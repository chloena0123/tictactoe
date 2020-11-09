package hw;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;

/**
 *
 * @author k.na
 */

public class Button extends JButton{
    private boolean claimed;
    private Player owner;


    public Button() {
        this.setPreferredSize(new Dimension(200,200));
        //this.setOpaque(true);
        this.setBackground(Color.black);
        this.setFont(new Font("sans_serif",Font.BOLD,60));
        this.setForeground(Color.white);
        
        
        claimed = false;
        // default value for owner is null
    }

    public Player getOwner(){
        return owner;
    }

    public boolean isClaimed() {
        return claimed;
    }

    public void claim(Player current) {
        if (current == Player.X) {
          this.setText("X");
          owner = Player.X;
        } else {
           this.setText("O");
           owner = Player.O;
        }
        claimed = true;
    }
}