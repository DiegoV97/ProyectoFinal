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
		valuesMap.put("cloud_name", "dht6hwart");
		valuesMap.put("api_key", "967266563358846");
		valuesMap.put("api_secret", "nHIDl7n_lgEzd6Vd9Nb5zBsgJnE");
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
	    String uniquePublicId = "video_" + System.currentTimeMillis();
	    Map result = cloudinary.uploader().upload(file, 
	            ObjectUtils.asMap("resource_type", "video",
	                    "public_id", uniquePublicId,
	                    "eager", Arrays.asList(
	                        new EagerTransformation().width(480).height(270).crop("limit").videoCodec("auto").quality("auto").bitRate("800k"),
	                        new EagerTransformation().width(160).height(90).crop("limit").videoCodec("auto").quality("auto").bitRate("400k")),
	                    "eager_async", true,
	                    "eager_notification_url", "https://mysite.example.com/notify_endpoint"));
	    file.delete();
	    return result;
	}





	


}
