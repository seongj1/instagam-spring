const input_data = document.querySelectorAll(".input-data");
const passwordType = document.querySelector("input[type = 'password']");
const phoneOrEmail_label = input_data[0].querySelector("label");
const phoneOrEmail_input = input_data[0].querySelector("input");
const password_visible = document.querySelector(".password-visible");
const submitBtn = document.querySelector('.submit-btn');

let checkFlag = [false, false, false, false]; //input들에 값이 들어있는지 확인하는 플래그

submitBtn.onclick = () => { //submit 버튼을 클릭했을 때 form안에 있는 데이터 submit으로 날리기 
	if(checkFlag.indexOf(false) == -1){ //체크 플레그에 indexof를 이용해서 false 값이 들어 있는지 확인
	document.querySelector("form").submit()  //false값이 없다면 데이터 submit으로 날리기 	
	}
}


password_visible.onclick = () => {
    if (passwordType.type == "password") {
        passwordType.type = 'text';
        password_visible.innerText = "숨기기";
    } else {
        passwordType.type = 'password';
        password_visible.innerText = "비밀번호 표시";
    }
}

for (let i = 0; i < input_data.length; i++){
    const label = input_data[i].querySelector("label");
    const input = input_data[i].querySelector("input");

    input.onkeydown = () => {
        label.style.top = "2px";
        label.style.fontSize = "11px";
        input.style.padding = "16px 0px 2px 8px";
    }

    input.onkeyup = () => {
        if (input.value.length == 0) {
            label.style.top = "9px";
            label.style.fontSize = "13px";
            input.style.padding = "9px 0px 7px 8px";
            
        }
    }

    input.onblur = () => {
        const inputMsg = document.querySelectorAll(".input-msg");
        
        
        if (input.value.length == 0) {
            inputMsg[i].innerHTML = `<i class="fa-solid fa-circle-xmark"></i>`
            checkFlag[i] = false;
        } else {
            inputMsg[i].innerHTML = `<i class="fa-solid fa-circle-check" style="color : #8e8e8e;"></i>`
            checkFlag[i] = true;
            if(i == 2){ //i인덱스가 2일 때 username input일 때
				
				$.ajax({ //J쿼리 사용해서 ajax 날리기 
					type: "get", //조회는 get요청
					url: "/app/auth/username/check1", //어디로 요청을 날릴 것인지 
					data: {  //username에 있는 input값
						"username": input.value
					},
					dataType: "text", //요청을 날리고 전달 받을 때 어떻게 받을 것인가.
					success: function(data){  //성공 했을 때
						if(data == "true"){ //데이터가 "true"일
							inputMsg[i].innerHTML = `<i class="fa-solid fa-circle-xmark"></i>`
							checkFlag[i] = false;
						}else{	//데이터가 "false"일 때
							inputMsg[i].innerHTML = `<i class="fa-solid fa-circle-check" style="color : #8e8e8e;"></i>`
							checkFlag[i] = true;
						}
					}
				})
            
				/*$.ajax({
					type: "get",
					url: "/app/auth/name/check1",
					data: {
						"name": input.value
					},
					dataType: "text",
					success: function(data){
						if(data == "1"){
							alert("okay")
						}
					}
				})*/
       		}
       		
        
		}
    }


}