package com.annchar.sealedclassesdemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _paymentData = MutableLiveData<Payment>()
    val paymentData = _paymentData

    private val paymentByCreditCardData: Payment = Payment.CreditCard(
        name = "AnnChar",
        number = "123456789123",
        expiredDate = "02/23",
        transferAmount = 100.50
    )

    private val paymentByCashBankData: Payment = Payment.CashBank(
        bankCode = "101",
        bankName = "bank",
        transferAmount = 202.20
    )

    private val paymentByPromptpayData: Payment = Payment.Promptpay(
        name = "AnnChar",
        citizenId = "1234567891234",
        mobileNumber = "0891234567",
        transferAmount = 8002.50
    )

    private val nonePaymentData: Payment = Payment.NonePayment

    init {
        // Choose data to set payment data
        setPaymentData(paymentByCreditCardData)
    }

    private fun setPaymentData(payment: Payment) {
        _paymentData.value = payment
    }
}