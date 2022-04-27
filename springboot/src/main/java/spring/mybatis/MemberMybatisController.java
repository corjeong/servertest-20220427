package spring.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberMybatisController {
	@Autowired
	@Qualifier("mybatisservice")
	MemberService service;
	
	//시작화면
	@RequestMapping("/membermybatisstart")
	public ModelAndView memberstart() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	
	//service memberlist 메소드 전체회원 조회 결과 모델, mybatis/memberlist.jsp 뷰로 전송
	@RequestMapping("/membermybatislist")
	public ModelAndView memberlist() {
		ModelAndView mv = new ModelAndView();
		List<MemberDTO> list = service.memberlist();
		mv.addObject("memberlist", list);
		mv.setViewName("mybatis/memberlist");
		return mv;
	}
	
	//service paginglist 메소드 페이징 처리 조회 모델, mybatis/memberlist.jsp 뷰로 전송
	// /membermybatispaginglist?page=x
	@RequestMapping("/membermybatispaginglist")
	public ModelAndView memberlist(int page) {
		ModelAndView mv = new ModelAndView();
		List<MemberDTO> list = service.memberlist(page);
		mv.addObject("memberlist", list);
		mv.addObject("name", "페이징처리리스트");
		mv.setViewName("mybatis/memberlist");
		return mv;
	}
	
	//service addresssearch 메소드 해당 주소 사는 회원 정보 모델 mybatis/memberlist.jsp 뷰로 전송
	//  /membermybatissearchlist?address=서울&address=대전	&address=제주
	@RequestMapping("/membermybatissearchlist")
	public ModelAndView memberlist(String address[]) {
		ModelAndView mv = new ModelAndView();
		List<String> list = service.memberlist(address);
		mv.addObject("memberaddresslist", list);
		mv.addObject("name", "주소 검색 리스트");
		mv.setViewName("mybatis/memberlist");
		return mv;		
	}
	
	//service insert 호출 모델 없다, 회원 가입 입력 폼 뷰
	@GetMapping("/membermybatisinsert")
	public String insertform() {
		return "mybatis/insertform";
	}
	//insert 결과 행 리턴 모델
	@PostMapping("/membermybatisinsert")
	public ModelAndView insertresult(MemberDTO dto) {
		ModelAndView mv = new ModelAndView();
		int insertresult = service.insertmember(dto);
		mv.addObject("insertresult", insertresult);
		mv.setViewName("mybatis/insertresult");
		return mv;	
	}
	
	//service update 호출 모델 없다, 회원정보 수정폼 뷰
	// /membermybatisupdate?id=xxxx
	@GetMapping("/membermybatisupdate")
	public String updateform(String id) {
		return "mybatis/updateform";
	}
	//update 결과 행 리턴 모델
	@PostMapping("/membermybatisupdate")
	public ModelAndView updateresult(MemberDTO dto) { //id(고정), name, address 입력
		ModelAndView mv = new ModelAndView();
		int updateresult = service.updatemember(dto);
		mv.addObject("updateresult", updateresult);
		mv.setViewName("mybatis/updateresult");
		return mv;	
	}
	
	//delete
	// /membermybatisdelete?id=xxx
	@RequestMapping("/membermybatisdelete")
	public String deleteresult(String id) {
		int deleteresult = service.deletemember(id);
		if(deleteresult == 1) {
			return "redirect:/membermybatislist"; //컨트롤러 uri 매핑메소드호출(회원리스트)
		}
		return "redirect:/membermybatisinsert"; //컨트롤러 uri 매핑메소드호출(회원가입)
	}
/*	public ModelAndView deleteresult(String id) {
		ModelAndView mv = new ModelAndView();
		int deleteresult = service.deletemember(id);
		List<MemberDTO> list = null;
		if(deleteresult == 1) {
			list = service.memberlist();
		}
		mv.addObject("memberlist", list);
		mv.setViewName("mybatis/memberlist");
		return mv;
	}
	*/
}
