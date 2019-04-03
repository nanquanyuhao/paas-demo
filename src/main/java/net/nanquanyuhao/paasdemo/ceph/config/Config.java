package net.nanquanyuhao.paasdemo.ceph.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by nanquanyuhao on 2019/4/3.
 */
@Configuration
public class Config {

    @Value("${ceph.rgw.s3endpoint}")
    private String s3Endpoint;

    @Value("${ceph.user.accesskey}")
    private String accessKey;

    @Value("${ceph.user.secretkey}")
    private String secretKey;

    @Bean
    public AmazonS3 getAmazonS3() {

        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        ClientConfiguration clientConfig = new ClientConfiguration();
        clientConfig.setProtocol(Protocol.HTTP);

        // 此处基于 Ceph 代码示例，使用过期方法确保不会引入其他异常
        AmazonS3 conn = new AmazonS3Client(credentials, clientConfig);
        conn.setEndpoint(s3Endpoint);
        return conn;
    }
}
