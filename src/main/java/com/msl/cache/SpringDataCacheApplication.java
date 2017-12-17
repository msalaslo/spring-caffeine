package com.msl.cache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;

import com.msl.cache.service.PromotionService;
import com.msl.cache.util.DummyPromotion;
import com.msl.model.promocion.Promocion;

@SpringBootApplication
@EnableCaching
public class SpringDataCacheApplication implements CommandLineRunner {

	@Autowired
	private PromotionService promotionService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataCacheApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		loadDummyPromotions();
	}
	
    @Bean
    public CacheManager cacheManager() {
        // configure and return an implementation of Spring's CacheManager SPI
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("promotions")));
        return cacheManager;
    }

	public void loadDummyPromotions() {
		Collection<Promocion> promotions = new ArrayList<Promocion>();
		for (int i = 0; i < 10; i++) {
			Promocion promotion = DummyPromotion.createPromotion(i + "");
			promotions.add(promotion);
		}
		promotionService.load(promotions);
	}
}
