package com.mtlevine0.mememagic.api.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mtlevine0.mememagic.api.model.Template;
import com.mtlevine0.mememagic.api.service.StorageService;
import com.mtlevine0.mememagic.api.service.TemplateService;

@RestController
@RequestMapping("/api/v1/template")
public class TemplateResource {
	
	@Autowired
	TemplateService templateService;
	
	@Autowired
	StorageService storageService;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Template template) {
		return new ResponseEntity<Template>(templateService.create(template), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> findAll() {
		return new ResponseEntity<List<Template>>(templateService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{templateId}")
	public ResponseEntity<?> findOne(@PathVariable("templateId") Long templateId) {
		return new ResponseEntity<Optional<Template>>(templateService.findOne(templateId), HttpStatus.OK);
	}
	
    @PostMapping("/{templateId}")
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file, 
    		@PathVariable("templateId") Long templateId) {
    	storageService.store(file, templateId);
    	return new ResponseEntity<String>(file.getOriginalFilename(), HttpStatus.OK);
    }
	
}
