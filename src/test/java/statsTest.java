import com.company.domain.Payment;
import com.company.domain.PointOfSale;
import com.company.dto.PaymentsOfPointSaleDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        try (Stream<String> lineStream = Files.lines(path)) {
            lineStream.forEach(this::initPaymentsOfPointSaleDTO);
            Stream<PaymentsOfPointSaleDTO>  paymentsOfPointSaleDTOStream =  paymentsOfPointSaleDTO.stream();
        }
        catch (IOException ignored) {
        }
    }

    private void initPaymentsOfPointSaleDTO(String s) {
        String[] str  = s.split(" ");
        try {
            Date date1=new SimpleDateFormat("dd.MM.yyyy").parse(str[0]);
            Payment payment =  new Payment(
                    Float.valueOf(str[4]), str[3], date1);
            PointOfSale pointOfSale =  new PointOfSale(str[2]);
            paymentsOfPointSaleDTO.add(new PaymentsOfPointSaleDTO(payment,pointOfSale));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
