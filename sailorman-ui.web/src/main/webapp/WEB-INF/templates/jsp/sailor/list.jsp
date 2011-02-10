<%@ include file="/WEB-INF/includes/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee List</title>
</head>
<body>

<div class="post">
<div class="post-bgtop">
<div class="post-bgbtm">
<h2 class="title"><a href="#">Employee List</a></h2>
<div class="entry"><a href="form">Add New Employee</a><br>

 
<form action="">Search by name : 
<input name="name">
<input type="submit" />
</form>


<table width="100%">
	<tr>
		<th>Name</th>
		<th>Birth</th>
		<th>Phone</th>
		<th>&nbsp;</th>
	</tr>
	<c:forEach var="sailor" items="${sailorList.pageList}">
		<tr>
			<td><c:out value="${sailor.name}" /></td>
			<td><c:out value="${sailor.birthplace}" /> - <c:out value="${sailor.birthdate}" /></td>
			<td><c:out value="${sailor.phone}" /></td>
			<td>
				<a href="<c:url value="../assignment/form"><c:param name="sailor" value="${sailor.id}"/></c:url>">
					assignment
				</a> | 
				<a href="<c:url value="view"><c:param name="id" value="${sailor.id}"/></c:url>">
					view
				</a> | 
				<a href="<c:url value="form"><c:param name="id" value="${sailor.id}"/></c:url>">
					edit
				</a> | 
				<a href="<c:url value="delete"><c:param name="id" value="${sailor.id}"/></c:url>">
					delete
				</a> 
			</td>
		</tr>
	</c:forEach>
	
	<tr>
	  <td colspan="4">
	  <c:if test="${!sailorList.firstPage}">
	    <a href="?page=previous"><font color="white"><B>&lt;&lt; Prev</B></font></a>
	  </c:if>
	  <c:if test="${!sailorList.lastPage}">
	    <a href="?page=next"><font color="white"><B>Next &gt;&gt;</B></font></a>
	  </c:if>
	  </td>
  	</tr>
	
</table>


</div>

</div>
</div>
</div>

</body>
</html>