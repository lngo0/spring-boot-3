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

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="FileStatus", schema = "dbo", catalog = "BAIETL")
public class FileStatus implements java.io.Serializable {
    private Integer id;
    private String status;
    private Set<BankFile> bankFiles = new HashSet<>(0);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="Status", length = 16)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "fileStatus")
    public Set<BankFile> getBaiFiles() {
        return bankFiles;
    }

    public void setBaiFiles(Set<BankFile> bankFiles) {
        this.bankFiles = bankFiles;
    }
}
