package com.RA20102141.foundation.CustomerAccountTracker.RA20102141_CustomerAccountTracker.Repository;
import com.RA20102141.foundation.CustomerAccountTracker.RA20102141_CustomerAccountTracker.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>
{

}