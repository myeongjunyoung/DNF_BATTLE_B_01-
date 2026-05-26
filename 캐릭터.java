package dnf.model;

public abstract class 캐릭터 {

  protected String 캐릭터명;
  protected String 직업;
  protected int 레벨;
  protected int HP;
  protected double 공격력;

  public 캐릭터(String 캐릭터명, String 직업, int 레벨) {
    this.캐릭터명 = 캐릭터명;
    this.직업 = 직업;
    this.레벨 = 레벨;
  }

  public abstract double 스킬발동();

  public String get캐릭터명() {
    return 캐릭터명;
  }

  public String get직업() {
    return 직업;
  }

  public int get레벨() {
    return 레벨;
  }

  public int getHP() {
    return HP;
  }

  public double get공격력() {
    return 공격력;
  }
}
