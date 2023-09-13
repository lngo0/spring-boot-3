package com.sample.sb3.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Bank", schema = "dbo", catalog = "BAIETL")
public class Bank implements java.io.Serializable {


    private Integer id;
    private String bankNumber;
    private String bankName;
    private boolean active;
    private Date createdTimestamp;
    private Date lastModifiedTimestamp;
    private Set<BankFile> bankFiles = new HashSet<>(0);

    public Bank() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="BankNumber", nullable = false, length = 50)
    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    @Column(name="BankName", nullable = false, length = 50)
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Column(name="Active", nullable = false)
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "bank")
    public Set<BankFile> getBaiFiles() {
        return bankFiles;
    }

    public void setBaiFiles(Set<BankFile> bankFiles) {
        this.bankFiles = bankFiles;
    }
}
