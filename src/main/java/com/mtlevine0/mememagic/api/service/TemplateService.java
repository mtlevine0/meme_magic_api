package com.mtlevine0.mememagic.api.service;

import java.util.List;
import java.util.Optional;

import com.mtlevine0.mememagic.api.model.Template;

public interface TemplateService {
	
	public Template create(Template template);
	
	public List<Template> findAll();
	
	public Optional<Template> findOne(long id);

}
