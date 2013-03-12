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
<jsp:include page="/common/htmlheader.jsp"></jsp:include>
<body>

<jsp:include page="/common/bodyheader.jsp"></jsp:include>


<div id="container" class="container-fluid">
<jsp:include page="/common/navbar.jsp"></jsp:include>

<div id="content">
<div class="row-fluid">
<div class="span3 left_navi">
</div>
<div class="span6" id="main">
<t:form action="${contextPath}/event/create" value="${action}"  class="form-horizontal" method="post">
<h4 class="border facebook topline bottomline leftline7 rightline">イベント作成</h4>
<input type="hidden" id="EventId" value="" />

<div class="control-group">
<label class="control-label">イベント名</label>
<div class="controls">
<t:input name="eventName" type="text" length="16" placeholder="XXXX商店街スタンプラリー"/>
</div>
</div>

<div class="control-group">
<label class="control-label">イベント開始日</label>
<div class="controls">
<t:input name="eventDateFrom" type="text" length="16" id="eventDateFrom" />
</div>
</div>


<div class="control-group">
<label class="control-label">イベント終了日</label>
<div class="controls">
<t:input name="eventDateTo" type="text" length="16" id="eventDateTo" />
</div>
</div>

<div class="control-group">
<label class="control-label">開催場所</label>
<div class="controls">
<t:input name="place" type="text" length="16" placeholder="開催場所を入力してください"/>
</div>
</div>

<div class="control-group">
<label class="control-label">説明</label>
<div class="controls">
<t:input name="description" type="text" length="16" placeholder="Facebookへ表示されます"/>
</div>
</div>

<div class="control-group">
<label class="control-label">スタンプの数</label>
<div class="controls">
<t:input name="stampCount" type="text" length="2" />
</div>
</div>

<div class="control-group">
<label class="control-label">画像ファイル</label>


<div class="controls">
	<select class="image-picker" name="selectImage" id="selectI">
	<c:forEach var="memberFile" items="${action.memberFileList}" varStatus="status">
		<option value='${f:out(memberFile.fileId)}' data-img-src='${f:out(memberFile.imageUrl)}'>${f:out(memberFile.fileName)}</option>
	</c:forEach>
	</select>
</div>
</div>

<t:input name="createEvent" class="btn btn-info" type="submit" value="登録"/>

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
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/i18n/jquery.ui.datepicker-ja.min.js"></script>
<script type="text/javascript">

	$(document).ready(function() {
		$(function() {
			$("#eventDateFrom").datepicker();
		});
		$(function() {
			$("#eventDateTo").datepicker();
		});
		$(function() {
			$("select.image-picker").imagepicker({
				hide_select:  false,
		    });
		});


		/* 詳細画面 */
		$("#updateEventStampButton").click(function(){//スタンプの更新ボタン押下時処理
			$('#updateEventStampForm').submit();
		});
    	$('#stamp-dialog').dialog({//QRコード表示ダイアログ初期制御
			autoOpen: false
		});
		$(".showQRButton").click(function() {//QRコード表示ボタン押下時処理
			$('#stamp-dialog img').attr("src",'http://localhost/yoyaku_sys/yoyaku/img/stamp/' +$(this).parent().parent().parent().find('.qrcode').val());
			$('#stamp-dialog img').attr("alt",$(this).parent().parent().parent().find('.qrcode').val());
			//選択行のバーコードをダイアログに移す
			$('#stamp-dialog').dialog('open');
		});

		//入力時のkeyupをイベントリスナーとして登録
		$(".stamp-action").each(function(){
			$(this).bind('keyup', makePostSentence(this));
		});
		$(".stamp-place").each(function(){
			$(this).bind('keyup', makePostSentence(this));
		});

	});

	//詳細ページ、投稿の表示制御
	function makePostSentence(element){
		var v, old = element.value;
		return function(){
			if(old != (v=element.value)){
				old = v;
				place = $(this).parent().parent().find('.stamp-place').val();
				action = $(this).parent().parent().find('.stamp-action').val();
				str = $(this).val();
				if(place){
					$(this).parent().parent().find('.stamp-fbpost').val(place + "にて" + action);
				}else{
					$(this).parent().parent().find('.stamp-fbpost').val(action);
				}
			}
		}
	}

</script></body>
</html>
