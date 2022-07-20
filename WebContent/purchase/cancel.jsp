<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>아임포트 기본 환불 샘플</title>
    <!-- jQuery -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
    <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
  </head>
  <body>
  <br/>
  <div id="cancelDiv">
    <form name="myform">
      [필수]아임포트 고유거래번호(imp_uid) : <input type="text" name="imp_uid" value=""/><br/>
      [옵션]취소사유                    : <input type="text" name="reason"  value="고객단순변심 환불"/><br/>
    </form>
    <br/>
    <input type="button" onclick="cancel()" value="취소"/><br/>
  </div>

  <!--<script src="cancelRefundSvr.js"></script> -->

  <script language="javascript">
  
    function cancel() {
      console.log("cancel()")
  
      let imp_uid = document.myform.imp_uid.value;
      let reason = document.myform.reason.value;
  
      $.ajax({
        url: "/temperShop/cancel_refund",
        type: "POST",
        data: "imp_uid=value&reason=value&...",
        success: function(data) {
          // 가맹점 서버 결제 API 성공시 로직
          console.log('결제 성공');
          console.log(data);
        },
        error: function() {
          alert("알 수 없는 문제 발생");
        }
      })
  
    }
  </script>
  </body>
</html>