package kh.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import kh.spring.dto.MessageDTO;
@Component
public class MessageDAO2 {

	@Autowired
	private JdbcTemplate template;
	public int insert(MessageDTO dto){
		String sql="insert into message values(message_seq.nextval,?,?)";
		int result=template.update(sql, dto.getName(),dto.getMsg());
		return result;
	}
public List<MessageDTO> selectAll(){
	String sql="select * from message";
	return template.query(sql,new RowMapper<MessageDTO>() {
		//rowmapper가  텅 비어있는 추상매서드여서 instance로 생성하지 못하여 오류 발생
		//인터페이스는 abstract를 가진 추상클레스와 같다 
		//추상매서드 해결방법 2가지 : 익명인스턴스화 시켜 비어있는 추상매서드의 내용을 채워준다 (callback),implement를 하여 class를 하는 방법은 번거러움 
		//queryforobject는 한번만 돌려 사용한다 
		//query는 while문으로 작동하게된다
		
		@Override
		public MessageDTO mapRow(ResultSet rs, int rn/*rownumber*/) throws SQLException {
			MessageDTO dto=new MessageDTO();
			dto.setSeq(rs.getInt(1));
			dto.setName(rs.getString(2));
			dto.setMsg(rs.getString(3));
			return dto;
		} //rowmapper가 dto형으로 만든다고 설정하면 next하면서 스스로 dto형으로 만든다 

	});
	
}

}
