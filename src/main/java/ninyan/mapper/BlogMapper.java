package ninyan.mapper;
import java.util.List;

import org.springframework.stereotype.Component;

import ninyan.entities.Blog;

public interface BlogMapper {
 
    public Blog selectBlog(int id);
   
    public void insertBlog(Blog blog);
   
    public void updateBlog(Blog blog);
   
    public void deleteBlog(int id);
   
    public List<Blog> selectAll();
   
}