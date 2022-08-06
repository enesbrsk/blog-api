package com.services.rest.blogapi.model;

import com.services.rest.blogapi.dto.PostRequest;
import com.services.rest.blogapi.dto.PostResponse;
import com.services.rest.blogapi.entity.Post;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {

    PostMapper INSTANCE = Mappers.getMapper( PostMapper.class );
    @InheritInverseConfiguration
    Post postRequestToPost(PostRequest postRequest);

    PostResponse postToPostResponse(Post post);

}
