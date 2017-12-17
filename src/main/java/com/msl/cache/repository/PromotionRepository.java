package com.msl.cache.repository;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import com.msl.model.promocion.Promocion;

@Component
public class PromotionRepository{
	
    @Autowired
    private CacheManager cacheManager;
    
    private Cache getCache() {
    	return cacheManager.getCache("promotions");
    }

	public void put(Promocion promotion) {
		getCache().put(promotion.getId(), promotion);
	}
	
    public Promocion get(String id) {
    	return (Promocion)getCache().get(id);
    }
//    public List<Promocion> findByCempresa(String cempresa);
//    public List<Promocion> findByCentrooo(String centrooo);
//    public List<Promocion> findByCdivisio(String cdivisio);
//    public List<Promocion> findByCfamilia(String cfamilia);    
//    public List<Promocion> findAll();
    
	public void load(Collection<Promocion> promociones) {
		for (Iterator<Promocion> iterator = promociones.iterator(); iterator.hasNext();) {
			Promocion promocion = (Promocion) iterator.next();
			getCache().put(promocion.getId(), promocion);
		}
		
	}

}
