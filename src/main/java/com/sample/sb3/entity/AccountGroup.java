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
@Table(name="AccountGroup", schema = "dbo", catalog = "BAIETL")
public class AccountGroup implements java.io.Serializable {

    private Integer id;
    private Record recordByTrailerRecordId;
    private BankFile bankFile;
    private Record recordByHeaderRecordId;
    private String senderId;
    private String receiverId;
    private String statusCode;
    private Date senderDateTime;
    private Integer dateModifier;
    private BigDecimal groupTotalAmount;
    private Integer accountCount;
    private Date createdTimestamp;
    private Date lastModifiedTimestamp;
    private Set<Account> accounts = new HashSet<>(0);

    public AccountGroup() {}

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
    @JoinColumn(name="TrailerRecordId")
    public Record getRecordByTrailerRecordId() {
        return recordByTrailerRecordId;
    }

    public void setRecordByTrailerRecordId(Record recordByTrailerRecordId) {
        this.recordByTrailerRecordId = recordByTrailerRecordId;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="BaiFileId", nullable = false)
    public BankFile getBaiFile() {
        return bankFile;
    }

    public void setBaiFile(BankFile bankFile) {
        this.bankFile = bankFile;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="HeaderRecordId")
    public Record getRecordByHeaderRecordId() {
        return recordByHeaderRecordId;
    }

    public void setRecordByHeaderRecordId(Record recordByHeaderRecordId) {
        this.recordByHeaderRecordId = recordByHeaderRecordId;
    }

    @Column(name = "SenderId", nullable = false, length = 50)
    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }


    @Column(name = "ReceiverId", nullable = false, length = 50)
    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }


    @Column(name = "StatusCode", nullable = false, length = 50)
    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="SenderDateTime", length = 27)
    public Date getSenderDateTime() {
        return senderDateTime;
    }

    public void setSenderDateTime(Date senderDateTime) {
        this.senderDateTime = senderDateTime;
    }

    @Column(name="DateModifier")
    public Integer getDateModifier() {
        return dateModifier;
    }

    public void setDateModifier(Integer dateModifier) {
        this.dateModifier = dateModifier;
    }

    @Column(name="GroupTotalAmount", nullable = false, precision = 12)
    public BigDecimal getGroupTotalAmount() {
        return groupTotalAmount;
    }

    public void setGroupTotalAmount(BigDecimal groupTotalAmount) {
        this.groupTotalAmount = groupTotalAmount;
    }

    @Column(name="AccountCount", nullable = false)
    public Integer getAccountCount() {
        return accountCount;
    }

    public void setAccountCount(Integer accountCount) {
        this.accountCount = accountCount;
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "accountGroup")
    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
}
