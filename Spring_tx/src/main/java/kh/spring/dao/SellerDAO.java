package kh.spring.dao;

import org.springframework.stereotype.Component;

import spring.kh.dto.SellerDTO;

public interface SellerDAO {
	public int InsertSeller(SellerDTO dto)throws Exception;
}
