package com.company;


import org.apache.log4j.Logger;

public class Main {

    final static Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.runTask1(args);
    }

    private void runTask1(String[] args) {
        if(args.length <3){
            LOGGER.error("missing count arguments");
        }
    }


}
