package dralchemist.scaling.lamp.service;

import dralchemist.scaling.lamp.model.ApodModel;
import dralchemist.scaling.lamp.model.ApodRequest;
import org.springframework.stereotype.Service;

@Service
public interface NasaService {

    public ApodModel getApodDataResponse(ApodRequest request) throws Exception;

}
