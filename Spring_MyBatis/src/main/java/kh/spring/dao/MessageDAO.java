package kh.spring.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.MessageDTO;
import kh.spring.dto.TempDTO;

@Repository//일반적으로 DAO는 componet어노테이션을 대체하는 기능으로서 repository로 이용
public class MessageDAO {
	@Autowired
	private SqlSessionTemplate  sst;
	
	
public int insert() {
	MessageDTO dto=new MessageDTO();
	dto.setName("test");
	dto.setMessage("hi");
	return sst.insert("messageDAO.insert",dto);
	}
public int delete() {
	return sst.delete("messageDAO.delete",1);
}
public List<MessageDTO> selectAll(){
	return sst.selectList("messageDAO.selectList"); //list로 뽑기
}

public TempDTO selectByseq() {
		return sst.selectOne("messageDAO.selectbyseq",5); //하나 select
}

public int update() {
	MessageDTO dto=new MessageDTO();
	dto.setSeq(3);
	dto.setName("s");
	return sst.update("messageDAO.update",dto);
}



}
