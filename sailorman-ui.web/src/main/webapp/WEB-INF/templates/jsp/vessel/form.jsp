<%@ include file="/WEB-INF/includes/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Vessel</title>
</head>
<body>

<div class="post">
<div class="post-bgtop">
<div class="post-bgbtm">
<h2 class="title"><a href="#">Edit Vessel</a></h2>
<div class="entry">

<form:form modelAttribute="vessel" method="post">
<table>
  <tr>
    <td><form:label	for="code" path="code" cssErrorClass="error">Code</form:label></td>
    <td><form:input path="code" /></td>
    <td><form:errors path="code" /></td>
  </tr>
  <tr>
    <td><form:label	for="name" path="name" cssErrorClass="error">Name</form:label></td>
    <td><form:input path="name" /></td>
    <td><form:errors path="name" /></td>
  </tr>
  <tr>
    <td><form:label	for="country" path="country" cssErrorClass="error">Country</form:label></td>
    <td>
    	<form:select path="country">
    		<form:options items="${countryList}" itemValue="id" itemLabel="name" />
    	</form:select>
    </td>
    <td><form:errors path="country" /></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td><input type="submit" /></td>
    <td>&nbsp;</td>
  </tr>
</table>

</form:form>

</div>

</div>
</div>
</div>

</body>
</html>