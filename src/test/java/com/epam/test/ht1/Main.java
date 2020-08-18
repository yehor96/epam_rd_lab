package com.epam.test.ht1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public boolean sleepIn(boolean weekday, boolean vacation) {
        return(!weekday || vacation);
    }

    public int diff21(int n) {
        if (n >= 21) {
            return (21 - n)*-2;
        }
        else {
            return 21 - n;
        }
    }

    public boolean nearHundred(int n) {
        return Math.abs(100 - n)<= 10 ? true : Math.abs(200 - n) <= 10;
    }

    public String missingChar(String str, int n) {
        String newStr = "";
        for (int i = 0; i < str.length(); i++){
            if(i != n) {
                newStr += str.charAt(i);
            }
        }
        return newStr;
    }

    public String backAround(String str) {
        StringBuilder builder = new StringBuilder();
        builder.append(str.charAt(str.length()-1) + str + str.charAt(str.length()-1));
        return builder.toString();
    }

    public boolean startHi(String str) {
        return str.startsWith("hi");
    }

    public boolean hasTeen(int a, int b, int c) {
        if (a >= 13 && a <= 19) {
            return true;
        }
        if (b >= 13 && b <= 19) {
            return true;
        }
        if (c >= 13 && c <= 19) {
            return true;
        }
        return false;
    }

    public boolean mixStart(String str) {
        if (str.length() < 3) {
            return false;
        }
        return str.substring(1, 3).equals("ix");
    }

    public int close10(int a, int b) {
        if (Math.abs(a - 10) < Math.abs(b - 10)){
            return a;
        }
        else if (Math.abs(a - 10) > Math.abs(b - 10)) {
            return b;
        }
        else {
            return 0;
        }
    }

    public boolean stringE(String str) {
        int counter = 0;
        for (char x : str.toCharArray()){
            if(x == 'e') {
                counter++;
            }
        }
        return (counter >= 1 && counter <=3);
    }

    public String everyNth(String str, int n) {
        String newStr = "";
        newStr += str.charAt(0);
        for (int i = n; i < str.length(); i +=n)
            newStr += str.charAt(i);
        return newStr;
    }

    public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        return ((!aSmile && !bSmile) || (aSmile && bSmile));
    }

    public boolean parrotTrouble(boolean talking, int hour) {
        return ((talking) && (hour < 7 || hour >20));
    }

    public boolean posNeg(int a, int b, boolean negative) {
        if (negative) {
            return (a < 0 && b < 0);
        }
        else {
            return (a < 0 != b < 0);
        }
    }

    public String frontBack(String str) {
        if (str.length() <= 1) {
            return str;
        }

        String newStr = "";
        newStr += str.charAt(str.length()-1);

        for (int i = 1; i < str.length()-1; i++){
            newStr += str.charAt(i);
        }
        newStr += str.charAt(0);

        return newStr;
    }

    public boolean or35(int n) {
        return ((n % 3 == 0) || (n % 5 == 0)) ? true : false;
    }

    public boolean icyHot(int temp1, int temp2) {
        return (temp1 < 0 && temp2 > 100) || (temp1 > 0 && temp2 < 0);
    }

    public boolean loneTeen(int a, int b) {
        return ((a >= 13 && a <= 19) != (b>=13 && b <= 19));
    }

    public String startOz(String str) {
        String newStr = "";
        if(str.length() < 2 && str.startsWith("o")) {
            return "o";
        }
        else if (str.length() == 0){
            return newStr;
        }
        else {
            if(str.charAt(0) == 'o') newStr += "o";
            if(str.charAt(1) == 'z') newStr += "z";
        }
        return newStr;
    }

    public boolean in3050(int a, int b) {
        if ((a >= 30 && a <= 40) && (b >= 30 && b <= 40)) {
            return true;
        }
        if ((a >= 40 && a <= 50) && (b >= 40 && b <= 50)) {
            return true;
        }
        return false;
    }

    public boolean lastDigit(int a, int b) {
        int remA = a % 10;
        int remB = b % 10;
        if(remA == remB) {
            return true;
        }
        else {
            return false;
        }
    }

    public int sumDouble(int a, int b) {
        if (a==b){
            return (a+b)*2;
        }
        else {
            return a+b;
        }
    }

    public boolean makes10(int a, int b) {
        return (a+b == 10 || a == 10 || b == 10);
    }

    public String notString(String str) {
        if(str.startsWith("not")) {
            return str;
        }
        else {
            return "not " + str;
        }
    }

    public String front3(String str) {
        if(str.length() <= 3) {
            return str+str+str;
        }
        else {
            return str.substring(0, 3) + str.substring(0, 3) + str.substring(0, 3);
        }
    }

    public String front22(String str) {
        if (str.length() < 2) {
            return str+str+str;
        }
        else {
            String newStr = str.substring(0,2);
            return newStr + str + newStr;
        }
    }

    public boolean in1020(int a, int b) {
        return ((a >= 10 && a <= 20) ||(b >= 10 && b <= 20));
    }

    public String delDel(String str) {
        if (str.length() < 4){
            return str;
        }
        if (str.substring(1, 4).equals("del")){
            return str.charAt(0) + str.substring(4, str.length());
        }
        return str;
    }

    public int intMax(int a, int b, int c) {
        int[] nums = {a, b, c};
        Arrays.sort(nums);
        return nums[2];
    }

    public int max1020(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);

        if ((max >= 10) && (max <= 20)){
            return max;
        }
        else if ((min >= 10) && (min <= 20)){
            return min;
        }
        else {
            return 0;
        }
    }

    public String endUp(String str) {
        if (str.length() <= 3) {
            return str.toUpperCase();
        }
        return str.substring(0, str.length() - 3)
                + str.substring(str.length() - 3, str.length()).toUpperCase();
    }
}
