package dnf.model;

public class 전사 extends 캐릭터 {

  public 전사(String 캐릭터명, int 레벨) {
    super(캐릭터명, "전사", 레벨);
    this.HP = 레벨 * 100;
    this.공격력 = 레벨 * 15;
  }

  @Override
  public double 스킬발동() {
    return 공격력 * 1.5;
  }
}
