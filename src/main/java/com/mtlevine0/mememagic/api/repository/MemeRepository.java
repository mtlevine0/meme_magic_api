package com.mtlevine0.mememagic.api.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtlevine0.mememagic.api.model.Meme;

@Transactional
public interface MemeRepository extends JpaRepository<Meme, Long>{}
