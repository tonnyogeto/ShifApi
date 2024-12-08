package com.splash.shifapi.userpaymentplan.dao;

import com.splash.shifapi.userpaymentplan.model.UserPaymentPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPaymentPlanDao extends JpaRepository<UserPaymentPlan,Integer> {
}
