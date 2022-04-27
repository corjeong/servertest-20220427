package product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("productservice")
public class ProductServiceImpl implements ProductService {
	@Autowired
	@Qualifier("productDAO")
	ProductDAO dao;
	
	@Override
	public List<ProductDTO> productlist() {
		return dao.productlist();
	}

	@Override
	public ProductDTO detailproduct(int productCode) {
		return dao.detailproduct(productCode);
	}

}
