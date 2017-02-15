package org.kingsdemo.kdmgmt.controller;

import java.util.List;

import org.kingsdemo.kdmgmt.cargo.model.Cargo;
import org.kingsdemo.kdmgmt.cargo.service.CargoService;
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
public class CargoController {
	
	@Autowired
	private CargoService stub;
	
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	@RequestMapping("/api/cargo")
    public List<Cargo> getAllCargos() {
    	return stub.getAllCargos();
    }
    
	@RequestMapping("/api/cargo/{cargoId}")
    public Cargo getCargo(@PathVariable("cargoId") Long cargoId) {
    	return stub.getCargo(cargoId);
    }
    
	@RequestMapping(method=RequestMethod.POST, value="/api/cargo")
    public void addCargo(@RequestBody Cargo cargo) {
    	stub.insertCargo(cargo);
    }
    
	@RequestMapping(method=RequestMethod.PUT, value="/api/cargo/{cargoId}")
    public void updateCargo(@RequestBody Cargo cargo, @PathVariable("cargoId") Long cargoId) {
		cargo.setId(cargoId);
    	stub.updateCargo(cargo);
    }
	
	@RequestMapping(method=RequestMethod.DELETE, value="/api/cargo/{cargoId}")
	public void deleteCargo(@PathVariable("cargoId") Long cargoId) {
		stub.deleteCargo(cargoId);
	}
}
