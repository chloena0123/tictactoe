package hw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickHandler implements ActionListener {
	  //the keyword implement is for using an interface
	  // which is an abstract class (it has empty methods)

	  Tttgui game;

	  public ClickHandler(Tttgui game){
	    this.game = game;
	  }

	  @Override
	  public void actionPerformed(ActionEvent e) {
	    Button b = (Button)e.getSource();
	    b.addActionListener(this);
	    game.move(b);
	  }

	}