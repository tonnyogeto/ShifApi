package com.splash.ShifApi.claims.dao;

import com.splash.ShifApi.claims.model.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimDao extends JpaRepository<Claim, Integer> {
}
