package com.gg.dls.service.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gg.dls.service.authentication.message.response.RecommendationResponse;

import io.jsonwebtoken.Jwts;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/rec")
public class RecRestAPIs {

	@Value("${gg.app.jwtSecret}")
	private String jwtSecret;

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	@LoadBalanced
	private RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@LoadBalanced
	@GetMapping("/recommend")
	public RecommendationResponse getRecommendation(@RequestHeader("Authorization") String authTokenArg) {
		// Extract the JWT from the Authorization-header
		String authToken = authTokenArg.substring(authTokenArg.indexOf(" ") + 1);
		Long userId;

		// Validate the JWT and extract the userId for use in the next step.
		// (.parseclaimsJws() will throw errors in case of an invalid token.)
		userId = Long.parseLong((String)Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken).getBody().get("sub"));
		
		// Forward the request to a running a running and Eureka-registered instance of
		// the recommendation-service, using its spring.application.name for Eureka
		// service discovery.
		// Apart from a URL, the RestTemplate needs a class that has properties/fields
		// that correspond with the json-object received from the recommendation service
		// response body.
		RecommendationResponse recResponse = restTemplate
				.getForObject("http://recommendation-service/recommend/" + userId, RecommendationResponse.class);

		return recResponse;
	}
}
