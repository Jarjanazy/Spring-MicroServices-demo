package jalil.demo.ReactiveClient.Configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    @Qualifier("mealServiceClient")
    @LoadBalanced
    public WebClient getWebClient(){
        return  WebClient
                .builder()
                .baseUrl("http://MealService")
                .build();
    }
}