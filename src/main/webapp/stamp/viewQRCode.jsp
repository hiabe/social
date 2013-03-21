<!DOCTYPE html>
<html lang="ja">
<jsp:include page="/common/htmlheader.jsp"></jsp:include>
<body>
<img src="${contextPath}${f:out(action.stampDto.imageUrl)}"/>
<br />
<input type="button" value="閉じる" onClick="window.close()">
<br>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.17/jquery-ui.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/bootstrap.min.js"></script>
</body>
</html>
