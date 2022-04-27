package product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
	
	@Autowired
	@Qualifier("productservice")
	ProductService service;
	
	@RequestMapping("/productlist")
	public ModelAndView productlist() {
		ModelAndView mv = new ModelAndView();
		List<ProductDTO> list = service.productlist();
		mv.addObject("list", list);
		mv.setViewName("mybatis/productlist");
		return mv;
	}
	
	@RequestMapping("/product")
	public ModelAndView detailproduct(int code) {
		ModelAndView mv = new ModelAndView();
		ProductDTO dto = service.detailproduct(code);
		mv.addObject("dto", dto);
		mv.setViewName("mybatis/detailproduct");
		return mv;
	}
	
	//ajax
/*	@ResponseBody
	@RequestMapping(value="/product", produces = {"application/json;charset=utf-8"})
	public ProductDTO detailproduct(int code){
		ProductDTO dto = service.detailproduct(code);
		return dto;
	}
*/	
}
