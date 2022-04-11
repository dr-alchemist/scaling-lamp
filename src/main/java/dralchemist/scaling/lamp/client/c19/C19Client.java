package dralchemist.scaling.lamp.client.c19;

import java.util.List;

import org.springframework.stereotype.Service;

import dralchemist.scaling.lamp.model.covid19tp.C19StateData;

@Service
public interface C19Client {
	
	public List<C19StateData> getCovid19TrackingProjectDataData() throws Exception;

}
