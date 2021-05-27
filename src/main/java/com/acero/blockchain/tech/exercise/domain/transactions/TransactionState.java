package com.acero.blockchain.tech.exercise.domain.transactions;

public class TransactionState {
    private String state;

    public TransactionState(String state) {
        this.state = state;
    }

    public String getState()
    {
        return state;
    }
}
