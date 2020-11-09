package hw;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

	/**
	 *
	 * @author k.na
	 */
	
	public class Tttgui extends JFrame { 
	    // The extends keywords means that TTTGUI inherits
	    // from JFrame, so a TTTGUI object "is a" JFrame
	    Button[][] buttons;
	    static int ROWS = 3;
	    static int COLS = 3;
	    Player currentPlayer;
            JLabel message;
            boolean gameOver;

	    public Tttgui() {
	        // Sends a title to the JFrame constructor
	        super("Tic Tac Toe");
	        
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setVisible(true);
	        
	        JPanel messagePanel = new JPanel();
                message = new JLabel();
                message.setText("Player X's turn");
                messagePanel.add(message);
                
	        JPanel gridPanel = new JPanel();
	        gridPanel.setLayout(new GridLayout(ROWS,COLS));
	        
	        buttons = new Button[ROWS][COLS];
	        for (int i = 0; i < ROWS; i++) {
	            for (int j = 0; j < COLS; j++) {
	                Button b = new Button();	                
	                buttons[i][j] = b;	              
	                gridPanel.add(b);
	                b.addActionListener(new ClickHandler(this));
	            }
	        }
	        this.add(messagePanel, BorderLayout.NORTH);
	        this.add(gridPanel, BorderLayout.SOUTH);
	        this.pack(); // Fits size to contents

	        currentPlayer = Player.X;
                gameOver = false;

	    }


	    public void move(Button b){
	        if (!b.isClaimed() && !gameOver){
	            b.claim(currentPlayer);
                    Player win = winner();
                    
                    if (win != null) {
                        String winningPlayer = (win == Player.X) ? "X" : "O";
                        message.setText(winningPlayer + " won the game");
                        gameOver = true;
                    } 
                    else {
                        // if player is X then change to O otherwise change to X
                        currentPlayer = (currentPlayer == Player.X) ? Player.O : Player.X ;
                        String player = (currentPlayer == Player.X) ? "X" : "O";
                        message.setText("Player " + player + "'s turn");
                    }
                }
            }   

	    
	    //rows, cols, diagonals are all claimed, then
	    // checks whether the owner is the same for all 3
            public Player winner() {
                Player winner = null; 
                //rows
                for(int i = 0; i<3; i++) {
                    if(buttons[i][0].isClaimed() && buttons[i][1].isClaimed() && buttons[i][2].isClaimed()) {
                        boolean cond1 = buttons[i][0].getOwner() == buttons[i][1].getOwner();
                        boolean cond2 = buttons[i][1].getOwner() == buttons[i][2].getOwner();
                        if(cond1 && cond2) {
                            return buttons[i][0].getOwner();
                        }
                    }
                }
               
                //cols
                for(int j = 0; j<3; j++) {
                    if(buttons[0][j].isClaimed() && buttons[1][j].isClaimed() && buttons[2][j].isClaimed()) {
                        boolean cond1 = buttons[0][j].getOwner() == buttons[1][j].getOwner();
                        boolean cond2 = buttons[1][j].getOwner() == buttons[2][j].getOwner();
                        if(cond1 && cond2) {
                            return buttons[0][j].getOwner();
                            }
                        }
                    }
                
                //diagonals
                if (buttons[0][0].isClaimed() && buttons[1][1].isClaimed() && buttons [2][2].isClaimed()) {
                    boolean cond1 = buttons[0][0].getOwner() == buttons[1][1].getOwner();
                    boolean cond2 = buttons[1][1].getOwner() == buttons[2][2].getOwner();
                    if(cond1 && cond2) {
                        return buttons[0][0].getOwner();
                    }
                }
                
                if (buttons[0][2].isClaimed() && buttons[1][1].isClaimed() && buttons [2][0].isClaimed()) {
                    boolean cond1 = buttons[0][2].getOwner() == buttons[1][1].getOwner();
                    boolean cond2 = buttons[1][1].getOwner() == buttons[2][0].getOwner();
                    if(cond1 && cond2) {
                        return buttons[0][2].getOwner();
                    }
                }
                
                return winner;
                }
                

	    /**
	     * @param args the command line arguments
	     */
	    public static void main(String[] args) {
	        Tttgui game = new Tttgui ();
	    }

	}