package com.epam.test.ht4.task1;

public class Main {

    public static void main(String[] args) {

    }

    public String stringTimes(String str, int n) {
        if(n == 0){
            return "";
        }

        StringBuilder builder = new StringBuilder(str);
        for(int i = 1; i < n; i++){
            builder.append(str);
        }

        return builder.toString();
    }

    boolean doubleX(String str) {
        for(int i = 0; i < str.length()-1; i++){
            if(str.charAt(i) == 'x'){
                if(str.charAt(i+1) == 'x'){
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public int last2(String str) {
        if (str.length() < 2){
            return 0;
        }

        String last = str.substring(str.length()-2);
        int counter = 0;

        for (int i=0; i<str.length()-2; i++) {
            String sub = str.substring(i, i+2);
            if (sub.equals(last)) {
                counter++;
            }
        }

        return counter;
    }

    public boolean array123(int[] nums) {
        for(int i =0; i < nums.length-2; i++)
            if(nums[i] == 1){
                if(nums[i+1]==2){
                    if(nums[i+2]==3)
                        return true;
                }
            }
        return false;
    }

    public String altPairs(String str) {
        String result = "";

        for(int i = 0; i < str.length(); i+=4){
            result += str.charAt(i);
            if(str.length()-1 > i){
                result += str.charAt(i+1);
            }
        }
        return result;
    }

    public boolean noTriples(int[] nums) {
        for(int i = 0; i < nums.length-2; i++){
            if(nums[i] == nums[i+1] && nums[i+1] == nums[i+2]){
                return false;
            }
        }
        return true;
    }

    public String frontTimes(String str, int n) {

        if(n == 0){
            return "";
        }

        StringBuilder builder = new StringBuilder();
        String front;

        if(str.length() <= 3){
            front = str;
        }
        else{
            front = str.substring(0, 3);
        }

        for(int i = 0; i < n; i++){
            builder.append(front);
        }

        return builder.toString();
    }

    public String stringBits(String str) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < str.length(); i += 2){
            builder.append(str.charAt(i));
        }
        return builder.toString();
    }

    public int arrayCount9(int[] nums) {
        int counter = 0;
        for(int each : nums){
            if(each == 9){
                counter++;
            }
        }
        return counter;
    }

    public int stringMatch(String a, String b) {
        int counter =0;

        String smallest = a.length() < b.length() ? a : b;

        for(int i =0; i < smallest.length()-1; i++){
            if(a.substring(i, i+2).equals(b.substring(i,i+2))){
                counter++;
            }
        }

        return counter;
    }

    public String stringYak(String str) {
        return str.replace("yak", "");
    }

    public boolean has271(int[] nums) {
        for(int i = 0; i < nums.length-2; i++){
            int value = nums[i];
            if((nums[i+1] == value + 5)
                    && (nums[i+2] >= value - 3)
                    && (nums[i+2] <= value + 1)){
                return true;
            }
        }
        return false;
    }

    int countXX(String str) {
        int counter = 0;
        for(int i = 0; i < str.length()-1; i++){
            if((str.charAt(i) == 'x') && (str.charAt(i+1) == 'x')){
                counter++;
            }
        }
        return counter;
    }

    public String stringSplosion(String str) {
        String newStr = "";

        for(int i = 0; i <= str.toCharArray().length; i++){
            newStr += str.substring(0, i);
        }
        return newStr;
    }

    public boolean arrayFront9(int[] nums) {
        int iterations;

        if(nums.length < 4){
            iterations = nums.length;
        }
        else {
            iterations = 4;
        }

        for(int i = 0; i < iterations; i++){
            if(nums[i] == 9){
                return true;
            }
        }
        return false;
    }

    public String stringX(String str) {
        if(str.length()<2){
            return str;
        }

        StringBuilder builder = new StringBuilder();
        builder.append(str.charAt(0));

        for(int i = 1; i < str.toCharArray().length-1; i++){
            if(str.charAt(i)=='x'){
                continue;
            }
            builder.append(str.charAt(i));
        }

        builder.append(str.charAt(str.length()-1));
        return builder.toString();
    }

    public int array667(int[] nums) {
        int counter = 0;
        for(int i = 0; i < nums.length-1; i++){
            if((nums[i]==6) && (nums[i+1]==6 || nums[i+1]==7)){
                counter++;
            }
        }
        return counter;
    }
}
