package com.company.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToFile {
    private  FileOutputStream fileOutputStream ;

    public  WriteToFile(String name) {
        try {
            this.fileOutputStream =  new FileOutputStream("name");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
