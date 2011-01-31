<%@ include file="/WEB-INF/includes/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Country List</title>
</head>
<body>

<div class="post">
<div class="post-bgtop">
<div class="post-bgbtm">
<h2 class="title"><a href="#">Country List</a></h2>
<div class="entry">

	<a href="form">Add New Country</a>

	<table width="100%">
  <tr>
    <th>Code</th>
    <th>Name</th>
    <th>&nbsp;</th>
  </tr>
  <c:forEach var="country" items="${countryList}">
  <tr>
    <td><c:out value="${country.code}"/></td>
    <td><c:out value="${country.name}"/></td>
    <td>
    	<a href="<c:url value="form"><c:param name="id" value="${country.id}"/></c:url>">
    	edit
		  </a>
    </td>
  </tr>
  </c:forEach>
</table>


</div>

</div>
</div>
</div>

</body>
</html>