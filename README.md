# 🥕 중고거래 서비스 프로젝트

당근마켓이나 중고나라와 같은 중고물품거래 서비스를 제공


## ⚒️ 사용 스택
![image](https://user-images.githubusercontent.com/102509636/227448656-b24b6c73-92ae-4219-beb1-9ca08c0f34a4.png)

![image](https://user-images.githubusercontent.com/102509636/227448692-f849f733-ec4a-41ea-9aa4-7b8403a46d28.png)
![image](https://user-images.githubusercontent.com/102509636/227448758-6146774c-5b40-4e7d-b949-862170add5ed.png)
![image](https://user-images.githubusercontent.com/102509636/227448768-a8a0d208-ef0a-4e0e-958a-8c81e13c0761.png)
![image](https://user-images.githubusercontent.com/102509636/227448788-3e24cc79-0717-424f-be61-4f787bd4ace4.png)
![image](https://user-images.githubusercontent.com/102509636/227448833-891b8f58-0d48-4688-a864-d8b0ec9e7865.png)
![image](https://img.shields.io/badge/redis-DC382D?style=for-the-badge&logo=Redis&logoColor=white)
![image](https://user-images.githubusercontent.com/102509636/226165425-4602e344-14c4-424e-9515-56f76ded026b.png)


##  💻 프로젝트 기능 및 설계
[회원]

- 회원가입
    - [ ] 모든 유저는 일반회원으로 회원가입을 하며 일반(USER) 권한을 갖는다.
    - [ ] 회원가입시 email, nickname, password 를 입력 받으며 email 은 unique 해야한다.
    - [ ] mailgun 을 사용하여 유효한 이메일인지 검증한다.
- 로그인
    - [ ] 로그인시 토큰을 발행한다.
    - [ ] 발행받은 토큰을 통해 권한을 부여한다.(jwt 토큰기반 인증)

[게시글]

- 모든 게시글 조회
    - [ ] 모든 게시글 조회가능(paging을 통해 20개씩 보이도록 처리)
    - [ ] 최신순으로 조회
    - [ ] 클릭 후 조회시 조회수 + 1
    - [ ] 좋아요 클릭시 user의 좋아요 목록에 상품 아이디 추가
- 특정 게시글 조회
    - [ ] 검색을 통해 특정 키워드가 들어가는 상품 조회(상품명 기준)
    - [ ] es or full text search 사용
- 게시글 등록(상품명-text, 사진-text(사진경로 url), 상품내용-text, 가격-Integer)
    - [ ] 권한에 관계없이 상품을 등록할 수 있다.
    - [ ] 상품명, 상품내용 필수적으로 적어야한다.(not null)
    - [ ] 등록시 위치(경도와 위도)를 자동으로 입력 받는다. (추가 기능)
- 게시글 수정
    - [ ] post 테이블의 회원 아이디를 확인 후 수정한다.(불일치시 수정 불가능)
- 게시글 삭제
    - [ ] post 데이블의 회원 아이디를 확인 후 삭제한다.(불일치시 삭제 불가능)
   

[거래]

- 거래 신청
    - [ ] 구매자 가 특정 게시글의 거래신청시 해당 게시글의 user 가 신청을 수락하면 거래 완료
    - [ ] 거래신청 시 가격 제시 가능
- 거래 완료
    - [ ] 상품 거래 완료시 거래 테이블 거래 완료 표시 후 게시글도 거래 완료로 수정
- 거래 취소
    - [ ] 거래 신청자가 거래 취소 가능
- 장바구니
    - [ ] redis 를 이용하여 장바구니 기능 구현 or 장바구니 테이블을 따로 생성

[추가 기능]
- [ ] 중고폰 기종 입력시 예상 가격 추천(중고물품 상태에 따른 가격 예측)
- [ ] 위치기반 상품 조회 - 위도, 경도 or 동별(enum 으로 구분)
- [ ] 지정한 키워드 상품 알림
- [ ] 거래시 채팅 기능


## 📄 ERD

![image](https://github.com/pumkinni/Used-Transaction_Project/assets/102509636/a7d6dcc8-6b72-4fd9-b892-273dccdd1633)


