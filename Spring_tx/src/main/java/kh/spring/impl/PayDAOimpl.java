package kh.spring.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import kh.spring.dao.PayDAO;
import spring.kh.dto.PayDTO;

@Component
public class PayDAOimpl implements PayDAO{
@Autowired
private JdbcTemplate template;

	/*public int InsertPay(Connection con,PayDTO dto)throws Exception {
		String sql="insert into pay values(payseq.nextval,?,?)";
		try(
				PreparedStatement pstat=con.prepareStatement(sql);
				)
		{pstat.setString(1, dto.getPid());
			pstat.setString(2, dto.getPname());
				int result=pstat.executeUpdate();
				
				return result;
				}
					
	}*/

public int insert(PayDTO dto)throws Exception
{	String sql="insert into pay values(payseq.nextval,?,?)";
int result=template.update(sql, dto.getPid(),dto.getPname());
return result;
	
}

}
