import reactor.core.publisher.Flux;
import  reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Ejemplo01 {
    public static void main(String[] args) {

        List<Integer> monoElements = new ArrayList<>();
        List<Integer> fluxElements = new ArrayList<>();

        //Creacion de mono
        Mono<Integer> mono = Mono.just(121);

        //Creacion de Flux
        Flux<Integer> flux = Flux.just(1,2,3,4,5,6,7,8,222);

        //mono subscription
        mono.subscribe(monoElements::add);

        //Flux subscription
        flux.subscribe(fluxElements::add);

        System.out.println(monoElements);
        System.out.println(fluxElements);
    }
}
