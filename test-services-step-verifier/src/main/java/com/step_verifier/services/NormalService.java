package com.step_verifier.services;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class NormalService {
    public Mono<String> searchOne(){
        return Mono.just("Hello world");
    }

    public Flux<String> searchAll(){
        return Flux.just("Hello", "How", "Are", "You?");
    }

    public Flux<String> searchAllSlow(){
        return Flux.just("Hello", "How", "Are", "You?").delaySequence(Duration.ofSeconds(10));
    }
}
