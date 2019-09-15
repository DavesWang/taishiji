package com.wangxcit.filesystem.dao;

import com.wangxcit.framework.domain.filesystem.FileSystem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileSystemRepository extends MongoRepository<FileSystem,String>{

}
