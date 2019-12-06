package com.company;


import com.company.nio.ReadFromFile;
import org.apache.log4j.Logger;

import java.io.File;

public class Main {

    final static Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.runTask1(args);
    }

    private void runTask1(String[] args) {
        if(args.length <1){
            LOGGER.error("missing count arguments");
            return;
        }
        File file  =  new File(args[0]);
        ReadFromFile readFromFile = new ReadFromFile(file);
        LOGGER.debug(readFromFile.getRandomIDPointOfSales());
    }


}
