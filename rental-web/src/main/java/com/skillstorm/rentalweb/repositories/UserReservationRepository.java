package com.skillstorm.rentalweb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.skillstorm.rentalweb.models.UserReservation;

@Repository
public interface UserReservationRepository extends CrudRepository<UserReservation, Integer>{
	List<UserReservation> deleteById(int id);
	
	@Query(value="Select license from userreservations WHERE license in (:cars) AND NOT((r_start BETWEEN :sDate AND :eDate) OR (r_end BETWEEN :sDate AND :eDate) OR (r_start <= :sDate AND r_end >= :eDate))",
			nativeQuery = true)
	List<String> filterCarsByDateRange(@Param("cars") List<String> cars, @Param("sDate") int startDate, @Param("eDate") int endDate);	
	
	@Query(value="select license from car where license not in (select license from userreservations where license in(:licenses))and license in (:licenses)",
			nativeQuery=true)
	List<String> getUnreservedCars(@Param("licenses") List<String> licenses);
}
