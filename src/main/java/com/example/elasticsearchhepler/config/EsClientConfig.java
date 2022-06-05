package com.example.elasticsearchhepler.config;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.sniff.SniffOnFailureListener;
import org.elasticsearch.client.sniff.Sniffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Configuration
@ConfigurationProperties(prefix = "es")
public class EsClientConfig {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private String[] host;
    private int port;
    private String scheme;
    private String username;
    private String password;

    public String[] getHost() {
        return host;
    }

    public void setHost(String[] host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 初始化 RestHighLevelClient bean
     *
     * @return
     */
    @Bean
    public RestHighLevelClient restHighLevelClient() {
        logger.info("初始化ES客户端连接。。。");
        HttpHost[] hosts = new HttpHost[host.length];
        for (int i = 0; i < host.length; i++) {
            hosts[i] = new HttpHost(host[i], port, scheme);
        }
        RestClientBuilder builder = RestClient.builder(hosts);

        if (StringUtils.hasLength(username)) {
            CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
            credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(username, password));
            builder.setHttpClientConfigCallback(f -> f.setDefaultCredentialsProvider(credentialsProvider));
        }

        SniffOnFailureListener sniffOnFailureListener = new SniffOnFailureListener();

        builder.setRequestConfigCallback(requestConfigBuilder -> requestConfigBuilder
                        .setConnectTimeout(5000)
                        .setSocketTimeout(150000))
                //设置嗅探失败的监听器
                .setFailureListener(sniffOnFailureListener);

        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(builder);

        Sniffer sniffer = Sniffer.builder(restHighLevelClient.getLowLevelClient())
                .setSniffIntervalMillis(5000)//嗅探间隔时间 默认5分钟
                .setSniffAfterFailureDelayMillis(30000)//嗅探失败的时候每隔多久嗅探一次
                .build();

        sniffOnFailureListener.setSniffer(sniffer);
        return restHighLevelClient;
    }
}
