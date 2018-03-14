import java.io.*;
import java.util.*;

public class TicTacToe implements Runnable
{
	private String ip="localhost";
	private int port=22222;
	private Scanner scanner=new Scanner(System.in);
	private JFrame frame;
	private final int WIDTH=507;
	private final int HEIGHT=528;
	private Thread thread;
	
	private Painter painter;
	private Socket socket;      //to connect the server to communicate between two machines
	private DataOutputStream dos;    
	private DataInputStream dis;
	
	private ServerSocket serverSocket;
	private BufferedImage board;
	private BufferedImage red;
	private BufferedImage blue;
	private BufferedImage redCircle;
	private BufferedImage blueCircle;
	
	private String[] spaces=new String[9];    //for 9 squares of board
	private boolean yourturn=false;
	private boolean circle=true;
	private boolean accepted=false;
	private boolean unablrToCommunicateWithOpponent=false;
	private boolean won=false;
	private boolean enemyWon=false;
	
	private int lenghtOfSpace=160;    //each box will be of 160*160
	private int errors=0;     //if any this will be incremented by 1 & unableToCommunicate will turn true
	private int firstSpot=-1;    // when won it will drew line starting from this 
	private int secondSpot=-1;   // till this
	
	private Font font=new Font("Verdana", Font.BOLD,32);
	private Font smallerFont=new Font("Verdana",Fond.BOLD,20);
	private Font largerFont=new Font("Verdana", Font.BOLD,50);
	
	private String waitingString="waiting for another player";
	private String unableToCommunicateWithOpponentString="uanble to communicate with opponent";
	private String wonString="You won!";
	private String enemyWon="Opponent won!";
	
	public TicTacToe()
	{
		System.out.println("Enter your ip: ");
		ip=scanner.nextLine();
		System.out.println("Enter your port: ");
		port=scanner.nextInt();
		while(port<1 || port>65536)
		{
			System.out.println("The port you entered is invalid.");
			System.out.println("Please enter a valid port: ");
			port=scanner.nextInt();
		}
		
		loadImages();
		
		painter =new Painter();
		painter.setPreferredSize(new Dimension(WIDTH,HEIGHT));
	}
	public void run()
	{
		
	}
	
	public void loadImages()
	{
		try
		{
			board=ImageIO.read(getClass().getResourceAsStream("/board.png"));
			redX=ImageIO.read(getClass().getResourceAsStream("/redX.png"));
			redCircle=ImageIO.read(getClass().getResourceAsStream("/redCircle.png"));
			blueX=ImageIO.read(getClass().getResourceAsStream("/blueX.png"));
			blueCircle=ImageIO.read(getClass().getResourceAsStream("/blueCircle.png"));
		}
		catch(IOException)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		TicTacToe tictactoe= new TicTacToe();
		
	}
	
	private class Painter extends JPanel implements mouseListener	
	{
		private static final long serialVersionUID=1L;
		
		public Painter()
		{
			setFocusable(true);
			requestFocus();
			setBackground(Color.WHITE);
			addMouseListener(this);
		}
		public void mouseClicked(MouseEvent e)
		{
			
		}
		
		public void mousePressed(MouseEvent e)
		{
			
		}
		public void mouseReleased(MouseEvent e)
		{
			
		}
		public void mouseEntered(MouseEvent e)
		{
			
		}
		public void mouseExited(MouseEvent e)
		{
			
		}
	}
}
