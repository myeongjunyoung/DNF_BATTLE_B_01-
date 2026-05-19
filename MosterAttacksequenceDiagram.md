```mermaid
sequenceDiagram
    actor Player as 플레이어
    participant UI as Attack_Monster_UI
    participant Battle as 전투
    participant PlayerObj as 플레이어
    participant Character as 캐릭터(전사/마법사)
    
    Player->>UI: 공격 요청
    UI->>Battle: 몬스터공격(플레이어id)
    
    Battle->>PlayerObj: 플레이어체크(플레이어id)
    
    alt 플레이어id == "hero"
        PlayerObj-->>Battle: return true
        
        Battle->>Character: 스킬발동()
        
        alt 직업 == "전사"
            Note right of Character: 검 휘두르기<br/>데미지 = 공격력 × 1.5
        else 직업 == "마법사"
            Note right of Character: 파이어볼<br/>데미지 = 공격력 × 2.0
        end
        
        Character-->>Battle: return 데미지
        
        alt 데미지 >= 200
            Note right of Battle: S급 공격
        else 데미지 >= 100
            Note right of Battle: A급 공격
        else 데미지 < 100
            Note right of Battle: B급 공격
        end
        
        Battle-->>UI: return 데미지, 등급
        UI-->>Player: 공격 결과 출력
    else 플레이어id != "hero"
        PlayerObj-->>Battle: return false
        Battle-->>UI: return false
        UI-->>Player: 오류 메시지
    end
```