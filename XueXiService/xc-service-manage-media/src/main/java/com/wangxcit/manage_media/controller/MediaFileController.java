package com.wangxcit.manage_media.controller;

import com.wangxcit.api.media.MediaFileControllerApi;
import com.wangxcit.framework.domain.media.MediaFile;
import com.wangxcit.framework.domain.media.request.QueryMediaFileRequest;
import com.wangxcit.framework.model.response.QueryResponseResult;
import com.wangxcit.manage_media.service.MediaFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/media/file")
public class MediaFileController implements MediaFileControllerApi {
    @Autowired
    MediaFileService mediaFileService;

    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult<MediaFile> findList(int page, int size, QueryMediaFileRequest queryMediaFileRequest) {
        System.out.println(
                "进入查询------------------------------"
        );
        return mediaFileService.findList(page,size,queryMediaFileRequest);
    }
}
