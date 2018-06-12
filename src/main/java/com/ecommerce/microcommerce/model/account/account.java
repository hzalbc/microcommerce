package com.ecommerce.microcommerce.model.account;

import javax.persistence.*;
import com.ecommerce.microcommerce.model.kpi.kpialpha;

@Entity
@Table(name = "account")

public class account {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer accountId;

    public String accountCode;
    public String accountDescription;

    public account(){

    }

    public account(String accountCode, String accountDescription) {
        this.accountCode = accountCode;
        this.accountDescription = accountDescription;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getAccountDescription() {
        return accountDescription;
    }

    public void setAccountDescription(String accountDescription) {
        this.accountDescription = accountDescription;
    }
}
