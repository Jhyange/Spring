package kh.spring.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import kh.spring.dao.SellerDAO;
import spring.kh.dto.PayDTO;
import spring.kh.dto.SellerDTO;

@Component
public class SellerDAOimpl implements SellerDAO {
	@Autowired
	private JdbcTemplate template;

	/*public int InsertSeller(Connection con,SellerDTO dto)throws Exception  {
		String sql="insert into seller values(sellerseq.nextval,?,?)";
		try(
				PreparedStatement pstat=con.prepareStatement(sql);
				)
		{pstat.setString(1, dto.getBid());
			pstat.setString(2, dto.getPid());
				int result=pstat.executeUpdate();
			
				return result;
				}
					
	}*/
	public int InsertSeller(SellerDTO dto)throws Exception
	{	String sql="insert into seller values(sellerseq.nextval,?,?)";
	int result=template.update(sql, dto.getBid(),dto.getPid());
	return result;
		
	}


}
