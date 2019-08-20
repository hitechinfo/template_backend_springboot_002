package com.skcc.backend.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skcc.backend.service.MainService;

@RestController
public class MainController {

	Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	MainService mainService;

	/**
	 * Sample List 조회
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/sample")
	public ResponseEntity<List<Map<String, Object>>> getSamples() throws Exception {
		return new ResponseEntity<List<Map<String, Object>>>(mainService.getSamples(), HttpStatus.OK);
	}

	/**
	 * Sample 생성
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/sample")
	public ResponseEntity<String> createSample(@RequestBody Map<String, String> newSample) throws Exception {
		
		if(newSample == null || newSample.get("sampleContents") == null || newSample.get("sampleContents").isEmpty()) {
			return new ResponseEntity<String>("SampleContents is required.", HttpStatus.BAD_REQUEST);
		}
		
		logger.info(newSample.get("sampleContents"));
		
		newSample.put("sampleOrder", "0");
		
		return new ResponseEntity<String>(mainService.createSample(newSample), HttpStatus.OK);
	}
	
	/**
	 * Sample 수정
	 * @param sampleKey
	 * @return
	 * @throws Exception
	 */
	@PutMapping("/sample/{sampleKey}")
	public ResponseEntity<String> modifySample(@PathVariable("sampleKey") String sampleKey) throws Exception {
		
		logger.info(sampleKey);

		if(sampleKey == null ||  sampleKey.isEmpty()) {
			return new ResponseEntity<String>("sampleKey is required.", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<String>(mainService.modifySample(sampleKey), HttpStatus.OK);
	}
	
	/**
	 * Sample 삭제
	 * @param sampleKey
	 * @return
	 * @throws Exception
	 */
	@DeleteMapping("/sample/{sampleKey}")
	public ResponseEntity<String> removeSample(@PathVariable("sampleKey") String sampleKey) throws Exception {
		logger.info(sampleKey);

		if(sampleKey == null ||  sampleKey.isEmpty()) {
			return new ResponseEntity<String>("sampleKey is required.", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<String>(mainService.removeSample(sampleKey), HttpStatus.OK);
	}
}
	