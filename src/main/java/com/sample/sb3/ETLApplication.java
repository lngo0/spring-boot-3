package com.sample.sb3;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

@SpringBootApplication
public class ETLApplication extends WebMvcAutoConfiguration {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ETLApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

	@Bean
	public ByteArrayHttpMessageConverter byteArrayHttpMessageConverter() {
		return new ByteArrayHttpMessageConverter();
	}

	@Bean
	public MappingJackson2HttpMessageConverter jackson2HttpMessageConverter() {
		MappingJackson2HttpMessageConverter httpMessageConverter = new MappingJackson2HttpMessageConverter();
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new Hibernate4Module());
		mapper.setDateFormat(getISO8601DateFormat());
		httpMessageConverter.setObjectMapper(mapper);
		return httpMessageConverter;
	}

	private DateFormat getISO8601DateFormat() {
		TimeZone timeZone = TimeZone.getTimeZone("UTC");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
		dateFormat.setTimeZone(timeZone);
		return dateFormat;
	}

}
