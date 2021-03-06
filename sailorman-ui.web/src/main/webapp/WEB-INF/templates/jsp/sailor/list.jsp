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

<c:if test="${not empty sailorList}">
<table width="100%">
	<tr>
		<th>Name</th>
		<th>Birthplace</th>
		<th>Birthdate</th>
		<th>Phone</th>
		<th>Passport</th>
		<th>Valid Until</th>
		<th>Photo</th>
		<th>&nbsp;</th>
	</tr>
	<c:forEach var="sailor" items="${sailorList.pageList}">
		<tr>
			<td><c:out value="${sailor.name}" /></td>
			<td><c:out value="${sailor.birthplace}" /></td>
			<td><fmt:formatDate value="${sailor.birthdate}"  type="date" dateStyle="medium" /></td>
			<td><c:out value="${sailor.phone}" /></td>
			<td><c:out value="${sailor.passportNumber}" /></td>
			<td><fmt:formatDate value="${sailor.passportExpireDate}"  type="date" dateStyle="medium" /></td>
			<td><img src="../<c:out value="${sailor.photo}" />" height="50px"></td>
			<td>
				<a href="<c:url value="view"><c:param name="id" value="${sailor.id}"/></c:url>">
					view
				</a> | 
				<a href="<c:url value="form"><c:param name="id" value="${sailor.id}"/></c:url>">
					edit
				</a> | 
				<a href="<c:url value="delete"><c:param name="id" value="${sailor.id}"/></c:url>">
					delete
				</a>  
				<c:choose>
					<c:when test="${'NEW' == sailor.employmentStatus}">
					| <a href="<c:url value="select"><c:param name="id" value="${sailor.id}"/></c:url>">
						select
					</a> 
					</c:when>
					<c:when test="${'SELECTED' == sailor.employmentStatus}">
					| <a href="<c:url value="approve"><c:param name="id" value="${sailor.id}"/></c:url>">
						approve
					</a> 
					</c:when>
					<c:when test="${'APPROVED' == sailor.employmentStatus}">
					| <a href="<c:url value="print"><c:param name="id" value="${sailor.id}"/></c:url>">
						print
					</a> 
					</c:when>
				</c:choose>
			</td>
		</tr>
	</c:forEach>
	
	<tr>
	  <td colspan="4">
	  <c:if test="${!sailorList.firstPage}">
	    <a href="?page=previous"><B>&lt;&lt; Prev</B></a>
	  </c:if>
	  <c:if test="${!sailorList.lastPage}">
	    <a href="?page=next"><B>Next &gt;&gt;</B></a>
	  </c:if>
	  </td>
  	</tr>
</table>
</c:if>

</div>

</div>
</div>
</div>

</body>
</html>