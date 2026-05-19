```mermaid

graph LR
    %% 액터 정의
    플레이어((플레이어))

    %% 시스템 경계 및 유스케이스 정의
    subgraph 던전앤파이터_전투_시스템
        사용사례1(캐릭터 생성)
        사용사례2(몬스터 공격)
        사용사례3(플레이어 체크)
    end

    %% 관계 정의
    플레이어 --> 사용사례1
    플레이어 --> 사용사례2

    %% 포함 관계 (<<include>>)
    사용사례1 -.->|include| 사용사례3
    사용사례2 -.->|include| 사용사례3

    %% 스타일링
    style 던전앤파이터_전투_시스템 fill:#f9f9f9,stroke:#333,stroke-width:2px
    style 플레이어 fill:#e1f5fe,stroke:#0288d1,stroke-width:2px
    style 사용사례1 fill:#fff,stroke:#333,stroke-width:1px
    style 사용사례2 fill:#fff,stroke:#333,stroke-width:1px
    style 사용사례3 fill:#fff59d,stroke:#fbc02d,stroke-width:1px
