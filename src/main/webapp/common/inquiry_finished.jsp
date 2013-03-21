<!DOCTYPE html>
<html lang="ja">
<c:import url="/common/htmlheader.jsp" />
<body>
<c:import url="/common/bodyheader.jsp" />
<div id="container" class="container-fluid">
<c:import url="/common/navbar.jsp" />
<div id="content">
<div class="row-fluid">
<div class="span3 left_navi">
</div>
<div class="span6" id="main">
<c:import url="/common/notice.jsp"/>
<h4>お問い合わせ内容を送信しました。</h4>
</div><!-- main -->
<div class="span3 right_navi">
</div>
</div><!-- row-fluid -->
</div><!-- content -->
<div id="footer">
	<div class="row-fluid">
	<div class="span3">
	<a href="http://www.g-aster.jp/">Copyright 2013  All Rights Reserved</a>
	</div>
	</div>
</div><!-- footer -->
</div><!-- container -->


<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.17/jquery-ui.min.js"></script>
<script src="${contextPath}/js/image-picker.min.js"></script>
<script src="${contextPath}/js/bootstrap.min.js"></script>
<script src="${contextPath}/js/image-resize.js"></script>
<script type="text/javascript">

	$(document).ready(function() {
		$(function() {
			//画像選択
			$("select.image-picker").imagepicker({
				hide_select:  true,
		    });
		});
	});

</script></body>
</html>
