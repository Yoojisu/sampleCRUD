package cafe.ebsteam.web03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe.ebsteam.web03.mapper.SampleMapper;
import cafe.ebsteam.web03.vo.Sample;
//빈의 역할 dao
@Service
public class SampleService {
	//@와 코드 사이에 주석 달지 않기!
   
	@Autowired private SampleMapper sampleMapper;
	private Sample sample;
	
	public List<Sample> getSampleList(){
		
		List<Sample> list = sampleMapper.selectSampleList();
		return list; 
	
		//인터페이스에 작성해서 리턴값 받기
	}
	
	public Sample getSampleOne(){
		 return null;
		
	}
	
	public int addSample(String sampleName){
		int result = sampleMapper.insertSample(sampleName);
		System.out.println(result + " : 입력 결과는?");
		//return을 받아야하나? 아니요
		return result;
	}
	
	public int removeSample(Sample sample){
		return 0;
		
	}
	public int modifiySample(Sample sample){
		return 0;
		
	}
}













