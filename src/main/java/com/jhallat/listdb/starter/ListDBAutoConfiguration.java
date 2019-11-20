package com.jhallat.listdb.starter;

import com.jhallat.listdb.ListDBDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(ListDBDataSource.class)
@EnableConfigurationProperties(ListDBProperties.class)
public class ListDBAutoConfiguration {

    @Autowired
    private ListDBProperties listDBProperties;

    @Bean
    @ConditionalOnMissingBean
    public ListDBDataSource listDBDataSource() {

        //TODO add error handling
        String host = listDBProperties.getHost();
        int port = Integer.parseInt(listDBProperties.getPort());

        ListDBDataSource dataSource = new ListDBDataSource(host, port);

        return dataSource;
    }

}
