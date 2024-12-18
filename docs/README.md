## 📝 개요
> 한 주의 점심 메뉴 추천 서비스

## ⚙️ 구현 기능 목록

### 🏁 서비스 시작

- [ ] 서비스 시작 문구 출력
- > 점심 메뉴 추천을 시작합니다.

### 💬 코치의 이름 및 각 코치가 못 먹는 메뉴 입력 받기

- [ ] 코치의 이름 입력을 위한 문구 출력
- > 코치의 이름을 입력해 주세요. (, 로 구분)

- [ ] 메뉴 추천을 받을 코치의 이름 입력 받기
- [ ] 예외 처리
    - [ ] 쉼표(`,`)로 구분된 이름의 개수가 범위(2~5)를 벗어나는 경우
    - [ ] 각 코치의 이름의 글자수가 범위(2~4)를 벗어나는 경우
    - [ ] `IllegalArgumentException`를 발생시키고, `[ERROR]`로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받기


- [ ] 각 코치가 못 먹는 메뉴 입력을 위한 문구 출력
- > OO(이)가 못 먹는 메뉴를 입력해 주세요.

- [ ] 각 코치가 먹지 못하는 메뉴를 입력 받기
- [ ] 예외 처리
    - [ ] 쉼표(`,`)로 구분된 메뉴의 개수가 범위(0~2)를 벗어나는 경우
    - [ ] `IllegalArgumentException`를 발생시키고, `[ERROR]`로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받기


### ✅ 서비스 종료

- [ ] 메뉴 추천 결과에 대한 문구 출력
- > 메뉴 추천 결과입니다.

- [ ] 메뉴 추천 결과 출력
- > [ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]
  <br>[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]
  <br>[ 토미 | 쌈밥 | 김치찌개 | 미소시루 | 짜장면 | 팟타이 ]
  <br>[ 제임스 | 된장찌개 | 비빔밥 | 가츠동 | 토마토 달걀볶음 | 파인애플 볶음밥 ]
  <br>[ 포코 | 된장찌개 | 불고기 | 하이라이스 | 탕수육 | 나시고렝 ]

- [ ] 추천 완료 문구 출력
- > 추천을 완료했습니다.