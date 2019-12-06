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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class statsTest {

    private List<PaymentsOfPointSaleDTO> paymentsOfPointSaleDTO;
    private  List<PaymentStats> paymentStatsList;
    private  File file;
    private InputStreamReader inputStreamReader;


    @BeforeEach
    public void init(){
        paymentStatsList =  new ArrayList<>();
        paymentsOfPointSaleDTO = new ArrayList<>();
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
            lineStream.forEach(this::initPaymentsOfStat);
            Stream<PaymentStats> statsStream = paymentStatsList.stream();
            sortStremByData(statsStream);
        }
        catch (IOException ignored) {
        }
    }

    private void sortStremByData(Stream<PaymentStats> stream){
        stream.sorted((e1, e2) -> e2.getDate().compareTo(e1.getDate()));

    }

    private void initPaymentsOfStat(String s) {
        String[] str  = s.split(" ");
        try {
            Date date = new SimpleDateFormat("dd.MM.yyyy").parse(str[0]);
            PaymentStats paymentStats = new PaymentStats(date,Float.valueOf(str[4]),str[3],str[2]);
            paymentStatsList.add(paymentStats);
        } catch (ParseException e) {
            e.printStackTrace();
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
