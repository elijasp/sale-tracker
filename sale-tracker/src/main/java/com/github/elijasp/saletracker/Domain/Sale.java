package com.github.elijasp.saletracker.Domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Sale {
    // == fields ==
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message="sale identifier is required")
    @Min(value=4, message = "Minimum chars/letters: 4")
    @Max(value=6, message= "Maximum chars/letters: 5")
    @Column(updatable = false, unique = true)
    private String saleIdentifier;
    @NotBlank(message = "Seller name is required")
    private String sellerName;
    @NotBlank(message = "Buyer name is required")
    private String buyerName;
    @NotBlank(message = "Description is required")
    private String description;
    @NotNull(message = "Amount is required")
    private Double amount;
    @JsonFormat(pattern = "yyyy-MM-dd : HH:mm")
    private LocalDateTime saleDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // == constructor ==
    public Sale(){}

    // == prepersist and preupdate entry to db methods ==
    @PrePersist
    protected void createdAt(){
        this.createdAt = LocalDateTime.now();
    }
    @PreUpdate
    protected void updatedAt(){
        this.updatedAt = LocalDateTime.now();
    }

    // == getters and setters ==
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSaleIdentifier() {
        return saleIdentifier;
    }

    public void setSaleIdentifier(String saleIdentifier) {
        this.saleIdentifier = saleIdentifier;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
