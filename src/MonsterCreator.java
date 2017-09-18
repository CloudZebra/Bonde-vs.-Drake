import java.util.Random;

//Här är lagring av monster och deras attribut. 


public class MonsterCreator 
{
	//Variabel deklaration
	private String MonsterName;
	private int MonsterHP;
	private int MonsterDamage;
	private int MonsterSpeed;
	private int i=1;
	
	//Getters och setters
	public String getMonsterName() {
		return MonsterName;
	}
	public void setMonsterName(String monsterName) {
		MonsterName = monsterName;
	}
	public int getMonsterHP() {
		return MonsterHP;
	}
	public void setMonsterHP(int monsterHP) {
		MonsterHP = monsterHP;
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
	private int MonsterDefense;
	//Beroende på vilken tier(1-4) så väljer den ett monstret från den tieren och skickar den till CombatManager klassen.
	public MonsterCreator(int Tier, String MonsterName, int MonsterHP, int MonsterDamage, int MonsterSpeed, int MonsterDefense, int CombatStart)
	{
		for(i=1;i<2;i++)
		{
		Random Rand = new Random();
		int RNG = Rand.nextInt(6);
		if(Tier == 1)
		{
			String[] T1MonsterName = {"Slime", "Råtta", "Goblin", "Fladdermus", "Spindel", "Vildsvin"};
			int[] T1MonsterHP = {22, 10, 10, 10, 12, 14};
			int[] T1MonsterDefense = {1, 2, 3, 0, 1, 4};
			int[] T1MonsterDamage = {1, 2, 3, 1, 5, 2};
			int[] T1MonsterSpeed = {4, 7, 6, 8, 6, 4};
			MonsterName = T1MonsterName[RNG];
			MonsterHP = T1MonsterHP[RNG];
			MonsterDamage = T1MonsterDamage[RNG];
			MonsterSpeed = T1MonsterSpeed[RNG];
			MonsterDefense = T1MonsterDefense[RNG];
		}
		
		if(Tier == 2)
		{
		String[] T2MonsterName = {"Ödlefolk", "Kobalt", "Slam", "Levande Svamp", "Orm", "Sköldpadda"};
		int[] T2MonsterHP = {20, 12, 20, 12, 10, 21};
		int[] T2MonsterDefense = {3, 4, 5, 6, 3, 7};
		int[] T2MonsterDamage = {5, 4, 4, 6, 6, 2};
		int[] T2MonsterSpeed = {5, 8, 4, 4, 6, 4};
		MonsterName = T2MonsterName[RNG];
		MonsterHP = T2MonsterHP[RNG];
		MonsterDamage = T2MonsterDamage[RNG];
		MonsterSpeed = T2MonsterSpeed[RNG];
		MonsterDefense = T2MonsterDefense[RNG];
		}
		
		if(Tier == 3)
		{
		String[] T3MonsterName = {"Orc", "Giganstisk Bläckfisk", "Krokodil", "Drowner", "Örn", "Giganstisk Krabba"};
		int[] T3MonsterHP = {18, 20, 20, 20, 13, 20};
		int[] T3MonsterDefense = {6, 2, 7, 3, 0, 7};
		int[] T3MonsterDamage = {7, 10, 6, 6, 8, 5};
		int[] T3MonsterSpeed = {4, 6, 5, 9, 11, 6};
		MonsterName = T3MonsterName[RNG];
		MonsterHP = T3MonsterHP[RNG];
		MonsterDamage = T3MonsterDamage[RNG];
		MonsterSpeed = T3MonsterSpeed[RNG];
		MonsterDefense = T3MonsterDefense[RNG];
		}
		
		if(Tier == 4)
		{
		String[] T4MonsterName = {"Troll", "Jätte", "Zyklop", "Drottning Spindel", "Harpya", "Wyvern"};
		int[] T4MonsterHP = {20, 23, 20, 20, 16, 20};
		int[] T4MonsterDefense = {5, 8, 3, 2, 2, 8};
		int[] T4MonsterDamage = {10, 7, 13, 8, 8, 6};
		int[] T4MonsterSpeed = {7, 5, 7, 10, 13, 9};
		MonsterName = T4MonsterName[RNG];
		MonsterHP = T4MonsterHP[RNG];
		MonsterDamage = T4MonsterDamage[RNG];
		MonsterSpeed = T4MonsterSpeed[RNG];
		MonsterDefense = T4MonsterDefense[RNG];
		}
		
		if(Tier == 5)
		{
		String[] T5MonsterName = {"Drake"};
		int[] T5MonsterHP = {52};
		int[] T5MonsterDefense = {10};
		int[] T5MonsterDamage = {9};
		int[] T5MonsterSpeed = {12};
		MonsterName = T5MonsterName[0];
		MonsterHP = T5MonsterHP[0];
		MonsterDamage = T5MonsterDamage[0];
		MonsterSpeed = T5MonsterSpeed[0];
		MonsterDefense = T5MonsterDefense[0];
		}
		
		
		setMonsterDefense(MonsterDefense);
		setMonsterName(MonsterName);
		setMonsterDamage(MonsterDamage);
		setMonsterHP(MonsterHP);
		setMonsterSpeed(MonsterSpeed);
		}
		if(i>1)
		{
		return;
		}
	}
}
