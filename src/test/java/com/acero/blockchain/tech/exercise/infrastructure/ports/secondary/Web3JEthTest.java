package com.acero.blockchain.tech.exercise.infrastructure.ports.secondary;

import com.acero.blockchain.tech.exercise.domain.transactions.EtherTransaction;
import com.acero.blockchain.tech.exercise.domain.transactions.EtherTransactionFixture;
import com.acero.blockchain.tech.exercise.infrastructure.transactions.TransactionReceipFixture;
import com.acero.blockchain.tech.exercise.infrastructure.transactions.TransferWrapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class Web3JEthTest {

    public static final String ERROR = "ERROR";
    @Mock
    private TransferWrapper transferWrapper;

    @InjectMocks
    private Web3JEth web3JEth;

    @Test
    public void verifyCorrentEtherTransaction() throws Exception
    {
        EtherTransaction etherTransaction = EtherTransactionFixture.correctEtherTransactionInfo();

        when(transferWrapper.send(etherTransaction.getReceiver(), etherTransaction.getCuantity())).thenReturn(TransactionReceipFixture.correctReceip());

        assertEquals("OK", web3JEth.sendEth(etherTransaction).getState());
    }

    @Test
    public void verifyTransactionFailed() throws Exception
    {
        EtherTransaction etherTransaction = EtherTransactionFixture.correctEtherTransactionInfo();

        when(transferWrapper.send(etherTransaction.getReceiver(), etherTransaction.getCuantity())).thenThrow(new Exception("Failed transaction"));

        assertEquals(ERROR, web3JEth.sendEth(etherTransaction).getState());
    }

    @Test
    public void verifyNoReceiver()
    {
        EtherTransaction etherTransaction = EtherTransactionFixture.emptyReceiverEtherTransactionInfo();
        assertEquals(ERROR, web3JEth.sendEth(etherTransaction).getState());
    }

    @Test
    public void verifyNoAmount()
    {
        EtherTransaction etherTransaction = EtherTransactionFixture.emptyCuantityEtherTransactionInfo();
        assertEquals(ERROR, web3JEth.sendEth(etherTransaction).getState());
    }
}