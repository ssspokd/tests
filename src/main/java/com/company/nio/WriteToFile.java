package com.company.nio;

import com.company.dto.PaymentsOfPointSaleDTO;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.List;

public class WriteToFile {
    private final static Logger LOGGER = Logger.getLogger(WriteToFile.class);

    private  File file;

    public WriteToFile(File file) {
        this.file = file;
        if(this.file.exists()){
            this.file.delete();
            try {
                this.file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public  void writeStreamToFile(List<PaymentsOfPointSaleDTO> paymentsOfPointSaleDTOList){
        try {
            OutputStreamWriter outputStreamWriter =  new OutputStreamWriter(new FileOutputStream(file));
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
