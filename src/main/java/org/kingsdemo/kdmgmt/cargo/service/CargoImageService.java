package org.kingsdemo.kdmgmt.cargo.service;

import java.util.List;

import org.kingsdemo.kdmgmt.cargo.model.CargoImage;
import org.kingsdemo.kdmgmt.cargo.repository.CargoImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CargoImageService {
	
	@Autowired
	private CargoImageRepository cargoImageRepository;
	
	public CargoImage getCargoImage(Long id) {
		return cargoImageRepository.findOne(id);
	}
	
	public List<CargoImage> getCargoImageByCargo(Long cargoId) {
		return cargoImageRepository.findByCargoId(cargoId);
	}
	
	public Long insertCargoImage(CargoImage cargoImage) {
		CargoImage i = cargoImageRepository.save(cargoImage);
		return i.getId();
	}
	
	public void deleteCargo(Long id) {
		cargoImageRepository.delete(id);
	}
	
	public void updateCargoImage(CargoImage cargoImage) {
		cargoImageRepository.save(cargoImage);
	}
}
