import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class testExamples {

    //Map Example
    @Test
    public void transformMap(){
        List<String> nameList = Arrays.asList("google", "x", "Space", "Tesla", "Aurealab");
        Flux<String> nameFlux = Flux.fromIterable(nameList)
                .filter(name -> name.length() > 5)
                .map(name -> name.toUpperCase())
                .log();

        StepVerifier.create(nameFlux)
                .expectNext("GOOGLE", "AUREALAB")
                .verifyComplete();
    }

    //FlatMap Example
    @Test
    public void transformFlatMap(){
        List<String> nameList = Arrays.asList("google", "x", "Space", "Tesla", "Aurealab");
        Flux<String> nameFlux = Flux.fromIterable(nameList)
                .filter(name -> name.length() > 5)
                .flatMap(name -> {
                    return Mono.just(name.toUpperCase());
                })
                .log();

        StepVerifier.create(nameFlux)
                .expectNext("GOOGLE", "AUREALAB")
                .verifyComplete();
    }

    //Merge Example
    @Test
    public void mergeFlows(){
        Flux<String> flux1 = Flux.just("Blenders", "Old", "Jonnie");
        Flux<String> flux2 = Flux.just("Panda", "Monkey", "Walker");

        Flux<String> fluxMerged = Flux.merge(flux1, flux2).log();

        StepVerifier.create(fluxMerged)
                .expectSubscription()
                .expectNext("Blenders", "Old", "Jonnie", "Panda", "Monkey", "Walker")
                .verifyComplete();
    }

    //Merge with delay Example
    @Test
    public void mergeFlowsWithDelay(){
        Flux<String> flux1 = Flux.just("Blenders", "Old", "Jonnie")
                .delayElements(Duration.ofSeconds(1));
        Flux<String> flux2 = Flux.just("Panda", "Monkey", "Walker")
                .delayElements(Duration.ofSeconds(1));

        Flux<String> fluxMerged = Flux.merge(flux1, flux2).log();

        StepVerifier.create(fluxMerged)
                .expectSubscription()
                .expectNextCount(6)
                .verifyComplete();
    }
}
