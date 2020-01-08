package com.blazejknie.myprojects.computer_shop.repository;

import com.blazejknie.myprojects.computer_shop.model.PowerSupply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PowerSupplyRepository extends JpaRepository<PowerSupply,Long> {
}
