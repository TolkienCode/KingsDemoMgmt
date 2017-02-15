package org.kingsdemo.kdmgmt.cargo.service;

import java.util.ArrayList;
import java.util.List;

import org.kingsdemo.kdmgmt.cargo.model.Cargo;
import org.kingsdemo.kdmgmt.cargo.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CargoService {
	
	@Autowired
	private CargoRepository cargoRepository;
	
	public Cargo getCargo(Long id) {
		return cargoRepository.findOne(id);
	}
	
	public List<Cargo> getAllCargos() {
		List<Cargo> cargos = new ArrayList<>();
		cargoRepository.findAll().forEach(cargos::add);
		return cargos;
	}
	
	public void insertCargo(Cargo cargo) {
		cargoRepository.save(cargo);
	}
	
	public void deleteCargo(Long id) {
		cargoRepository.delete(id);
	}
	
	public void updateCargo(Cargo cargo) {
		cargoRepository.save(cargo);
	}
}
