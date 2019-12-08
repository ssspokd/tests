package com.company.nio;

import com.company.MainTest1;
import com.company.dto.PaymentsOfPointSaleDTO;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.List;

public class WriteToFile {
    final static Logger LOGGER = Logger.getLogger(WriteToFile.class);

    public  static void writeStreamToFile(String nameFile, List<PaymentsOfPointSaleDTO> paymentsOfPointSaleDTOList){
        try {
            File file = new File(nameFile);
            if(file.exists()){
                file.delete();
                file.createNewFile();
            }
            OutputStreamWriter outputStreamWriter =  new OutputStreamWriter(new FileOutputStream(new File(nameFile)));
            paymentsOfPointSaleDTOList.forEach(paymentsOfPointSaleDTO -> {
                try {
                    outputStreamWriter.write(paymentsOfPointSaleDTO.toString() + "\n");
                } catch (IOException e) {
                    LOGGER.error(e.getMessage());
                }
            });
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
