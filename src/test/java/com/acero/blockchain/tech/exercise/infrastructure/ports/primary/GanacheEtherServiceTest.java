package com.acero.blockchain.tech.exercise.infrastructure.ports.primary;

import com.acero.blockchain.tech.exercise.application.rest.usecase.sendether.SendInfo;
import com.acero.blockchain.tech.exercise.domain.transactions.EtherTransaction;
import com.acero.blockchain.tech.exercise.infrastructure.ports.secondary.Web3JEth;
import com.acero.blockchain.tech.exercise.infrastructure.transactions.SendInfoAdapter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static com.acero.blockchain.tech.exercise.application.rest.SendInfoFixture.*;
import static com.acero.blockchain.tech.exercise.domain.transactions.EtherTransactionFixture.*;
import static com.acero.blockchain.tech.exercise.domain.transactions.TransactionStateFixture.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GanacheEtherServiceTest {

    public static final String ERROR = "ERROR";
    @Mock
    private SendInfoAdapter sendInfoAdapter;

    @Mock
    private Web3JEth web3JEth;

    @InjectMocks
    private GanacheEtherService ganacheEtherSender;

    @Test
    public void verifyCorrectInfo() {
        SendInfo sendInfo = completeSendInfo();
        EtherTransaction etherTransaction = correctEtherTransactionInfo();

        when(sendInfoAdapter.adapt(sendInfo)).thenReturn(etherTransaction);
        when(web3JEth.sendEth(etherTransaction)).thenReturn(okState());

        assertEquals("OK", ganacheEtherSender.send(sendInfo).getState());
    }

    @Test
    public void verifyEmptyInfo() {
        SendInfo sendInfo = emptySendInfo();
        EtherTransaction etherTransaction = emptyEtherTransactionInfo();

        when(sendInfoAdapter.adapt(sendInfo)).thenReturn(etherTransaction);
        when(web3JEth.sendEth(etherTransaction)).thenReturn(errorState());

        assertEquals(ERROR, ganacheEtherSender.send(sendInfo).getState());
    }

    @Test
    public void verifyEmptyAmount() {
        SendInfo sendInfo = emptyAmountSendInfo();
        EtherTransaction etherTransaction = emptyCuantityEtherTransactionInfo();

        when(sendInfoAdapter.adapt(sendInfo)).thenReturn(etherTransaction);
        when(web3JEth.sendEth(etherTransaction)).thenReturn(errorState());

        assertEquals(ERROR, ganacheEtherSender.send(sendInfo).getState());
    }

    @Test
    public void verifyEmptyAdress() {
        SendInfo sendInfo = emptyAdressSendInfo();
        EtherTransaction etherTransaction = emptyReceiverEtherTransactionInfo();

        when(sendInfoAdapter.adapt(sendInfo)).thenReturn(etherTransaction);
        when(web3JEth.sendEth(etherTransaction)).thenReturn(errorState());

        assertEquals(ERROR, ganacheEtherSender.send(sendInfo).getState());
    }
}
