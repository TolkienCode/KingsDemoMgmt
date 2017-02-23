package org.kingsdemo.kdmgmt.cargo.repository;

import java.util.List;

import org.kingsdemo.kdmgmt.cargo.model.CargoImage;
import org.springframework.data.repository.CrudRepository;

public interface CargoImageRepository extends CrudRepository<CargoImage, Long> {

	public List<CargoImage> findByCargoId(Long cargoId);
}
