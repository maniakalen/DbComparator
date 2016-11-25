package geo.peter.code;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * Created by peter.georgiev on 03/11/2016.
 */
public class TableListDataModel extends DefaultTableModel
{
    private ArrayList<Color> rowColours;

    private String[] m_colNames = { "Table name" };

    private Class[] m_colTypes = { String.class };

    public TableListDataModel()
    {
        super();
        rowColours = new ArrayList<>();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    public String getColumnName(int col) {
        return m_colNames[col];
    }

    public Class getColumnClass(int col) {
        return m_colTypes[col];
    }

    void setRowColor(int row, Color c) {
        rowColours.set(row, c);
    }


    Color getRowColor(int row) {
        return row < rowColours.size()?rowColours.get(row):null;
    }

    @Override
    public void addRow(Vector rowData) {
        super.addRow(rowData);
        rowColours.add(Color.WHITE);
    }

    public static class MyTableCellRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            TableListDataModel model = (TableListDataModel) table.getModel();
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            Color col = model.getRowColor(row);
            if (col != null) {
                c.setBackground(col);
            }
            return c;
        }
    }
}
