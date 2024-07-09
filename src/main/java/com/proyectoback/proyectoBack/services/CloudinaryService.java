package com.proyectoback.proyectoBack.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.EagerTransformation;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryService {
	
	Cloudinary cloudinary;
	
	private Map<String, String> valuesMap = new HashMap<>();

	public CloudinaryService() {
		valuesMap.put("cloud_name", "dappzkn6l");
		valuesMap.put("api_key", "266943844235859");
		valuesMap.put("api_secret", "DQEbPaaGXkljtzZf1u_DMzrPnRY");
		cloudinary = new Cloudinary(valuesMap);
	}
	
	public Map upload(MultipartFile multipartFile) throws IOException {
		File file = convert(multipartFile);
		Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
		file.delete();
		return result;
	}
	
	public Map delete(String id) throws IOException {
		Map result = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
		return result;
	}
	
	
	private File convert(MultipartFile multipartFile) throws IOException {
		File file = new File(multipartFile.getOriginalFilename());
		FileOutputStream fo = new FileOutputStream(file);
		fo.write(multipartFile.getBytes());
		fo.close();
		return file;
	}
	
	public Map uploadVideo(MultipartFile multipartFile) throws IOException {
	    File file = convert(multipartFile);
	    String uniquePublicId = "video_" + System.currentTimeMillis();  // Genera un timestamp único para cada video
	    Map result = cloudinary.uploader().upload(file, 
	            ObjectUtils.asMap("resource_type", "video",
	                    "public_id", uniquePublicId,  // Usa el timestamp único como public_id
	                    "eager", Arrays.asList(
	                        new EagerTransformation().width(300).height(300).crop("pad").audioCodec("none"),
	                        new EagerTransformation().width(160).height(100).crop("crop").gravity("south").audioCodec("none")),
	                    "eager_async", true,
	                    "eager_notification_url", "https://mysite.example.com/notify_endpoint"));
	    file.delete();
	    return result;
	}


	


}
