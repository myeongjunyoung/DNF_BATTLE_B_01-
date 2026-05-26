package dnf.model;

import java.io.Serializable;

public class 보스 implements Serializable {

  private String 보스명;
  private int 최대HP;
  private int 현재HP;
  private double 누적데미지;
  private int 공격횟수;

  public 보스(String 보스명, int 최대HP) {
    this.보스명 = 보스명;
    this.최대HP = 최대HP;
    this.현재HP = 최대HP;
    this.누적데미지 = 0;
    this.공격횟수 = 0;
  }

  public void 데미지받기(double 데미지) {
    if (처치됨()) {
      return;
    }
    this.누적데미지 += 데미지;
    this.현재HP -= (int) Math.round(데미지);
    if (this.현재HP < 0) {
      this.현재HP = 0;
    }
    this.공격횟수++;
  }

  public boolean 처치됨() {
    return 현재HP <= 0;
  }

  public double getHP비율() {
    if (최대HP <= 0) {
      return 0;
    }
    return (double) 현재HP / 최대HP * 100.0;
  }

  public String get보스명() {
    return 보스명;
  }

  public int get최대HP() {
    return 최대HP;
  }

  public int get현재HP() {
    return 현재HP;
  }

  public double get누적데미지() {
    return 누적데미지;
  }

  public int get공격횟수() {
    return 공격횟수;
  }
}
