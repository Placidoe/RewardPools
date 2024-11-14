package com.exploreX;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@Configurable
@EnableElasticsearchRepositories
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }

}
