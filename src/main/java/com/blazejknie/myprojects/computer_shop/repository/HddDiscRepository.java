package com.blazejknie.myprojects.computer_shop.repository;

import com.blazejknie.myprojects.computer_shop.model.HddDisc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface HddDiscRepository extends JpaRepository<HddDisc,Long> {
}
