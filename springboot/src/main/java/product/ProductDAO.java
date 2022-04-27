package product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("productDAO")
public interface ProductDAO {
	public List<ProductDTO> productlist();
	public ProductDTO detailproduct(int productCode);
}
