package spring.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper //마이바티스 sql실행(id, resulttype, parameter타입)
@Repository("mybatisdao")
public interface MemberDAO {
	public int insertmember(MemberDTO dto);
	public int updatemember(MemberDTO dto);
	public int deletemember(String id);
	public List<MemberDTO> memberlist();
	public List<MemberDTO> paginglist(int[] limit);
	public List<String> addresssearch(String[] address);
	public MemberDTO member(String id);
}
