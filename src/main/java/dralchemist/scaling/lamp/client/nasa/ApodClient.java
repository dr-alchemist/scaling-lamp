package dralchemist.scaling.lamp.client.nasa;

import dralchemist.scaling.lamp.controller.NasaException;
import dralchemist.scaling.lamp.model.ApodModel;
import dralchemist.scaling.lamp.model.ApodRequest;

public interface ApodClient {

    public ApodModel getApodData(ApodRequest request) throws NasaException;
}
