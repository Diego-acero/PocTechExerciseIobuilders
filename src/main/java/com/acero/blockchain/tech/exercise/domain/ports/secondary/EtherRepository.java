package com.acero.blockchain.tech.exercise.domain.ports.secondary;

import com.acero.blockchain.tech.exercise.domain.transactions.TransactionState;
import com.acero.blockchain.tech.exercise.domain.transactions.EtherTransaction;

import java.math.BigDecimal;

public interface EtherRepository {
    TransactionState sendEth(EtherTransaction etherTransaction);

    BigDecimal obtainEthBalance(String account);
}
