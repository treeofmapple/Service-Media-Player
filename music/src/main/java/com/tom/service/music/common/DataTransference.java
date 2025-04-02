package com.tom.service.music.common;

import java.io.File;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

@Slf4j
@Service
@RequiredArgsConstructor
public class DataTransference {

	@Value("amazon.s3.bucket-name")
	private final String bucketName;
	
	private final S3Client client;
	
	public void uploadFile(String key, File file) {
		try {
			client.putObject(
					PutObjectRequest.builder()
					.bucket(bucketName)
					.key(key)
					.build(),
				RequestBody.fromFile(file)
				);
			log.info("File uploaded sucessfully: {}", key);
		} catch(S3Exception e) {
			log.error("Error uploading file: {}", e);
		}
	}
	
	public Optional<File> downloadFile(String key, String destinationPath) {
		try {
			GetObjectRequest getObjectRequest = 
					GetObjectRequest.builder()
					.bucket(bucketName)
					.key(key)
					.build();
			client.getObject(getObjectRequest, Paths.get(destinationPath));
			log.info("File downloaded sucessfully: {}", key);
			return Optional.of(new File(destinationPath));
		} catch(S3Exception e) {
			log.error("Error uploading file: {}", e);
			return Optional.empty();
		}
	}
}
