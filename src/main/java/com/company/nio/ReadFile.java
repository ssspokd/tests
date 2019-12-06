package com.company.nio;

import com.company.domain.PointOfSale;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ReadFile {
    final static Logger LOGGER = Logger.getLogger(ReadFile.class);

    private List<PointOfSale> pointOfSaleList = new ArrayList<>();
    private File file;


    public ReadFile(File file){
        this.file = file;
        readData();
    }

    private void readData(){
        try (FileReader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader)) {
            String line;
            while ((line = br.readLine()) != null) {
                pointOfSaleList.add(new PointOfSale(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void print(){
        for(PointOfSale pointOfSale : pointOfSaleList){
            LOGGER.debug(pointOfSale.getIdPointOfSale());
        }
    }

    public String getRandomIDPointOfSales(){
        return pointOfSaleList.get(new Random().nextInt(pointOfSaleList.size())).getIdPointOfSale();
    }
}
