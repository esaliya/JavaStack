package ui;

import javax.swing.table.AbstractTableModel;
import java.io.File;
import java.util.Date;

public class FileTableModel extends AbstractTableModel{
    private String[] columnNames = {"File Name", "File Size (KB)", "Modified Time"};
    private File [] files;
    public int getRowCount() {
        return files.length;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: {
                String path = files[rowIndex].getAbsolutePath();
                String name;
                return "".equals(name = path.substring(path.lastIndexOf(File.separator) + 1)) ? path : name;
            } case 1: {
                return files[rowIndex].isFile() ? files[rowIndex].length() : "n/a";
            } case 2: {
                return new Date(files[rowIndex].lastModified());
            }
        }
        return null;
    }

    public void setFiles(File[] files) {
        this.files = files;
    }
}
