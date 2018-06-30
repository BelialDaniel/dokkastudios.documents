package interfaces;

import clases.Data;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.ArrayList;

/**
 * This interface is used to apply strategy pattern
 */
public interface SheetCreator {

    /**
     * This interface is used to create the behavior of the sheets
     * @param title
     * @param headers
     * @param data
     * @return
     */
     void createSheet(Workbook workbook, String title, ArrayList<String> headers, Data data);
}
