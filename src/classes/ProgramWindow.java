package classes;

import javax.swing.*;
import java.awt.event.ComponentListener;


public abstract class ProgramWindow extends JFrame implements ComponentListener {
    //The class used as the main window for your GUI screensaver program.
    @Override
    public String getTitle() {
         //The title of the window
        return "ScreenSavingTime!";
    }

}
