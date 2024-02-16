package com.example.demo.api.controller;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.answer.AnswerForm;
import com.example.demo.api.ApiProperties;
import com.example.demo.api.model.TourService;
import com.example.demo.api.model.TouristDTO;
import com.example.demo.api.model.WeatherService;
import com.example.demo.user.SiteUser;
import com.example.demo.user.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.api.model.GpsTransfer;
import com.example.demo.api.model.TourDetailDTO;


@RequiredArgsConstructor
@Controller
@RequestMapping("/api")
public class FlaskController {

	@Autowired
	TourService t_service = new TourService();
	
	@Autowired
	WeatherService w_service = new WeatherService();
	
	@Autowired
	GpsTransfer gpsTransfer=new GpsTransfer();

	@GetMapping("/flask")
	public String displayPage(Model model) {
		return "flask/flask_Page";
	}
	
	@GetMapping("/data_chart")
	public String datadisplayPage(Model model) {
		return "flask/data_chart";
	}

	@GetMapping("/kapp")
	public String kappPageEndpoint(Model model) {

		List<TouristDTO> touristDTOList = t_service.fetchDataFromExternalAPI();

		model.addAttribute("touristDTOList", touristDTOList);

		return "apiapp/kapp_Page";
	}

	@PostMapping("/kapp")
	public String handleFormSubmit(Model model) {

		return "apiapp/kapp_Page";
	}
	
	@GetMapping("/tourdetail")
	public String apidetail(Model model , @RequestParam(name = "contentid") String contentid) throws Exception {
		//System.out.println("contentid = "+contentid);
		Map<String, Object> map = new HashMap<>();
		map.put("contentid",contentid);
		Map<String, Object> tourDetailDTO = new HashMap<>();
		tourDetailDTO =	t_service.fetchDataFromExternalAPIdetail(map);
		//System.out.println("tourDetailDTO::"+tourDetailDTO);
		TourDetailDTO x =  (TourDetailDTO) tourDetailDTO.get("tourDetailDTO");
		
		
		gpsTransfer.setLon(Double.parseDouble(x.getMapx()));
		gpsTransfer.setLat(Double.parseDouble(x.getMapy()));
		gpsTransfer.transfer(gpsTransfer, 0);
		//System.out.println("gpsTransfer::"+gpsTransfer);
		map.put("gpsTransfer", gpsTransfer);
		Map<String, Object> weatherTMPDTOList = new HashMap<>();
		weatherTMPDTOList = w_service.fetchDataFromExternalAPIweather(map);
		
		System.out.println(weatherTMPDTOList.get("weatherTMPDTOList"));
		
		model.addAttribute(tourDetailDTO.get("tourDetailDTO"));
		model.addAttribute(weatherTMPDTOList.get("weatherTMPDTOList"));
		
		return "apiapp/tour_detail";
	}

}
