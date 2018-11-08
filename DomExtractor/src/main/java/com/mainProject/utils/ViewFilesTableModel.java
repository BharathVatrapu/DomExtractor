package com.mainProject.utils;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ViewFilesTableModel extends AbstractTableModel {
    private final List<ViewFileTable> viewFileList;

    private final String[] columnNames = new String[] {
            "Sno", "File Name", "Created Date"
    };
    private final Class[] columnClass = new Class[] {
            Integer.class, String.class,String.class
    };

    public ViewFilesTableModel(List<ViewFileTable> viewFileList)
    {
        this.viewFileList = viewFileList;
    }

    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex)
    {

        return columnClass[columnIndex];
    }

    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }

    @Override
    public int getRowCount()
    {
        return viewFileList.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)    {
        ViewFileTable row = viewFileList.get(rowIndex);
        if(0 == columnIndex) {
            return row.getSno();
        }
        else if(1 == columnIndex) {
            return row.getfileName();
        }
       else if(2 == columnIndex){
            return row.getcreateDate();
        }
        return null;
    }
}
