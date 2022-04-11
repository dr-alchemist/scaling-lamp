package dralchemist.scaling.lamp.client;


import dralchemist.scaling.lamp.exception.ClientException;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public abstract class BaseClient {

    public static final String START_LIT = "\t **** START ****";
    public static final String END_LIT = "\t **** END ****";
    public static final int CONNECTION_TIMEOUT = 5000;
    public static final int READ_TIMEOUT = 300000;

    protected RestTemplate restTemplate;

    protected String baseUrl;

    public BaseClient() {
        super();
        setRestTemplate();
    }

    public BaseClient(RestTemplate restTemplate, String baseUrl) {
        setRestTemplate();
        this.baseUrl = baseUrl;
    }

    protected void setRestTemplate() {
        restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(getRequestFactory());
//        restTemplate.setInterceptors(getInterceptors());;
        restTemplate.setErrorHandler(new ClientException());
    }

    //Not Required
    /*protected List<ClientHttpRequestInterceptor> getInterceptors() {
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        // interceptors.add(new StatsI)
        return interceptors;
    }*/

    protected HttpComponentsClientHttpRequestFactory getRequestFactory() {
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setConnectTimeout(CONNECTION_TIMEOUT);
        requestFactory.setReadTimeout(READ_TIMEOUT);
//        requestFactory.setHttpClient(HttpClientBuilder.create().disableCookieManagement().build());
        return requestFactory;
    }

//    protected HttpHeaders getHttpHeaders(String authCookie) {
//        HttpHeaders httpHeaders = new HttpHeaders();
//
//        if (authCookie != null){
//            httpHeaders.add("Cookie", authCookie);
//        }
//        return httpHeaders;
//    }

    protected boolean isRequestSuccessful(HttpStatus status) {
        HttpStatus.Series series = status.series();
        return !(HttpStatus.Series.CLIENT_ERROR.equals(series) || HttpStatus.Series.SERVER_ERROR.equals(series));
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

}



