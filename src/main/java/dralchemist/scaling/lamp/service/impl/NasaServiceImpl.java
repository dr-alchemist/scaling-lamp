package dralchemist.scaling.lamp.service.impl;

import dralchemist.scaling.lamp.client.nasa.ApodClient;
import dralchemist.scaling.lamp.model.ApodModel;
import dralchemist.scaling.lamp.model.ApodRequest;
import dralchemist.scaling.lamp.service.NasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NasaServiceImpl implements NasaService {

    @Autowired
    private ApodClient client;

    @Override
    public ApodModel getApodDataResponse(ApodRequest request) throws Exception {

        ApodModel response = new ApodModel();

        try {
            if (request.isHd()) {
                ApodModel responModel =  client.getApodData(request);
                return responModel;
            }
//            response.setCopyright();
        } catch (Exception e) {
            throw new Exception(e);
        }
        return response;
    }
}
