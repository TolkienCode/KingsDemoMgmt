package org.kingsdemo.kdmgmt.controller;

import java.util.List;

import org.kingsdemo.kdmgmt.cargo.model.Cargo;
import org.kingsdemo.kdmgmt.cargo.model.CargoImage;
import org.kingsdemo.kdmgmt.cargo.service.CargoImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Root resource (exposed at "cargo" path)
 */
@RestController
public class CargoImageController {
	
	@Autowired
	private CargoImageService cargoImageService;
	
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	@RequestMapping("/api/cargo/{id}/images")
    public List<CargoImage> getCargoImageByCargoId(@PathVariable("id") Long cargoId) {
    	return cargoImageService.getCargoImageByCargo(cargoId);
    }
    
	@RequestMapping("/api/cargo/{cargoId}/images/{id}")
    public CargoImage getCargoImage(@PathVariable("id") Long imageId) {
    	return cargoImageService.getCargoImage(imageId);
    }
    
	@RequestMapping(method=RequestMethod.POST, value="/api/cargo/{cargoId}/images")
    public void addCargoImage(@RequestBody CargoImage cargoImage, @PathVariable("cargoId") Long cargoId) {
		cargoImage.setCargo(new Cargo("", cargoId, 0.00F, ""));
		cargoImageService.insertCargoImage(cargoImage);
    }
    
	@RequestMapping(method=RequestMethod.PUT, value="/api/cargo/{cargoId}/images/{id}")
    public void updateCargoImage(@RequestBody CargoImage cargoImage, @PathVariable("cargoId") Long cargoId, @PathVariable("id") Long id) {
		cargoImage.setCargo(new Cargo("", cargoId, 0.00F, ""));
		cargoImageService.updateCargoImage(cargoImage);
    }
	
	@RequestMapping(method=RequestMethod.DELETE, value="/api/cargo/{cargoId}/images/{id}")
	public void deleteCargoImage(@PathVariable("id") Long id) {
		cargoImageService.deleteCargo(id);
	}
}
