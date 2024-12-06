import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class flatMapExample {
    public static void main(String[] args) {
        Flux.fromArray(new String[]{"Tom", "Melissa", "Steve", "Megan"})
                .flatMap(flatMapExample::modifyNameToMono)
                .subscribe(System.out::println);
    }

    private static Mono<String> modifyNameToMono(String name){
        return Mono.just(name.concat(" modify"));
    }
}
