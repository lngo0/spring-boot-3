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

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Record", schema = "dbo", catalog = "BAIETL")
public class LineRecord implements java.io.Serializable {

    private Integer id;
    private BankFile bankFile;
    private Integer lineNumber;
    private String recordCode;
    private String recordTxt;
    private Date createdTimestamp;
    private Date lastModifiedTimestamp;
    private Set<Account> accountsForTrailerRecordId = new HashSet<>(0);
    private Set<TransactionDetail> transactionDetails = new HashSet<>(0);
    private Set<AccountGroup> accountGroupsForTrailerRecordId = new HashSet<>(0);
    private Set<Account> accountsForHeaderRecordId = new HashSet<>(0);
    private Set<AccountGroup> accountGroupsForHeaderRecordId = new HashSet<>(0);

    public LineRecord() {}

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
    @JoinColumn(name="BankId", nullable = false)
    public BankFile getBaiFile() {
        return bankFile;
    }

    public void setBaiFile(BankFile bankFile) {
        this.bankFile = bankFile;
    }

    @Column(name="LineNumber", nullable = false)
    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Column(name="RecordCode", nullable = false, length = 3)
    public String getRecordCode() {
        return recordCode;
    }

    public void setRecordCode(String recordCode) {
        this.recordCode = recordCode;
    }

    @Column(name="RecordTxt", nullable = false, length = 8000)
    public String getRecordTxt() {
        return recordTxt;
    }

    public void setRecordTxt(String recordTxt) {
        this.recordTxt = recordTxt;
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
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "recordByTrailerRecordId")
    public Set<Account> getAccountsForTrailerRecordId() {
        return accountsForTrailerRecordId;
    }

    public void setAccountsForTrailerRecordId(Set<Account> accountsForTrailerRecordId) {
        this.accountsForTrailerRecordId = accountsForTrailerRecordId;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "record")
    public Set<TransactionDetail> getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(Set<TransactionDetail> transactionDetails) {
        this.transactionDetails = transactionDetails;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "recordByTrailerRecordId")
    public Set<AccountGroup> getAccountGroupsForTrailerRecordId() {
        return accountGroupsForTrailerRecordId;
    }

    public void setAccountGroupsForTrailerRecordId(Set<AccountGroup> accountGroupsForTrailerRecordId) {
        this.accountGroupsForTrailerRecordId = accountGroupsForTrailerRecordId;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "recordByHeaderRecordId")
    public Set<Account> getAccountsForHeaderRecordId() {
        return accountsForHeaderRecordId;
    }

    public void setAccountsForHeaderRecordId(Set<Account> accountsForHeaderRecordId) {
        this.accountsForHeaderRecordId = accountsForHeaderRecordId;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "recordByHeaderRecordId")
    public Set<AccountGroup> getAccountGroupsForHeaderRecordId() {
        return accountGroupsForHeaderRecordId;
    }

    public void setAccountGroupsForHeaderRecordId(Set<AccountGroup> accountGroupsForHeaderRecordId) {
        this.accountGroupsForHeaderRecordId = accountGroupsForHeaderRecordId;
    }
}
