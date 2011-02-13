<%@ include file="/WEB-INF/includes/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Vessel</title>

<script type="text/javascript">
jQuery(function(){
		// datepicker
        var pickerOpts = {
            dateFormat: "yy-mm-dd"
        };
		
		jQuery('input[name=signon]').datepicker(pickerOpts);
		jQuery('input[name=signoff]').datepicker(pickerOpts);
});
</script>
</head>
<body>

<div class="post">
<div class="post-bgtop">
<div class="post-bgbtm">
<h2 class="title"><a href="#">Edit Assignment</a></h2>
<div class="entry">

<form:form modelAttribute="assignment" method="post">

<input type="hidden" name="sailor" value="${assignment.sailor.id}">

<table>
	
	<tr>
  	<td colspan="3"><form:errors path="sailor" /></td>
  </tr>
	<tr>
  	<td colspan="3"><b>Personal Information</b></td>
  </tr>
  <tr>
    <td valign="top" colspan="2">&nbsp;</td>
    <td colspan="2"> <img src="../<c:out value="${assignment.sailor.photo}" />" height="100px"></td>
  </tr>
  <tr>
    <td>Name</td>
    <td colspan="2"><c:out value="${assignment.sailor.name}" /></td>
  </tr>
  <tr>
    <td>Birthplace</td>
    <td colspan="2"><c:out value="${assignment.sailor.birthplace}" /></td>
  </tr>
  <tr>
    <td>Birthdate</td>
    <td colspan="2"><fmt:formatDate value="${assignment.sailor.birthdate}"  type="date" dateStyle="medium" /></td>
  </tr>
  <tr>
    <td>Phone</td>
    <td colspan="2"><c:out value="${assignment.sailor.phone}" /></td>
  </tr>

  <tr>
    <td><form:label	for="vessel" path="vessel" cssErrorClass="error">Vessel</form:label></td>
    <td>
    	<form:select path="vessel">
    		<form:options items="${vesselList}" itemValue="id" itemLabel="name" />
    	</form:select>
    </td>
    <td><form:errors path="vessel" /></td>
  </tr>
  <tr>
    <td><form:label	for="assignmentGt" path="assignmentGt" cssErrorClass="error">GT</form:label></td>
    <td><form:input path="assignmentGt" /></td>
    <td><form:errors path="assignmentGt" /></td>
  </tr>
  <tr>
    <td><form:label	for="type" path="type" cssErrorClass="error">Type</form:label></td>
    <td><form:input path="type" /></td>
    <td><form:errors path="type" /></td>
  </tr>
  <tr>
    <td><form:label	for="flag" path="flag" cssErrorClass="error">Flag</form:label></td>
    <td><form:input path="flag" /></td>
    <td><form:errors path="flag" /></td>
  </tr>
  <tr>
    <td><form:label	for="rank" path="rank" cssErrorClass="error">Rank</form:label></td>
    <td><form:input path="rank" /></td>
    <td><form:errors path="rank" /></td>
  </tr>
  <tr>
    <td><form:label	for="fishingArea" path="fishingArea" cssErrorClass="error">Fishing Area</form:label></td>
    <td><form:input path="fishingArea" /></td>
    <td><form:errors path="fishingArea" /></td>
  </tr>
  <tr>
    <td><form:label	for="signon" path="signon" cssErrorClass="error">Sign On Date</form:label></td>
    <td><form:input path="signon" /></td>
    <td><form:errors path="signon" /></td>
  </tr>
  <tr>
    <td><form:label	for="signoff" path="signoff" cssErrorClass="error">Sign Off Date</form:label></td>
    <td><form:input path="signoff" /></td>
    <td><form:errors path="signoff" /></td>
  </tr>
  <tr>
    <td><form:label	for="term" path="term" cssErrorClass="error">Term</form:label></td>
    <td><form:input path="term" /></td>
    <td><form:errors path="term" /></td>
  </tr>
  <tr>
    <td><form:label	for="salary" path="salary" cssErrorClass="error">Salary</form:label></td>
    <td><form:input path="salary" /></td>
    <td><form:errors path="salary" /></td>
  </tr>
  <tr>
    <td><form:label	for="bonus" path="bonus" cssErrorClass="error">Bonus</form:label></td>
    <td><form:input path="bonus" /></td>
    <td><form:errors path="bonus" /></td>
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