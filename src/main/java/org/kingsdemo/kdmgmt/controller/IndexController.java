package org.kingsdemo.kdmgmt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.kingsdemo.kdmgmt.cargo.model.Cargo;
import org.kingsdemo.kdmgmt.cargo.model.CargoImage;
import org.kingsdemo.kdmgmt.cargo.service.CargoImageService;
import org.kingsdemo.kdmgmt.cargo.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@Autowired
	private CargoService cargoService;
	
	@Autowired
	private CargoImageService cargoImageService;
	
	@RequestMapping(value="/newcargo", method=RequestMethod.GET)
	public String indexForm() {
		return "newcargo";
	}
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public ModelAndView indexPage() {
		List<Cargo> cs = cargoService.getAllCargos();
		ModelAndView modelAndView = new ModelAndView("index");
	    modelAndView.addObject("cargos", cs);
		return modelAndView;
	}
	
	@RequestMapping(value="/newcargo", method=RequestMethod.POST)
	public ModelAndView index(HttpServletRequest request) {
		String description = request.getParameter("description");
		String category = request.getParameter("category");
		String price = request.getParameter("price");
		String imageURL = "http://"; // request.getParameter("imageURL");
		
		Cargo c = new Cargo();
		c.setCategory(category);
		c.setDescription(description);
		c.setPrice(Float.parseFloat(price));
		
		Long cargoId = cargoService.insertCargo(c);
		
		CargoImage image = new CargoImage();
		image.setCargo(new Cargo("", cargoId, 0.00F, ""));
		image.setDescription("hard-coded image description");
		image.setImgURL(imageURL);
		
		Long imageId = cargoImageService.insertCargoImage(image);
		
		List<Cargo> cs = cargoService.getAllCargos();
		ModelAndView modelAndView = new ModelAndView("index");
	    modelAndView.addObject("cargos", cs);
	    modelAndView.addObject("message", "New Image Id: " + imageId.toString());
	    
		return modelAndView;
	}
}
