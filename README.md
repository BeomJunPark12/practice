# 블로그형 게시판 만들기
## 1. BindingResult

1. 회원가입<br>
    @Valid [🔍](https://github.com/BeomJunPark12/practice/blob/66ce8428184efae669a769dc7364085a1a1d0a69/src/main/java/com/beom/web/controller/UserController.java#L38)<br>
    ㄴ UserForm의 @NotBlank 이용 [🔍](https://github.com/BeomJunPark12/practice/blob/66ce8428184efae669a769dc7364085a1a1d0a69/src/main/java/com/beom/web/controller/user/UserForm.java#L13)<br>
    ㄴ Thymeleaf를 이용해서 view에 뿌리기 [🔍](https://github.com/BeomJunPark12/practice/blob/66ce8428184efae669a769dc7364085a1a1d0a69/src/main/resources/templates/user/createForm.html#L10)<br>

2. 로그인<br>
    @Valid[🔍](https://github.com/BeomJunPark12/practice/blob/66ce8428184efae669a769dc7364085a1a1d0a69/src/main/java/com/beom/web/controller/LoginController.java#L40)<br>
    ㄴ LoginForm의 @NotBlank이용[🔍](https://github.com/BeomJunPark12/practice/blob/66ce8428184efae669a769dc7364085a1a1d0a69/src/main/java/com/beom/web/controller/login/LoginForm.java#L12)<br>
    ㄴ GlobalErrors[🔍](https://github.com/BeomJunPark12/practice/blob/66ce8428184efae669a769dc7364085a1a1d0a69/src/main/java/com/beom/web/controller/LoginController.java#L51)<br>
    ㄴ Thymeleaf를 이용해서 view에 뿌리기[🔍](https://github.com/BeomJunPark12/practice/blob/66ce8428184efae669a769dc7364085a1a1d0a69/src/main/resources/templates/user/loginForm.html#L14)
             
