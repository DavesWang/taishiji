package com.wangxcit.test.fastdfs;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileOutputStream;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Testfast {
    //文件上传
    @Test
    public void testUpload(){
        try{
            ClientGlobal.initByProperties("config/fastdfs-client.properties");
            System.out.println("network_timeout="+ClientGlobal.g_network_timeout);
            System.out.println("charset="+ClientGlobal.g_charset);
            //创建客户端
            TrackerClient tc = new TrackerClient();
            //链接tracker Server
            TrackerServer ts = tc.getConnection();
            if(ts==null){
                System.out.println("getConnection return null");
                return ;
            }
            //获取一个storage server
            StorageServer ss = tc.getStoreStorage(ts);
            if(ss==null){
                System.out.println("getStoreStorage return null");
            }
            //创建一个storage存储客户端
            StorageClient1 sc1= new StorageClient1(ts,ss);
            NameValuePair[] meta_list = null;
            String item="C:\\Users\\DavesWang\\Desktop\\1.jpg";
            String fileid;
            fileid = sc1.upload_appender_file1(item,"jpg",meta_list);
            //group1/M00/00/00/wKgZhVyGBxGEI0SkAAAAAOQzHmI950.jpg
            System.out.println("upload local file "+item+"ok,fileid="+fileid);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //文件查询
    @Test
    public void testQueryFile() throws Exception{
        ClientGlobal.initByProperties("config/fastdfs-client.properties");
        TrackerClient tracker = new TrackerClient();
        TrackerServer  trackerServer = tracker.getConnection();
        StorageServer storageServer = null;
        StorageClient storageClient = new StorageClient(trackerServer,storageServer);
        FileInfo fileInfo = storageClient.query_file_info("group1","M00/00/00/wKgZhVzzmMqEbrK9AAAAABA_6LU873.jpg");
        System.out.println(fileInfo);
    }
    //下载文件
    @Test
    public void testDownload() throws Exception{
        ClientGlobal.initByProperties("config/fastdfs-client.properties");
        TrackerClient trackerClient =new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageServer storageServer = null;
        StorageClient1 storageClient1 = new StorageClient1(trackerServer,storageServer);
        byte[] result = storageClient1.download_file1("group1/M00/00/00/wKgZhVyGBxGEI0SkAAAAAOQzHmI950.jpg");
        File file = new File("d:/1.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(result);
        fileOutputStream.close();
    }

}
