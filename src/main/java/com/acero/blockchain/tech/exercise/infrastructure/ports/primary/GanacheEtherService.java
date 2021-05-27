package com.acero.blockchain.tech.exercise.infrastructure.ports.primary;

import com.acero.blockchain.tech.exercise.domain.ports.primary.EtherService;
import com.acero.blockchain.tech.exercise.domain.ports.secondary.EtherRepository;
import com.acero.blockchain.tech.exercise.domain.transactions.TransactionState;
import com.acero.blockchain.tech.exercise.application.rest.usecase.sendether.SendInfo;
import com.acero.blockchain.tech.exercise.domain.transactions.EtherTransaction;
import com.acero.blockchain.tech.exercise.infrastructure.transactions.SendInfoAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;

@Component
public class GanacheEtherService implements EtherService {

    @Autowired
    private SendInfoAdapter sendInfoAdapter;
    @Autowired
    private EtherRepository etherRepository;

    @Override
    public TransactionState send(SendInfo sendInfo) {
        EtherTransaction etherTransaction = sendInfoAdapter.adapt(sendInfo);
        return etherRepository.sendEth(etherTransaction);
    }

    @Override
    public BigDecimal obtainEthBalance(String account) {
        return etherRepository.obtainEthBalance(account);
    }
}
