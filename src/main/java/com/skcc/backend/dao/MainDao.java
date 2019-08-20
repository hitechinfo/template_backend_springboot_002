package com.skcc.backend.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("mainDao")
public class MainDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	/**
	 * Sample List 조회
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectSamples() throws Exception {
		return sqlSessionTemplate.selectList("sample.selectSampleList");
	}
	
	/**
	 * Sample 생성
	 * @param newSample
	 * @return
	 * @throws Exception
	 */
	public int insertSample(Map<String, String> newSample) throws Exception {
		return sqlSessionTemplate.insert("sample.insertSample", newSample);
	}
	
	/**
	 * Sample 수정
	 * @param sampleKey
	 * @return
	 * @throws Exception
	 */
	public int updateSample(String sampleKey) throws Exception {
		return sqlSessionTemplate.update("sample.updateSample", sampleKey);
	}
	
	/**
	 * Sample 삭제
	 * @param sampleKey
	 * @return
	 * @throws Exception
	 */
	public int deleteSample(String sampleKey) throws Exception {
		return sqlSessionTemplate.delete("sample.deleteSample", sampleKey);
	}
}