package com.company.utils;

import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {
    public  static  long genereateDate(){
        Date endDate = new Date(new Date().getYear(), 1,1);
        Date startDate = new Date((endDate.getYear() - 1),1,1 );
        return ThreadLocalRandom.current().longs(1, startDate.getTime() , endDate.getTime()).toArray()[0];
    }

    public  static float generateSum(){
        float leftLimit = 10_000.12F;
        float rigthLimit = 1000_000.15F;
        return leftLimit + new Random().nextFloat() * (rigthLimit - leftLimit);
    }

    public static String generateUUID(){
        return UUID.randomUUID().toString();
    }

    public static String convertDate(Date date){
        return date.getDay() + "." + date.getMonth() + ". " + date.getYear() + " "
                + date.getHours() + ":" + date.getMinutes();
    }

}
