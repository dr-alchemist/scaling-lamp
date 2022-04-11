package dralchemist.scaling.lamp.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private String timeStamp = new Date().toString();

    private HttpStatus httpStatus;

    private String errorCode;
    private String errorMessage;

    private String requestURI;
    private String requestParams;


}
