package com.company;


import com.company.domain.Payment;
import com.company.domain.PointOfSale;
import com.company.dto.PaymentsOfPointSaleDTO;
import com.company.nio.ReadFile;
import com.company.nio.WriteToFile;
import com.company.utils.Utils;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainTest1 {


    final static Logger LOGGER = Logger.getLogger(MainTest1.class);

    public static void main(String[] args) {
        if(args.length  != 3){
            LOGGER.error("missing count arguments, only 3\n " +
                    "1 argument: input file\n " +
                    "2 argument: count operations\n" +
                    " 3 argument: outputfile" );
            return;
        }
	// write your code here
        MainTest1 mainTest1 = new MainTest1();
        mainTest1.runTask1(args[0],Integer.valueOf(args[1]),args[2]);
    }

    private void runTask1(String nameFileInput,int countOperations,String nameFileOutput) {
        File file  =  new File(nameFileInput);
        ReadFile readFile = new ReadFile(file);
        List<PaymentsOfPointSaleDTO> paymentsOfPointSale =  new ArrayList<>();
        for(int i = 0; i < countOperations ;i ++){
            Payment payment = new Payment(Utils.generateSum(),
                    Utils.generateUUID(),
                    new Date(Utils.genereateDate()));
            PointOfSale pointOfSale = new PointOfSale(readFile.getRandomIDPointOfSales());
            paymentsOfPointSale.add(new PaymentsOfPointSaleDTO(payment,pointOfSale));
        }
        new WriteToFile().writeStreamToFile(nameFileOutput, paymentsOfPointSale);
    }

}
