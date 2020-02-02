<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/mypage-point-charge.css">
<!-- iamport.payment.js -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>


<title>온스터디</title>
<style>
.btn-group {
	width: 100%;
	margin: auto;
}

.btn-group .btn {
	border-color: #ffffff;
	background-color: #9e9e9e;
	color: #ffffff;
}
</style>

</head>

<body>
	<%@ include file="../common/loginedHeader.jsp"%>

	<div id="container" style="color: #333333;">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<p class="content-title">포인트 관리</p>
					<div class="jumbotron">
						<p class="mypage-point-charge-title">포인트 충전</p>
						<div class="point-charge">
							<label for="amount-of-money" class="amount-of-money-label">충전할	금액</label>
							<input type="number" id="amount-of-money"
								class="form-control input-comment" min="1000" step="1000"
								placeholder="금액을 1000원 단위로 입력해주세요." name="pointCharge">
							<button
								class="btn btn-md form-control orange-hover-btn 10-thousand-won"
								type="button" value="10000" style="width: 24%">1만원</button>
							<button
								class="btn btn-md form-control orange-hover-btn 30-thousand-won"
								type="button" value="30000" style="width: 24%">3만원</button>
							<button
								class="btn btn-md form-control orange-hover-btn 50-thousand-won"
								type="button" value="50000" style="width: 24%">5만원</button>
							<button
								class="btn btn-md form-control orange-hover-btn 100-thousand-won"
								type="button" value="100000" style="width: 24%">10만원</button>
							<div class="charge-way">
								<p class="mb-1 mypage-point-charge-way">충전수단</p>
								<div class="btn-group btn-group-toggle" data-toggle="buttons"
									id="pointInOutWrapper">
									 <label class="btn btn-dark"> <input checked
										type="radio" name="chargeWay" id="directCharge" value="D">
										무통장 입금
									</label> <label class="btn btn-dark"> <input
										type="radio" name="chargeWay" id="cardCharge" value="C">
										카드 결제
									</label>
								</div>
							</div>
							<div class="charge-confirm">
								<button
									class="btn btn-lg mt-5 form-control orange-hover-btn charge-confirm-btn" onclick="charge()"
										style="width: 200px">충전하기</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
<script>

	$(function() {
		$(".10-thousand-won").on({
			"click" : function() {
				$("#amount-of-money").val($(this).val());
			}
		});
		$(".30-thousand-won").on({
			"click" : function() {
				$("#amount-of-money").val($(this).val());
			}
		});
		$(".50-thousand-won").on({
			"click" : function() {
				$("#amount-of-money").val($(this).val());
			}
		});
		$(".100-thousand-won").on({
			"click" : function() {
				$("#amount-of-money").val($(this).val());
			}
		});

		$(".charge-way-btn").on({
			"click" : function() {
				$(this).css("backgroundColor", "#f15a25").css("color",
						"#ffffff");
			}
		});
		
		$("input[name=chargeWay]").click(function(){
			console.log($(this).val());
		});
		
		$("#amount-of-money").on("keyup", function(){
			 $(this).val($(this).val().replace(/[^0-9]/g,""));
		});
		
	});
	
	function charge(){
		$chargeWay = $("input[name=chargeWay]:checked");
		var amount = $("#amount-of-money").val();
		
		if($chargeWay.val() == "C"){
			var name = "온스터디 포인트 충전";
			var buyer_name = "<%=loginMember.getMemberNm() %>";
			var buyer_tel = "<%=loginMember.getMemberPhone() %>";
			
			var merchant_uid;
			
			$.ajax({
				url : "pointCardCharge",
				type : "post",
				data : {
					name : name,					// 주문명
					amount: amount,					// 결제할 금액
					buyer_name: buyer_name,	 		// 주문자명 
					buyer_tel: buyer_tel,			// 주문자 연락처
				},
				success : function(merchant_uid){
					console.log(merchant_uid);
					
					if(merchant_uid != ""){
						payment(name, amount, buyer_name, buyer_tel, merchant_uid);
					}else{
						alert("카드 결제에 실패하였습니다.");
					}
				},
				
				error : function(){
					alert("ajax 통신 실패");
				}
				
			});
			
		}else{
			location.href="pointCharge?pointCharge=" + amount;
		}

	}
	
	function payment(name, amount, buyer_name, buyer_tel, merchant_uid){
		
		// STEP2 가맹점 식별하기
		// IMP 객체의 init 함수의 인자에 가맹점 식별코드를 삽입하고 웹사이트의 결제 페이지에서 호출합니다.

		var IMP = window.IMP; // 생략해도 괜찮습니다.
		IMP.init("imp95918894"); // "imp00000000" 대신 발급받은 "가맹점 식별코드"를 사용합니다.
		
		// STEP3결제창 호출코드 추가하기
		// IMP.request_pay(param, callback)을 호출합니다. 함수의 첫번째 인자인 param에 결제 요청에 필요한 속성과 값을 담습니다
		// IMP.request_pay(param, callback) 호출
		IMP.request_pay({ // param
			// param 객체 속성
			// https://docs.iamport.kr/tech/imp#param
			
			// pg : pg사 선택
			pg: "html5_inicis", // (이니시스웹표준)
			
			// 결제 수단
			pay_method: "card", // (신용카드)
			
			// 가맹점에서 생성/관리하는 고유 주문번호 (필수항목)
			// 결제가 된 적이 있는 merchant_uid로는 재결제 불가
			// script 마지막 설명 참고 
			merchant_uid: merchant_uid,
			
			// 주문명
			name: name,  //(주문명 입력값)
			
			// 결제할 금액
			amount: amount,	// 결제할 금액 입력값
			
			// 주문자명 (선택항목)
			buyer_name: buyer_name,
			
			// 주문자 연락처 (선택항목)
			buyer_tel: buyer_tel,
			
		}, function (rsp) { // callback
			/*
				- callback함수의 rsp객체
				IMP.request_pay()함수의 두번째 인자에는 JavaScript 함수를 지정합니다. 
				이를 callback함수라고 부르며, 결제 프로세스 완료 후 호출되는 함수입니다. 
				해당 함수가 호출될 때 결제 결과의 정보를 담고있는 rsp객체를 인자로써 가집니다. 
				해당 객체를 통해 결제 성공여부, 결제 에러 메시지, 결제 승인 시각 등의 정보를 확인할 수 있습니다.
			*/
			console.log(rsp);
			
		  	if (rsp.success) {  // 결제 성공 시: 결제 승인 또는 가상계좌 발급에 성공한 경우
			//[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid,merchant_uid 전달하기
				$.ajax({
					url: "insertImpUid", //cross-domain error가 발생하지 않도록 동일한 도메인으로 전송
					type: 'POST',
					dataType: 'text',
					async : false,
					data: {
						imp_uid : rsp.imp_uid,			// 아임포트 거래 고유 번호
						merchant_uid: rsp.merchant_uid,  // 가맹점에서 생성/관리하는 고유 주문번호
						amount: amount					// 결제 금액
					},
					success: function(result){
						console.log("result : " + result);
						alert("결제 완료");
						location.href="mypage";
					},
					error: function(e){
						alert("insertImpUid 반환 중 에러");
					}
				}).done(function(data) {
					//[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
					console.log(data);
					console.log(everythings_fine);
					if ( everythings_fine ) {
						var msg = '결제가 완료되었습니다.';
						msg += '\n고유ID : ' + rsp.imp_uid;
						msg += '\n상점 거래ID : ' + rsp.merchant_uid;
						msg += '\결제 금액 : ' + rsp.paid_amount;
						msg += '카드 승인번호 : ' + rsp.apply_num;
				
						alert(msg);
						location.href="mypage";
						
					} else {
						alert("결제 실패");
						//[3] 아직 제대로 결제가 되지 않았습니다.
						//[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
					}
				});
			 } else {
				 alert("결제 취소");
			 }
		});
	}
</script>

	<%@ include file="../common/footer.jsp"%>

</body>

</html>