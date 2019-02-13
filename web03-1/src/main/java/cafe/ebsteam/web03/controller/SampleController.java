package cafe.ebsteam.web03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import cafe.ebsteam.web03.mapper.SampleMapper;
import cafe.ebsteam.web03.service.SampleService;
import cafe.ebsteam.web03.vo.Sample;

@Controller
public class SampleController {
	@Autowired private SampleService sampleService;
	@Autowired private Sample sample;
	//@Autowired private SampleMapper sampleMapper;

	//1.입력 폼
	@GetMapping("/addSample")
	public String addSample() {
		System.out.println("입력 폼 실행");
		return "addSample"; 
		//view 이름은 templeate 폴더에 addSample.html로 된다.
		//view이름을 리턴 받기 위해 String으로 선언하고 리턴에 view명을 적는다.
	}
	
	//2.입력 액션
	//post방식으로 mapping한다는 뜻
	@PostMapping("/addSample")
	public String addSample(@RequestParam(value="sampleName")String sampleName) {
		//Spring mvc는 sampleName의 값이 null인데 입력값으로 채우겠다는 뜻
		System.out.println("입력 액션 실행");
		
		sampleService.addSample(sampleName);
		//SampleService.java내의 addSample메서드 sampleName을 매개변수로 받아 호출한다.
		
		return "redirect:/sampleList";
		//경로를 sampleList로 다시 요청하기 위해 리다이렉트 함!
		
	}
	
	//3.목록
	@GetMapping("/sampleList")
	public String sampleList(Model model) {
		System.out.println("리스트 출력");
		
		List<Sample> list =  sampleService.getSampleList();
		//SampleService.java내의 getSampleList메서드를 호출하여 리턴값을 list로 받겠다.
		
		model.addAttribute("list", list);
		//입력된 값을 담아야 하기 때문에 Model이 필요 (setAttribute)
		//list에 저장된 값을 변수 "list"에 저장한다.
		
		return "sampleList";
		//view이름을 리턴 받기 위해 String으로 선언하고 리턴에 view명을 적는다.
	}
	
	
	//4.삭제 액션
	@GetMapping("/removeSample")
	public String removeSample(@RequestParam(value="sampleId")int sampleId) {
		System.out.println("삭제 액션 실행");
		//화면에서 입력받은 sampleId 값을 매개변수로 받겠다.
		
		sampleService.removeSample(sampleId);
		//SampleService.java내의 removeSample메서드에 sampleId를 매개변수로 받아 호출한다.
		
		return "redirect:/sampleList";
		//경로를 sampleList로 다시 요청하기 위해 리다이렉트 함!
	}
	
	
	
	//5.수정 폼
	@GetMapping("/modifiySample")
	public String getSampleOne(Model model, @RequestParam(value="sampleId")int sampleId) {
		//화면에서 입력받은 sampleId 값을 매개변수로 받겠다.
		System.out.println("수정 폼 실행");
		
		List<Sample> list = sampleService.getSampleOne(sampleId);
		//SampleService.java내의 getSampleOne메서드에 sampleId를 매개변수로 받아 호출하여 리턴값을 list로 받겠다.
		
		model.addAttribute("list_one", list);
		//list에 저장된 값을 변수 "list_one"에 저장한다.
	
		return "modifiySample";
		//view이름을 리턴 받기 위해 String으로 선언하고 리턴에 view명을 적는다.
		
	}
	
	//6.수정 액션
	@PostMapping("/modifiySample")
	public String modifiySample(@RequestParam(value="sampleId")int sampleId,@RequestParam(value="sampleName")String sampleName) {
		//화면에서 입력받은 sampleId, sampleName 값을 매개변수로 받겠다.
		System.out.println("수정 액션 실행");
		//화면에서 입력받은 sampleName 값을 매개변수로 받겠다.
		
		sampleService.modifiySample(sampleId,sampleName);
		//SampleService.java내의 modifiySample메서드에 sampleId,sampleName를 매개변수로 받아 호출한다.
		
		return "redirect:/sampleList";
		//경로를 sampleList로 다시 요청하기 위해 리다이렉트 함!
		
	}
	
	
	
}
