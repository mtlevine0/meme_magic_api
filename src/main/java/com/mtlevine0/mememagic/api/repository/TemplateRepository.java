package com.mtlevine0.mememagic.api.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtlevine0.mememagic.api.model.Template;

@Transactional
public interface TemplateRepository extends JpaRepository<Template, Long>{}
