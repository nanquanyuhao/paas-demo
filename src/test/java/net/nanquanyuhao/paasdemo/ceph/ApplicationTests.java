package net.nanquanyuhao.paasdemo.ceph;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.util.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayInputStream;
import java.io.File;

/**
 * Created by nanquanyuhao on 2019/4/3.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    public static final String BUCKET_NAME = "demo";

    @Autowired
    private AmazonS3 amazonS3;

    @Test
    public void contextLoads() {

        ObjectListing objects = amazonS3.listObjects(BUCKET_NAME);
        do {
            for (S3ObjectSummary objectSummary : objects.getObjectSummaries()) {
                System.out.println(objectSummary.getKey() + "\t" +
                        objectSummary.getSize() + "\t" +
                        StringUtils.fromDate(objectSummary.getLastModified()));
            }
            objects = amazonS3.listNextBatchOfObjects(objects);
        } while (objects.isTruncated());

        ByteArrayInputStream input = new ByteArrayInputStream("Hello World!".getBytes());
        amazonS3.putObject(BUCKET_NAME, "hello.txt", input, new ObjectMetadata());
        // amazonS3.setObjectAcl(BUCKET_NAME, "hello.txt", CannedAccessControlList.PublicRead);

        amazonS3.getObject(
                new GetObjectRequest(BUCKET_NAME, "hello.txt"),
                new File("C:\\Users\\nanquanyuhao\\Desktop\\hello.txt")
        );

        GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(BUCKET_NAME, "hello.txt");
        System.out.println("文件地址：" + amazonS3.generatePresignedUrl(request));
    }
}
