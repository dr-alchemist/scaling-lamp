package dralchemist.scaling.lamp.client.c19.impl;

import dralchemist.scaling.lamp.client.c19.C19Client;
import dralchemist.scaling.lamp.model.covid19tp.C19StateData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class C19ClientImpl implements C19Client {

    private static final Logger LOGGER = LoggerFactory.getLogger(C19ClientImpl.class);

    @Autowired
    protected RestTemplate restTemplate;

    protected String getBaseUrl() {
        return "https://api.covidtracking.com/";
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<C19StateData> getCovid19TrackingProjectDataData() throws Exception {
        List<C19StateData> result;

        final String METHOD_NAME = "getCovidData";

        try {
            List<C19StateData> response = new ArrayList<C19StateData>();

            HttpEntity<?> httpEntity = new HttpEntity<>(new HttpHeaders());

			//URI uri = UriComponentsBuilder.fromUriString(getBaseUrl()).path("v1/states/current.json").build().toUri();
            URI uri = UriComponentsBuilder.fromUriString(getBaseUrl()).path("v1/states/ca/daily.json").build().toUri();
            LOGGER.info("URI******* {}", uri);

            // Call REST service
            ResponseEntity<String> responseEntity = restTemplate.exchange(uri.toString(), HttpMethod.GET, httpEntity,
                    String.class);

            if ("200 ok".equalsIgnoreCase(String.valueOf(responseEntity.getStatusCode()))) {
                LOGGER.info("Method Name ***** {}", METHOD_NAME, "Scucess");
                LOGGER.info("Response from API ------ {} ", response.toString());
                result = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<C19StateData>>() {
                }).getBody();
            } else {
                throw new Exception("Error while calling COVID TRACKING PROJECT " + responseEntity.getBody());
            }
        } catch (HttpStatusCodeException e) {
            throw new Exception(e);
        } catch (Exception e) {
            throw new Exception(e);
        }

        return result;
    }

}
