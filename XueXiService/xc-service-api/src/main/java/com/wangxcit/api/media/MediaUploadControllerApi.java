package com.wangxcit.api.media;

import com.wangxcit.framework.domain.media.response.CheckChunkResult;
import com.wangxcit.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;
@Api(value = "媒资管理接口",description = "媒资管理接口，提供文件上传，文件处理等接口")
public interface MediaUploadControllerApi {
    @ApiOperation("文件上传注册")
    public ResponseResult register(
                                    String uid,
                                   String fileMd5,
                                   String fileName,
                                   Long fileSize,
                                   String mimetype,
                                   String fileExt);
    @ApiOperation("分块检查")
    public CheckChunkResult checkchunk(String uid,
                                        String fileMd5,
                                       Integer chunk,
                                       Integer chunkSize);
    @ApiOperation("上传分块")
    public ResponseResult uploadchunk(String uid,MultipartFile file,
                                      String fileMd5,Integer chunk);
    @ApiOperation("合并文件")
    public ResponseResult mergechunks(  String uid,
                                        String fileMd5,
                                      String fileName,
                                      Long fileSize,
                                      String mimetype,
                                      String fileExt);
}