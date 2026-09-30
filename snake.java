import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class FDemo extends JFrame{
JPDemo jp;
FDemo()
{
jp=new JPDemo();
add(jp);
}
}
class JPDemo extends JPanel implements ActionListener,KeyListener
{
ImageIcon img1,img2,img3,img4;
Image dot,head,food,ck11;
int x[]=new int[100];
int y[]=new int[100];
int dots=5;
int score=0;
int high_score=0;
boolean start_game=false;
boolean gameOver=false;
boolean left=false,right=true,up=false,down=false;
int r1=0,r2=0;
Timer t;
JPDemo(){
x[0]=120;
y[0]=100;
x[1]=100;
y[1]=100;
x[2]=80;
y[2]=100;
x[3]=60;
y[3]=100;
x[4]=40;
y[4]=100;
setBackground(Color.black);
img1=new ImageIcon("dot.png");
dot=img1.getImage();
img2=new ImageIcon("head.png");
head=img2.getImage();
img3=new ImageIcon("food.png");
food=img3.getImage();
img4=new ImageIcon("ck11.jpg");
ck11=img4.getImage();


 t=new Timer(120,this);
t.start();

addKeyListener(this);
setFocusable(true);

randomDemo();
}
void randomDemo(){
	r1=(int)Math.round(Math.random()*25+2);
	r1=r1*20;
	r2=(int)Math.round(Math.random()*25+2);
	r2=r2*20;
	
}
public void paintComponent(Graphics g){
	super.paintComponent(g);
	g.drawImage(ck11,0,0,1400,1000,this);
	g.drawImage(food,r1,r2,this);
	  g.setColor(Color.RED);
	g.drawRect(40,40,1280,617);
	for(int i=0;i<dots;i++){
		if(i==0){
			g.drawImage(head,x[i],y[i],this);
		}
		else{
			g.drawImage(dot,x[i],y[i],this);
		}
		
Font f=new Font("",Font.BOLD,20);
		g.setColor(Color.red);
		g.setFont(f);
		g.drawString("score:"+score,20,30);
			g.drawString("high score:"+ high_score,1200,30);
		
		if(gameOver)
		{
      
     Font f1=new Font("Georgia",Font.BOLD,80);		
			g.setFont(f1);
	 g.drawString("   Game     Over",300,355);
     Font f2=new Font("",Font.BOLD,30);	
g.setFont(f2);
			g.setColor(Color.red);
			g.drawString("your score:"+score,530,70);
			g.drawString("Press R to Restart",510,420);
			
		}
}
}
public void actionPerformed(ActionEvent e)
{

	if(x[0]==r1&&y[0]==r2)
	{
		dots++;
		score++;
		if(score>high_score){
		high_score = score;
		}
		randomDemo();
	}
	if(start_game){
		start_game=true;
		gameOver=false;
		
		for(int i=1;i<dots;i++)
			{
			if(x[0]==x[i]&&y[0]==y[i]){
			start_game=false;
			gameOver=true;
			}
		}
			
		
		for(int i=dots;i>0;i--)
		{
			x[i]=x[i-1];
			y[i]=y[i-1];
		}
		if(right){
			x[0]=x[0]+20;
		}
			if(left){
			x[0]=x[0]-20;
		}	
		if(up){
			y[0]=y[0]-20;
		}	
		if(down){
			y[0]=y[0]+20;
		}
	
	if(x[0]<=40||x[0]>1280||y[0]<=40||y[0]>620)
	{
		start_game=false;
	gameOver = true;	
	}
		
/*
		if(x[0]<0)
		{
			x[0]=1900-20;
		}
		else if(x[0]>=1930)
		{
			x[0]=0;
		}
		if(y[0]<0)
		{
			y[0]=1000-20;
		}
		else if(y[0]>=1000)
		{
			y[0]=0;
		}
		
*/
	}
	repaint();
}
public void keyReleased(KeyEvent e){
}
public void keyPressed(KeyEvent e){
	if(e.getKeyCode() == KeyEvent.VK_SPACE){
    start_game = true;
}
        
	if(e.getKeyCode()==KeyEvent.VK_R&&gameOver==true)
        {
            restartGame();
        }
	if(start_game==true && gameOver==false){
		
	if(e.getKeyCode()==KeyEvent.VK_DOWN)
	{
		left=false;
		right=false;
		up=false;
		down=true;
	}
	if(e.getKeyCode()==KeyEvent.VK_RIGHT)
	{
		left=false;
		right=true;
		up=false;
		down=false;
	}
	if(e.getKeyCode()==KeyEvent.VK_LEFT)
	{
		left=true;
		right=false;
		up=false;
		down=false;
	}
	if(e.getKeyCode()==KeyEvent.VK_UP)
	{
		left=false;
		right=false;
		up=true;
		down=false;
	}
}
		
}
public void keyTyped(KeyEvent e){}
 void restartGame() {
t.restart();

        dots = 5;
        score = 0;

        x[0] = 120; y[0] = 100;
        x[1] = 100; y[1] = 100;
        x[2] = 80;  y[2] = 100;
        x[3] = 60;  y[3] = 100;
        x[4] = 40;  y[4] = 100;

        left = false;
        right = true;
        up = false;
        down = false;

        start_game = false;
        gameOver = false;
        randomDemo();

        repaint();
}
}
class Demo9{
	public static void main(String ar[])
	{
		FDemo f=new FDemo();
		f.setVisible(true);
		f.setSize(1930,1000);
		f.setLocation(0,0);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
	}
}