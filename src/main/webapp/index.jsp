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
<c:import url="/common/errors.jsp"/>
<c:import url="/common/notice.jsp"/>
<t:form action="${contextPath}/stamp/showDetail" value="${action}" method="post" id="showStampForm">
<h4 class="border facebook topline bottomline leftline7 rightline">作成したＱＲ一覧</h4>
<div class="row-fluid">
<input type="hidden" id="authKey" name="authKey" value="" />
<c:forEach var="stamp" items="${action.topForm.stampList}" varStatus="status">
<div class="span12 border topline bottomline leftline rightline ">
	<div class="span4">
		<div class="thumbnail">
			<img src="${contextPath}${f:out(stamp.memberFileUrl)}" class="thumbnail-img" alt="${f:out(stamp.caption)}">
		</div>
	</div>
	<div class="span8">
		<div class="caption">
			<h5>${f:out(stamp.caption)}</h5>
			<p>${f:out(stamp.message)}</p>
			<p><t:input name="stampDetail" type="button" class="btn stampDetailButton" value="詳細" onClick="showStampDetail('${f:out(stamp.authKey)}')"/></p>
		</div>
	</div>
</div>
</c:forEach>
</div>
</t:form>
<br/>
<t:form action="${contextPath}/stamp/createStamp" method="post" value="${action}" >
<t:input name="createEvent" class="btn btn-info" type="submit" value="アクションＱＲを作成する"/>
<select class="image-picker" name="selectImage">
<c:forEach var="memberFile" items="${action.topForm.memberImageList}" varStatus="status">
	<option value="${f:out(memberFile.fileId)}" data-img-src="${contextPath}${f:out(memberFile.imageUrl)}"/>
</c:forEach>
</select>
</t:form>
<div class="row-fluid">
<input type="hidden" id="StampId" name="stampId" value="" />
<div class="span12">
<t:form method="post" action="${contextPath}/fileUpload/upload" enctype="multipart/form-data" value="${form}">
<div class="control-group">
<label class="control-label">画像登録</label>
<div class="controls">
<t:input name="imageFile" type="file" />
</div>
</div>
<t:input name="imageUploadButton" type="submit" class="btn btn-info" value="画像を登録" />
</t:form>



</div>
</div>

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
