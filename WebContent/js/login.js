$(function () {
    // 전화번호 입력후 확인 버튼 클릭시
    // 현재 모달 제거
    $("#findIdBtn").click(function () {
        $("#findIdModal").modal("hide");
    });

    $("#findId-findPwdBtn").click(function () {
        $("#findIdResultModal").modal("hide");
    });

    // 전화번호 관련
    $(".phone").on("input", function () {

        // 전화번호 input 태그에 4글자 이상 입력하지 못하게 하는 이벤트
        if ($(this).val().length > $(this).prop("maxLength")) {
            $(this).val($(this).val().slice(0, $(this).prop("maxLength")));
        }

        // 전화번호 유효성 검사
        var regExp2 = /^\d{3,4}$/; // 숫자 3~4 글자
        var regExp3 = /^\d{4,4}$/; // 숫자 4 글자

        if (!regExp2.test($("#phone2").val()) || !regExp3.test($("#phone3").val())) {
            $("#checkPhone").text("전화번호가 유효하지 않습니다.")
                .css("color", "red");

            signUpCheck.phone = false;

        } else {
            $("#checkPhone").text("전화번호 형식이 유효합니다.")
                .css("color", "green");

            signUpCheck.phone = true;

        }
    });

    // 아이디 찾기 클릭 시
    $("#open-findid-modal").click(function () {
        $("#findIdModal").modal({ backdrop: "static" });
    });

    // 비밀번호 찾기 클릭 시
    $("#open-findpwd-modal").click(function () {
        $("#findPwdModal").modal({ backdrop: "static" });
    });

    // 회원가입 클릭 시
    $("#open-signup-modal").click(function () {
        $("#signUpModal").modal({ backdrop: "static" });
    });

    // 아이디 찾기 모달에서 확인 버튼 클릭 시
    $("#findIdBtn").click(function () {
        $("#findIdModal").modal("hide");
        console.log($("#findId-phone1").length);
        // if("#findId-phone1")
        $("#findIdResultModal").modal({ backdrop: "static" });
    });

    // 아이디 확인 모달에서 비밀번호 찾기 클릭 시
    $("#findId-findPwdBtn").click(function () {
        $("#findIdResultModal").modal("hide");
        $("#findPwdModal").modal({ backdrop: "static" });
    });

    // 비밀번호 찾기 모달에서 확인 버튼 클릭 시
    $("#findPwdBtn").click(function () {
        $("#findPwdModal").modal("hide");
        if($("#findPwd-input-id").val() == "1"){
            alert("입력하신 정보가 일치하지 않습니다.");
        }else{
            $("#changePwdModal").modal({ backdrop: "static" });
        }
    });

    // 비밀번호 변경 버튼 클릭 시
    $("#changePwdBtn").click(function(){
        $("#changePwdModal").modal("hide");
        alert("비밀번호가 성공적으로 변경되었습니다.");
    });
});