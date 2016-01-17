package ninyan.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ninyan.entities.Blog;
import ninyan.mapper.BlogMapper;

@Service
public class BlogServiceImpl {
	private Logger logger = LoggerFactory.getLogger(getClass());
    private BlogMapper blogMapper;
    @PostConstruct
    public void init(){
    	System.out.println("init function");
    }
    @PreDestroy
    public void close(){
    	System.out.println("close");
    }
    
    public void deleteBlog(int id) {
    	logger.debug("delete Blog By ID : " + id);
        blogMapper.deleteBlog(id);
    }
 
    public Blog find(int id) {
    	logger.debug("Select Blog By ID : " + id);
        return blogMapper.selectBlog(id);
    }
 
    public List<Blog> find() {
    	logger.debug("Select Blog list");
        List<Blog> list = blogMapper.selectAll();
    	System.out.println(list);
    	return list;
    }
 
    public void insertBlog(Blog blog) {
    	logger.debug("insert Blog: "+ blog);
        blogMapper.insertBlog(blog);
    }
 
    public void updateBlog(Blog blog) {
    	logger.debug("update Blog: "+ blog);
        blogMapper.updateBlog(blog);
    }
 
    public BlogMapper getBlogMapper() {
       return blogMapper;
    }
 
    @Resource
    public void setBlogMapper(BlogMapper blogMapper) {
       this.blogMapper = blogMapper;
    }
 
}