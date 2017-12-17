package com.msl.cache.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.msl.cache.service.PromotionService;
import com.msl.model.promocion.Promocion;

@RestController
@RequestMapping("/promocion")
public class PromotionController {
	
	Logger logger = LoggerFactory.getLogger("com.msl.cache.controller.PromotionController");
	
	@Autowired
	PromotionService service;
	
	@GetMapping(path = "/get")
    public Promocion get(@RequestParam(value="id", required=false, defaultValue="0") String id, Model model) {
        logger.debug("Buscando productos por id...");
        return service.get(id);
    }
	
    @PostMapping(path = "/put")
    public ResponseEntity<Promocion> put(@RequestBody Promocion promotion) {
    	this.service.put(promotion);
        return new ResponseEntity<>(promotion, HttpStatus.CREATED);
    }
}