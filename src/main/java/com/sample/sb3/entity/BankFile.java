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
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name="BankFile", schema = "dbo", catalog = "BAIETL")
public class BankFile implements java.io.Serializable {

    private Integer id;
    private Bank bank;
    private  FileStatus fileStatus;
    private String fileName;
    private String senderId;
    private String receiverId;
    private Date fileCreationDateTime;
    private String senderFileId;
    private String recordLength;
    private BigDecimal totalAmount;
    private Integer accountGroupCount;
    private  String checkSum;
    private Date createdTimestamp;
    private Date lastModifiedTimestamp;
    private Set<AccountGroup> accountGroupset = new HashSet<>();
    private Set<Record> recordsset = new HashSet<>();

    public BankFile() {
    }
    public BankFile(FileStatus fileStatus, String fileName, String checkSum) {
        this.fileName = fileName;
        this.fileStatus = fileStatus;
        this.checkSum = checkSum;
    }

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
    @JoinColumn(name="BankId")
    public Bank getBank() {
        return this.bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Status", nullable = false)
    public FileStatus getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(FileStatus fileStatus) {
        this.fileStatus = fileStatus;
    }

    @Column(name="FileName", nullable = false, length = 100)
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Column(name="SenderId", length = 50)
    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    @Column(name="ReceiverId", length = 50)
    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="FileCreationDateTime", length = 27)
    public Date getFileCreationDateTime() {
        return fileCreationDateTime;
    }

    public void setFileCreationDateTime(Date fileCreationDateTime) {
        this.fileCreationDateTime = fileCreationDateTime;
    }

    @Column(name="SenderFileId", length = 50)
    public String getSenderFileId() {
        return senderFileId;
    }

    public void setSenderFileId(String senderFileId) {
        this.senderFileId = senderFileId;
    }

    @Column(name="RecordLength")
    public String getRecordLength() {
        return recordLength;
    }

    public void setRecordLength(String recordLength) {
        this.recordLength = recordLength;
    }
    @Column(name="FileTotalAmount", precision = 12)
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Column(name="AccountGroupCount")
    public Integer getAccountGroupCount() {
        return accountGroupCount;
    }

    public void setAccountGroupCount(Integer accountGroupCount) {
        this.accountGroupCount = accountGroupCount;
    }

    @Column(name="Checksum")
    public String getCheckSum() {
        return checkSum;
    }

    public void setCheckSum(String checkSum) {
        this.checkSum = checkSum;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CreatedTimestamp")
    public Date getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Date createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="LastModifiedTimestamp")
    public Date getLastModifiedTimestamp() {
        return lastModifiedTimestamp;
    }

    public void setLastModifiedTimestamp(Date lastModifiedTimestamp) {
        this.lastModifiedTimestamp = lastModifiedTimestamp;
    }
}
