<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>instagram</title>
    <link rel="stylesheet" href="/app/static/css/account.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-latest.min.js"></script>
</head>

<body>
    <section class="container">
        <main class="m-container">
        	<jsp:include page="../../include/nav/nav.jsp"></jsp:include>
            <div id="container">
                <article>
                    <section class="side-bar">
                        <div class="side-bar-item clicked">
                            <b>프로필 편집</b>
                        </div>
                        <div class="side-bar-item">
                            <b>비밀번호 변경</b>
                        </div>
                        <div class="side-bar-item">
                            <b>앱 및 웹사이트</b>
                        </div>
                        <div class="side-bar-item">
                            <b>이메일 알림</b>
                        </div>
                        <div class="side-bar-item">
                            <b>푸쉬 알림</b>
                        </div>
                        <div class="side-bar-item">
                            <b>연락처 관리</b>
                        </div>
                        <div class="side-bar-item">
                            <b>개인정보 및 보안</b>
                        </div>
                        <div class="side-bar-item">
                            <b>로그인 활동</b>
                        </div>
                        <div class="side-bar-item">
                            <b>instagram에서 보낸 이메일</b>
                        </div>
                        <div class="side-bar-item">
                            <b>도움말</b>
                        </div>

                    </section>
                    <section class="profile-box">
                        <form class="profile-box-form1">
                            <div class="box-item-left">
                                <div class="profile-img-round">
                                    <img src="images/instagram.png" alt="">
                                </div>
                            </div>
                            <div class="box-item-right">
                                <h1 class="profile-username">seongjun</h1>
                                <div class="update-img-button">프로필 사진 바꾸기</div>
                            </div>
                        </form>
                        <form class="profile-box-form2">
                            <div class="box-items">
                                <div class="box-item-left">
                                    <label for="name">이름</label>
                                </div>
                                <div class="box-item-right">
                                    <div class="input-items">
                                        <input type="text" id="name" class="text-input" name="name" value="윤성준">
                                        <div class="input-explanation">
                                            <div class="explanation-text1">
                                                사람들이 이름, 별명 또는 비즈니스 이름 등 회원님의 알려진 이름을
                                                사용하여 회원님의 게정을 찾을 수 있도록 도와주세요.
                                            </div>
                                            <div class="explanation-text2">
                                                이름은 14일 안에 두 번만 변경할 수 있습니다.
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="box-items">
                                <div class="box-item-left">
                                    <label for="username">사용자 이름</label>
                                </div>
                                <div class="box-item-right">
                                    <div class="input-items">
                                        <input type="text" id="username" class="text-input" name="username"
                                            value="seongjun">
                                        <div class="input-explanation">
                                            <div class="explanation-text1">
                                                In most cases, you'll be able to change your username back to
                                                undefined for another undefined days.
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="box-items">
                                <div class="box-item-left">
                                    <label for="website">웹사이트</label>
                                </div>
                                <div class="box-item-right">
                                    <div class="input-items">
                                        <input type="text" id="website" class="text-input" name="website" value="">
                                    </div>
                                </div>
                            </div>
                            <div class="box-items">
                                <div class="box-item-left">
                                    <label for="introduce">소개</label>
                                </div>
                                <div class="box-item-right">
                                    <div class="input-items">
                                        <textarea id="introduce" class="text-textarea" name="introduce">
                                        </textarea>
                                    </div>
                                </div>
                            </div>
                            <div class="box-items">
                                <div class="box-item-left">
                                    <label for="email">이메일</label>
                                </div>
                                <div class="box-item-right">
                                    <div class="input-items">
                                        <input type="text" id="email" class="text-input" name="email"
                                            value="dich24@naver.com">
                                    </div>
                                </div>
                            </div>
                            <div class="box-items">
                                <div class="box-item-left">
                                    <label for="phone">전화번호</label>
                                </div>
                                <div class="box-item-right">
                                    <div class="input-items">
                                        <input type="text" id="phone" class="text-input" name="phone"
                                            value="+82 10-9473-7896">
                                        <button type="button">휴대폰 번호 확인</button>
                                    </div>
                                </div>
                            </div>
                            <div class="box-items">
                                <div class="box-item-left">
                                    <label for="gender">성별</label>
                                </div>
                                <div class="box-item-right">
                                    <div class="input-items">
                                        <select id="gender" class="text-input" name="gender">
                                            <option value="0">남성</option>
                                            <option value="1">여성</option>
                                            <option value="2">맞춤 성별</option>
                                            <option value="3">밝히고 싶지 않음</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="box-items">
                                <div class="box-item-left">
                                </div>
                                <div class="box-item-right">
                                    <button type="button" class="submit">제출</button>
                                </div>
                            </div>
                        </form>
                    </section>
                </article>
            </div>

        </main>
        <footer>

        </footer>
    </section>
    <script type="text/javascript" src="/app/static/js/account.js"></script>
</body>

</html>