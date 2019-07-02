package kh.spring.service;

import org.springframework.stereotype.Component;

import spring.kh.dto.PayDTO;

public interface BuyService {
	public void Buy(PayDTO dto)throws Exception;
}
