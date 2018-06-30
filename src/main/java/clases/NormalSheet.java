package clases;

import org.apache.poi.ss.usermodel.*;

import java.util.ArrayList;

public class NormalSheet implements interfaces.SheetCreator {

    /**
     * This methos create a normal sheet
     * @param workbook
     * @param title
     * @param headers
     * @param data
     * @return
     */
    @Override
    public void createSheet(Workbook workbook, String title, ArrayList<String> headers, Data data) {

        Sheet sheet = null;
        Row headerRow = null;
        try {
            sheet = workbook.createSheet(title);

            if (headers != null && !headers.isEmpty()) {
                headerRow = sheet.createRow(0);

                //font to the headers columns
                Font headerFont = workbook.createFont();
                headerFont.setBold(true);
                headerFont.setFontHeightInPoints((short) 12);
                headerFont.setColor(IndexedColors.BLACK.getIndex());

                CellStyle headerCellStyle = workbook.createCellStyle();
                headerCellStyle.setFont(headerFont);

                for (int indexCell = 0; indexCell < headers.size(); indexCell++) {
                    headerRow.createCell(indexCell).setCellValue(headers.get(indexCell));
                    headerRow.getCell(indexCell).setCellStyle(headerCellStyle);
                }
            }

            if (data != null) {
                int rowExcel = headerRow != null ? 1 : 0;
                for (int rowData = 0; rowData < data.size(); rowData++, rowExcel++) {
                    Row dataRow = sheet.createRow(rowExcel);
                    int columnCount = data.getRow(rowData).size();
                    for (int column = 0; column < columnCount; column++)
                        dataRow.createCell(column).setCellValue((String) data.getRow(rowData).get(column));
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}