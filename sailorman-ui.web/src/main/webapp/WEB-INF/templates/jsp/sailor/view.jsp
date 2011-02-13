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

<form action="export" method="post">
<input type="hidden" name="id" value="${sailor.id}">

Export to 
<input type="radio" name="format" value="pdf" checked="checked">PDF 
<input type="submit" value="Download"> 

</form>

<img src="../<c:out value="${sailor.photo}" />" height="100px">

<table width="100%" border="1">
	<thead>
		<tr>
			<th>Name</th>
			<th>Date of Birth</th>
			<th>Birth Place</th>
			<th>Phone Number</th>
			<th>Anak</th>
			<th>Religion</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>${sailor.name}</td>
			<td><fmt:formatDate value="${sailor.birthdate}"  type="date" dateStyle="medium" /></td>
			<td>${sailor.birthplace}</td>
			<td>${sailor.phone}</td>
			<td>${sailor.children}</td>
			<td>${sailor.religion}</td>
		</tr>
	</tbody>
</table>

<br>



<table width="100%" border="1">
	<thead>
		<tr>
			<th>Passport</th>
			<th>Seaman Book</th>
			<th>&nbsp;</th>
			<th>Lysence</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>
				<table>
					<tr>
						<td>Number</td>
						<td>${sailor.passportNumber}</td>
					</tr>
					<tr>
						<td>Issue Date</td>
						<td><fmt:formatDate value="${sailor.passportIssueDate}"  type="date" dateStyle="medium" /></td>
					</tr>
					<tr>
						<td>Valid Until</td>
						<td><fmt:formatDate value="${sailor.passportExpireDate}"  type="date" dateStyle="medium" /></td>
					</tr>
					<tr>
						<td>Issue Place</td>
						<td>${sailor.passportIssuePlace}</td>
					</tr>
				</table>
			</td>
			<td>
				<table>
					<tr>
						<td>Number</td>
						<td>${sailor.seamanBookNumber}</td>
					</tr>
					<tr>
						<td>Issue Date</td>
						<td><fmt:formatDate value="${sailor.seamanBookIssueDate}"  type="date" dateStyle="medium" /></td>
					</tr>
					<tr>
						<td>Valid Until</td>
						<td><fmt:formatDate value="${sailor.seamanBookExpireDate}"  type="date" dateStyle="medium" /></td>
					</tr>
					<tr>
						<td>Issue Place</td>
						<td>${sailor.seamanBookIssuePlace}</td>
					</tr>
				</table>
			</td>
			<td>
				<table>
					<tr>
						<td>Number</td>
						<td>${sailor.licenseNumber}</td>
					</tr>
					<tr>
						<td>Issue Date</td>
						<td><fmt:formatDate value="${sailor.licenseIssueDate}"  type="date" dateStyle="medium" /></td>
					</tr>
					<tr>
						<td>Valid Until</td>
						<td><fmt:formatDate value="${sailor.licenseExpireDate}"  type="date" dateStyle="medium" /></td>
					</tr>
					<tr>
						<td>Issue Place</td>
						<td>${sailor.licenseIssuePlace}</td>
					</tr>
				</table>
			</td>
			<td>&nbsp;</td>
		</tr>
	</tbody>
</table>


<br>
<a href="<c:url value="../assignment/add"><c:param name="sailor" value="${sailor.id}"/></c:url>">
					Add Assignment
				</a>

<br>
<c:if test="${not empty assignmentList}">
<table width="100%" border="1">
	<thead>
		<tr>
			<th>Vessel Name</th>
			<th>GT</th>
			<th>Type</th>
			<th>Flag</th>
			<th>Rank</th>
			<th>Fishing Area</th>
			<th>Sign-on Date</th>
			<th>Sign-off Date</th>
			<th>Term</th>
			<th>Salary</th>
			<th>Bonus</th>
			<th>&nbsp;</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="assignment" items="${assignmentList}">
		<tr>
			<td>${assignment.vessel.code} - ${assignment.vessel.name}</td>
			<td>${assignment.assignmentGt}</td>
			<td>${assignment.type}</td>
			<td>${assignment.flag}</td>
			<td>${assignment.rank}</td>
			<td>${assignment.fishingArea}</td>
			<td><fmt:formatDate value="${assignment.signon}"  type="date" dateStyle="medium" /></td>
			<td><fmt:formatDate value="${assignment.signoff}"  type="date" dateStyle="medium" /></td>
			<td>${assignment.term}</td>
			<td>${assignment.salary}</td>
			<td>${assignment.bonus}</td>
			<td>
				<a href="<c:url value="../assignment/edit"><c:param name="id" value="${assignment.id}"/></c:url>">
					edit
				</a> | 
				<a href="<c:url value="../assignment/delete"><c:param name="id" value="${assignment.id}"/></c:url>">
					delete
				</a>
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</c:if>

<br>
<br>

<table width="100%" border="1">
	<thead>
		<tr>
			<th>Height</th>
			<th>Weight</th>
			<th>Cloth</th>
			<th>Glove</th>
			<th>Shoe Size</th>
			<th>Smoking</th>
			<th>New Salary</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>${sailor.height}</td>
			<td>${sailor.weight}</td>
			<td>${sailor.cloth}</td>
			<td>${sailor.glove}</td>
			<td>${sailor.shoe}</td>
			<td>${sailor.smoking ? 'Yes' : 'No'}</td>
			<td>${sailor.newSalary}</td>
		</tr>
	</tbody>
</table>


</div>


</div>
</div>
</div>
</body>
</html>