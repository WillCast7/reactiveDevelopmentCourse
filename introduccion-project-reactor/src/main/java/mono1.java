import reactor.core.publisher.Mono;

public class mono1 {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("Hola Mundo");
        mono.subscribe(
        data -> System.out.println(data), //onNext
        err ->System.out.println(err), //onError
                ()-> System.out.println("completed") //Complete
        );
    }
}
