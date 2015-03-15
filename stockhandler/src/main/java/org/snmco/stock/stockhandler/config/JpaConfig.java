package org.snmco.stock.stockhandler.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"org.snmco.stock.stockhandler.reppository"})
public class JpaConfig {
}
