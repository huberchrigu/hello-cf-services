package ch.huber.cloud.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.session.data.redis.config.ConfigureRedisAction;

/**
 * @author christoph.huber
 */
@Profile("cloud")
@Configuration
public class CloudConfig {

    @Bean
    public ConfigureRedisAction noConfig() {
        return ConfigureRedisAction.NO_OP;
    }
}