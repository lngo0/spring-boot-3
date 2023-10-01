package com.sample.sb3.constant;

public enum BankConstants {
    BANK_SAMPLE("Bank Routing Number")
    ;
    private String bankNum;
    BankConstants(String  bankNum) {
        this.bankNum = bankNum;
    }

    public String getBankNum() {
        return bankNum;
    }
}
