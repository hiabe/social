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
<t:form action="${contextPath}/event/update" value="${action}" method="post" id="showSocialEventForm" class="form-horizontal">
<h4 class="border facebook topline bottomline leftline7 rightline">イベント詳細</h4>
<div class="row-fluid">
<input type="hidden" id="EventId" name="eventId" value="" />
<div class="control-group">
<label class="control-label">イベント名</label>
<div class="controls">
<t:input name="eventName" type="text" length="16" value="${f:out(event.eventName)}" />
</div>
</div>

<div class="control-group">
<label class="control-label">イベント開始日</label>
<div class="controls">
<t:input name="eventDateFrom" type="text" length="16" id="eventDateFrom"  value="${f:out(event.eventDateFromString)}"/>
</div>
</div>
<div class="control-group">
<label class="control-label">イベント終了日</label>
<div class="controls">
<t:input name="eventDateTo" type="text" length="16" id="eventDateTo" value="${f:out(event.eventDateToString)}"/>
</div>
</div>

<div class="control-group">
<label class="control-label">開催場所</label>
<div class="controls">
<t:input name="place" type="text" length="16" value="${f:out(event.place)}" class="uneditable-input"/>
</div>
</div>

<div class="control-group">
<label class="control-label">説明</label>
<div class="controls">
<t:input name="description" type="text" length="16" value="${f:out(event.description)}" />
</div>
</div>

<div class="control-group">
<label class="control-label">参加用URL</label>
<div class="controls">
<a href="${f:out(event.pageUrl)}">${f:out(event.pageUrl)}</a>
</div>
</div>

<div class="control-group">
<label class="control-label">スタンプの数</label>
<div class="controls">
<t:input name="stampCount" type="text" length="2" value="${f:out(event.stampCount)}"/>
</div>
</div>


<c:forEach var="stamp" items="${action.event.stampList}" varStatus="status">
<div class="row-fluid">
<div class="span12 border topline bottomline leftline rightline">
	<div class="span3">
		<h5>No:${f:out(stamp.stampNo)}</h5>
		<div class="thumbnail">
			<img src="${f:out(stamp.memberFileUrl)}" alt="${f:out(stamp.message)}">
			<t:input type="hidden" id="StampId" name="stampId" value="${f:out(stamp.stampId)}" />
			<t:input name="fileId" type="hidden" class="fileId" value="${f:out(stamp.fileId)}"/>
			<div class="caption">
			<p><t:input name="selectImageButton" type="button" class="btn eventDetailButton" value="画像選択" onClick="mdlg(this)"/></p>
			<p><t:input name="selectImageButton" type="button" class="btn eventDetailButton" value="ＱＲ表示" onClick="showQRCodedlg(${f:out(stamp.stampId)},${f:out(stamp.eventId)})"/></p>
			</div>
		</div>
	</div>
	<div class="span9">
			<div class="control-group">
			<label class="control-label">メッセージ</label>
			<div class="controls">
				<t:input name="message" type="text" value="${f:out(stamp.message)}"/>
			</div>
			</div>
			<div class="control-group">
			<label class="control-label">link(URL)</label>
			<div class="controls">
				<t:input name="postUrl" type="text" value="${f:out(stamp.postUrl)}" />
			</div>
			</div>
			<div class="control-group">
			<label class="control-label">caption（見出し)</label>
			<div class="controls">
				<t:input name="caption" type="text" value="${f:out(stamp.caption)}" class="stamp-action"/>
			</div>
			</div>
	</div>
</div>
</div><!-- row-fluid -->
</c:forEach>
</div>
<t:input name="updateEvent" class="btn" type="submit" value="更新"/>
</t:form>
<br/>
<t:form action="${contextPath}/event/createevent" method="post" value="${action}" >
<t:input name="createEvent" class="btn" type="button" value="画像を登録する"/>
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




<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.17/jquery-ui.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/bootstrap.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/i18n/jquery.ui.datepicker-ja.min.js"></script>
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

//		//入力時のkeyupをイベントリスナーとして登録
//		$(".stamp-action").each(function(){
//			$(this).bind('keyup', makePostSentence(this));
//		});
//		$(".stamp-place").each(function(){
//			$(this).bind('keyup', makePostSentence(this));
//		});
	});

	//Topページ、イベント詳細表示
	function showEventDetail(id){
		alert("showEventDetail id=["+id+"] called");
		document.getElementById('EventId').value = id;
		document.getElementById('showSocialEventForm').submit();
	}

	//詳細ページ、投稿の表示制御
//	function makePostSentence(element){
//		var v, old = element.value;
//		return function(){
//			if(old != (v=element.value)){
//				old = v;
//				place = $(this).parent().parent().parent().find('.stamp-place').val();
//				action = $(this).parent().parent().parent().find('.stamp-action').val();
//				str = $(this).val();
//				if(place){
//					$(this).parent().parent().parent().find('.stamp-fbpost').text(place + "にて" + action);
//				}else{
//					$(this).parent().parent().parent().find('.stamp-fbpost').text(action);
//				}
//			}
//		}
//	}

	function mdlg(element){
		returnArray = showModalDialog("${contextPath}/event/selectImage");
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
	function showQRCodedlg(stampId,eventId){
		showModalDialog("${contextPath}/event/showQRCode?stampId="+stampId+"&eventId="+eventId);
	}
	</script></body>
</html>
