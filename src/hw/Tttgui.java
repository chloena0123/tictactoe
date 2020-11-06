package hw;



	import java.awt.Color;
	import java.awt.GridLayout;
	import javax.swing.JFrame;
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

	    public Tttgui() {
	        // Sends a title to the JFrame constructor
	        super("Tic Tac Toe");
	        
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setVisible(true);
	        
	        JPanel messagePanel = new JPanel();
	        
	        // FIX: Add text to the message panel
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
	        this.add(messagePanel);
	        this.add(gridPanel);
	        this.pack(); // Fits size to contents

	        currentPlayer = Player.X;

	    }


	    public void move(Button b){
	        if (!b.isClaimed()){
	            b.claim(currentPlayer);
	            // if player is X then change to O otherwise change to X
	            currentPlayer = (currentPlayer == Player.X) ? Player.O : Player.X ;
	        }
	    }

	    //FIX: make a winner method that checks whether 
	    //rows, cols, diagonals are all claimed, then
	    // checks whether the owner is the same for all 3

	    /**
	     * @param args the command line arguments
	     */
	    public static void main(String[] args) {
	        Tttgui game = new Tttgui ();
	    }

	}