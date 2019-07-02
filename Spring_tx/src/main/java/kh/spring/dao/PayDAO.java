package kh.spring.dao;

import org.springframework.stereotype.Component;

import spring.kh.dto.PayDTO;

public interface PayDAO {
	public int insert(PayDTO dto)throws Exception;
}
