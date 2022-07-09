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
                name : '${prodDetail.prodName}',
                amount : ${purchaseInfo.cost},
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
                location.href="/temperShop/myPage/purchase_history.jsp";
                
            } else {
//                 var msg = '결제에 실패하였습니다.';
//                 msg += '에러내용 : ' + rsp.error_msg;
                console.log("결제에 실패했습니다 쇼핑몰 페이지로 이동합니다");
                location.href="/temperShop/product/list?pageNumber=1";
            }
        });
        
      </script>
</body>
</html>