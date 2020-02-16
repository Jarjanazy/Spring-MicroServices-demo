package jalil.demo.ReactiveClient.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class MealService {
    Logger logger = LoggerFactory.getLogger(MealService.class);

    WebClient.Builder webClient;

    public MealService(
            @Autowired @Qualifier("webClient") WebClient.Builder webClient){
        this.webClient = webClient;
    }

    public Mono<String> getMealByName(String mealName){
        return webClient
                .build()
                .get()
                .uri("http://MealService/meal/{mealName}", mealName)
                .retrieve()
                .bodyToMono(String.class)
                .doOnNext(s -> logger.info("Received " + s));
    }

}
