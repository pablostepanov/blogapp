package fi.candysoft.repository;

import java.util.Optional;

import fi.candysoft.model.Post;

import org.springframework.data.domain.Page;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findAllByOrderByCreateDateDesc();

    Optional<Post> findById(Long id);

}
