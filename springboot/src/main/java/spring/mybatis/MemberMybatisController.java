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
	
	//����ȭ��
	@RequestMapping("/membermybatisstart")
	public ModelAndView memberstart() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	
	//service memberlist �޼ҵ� ��üȸ�� ��ȸ ��� ��, mybatis/memberlist.jsp ��� ����
	@RequestMapping("/membermybatislist")
	public ModelAndView memberlist() {
		ModelAndView mv = new ModelAndView();
		List<MemberDTO> list = service.memberlist();
		mv.addObject("memberlist", list);
		mv.setViewName("mybatis/memberlist");
		return mv;
	}
	
	//service paginglist �޼ҵ� ����¡ ó�� ��ȸ ��, mybatis/memberlist.jsp ��� ����
	// /membermybatispaginglist?page=x
	@RequestMapping("/membermybatispaginglist")
	public ModelAndView memberlist(int page) {
		ModelAndView mv = new ModelAndView();
		List<MemberDTO> list = service.memberlist(page);
		mv.addObject("memberlist", list);
		mv.addObject("name", "����¡ó������Ʈ");
		mv.setViewName("mybatis/memberlist");
		return mv;
	}
	
	//service addresssearch �޼ҵ� �ش� �ּ� ��� ȸ�� ���� �� mybatis/memberlist.jsp ��� ����
	//  /membermybatissearchlist?address=����&address=����	&address=����
	@RequestMapping("/membermybatissearchlist")
	public ModelAndView memberlist(String address[]) {
		ModelAndView mv = new ModelAndView();
		List<String> list = service.memberlist(address);
		mv.addObject("memberaddresslist", list);
		mv.addObject("name", "�ּ� �˻� ����Ʈ");
		mv.setViewName("mybatis/memberlist");
		return mv;		
	}
	
	//service insert ȣ�� �� ����, ȸ�� ���� �Է� �� ��
	@GetMapping("/membermybatisinsert")
	public String insertform() {
		return "mybatis/insertform";
	}
	//insert ��� �� ���� ��
	@PostMapping("/membermybatisinsert")
	public ModelAndView insertresult(MemberDTO dto) {
		ModelAndView mv = new ModelAndView();
		int insertresult = service.insertmember(dto);
		mv.addObject("insertresult", insertresult);
		mv.setViewName("mybatis/insertresult");
		return mv;	
	}
	
	//service update ȣ�� �� ����, ȸ������ ������ ��
	// /membermybatisupdate?id=xxxx
	@GetMapping("/membermybatisupdate")
	public String updateform(String id) {
		return "mybatis/updateform";
	}
	//update ��� �� ���� ��
	@PostMapping("/membermybatisupdate")
	public ModelAndView updateresult(MemberDTO dto) { //id(����), name, address �Է�
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
			return "redirect:/membermybatislist"; //��Ʈ�ѷ� uri ���θ޼ҵ�ȣ��(ȸ������Ʈ)
		}
		return "redirect:/membermybatisinsert"; //��Ʈ�ѷ� uri ���θ޼ҵ�ȣ��(ȸ������)
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
