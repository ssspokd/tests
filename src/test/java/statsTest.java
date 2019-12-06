import com.company.dto.PaymentsOfPointSaleDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class statsTest {

    private List<PaymentsOfPointSaleDTO> paymentsOfPointSaleDTO;
    private  File file;
    private InputStreamReader inputStreamReader;


    @BeforeEach
    public void init(){
        file = new File("e:/file1.txt");
        InputStream inputStream = null;
        try {
            inputStream =  new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        inputStreamReader =  new InputStreamReader(inputStream);
    }

    @Test
    public void ReadDataFromFile() throws IOException {
        Path path =  file.toPath();
    }
}
