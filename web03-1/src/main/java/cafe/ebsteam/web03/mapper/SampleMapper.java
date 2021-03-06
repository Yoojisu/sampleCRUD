package cafe.ebsteam.web03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cafe.ebsteam.web03.vo.Sample;
//다른 @사용하능하지만 선생님 시간에는 잘 따라하자!
@Mapper
public interface SampleMapper {
	
	//추상메서드들..!
	List<Sample> selectSampleList();
	List<Sample> selectSampleOne(int sampleId);
	int insertSample(String sampleName);
	int deleteSample(int sampleId);
	int updateSample(int sampleId, String sampleName);	
}
