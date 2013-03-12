<!DOCTYPE html>
<html lang="ja">
<jsp:include page="/common/htmlheader.jsp"></jsp:include>
<body>
<form>
<select class="image-picker" name="selectImage">
<c:forEach var="memberFile" items="${action.memberFileList}" varStatus="status">
	<option value="${f:out(memberFile.fileId)}" data-img-src="${f:out(memberFile.imageUrl)}"/>
</c:forEach>
</select>
<input type="button" value="選択" onClick="toMainWin(this.form.selectImage.value)">

</form>
<br>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.17/jquery-ui.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/image-picker.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("select").imagepicker();
});

function toMainWin(str){
	returnValue=str;
	close();
}
</script>
</body>
</html>
