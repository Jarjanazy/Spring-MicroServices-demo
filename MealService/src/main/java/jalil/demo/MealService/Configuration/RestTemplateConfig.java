package jalil.demo.MealService.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    /* create a Bean for RestTemplate*/
    @Bean
    public RestTemplate getRestTemplateBean(){
        return new RestTemplate();
    }

}
