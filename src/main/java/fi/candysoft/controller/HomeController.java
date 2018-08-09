package fi.candysoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import fi.candysoft.service.PostService;
import fi.candysoft.model.Post;
import org.springframework.data.domain.Page;
import java.util.List;
import org.springframework.ui.Model;

@Controller
public class HomeController {

    private final PostService postService;

    @Autowired
    public HomeController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        Page<Post> page = postService.findAllPosts();

        List <Post> posts = page.getContent();
        System.out.println("We have " + posts.size() + " posts saved");
        for (int i = 0; i < posts.size(); i++) {
            Post post = posts.get(i);
            System.out.println("Title = " + post.getTitle() + " Body = " + post.getBody() + " Creation date = " + post.getCreateDate());
        }

        model.addAttribute("posts", posts);

        return "index";
    }
}
