package com.company.nio;

import com.company.dto.PaymentsOfPointSaleDTO;

import java.io.*;
import java.util.List;

public class WriteToFile {

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
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
