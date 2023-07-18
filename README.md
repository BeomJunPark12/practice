# 개발 환경
- Java jdk11, SpringBoot, Jpa, Mysql, Intellj, thymeleaf
- 스프링 시큐리티, 로그인, 게시판


# 주요 로직
## 스프링 시큐리티
- [시큐리티 설정](https://github.com/BeomJunPark12/practice/blob/98f355662e93d144e5a55cf299fb9fe0aec5ed20/src/main/java/com/beom/web/config/SecurityConfig.java#L19)
- [비밀번호 인코더](https://github.com/BeomJunPark12/practice/blob/f449c68b48913a0e4a24c1f6cd95f7bbdd3e7123/src/main/java/com/beom/web/config/SecurityConfig.java#L39) - 사용자 비밀번호를 암호화하고 인증 시 비밀번호 검증할 때 사용된다.
- [시큐리티 세션 저장](https://github.com/BeomJunPark12/practice/blob/f449c68b48913a0e4a24c1f6cd95f7bbdd3e7123/src/main/java/com/beom/web/config/auth/PrincipalDetailService.java#L21)

## 회원가입
-[회원가입](https://github.com/BeomJunPark12/practice/blob/f449c68b48913a0e4a24c1f6cd95f7bbdd3e7123/src/main/java/com/beom/web/service/UserService.java#L26) - DB에 비밀번호가 암호화돼서 저장된다.

<img width="656" alt="스크린샷 2023-07-18 오전 10 28 55" src="https://github.com/BeomJunPark12/practice/assets/118503208/ae94a3f0-f10b-47c8-b508-0f8e777db505">

## 회원수정
-[세션값 변경](https://github.com/BeomJunPark12/practice/blob/f449c68b48913a0e4a24c1f6cd95f7bbdd3e7123/src/main/java/com/beom/web/controller/api/UserApiController.java#L52) - ajax로 값을 바꿨기 때문에 화면에 바로 반영이 안될 수 있음 -> 세션을 강제로 변경한다(덮어씌우기)

## 더티체킹
-[글수정](https://github.com/BeomJunPark12/practice/blob/f449c68b48913a0e4a24c1f6cd95f7bbdd3e7123/src/main/java/com/beom/web/service/BoardService.java#L70) - 영속성 컨텍스트를 보관할 때 최초의 상태를 복사해서 저장해둠 -> 트랜잭션이 끝나고 flush할 때 값을 비교해 변경된 부분을 update, save함수를 안써도 알아서 값을 변경해준다.

# 구현화면
## 게시판
<img width="1466" alt="게시판" src="https://github.com/BeomJunPark12/practice/assets/118503208/d06037cf-57ac-4fe3-b200-57757e7ae89a">
게시판 페이지입니다. 글쓰기를 할 수 있습니다.<br>
검색, 페이징 진행중입니다.

## 글 상세보기
<img width="1412" alt="글상세보기" src="https://github.com/BeomJunPark12/practice/assets/118503208/217df6e7-f686-49f9-84d0-f4dc982e1512">
로그인한 사용자와 글 작성자가 같으면 글수정과 글삭제를 할 수 있습니다.

## 댓글창
<img width="1211" alt="댓글" src="https://github.com/BeomJunPark12/practice/assets/118503208/8a1e21c5-9909-4ba5-ba55-37e5b3fe84f3">
글상세보기 페이지에서 댓글을 작성할 수 있습니다.<br>
로그인한 사용자와 댓글 작성자가 같으면 댓글을 삭제할 수 있습니다.

## 회원수정
<img width="972" alt="회원수정" src="https://github.com/BeomJunPark12/practice/assets/118503208/fadd3dcf-17a6-4b3d-80d3-daecfc673ffa">
아이디는 수정할 수 없습니다.<br>
비밀번호만 수정할 수 있게 화면을 구성했습니다.




댓글 구현 완료

해야 할 일: 페이징 처리



## DB
<img src="https://github.com/BeomJunPark12/practice/blob/main/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202023-06-30%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%205.53.59.png" width="1000" height="600"/>

