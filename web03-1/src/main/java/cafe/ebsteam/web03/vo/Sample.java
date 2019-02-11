package cafe.ebsteam.web03.vo;

import org.springframework.stereotype.Component;

@Component
public class Sample {
	//주석, 커밋메세지가 제일 중요!
	private int sampleId; //sample.sample_id
	private String sampleName; //sample.sampe_name
	

	public int getSampleId() {
		return sampleId;
	}


	public void setSampleId(int sampleId) {
		this.sampleId = sampleId;
	}


	public String getSampleName() {
		return sampleName;
	}


	public void setSampleName(String sampleName) {
		this.sampleName = sampleName;
	}


	@Override
	public String toString() {
		return "Sample [sampleId=" + sampleId + ", sampleName=" + sampleName + "]";
	}
	
}
