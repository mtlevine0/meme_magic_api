package com.mtlevine0.mememagic.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mtlevine0.mememagic.api.model.Template;
import com.mtlevine0.mememagic.api.repository.TemplateRepository;

@Component
public class DefaultTemplateService implements TemplateService {
	
	@Autowired
	TemplateRepository templateRepository;

	@Override
	public Template create(Template template) {
		return templateRepository.save(template);
	}

	@Override
	public List<Template> findAll() {
		return templateRepository.findAll();
	}

	@Override
	public Optional<Template> findOne(long id) {
		return templateRepository.findById(id);
	}

}
