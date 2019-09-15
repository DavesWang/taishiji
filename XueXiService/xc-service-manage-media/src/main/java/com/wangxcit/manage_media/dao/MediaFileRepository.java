package com.wangxcit.manage_media.dao;

import com.wangxcit.framework.domain.media.MediaFile;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface MediaFileRepository extends  MongoRepository<MediaFile,String> {
}
