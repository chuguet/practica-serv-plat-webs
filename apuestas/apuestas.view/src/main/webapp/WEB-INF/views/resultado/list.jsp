<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div style="padding-top:30px">
		<ul style="color: olive; font-family: cursive;" id="slider"></ul>
		<h1 style="color: olive;" align="center" id="promedio"></h1>
	</div>
<script type="text/javascript">
	function showInformationIntoView(information) {
		resultado.formatList(information);
	};
</script>