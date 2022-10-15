package io.swaragade;

// cmd + option + L : format code

public class IsValidPalindrome {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        String s = fr.nextLine();
        System.out.println(new IsValidPalindrome().isPalindrome(s));

    }

    public boolean isPalindrome(String s) {
        s = s.toUpperCase();
        //System.out.println(s);
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while(i != j && i < arr.length && j >=0){
            if(!isAlphaNum(arr[i])){
                i++;
                continue;
            }
            if(!isAlphaNum(arr[j])){
                j--;
                continue;
            }
            if( arr[i] != arr[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    boolean isAlphaNum(char c){
        boolean res = false;
        if((c >=48 && c<= 57) || (c >=65 && c<=90))
            res = true;
        else {
            res = false;
        }
        //System.out.println(c + ":" +res);
        return res;
    }
}
