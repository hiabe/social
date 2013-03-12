<!DOCTYPE html>
<html lang="ja">
<jsp:include page="/common/htmlheader.jsp"></jsp:include>
<body>
<img src="${f:out(action.stampDto.imageUrl)}"/>

<input type="button" value="閉じる" onClick="window.close()">

<br>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.17/jquery-ui.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/bootstrap.min.js"></script>
</body>
</html>
