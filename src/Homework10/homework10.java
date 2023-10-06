package Homework10;

import static java.lang.System.out;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;


public class homework10 {
    public static void main(String[] args) {
    		date();
    		rand();
    		cho();
    }
    
    public static void cho() {
    	 Scanner sc = new Scanner(System.in);
         
         System.out.println("輸入數字(ex.123): ");
         String nuu = sc.next();
         int chnum = -1;
    	 if (nuu.matches("^[0-9]+$")) {
				 double number = Double.parseDouble(nuu);
				while(chnum !=0) {
	

	             System.out.println("選擇一種表示方法:1千分位,2百分比,3科學記號,0退出");
	   
	
	            chnum = sc.nextInt();
	
	             switch (chnum) {
	                 case 1:
	                     formatAndDisplay(number, "千分位", "###,###.###");
	                     break;
	                 case 2:
	                     formatAndDisplay(number, "百分比", "###.##%");
	                     break;
	                 case 3:
	                     formatAndDisplay(number, "科學記號", "0.###E0");
	                     break;
	                 case 0:
	                	 System.out.println("退出。");
	                	 break;
	             }
	         }
    	 }
    	 else {
             System.out.println("無效的輸入。請輸入一個有效的數字。");
         }
    }
    public static void formatAndDisplay(double number, String formatType, String pattern) {
        DecimalFormat formatter = new DecimalFormat(pattern);
        String formattedNumber = formatter.format(number);
        System.out.println("格式化后的数字 (" + formatType + "): " + formattedNumber);
    }
    
    
	public static void rand() {
//		請設計一隻程式,用亂數產生5個介於1~100之間的整數,而輸出結果可以判斷出這5個整數為是否
//		為質數 (提示:Math類別)
		Random random = new Random();
		int i=0,j,flag=-1;
		int[] numm = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97};
		int []s1 = new int [5];
		for(i=0;i<5;i++) {
			s1[i] = 1+random.nextInt(100);
			flag=-1;
			for(j=0;j<25;j++) {
				if(s1[i]==numm[j]) {
					flag=0;
				}
			}
			if(flag==0) {
			System.out.printf("%3d是質數",s1[i]);
			}
			else {
				System.out.printf("%3d不是質數",s1[i]);
			}
		}


	}
    
    public static  void date() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n------------------日期格式化-------------------");
        System.out.println("輸入日期(ex.20110122): ");
        String dayta = sc.next();
        
        SimpleDateFormat s1 = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat s2 = new SimpleDateFormat("MMddyyyy");
        SimpleDateFormat s3 = new SimpleDateFormat("ddMMyyyy");

        try {
        	Date date = s1.parse(dayta);

            
            while (true) {
                System.out.println("0.退出 1.年月日 2.月日年 3.日月年");
                int userChoice = sc.nextInt();
                
                switch (userChoice) {
                    case 0:
                        System.out.println("退出程式");
                        return; // 結束程式
                    case 1:
                    	System.out.println("年月日格式 (yyyyMMdd): " + s1.format(date));
                        break;
                    case 2:
                    	 System.out.println("月日年格式 (MMddyyyy): " + s2.format(date));
                        break;
                    case 3:
                    	System.out.println("日月年格式 (ddMMyyyy): " + s3.format(date));
                        break;
                    default:
                        System.out.println("請輸入有效的選項");
                        break;
                }
            }
        } catch (ParseException e) {
            System.out.println("日期解析失敗。請輸入正確的日期格式(ex.20110122)。");
        }
    }
}
