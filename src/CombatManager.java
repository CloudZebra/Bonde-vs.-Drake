import java.util.Random;

//Funktionerna för stridsmekaniken.


public class CombatManager {
	//Variabel deklaration
	private String MonsterName;
	private int MonsterHP;
	private String GameMainTextLogg="";
	private int MonsterDamage;
	private int MonsterSpeed;
	private int MonsterDefense;
	private int Heals;
	private int PlayerHP;
	private int PlayerMaxHP;
	private int MonsterMaxHP;
	private boolean Combat = true;
	
	//Getters och setters
	public int getHeals() {
		return Heals;
	}

	public int getMonsterMaxHP() {
		return MonsterMaxHP;
	}

	public void setMonsterMaxHP(int monsterMaxHP) {
		MonsterMaxHP = monsterMaxHP;
	}

	public void setHeals(int heals) {
		Heals = heals;
	}
	public int getPlayerMaxHP() {
		return PlayerMaxHP;
	}

	public void setPlayerMaxHP(int playerMaxHP) {
		PlayerMaxHP = playerMaxHP;
	}
	
	public String getGameMainTextLogg() {
		return GameMainTextLogg;
	}

	public void setGameMainTextLogg(String GameMainTextLogg) {
		GameMainTextLogg = GameMainTextLogg;
	}

	public int getMonsterHP() {
		return MonsterHP;
	}

	public void setMonsterHP(int monsterHP) {
		MonsterHP = monsterHP;
	}

	public String getMonsterName() {
		return MonsterName;
	}

	public void setMonsterName(String monsterName) {
		MonsterName = monsterName;
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

	public int getMonsterDefense() {
		return MonsterDefense;
	}

	public void setMonsterDefense(int monsterDefense) {
		MonsterDefense = monsterDefense;
	}

	public boolean isCombat() {
		return Combat;
	}

	public void setCombat(boolean Combat) {
		this.Combat = Combat;
	}

	public int getPlayerHP() {
		return PlayerHP;
	}

	public void setPlayerHP(int playerHP) {
		PlayerHP = playerHP;
	}

	//stridsinstans som gör allt från att hämta Monster, Matten för träffchans och skada etc.
	public CombatManager(int Heals, String GameMainText, int Tier, int CombatStart, int MonsterDefense, int MonsterDamage, int MonsterSpeed,
			String MonsterName, int MonsterHP, int Choice, boolean Combat, int PlayerHP, int PlayerMaxHP, int PlayerSkill,
			int PlayerWeapon, int PlayerDefense, int PlayerSpeed, boolean Dead) {
		setPlayerMaxHP(PlayerMaxHP);
		setHeals(Heals);
		if (CombatStart == 1) {
			MonsterCreator MonsterInstance = new MonsterCreator(Tier, MonsterName, MonsterHP, MonsterDamage, MonsterSpeed,
					MonsterDefense, CombatStart);
			MonsterHP = MonsterInstance.getMonsterHP();
			setPlayerHP(PlayerHP);
			MonsterName = MonsterInstance.getMonsterName();
			setMonsterName(MonsterName);
			MonsterDamage = MonsterInstance.getMonsterDamage();
			setMonsterDamage(MonsterDamage);
			MonsterDefense = MonsterInstance.getMonsterDefense();
			setMonsterDefense(MonsterDefense);
			MonsterSpeed = MonsterInstance.getMonsterSpeed();
			setMonsterSpeed(MonsterSpeed);
			setMonsterMaxHP(MonsterHP);

			if (PlayerSpeed > 10) {
				PlayerSpeed = (PlayerSpeed - ((PlayerSpeed - 10) / 2));
			}

			if (MonsterSpeed > 10) {
				MonsterSpeed = (MonsterSpeed - ((MonsterSpeed - 10) / 2));
			}
		}
		if (Combat == true) 
		{
			char[] BRCheck = GameMainText.toCharArray();
			int BRCheckCounter = 0;
			int BRCounter = 0;
			while(BRCheck.length>BRCheckCounter)
			{
				if(BRCheck[BRCheckCounter] == '<' && BRCheck[BRCheckCounter+1] == 'b' && BRCheck[BRCheckCounter+2] == 'r' && BRCheck[BRCheckCounter+3] == '>')
				{
					BRCounter++;
				}
				BRCheckCounter++;
			}
			if(BRCounter>15)
			{
				GameMainTextLogg = "";
			}
			else
			{
				GameMainTextLogg = GameMainText;
			}
			Random Rand = new Random();
			int PlayerHitThreshhold = ((MonsterSpeed) / (PlayerSpeed - 3) + 7);
			int PlayerHitLight = (int) (Math.floor(Rand.nextInt(10)) + (PlayerSpeed));
			int PlayerHitHeavy = (int) (Math.floor(Rand.nextInt(6)) + (PlayerSpeed));
			int MonsterHitThreshhold = ((PlayerSpeed) / (MonsterSpeed - 3) + 7);
			int MonsterHit = (int) (Math.floor(Rand.nextInt(10)) + (MonsterSpeed));
			GameMainTextLogg = GameMainTextLogg+"<br> Spelarerns träff rullning: " + PlayerHitLight + " Träff gränsen: " + PlayerHitThreshhold+"<br>";

			if(Choice == 3 && Heals<1)
			{
				GameMainTextLogg = GameMainTextLogg+"Du försökte hela dig men du har inga mer potions!<br>";
			}
			if(Choice == 3 && Heals>0){
				GameMainTextLogg = GameMainTextLogg+"Spelaren Helade sig till fullt HP! "+(Heals-1)+"/5 Potions kvar<br>";
				PlayerHP=PlayerMaxHP;
				Heals--;
				setHeals(Heals);
			}

			if (PlayerHitLight >= PlayerHitThreshhold && Choice == 1) {
				int PlayerDamage = (int) Math.floor(PlayerWeapon * (PlayerSkill * 0.6));
				int TempMonsterHP = MonsterHP;
				MonsterHP = (int) Math.floor(MonsterHP
						- (PlayerDamage - (PlayerDamage * ((double) MonsterDefense / ((double) MonsterDefense + 5)))));
				if (TempMonsterHP == MonsterHP) {
					MonsterHP--;
				}
				GameMainTextLogg = GameMainTextLogg+"Utdelad skada: " + (TempMonsterHP-MonsterHP)+"<br>";
			}

			if (PlayerHitHeavy >= PlayerHitThreshhold && PlayerHitHeavy < PlayerSpeed + 5 && Choice == 2) {
				int PlayerDamage = (int) Math.floor(PlayerWeapon * (PlayerSkill));
				int TempMonsterHP = MonsterHP;
				MonsterHP = (int) Math.floor(MonsterHP
						- (PlayerDamage - (PlayerDamage * ((double) MonsterDefense / ((double) MonsterDefense + 5)))));
				if (TempMonsterHP == MonsterHP) {
					MonsterHP--;
				}
				GameMainTextLogg = GameMainTextLogg+"Utdelad skada: " +(TempMonsterHP-MonsterHP)+"<br>";
			}

			if (PlayerHitHeavy > (PlayerSpeed + 4) && Choice == 2) {
				int PlayerDamage = (int) Math.floor(PlayerWeapon * (PlayerSkill) * 1.5);
				int TempMonsterHP = MonsterHP;
				MonsterHP = (int) Math.floor(MonsterHP
						- (PlayerDamage - (PlayerDamage * ((double) MonsterDefense / ((double) MonsterDefense + 10)))));
				if (TempMonsterHP == MonsterHP) {
					MonsterHP--;
				}
				GameMainTextLogg = GameMainTextLogg+"Utdelad kritisk skada!: "+(TempMonsterHP-MonsterHP)+"<br>";
			}
			
			if (PlayerHitLight < PlayerHitThreshhold && Choice == 1)
			{
				GameMainTextLogg = GameMainTextLogg+"Du missade!?<br>";
			}
			
			if (PlayerHitHeavy < PlayerHitThreshhold && Choice == 2)
			{
				GameMainTextLogg = GameMainTextLogg+"Du missade!?<br>";
			}

			if (MonsterHit > MonsterHitThreshhold) {
				int TempPlayerHP = PlayerHP;
				PlayerHP = (int) Math.floor(PlayerHP
						- (MonsterDamage - (MonsterDamage * ((double) PlayerDefense / ((double) PlayerDefense + 5)))));
				if (TempPlayerHP == PlayerHP) {
					PlayerHP--;
				}
				GameMainTextLogg = GameMainTextLogg+"Tagen skada: " + (TempPlayerHP-PlayerHP)+"<br>";
			}
			else {
				GameMainTextLogg = GameMainTextLogg+MonsterName+" missade!?<br>";
			}
			if(MonsterHP<1)
				MonsterHP = 0;
			if(PlayerHP<1)
				PlayerHP = 0;
			GameMainTextLogg = GameMainTextLogg+" Ditt HP är: "+PlayerHP+".  "+MonsterName+" HP är: "+MonsterHP+"<br>";
			
			setGameMainTextLogg(GameMainTextLogg);

			if (PlayerHP < 1) {
				PlayerHP = 0;
				System.out.println("Du Suger!");
				Combat = false;
				Dead = true;
				setPlayerHP(PlayerHP);
				return;
			}
			System.out.println(MonsterHP);
			if (MonsterHP < 1) {
				MonsterHP = 0;
				System.out.println("Den suger!");
				Combat = false;
				Dead = false;
				setPlayerHP(PlayerHP);
				return;
			}
			if(CombatStart==1)
				MonsterHP = MonsterMaxHP;
		}
		setPlayerHP(PlayerHP);
		setMonsterHP(MonsterHP);
	}
}

