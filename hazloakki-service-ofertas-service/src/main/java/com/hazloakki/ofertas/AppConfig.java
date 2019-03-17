package com.hazloakki.ofertas;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.github.mongobee.Mongobee;

@Configuration
@ComponentScan
public class AppConfig {
	
	@Value("${hazloakki.aws.access_key_id}")
	private String awsId;
 
	@Value("${hazloakki.aws.secret_access_key}")
	private String awsKey;
	
	@Value("${hazloakki.s3.region}")
	private String region;
 
	@Bean
	public AmazonS3 s3client() {
		
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsId, awsKey);
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
								.withRegion(Regions.fromName(region))
		                        .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
		                        .build();
		
		return s3Client;
	}
	
	@Bean
	public Mongobee mongobee(MongoTemplate template) throws Exception{
	  Mongobee runner = new Mongobee();	
	  runner.setDbName("hazloakki_ofertas");
	  runner.setChangeLogsScanPackage("com.hazloakki.ofertas.changelogs");
	  runner.setMongoTemplate(template);
	  
	  return runner;
	}

}
