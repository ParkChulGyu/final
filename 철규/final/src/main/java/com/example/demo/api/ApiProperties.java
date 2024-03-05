package com.example.demo.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class ApiProperties {

	// flask
	private final String flask_api_url = "http://127.0.0.1:5000";

	// api url
	private final String  kapp_api_url= "http://apis.data.go.kr/B551011/KorService1";

	// pcg key
	private final String  pcg_service_key="lqQazXlaDVBCC6RSW8rmSCPJnO4%2B6MDm4V4e15lOP5z8TonUtOFvQJd5sW9qL1j4%2FPezxtDigZOOtR4lZbgcvg%3D%3D";

}
