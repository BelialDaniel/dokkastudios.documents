package clases;

import interfaces.Report;
import interfaces.SheetCreator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is used to create document in a way more easier
 */
public class ExcelReport implements Report<ExcelReport> {

    private Workbook mWorkbook = null;
    private CreationHelper mHelper = null;
    private String mExcelFileName = "DefaulNameReport";

    private SheetCreator mSheetCreator = null;

    /**
     *
     */
    private ExcelReport() {
        mWorkbook = new XSSFWorkbook();//HSSFWorkbook();
        mHelper = mWorkbook.getCreationHelper();
        mSheetCreator = new NormalSheet();
    }

    /**
     *
     * @param workbook
     */
    private ExcelReport(Workbook workbook) {
        mWorkbook = workbook;
        mHelper = mWorkbook.getCreationHelper();
    }

    /**
     *
     * @param workbook
     * @return
     */
    static public ExcelReport getInstance(Workbook workbook) {
        return new ExcelReport(workbook);
    }

    /**
     *
     * @return
     */
    static public ExcelReport getInstance() {
        return new ExcelReport();
    }

    /**
     *
     * @param excelFileName
     * @return
     */
    @Override
    public ExcelReport setFileName(String excelFileName) {
        this.mExcelFileName = excelFileName;
        return this;
    }

    /**
     *
     * @param title
     * @param headers
     * @param data
     * @return
     */
    public ExcelReport createSheet(String title, ArrayList<String> headers, Data data) {
        mSheetCreator.createSheet(mWorkbook, title, headers, data);
        return this;
    }

    /**
     *
     * @param sheetCreator
     * @return
     */
    public ExcelReport assignNewSheetType(SheetCreator sheetCreator) {
        mSheetCreator = sheetCreator;
        return this;
    }

    @Override
    public void createFile(String path) {
        if(mWorkbook instanceof XSSFWorkbook)
            mExcelFileName += ".xlsx";
        else if (mWorkbook instanceof HSSFWorkbook)
            mExcelFileName += ".xls";

        String absolutePath = path + mExcelFileName;

        FileOutputStream fileOutExcel = null;

        try {
            fileOutExcel =  new FileOutputStream(absolutePath);
            mWorkbook.write(fileOutExcel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(fileOutExcel != null)
                    fileOutExcel.close();
                if(mWorkbook != null)
                    mWorkbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
