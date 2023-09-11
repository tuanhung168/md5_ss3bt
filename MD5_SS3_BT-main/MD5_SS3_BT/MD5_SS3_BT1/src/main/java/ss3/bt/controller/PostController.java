package ss3.bt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ss3.bt.model.dto.PostDto;
import ss3.bt.model.entity.Category;
import ss3.bt.model.entity.Post;
import ss3.bt.model.service.category.ICategoryService;
import ss3.bt.model.service.post.IPostService;

import java.util.Optional;

@Controller
@RequestMapping(value = {"/","/posts"})
public class PostController {
    @Autowired
    private IPostService postService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories() {

        return categoryService.findAll();
    }

    @GetMapping()
    public ModelAndView postList(@RequestParam("search") Optional<String> search, Pageable pageable) {
        Page<Post> posts;
        pageable = PageRequest.of(pageable.getPageNumber(), 5, Sort.by(Sort.Order.desc("creationDate")));
        if (search.isPresent()) {
            posts = postService.findAllByTitleContaining(search.get(), pageable);
        } else {
            posts = postService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("post/list");
        modelAndView.addObject("posts", posts);
        return modelAndView;
    }
    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable Long id){
        return new ModelAndView("post/detail","post",postService.findById(id).get());
    }
    @GetMapping("/add")
    public ModelAndView showAddForm() {
        return new ModelAndView("post/add", "post", new PostDto());
    }

    @PostMapping("/add")
    public String add(@ModelAttribute PostDto postDto) {
        postService.save(postDto);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        return new ModelAndView("post/edit", "post", postService.findById(id).get());
    }

    @PostMapping("/update")
    public String update(@ModelAttribute PostDto postDto) {
        postService.save(postDto);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        postService.delete(id);
        return "redirect:/";
    }
}
