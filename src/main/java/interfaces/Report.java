package interfaces;

import clases.Data;

import java.util.ArrayList;

public interface Report<T> {
    /**
     *
     * @param mExcelFileName
     * @return
     */
    T setFileName(String mExcelFileName);

    /**
     *
     * @param path
     */
    void createFile(String path);
}