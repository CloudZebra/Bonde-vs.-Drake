
//Huvudkods filen vilket är den som alla andra skall vara samanbundna.  

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainGame implements ActionListener {

	// Variabel deklaration.
	private JFrame Frame = new JFrame("Bonde vs. Drake");
	private JLayeredPane MainPane = new JLayeredPane();
	private JPanel MainPanel = new JPanel();
	private JPanel ButtonPanel = new JPanel();
	private JPanel AttributePanel = new JPanel();
	private JPanel EquipmentPanel = new JPanel();
	private JPanel South = new JPanel();
	private JPanel MainTextPanel = new JPanel();
	private JPanel HPPanel = new JPanel();
	private JPanel DEFPanel = new JPanel();
	private JPanel SkillPanel = new JPanel();
	private JPanel SpeedPanel = new JPanel();
	private JLabel HPNumber = new JLabel();
	private JLabel DEFNumber = new JLabel();
	private JLabel SkillNumber = new JLabel();
	private JLabel SpeedNumber = new JLabel();
	private JLabel MainText = new JLabel(); 
	private JLabel HP = new JLabel();
	private JLabel DEF = new JLabel();
	private JLabel Skill = new JLabel();
	private JLabel Speed = new JLabel();;
	private int CombatFlip = 1;
	private int StoryLoggCounter = 0;
	private int Chapter = 1;
	private int Tier = 0;
	private int Heals = 5;
	private int MonsterHP = 0;
	private int MonsterSkill = 0;
	private int PlayerMaxHP = 50;
	private int PlayerHP = 50;
	private int CombatStart = 1;
	private int PlayerWeapon = 4;
	private int PlayerSpeed = 5;
	private int Choice = 0;
	private int PlayerSkill = 5;
	private int PlayerDefense = 6;
	private int MonsterDefense = 0;
	private int MonsterDamage = 0;
	private int MonsterSpeed = 0;
	private int NumberOfBreakRows = 0;
	private String SRC = "src/";
	private String StoryLoggPrint = "";
	private String MainWindowText = "";
	private String CombatLogg = "";
	private String MonsterName = "";
	private String StoryLogg = "";
	private int PrintErrorCorrector = 1;
	private boolean TempCombatPrint = false;
	private boolean CombatPrint = false;
	private boolean Dead = false;
	private boolean Combat = false;
	public boolean Attack = false;
	private BufferedReader StoryBuffer;
	
	//Getters och setters
	public int getChoice() {
		return Choice;
	}

	public void setChoice(int choice) {
		Choice = choice;
	}
	public int getMonsterHP() {
		return MonsterHP;
	}

	public void setMonsterHP(int monsterHP) {
		MonsterHP = monsterHP;
	}
	public int getMonsterDefense() {
		return MonsterDefense;
	}

	public void setMonsterDefense(int monsterDefense) {
		MonsterDefense = monsterDefense;
	}

	public int getMonsterDamage() {
		return MonsterDamage;
	}

	public void setMonsterDamage(int monsterDamage) {
		MonsterDamage = monsterDamage;
	}

	public int getMonsterSpeed() {
		return MonsterSpeed;
	}

	public void setMonsterSpeed(int monsterSpeed) {
		MonsterSpeed = monsterSpeed;
	}

	public int getMonsterSkill() {
		return MonsterSkill;
	}

	public void setMonsterSkill(int monsterSkill) {
		MonsterSkill = monsterSkill;
	}

	public String getMonsterName() {
		return MonsterName;
	}

	public void setMonsterName(String monsterName) {
		MonsterName = monsterName;
	}
	public void setCombat(boolean combat) {
		this.Combat = combat;
	}

	public void setPlayerHP(int playerHP) {
		PlayerHP = playerHP;
	}
	
	// Skapar en JFrame(fönster) och gör de statiska delarna, Paneler, Knappar och layout och bilder
	public MainGame() {
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame.getContentPane().setBackground(Color.BLACK);
		Frame.setPreferredSize(new Dimension(750, 1025));
		Frame.setLayout(new BorderLayout());
		
		MainPane.setLayout(new BorderLayout());
		Frame.add(MainPane);

		MainPanel.setLayout(new BorderLayout());
		MainPanel.setSize(700, 710);
		MainPanel.setOpaque(false);
		MainPanel.setBorder(BorderFactory.createEmptyBorder(60, 60, 0, 0));
		MainPane.add(MainPanel, BorderLayout.NORTH);
		MainPane.setLayer(MainPanel, 8);
		
		
		
		ButtonPanel.setPreferredSize(new Dimension(750, 50));
		ButtonPanel.setLayout(new GridLayout(1, 3));

		JButton Button1 = new JButton(new ImageIcon(SRC+"Img/ButtonNotPressedA.png"));
		Button1.setPreferredSize(new Dimension(240, 50));
		Button1.setFont(Button1.getFont().deriveFont(40.0f));
		Button1.setActionCommand("A");

		Button1.addActionListener(this);

		JButton Button2 = new JButton(new ImageIcon(SRC+"Img/ButtonNotPressedB.png"));
		Button2.setPreferredSize(new Dimension(240, 50));
		Button2.setFont(Button2.getFont().deriveFont(40.0f));
		Button2.setActionCommand("B");

		Button2.addActionListener(this);

		JButton Button3 = new JButton(new ImageIcon(SRC+"Img/ButtonNotPressedC.png"));
		Button3.setPreferredSize(new Dimension(240, 50));
		Button3.setFont(Button3.getFont().deriveFont(40.0f));
		Button3.setActionCommand("C");

		Button3.addActionListener(this);

		AttributePanel.setPreferredSize(new Dimension(250, 200));
		AttributePanel.setBackground(Color.YELLOW);
		AttributePanel.setLayout(new GridLayout(4, 1));
		AttributePanel.setOpaque(false);

		EquipmentPanel.setPreferredSize(new Dimension(500, 200));
		EquipmentPanel.setBackground(Color.CYAN);
		EquipmentPanel.setLayout(new GridLayout(1, 2));
		EquipmentPanel.setOpaque(false);
		
		ButtonPanel.add(Button1);
		ButtonPanel.add(Button2);
		ButtonPanel.add(Button3);

		South.setLayout(new BorderLayout());
		South.setBackground(Color.GRAY);

		South.add(ButtonPanel, BorderLayout.NORTH);
		South.add(AttributePanel, BorderLayout.WEST);
		South.add(EquipmentPanel, BorderLayout.EAST);
		
		HPPanel.setOpaque(false);
		DEFPanel.setOpaque(false);
		SkillPanel.setOpaque(false);
		SpeedPanel.setOpaque(false);

		MainPane.add(South, BorderLayout.SOUTH);
		MainPane.setLayer(South, 0);

		MainTextPanel.setLayout(new GridLayout(1, 1));
		
		try {
			BufferedImage MyPicture = ImageIO.read(new File(SRC+"Img/PixelRam.png"));

			MainText = new JLabel(new ImageIcon(MyPicture));
			MainText.setOpaque(true);
		} catch (IOException IOException) {
			IOException.printStackTrace();
		}
		try {
			BufferedImage AttributeIcon = ImageIO.read(new File(SRC+"Img/HP.png"));

			  HP = new JLabel(new ImageIcon(AttributeIcon));
	          HP.setOpaque(false);
	        } catch (IOException IOException) {
	            IOException.printStackTrace();
	        }
		try {
			BufferedImage AttributeIcon = ImageIO.read(new File(SRC+"Img/DEF.png"));

			  DEF= new JLabel(new ImageIcon(AttributeIcon));
	          DEF.setOpaque(false);
	        } catch (IOException IOException) {
	            IOException.printStackTrace();
	        }
		try {
			BufferedImage AttributeIcon = ImageIO.read(new File(SRC+"Img/Skill.png"));

			  Skill= new JLabel(new ImageIcon(AttributeIcon));
	          Skill.setOpaque(false);
	        } catch (IOException IOException) {
	            IOException.printStackTrace();
	        }
		try {
			BufferedImage AttributeIcon = ImageIO.read(new File(SRC+"Img/Speed.png"));

			  Speed = new JLabel(new ImageIcon(AttributeIcon));
	          Speed.setOpaque(false);
	        } catch (IOException IOException) {
	            IOException.printStackTrace();
	        }	
		Draw();
	}
	
	//Ritar ut texten i huvudfönstret.
	public void Draw(){
		MainWindowText = "";
		TempCombatPrint = CombatPrint;
		if(Combat == false && CombatPrint==false)
		{
			String StorySRC = "";
			if(Tier==0){StorySRC = "Prologue"+Chapter; StoryLoggPrint = ""; StoryLogg = ""; StoryLoggCounter = 0; NumberOfBreakRows = 0;}
			if(Tier==1){StorySRC = "Skog"+Chapter; StoryLoggPrint = ""; StoryLogg = ""; StoryLoggCounter = 0; NumberOfBreakRows = 0;}
			if(Tier==2){StorySRC = "Trask"+Chapter; StoryLoggPrint = ""; StoryLogg = ""; StoryLoggCounter = 0; NumberOfBreakRows = 0;}
			if(Tier==3){StorySRC = "Kust"+Chapter; StoryLoggPrint = ""; StoryLogg = ""; StoryLoggCounter = 0; NumberOfBreakRows = 0;}
			if(Tier==4){StorySRC = "Berg"+Chapter; StoryLoggPrint = ""; StoryLogg = ""; StoryLoggCounter = 0; NumberOfBreakRows = 0;}
			if(Tier==5){StorySRC = "Epilogue"+Chapter; StoryLoggPrint = ""; StoryLogg = ""; StoryLoggCounter = 0; NumberOfBreakRows = 0;} System.out.println(StorySRC);
			System.out.println(SRC+"Doc/"+StorySRC+".txt");
			try {StoryBuffer = new BufferedReader(new InputStreamReader(new FileInputStream(SRC+"Doc/"+StorySRC+".txt")));}
			catch (FileNotFoundException Exception) {Exception.printStackTrace();}
			try {
			    String StoryLine = "";
			    while ((StoryLine = StoryBuffer.readLine()) != null) 
			    {
			    	StoryLogg = StoryLogg+StoryLine;
			    }
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
			    try {
					StoryBuffer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			StoryLogg = "<html>"+StoryLogg+"";
			char[] StoryLoggChar = StoryLogg.toCharArray();
			while(StoryLoggChar.length>StoryLoggCounter)
			{
				StoryLoggPrint = StoryLoggPrint+StoryLoggChar[StoryLoggCounter];
				if(StoryLoggCounter % 50 == 0 && StoryLoggCounter != 0)
				{
					int StoryLoggCounterTemp = StoryLoggCounter;
					while(StoryLoggChar[StoryLoggCounterTemp] != ' ')
					{
						StoryLoggCounterTemp--;
					}
					StoryLoggPrint = new StringBuilder(StoryLoggPrint).insert((StoryLoggCounterTemp+(4*NumberOfBreakRows)), "<br>").toString();
					NumberOfBreakRows++;
				}
				if(StoryLoggCounter == StoryLoggChar.length-1)
				{
					StoryLoggPrint = StoryLoggPrint+"</html>";
				}
				StoryLoggCounter++;
			}
			MainWindowText = StoryLoggPrint;
			Choice = 0;
		}
		else
		{
			MainWindowText = "<html>";
			MainWindowText = MainWindowText+""+CombatLogg;
			MainWindowText = MainWindowText+"</html>";
			Choice = 0;
			CombatPrint = false;
		}
		if(TempCombatPrint==true && Combat==false)
		{
			CombatLogg = "";
			PrintErrorCorrector = 1;
		}
		MainText.setText(MainWindowText);
		MainText.setFont(new Font("Verdana", Font.PLAIN, 24));
		MainText.setHorizontalTextPosition(SwingConstants.CENTER);
		MainPanel.add(MainText, BorderLayout.NORTH);
		MainPane.setLayer(MainText, 7);
		
		HPNumber.setFont(new Font("Verdana", Font.PLAIN, 36));
		DEFNumber.setFont(new Font("Verdana", Font.PLAIN, 36));
		SkillNumber.setFont(new Font("Verdana", Font.PLAIN, 36));
		SpeedNumber.setFont(new Font("Verdana", Font.PLAIN, 36));
		HPPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
		DEFPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
		SkillPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
		SpeedPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
		HPNumber.setText(String.valueOf(PlayerHP)+"/"+String.valueOf(PlayerMaxHP)+" "+String.valueOf(Heals)+"/5");
		DEFNumber.setText(String.valueOf(PlayerDefense));
		SkillNumber.setText(String.valueOf(PlayerSkill+" ("+PlayerWeapon+")"));
		SpeedNumber.setText(String.valueOf(PlayerSpeed));
		
		HPPanel.add(HP);
		HPPanel.add(HPNumber);
		DEFPanel.add(DEF);
		DEFPanel.add(DEFNumber);
		SkillPanel.add(Skill);
		SkillPanel.add(SkillNumber);
		SpeedPanel.add(Speed);
		SpeedPanel.add(SpeedNumber);
		AttributePanel.add(HPPanel);
		AttributePanel.add(DEFPanel);
		AttributePanel.add(SkillPanel);
		AttributePanel.add(SpeedPanel);
		MainTextPanel.add(MainText);

		MainPane.add(MainTextPanel, BorderLayout.NORTH);
		MainPane.setLayer(MainTextPanel, 4);

		Frame.setResizable(false);
		Frame.pack();
		Frame.setVisible(true);
		}
	
	// Startfunktioner där programmet starter och gör en instans av MainGame som är spelet.
	public static void main(String[] args) {

		new MainGame();

	}
	
	//Kollar vilken knapp du klickar på, startar strids funktionen och kollar valen.
	public void actionPerformed(ActionEvent ButtonClicked) {
		System.out.println(((JButton) ButtonClicked.getSource()).getActionCommand());
		if(!Dead) {
		if (((JButton) ButtonClicked.getSource()).getActionCommand() == "A") {
			Choice = 1;
			Choice(Choice);
			setChoice(Choice);
			
			if(Tier==2 && Chapter==25) {
				Chapter = 26;
				Draw();
				Dead=true;
			}
			if(Tier == 3 && Chapter == 19){
				Chapter = 20;
				PlayerDefense = 8;
				Draw();
			} else if(Tier==3 && Chapter==20){
				Chapter=23;
				PlayerDefense = 8;
				Draw();
			}
			if(Tier == 4 && Chapter == 10){
				Chapter = 11;
				PlayerWeapon = 5;
				Draw();
				
			} else if(Tier == 4 && Chapter == 11){
				Chapter = 14;
				PlayerWeapon = 5;
				Draw();
			}
			
			if(Tier==1 && Chapter==21 && CombatFlip == 1)
				Combat=true;
			if(Tier==2 && Chapter==4 && CombatFlip == 1)
				Combat=true;
			if(Tier==2 && Chapter==7 && CombatFlip == 1)
				Combat=true;
			if(Tier==2 && Chapter==18 && CombatFlip == 1)
				Combat=true;
			if(Tier==3 && Chapter==5 && CombatFlip == 1)
				Combat=true;
			if(Tier==3 && Chapter==12 && CombatFlip == 1)
				Combat=true;
			if(Tier==3 && Chapter==16 && CombatFlip == 1)
				Combat=true;
			if(Tier==4 && Chapter==3 && CombatFlip == 1)
				Combat=true;
			if(Tier==4 && Chapter==7 && CombatFlip == 1)
				Combat=true;
			if(Tier==5 && Chapter==5 && CombatFlip == 1)
				Combat=true;
			if(Combat==true && CombatFlip == 1)
			{
				CombatStart=1;
				CombatFlip++;
			}
			
			if(Dead==true)
			{
				System.out.println("Du Suger");
				JOptionPane.showMessageDialog(null, "Du dog!");
			}
		}
		if (((JButton) ButtonClicked.getSource()).getActionCommand() == "B") {
			Choice = 2;
			Choice(Choice);
			setChoice(Choice);
			
			if(Tier == 2 && Chapter == 25){
				Chapter = 27;
				PlayerSpeed = 7;
				Draw();

			} else if(Tier==2 && Chapter==27){
				Chapter=29;
				PlayerSpeed = 7;
				Draw();
			}
			if(Tier==3 && Chapter==19) {
				Chapter = 21;
				Draw();
				Dead=true;
			}
			if(Tier==4 && Chapter==10) {
				Chapter = 12;
				Draw();
				Dead=true;
			}
			
			if(Tier==1 && Chapter==21 && CombatFlip == 1)
				Combat=true;
			if(Tier==2 && Chapter==4 && CombatFlip == 1)
				Combat=true;
			if(Tier==2 && Chapter==7 && CombatFlip == 1)
				Combat=true;
			if(Tier==2 && Chapter==18 && CombatFlip == 1)
				Combat=true;
			if(Tier==3 && Chapter==5 && CombatFlip == 1)
				Combat=true;
			if(Tier==3 && Chapter==12 && CombatFlip == 1)
				Combat=true;
			if(Tier==3 && Chapter==16 && CombatFlip == 1)
				Combat=true;
			if(Tier==4 && Chapter==3 && CombatFlip == 1)
				Combat=true;
			if(Tier==4 && Chapter==7 && CombatFlip == 1)
				Combat=true;
			if(Tier==5 && Chapter==5 && CombatFlip == 1)
				Combat=true;
			if(Combat==true && CombatFlip == 1)
			{
				CombatStart=1;
				CombatFlip++;
			}
			if(Dead==true)
			{
				System.out.println("Du Suger");
				JOptionPane.showMessageDialog(null, "Du dog!");
			}
		}
		if (((JButton) ButtonClicked.getSource()).getActionCommand() == "C") {
			Choice = 3;
			Choice(Choice);
			setChoice(Choice);
			
			if(Tier==2 && Chapter==25) {
				Chapter = 28;
				Draw();
				Dead= true;
			}
			if(Tier==3 && Chapter==19) {
				Chapter = 22;
				Draw();
				Dead=true;
			}	
			if(Tier==4 && Chapter==10) {
				Chapter = 13;
				Draw();
				Dead=true;
			}
			if(Tier==1 && Chapter==21 && CombatFlip == 1)
				Combat=true;
			if(Tier==2 && Chapter==4 && CombatFlip == 1)
				Combat=true;
			if(Tier==2 && Chapter==7 && CombatFlip == 1)
				Combat=true;
			if(Tier==2 && Chapter==18 && CombatFlip == 1)
				Combat=true;
			if(Tier==3 && Chapter==5 && CombatFlip == 1)
				Combat=true;
			if(Tier==3 && Chapter==12 && CombatFlip == 1)
				Combat=true;
			if(Tier==3 && Chapter==16 && CombatFlip == 1)
				Combat=true;
			if(Tier==4 && Chapter==3 && CombatFlip == 1)
				Combat=true;
			if(Tier==4 && Chapter==7 && CombatFlip == 1)
				Combat=true;
			if(Tier==5 && Chapter==5 && CombatFlip == 1)
				Combat=true;
			if(Combat==true && CombatFlip == 1)
			{
				CombatStart=1;
				CombatFlip++;
			}
			
			if(Dead==true)
			{
				System.out.println("Du Suger");
				JOptionPane.showMessageDialog(null, "Du dog!");
			}
		}
		return;
	}
}
	//Här ändrar den tiers (Akter)
	public void Choice(int Choice) {
		if(Chapter>11 && Tier == 0)
		{
			Chapter = 0;
			Tier++;
		} 
		else if(Chapter>22 && Tier == 1)
		{
			Chapter = 0;
			Tier++;
		}
		else if(Chapter>28 && Tier == 2)
		{
			Chapter = 0;
			Tier++;
		}
		else if(Chapter>23 && Tier == 3)
		{
			Chapter = 0;
			Tier++;
		}
		else if(Chapter>13 && Tier == 4)
		{
			Chapter = 0;
			Tier++;
		}
		else if(Chapter>15 && Tier == 5){
			JOptionPane.showMessageDialog(null, "Du har vunnit! Grattis!");
		}
		//Combat metoden, bestämmer när combat är slut.
		if (Combat == true)
		{
			CombatPrint=true;
			CombatManager CombatInstance = new CombatManager(Heals, CombatLogg, Tier, CombatStart, getMonsterDefense(), getMonsterDamage(),
					getMonsterSpeed(), getMonsterName(), MonsterHP, Choice, Combat, PlayerHP, PlayerMaxHP, PlayerSkill, PlayerWeapon,
					PlayerDefense, PlayerSpeed, Dead);
			CombatLogg = CombatInstance.getGameMainTextLogg();
			PlayerHP = CombatInstance.getPlayerHP();
			MonsterHP = CombatInstance.getMonsterHP();
			if (MonsterHP < 1) {
				Combat = false;
				CombatFlip--;
			}
			if(PlayerHP < 1)
			{
				Dead=true;
				Combat = false;
				CombatFlip--;
			}
			if (CombatStart == 1) {
				MonsterDefense = CombatInstance.getMonsterDefense();
				MonsterDamage = CombatInstance.getMonsterDamage();
				MonsterSpeed = CombatInstance.getMonsterSpeed();
				MonsterName = CombatInstance.getMonsterName();
				setMonsterName(MonsterName);
				setMonsterDefense(MonsterDefense);
				setMonsterDamage(MonsterDamage);
				setMonsterSpeed(MonsterSpeed);
				MonsterHP = CombatInstance.getMonsterMaxHP();
				CombatStart = 0;
				CombatLogg = "Du möter en "+MonsterName+" som har "+MonsterHP+" HP";
			}
			Heals = CombatInstance.getHeals();
		}
		//Denna fortsätter berättelsen.
		if(PrintErrorCorrector == 1)
		{
			PrintErrorCorrector = 2;
			Chapter--;
		}
		if(Tier==0 && !Combat){
			Chapter++;
		}
		if(Tier==1 && !Combat){
			Chapter++;
		}
		if(Tier==2 && Chapter!=25 && Chapter!=27 && !Combat){
			Chapter++;
		}
		if(Tier==3 && Chapter!=19 && Chapter!=20 && !Combat){
			Chapter++;
		}
		if(Tier==4 && Chapter!=10 && Chapter!=11 && !Combat){
			Chapter++;
		}
		if(Tier==5 && !Combat){
			Chapter++;
		}
		Draw();
	}
}
