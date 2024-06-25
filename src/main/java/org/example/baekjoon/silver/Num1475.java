package org.example.baekjoon.silver;

import java.io.*;

public class Num1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int count = 0;
        int[] array = new int[10];
        boolean isNine = false;
        boolean isSix = false;

        for(int i=0;i<10;i++){
            array[i] = 0;
        }

        while (num != 0){
            int temp = num%10;


            if (temp == 6){
                if (!isSix) {
                    isSix = true;
                    array[temp] += 1;
                }
                else{
                    isSix = false;
                    array[9] +=1;
                }
            } else if (temp == 9) {
                if(!isNine){
                    isNine = true;
                    array[temp] +=1;
                }else{
                    isNine = false;
                    array[6] +=1;
                }
            }else {
                array[temp] += 1;
            }
            num /= 10;

        }
        int max = 0;
        for(int i=0;i<10;i++){
            if(array[i]>max)
                max = array[i];
        }

        bw.write(""+max);
        bw.close();

    }
}
