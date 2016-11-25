package geo.peter.ui;

import geo.peter.code.TableListDataModel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.Vector;

/**
 * Created by peter.georgiev on 03/11/2016.
 */
public class DbTableListBlock extends JPanel {

    public TableListDataModel model;
    public JScrollPane scroll;
    DbTableListBlock()
    {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.build();
        this.setPreferredSize(new Dimension(500, 70));
    }

    private void build()
    {
        this.model = new TableListDataModel();

        final JTable table = new JTable(this.model);
        table.setDefaultRenderer(String.class, new TableListDataModel.MyTableCellRenderer());
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        this.scroll = new JScrollPane(table);
        this.add(this.scroll);
    }
}
