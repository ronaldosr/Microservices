package br.com.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.microservices.bean.ExchangeValue;

public interface  ExchangeValueRepository extends JpaRepository<ExchangeValue, Long>{

	ExchangeValue findByFromAndTo(String from, String to);
}
