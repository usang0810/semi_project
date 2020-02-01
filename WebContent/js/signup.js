var signUpCheck = {
	"id" : false,
	"pwd1" : false,
	"pwd2" : false,
	"name" : false,
	"phone" : false,
	"idDup" : false
};

$(document).ready(function() {
	// Add the following code if you want the name of the file appear on select
	$(".custom-file-input").on("change", function() {
		var fileName = $(this).val()
				.split("\\").pop();
		
		$(this).siblings(".custom-file-label")
				.addClass("selected").html(fileName);
	});

	// jQuery 변수 : 변수에 직접적으로 jQuery메소드를 사용할 수 있음.
	var $id = $("#inputId");
	var $pwd1 = $("#inputPwd");
	var $pwd2 = $("#inputPwdCk");
	var $name = $("#inputName");
	var $phone2 = $("#phone2");
	var $phone3 = $("#phone3");

	// 아이디  유효성 검사
	// 첫글자는 영어 소문자, 나머지 글자는 영어 대,소문자 + 숫자, 총 6~12글자
	$id.on("input", function() {
		var regExp = /^[a-z][a-zA-z\d]{5,11}$/;
		if (!regExp.test($id.val())) {
			$("#checkId").text("아이디 형식이 유효하지 않습니다.")
					.css("color", "red");

			signUpCheck.id = false;

		} else {
			$("#checkId").text("유효한 형식의 아이디 입니다.").css(
					"color", "green");

			signUpCheck.id = true;
		}
	});
	
	$("#idDupCheck").click(function(){
		
		if($(this).val() == "N"){
			$("#inputId").prop("readonly", false).val("").focus();
			$("#idDupCheck").text("중복확인").val("Y");
			signUpCheck.idDup = false;
		}else{
			if(signUpCheck.id == true){
				$.ajax({
					url : "idDupCheck",
					data : {id: $id.val()},
					type : "GET",
					success : function(result){
						if( result == "yes"){
							alert("사용 가능한 아이디입니다.");
							
							$("#inputId").prop("readonly", true);
							$("#idDupCheck").text("취소").val("N");
							signUpCheck.idDup = true;
							
						}else{
							alert("중복된 아이디입니다. 다른 아이디를 입력해 주세요.");	
							
							signUpCheck.idDup = false;
						}
					},
					error : function(e){
						console.log("아이디 중복검사 ajax 실패");	
						console.log(e);
					},
				});
				
			}else{
				alert("유효한 아이디 형식을 입력 후 다시 시도해 주세요.");
			}
		}
		
	});

	// 비밀번호  유효성 검사
	//영어 대,소문자 + 숫자, 특수문자(~!@#$%^&*_-) 총 8~16글자
	$pwd1.on("input",function() {
		// var regExp = /^[A-Za-z0-9~!@#$%^&*_-]{8,16}$/;

		// 최소 8자 ~ 최대 16자, 최소 하나의 문자, 숫자, 하나의 특수 문자
		var regExp = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&~^])[A-Za-z\d$@$!%*#?&~^]{8,16}$/;

		// "^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$"

		if (!regExp.test($pwd1.val())) {
			$("#checkPwd1").text("비밀번호 형식이 유효하지 않습니다.")
					.css("color", "red");

			signUpCheck.pwd1 = false;

		} else {
			$("#checkPwd1").text("유효한 형식의 비밀번호 입니다.")
					.css("color","green");

			signUpCheck.pwd1 = true;
		}
	});

	// 비밀번호 일치 여부
	$pwd2.on("input", function() {
		if ($pwd1.val().trim() != $pwd2.val().trim()) {
			$("#checkPwd2").text("비밀번호가 일치하지 않습니다.")
					.css("color", "red");

			signUpCheck.pwd2 = false;

		} else {
			$("#checkPwd2").text("비밀번호가 일치합니다.").css(
					"color", "green");

			signUpCheck.pwd2 = true;
		}
	});

	// 이름 유효성 검사
	// 한글 두 글자 이상
	$name.on("input", function() {
		var regExp = /^[가-힣]{2,}$/;
		if (!regExp.test($name.val())) {
			signUpCheck.name = false;

		} else {
			signUpCheck.name = true;
		}
	});

	// 전화번호 관련
	$(".phone").on("input", function() {

		// 전화번호 input 태그에 4글자 이상 입력하지 못하게 하는 이벤트
		if ($(this).val().length > $(
				this).prop("maxLength")) {
			$(this).val($(this).val().slice(0, $(this).prop("maxLength")));
		}

		// 전화번호 유효성 검사
		var regExp2 = /^\d{3,4}$/; // 숫자 3~4 글자
		var regExp3 = /^\d{4,4}$/; // 숫자 4 글자

		if (!regExp2.test($("#phone2")
				.val())
				|| !regExp3.test($(
						"#phone3")
						.val())) {
			$("#checkPhone")
					.text(
							"전화번호가 유효하지 않습니다.")
					.css("color", "red");

			signUpCheck.phone = false;

		} else {
			$("#checkPhone").text(
					"전화번호 형식이 유효합니다.")
					.css("color",
							"green");

			signUpCheck.phone = true;

		}
	});

	// 프로필 이미지 클릭 시 파일 선택 클릭
	$("#profileImg").click(function() {
		$("#inputImg").click();
	});

});
// 이미지 첨부 시 이미지 출력
function LoadImg(value) {

	if (value.files && value.files[0]) {
		// -> 파일이 선택이 된 경우
		var reader = new FileReader();

		reader.onload = function(e) {
			$("#profileImg").prop("src", e.target.result);
		}

		// file에서 내용(Content)을 읽어옴
		// + base64 인코딩된 경로를 반환
		reader.readAsDataURL(value.files[0]);
	}
}

// submit 동작
function validate() {

	//console.log(signUpCheck.idDup);
	for ( var key in signUpCheck) {
		if (!signUpCheck[key]) {
			console.log("유효값 false -> " + key + " : "
					+ signUpCheck[key])
			alert("일부 입력값이 잘못되었습니다.");
			var id = "#" + key;
			$(id).focus();
			return false;
		}
	}
}