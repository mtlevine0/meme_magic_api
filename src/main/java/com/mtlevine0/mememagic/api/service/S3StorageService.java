package com.mtlevine0.mememagic.api.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.mtlevine0.mememagic.api.model.Template;

@Component
public class S3StorageService implements StorageService {
	
	@Autowired
	TemplateService templateService;

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void store(MultipartFile file, Long templateId) {        
        String bucket = "mememagic.media";        
        final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient(); 
        PutObjectResult result = null;
        String keyName = "templates/" + templateId;
        try {
        	try {
//				s3.putObject(bucket, file.getOriginalFilename(), multipartToFile(file));
				result = s3.putObject(bucket, keyName, convert(file));
			} catch (SdkClientException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } catch(AmazonServiceException e) {
        	System.err.println(e);
        }

        Optional<Template> template = templateService.findOne(templateId);
        if(template.isPresent()) {
        	template.get().setLocation("https://s3.amazonaws.com/mememagic.media/templates/" + templateId);
        	templateService.create(template.get());
        }
        
	}

	@Override
	public Stream<Path> loadAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Path load(String filename) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource loadAsResource(String filename) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}
	
	public File convert(MultipartFile file) throws IOException
	{    
	    File convFile = new File(file.getOriginalFilename());
	    convFile.createNewFile(); 
	    FileOutputStream fos = new FileOutputStream(convFile); 
	    fos.write(file.getBytes());
	    fos.close(); 
	    return convFile;
	}

}
