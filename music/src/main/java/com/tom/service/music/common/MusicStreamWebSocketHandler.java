package com.tom.service.music.common;

import java.io.IOException;
import java.nio.ByteBuffer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;

@Slf4j
@Component
@RequiredArgsConstructor
public class MusicStreamWebSocketHandler extends TextWebSocketHandler {

	@Value("amazon.s3.bucket-name")
	private final String bucketName;
	
    private final S3Client s3Client;
    
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
    	String fileName = message.getPayload();
    	try {
            GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                    .bucket(bucketName)
                    .key(fileName) 
                    .build();

            ResponseBytes<GetObjectResponse> s3Object = s3Client.getObjectAsBytes(getObjectRequest);
            byte[] audioBytes = s3Object.asByteArray();

            session.sendMessage(new BinaryMessage(ByteBuffer.wrap(audioBytes)));
    	} catch (Exception e) {
    		session.sendMessage(new TextMessage("Error: Could not retrieve file from S3. " + e.getMessage()));
    		log.warn("" , e);
    	}
    }
}
