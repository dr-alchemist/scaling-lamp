package dralchemist.scaling.lamp.client.nasa.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dralchemist.scaling.lamp.client.nasa.ApodClient;
import dralchemist.scaling.lamp.controller.NasaException;
import dralchemist.scaling.lamp.model.ApodModel;
import dralchemist.scaling.lamp.model.ApodRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class ApodClientImpl implements ApodClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApodClientImpl.class);

    @Value("${nasa.apikey}")
    protected String nasaApiKey;

    @Value("${nasa.apodurl}")
    protected String hostName;

    @Autowired
    protected RestTemplate restTemplate;

    protected String getBaseUrl() {
        return "https://" + hostName + "/";
    }

    @Override
    public ApodModel getApodData(ApodRequest request) throws NasaException {

        final String METHOD_NAME = "getNasaApodData";

        try {
            ApodModel response = new ApodModel();

            HttpEntity<?> httpEntity = new HttpEntity<>(new HttpHeaders());
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            params.add("api_key", nasaApiKey);


            if (request.isHd()) {
                params.add("hd", String.valueOf(request.isHd()));
            }

            if (null != request.getDate() && !request.getDate().isEmpty()) {
                params.add("date", request.getDate());
            }

            URI uri = UriComponentsBuilder.fromUriString(getBaseUrl()).path("apod").queryParams(params).build().toUri();
            LOGGER.info("URI******* {}", uri);

            // Call REST service
            ResponseEntity<String> responseEntity = restTemplate.exchange(uri.toString(), HttpMethod.GET, httpEntity,
                    String.class);

            response.setBalance(responseEntity.getHeaders().get("X-RateLimit-Remaining").get(0).toString());

            if ("200 ok".equalsIgnoreCase(String.valueOf(responseEntity.getStatusCode()))) {
                LOGGER.info("Method Name ***** {}", METHOD_NAME, "Scucess");
                ObjectMapper mapper = new ObjectMapper();
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                response = mapper.readValue(responseEntity.getBody(), ApodModel.class);
                LOGGER.info("Response from API ------ {} ", response.toString());
                return response;
            } else {
                throw new NasaException("Error while calling NASA" + responseEntity.getBody());
            }
        } catch (HttpStatusCodeException e) {
            throw new NasaException(e);
        } catch (Exception e) {
            throw new NasaException(e);
        }
    }

}
