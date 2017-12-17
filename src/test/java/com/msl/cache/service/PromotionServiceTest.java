package com.msl.cache.service;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.msl.cache.util.DummyPromotion;
import com.msl.model.promocion.Promocion;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PromotionServiceTest {

	@Autowired
	private PromotionService promotionService;

	@Test
	public void load() {
		Collection<Promocion> promotions = new ArrayList<Promocion>();
		for (int i = 0; i < 10; i++) {
			Promocion promotion = DummyPromotion.createPromotion(i + "");
			promotions.add(promotion);
		}
		promotionService.load(promotions);
	}

	
}
