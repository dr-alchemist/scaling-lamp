package dralchemist.scaling.lamp.exception;

import dralchemist.scaling.lamp.model.BaseRequest;
import dralchemist.scaling.lamp.client.ErrorResponse;

public class BaseException  extends Exception {

    private static final long serialVersionUID = 1l;
    private String className;
    private String methodName;
    private BaseRequest baseRequest;
    private ErrorResponse errorResponse;

}
