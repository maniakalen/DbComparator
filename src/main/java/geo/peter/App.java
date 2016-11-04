package geo.peter;

import geo.peter.ui.DbConnectFrame;
import geo.peter.ui.GuiHelper;

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
        GuiHelper.replaceFrame(this.frame, new DbConnectFrame(this.frame));

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
