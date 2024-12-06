import reactor.core.publisher.Flux;

public class flux1 {
    public static void main(String[] args) {
        Flux<String> flux = Flux.fromArray(new String[]{"Data 1", "Data 2", "Data 3", "Data 4", "Data 5"});
        //flux.subscribe(System.out::println);

        flux.doOnNext(System.out::println).subscribe();
    }
}
