package com.sample.sb3.utils;

public class StringUtil {
    private static final String COMMA = ",";
    private static final String FORWARDS = "/";
    private static final String BACKWARDS = "\\";
    private static final String DASH = "-";
    private static final int INDEXLEN = 10;
    public static String cleanStr(String str) {
        if (str != null){
            str = str.trim();

            while(str.endsWith(FORWARDS) || str.endsWith("``") || str.endsWith(BACKWARDS)) {
                str = str.substring(0, str.length() - 1).trim();
            }
        }
        return str;
    }

//    public static void parseCheckNumberPrefix1(String textStr, TransactionDetail transactionDetail) {
//        String routingNumber = textStr.replace(TextPrefix.PREFIX_1.getStr(), "");
//        if (routingNumber.contains(COMMA)) {
//            routingNumber = routingNumber.substring(0, routingNumber.indexOf(COMMA));
//        }
//        routingNumber = getRoutingNumber(routingNumber);
//        setRoutingAndCheckNumbers(routingNumber, transactionDetail);
//    }

    private static String getRoutingNumber(String str) {
        if (str.contains(BACKWARDS)) {
            str = str.substring(0, str.indexOf(BACKWARDS)).trim();
        }
        if (str.contains(DASH)) {
            str = str.substring(0, str.indexOf(DASH)).trim();
        }

        return str;
    }

//    private static void setRoutingAndCheckNumbers(String routingNumber, TransactionDetail transactionDetail) {
//        //Situational, depending on pattern
//        String routingNum = routingNumber, checkNum = routingNumber,
//                tempNum1 = "";
//        int rtNumLen = routingNum.length();
//
//        //Clean routing number
//        if (rtNumLen >= INDEXLEN) {
//            tempNum1 = routingNum.substring(rtNumLen - INDEXLEN);
//        }
//
//        if (routingNum.endsWith("AAA")) {
//            tempNum1 = routingNum.substring(routingNum.length() - INDEXLEN);
//            routingNum = routingNum.substring(routingNum.length() - INDEXLEN);
//            checkNum = checkNum.substring(0, checkNum.indexOf(routingNum));
//        }
//        //Get check number
//        checkNum = checkNum.substring(0, checkNum.indexOf(routingNum));
//
//        transactionDetail.setPayerRoutingNumber(routingNumber);
//        transactionDetail.setCheckNumber(checkNum);
//    }
//
//    public static void parseCheckNumberPrefix2(String textStr, TransactionDetail transactionDetail) {
//        String newTxt = textStr.replace(TextPrefix.PREFIX_2.getStr(), "");
//        if (newTxt.contains(COMMA)) {
//            newTxt = newTxt.substring(0, newTxt.indexOf(COMMA));
//        } else if (newTxt.contains("*")) {
//            newTxt = newTxt.substring(0, newTxt.indexOf("*"));        }
//
//        String[] fields = newTxt.split("[*]");
//        String checkNumber = fields[0];
//        transactionDetail.setCheckNumber(checkNumber);
//    }
//
//    public static void parseCheckNumberByPrefix(String textStr, String prefix, TransactionDetail transactionDetail) {
//        //Common prefix with no extra work
//        String newTxt = textStr.replace(prefix, "");
//        if (newTxt.contains(COMMA)) {
//            newTxt = newTxt.substring(0, newTxt.indexOf(COMMA));
//        }
//        String[] fields = newTxt.split("[*]");
//        String checkNumber = fields[0];
//        transactionDetail.setCheckNumber(checkNumber);
//    }
}
