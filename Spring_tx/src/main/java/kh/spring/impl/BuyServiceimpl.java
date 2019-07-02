package kh.spring.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import kh.spring.dao.PayDAO;
import kh.spring.dao.SellerDAO;
import kh.spring.service.BuyService;
import spring.kh.dto.PayDTO;
import spring.kh.dto.SellerDTO;
@Component
public class BuyServiceimpl implements BuyService {
	@Autowired 
	private PayDAO pdao;
	@Autowired
	private SellerDAO sdao;
	/*@Autowired
	private DataSource ds;
	*/
	@Transactional("txManager")
	public void Buy(PayDTO dto)throws Exception
	{
		pdao.insert(dto);
		sdao.InsertSeller(new SellerDTO(0,"00sss"/*(String)session.getAttribute("id")*/,dto.getPid()));
		
	/*	Connection con=null;
		try 
		{	 con=this.ds.getConnection();
			pdao.insert(dto);
			sdao.InsertSeller(new SellerDTO(0,"jack"(String)session.getAttribute("id"),dto.getPid()));
		//pay는 성공하고 seller는 실패하였지만 하나는 성공하여서 insert되니깐 문제가 발생한다 
		//그러므로 두개는 작업의 원자성을 가져야한다 
				con.commit();
			//두개 다 commit하여야한다 
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			//하나만 성공부분을 취소하여야한다 
		}finally {
			
			try{if(con!=null)con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}*/
		
	}
}
