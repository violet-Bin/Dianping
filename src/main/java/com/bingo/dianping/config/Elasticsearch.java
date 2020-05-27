package com.bingo.dianping.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: jiangjiabin
 * @Date: Create in 23:25 2020/5/27
 * @Description:
 */
@Configuration
public class Elasticsearch {

    private static final String COLON = ":";
    private static final String SCHEME = "http";

    @Value("${elasticsearch.ip}")
    String ipAddress;

    @Bean(name = "highLevelClient")
    public RestHighLevelClient highLevelClient() {

        String[] address = ipAddress.split(COLON);
        String ip = address[0];
        int port = Integer.valueOf(address[1]);
        HttpHost httpHost = new HttpHost(ip, port, SCHEME);
        return new RestHighLevelClient(RestClient.builder(httpHost));


    }


}
