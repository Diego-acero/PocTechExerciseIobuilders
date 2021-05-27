package com.acero.blockchain.tech.exercise.application.rest.usecase.obtainbalance;


import java.math.BigDecimal;

public class ObtainBalanceResponseModel {

    private BigDecimal balance;

    public ObtainBalanceResponseModel(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }


}
