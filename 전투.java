package dnf.service;

import dnf.model.마법사;
import dnf.model.보스;
import dnf.model.전사;
import dnf.model.캐릭터;
import dnf.model.플레이어;

import java.io.Serializable;

public class 전투 implements Serializable {

  private final 플레이어 플레이어객체 = new 플레이어("hero");
  private 캐릭터 캐릭터;
  private 보스 보스;
  private boolean 인증완료 = false;

  public 캐릭터 캐릭터생성(String 플레이어id, String 캐릭터명, String 직업, int 레벨) {
    if (!플레이어객체.플레이어체크(플레이어id)) {
      return null;
    }
    캐릭터 생성된캐릭터 = null;
    if ("전사".equals(직업)) {
      생성된캐릭터 = new 전사(캐릭터명, 레벨);
    } else if ("마법사".equals(직업)) {
      생성된캐릭터 = new 마법사(캐릭터명, 레벨);
    }
    if (생성된캐릭터 == null) {
      return null;
    }
    this.캐릭터 = 생성된캐릭터;
    this.보스 = null;
    this.인증완료 = false;
    return 생성된캐릭터;
  }

  public String 몬스터공격(String 플레이어id) {
    if (!플레이어객체.플레이어체크(플레이어id)) {
      return "FAIL";
    }
    if (this.캐릭터 == null) {
      return "FAIL";
    }
    double 데미지 = this.캐릭터.스킬발동();
    String 등급 = 등급판정(데미지);
    return "데미지:" + 데미지 + ",등급:" + 등급;
  }

  public 보스 보스소환(String 플레이어id, String 보스명, int 보스HP) {
    if (this.캐릭터 == null) {
      return null;
    }
    if (!플레이어객체.플레이어체크(플레이어id)) {
      return null;
    }
    if (보스명 == null || 보스명.trim().isEmpty()) {
      보스명 = "어둠의 군주";
    }
    if (보스HP <= 0) {
      보스HP = 1000;
    }
    this.보스 = new 보스(보스명, 보스HP);
    this.인증완료 = true;
    return this.보스;
  }

  public String 보스공격() {
    if (!this.인증완료) {
      return "NOT_AUTH";
    }
    if (this.캐릭터 == null || this.보스 == null) {
      return "FAIL";
    }
    if (this.보스.처치됨()) {
      return "ALREADY_DEFEATED";
    }
    double 데미지 = this.캐릭터.스킬발동();
    this.보스.데미지받기(데미지);
    String 등급 = 등급판정(데미지);
    String 상태 = this.보스.처치됨() ? "CLEAR" : "HIT";
    return 상태 + "|데미지:" + 데미지 + ",등급:" + 등급;
  }

  public void 보스초기화() {
    this.보스 = null;
  }

  public boolean is인증완료() {
    return 인증완료;
  }

  public String 등급판정(double 데미지) {
    if (데미지 >= 200) {
      return "S급";
    }
    if (데미지 >= 100) {
      return "A급";
    }
    return "B급";
  }

  public 캐릭터 get캐릭터() {
    return 캐릭터;
  }

  public 보스 get보스() {
    return 보스;
  }
}
