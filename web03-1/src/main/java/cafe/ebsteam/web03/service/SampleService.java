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
		//sampleMapper내의 selectSampleList메서드를 호출하여 list로 받겠다.
		
		return list; 
		//list의 값을 리턴값으로 저장한다
	
	}
	
	public List<Sample> getSampleOne(int sampleId){
		
		List<Sample> list = sampleMapper.selectSampleOne(sampleId);
		//sampleMapper내의 selectSampleOne메서드에 매개변수 sampleId를 입력한 후 호출하여 list로 받겠다.
		
		return list;	
		//list의 값을 리턴값으로 저장한다
	}
	
	public int addSample(String sampleName){
		
		int result = sampleMapper.insertSample(sampleName);
		//sampleMapper내의 insertSample메서드에 매개변수 sampleName를 입력한 후 호출하여 int형으로 받겠다.
		
		System.out.println(result + " : 입력 결과는?");
		
		return result;
		//return을 실행 결과로 받아 실행 결과 값이 1이면 성공! 
	}
	
	public int removeSample(int sampleId){
		int result = sampleMapper.deleteSample(sampleId);
		//sampleMapper내의 deleteSample메서드에 매개변수 sampleId를 입력한 후 호출하여 int형으로 받겠다.
		
		System.out.println(result + " : 입력 결과는?");
		
		return result;
		//return을 실행 결과로 받아 실행 결과 값이 1이면 성공! 
		
	}
	public int modifiySample(int sampleId,String sampleName){
		int result = sampleMapper.updateSample(sampleId,sampleName);
		//sampleMapper내의 updateSample메서드에 매개변수 sampleId, sampleName을 입력한 후 호출하여 int형으로 받겠다.
		
		System.out.println(result + " : 입력 결과는?");
		
		return result;
		//return을 실행 결과로 받아 실행 결과 값이 1이면 성공! 
		
	}
}













