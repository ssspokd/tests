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

public class Main {

    final static Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.runTask1(args);
    }

    private void runTask1(String[] args) {
        if(args.length  != 3){
            LOGGER.error("missing count arguments, only 3\n " +
                    "1 argument: input file\n " +
                    "2 argument: count operations\n" +
                    " 3 argument: outputfile" );
            return;
        }
        File file  =  new File(args[0]);
        ReadFile readFile = new ReadFile(file);
        List<PaymentsOfPointSaleDTO> paymentsOfPointSale =  new ArrayList<>();

        for(int i = 0; i < Integer.valueOf(args[1]) ;i ++){
            Payment payment = new Payment(Utils.generateSum(),
                    Utils.generateUUID(),
                    new Date(Utils.genereateDate()));
            PointOfSale pointOfSale = new PointOfSale(readFile.getRandomIDPointOfSales());
            paymentsOfPointSale.add(new PaymentsOfPointSaleDTO(payment,pointOfSale));
        }
    }

}
