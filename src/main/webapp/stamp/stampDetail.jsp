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
<head>
<jsp:include page="/common/htmlheader.jsp"></jsp:include>
</head>
<body>
<jsp:include page="/common/bodyheader.jsp"></jsp:include>
<div id="container" class="container-fluid">
<jsp:include page="/common/navbar.jsp"></jsp:include>
<div id="content">
<div class="row-fluid">
<div class="span3 left_navi">
</div>
<c:import url="/common/errors.jsp"/>
<c:import url="/common/notice.jsp"/>
<div class="span6 border topline bottomline leftline rightline" id="main">
<t:form action="${contextPath}/stamp/update" value="${action}" method="post" id="showStampForm" class="form-horizontal">
<h4 class="border facebook topline bottomline leftline7 rightline">ＱＲコード詳細</h4>
<div class="row-fluid">
<input type="hidden" id="stampId" name="stampId" value="${f:out(action.stampDto.stampId)}" />
<input type="hidden" id="authKey" name="authKey" value="${f:out(action.stampDto.authKey)}" />
<div class="control-group">
<label class="control-label">メッセージ</label>
<div class="controls">
<t:input name="message" type="text" length="16" value="${f:out(action.stampDto.message)}" />
</div>
</div>
<div class="control-group">
<label class="control-label">リンクタイトル</label>
<div class="controls">
<t:input name="linkName" type="text" length="16" id="linkName"  value="${f:out(action.stampDto.linkName)}"/>
</div>
</div>
<div class="control-group">
<label class="control-label">見出し</label>
<div class="controls">
<t:input name="caption" type="text" length="16" id="caption"  value="${f:out(action.stampDto.caption)}"/>
</div>
</div>
<div class="control-group">
<label class="control-label">URL</label>
<div class="controls">
<t:input name="postUrl" type="text" length="16" id="postUrl" value="${f:out(action.stampDto.postUrl)}"/>
</div>
</div>
<div class="control-group">
<label class="control-label">説明文</label>
<div class="controls">
<t:textarea name="description" id="description" value="${f:out(action.stampDto.description)}"/>
</div>
</div>

<div class="control-group">
<label class="control-label">投稿画像</label>
<div class="controls">
<img src="${contextPath}${f:out(action.stampDto.memberFileUrl)}" class="thumbnail-img" id="post-img"/>
</div>
</div>
<div class="image-select">
画像を選択する。
<select class="image-picker" name="fileId">
<c:forEach var="memberFile" items="${action.memberFileList}" varStatus="status">
	<option value='${f:out(memberFile.fileId)}' data-img-src='${contextPath}${f:out(memberFile.imageUrl)}'>${f:out(memberFile.fileName)}</option>
</c:forEach>
</select>
</div>

<div class="control-group">
<label class="control-label">ＱＲコード(クリックすると読込時と同じ動作をします。)</label>
<div class="controls">
<a href="${contextPath}${f:out(action.stampDto.pageUrl)}"><img src="${contextPath}${f:out(action.stampDto.imageUrl)}" class="thumbnail-img"/></a>
<p><t:input name="selectImageButton" type="button" class="btn eventDetailButton" value="拡大表示" onClick="showQRCodedlg('${f:out(action.stampDto.authKey)}')"/></p>
</div>
</div>

</div>
<p><t:input name="updateStamp" class="btn" id="updateStamp" type="button" value="更新"/></p>
</t:form>
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




<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.17/jquery-ui.min.js"></script>
<script src="${contextPath}/js/bootstrap.min.js"></script>
<script src="${contextPath}/js/image-picker.min.js"></script>
<script src="${contextPath}/js/image-resize.js"></script>
<script src="${contextPath}/js/jquery.ui.draggable.js"></script>
<script src="${contextPath}/js/jquery.alerts.js"></script>
<script>
	$(document).ready(function() {
		/* 詳細画面 */
		$("#updateEventStampButton").click(function(){//スタンプの更新ボタン押下時処理
			$('#updateEventStampForm').submit();
		});
		$('#stamp-dialog').dialog({//QRコード表示ダイアログ初期制御
			autoOpen: false
		});
		//画像選択
		$("select.image-picker").imagepicker({
			hide_select:  true,
	    });
		$('img.image_picker_image').click(function(){
			alert($(this).attr('src'));
			$('#post-img').attr("src",$(this).attr("src"));
		});
		//更新ボタン
		$('#updateStamp').click(function(){
			jConfirm('更新します。よろしいですか?', '更新確認', function(isOk) {
		    	jAlert('Confirmed: ' + isOk, 'Confirmation Results');
		        if (isOk) {
		        	$('#showStampForm').submit();
		        }
			});
		});
	});
	function mdlg(element){
		returnArray = showModalDialog("${contextPath}/stamp/selectImage");
		alert("ファイルID:"+returnArray[0]);
		alert("URL:"+returnArray[1]);
		if(fileId==null){
			alert("何もしない");
			return;
		}
		var parent = element.parentNode;
		alert(parent.innerHTML);
		var parent2 = element.parentNode.parentNode;
		alert(parent2.innerHTML);
		//画像も選択したものを表示するようにする。
	}

	//QRコードを表示します。
	function showQRCodedlg(authKey){
		showModalDialog("${contextPath}/stamp/showQRCode?authKey="+authKey);
	}
	</script></body>
</html>
