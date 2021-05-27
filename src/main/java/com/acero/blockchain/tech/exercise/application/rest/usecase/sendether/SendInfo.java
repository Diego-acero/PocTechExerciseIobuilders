package com.acero.blockchain.tech.exercise.application.rest.usecase.sendether;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SendInfo {
    @JsonProperty("receiverWallet")
    private String receiverWallet;
    @JsonProperty("amount")
    private float amount;

    public String getReceiverWallet() {
        return receiverWallet;
    }

    public void setReceiverWallet(String receiverWallet) {
        this.receiverWallet = receiverWallet;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
