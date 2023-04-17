package com.cloudConfigueClient.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudConfigueClient.web.model.ConfigurationModel;

@RefreshScope
@RestController
public class CloudConfigueClientController extends BaseController{
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ConfigurationModel configurationModel;

	
	/* Example one for the List */
	
//	@Autowired
//	@Lazy
//	private RestTemplate template;
//	
//	@Value("${cloud.configue.url}")
//	private String url;
//	
//	@GetMapping("/getList")
//	public List<String> getList(){
//		List<String> lists = template.getForObject(url, List.class);
//		return lists;
//	}
//	
//	@Bean
//	public RestTemplate template() {
//		return new RestTemplate();
//	}
	
//	 @GetMapping()
//	 public ResponseEntity<String> getMessage(Model model) {   
//		 	return new ResponseEntity<String>( environment.getProperty("welcome.message"), HttpStatus.OK);
//	 
//	 }
	
	/* Example second for the different properties dev/stage/prod */
	@GetMapping("/value")
	public String getValue() {
//		return environment.getProperty("spring.datasource.password");
		return environment.getProperty("application-dev.value");
//		return configurationModel.getValue();
	}
	
}
