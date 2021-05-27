package com.acero.blockchain.tech.exercise.domain.ports.primary;

import com.acero.blockchain.tech.exercise.domain.transactions.TransactionState;
import com.acero.blockchain.tech.exercise.application.rest.usecase.sendether.SendInfo;

import java.math.BigDecimal;

public interface EtherService {
    TransactionState send(SendInfo sendInfo);

    BigDecimal obtainEthBalance(String account);
}
