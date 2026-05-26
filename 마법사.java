package dnf.model;

public class 마법사 extends 캐릭터 {

  public 마법사(String 캐릭터명, int 레벨) {
    super(캐릭터명, "마법사", 레벨);
    this.HP = 레벨 * 60;
    this.공격력 = 레벨 * 25;
  }

  @Override
  public double 스킬발동() {
    return 공격력 * 2.0;
  }
}
