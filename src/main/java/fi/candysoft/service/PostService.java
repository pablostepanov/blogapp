package fi.candysoft.service;

import fi.candysoft.model.Post;

import org.springframework.data.domain.Page;

public interface PostService {

    /**
     *
     * @param post Post to be saved
     * @return saved <CODE>Post</CODE>
     */
    Post save(Post post);

    /**
     * Finds a {@link Page) of all {@link Post} ordered by date
     */
    Page<Post> findAllPosts();

    /**
     *
     * @param post Post to be deleted
     */
    void delete(Post post);
}