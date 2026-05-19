```mermaid
sequenceDiagram
    actor Player as 플레이어
    participant UI as Create_Character_UI
    participant Battle as 전투
    participant PlayerObj as 플레이어
    participant Character as 캐릭터(전사/마법사)
    
    Player->>UI: 정보 입력<br/>(플레이어id, 캐릭터명, 직업, 레벨)
    UI->>Battle: 캐릭터생성(플레이어id, 캐릭터명, 직업, 레벨)
    
    Battle->>PlayerObj: 플레이어체크(플레이어id)
    
    alt 플레이어id == "hero"
        PlayerObj-->>Battle: return true
        
        alt 직업 == "전사"
            Battle->>Character: new 전사(캐릭터명, 레벨)
            Note right of Character: HP = 레벨 × 100<br/>공격력 = 레벨 × 15
        else 직업 == "마법사"
            Battle->>Character: new 마법사(캐릭터명, 레벨)
            Note right of Character: HP = 레벨 × 60<br/>공격력 = 레벨 × 25
        end
        
        Character-->>Battle: return 캐릭터 객체
        Battle-->>UI: return true
        UI-->>Player: 캐릭터 정보 출력
    else 플레이어id != "hero"
        PlayerObj-->>Battle: return false
        Battle-->>UI: return false
        UI-->>Player: 오류 메시지
    end