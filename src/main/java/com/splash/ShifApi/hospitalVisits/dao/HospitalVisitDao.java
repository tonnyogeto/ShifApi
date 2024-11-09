package com.splash.ShifApi.hospitalVisits.dao;

import com.splash.ShifApi.hospitalVisits.model.HospitalVisit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalVisitDao extends JpaRepository<HospitalVisit, Integer> {
}
