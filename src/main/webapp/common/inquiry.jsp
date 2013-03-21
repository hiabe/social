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
<t:form action="${contextPath}/postInquiry" value="${action}"  class="form-horizontal" method="post">
<h4 class="border facebook topline bottomline leftline7 rightline">お問い合わせ</h4>
<c:import url="/common/errors.jsp"/>

<div class="control-group">
<label class="control-label">*お名前</label>
<div class="controls">
<t:input name="myName" type="text" length="16" placeholder="名前　太郎"/>
</div>
</div>

<div class="control-group">
<label class="control-label">*メールアドレス</label>
<div class="controls">
<t:input name="mailAddress" type="text" length="64" id="mailAddress" placeholder="yourname@domain.com"/>
</div>
</div>

<div class="control-group">
<label class="control-label">*お問い合わせ内容</label>
<div class="controls">
<t:textarea name="comment" />
</div>
</div>

<t:input name="post" class="btn btn-info" type="submit" value="送信"/>

</t:form>
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
</div>
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
