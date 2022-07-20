<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <!-- jQuery -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
    <!-- iamport.payment.js -->
    <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.7.js"></script>

    <script type="text/javascript">
            IMP.init('imp33592445'); //iamport 대신 자신의 "가맹점 식별코드"를 사용하시면 됩니다
            IMP.request_pay({
                merchant_uid : 'merchant_' + new Date().getTime(),
                name : '${purchaseInfo.purchaseName}',
                amount : ${purchaseInfo.purchaseCost},
                buyer_email : '${loginUserInfo.email}',
                buyer_name : '${loginUserInfo.name}',
                buyer_tel : '${loginUserInfo.tel}',
                buyer_addr : '${loginUserInfo.addr}',
            buyer_postcode : '${loginUserInfo.postalCode}'
        }, function(rsp) {
            if ( rsp.success ) {
//                 var msg = '결제가 완료되었습니다.';
//                 msg += '고유ID : ' + rsp.imp_uid;
//                 msg += '상점 거래ID : ' + rsp.merchant_uid;
//                 msg += '결제 금액 : ' + rsp.paid_amount;
//                 msg += '카드 승인번호 : ' + rsp.apply_num;
//                 msg += '구매 상품 명 : ' + name;
                alert("구매 성공! 구매 내역 페이지로 이동합니다");
//                 location.href="/temperShop/myPage/purchase_history.jsp?userIdx="+${loginUserInfo.userIdx };
                location.href="/temperShop/purchase/history?userIdx="+${loginUserInfo.userIdx }+"&impUid="+rsp.imp_uid+"&mcUid="+rsp.merchant_uid+"&paid="+rsp.paid_amount;
                
            } else {
        			$.ajax({
        				url: "/temperShop/purchase/cancel_list?",
        				type: "post",
        				data: "purchaseDate=${purchaseInfo.purchaseDate}",
        				success: function() {
        					alert("구매를 취소하고 목록으로 돌아갑니다");
        					location.href="/temperShop/product/list?pageNumber=1";
        				},
        				error: function(response) {
        					if(response.status == 409) {
        						alert("오류 발생");
        					}
        				}
        			});
            }
        });
        
      </script>
</body>
</html>