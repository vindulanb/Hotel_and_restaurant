

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LENOVO
 */
public class m {

    public static int tables(int t1, int t2, int t3, int t4, int peoples) {

        int no_tables = 0;
        int arr[] = {t1, t2, t3, t4};
        for (int i = 0; i < 4; ++i) {
            if (arr[i] == 1) {
                no_tables = no_tables + 1;
            }
        }

        int ans = peoples / 5;
        int totaltabels = ans + no_tables;
        return (totaltabels);

    }

    public static int dec(int lamp, int tray, String baloon1, String baloons, int baloonamount, String baskets, int basketamount, int lampamount) {
        int no_balooni = Integer.parseInt(baloons);
        int no_basketi = Integer.parseInt(baskets);
        int amount = 0;
        if (lamp == 1) {
            amount = amount + lampamount;
        }
        if (tray == 1) {
            amount = amount + (no_basketi * basketamount);
        }
        if (baloon1.equalsIgnoreCase("none")) {
            amount = amount;
        } else {
            amount = amount + (no_balooni * baloonamount);
        }
        return amount;
    }

    public static int flowerdec(int ta1, int ta2, int ta3, int ta4, String gests, String numflow, int cflow, int wflow, int varsecheck, int varserper, String flower) {
        int nopeople = Integer.parseInt(gests);
        int flowers = Integer.parseInt(numflow);
        int no_tables = 0;
        int varseamount = 0;
        int floweramount;
        int totalamountflow;
        int arr[] = {ta1, ta2, ta3, ta4};
        for (int i = 0; i < 4; ++i) {
            if (arr[i] == 1) {
                no_tables = no_tables + 1;
            }
        }

        int ans = nopeople / 5;
        int totaltabels = ans + no_tables;
        if (varsecheck == 1) {
            varseamount = (varserper * totaltabels);
        }

        if (flower.equalsIgnoreCase("none")) {
            floweramount = 0;
        } else {
            if (flower.equalsIgnoreCase("white")) {
                floweramount = (wflow * flowers);
            } else {
                floweramount = (cflow * flowers);
            }
        }
        totalamountflow = floweramount + varseamount;
        return totalamountflow;
    }

    public static int rent(int advancechek, int advanceamount, String duration, int manuprice, String gests, int additionalpay, int aditionalhours) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
//      try{
        Date date2 = format.parse(duration);
        int difference = date2.getHours();  //casting because it genarate int
        int differencemin = date2.getMinutes();
        int hours;
        int hoursrent, mintsrent;
        int nopeople = Integer.parseInt(gests);

        int rent;
        int plateofpay;
        int addhourspay;

        if (difference > 6) {
            hours = difference - aditionalhours;
            hoursrent = hours * 6000;
            if (differencemin > 0) {
                mintsrent = (additionalpay / 60) * differencemin;
            } else {
                mintsrent = 0;
            }
        } else {
            hoursrent = 0;
            mintsrent = 0;
        }
        addhourspay = hoursrent + mintsrent;
        plateofpay = nopeople * manuprice;
        rent = plateofpay + addhourspay;
        if (advancechek == 1) {
            rent = rent - advanceamount;
        } else {
            rent = rent;
        }

        return rent;
    }

    public static int banndrent(int bandcheck, int bandamount) {
        int bandpay;

        if (bandcheck == 1) {
            bandpay = bandamount;
        } else {
            bandpay = 0;
        }
        return bandpay;
    }
}
