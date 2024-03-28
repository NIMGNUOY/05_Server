const checkObj = {

    "inputName" : false,
    "inputAge" : false,
    "inputTeam" : false,
    "inputNationality" : false

};

// 이름 유효성 검사
const inputName = document.getElementById("inputName");


inputName.addEventListener("keyup", function () {
    
    const regExp = /^[A-Za-z\s]{2,20}$/;
    const nameMessage = document.getElementById("nameMessage");
    
    if(regExp.test(this.value)) {
        
        nameMessage.innerText = "정상입력";
        nameMessage.style.color = "green";
        checkObj.inputName = true;

    } else {

        nameMessage.innerText = "2~20글자 대/소문자 영어를 입력해주세요";
        nameMessage.style.color = "red";
        checkObj.inputName = false;

    }

});

// 나이 
const inputAge = document.getElementById("inputAge");

inputAge.addEventListener("change", function () {

    if(inputAge.value.length == 0) {
        alert("나이를 입력해주세요.");
    } else if (inputAge.value >= 50 || inputAge.value <= 10) {
        alert("나이를 정확히 입력해주세요");
    } else {
        checkObj.inputAge = true;
    }

});

// 소속팀
const inputTeam = document.getElementById("inputTeam");

inputTeam.addEventListener("change", function() {
    
    if(inputTeam.value.length == 0) {
        alert("소속팀을 입력해주세요");
    } else {
        checkObj.inputTeam = true;
    }

});

// 국적
const inputNationality = document.getElementById("inputNationality");

inputNationality.addEventListener("change", function() {
    
    if(inputNationality.value.length == 0) {
        alert("국적을 입력해주세요");
    } else {
        checkObj.inputNationality = true;
    }

});


function validate() {

    for(let key in checkObj) {

        if(!checkObj[key]) {
            alert("유효성 검사가 완료되지 않았습니다");
            return false;
        }

    }

    return true;
}