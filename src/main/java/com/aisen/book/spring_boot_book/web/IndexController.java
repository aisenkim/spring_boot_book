package com.aisen.book.spring_boot_book.web;

import com.aisen.book.spring_boot_book.config.auth.LoginUser;
import com.aisen.book.spring_boot_book.config.auth.dto.SessionUser;
import com.aisen.book.spring_boot_book.service.posts.PostsService;
import com.aisen.book.spring_boot_book.web.dto.PostsListResponseDto;
import com.aisen.book.spring_boot_book.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        if (user != null){
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }

    @GetMapping("/posts/save")
    public String postsSave(@LoginUser SessionUser user, Model model) {
        // send user author name to template
        model.addAttribute("author", user.getName());
        return "posts-save";
    }

    @GetMapping("/posts/view/{id}")
    public String postsView(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-view";
    }

}
