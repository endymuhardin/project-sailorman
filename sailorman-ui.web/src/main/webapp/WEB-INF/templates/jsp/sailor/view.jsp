<%@ include file="/WEB-INF/includes/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Info</title>
</head>
<body>

<div class="post">
<div class="post-bgtop">
<div class="post-bgbtm">

<h2 class="title"><a href="#">Employee Information</a></h2>
<div class="entry">

<table width="100%">
	<tr>
  	<td colspan="3"><b>Personal Information</b></td>
  </tr>
  <tr>
    <td valign="top" colspan="2">&nbsp;</td>
    <td> <img src="../<c:out value="${sailor.photo}" />" height="100px"></td>
  </tr>
  <tr>
    <td>Name</td>
    <td>:</td>
    <td><c:out value="${sailor.name}" /></td>
  </tr>
  <tr>
    <td>Birthplace</td>
    <td>:</td>
    <td><c:out value="${sailor.birthplace}" /></td>
  </tr>
  <tr>
    <td>Birthdate</td>
    <td>:</td>
    <td><fmt:formatDate value="${sailor.birthdate}"  type="date" dateStyle="medium" /></td>
  </tr>
  <tr>
    <td>Phone</td>
    <td>:</td>
    <td><c:out value="${sailor.phone}" /></td>
  </tr>
  <tr>
    <td>Children</td>
    <td>:</td>
    <td><c:out value="${sailor.children}" /></td>
  </tr>
  <tr>
    <td>Religion</td>
    <td>:</td>
    <td><c:out value="${sailor.religion}" /></td>
  </tr>
  <tr>
  	<td colspan="3"><b>Passport Information</b></td>
  </tr>
  <tr>
    <td>Passport Number</td>
    <td>:</td>
    <td><c:out value="${sailor.passportNumber}" /></td>
  </tr>
  <tr>
    <td>Passport Issue Place</td>
    <td>:</td>
    <td><c:out value="${sailor.passportIssuePlace}" /></td>
  </tr>
  <tr>
    <td>Passport Issue Date</td>
    <td>:</td>
    <td><fmt:formatDate value="${sailor.passportIssueDate}" type="date" dateStyle="medium" /></td>
  </tr>
  <tr>
    <td>Passport Expire Date</td>
    <td>:</td>
    <td><fmt:formatDate value="${sailor.passportExpireDate}" type="date" dateStyle="medium" /></td>
  </tr>
  
  <tr>
  	<td colspan="3"><b>Seaman Book Information</b></td>
  </tr>
  <tr>
    <td>Seaman Book Number</td>
    <td>:</td>
    <td><c:out value="${sailor.seamanBookNumber}" /></td>
  </tr>
  <tr>
    <td>Seaman Book Issue Place</td>
    <td>:</td>
    <td><c:out value="${sailor.seamanBookIssuePlace}" /></td>
  </tr>
  <tr>
    <td>Seaman Book Issue Date</td>
    <td>:</td>
    <td><fmt:formatDate value="${sailor.seamanBookIssueDate}" type="date" dateStyle="medium"/></td>
  </tr>
  <tr>
    <td>Seaman Book Expire Date</td>
    <td>:</td>
    <td><fmt:formatDate value="${sailor.seamanBookExpireDate}" type="date" dateStyle="medium"/></td>
  </tr>
  
  <tr>
  	<td colspan="3"><b>License Information</b></td>
  </tr>
  <tr>
    <td>License Number</td>
    <td>:</td>
    <td><c:out value="${sailor.licenseNumber}" /></td>
  </tr>
  <tr>
    <td>License Issue Place</td>
    <td>:</td>
    <td><c:out value="${sailor.licenseIssuePlace}" /></td>
  </tr>
  <tr>
    <td>License Issue Date</td>
    <td>:</td>
    <td><fmt:formatDate value="${sailor.licenseIssueDate}" type="date" dateStyle="medium"/></td>
  </tr>
  <tr>
    <td>License Expire Date</td>
    <td>:</td>
    <td><fmt:formatDate value="${sailor.licenseExpireDate}" type="date" dateStyle="medium"/></td>
  </tr>
  
  
  <tr>
  	<td colspan="3"><b>Physical Information</b></td>
  </tr>
  
  <tr>
    <td>Height</td>
    <td>:</td>
    <td><c:out value="${sailor.height}" /></td>
  </tr>
  <tr>
    <td>Weight</td>
    <td>:</td>
    <td><c:out value="${sailor.weight}" /></td>
  </tr>
  <tr>
    <td>Cloth</td>
    <td>:</td>
    <td><c:out value="${sailor.cloth}" /></td>
  </tr>
  <tr>
    <td>Glove</td>
    <td>:</td>
    <td><c:out value="${sailor.glove}" /></td>
  </tr>
  <tr>
    <td>Shoe</td>
    <td>:</td>
    <td><c:out value="${sailor.shoe}" /></td>
  </tr>
  <tr>
    <td>Smoking</td>
    <td>:</td>
    <td><c:out value="${sailor.smoking}" /></td>
  </tr>
</table>

</div>

<h2 class="title"><a href="#">Assignment</a></h2>

<a href="<c:url value="../assignment/form"><c:param name="sailor" value="${sailor.id}"/></c:url>">
					Add Assignment
				</a>

<div class="entry">

	<c:forEach var="assignment" items="${assignmentList}">
<table width="100%">
	<tr>
    <td>GT</td>
    <td><c:out value="${assignment.assignmentGt}" /></td>
  </tr>
  <tr>
    <td>Type</td>
    <td><c:out value="${assignment.type}" /></td>
  </tr>
  <tr>
    <td>Flag</td>
    <td><c:out value="${assignment.flag}" /></td>
  </tr>
  <tr>
    <td>Rank</td>
    <td><c:out value="${assignment.rank}" /></td>
  </tr>
  <tr>
    <td>Fishing Area</td>
    <td><c:out value="${assignment.fishingArea}" /></td>
  </tr>
  <tr>
    <td>Sign On Date</td>
    <td><fmt:formatDate value="${assignment.signon}" type="date" dateStyle="medium"/></td>
  </tr>
  <tr>
    <td>Sign Off Date</td>
    <td><fmt:formatDate value="${assignment.signoff}" type="date" dateStyle="medium"/></td>
  </tr>
  <tr>
    <td>Term</td>
    <td><c:out value="${assignment.term}" /></td>
  </tr>
  <tr>
    <td>Salary</td>
    <td><c:out value="${assignment.salary}" /></td>
  </tr>
  <tr>
    <td>Bonus</td>
    <td><c:out value="${assignment.bonus}" /></td>
  </tr>
  <tr>
    <td><a href="<c:url value="../assignment/delete"><c:param name="id" value="${assignment.id}"/></c:url>">
					Delete Assignment
				</a>
		</td>
    <td>&nbsp;</td>
  </tr>
</table>
<br><br>
	</c:forEach>
</div>

</div>
</div>
</div>
</body>
</html>