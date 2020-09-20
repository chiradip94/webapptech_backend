package com.RA20102141.foundation.CustomerAccountTracker.RA20102141_CustomerAccountTracker.Repository;

import com.RA20102141.foundation.CustomerAccountTracker.RA20102141_CustomerAccountTracker.Model.Account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
    
}
