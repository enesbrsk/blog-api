package com.services.rest.blogapi.service;

import com.services.rest.blogapi.dto.PostRequest;
import com.services.rest.blogapi.dto.PostResponse;
import com.services.rest.blogapi.entity.Post;
import com.services.rest.blogapi.model.PostMapper;
import com.services.rest.blogapi.repository.PostRepository;
import com.services.rest.blogapi.utility.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private final PostRepository postRepository;

    public boolean createPost(PostRequest postRequest, MultipartFile multipartFile) throws IOException {

       /* Post post = PostMapper.INSTANCE.postRequestToPost(postRequest);
        post.setImageName(StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename())));

        Post data = postRepository.save(post);
*/
        Utils.saveImage(1L,multipartFile);

        log.info("Post created");
        return true;
    }

    public List<PostResponse> getAllPost(){
        return postRepository.findAll()
                .stream()
                .map(PostMapper.INSTANCE::postToPostResponse)
                .collect(Collectors.toList());
    }


    public PostResponse getPostById(Long id){
        return PostMapper.
                INSTANCE.
                postToPostResponse(getPost(id));
    }

    public PostResponse updatePostById(Long id,PostRequest postRequest){

        // image must add
        Post post = getPost(id);

        if (postRequest.getText() != null){
            post.setText(postRequest.getText());
        }
        if (postRequest.getTitle() != null){
            post.setTitle(postRequest.getTitle());
        }
        if (postRequest.getDescription() != null){
            post.setDescription(postRequest.getDescription());
        }
        return PostMapper.
                INSTANCE.
                postToPostResponse(postRepository.save(post));
    }

    private Post getPost(Long id){
        return postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found id " + id));
    }
}
