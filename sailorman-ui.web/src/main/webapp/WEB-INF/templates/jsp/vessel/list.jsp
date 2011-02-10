<%@ include file="/WEB-INF/includes/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vessel List</title>
</head>
<body>

<div class="post">
<div class="post-bgtop">
<div class="post-bgbtm">
<h2 class="title"><a href="#">Vessel List</a></h2>
<div class="entry"><a href="form">Add New Vessel</a><br>

 
<form action="">Select country : 
<select name="country">
	<c:forEach var="country" items="${countryList}">
	<option value="<c:out value="${country.id}" />"><c:out value="${country.name}" /></option>
	</c:forEach>
</select>
<input type="submit" />
</form>

<c:if test="${not empty vesselList}">
<table width="100%">
	<tr>
		<th>Code</th>
		<th>Name</th>
		<th>Country</th>
		<th>&nbsp;</th>
	</tr>
	<c:forEach var="vessel" items="${vesselList}">
		<tr>
			<td><c:out value="${vessel.code}" /></td>
			<td><c:out value="${vessel.name}" /></td>
			<td><c:out value="${vessel.country.code}" /> - <c:out
				value="${vessel.country.name}" /></td>
			<td><a
				href="<c:url value="form"><c:param name="id" value="${vessel.id}"/></c:url>">
			edit </a></td>
		</tr>
	</c:forEach>
</table>
</c:if>

</div>

</div>
</div>
</div>

</body>
</html>