package fi.candysoft.service.impl;

import fi.candysoft.service.PostService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import fi.candysoft.model.Post;
import fi.candysoft.repository.PostRepository;
import java.util.Optional;


@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post save(Post post) {
        return postRepository.saveAndFlush(post);
    }

    @Override
    public Page<Post> findAllPosts() {
        return postRepository.findAllByOrderByCreateDateDesc();
    }

    @Override
    public void delete(Post post) {
        postRepository.delete(post);
    }


    @Override
    public Optional<Post> findForId(Long id) {
        return postRepository.findById(id);
    }

}
