package dralchemist.scaling.lamp.util;

import org.springframework.http.HttpStatus;

public class CommonUtil {

    public static boolean isError(HttpStatus status) {
        HttpStatus.Series series = status.series();
        return (HttpStatus.Series.CLIENT_ERROR.equals(series) || HttpStatus.Series.SERVER_ERROR.equals(series));
    }

}
