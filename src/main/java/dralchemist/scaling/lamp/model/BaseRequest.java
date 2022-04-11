package dralchemist.scaling.lamp.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Required;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
public class BaseRequest implements Serializable {

  /*  private static final long serialVersionUID = 1L;

    @NotNull
    @NotBlank
    @Pattern(regexp = "[A-Z]{3}")
    private String sysId;

    @NotNull
    @NotBlank
    @Pattern(regexp = "[a-zA-Z]{1,6}")
    private String appName;

    @NotNull
    @NotBlank
    private String userName;

//    public BaseRequest() {}

//    public BaseRequest(@NotNull @NotBlank @Pattern(regexp = "[A-Z]{3}") String sysId, @NotNull @NotBlank @Pattern(regexp = "[a-zA-Z]{1,6}") String appName, @NotNull @NotBlank String userName) {
//        this.sysId = sysId;
//        this.appName = appName;
//        this.userName = userName;
//    }*/

}
