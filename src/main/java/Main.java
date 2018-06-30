import clases.Data;
import clases.ExcelReport;

import java.util.ArrayList;

public class Main {

    static public void main(String[] args) {

        /*
         * this header denote a normal simple sheet
         */
        ArrayList<String> headers = new ArrayList<>();
        headers.add("Name");
        headers.add("Age");
        headers.add("Address");

        /*
         * this is the data to fill the sheet
         */
        Data<String> dataCardBatch = new Data<>();
        dataCardBatch.addData(0, "Manuel");
        dataCardBatch.addData(0, "23");
        dataCardBatch.addData(0, "Addres 1");

        dataCardBatch.addData(1, "Daniel");
        dataCardBatch.addData(1, "31");
        dataCardBatch.addData(1, "Addres 2");

        ExcelReport cardBatchReport = ExcelReport.getInstance();

        cardBatchReport
                .setFileName("CardBatchReport")
                .createSheet("FirstSheet", headers, dataCardBatch)
                .createSheet("SecondSheet", headers, dataCardBatch)
                .createFile("/Users/belialdaniel/Desktop");
    }
}