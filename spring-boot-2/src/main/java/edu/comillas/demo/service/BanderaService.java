package edu.comillas.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.comillas.demo.model.BanderaSearchModel;
import java.util.List;
@Service
public class BanderaService {
	//url tiene el valor de la url de bandera.url que se define en application.properties
	@Value("${bandera.url}")
	private String url;
	@Value("${bandera.url}")
	private String url2;

	public List<BanderaSearchModel> getBanderas(String busqueda) {
		final RestTemplate template = new RestTemplate();
		final String urlFinal = url+busqueda;
		System.out.print(urlFinal);
		final HttpMethod method = HttpMethod.GET;
		ResponseEntity<List<BanderaSearchModel>> response = template.exchange(urlFinal, method, null, new ParameterizedTypeReference<List<BanderaSearchModel>>(){});

		return  response.getBody();
	}
	
	public BanderaSearchModel getBandera(String nombre) {
		final RestTemplate template = new RestTemplate();
		final String urlFinal = url2+nombre;
		System.out.print(urlFinal);
		final HttpMethod method = HttpMethod.GET;
		ResponseEntity<BanderaSearchModel> response = template.exchange(urlFinal, method, null, BanderaSearchModel.class);

		return  response.getBody();
	}
}