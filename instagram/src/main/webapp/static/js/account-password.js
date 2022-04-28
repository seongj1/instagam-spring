const profileUsername = document.querySelector(".profile-username");
const passwordInputs = document.querySelectorAll(".password-input");
const submitBtn = document.querySelector(".submit-btn");
const boxItemLefts = document.querySelectorAll(".box-item-left");

let usercode = 0;

let principal = getPrincipal();

load();

function load() {
	profileUsername.textContent = principal.username;
}

function isEmpty(str) {
	return typeof str == "undefined" || str == null || str == "";
}

submitBtn.onclick = () => {
	for(let i = 0; i < passwordInputs.length; i++){
		if(isEmpty(passwordInputs[i].value)){
			const labelName = boxItemLefts[i + 1].querySelector("label").textContent;
			alert(labelName + "(을)를 입력해주세요.");
			return;
		}else if(i == 1 && passwordInputs[i].value != passwordInputs[i + 1].value){
			alert("새 비밀번호가 서로 일치하지 않습니다.");
			return;
		}else if(i == 2 && passwordInputs[i - 2].value == passwordInputs[i - 1].value){
			alert("기존의 비밀번호와 동일한 비밀번호는 사용할 수 없습니다.");
			return;
		}
	}
	$.ajax({
		type: "put",
		url: "/app/profile/account/password/update",
		data: JSON.stringify({
			originPassword: passwordInputs[0].value,
			newPassword: passwordInputs[1].value
		}),
		contentType: "application/json;charset=utf-8",
		dataType: "text",
		success: function(data){
			if(data == "true"){
				alert("비밀번호 변경 완료. 다시 로그인 하세요.");
				location.replace("/app/logout");
			}else {
				alert("이번 비밀번호가 일치하지 않습니다.");
			}
		},
		error: function(){
			alert("비동기 처리 오류");
		}
		
	});
}






/*function passwordIsempty(){
	if(passwordInputs[0].value == " "){
		alert("이전 비밀번호를 입력해주세요.");
	}else{
		checkFlag = true;
	}
	if(passwordInputs[1].value == " "){
		alert("새 비밀번호를 입력해주세요.");
	}else{
		checkFlag = true;
	}
	if(passwordInputs[2].value == " "){
		alert("새 비밀번호 확인을 입력해주세요.");
	}else {
		checkFlag = true;
	}
}

function passwordEquels() {
	let password = document.getElementById("password").value;
	let newpassword = document.getElementById("new-password").value;
	let newrepassword = document.getElementById("new-repassword").value;
	
	
	if(newpassword != newrepassword){
		alert("비밀번호가 맞지 않습니다.");
		return false;
	}else{
		alert("비밀번호가 일치합니다.");
		return true;
	}
}*/