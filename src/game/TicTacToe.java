package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToe implements ActionListener {

	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] buttons = new JButton[9];
	
	boolean player1_turn;
	
	TicTacToe(){
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(800, 800);
	frame.getContentPane().setBackground(Color.MAGENTA);
	frame.setLayout(new BorderLayout());

	
	textfield.setBackground(Color.BLACK);
	textfield.setForeground(Color.YELLOW);
	textfield.setHorizontalAlignment(JLabel.CENTER);
	textfield.setText("Tic-Tac-Toe");
	textfield.setFont(new Font(null, Font.PLAIN, 65));
	textfield.setOpaque(true);
	
	title_panel.setLayout(new BorderLayout());
	title_panel.setBounds(0, 0, 800, 100);
	title_panel.add(textfield);
	title_panel.setOpaque(true);
	
	button_panel.setLayout(new GridLayout(3,3));
	button_panel.setBackground(Color.black);
	
	for (int i =0; i<9; i++)
	{
		buttons[i] = new JButton();
		button_panel.add(buttons[i]);
		buttons[i].setFont(new Font(null, Font.ITALIC, 100));
		buttons[i].setFocusable(false);
		buttons[i].addActionListener(this);
	}

	frame.add(title_panel, BorderLayout.NORTH);
	frame.add(button_panel);
	frame.setVisible(true);
	
	firstTurn();
	
	}
	
	
	
	
	public void firstTurn()
	{
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	       if(random.nextInt(2)==0)
	       {
	    	   player1_turn = true;
	    	   textfield.setText("X turn");
	       }
	       else 
	       {
	    	   player1_turn = false;
	    	   textfield.setText("O turn");

	       }
	}
	
	public void check()
	{
		if (   (buttons[0].getText()=="X") &&
				(buttons[1].getText()=="X") &&
				(buttons[2].getText()=="X")
				
				)
		{
			xWins(0,1,2);
		}
		if (   (buttons[3].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[5].getText()=="X")
				
				)
		{
			xWins(3,4,5);
		}
		if (   (buttons[6].getText()=="X") &&
				(buttons[7].getText()=="X") &&
				(buttons[8].getText()=="X")
				
				)
		{
			xWins(6,7,8);
		}
		if (   (buttons[0].getText()=="X") &&
				(buttons[3].getText()=="X") &&
				(buttons[6].getText()=="X")
				
				)
		{
			xWins(0,3,6);
		}
		if (   (buttons[1].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[7].getText()=="X")
				
				)
		{
			xWins(1,4,7);
		}
		if (   (buttons[2].getText()=="X") &&
				(buttons[5].getText()=="X") &&
				(buttons[8].getText()=="X")
				
				)
		{
			xWins(2,5,8);
		}
		if (   (buttons[2].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[6].getText()=="X")
				
				)
		{
			xWins(2,4,6);
		}
		if (   (buttons[0].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[8].getText()=="X")
				
				)
		{
			xWins(0,4,8);
		}
		// CHECK O WINS
		
		if (   (buttons[0].getText()=="O") &&
				(buttons[1].getText()=="O") &&
				(buttons[2].getText()=="O")
				
				)
		{
			oWins(0,1,2);
		}
		if (   (buttons[3].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[5].getText()=="O")
				
				)
		{
			oWins(3,4,5);
		}
		if (   (buttons[6].getText()=="O") &&
				(buttons[7].getText()=="O") &&
				(buttons[8].getText()=="O")
				
				)
		{
			oWins(6,7,8);
		}
		if (   (buttons[0].getText()=="O") &&
				(buttons[3].getText()=="O") &&
				(buttons[6].getText()=="O")
				
				)
		{
			oWins(0,3,6);
		}
		if (   (buttons[1].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[7].getText()=="O")
				
				)
		{
			oWins(1,4,7);
		}
		if (   (buttons[2].getText()=="O") &&
				(buttons[5].getText()=="O") &&
				(buttons[8].getText()=="O")
				
				)
		{
			oWins(2,5,8);
		}
		if (   (buttons[2].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[6].getText()=="O")
				
				)
		{
			oWins(2,4,6);
		}
		if (   (buttons[0].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[8].getText()=="O")
				
				)
		{
			oWins(0,4,8);
		}
		
		
	}
	public void xWins(int a, int b, int c)
	{
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);

		for (int i=0; i<9; i++)
		{
			buttons[i].setEnabled(false);
		}
		textfield.setText("X wins");
	}
	public void oWins(int a, int b, int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for (int i=0; i<9; i++)
		{
			buttons[i].setEnabled(false);
		}
		textfield.setText("O wins");

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for (int i =0;i<9;i++)
		{
			if(e.getSource()==buttons[i])
			{
				if(player1_turn)
				{
					if(buttons[i].getText()=="")
					{
						buttons[i].setForeground(Color.CYAN);
						buttons[i].setText("X");
						player1_turn=false;
						textfield.setText("O Turn");
						check();
						
					}
				}
				else {
					if(buttons[i].getText()=="")
					{
						buttons[i].setForeground(Color.ORANGE);
						buttons[i].setText("O");
						player1_turn=true;
						textfield.setText("X Turn");
						check();
				}}
			}
		}
		
	}

}
