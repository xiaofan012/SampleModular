/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xiaofan.module.swing;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrator
 */
public class MyTableModel extends AbstractTableModel {

    String[] colNameArray = new String[]{"姓名", "工号", "出生年月", "薪水"};
    Object[][] employers
            = {
                {"Name1", "123", "2000-08", "1200"},
                {"Name1", "123", "2000-08", "1200"},
                {"Name1", "123", "2000-08", "1200"},
                {"Name1", "123", "2000-08", "1200"},
                {"Name1", "123", "2000-08", "1200"},
                {"Name1", "123", "2000-08", "1200"},
                {"Name1", "123", "2000-08", "1200"},
                {"Name1", "123", "2000-08", "1200"},
                {"Name1", "123", "2000-08", "1200"}
            };

    public int getRowCount() {
        return employers.length;
    }

    public int getColumnCount() {
        return colNameArray.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return employers[rowIndex][columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }

    @Override
    public String getColumnName(int column) {
        return colNameArray[column];
    }

}
