package com.mtlevine0.mememagic.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.mtlevine0.mememagic.api.model.Meme;

@Component
public interface MemeService {

	public Meme create(Meme meme);
	
	public List<Meme> findAll();
	
	public Optional<Meme> findOne(Long id);
	
}
