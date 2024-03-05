package com.example.demo.api.flask;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;



@Service
@Transactional(readOnly = true)
public class FlaskService {

    @Value("${flask.api.url}")
    private String flaskApiUrl;
    
    @Value("${kapp.api-url}")
    private String apiurl;
    
    @Value("${pcg.service-key}")
    private String servicekey;

    public String fetchDataFromFlaskApi() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(flaskApiUrl, String.class);
    }
    
    
    
}
