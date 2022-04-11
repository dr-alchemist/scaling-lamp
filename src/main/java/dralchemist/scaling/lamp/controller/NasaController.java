package dralchemist.scaling.lamp.controller;

import dralchemist.scaling.lamp.client.c19.C19Client;
import dralchemist.scaling.lamp.client.nasa.ApodClient;
import dralchemist.scaling.lamp.model.ApodModel;
import dralchemist.scaling.lamp.model.ApodRequest;
import dralchemist.scaling.lamp.model.covid19tp.C19StateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class NasaController {

    @Value("${nasa.apodurl}")
    private String nasaApodUrl;

    @Autowired
    private ApodClient client;

    @Autowired
    private C19Client c19Client;

    static final String METHOD_NAME = "getApodHDPic";

    @GetMapping("/astronomy/apod/day/")
    @ResponseBody
    public ApodModel getApodHDPic(@RequestParam(required = false) boolean isHd, @RequestParam(required = false) String date) throws NasaException {

        ApodRequest request = new ApodRequest();
        request.setHd(isHd);
        request.setDate(date);
        return client.getApodData(request);

    }

    @GetMapping("/covid/data/")
    @ResponseBody
    public List<C19StateData> getCoviddata() throws Exception {
        System.out.println(c19Client.getCovid19TrackingProjectDataData().size());
        return c19Client.getCovid19TrackingProjectDataData();

    }

}
