// console.log("signup.js loaded");

// 유효성 검사 객체
const checkObj = { 
    "inputId" : false,          // 아이디 
    "inputPw" : false,          // 비밀번호
    "inputPwConfirm" : false,  // 비번확인
    "inputName" : false         // 닉네임
};


// 아이디 유효성 검사
const inputId = document.getElementById("inputId");

inputId.addEventListener("keyup", function () {
    
    const regExp = /^[A-Za-z][\w!@#$%^&*_-]{5,13}$/;     
    // 소/대문자 시작(1) + 나머지 일부 특수문자를 포함한 모든 문자(5~13) = 6~14글자

    if(regExp.test(this.value)) {
        this.style.backgroundColor = "green";
        this.style.color = "white";
        checkObj.inputId = true;
    } else {
        this.style.backgroundColor = "red";
        this.style.color = "white";
        checkObj.inputId = false;
    }

})


// 비밀번호 검사
const inputPw = document.getElementById("inputPw");
const inputPwConfirm = document.getElementById("inputPw2");

inputPwConfirm.addEventListener("keyup", function() {
    
    if(inputPw.value.length == 0) {
        this.value = "";    // this 참조변수(inputPwConfirm) 사용시 화살표 함수 X
        alert("비밀번호를 먼저 입력해주세요");
        inputPw.focus();
        checkObj.inputPw = false;
    }

});

const pwMessage = document.getElementById("pwMessage");

inputPw.addEventListener("keyup", () => {

    if( (inputPw.value == inputPwConfirm.value) && inputPw.value.length != 0) {
        pwMessage.innerText = "비밀번호 일치";
        pwMessage.classList.add("confirm");
        pwMessage.classList.remove("error");
        checkObj.inputPw = true;
        checkObj.inputPwConfirm = true;
    } else {
        pwMessage.innerText = "비밀번호 불일치";
        pwMessage.classList.add("error");
        pwMessage.classList.remove("confirm");
        checkObj.inputPwConfirm = false;
    }

});


inputPwConfirm.addEventListener("keyup", () => {

    if( (inputPw.value == inputPwConfirm.value) && inputPw.value.length != 0) {
        pwMessage.innerText = "비밀번호 일치";
        pwMessage.classList.add("confirm");
        pwMessage.classList.remove("error");
        checkObj.inputPw = true;
        checkObj.inputPwConfirm = true;
    } else {
        pwMessage.innerText = "비밀번호 불일치";
        pwMessage.classList.add("error");
        pwMessage.classList.remove("confirm");
        checkObj.inputPwConfirm = false;
    }

});


// 닉네임 유효성 검사 (2~5글자 한글만)
const inputName = document.getElementById("inputName");

inputName.addEventListener("change", function() {

    const regExp = /^[가-힣]{2,5}$/;

    const nameMessage = document.getElementById("nameMessage");

    if( regExp.test(this.value) ) {
        nameMessage.innerText = "정상입력";
        nameMessage.classList.add("confirm");
        nameMessage.classList.remove("error");
        checkObj.inputName = true;
    } else {
        nameMessage.innerText = "2글자에서 5글자 사이 한글만 입력하세요";
        nameMessage.classList.add("error");
        nameMessage.classList.remove("confirm");
        checkObj.inputName = false;
    }

});


// 최종적으로 유효성 검사 객체인 checkObj 안에 있는 모든 value 값이
// true 인지 확인해주는 함수
// 만약 모두 ture 다 -> 서버로 submit
// 만약 하나라도 false 다 -> "유효성 검사가 완료되지 않았습니다"
function validate() {
    
    for(let key in checkObj) {
        if( !checkObj[key] ) {
            alert("유효성 검사가 완료되지 않았습니다");
            return false;
        }
    }

    return true;

}