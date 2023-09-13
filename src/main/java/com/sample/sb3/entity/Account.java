package com.sample.sb3.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Account", schema = "dbo", catalog = "BAIETL")
public class Account implements java.io.Serializable {
    private Integer id;
    private Record recordByHeaderRecordId;
    private Record recordByTrailerRecordId;
    private AccountGroup accountGroup;
    private String accountNumber;
    private BigDecimal totalAmount;
    private Date createdTimestamp;
    private Date lastModifiedTimestamp;

    public Account(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="HeaderRecordId")
    public Record getRecordByHeaderRecordId() {
        return recordByHeaderRecordId;
    }

    public void setRecordByHeaderRecordId(Record recordByHeaderRecordId) {
        this.recordByHeaderRecordId = recordByHeaderRecordId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="TrailerRecordId")
    public Record getRecordByTrailerRecordId() {
        return recordByTrailerRecordId;
    }

    public void setRecordByTrailerRecordId(Record recordByTrailerRecordId) {
        this.recordByTrailerRecordId = recordByTrailerRecordId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="AccountGroupId", nullable = false)
    public AccountGroup getAccountGroup() {
        return accountGroup;
    }

    public void setAccountGroup(AccountGroup accountGroup) {
        this.accountGroup = accountGroup;
    }

    @Column(name = "AccountNumber", nullable = false, length = 50)
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Column(name="TotalAmount", nullable = false, precision = 12)
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CreatedTimestamp", length = 27)
    public Date getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Date createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="LastModifiedTimestamp", length = 27)
    public Date getLastModifiedTimestamp() {
        return lastModifiedTimestamp;
    }

    public void setLastModifiedTimestamp(Date lastModifiedTimestamp) {
        this.lastModifiedTimestamp = lastModifiedTimestamp;
    }

}
