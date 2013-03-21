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
<div class="span6 border topline bottomline leftline rightline" id="main">
<t:form action="${contextPath}/event/showDetail" value="${action}" method="post" id="showSocialEventForm" class="form-horizontal">
<h4 class="border facebook topline bottomline leftline7 rightline">エントリー完了</h4>
<div class="row-fluid">
<input type="hidden" id="EventId" name="eventId" value="" />
<div class="control-group">
<label class="control-label">イベント名</label>
<div class="controls">
<span class="input-xlarge uneditable-input">${f:out(event.eventName)}</span>
</div>
</div>

<div class="control-group">
<label class="control-label">イベント開始日</label>
<div class="controls">
<span class="input-xlarge uneditable-input">${f:out(event.eventDateFromString)}</span>
</div>
</div>


<div class="control-group">
<label class="control-label">イベント終了日</label>
<div class="controls">
<span class="input-xlarge uneditable-input">${f:out(event.eventDateToString)}</span>
</div>
</div>

<div class="control-group">
<label class="control-label">開催場所</label>
<div class="controls">
<span class="input-xlarge uneditable-input">${f:out(event.place)}</span>
</div>
</div>

<div class="control-group">
<label class="control-label">説明</label>
<div class="controls">
<span class="input-xlarge uneditable-input">${f:out(event.description)}</span>
</div>
</div>

<div class="control-group">
<label class="control-label">スタンプの数</label>
<div class="controls">
<span class="input-xlarge uneditable-input">${f:out(event.stampCount)}</span>
</div>
</div>


<c:forEach var="stamp" items="${action.event.stampList}" varStatus="status">
<div class="row-fluid">
<div class="span12 border topline bottomline leftline rightline">
	<div class="span3">
		<h5>No:${f:out(stamp.stampNo)}</h5>
		<div class="thumbnail">
			<img src="${f:out(stamp.memberFileUrl)}" alt="${f:out(stamp.action)}">
			<t:input name="fileId" type="hidden" class="fileId" value="${f:out(stamp.fileId)}"/>
			<div class="caption">
			<p><t:input name="selectImageButton" type="button" class="btn eventDetailButton" value="画像選択" onClick="mdlg(this)"/></p>
			<p><t:input name="selectImageButton" type="button" class="btn eventDetailButton" value="ＱＲ表示" onClick="mdlg(this)"/></p>
			</div>
		</div>
	</div>
	<div class="span9">
			<div class="control-group">
			<label class="control-label">場所</label>
			<div class="controls">
				<t:input name="place" type="text" value="${f:out(stamp.place)}" class="stamp-place"/>
			</div>
			</div>
			<div class="control-group">
			<label class="control-label">場所URL</label>
			<div class="controls">
				<t:input name="placeUrl" type="text" value="${f:out(stamp.placeUrl)}" />
			</div>
			</div>
			<div class="control-group">
			<label class="control-label">行動</label>
			<div class="controls">
				<t:input name="action" type="text" value="${f:out(stamp.action)}" class="stamp-action"/>
			</div>
			</div>
			<div class="control-group">
			<label class="control-label">説明</label>
			<div class="controls">
				<t:input name="description" type="text" value="${f:out(stamp.description)}"/>
			</div>
			</div>
			<div class="control-group">
			<label class="control-label">投稿内容</label>
			<div class="controls">
				<span class="input-xlarge uneditable-input stamp-fbpost"></span>
			</div>
			</div>
	</div>
</div>
</div><!-- row-fluid -->
</c:forEach>
</div>
</t:form>
<br/>
<t:form action="${contextPath}/" method="post" value="${action}" >
<t:input name="createEvent" class="btn" type="submit" value="TOPへ"/>
</t:form>
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




<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.17/jquery-ui.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		/*トップ画面*/
//		$(".eventImage").click(function(){//画像ボタン押下(イベント選択）時処理
//			alert('呼ばれました');
//			$('#EventId').val($(this).
//				closest('div'). // <div>要素直上の<tr>要素を取得
//				children('input'). // 配下から2番目の<input>要素を取得
//				text() // そのテキスト値をEventIdの値に設定
//			);
//			$('#showSocialEventForm').submit();
//		});
//		$(".eventDetailButton").click(function(){//詳細ボタン押下時処理
//			$('#EventId').val(jQuery.trim($(this).parent().parent().children("td:nth-child(2)").text()));
//			$('#showSocialEventForm').submit();
//		});
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

	//Topページ、イベント詳細表示
	function showEventDetail(id){
		alert("showEventDetail id=["+id+"] called");
		document.getElementById('EventId').value = id;
		document.getElementById('showSocialEventForm').submit();
	}

	//詳細ページ、投稿の表示制御
	function makePostSentence(element){
		var v, old = element.value;
		return function(){
			if(old != (v=element.value)){
				old = v;
				place = $(this).parent().parent().parent().find('.stamp-place').val();
				action = $(this).parent().parent().parent().find('.stamp-action').val();
				str = $(this).val();
				if(place){
					$(this).parent().parent().parent().find('.stamp-fbpost').text(place + "にて" + action);
				}else{
					$(this).parent().parent().parent().find('.stamp-fbpost').text(action);
				}
			}
		}
	}

	function mdlg(element){
		n = showModalDialog("${contextPath}/event/selectImage");
		alert("ファイルID:"+n);
		return function(){
			$(this).parent().parent().parent().find('.fileId').val(n);
			//画像も選択したものを表示するようにする。
		}
	}

	function showQRCodedlg(element){
		var authKey=
		showModalDialog("${contextPath}/event/showQRCode?");
	}
	</script></body>
</html>
