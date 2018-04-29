package com.mtlevine0.mememagic.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mtlevine0.mememagic.api.model.Meme;
import com.mtlevine0.mememagic.api.repository.MemeRepository;

public class DefaultMemeService implements MemeService {

	@Autowired
	MemeRepository memeRepository;
	
	@Override
	public Meme create(Meme meme) {
		return memeRepository.save(meme);
	}

	@Override
	public List<Meme> findAll() {
		return memeRepository.findAll();
	}

	@Override
	public Optional<Meme> findOne(Long id) {
		return memeRepository.findById(id);
	}

}
