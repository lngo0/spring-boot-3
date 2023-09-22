package com.sample.sb3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="TransactionDetail", schema = "dbo", catalog = "BAIETL")
public class TransactionDetail implements java.io.Serializable {
    private Integer id;
    private TransactionType transactionType;
    private Account account;
    private LineRecord lineRecord;
    private BigDecimal amount;
    private String checkNumber;
    private Date checkDate;
    private Date depositDate;
    private String bankReferenceNumber;
    private String customerReferenceNumber;
    private String location;
    private String payerName;
    private String payerNumber;
    private String payerRoutingNumber;
    private String payerAccountNumber;
    private String paymentType;
    private String clientName;
    private String clientIdentifier;
    private String paymentNote;
    private String traceNumber;
    private String text;
    private String lockbox;
    private Date createdTimestamp;
    private Date lastModifiedTimestamp;

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
    @JoinColumn(name="TransactionTypeId", nullable = false)
    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="AccountId", nullable = false)
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="RecordId", nullable = false)
    public LineRecord getLineRecord() {
        return lineRecord;
    }

    public void setRecord(LineRecord lineRecord) {
        this.lineRecord = lineRecord;
    }

    @Column(name="Amount", nullable = false, precision = 12)
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Column(name="CheckNumber", length = 50)
    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="CheckDate", length = 10)
    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="DepositDate", length = 10)
    public Date getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(Date depositDate) {
        this.depositDate = depositDate;
    }

    @Column(name="BankReferenceNumber", length = 50)
    public String getBankReferenceNumber() {
        return bankReferenceNumber;
    }

    public void setBankReferenceNumber(String bankReferenceNumber) {
        this.bankReferenceNumber = bankReferenceNumber;
    }

    @Column(name="CustomerReferenceNumber", length = 50)
    public String getCustomerReferenceNumber() {
        return customerReferenceNumber;
    }

    public void setCustomerReferenceNumber(String customerReferenceNumber) {
        this.customerReferenceNumber = customerReferenceNumber;
    }

    @Column(name="CustomerReferenceNumber", length = 50)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name="CustomerReferenceNumber", length = 50)
    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    @Column(name="CustomerReferenceNumber", length = 50)
    public String getPayerNumber() {
        return payerNumber;
    }

    public void setPayerNumber(String payerNumber) {
        this.payerNumber = payerNumber;
    }

    @Column(name="PayerRoutingNumber", length = 50)
    public String getPayerRoutingNumber() {
        return payerRoutingNumber;
    }

    public void setPayerRoutingNumber(String payerRoutingNumber) {
        this.payerRoutingNumber = payerRoutingNumber;
    }

    @Column(name="PayerAccountNumber", length = 50)
    public String getPayerAccountNumber() {
        return payerAccountNumber;
    }

    public void setPayerAccountNumber(String payerAccountNumber) {
        this.payerAccountNumber = payerAccountNumber;
    }

    @Column(name="PaymentTye", length = 50)
    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Column(name="ClientName", length = 50)
    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Column(name="ClientIdentifier", length = 50)
    public String getClientIdentifier() {
        return clientIdentifier;
    }

    public void setClientIdentifier(String clientIdentifier) {
        this.clientIdentifier = clientIdentifier;
    }

    @Column(name="PaymentNote", length = 100)
    public String getPaymentNote() {
        return paymentNote;
    }

    public void setPaymentNote(String paymentNote) {
        this.paymentNote = paymentNote;
    }

    @Column(name="TraceNumber", length = 50)
    public String getTraceNumber() {
        return traceNumber;
    }

    public void setTraceNumber(String traceNumber) {
        this.traceNumber = traceNumber;
    }

    @Column(name="Text", length = 8000)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Column(name="Lockbox", length = 30)
    public String getLockbox() {
        return lockbox;
    }

    public void setLockbox(String lockbox) {
        this.lockbox = lockbox;
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
