package com.skcc.backend.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skcc.backend.dao.MainDao;

@Service("mainService")
public class MainService {

	@Autowired
	MainDao mainDao;

	/**
	 * Sample List 조회
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getSamples() throws Exception {
		return mainDao.selectSamples();
	}

	/**
	 * Sample 생성
	 * @return
	 * @throws Exception
	 */
	public String createSample(Map<String, String> newSample) throws Exception {
		String resultMessage = "Fail!";
		int resultCount = mainDao.insertSample(newSample);
		if(resultCount > 0) {
			resultMessage = "Inserted!";
		}
		return resultMessage;
	}
	
	/**
	 * Sample 수정
	 * @param sampleKey
	 * @return
	 * @throws Exception
	 */
	public String modifySample(String sampleKey) throws Exception {
		String resultMessage = "Fail!";
		int resultCount = mainDao.updateSample(sampleKey);
		if(resultCount > 0) {
			resultMessage = "Updated!";
		}
		return resultMessage;
	}
	
	/**
	 * Sample 삭제
	 * @param sampleKey
	 * @return
	 * @throws Exception
	 */
	public String removeSample(String sampleKey) throws Exception {
		String resultMessage = "Fail!";
		int resultCount = mainDao.deleteSample(sampleKey);
		if(resultCount > 0) {
			resultMessage = "Deleted!";
		}
		return resultMessage;
	}	
}
