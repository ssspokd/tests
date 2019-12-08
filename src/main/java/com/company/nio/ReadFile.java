package com.company.nio;

import com.company.domain.PointOfSale;
import org.apache.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class ReadFile {
    final static Logger LOGGER = Logger.getLogger(ReadFile.class);

    private List<PointOfSale> pointOfSaleList = new ArrayList<>();
    private File file;


    public ReadFile(File file){
        this.file = file;
        readFileStream();
    }

    private void readData(){
        try (FileReader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader)) {
            String line;
            while ((line = br.readLine()) != null) {
                pointOfSaleList.add(new PointOfSale(line));
            }
        } catch (FileNotFoundException e) {
            LOGGER.error(e.getMessage());
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    private  void  readFileStream(){
        Path path =  file.toPath();
        Stream<String> lineStream = Stream.generate(() -> "");
        try
        {
            lineStream = Files.lines(path);
            lineStream.forEach(s -> pointOfSaleList.add(new PointOfSale(s)));
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }



    public String getRandomIDPointOfSales(){
        return pointOfSaleList.get(new Random().nextInt(pointOfSaleList.size())).getIdPointOfSale();
    }
}
