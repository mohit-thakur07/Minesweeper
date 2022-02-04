package minesweeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
public class Watch
{
      String time = "0";
      int hours = 0;
      int minutes = 0;
      int seconds = 0;
      public static boolean runTimer = true;      
      
      public Watch(javax.swing.JTextField j)
      {          
          Timer timer = new Timer(1000, new TimerListenerClass());
            timer.start();       
            
            while (runTimer)
            {                        
                time = hours + " : " + minutes + " : " + seconds + "";
                j.setText(time);                                    
            }
      }
      
      class TimerListenerClass implements ActionListener
      {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                  seconds += 1;
                  if (seconds > 59)
                  {
                        seconds = 0;
                        minutes += 1;
                  }
                  if (minutes > 59)
                  {
                        minutes = 0;
                        hours += 1;
                  }
            }
      }      
}