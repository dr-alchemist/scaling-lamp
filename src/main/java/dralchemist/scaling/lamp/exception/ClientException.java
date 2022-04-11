package dralchemist.scaling.lamp.exception;

import dralchemist.scaling.lamp.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

public class ClientException  implements ResponseErrorHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientException.class);

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return CommonUtil.isError(response.getStatusCode());
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        LOGGER.error("NASA client response error: {}, response text: {}", response.getStatusCode(), response.getStatusText());
    }

}
