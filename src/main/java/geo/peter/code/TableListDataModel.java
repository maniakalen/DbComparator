package geo.peter.code;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by peter.georgiev on 03/11/2016.
 */
public class TableListDataModel extends DefaultTableModel
{
    String[] m_colNames = { "Table name" };

    Class[] m_colTypes = { String.class };

    public TableListDataModel()
    {
        super();
    }
    public TableListDataModel(List<Vector> data)
    {
        super();
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
}
