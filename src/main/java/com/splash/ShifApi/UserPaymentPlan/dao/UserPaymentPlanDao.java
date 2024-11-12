package com.splash.ShifApi.UserPaymentPlan.dao;

import com.splash.ShifApi.UserPaymentPlan.model.UserPaymentPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPaymentPlanDao extends JpaRepository<UserPaymentPlan,Integer> {
}
