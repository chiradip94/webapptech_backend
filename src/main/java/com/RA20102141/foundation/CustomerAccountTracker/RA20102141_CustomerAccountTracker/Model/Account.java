package com.RA20102141.foundation.CustomerAccountTracker.RA20102141_CustomerAccountTracker.Model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@Table
public class Account
{
    @Id
    private Long accNo;
    private String IFSCCode;
    private String bank;
    private double balance;
    private double interst;
}