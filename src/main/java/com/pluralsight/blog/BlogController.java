package com.pluralsight.blog;

import com.pluralsight.blog.data.PostRepository;
import com.pluralsight.blog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BlogController {

    private PostRepository postRepository;

    public BlogController(PostRepository repository) {
        postRepository = repository;
    }

    @RequestMapping("/")
    public String listPosts(ModelMap modelMap) {
        final List<Post> allPosts = postRepository.getAllPosts();
        modelMap.put("posts", allPosts);
        return "home";
    }
}
