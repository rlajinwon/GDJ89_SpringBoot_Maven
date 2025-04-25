package com.one.app.webclient;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

import com.one.app.PostVO;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@SpringBootTest
@Slf4j
class WebTest {

	
	@Test
	void test2() {
		//객체 생성 재사용 가능 
		WebClient webClient = WebClient.create("https://jsonplaceholder.typicode.com/");
		
		
		Flux<PostVO> fl = webClient.get()
		.uri("posts")
		.retrieve()
		.bodyToFlux(PostVO.class)
		;
		
		fl.subscribe((s)->{
			//s => PostVO 
			log.info("{}: " , s );
			
		});
		
		
		
		
		
		
		
		Mono<PostVO> res = webClient
				.get()
				.uri("posts/{num}",1)
				.retrieve()
				.bodyToMono(PostVO.class)
				
				;
			
			PostVO postVO = res.block();
			
			
			
			
		
		
		
		
		
		
		
		
		
		
//		Mono<ResponseEntity<PostVO>> res = webClient
//			.get()
//			.uri("posts/{num}",1)
//			.retrieve()
//			.toEntity(PostVO.class)
//			
//			;
//		
//		PostVO postVO = res.block().getBody();
//		
//		
//		
//		log.info("{}", postVO);
//		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	@Test
	void test() {
		
		WebClient webClient = WebClient.create();
		 Mono<ResponseEntity<String>> res = webClient
			.get()
			.uri("https://jsonplaceholder.typicode.com/posts/{num}",3)
			.retrieve()
			.toEntity(String.class)
			
			;
			
		 	String result = res.block().getBody();
		 	log.info(result);
			
			
	}

}
