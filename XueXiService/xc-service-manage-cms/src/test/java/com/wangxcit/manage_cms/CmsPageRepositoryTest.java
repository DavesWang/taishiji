package com.wangxcit.manage_cms;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.wangxcit.framework.domain.cms.CmsPage;
import com.wangxcit.manage_cms.dao.CmsPageRepository;
import org.apache.commons.io.IOUtils;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;


/**
 * 测试程序使用@SpringBootTest和@RunWith(SpringRunner.class)注解，启动测试类会从main下找springBoot启
 动类，加载spring容器
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {
    @Autowired
    CmsPageRepository cmsPageRepository;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    GridFsTemplate gridFsTemplate;
    @Autowired
    GridFSBucket gridFSBucket;
    @Test
    public void testFindPage(){
        int page = 0;
        int size = 10;
        Pageable pageable = PageRequest.of(page,size);
        Page<CmsPage> all = cmsPageRepository.findAll(pageable);
        System.out.println(all.getContent());
    }
    //添加
    @Test
    public void testAdd(){
        CmsPage cmsPage = new CmsPage();
        cmsPage.setPageName("测试");
        CmsPage save = cmsPageRepository.save(cmsPage);
        //System.out.println(save);
    }
    //删除
    @Test
    public void testDelete(){
       /* CmsPage cmsPage = new CmsPage();
        cmsPage.setPageName("测试");
        cmsPage.setPageId("5c7914120960db421cb41dbe");
        cmsPageRepository.delete(cmsPage);*/
       cmsPageRepository.deleteById("5c79143c0960db1dcc2b7813");
    }
    @Test
    //修改  先查 再改 再保存
    public void updateTest(){
        Optional<CmsPage> byId = cmsPageRepository.findById("5c7919670960db25b431700c");
        //Optional对象是 JDK1.8 用get方法即可得到想要的的对象 ，优点：提醒进行非空判断 防止Null
        if(byId.isPresent()){
            CmsPage cmsPage = byId.get();
            System.out.println(cmsPage);
            cmsPage.setPageName("修改后测试");
            cmsPageRepository.save(cmsPage);
        }
    }
    //测试根据名称自定义的方法
    @Test
    public void defineTest(){
        List<CmsPage> list = cmsPageRepository.findByPageName("修改后测试");
        if(list==null&&list.size()==0){
            System.out.println("xx");
            System.exit(0);
        }
        System.out.println(list);
    }
    //自定义条件查询
    @Test
    public void findByExample(){
        ExampleMatcher exampleMatcher = ExampleMatcher.matching();
        //页面别名模糊查询，需要自定义字符串的匹配器
        exampleMatcher = exampleMatcher.withMatcher("pageAliase",ExampleMatcher.GenericPropertyMatchers.contains());
        CmsPage cmsPage = new CmsPage();
        cmsPage.setPageAliase("首页");
        //定义条件
        Example<CmsPage> example =Example.of(cmsPage,exampleMatcher);
        Pageable pageable = PageRequest.of(0,10);
        Page<CmsPage> all = cmsPageRepository.findAll(example, pageable);
        System.out.println(all.getContent());

    }
    //测试远程得到数据（页面静态化）
    @Test
    public void testRestTemplate(){
        ResponseEntity<Map> forEntity = restTemplate.getForEntity("http://localhost:31001/cms/config/getmodel/5a791725dd573c3574ee333f", Map.class);
        System.out.println(forEntity.getBody());
    }
    //测试GridFS文件存取
    @Test
    public void testGridFs() throws FileNotFoundException {
        //要存储的文件
        File file = new File("d:/葛傲峰.png");
        //定义输入流
        FileInputStream inputStram = new FileInputStream(file);
        //向GridFS存储文件
        ObjectId objectId = gridFsTemplate.store(inputStram, "轮播图测试文件01", "");
        //得到文件ID
        String fileId = objectId.toString();
        System.out.println(fileId);
    }
    //取文件测试
    @Test
    public void queryFile() throws IOException {
        String fileId = "5c7e591d0960db342c3b6114";
        //根据id查询文件
        GridFSFile gridFSFile = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(fileId)));
        //打开下载流对象
        GridFSDownloadStream gridFSDownloadStream = gridFSBucket.openDownloadStream(gridFSFile.getObjectId());
        //创建gridFsResource，用于获取流对象
        GridFsResource gridFsResource = new GridFsResource(gridFSFile,gridFSDownloadStream);
        //获取流中的数据
        String s = IOUtils.toString(gridFsResource.getInputStream(), "UTF-8");
        System.out.println(s);
    }
}
