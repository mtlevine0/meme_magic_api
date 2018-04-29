package com.mtlevine0.mememagic.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtlevine0.mememagic.api.model.Meme;
import com.mtlevine0.mememagic.api.service.MemeService;

@RestController
@RequestMapping(value = "/api/v1/meme")
public class MemeResource {
	
	@Autowired
	MemeService memeService;
	
	@PostMapping(value = "/{templateId}")
	public ResponseEntity<?> create(@RequestBody Meme meme, @PathVariable("templateId") Long templateId) {
		return new ResponseEntity<Meme>(memeService.create(meme), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> findAll() {
		return new ResponseEntity<List<Meme>>(memeService.findAll(), HttpStatus.OK);
	}

}
