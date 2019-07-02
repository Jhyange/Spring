package kh.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kh.spring.dto.MessageDTO;

@Component
public class MessageDAO {
@Autowired
private DataSource ds;

public int Insert(MessageDTO dto) {
	String sql="insert into message values(message_seq.nextval,?,?)";
	try( 
		Connection con = ds.getConnection();
		 PreparedStatement pst=con.prepareStatement(sql);
			)
	{
		pst.setString(1, dto.getName());
		pst.setString(2, dto.getMsg());
		int result=pst.executeUpdate();
		con.commit();
		return result;
	} catch (SQLException e) {
			e.printStackTrace();
	}
	return 0;
		
}

public List select() throws Exception{
	
	String sql="select* from message";
	try(Connection con=ds.getConnection();
	PreparedStatement pst=con.prepareStatement(sql);
		){
	ResultSet rs=pst.executeQuery();
	List<MessageDTO> result=new ArrayList<>();
	while(rs.next())
	{
		MessageDTO dto=new MessageDTO();
		dto.setSeq(rs.getInt("seq"));
		dto.setName(rs.getString("name"));
		dto.setMsg(rs.getString("message"));
		result.add(dto);
	}
	return result;
	}

}

}
