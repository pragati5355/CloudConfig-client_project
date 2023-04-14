package com.cloudConfigueClient.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RefreshScope
public class CloudConfigueClientController extends BaseController{

	@Autowired
	@Lazy
	private RestTemplate template;
	
	@Value("${cloud.configue.url}")
	private String url;
	
	@GetMapping("/getList")
	public List<String> getList(){
		List<String> lists = template.getForObject(url, List.class);
		return lists;
	}
	
	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}
}
