var phoneCheck = false;
var phoneCheck2 = false;

$(function () {
	
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

        if (!regExp2.test($("#findIdPhone2").val()) || !regExp3.test($("#findIdPhone3").val())) {

        	phoneCheck = false;

        } else {

        	phoneCheck = true;

        }
        
        if (!regExp2.test($("#findPwdPhone2").val()) || !regExp3.test($("#findPwdPhone3").val())) {

        	phoneCheck2 = false;

        } else {

        	phoneCheck2 = true;

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

    // 아이디 확인 모달에서 비밀번호 찾기 클릭 시
    $("#findId-findPwdBtn").click(function () {
        $("#findIdResultModal").modal("hide");
        $("#findPwdModal").modal({ backdrop: "static" });
    });
    
//    // 비밀번호 변경 버튼 클릭 시
//    $("#changePwdBtn").click(function(){
//        $("#changePwdModal").modal("hide");
//        alert("비밀번호가 성공적으로 변경되었습니다.");
//    });
    
    // 아이디 찾기 버튼 클릭 시 
    $("#findIdBtn").click(function(){
    	console.log("check : " + phoneCheck);
    	
    	if(phoneCheck){
    		var phone1 = $("#findIdPhone1").val();
        	var phone2 = $("#findIdPhone2").val();
        	var phone3 = $("#findIdPhone3").val();
        	
        	$.ajax({
    			url: "findId",
    			data: {phone1 : phone1, phone2 : phone2, phone3 : phone3},
    			dataType: "json",
    			type: "post",
    			
    			success : function(obj){
    				console.log("ID찾기 통신 성공");
    				console.log(obj);
    				
    				$("#findIdModal").modal("hide");
    				if(obj.check == "yes"){
    					var $findIdBody = $("#findIdResultBody");
    					
    					$findIdBody.html("");
    					
    					var $result = "";
    					$result += "<p class='small'>";
    					$result += "아이디 : " + obj.id + "<br>";
    					$result += "이름 : " + obj.name + "<br>";
    					$result += "가입일 : " + obj.date;
    					$result += "</p>";
    					
    					$findIdBody.append($result);
    					
    					$("#findIdResultModal").modal({ backdrop: "static" });
    
    				}else{
    					alert("일치하는 휴대폰 번호가 없습니다.");
    				}
    			},

    			error : function(request,status,error){
    				alert("code = "+ request.status + " message = " + request.responseText + " error = " + error);
    				$("#findIdModal").modal("hide");
    			},
    			
    		});
    		
    	}else{
    		alert("유효한 전화번호가 아닙니다. 다시 입력해주세요");
    	}

    });
    
    // 비밀번호 찾기 버튼 클릭 시 
    $("#findPwdBtn").click(function(){
    	console.log("check : " + phoneCheck2);
    	
    	if(phoneCheck2){
    		id = $("#findPwdId").val();
    		var phone1 = $("#findPwdPhone1").val();
        	var phone2 = $("#findPwdPhone2").val();
        	var phone3 = $("#findPwdPhone3").val();
        	
        	$.ajax({
    			url: "findPwd",
    			data: {id : id, phone1 : phone1, phone2 : phone2, phone3 : phone3},
    			dataType: "text",
    			type: "post",
    			
    			success : function(result){
    				console.log("Pwd찾기 통신 성공");
    				console.log(result);
    				
    				$("#findPwdModal").modal("hide");
    				if(result == "yes"){
    					$("#changePwdModal").modal({ backdrop: "static" });
    				}else{
    					alert("입력하신 정보가 일치하지 않습니다.");
    				}
    			},

    			error : function(request,status,error){
    				alert("code = "+ request.status + " message = " + request.responseText + " error = " + error);
    				$("#findIdModal").modal("hide");
    			},
    			
    		});
    		
    	}else{
    		alert("유효한 전화번호가 아닙니다. 다시 입력해주세요");
    	}

    });
    
    // 비밀번호 변경 버튼 클릭 시
    $("#changePwdBtn").click(function(){
    	var $pwd1 = $("#changePwd-input-pwd1");
		var $pwd2 = $("#changePwd-input-pwd2");
		
		var regExp = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&~^])[A-Za-z\d$@$!%*#?&~^]{8,16}$/;
		
		if(!regExp.test($pwd1.val())){
			alert("비밀번호가 유효하지 않습니다.");
			
		}else{
			
			if($pwd1.val().trim() != $pwd2.val().trim()){
				alert("비밀번호가 일치하지 않습니다.");
				
			}else{
				$.ajax({
					url: "changePwd",
					data: {id : id, pwd1 : $pwd1.val()},
					dataType: "text",
					type: "post",
					
					success : function(result){
						console.log("Pwd변경 통신 성공");
						console.log(result);
						
						if(result == "yes"){
							alert("비밀번호가 변경되었습니다");
						}else{
							alert("비밀번호 변경에 실패하였습니다");
						}
						
					},

					error : function(request,status,error){
						alert("code = "+ request.status + " message = " + request.responseText + " error = " + error);
						$("#findIdModal").modal("hide");
					},
					
				});
			}
		}

    });
    
    
});