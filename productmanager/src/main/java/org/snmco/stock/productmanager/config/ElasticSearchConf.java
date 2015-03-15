package org.snmco.stock.productmanager.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "org/springframework/data/elasticsearch/repository")
public class ElasticSearchConf {

    @Value("${esearch.port}") int port;
    @Value("${esearch.host}") String hostname;

    @Bean
    public ElasticsearchOperations elasticSearchTemplate() {
        return new ElasticsearchTemplate(client());
    }

    @Bean
    public Client client() {
        TransportClient client= new TransportClient();
        TransportAddress address = new InetSocketTransportAddress(hostname, port);
        client.addTransportAddress(address);
        return client;
    }

}
