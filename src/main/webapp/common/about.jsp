<!DOCTYPE html>
<html lang="ja">
<c:import url="/common/htmlheader.jsp"/>
<body>
<c:import url="/common/bodyheader.jsp"/>
<c:import url="/common/errors.jsp"/>
<div id="container" class="container-fluid">
<c:import url="/common/navbar.jsp"/>
<div id="content">
<div class="row-fluid">
<div class="span3 left_navi">
</div>
<div class="span6" id="main">
ソーシャルスタンプは、画面から作成したQRコードを参照すると、作成した内容が自動的に、ポストされる
サービスです。

<br/>

</div><!-- main -->
<div class="span3 right_navi">
</div>
</div><!-- row-fluid -->
</div><!-- content -->
<div id="footer">
	<div class="row-fluid">
	<a href="http://www.g-aster.jp/">Copyright 2013  All Rights Reserved</a>
	</div>
</div>
</div><!-- container -->




<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.17/jquery-ui.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/image-picker.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/image-resize.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#stamp-dialog').dialog({//QRコード表示ダイアログ初期制御
			autoOpen: false
		});
		$(".showQRButton").click(function() {//QRコード表示ボタン押下時処理
			$('#stamp-dialog img').attr("src",'http://localhost/yoyaku_sys/yoyaku/img/stamp/' +$(this).parent().parent().parent().find('.qrcode').val());
			$('#stamp-dialog img').attr("alt",$(this).parent().parent().parent().find('.qrcode').val());
			//選択行のバーコードをダイアログに移す
			$('#stamp-dialog').dialog('open');
		});
		//画像選択
		$("select.image-picker").imagepicker();
	});

	//Topページ、スタンプ詳細表示
	function showStampDetail(authKey){
		document.getElementById('authKey').value = authKey;
		document.getElementById('showStampForm').submit();
	}

	function createEventWithStamp(id){
		alert("未実装です file_id="+id);
	}

</script></body>
</html>
