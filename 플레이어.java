package dnf.model;

public class 플레이어 {

  private String 플레이어id;

  public 플레이어(String 플레이어id) {
    this.플레이어id = 플레이어id;
  }

  public boolean 플레이어체크(String 플레이어id) {
    return "hero".equals(플레이어id);
  }

  public String get플레이어id() {
    return 플레이어id;
  }
}
