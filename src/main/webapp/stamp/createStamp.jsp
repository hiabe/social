<%--

    Copyright 2004-2010 the Seasar Foundation and the Others.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
    either express or implied. See the License for the specific language
    governing permissions and limitations under the License.

--%>

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
<c:import url="/common/errors.jsp"/>
<c:import url="/common/notice.jsp"/>
<t:form action="${contextPath}/stamp/create" id="createStampForm" value="${action}"  class="form-horizontal" method="post">
<h4 class="border facebook topline bottomline leftline7 rightline">QRコード作成</h4>
<input type="hidden" id="fileId" value="" />

<div class="control-group">
<label class="control-label">投稿メッセージ</label>
<div class="controls">
<t:input name="message" type="text" length="16" placeholder="XXXXをしました。"/>
</div>
</div>

<div class="control-group">
<label class="control-label">リンクタイトル</label>
<div class="controls">
<t:input name="linkName" type="text" length="16" id="linkName" placeholder="XXXXXスタンプラリー"/>
</div>
</div>

<div class="control-group">
<label class="control-label">見出し</label>
<div class="controls">
<t:input name="caption" type="text" length="16" id="caption" placeholder="XXゲット！"/>
</div>
</div>


<div class="control-group">
<label class="control-label">linkURL(投稿のlinkです。）</label>
<div class="controls">
<t:input name="postUrl" type="text" length="64" placeholder="http://www.hoge.com/"/>
</div>
</div>

<div class="control-group">
<label class="control-label">説明文</label>
<div class="controls">
<t:textarea name="description" placeholder="XXXXは◯◯日－XX日までXXで開催中"/>
</div>
</div>


<div class="control-group">
<label class="control-label">画像ファイル</label>
<div class="controls">
	<select class="image-picker" name="fileId" id="selectImage">
	<c:forEach var="memberFile" items="${memberFileList}" varStatus="status">
		<option value='${f:out(memberFile.fileId)}' data-img-src='${contextPath}${f:out(memberFile.imageUrl)}'>${f:out(memberFile.fileName)}</option>
	</c:forEach>
	</select>
</div>
</div>

<t:input name="createStamp" class="btn btn-info" type="button" id="createStamp"value="登録"/>

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
<script src="${contextPath}/js/jquery.ui.draggable.js"></script>
<script src="${contextPath}/js/jquery.alerts.js"></script>
<script>

	$(document).ready(function() {
		$(function() {
			//画像選択
			$("select.image-picker").imagepicker({
				hide_select:  true,
		    });
		});
		//登録ボタン
		$('#createStamp').click(function(){
			jConfirm('登録します。よろしいですか?', '登録確認', function(isOk) {
		        if (isOk) {
		        	$('#createStampForm').submit();
		        }
			});
		});
	});

</script></body>
</html>
