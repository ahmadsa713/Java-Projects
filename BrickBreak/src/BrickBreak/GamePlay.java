package BrickBreak;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;




import javax.swing.JPanel;

import javax.swing.Timer;



import java.awt.Graphics2D;

public class GamePlay extends JPanel implements KeyListener , ActionListener {

	private boolean play = false;
	private int score=0;
	private int TotalBricks = 21;
	private Timer timer;
	private int delay = 8;
	
	private int playerX = 310;
	
	private int ballposX = 120;
	private int ballposY = 350;
	private int ballxdir = -1;
	private int ballydir = -2;
	
	private MapGen map;
	
	public GamePlay() {
		map = new MapGen(3,7);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
		
	}
	
	public void paint(Graphics g) {
		
		g.setColor(Color.BLACK);
		g.fillRect(1, 1, 692, 592);
		
		
		map.draw((Graphics2D)g);
		
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691, 0, 3, 592);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("serif", Font.BOLD,25));
		g.drawString(""+score,590 , 30);
		
		
		g.setColor(Color.GREEN);
		g.fillRect(playerX, 550, 100, 8);
		
		g.setColor(Color.YELLOW);
		g.fillOval(ballposX, ballposY, 20, 20);
		
		if(TotalBricks <=0) {
			play =false;
			ballxdir =0;
			ballydir = 0;
			g.setColor(Color.RED);
			g.setFont(new Font("serif", Font.BOLD,30));
			g.drawString("You Win", 260, 300);
			
			g.setFont(new Font("serif", Font.BOLD,20));
			g.drawString("Press Enter to Play Again", 230, 350);
			
			
			
		}
		
		
		
		if(ballposY >570) {
			play =false;
			ballxdir =0;
			ballydir = 0;
			g.setColor(Color.RED);
			g.setFont(new Font("serif", Font.BOLD,30));
			g.drawString("Game Over, Scores:", 190, 300);
			
			g.setFont(new Font("serif", Font.BOLD,20));
			g.drawString("Press Enter to Play Again", 230, 350);
			
		}
		
		g.dispose();
		
	}
	
	
	public void keyPressed(KeyEvent arg0) {}
	
	public void keyTyped(KeyEvent arg0) {}

	
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(!play) {
				play=true;
				ballposX=120;
				ballposY= 350;
				ballxdir=-1;
				ballydir=-2;
				playerX = 310;
				score=0;
				TotalBricks=21;
				map=new MapGen(3,7);
				
				repaint();
			}
			
		}
		
		
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(playerX >= 600) {
				playerX= 600;
				}
			
			else {
				moveRight();
			}
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				if(playerX < 10) {
					playerX= 10;
					
				}
				
				else {
					moveLeft();
				}			
		}
			
		
	}
		
		
		
		
	}
	
	
	
	
	
	
	public void moveRight() {
		play = true;
		playerX += 20; 
		
	}
	
	public void moveLeft() {
		play = true;
		playerX -= 20; 
		
	}

	
	

	
	public void actionPerformed(ActionEvent e) {
		
		timer.start();
		
		if(play) {
			
			if(new Rectangle(ballposX, ballposY,20,20).intersects(new Rectangle(playerX,550,100,8))) {
				ballydir = -ballydir;	
			}
			
		A:	for(int i=0; i<map.map.length;i++) {
				for(int j=0;j< map.map[0].length;j++) {
					int brickX = j* map.brickWidth+80;
					int brickY = i* map.brickHeight+50;
					int brickWidth = map.brickWidth;
					int brickHeight = map.brickHeight;
					
					Rectangle rect = new Rectangle(brickX,brickY,brickWidth,brickHeight);
					Rectangle ballRect = new Rectangle(ballposX,ballposY,20,20);
					Rectangle brickRect = rect;
					
					if(ballRect.intersects(brickRect)) {
						map.setBrickValue(0, i, j);
						TotalBricks--;
						score += 5;
						
						if(ballposX +19 <= brickRect.x || ballposX +1 >= brickRect.x + brickRect.width) {
							ballxdir = -ballxdir;
						}
						else {
							ballydir=-ballydir;
						}
						
						break A;
					}
				}
			}
			
			ballposX += ballxdir;
			ballposY += ballydir;
			
			if(ballposX < 0) {
				ballxdir = -ballxdir;
				}
			
			if(ballposY < 0) {
				ballydir = -ballydir;
				}
			
			if(ballposX > 670) {
				ballxdir = -ballxdir;
				}
			
			}
		
		repaint();
	
	}		
		
	}


