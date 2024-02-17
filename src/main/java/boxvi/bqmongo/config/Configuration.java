package boxvi.bqmongo.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Configuration {

    @Bean
    public ResponseMessage responseMessage() {
        return new ResponseMessage();
    }

}
