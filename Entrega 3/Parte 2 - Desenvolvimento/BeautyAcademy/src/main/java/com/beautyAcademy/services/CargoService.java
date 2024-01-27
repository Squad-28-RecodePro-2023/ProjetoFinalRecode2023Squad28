package com.beautyAcademy.services;

import com.beautyAcademy.entities.Cargo;
import com.beautyAcademy.repositories.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoService {

	private final CargoRepository cargoRepository;

	@Autowired
	public CargoService(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}

	public List<Cargo> getAllCargos() {
		return cargoRepository.findAll();
	}

	public Cargo getCargoById(int id) {
		Optional<Cargo> optionalCargo = cargoRepository.findById(id);
		return optionalCargo.orElse(null);
	}

	public Cargo createCargo(Cargo cargo) {
		return cargoRepository.save(cargo);
	}

	public Cargo updateCargo(int id, Cargo cargo) {
		Optional<Cargo> optionalCargo = cargoRepository.findById(id);
		if (optionalCargo.isPresent()) {
			Cargo existingCargo = optionalCargo.get();
			existingCargo.setNome(cargo.getNome());
			return cargoRepository.save(existingCargo);
		} else {
			return null;
		}
	}

	public void deleteCargo(int id) {
		cargoRepository.deleteById(id);
	}
}
