package com.acero.blockchain.tech.exercise.infrastructure.transactions;

import com.acero.blockchain.tech.exercise.application.rest.SendInfoFixture;
import com.acero.blockchain.tech.exercise.domain.transactions.EtherTransactionFixture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SendInfoAdapterTest {

    private final SendInfoAdapter sendInfoAdapter = new SendInfoAdapter();

    @Test
    public void verifyCompleteSendInfo()
    {
        assertEquals(EtherTransactionFixture.correctEtherTransactionInfo(), sendInfoAdapter.adapt(SendInfoFixture.completeSendInfo()));
    }

    @Test
    public void verifyNoReceiver()
    {
        assertEquals(EtherTransactionFixture.emptyReceiverEtherTransactionInfo(), sendInfoAdapter.adapt(SendInfoFixture.emptyAdressSendInfo()));
    }

}