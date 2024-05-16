/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.sequencefullofcolors;

import java.util.Scanner;

/**
 *
 * @author Nhat Anh
 */
public class SequenceFullOfColors {

    //hàm kiểm tra xem có đủ màu không
    public static boolean sequenceFullOfColors(String input) {
        int countTotalR = 0, countTotalG = 0, countTotalB = 0, countTotalY = 0;
        //lặp để đếm tổng số màu có trong input
        for (char c : input.toCharArray()) {
            switch (c) {
                case 'R':
                    countTotalR++;
                    break;
                case 'G':
                    countTotalG++;
                    break;
                case 'B':
                    countTotalB++;
                    break;
                case 'Y':
                    countTotalY++;
                    break;
            }
        }
        //Nếu số màu green khác red hoặc số màu yellow khác blue trả về false
        if (countTotalG != countTotalR || countTotalY != countTotalB) {
            return false;
        }
        //lặp để tạo từng tiền tố của input
        for (int i = 2; i < input.length(); i++) {
            String subString = input.substring(0, i);
            int countR = 0, countG = 0, countB = 0, countY = 0;
            //Đếm từng màu trong tiền tố đó
            for (char c : subString.toCharArray()) {
                switch (c) {
                    case 'R':
                        countR++;
                        break;
                    case 'G':
                        countG++;
                        break;
                    case 'B':
                        countB++;
                        break;
                    case 'Y':
                        countY++;
                        break;
                }
            }
            //nếu chênh lệch giữa green và red hoặc yellow và blue > 1 sẽ trả về false
            if (countR - countG > 1 || countG - countR > 1 || countY - countB > 1 || countB - countY > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào số phép thử: " );
        int numberOfTestCase = sc.nextInt(); sc.nextLine();
        String [] input = new String[numberOfTestCase];
        for(int i = 0; i < numberOfTestCase; i++ ){
            input[i] = sc.nextLine();
        }
        
        for(int i = 0; i < input.length; i++){
            System.out.println(sequenceFullOfColors(input[i]));
        }
    }
}
