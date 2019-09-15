package com.wangxcit.manage_media.controller;

import com.wangxcit.api.media.MediaUploadControllerApi;
import com.wangxcit.framework.domain.media.response.CheckChunkResult;
import com.wangxcit.framework.model.response.ResponseResult;
import com.wangxcit.manage_media.service.MediaUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/media/upload")
public class MediaUploadController implements MediaUploadControllerApi {

    @Autowired
    MediaUploadService mediaUploadService;

    //文件上传前的注册
    @Override
    @PostMapping("/register")
    public ResponseResult register(String uid,String fileMd5, String fileName, Long fileSize, String mimetype, String fileExt) {
        System.out.println("用户id"+uid);
        System.out.println("md5"+fileMd5);
        return mediaUploadService.register(fileMd5,fileName,fileSize,mimetype,fileExt,uid);
    }

    @Override
    @PostMapping("/checkchunk")
    public CheckChunkResult checkchunk(String uid,String fileMd5, Integer chunk, Integer chunkSize) {
        return mediaUploadService.checkchunk(fileMd5,chunk,chunkSize,uid);
    }

    @Override
    @PostMapping("/uploadchunk")
    public ResponseResult uploadchunk(String uid,MultipartFile file, String fileMd5, Integer chunk) {
        return mediaUploadService.uploadchunk(file,fileMd5,chunk,uid);
    }

    @Override
    @PostMapping("/mergechunks")
    public ResponseResult mergechunks(String uid,String fileMd5, String fileName, Long fileSize, String mimetype, String fileExt) {
        return mediaUploadService.mergechunks(fileMd5,fileName,fileSize, mimetype,fileExt,uid);
    }
}
