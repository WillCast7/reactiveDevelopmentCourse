import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.Objects;

public class TestUsers {
    private static final Logger log = LoggerFactory.getLogger(TestUsers.class);
    public static void main(String[] args) {
        Flux <String> names = Flux.just("Pepe Rodriguez", "Elviro pacativa", "Benito Melezdez", "Rafael Belalcazar", "Martin Asprilla", "Bernardo Aspilicueta");
        Flux <User> users = names.map(name -> new User(name.split(" ")[0].toUpperCase(), name.split(" ")[1].toUpperCase()))
            .filter(user -> user.getSurName().equalsIgnoreCase("pacativa"))
            .doOnNext(user -> {
                if(Objects.equals(user, null)){
                    throw new RuntimeException("The name can't be empties");
                }
                System.out.println(user.getName().concat(" ").concat(user.getSurName()));
            })
            .map(user -> {
                String name = user.getName().toLowerCase();
                user.setName(name);
                return user;
            });

        users.subscribe(e -> log.info(e.toString()), error -> log.error(error.getMessage()), new Runnable() {
            @Override
            public void run() {
                log.info("this example is overed");
            }
        });
    }
}
