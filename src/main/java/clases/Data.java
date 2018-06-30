package clases;

import java.util.ArrayList;

/**
 * This class is used to store the data of the sheet to fill
 * @param <T>
 */
public class Data <T> extends ArrayList<ArrayList<T>> {

    /**
     *
     * @param indexRow
     * @param data
     */
    public void addData(int indexRow, T data) {
        if(this.isEmpty())
            this.add(new ArrayList<>());
        else if (indexRow > (this.size() - 1))
            this.add(new ArrayList<>());

        try {
            this.get(indexRow).add(data);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param indexRow
     * @return
     */
    public ArrayList<T> getRow(int indexRow) {

        ArrayList<T> row = null;
        try {
            row = this.get(indexRow);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return row;
    }
}