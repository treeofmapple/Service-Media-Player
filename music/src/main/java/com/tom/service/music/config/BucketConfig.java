package com.tom.service.music.config;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.S3Configuration;

@Configuration
public class BucketConfig {

	@Value("${blackblaze.endpoint}")
	private String endpoint;
	
	@Value("${amazon.s3.credentials.access-key}")
	private String accessKey;
	
	@Value("${amazon.s3.credentials.secret-key}")
	private String secretKey;
	
	@Value("${amazon.s3.region.static}")
	private String region;
	
	@Bean
	S3Client s3Client() {
		return S3Client.builder()
				.endpointOverride(URI.create(endpoint))
				.credentialsProvider(
						StaticCredentialsProvider.create(
								AwsBasicCredentials.create(accessKey, secretKey)))
				.region(Region.of(region))
				.serviceConfiguration(
						S3Configuration.builder()
						.pathStyleAccessEnabled(true)
						.build())
				.build();
	}
}
