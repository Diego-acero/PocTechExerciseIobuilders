package com.acero.blockchain.tech.exercise.infrastructure.transactions;

import com.acero.blockchain.tech.exercise.domain.transactions.EtherTransaction;
import com.acero.blockchain.tech.exercise.application.rest.usecase.sendether.SendInfo;
import org.springframework.stereotype.Component;

@Component
public class SendInfoAdapter {
    public EtherTransaction adapt(SendInfo sendInfo)
    {
        return new EtherTransaction(sendInfo.getAmount(), sendInfo.getReceiverWallet());
    }
}
