package com.step_verifier;

import com.step_verifier.services.NormalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;

@SpringBootTest
class TestServicesStepVerifierApplicationTests {

	@Autowired
	NormalService normalService;

	@Test
	void testMono() {
		Mono<String> one = normalService.searchOne();
		StepVerifier.create(one)
				.expectNext("Hello world")
				.verifyComplete();
	}

	@Test
	void testFlux(){
		Flux<String> various = normalService.searchAll();
		StepVerifier.create(various)
				.expectNext("Hello")
				.expectNext("How")
				.expectNext("Are")
				.expectNext("You?")
				.verifyComplete();
	}

	@Test
	void testFluxSlow(){
		Flux<String> voriousSlow = normalService.searchAllSlow();
		StepVerifier.create(voriousSlow)
				.expectNext("Hello")
				.thenAwait(Duration.ofSeconds(1))
				.expectNext("How")
				.thenAwait(Duration.ofSeconds(1))
				.expectNext("Are")
				.thenAwait(Duration.ofSeconds(1))
				.expectNext("You?")
				.verifyComplete();
	}
}
