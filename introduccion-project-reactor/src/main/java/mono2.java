import reactor.core.publisher.Mono;

public class mono2 {
    public static void main(String[] args) {
        //Exception created
        Mono<String> mono = Mono.fromSupplier(() -> {
            throw new RuntimeException("Exception ocurred");
        });

        mono.subscribe(
                data -> System.out.println(data), //onNext
                err ->System.out.println(err), //onError
                ()-> System.out.println("completed") //Complete
        );
    }
}
