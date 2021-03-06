<%@page import="com.internousdev.ecsite.action.AdminLoginAction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>ユーザー管理画面</title>


<style type="text/css">
body {
	margin: 0;
	padding: 0;
	line-height: 1.6;
	letter-spacing: 1px;
	font-family: Verdana, Helvetica, sans-serif;
	font-size: 12px;
	color: #333;
	background: #fff;
}

table {
	text-align: center;
	margin: 0 auto;
}

/* ======== ID LAYOUT ======== */
#top {
	width: 780px;
	margin: 30px auto;
	border: 1px solid #333;
}

#header {
	width: 100%;
	height: 80px;
	background-color: black;
}

#main {
	width: 100%;
	height: 500px;
	text-align: center;
}

#footer {
	width: 100%;
	height: 80px;
	background-color: black;
	clear: both;
}

#text-right {
	display: inline-block;
	text-align: right;
}
</style>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
	function submitAction(url) {
		$('form').attr('action', url);
		$('form').submit();
	}
</script>
</head>
<body>
	<div id="header">
		<div id="pr"></div>
	</div>
	<div id="main">
		<div id="top">
			<p>ユーザー管理画面</p>
		</div>
		<s:if test="userExist == false">
			<h3>ユーザー登録はありません。</h3>
		</s:if>
		<s:elseif test="userExist == true">
			<h3>以下のアカウントに対しての操作を選択してください。</h3>
			<table border="1">
				<tr>
					<th>ユーザー番号</th>
					<th>ユーザーID</th>
					<th>ユーザーパスワード</th>
					<th>ユーザー名</th>
					<th>登録日</th>
				</tr>
				<s:iterator value="userList">
					<tr>
						<td><s:property value="userNum" escape="false" /></td>
						<td><s:property value="userId" escape="false" /></td>
						<td><s:property value="userPass" escape="false" /></td>
						<td><s:property value="userName" escape="false" /></td>
						<td><s:property value="userDate" escape="false" /></td>
					</tr>
				</s:iterator>
			</table>
			<form id="adminSelect">
				<table>
					<tr>
						<td><input type="button" value="ユーザーアカウント削除"
							onclick="submitAction('DeleteUserAction')" /></td>
					</tr>
				</table>
			</form>
		</s:elseif>
		<div id="text-right">
			<p>
				<a href='<s:url action="GoAdminHomeAction"/>'>管理者Home</a>
			<p>
				<a href='<s:url action="GoHomeAction"/>'>ECサイトHome</a>
		</div>
	</div>
	<div id="footer">
		<div id="pr"></div>
	</div>
</body>
</html>