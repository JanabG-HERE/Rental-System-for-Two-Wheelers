package com.bikerental.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class DiskStorageServiceImpl implements StorageService {
	
	private String BASEPATH;
	
	public DiskStorageServiceImpl(FileUploadProperties fileUploadProperties) {
		this.BASEPATH=Paths.get(fileUploadProperties.getLocation())
				.toAbsolutePath()
				.normalize().toString();
	}
	
	@PostConstruct
    public void init() {
        // TODO Auto-generated method stub
        try {
        	File file=new File(BASEPATH);
        	System.err.println(BASEPATH);
            if(file.mkdirs()) {
            	System.out.println("Directory created");
            }
        } 
        catch (Exception ex) {
            System.err.println("Could not create upload dir! "+ex.getMessage());
        }
    }
	
	@Override
	public List<String> loadAll() {
		File dirPath = new File(BASEPATH);
		return Arrays.asList(dirPath.list());
	}

	@Override
	public String store(MultipartFile file) {
		System.out.println(file.getOriginalFilename());
		String ext=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		System.out.println(ext);
		String fileName = UUID.randomUUID().toString().replaceAll("-", "")+ext;
		File filePath = new File(BASEPATH, fileName);
		try(FileOutputStream out = new FileOutputStream(filePath)) {
			FileCopyUtils.copy(file.getInputStream(), out);
			return fileName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Resource load(String fileName) {
		File filePath = new File(BASEPATH, fileName);
		if(filePath.exists())
			return new FileSystemResource(filePath);
		return null;
	}

	@Override
	public void delete(String fileName) {
		File filePath = new File(BASEPATH, fileName);
		if(filePath.exists())
			filePath.delete();
	}

}
