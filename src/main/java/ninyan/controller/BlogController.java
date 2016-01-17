package ninyan.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ninyan.entities.Blog;
import ninyan.entities.Project;
import ninyan.service.BlogServiceImpl;

@Controller
@RequestMapping("/blog")
public class BlogController {
	@Autowired
	private BlogServiceImpl blogServiceImpl;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addBlog() {
		System.out.println("addBlog");
		return "blog_add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody 
	public Blog saveBlog(@Valid @ModelAttribute Blog blog) {
		System.out.println("saveBlog");
		System.out.println(blog);
		this.blogServiceImpl.insertBlog(blog);
//		Blog test = new Blog();
//		test.setTitle("ª∆“Ì");
//		test.setContent("±øµ∞");
//		test.setOwner("ning");
//		this.blogServiceImpl.insertBlog(test);
		System.out.println(blog);
		return blog;
	}
	@RequestMapping(value = "/findAll")
	@ResponseBody 
	public List<Blog> findAll(){
		return this.blogServiceImpl.find();
	}
	
	@RequestMapping(value="/find/{id}")
	@ResponseBody 
	public Blog findBlog(@PathVariable("id") int id){
		Blog blog = this.blogServiceImpl.find(id);
		System.out.println("find blog: "+blog);
		return blog;
	}
}
