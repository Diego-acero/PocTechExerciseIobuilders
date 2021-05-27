package com.acero.blockchain.tech.exercise.domain.transactions;

public class EtherTransactionFixture {

    public static EtherTransaction correctEtherTransactionInfo()
    {
        return new EtherTransaction(2, "xxx032");
    }

    public static EtherTransaction emptyEtherTransactionInfo()
    {
        return new EtherTransaction(0, null);
    }

    public static EtherTransaction emptyCuantityEtherTransactionInfo()
    {
        return new EtherTransaction(0, "xxx032");
    }

    public static EtherTransaction emptyReceiverEtherTransactionInfo()
    {
        return new EtherTransaction(2, null);
    }
}