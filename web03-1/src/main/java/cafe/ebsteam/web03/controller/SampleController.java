package cafe.ebsteam.web03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cafe.ebsteam.web03.service.SampleService;

@Controller
public class SampleController {
	@Autowired private SampleService sampleservice;

	//1.입력 폼
	@GetMapping
	public String addSample() {
		return "addSample"; //view 이름은 templeate 폴더에 addSample.html로 된다.
		//view이름을 리턴 받기 위해 String으로 선언하고 리턴값에 view이름을 적는다.
	}
	
	//2.입력 액션
	//post방식으로 mapping한다는 뜻
	@PostMapping
	public String addSample(@RequestParam(value="sampleName")String sampleName) {
		//Spring mvc는 sampleName의 값이 null인데 입력값으로 채우겠다는 뜻
		return "redirect:/sampleList";
		//redirect로 시작하지 않으면 view로 포워딩 하게 되어있음.
		
	}
	
	//3.목록
	@GetMapping("/sampleList")
	public String sampleList(Model model) {
		//입력된 값을 담아야 하기 때문에 Model이 필요 (setAttribute)
		return "sampleList";
	}
	
	
	//4.삭제 액션
	//@PostMapping
	
	
	//5.수정 폼
	
	//6.수정 액션
	
	
}
