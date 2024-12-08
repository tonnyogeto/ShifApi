package com.splash.shifapi.hospitalvisits.dao;

import com.splash.shifapi.hospitalvisits.model.HospitalVisit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalVisitDao extends JpaRepository<HospitalVisit, Integer> {
}
