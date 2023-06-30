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

## 회원수정
-[세션값 변경](https://github.com/BeomJunPark12/practice/blob/f449c68b48913a0e4a24c1f6cd95f7bbdd3e7123/src/main/java/com/beom/web/controller/api/UserApiController.java#L52) - ajax로 값을 바꿨기 때문에 화면에 바로 반영이 안될 수 있음 -> 세션을 강제로 변경한다(덮어씌우기)

## 더티체킹
-[글수정](https://github.com/BeomJunPark12/practice/blob/f449c68b48913a0e4a24c1f6cd95f7bbdd3e7123/src/main/java/com/beom/web/service/BoardService.java#L70) - 영속성 컨텍스트를 보관할 때 최초의 상태를 복사해서 저장해둠 -> 트랜잭션이 끝나고 flush할 때 값을 비교해 변경된 부분을 update, save함수를 안써도 알아서 값을 변경해준다.



댓글 구현 완료

해야 할 일: 페이징 처리
