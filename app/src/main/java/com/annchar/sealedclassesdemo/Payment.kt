package com.annchar.sealedclassesdemo

sealed class Payment {
    data class CreditCard(
        val name: String,
        val number: String,
        val expiredDate: String,
        val transferAmount: Double
    ) : Payment()

    data class CashBank(
        val bankCode: String,
        val bankName: String,
        val transferAmount: Double
    ) : Payment()

    data class Promptpay(
        val name: String,
        val citizenId: String,
        val mobileNumber: String,
        val transferAmount: Double
    ) : Payment()

    object NonePayment : Payment()
}