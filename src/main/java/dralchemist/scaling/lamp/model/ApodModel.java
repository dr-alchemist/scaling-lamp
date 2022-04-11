package dralchemist.scaling.lamp.model;

import lombok.Data;

@Data
//@JsonIgnoreProperties(ignoreUnknown = true)
public class ApodModel {

    String date;
    String explanation;
    String hdurl;
    String media_type;
    String service_version;
    String title;
    String url;
    String copyright;

    String balance;

}
