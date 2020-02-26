package com.annchar.sealedclassesdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.paymentData.observe(this, Observer<Payment> {
            bindDataToView(it)
        })
    }

    private fun bindDataToView(payment: Payment) {
        textview_payment_data.text = getPaymentDetailToString(payment)
    }

    private fun getPaymentDetailToString(payment: Payment): String {
        return when (payment) {
            is Payment.CreditCard ->
                "Credit Card \nName: ${payment.name} \nCard Number: ${payment.number} \nExpired Date: ${payment.expiredDate} \nTransfer Amount: ${payment.transferAmount}"
            is Payment.CashBank ->
                "Cash Bank \nBank Code: ${payment.bankCode} \nBank Name: ${payment.bankName} \nTransfer Amount: ${payment.transferAmount}"
            is Payment.Promptpay ->
                "Promptpay \nName: ${payment.name} \nCitizen Id: ${payment.citizenId} \nMobile Number: ${payment.mobileNumber} \nTransfer Amount: ${payment.transferAmount}"
            Payment.NonePayment -> "None Payment"
        }
    }
}
