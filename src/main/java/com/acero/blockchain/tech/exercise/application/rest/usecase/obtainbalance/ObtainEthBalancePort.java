package com.acero.blockchain.tech.exercise.application.rest.usecase.obtainbalance;

public interface ObtainEthBalancePort {

    ObtainBalanceResponseModel obtainBalance(String account);
}
