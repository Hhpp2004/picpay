package com.example.picpay.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.*;

@Entity
@Table(name = "type_wallet")
public class Type_Wallet {
    public static final String Type_Enum_Str = null;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    public Type_Wallet() {
    }

    public Type_Wallet(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static enum Type_Enum {
        USER(1L, "user"),
        MERCHANT(2L, "merchant");

        private final Long id;
        private final String description;

        Type_Enum(Long id, String description) {
            this.id = id;
            this.description = description;
        }

        public Type_Wallet get() {
            return new Type_Wallet(this.id, this.description);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,description);
    }

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Type_Wallet that =(Type_Wallet)obj;
        return Objects.equals(id, that.id) && Objects.equals(description, that.description);
    }

}
