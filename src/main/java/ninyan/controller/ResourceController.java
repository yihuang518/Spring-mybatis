package ninyan.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import ninyan.entities.Resource;

@Controller
@SessionAttributes("resource")
@RequestMapping("/resource")
public class ResourceController {

	@ModelAttribute("resource")
	public Resource getResource() {
		System.out.println("create resource");
		return new Resource();
	}

	@ModelAttribute("typeOptions")
	public List<String> getTypeOptions() {
		System.out.println("create typeOptions");
		return new LinkedList<String>(Arrays.asList(new String[] { "A", "B", "C" }));
	}

	@ModelAttribute("radioOptions")
	public List<String> getRadioOptions() {
		System.out.println("create radioOptions");
		return new LinkedList<String>(Arrays.asList(new String[] { "A", "B", "C" }));
	}

	@ModelAttribute("checkOptions")
	public List<String> getCheckOptions() {
		System.out.println("create checkOptions");
		return new LinkedList<String>(Arrays.asList(new String[] { "A", "B", "C" }));
	}

	@RequestMapping(value = "/add")
	public String addResource(Model model) {
		return "resource_add";
	}
	
	@RequestMapping(value = "/upload", method=RequestMethod.POST)
	@ResponseBody
	public String handleUpload(@RequestParam("file") MultipartFile file) {
		if(!file.isEmpty()){
			System.out.println("The file size is " + file.getSize());
			
			
			
			File destFile = new File("D:/springSavedFile");
			try {
				file.transferTo(destFile);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//			if(!destFile.exists())
//				destFile.createNewFile();
//			FileChannel sourceChannel = null;
//			FileChannel descChannel = null;
//			
//			try {
//				sourceChannel = new FileInputStream(file).getChannel();
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			return "The file size is " + file.getSize();
		}else{
			return "There's a problem";
		}
	}

	@RequestMapping(value = "/save")
	public String saveResource(Model model, @ModelAttribute Resource resource, SessionStatus status) {
		System.out.println(resource);
		status.setComplete();
		return "redirect:/resource/add";
	}
	
	@RequestMapping(value = "/find")
	public String find(Model model) {
		Resource rc = new Resource();
		rc.setDate(new Date());
		rc.setName("ning");
		model.addAttribute("resource", rc);
		return "resources";
	}

	@RequestMapping(value = "/request")
	@ResponseBody
	public String request(@ModelAttribute("resource") Resource resource) {
		System.out.println(resource);
		return "The request has been sent for approval";
	}

	@ExceptionHandler(NullPointerException.class)
	public String handleError(HttpServletRequest request) {
		return "controller_error";
	}
}
