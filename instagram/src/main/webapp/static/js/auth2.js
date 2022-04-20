const input = document.querySelectorAll("label");
const username_input = input[0].querySelector(".input-id");
const username_span = input[0].querySelector("span");
const password_input = input[1].querySelector(".input-id");
const password_span = input[1].querySelector("span");
const login_button = document.querySelector(".button")



username_input.onkeydown = (e) => {
    if (e.keyCode == 13) {
        if (username_input.value.length == 0) {
            alert("아이디를 입력해주세요.");
        }
        password_input.focus();
    }
    username_input.classList.add("input-id-text");
    username_span.classList.add("typed-span");
    changeColor();
}

username_input.onkeyup = () => {
    if (username_input.value.length == 0) {
        username_input.classList.remove("input-id-text");
        username_span.classList.remove("typed-span");
    } 
    changeColor();
}

password_input.onkeydown = (e) => {
    if (e.keyCode == 13) {
        login_button.click();
    }
    password_input.classList.add("input-id-text");
    password_span.classList.add("typed-span");
    changeColor();
}

password_input.onkeyup = () => {
    if (password_input.value.length == 0) {
        password_input.classList.remove("input-id-text");
        password_span.classList.remove("typed-span");
    }
    changeColor();
}

login_button.onclick = () => {
    if (username_input.value.length == 0) {
        alert("아이디를 입력해주세요.");
    } else if (password_input.value.length == 0) {
        alert("비밀번호를 입력해주세요.");
    } else {
        alert("로그인 시도.");
    }
}



function changeColor() {
    if (username_input.value.length != 0 && password_input.value.length != 0) {
        login_button.classList.add("buttonColor");
    } else {
        login_button.classList.remove("buttonColor");
    }
}




