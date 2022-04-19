package com.project.parkinglot.entity.vehicle;

import com.project.parkinglot.controller.vehicle.VehicleEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "vehicle")
@Table(name = "vehicle")
@Getter
@Setter
//TODO define inheritance
public class VehicleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String licensePlate;

	@Enumerated(EnumType.STRING)
	private VehicleEnum vehicleEnum;

	@Column(nullable = false)
	private LocalDateTime checkIn;

	@Column(nullable = false)
	private LocalDateTime checkOut;

	@Column(nullable = false)
	private long parkingAreaId;

	
	//TODO getters setters
}
