package ss3.bt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ss3.bt.model.entity.Category;
import ss3.bt.model.service.category.ICategoryService;
import ss3.bt.model.service.post.IPostService;

import java.util.Optional;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IPostService postService;

    @GetMapping()
    public ModelAndView categoryList() {
        Iterable<Category> categories = categoryService.findAll();
        return new ModelAndView("category/list","categories",categories);
    }

    @GetMapping("/add")
    public ModelAndView showAddForm() {
        return new ModelAndView("category/add","category",new Category());
    }

    @PostMapping("/add")
    public ModelAndView saveCat(@ModelAttribute("category") Category category) {
        categoryService.save(category);

        ModelAndView modelAndView = new ModelAndView("category/add");
        modelAndView.addObject("category", new Category());
        modelAndView.addObject("message", "New category created successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        return new ModelAndView("category/edit","category",category.get());
    }


    @PostMapping("/update")
    public ModelAndView updateProvince(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("category/edit");
        modelAndView.addObject("category", category);
        modelAndView.addObject("message", "Category updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        categoryService.delete(id);
        return "redirect:/categories";
    }


}
