package geo.peter;

import geo.peter.ui.DbConnectFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by peter.georgiev on 02/11/2016.
 */
public class App {

    private JFrame frame;
    private App()
    {
        this.frame = new JFrame("DB Comparator");
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.frame.setLocation(dim.width/2-this.frame.getSize().width/2, dim.height/2-this.frame.getSize().height/2);

        this.frame.getContentPane().add(new DbConnectFrame(this.frame));


        this.frame.pack();
        this.frame.setVisible(true);

    }
    public static void main( String[] args )
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new App();
            }
        });
    }
}
