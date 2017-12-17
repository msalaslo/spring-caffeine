package com.msl.cache.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.msl.cache.repository.PromotionRepository;
import com.msl.model.promocion.Promocion;

@Service
public class PromotionService {
	
	@Autowired
	PromotionRepository repository;

	@Cacheable(cacheNames = "promotions")
    public Promocion get(String id){
    	return repository.get(id);
    }
	
	@CachePut(value="promotions", key="#id")
	public void put(Promocion product) {
		repository.put(product);
	}
	
	@CacheEvict(value = "promotions", key = "#id")
    public void evict(long id){
    }
	
	public void load(Collection<Promocion> promociones) {
		repository.load(promociones);
	}
	
//	@Cacheable
//  public List<Promocion> findByEmpresa(String empresa){
//  	return repository.findByCempresa(empresa);
//  }
//  
//	@Cacheable
//  public List<Promocion> findByCentro(String centro){
//  	return repository.findByCentrooo(centro);
//  }
//  
//	@Cacheable
//  public List<Promocion> findByDivision(String division){
//  	return repository.findByCdivisio(division);
//  }
//	
//	@Cacheable
//  public List<Promocion> findByFamilia(String familia){
//  	return repository.findByCfamilia(familia);
//  }

}
