<%@ include file="/WEB-INF/includes/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Sailor</title>


<script type="text/javascript">
jQuery(function(){
		// datepicker
        var pickerOpts = {
            dateFormat: "yy-mm-dd"
        };
		
		jQuery('input[name=birthdate]').datepicker(pickerOpts);
		jQuery('input[name=passportIssueDate]').datepicker(pickerOpts);
		jQuery('input[name=passportExpireDate]').datepicker(pickerOpts);
		jQuery('input[name=seamanBookIssueDate]').datepicker(pickerOpts);
		jQuery('input[name=seamanBookExpireDate]').datepicker(pickerOpts);
		jQuery('input[name=licenseIssueDate]').datepicker(pickerOpts);
		jQuery('input[name=licenseExpireDate]').datepicker(pickerOpts);
});
</script>

</head>
<body>

<div class="post">
<div class="post-bgtop">
<div class="post-bgbtm">
<h2 class="title"><a href="#">Edit Sailor</a></h2>
<div class="entry">

<form:form modelAttribute="sailor" method="post" enctype="multipart/form-data">
<table>
  <tr>
    <td><form:label	for="name" path="name" cssErrorClass="error">Name</form:label></td>
    <td><form:input path="name" /></td>
    <td><form:errors path="name" /></td>
  </tr>
  <tr>
    <td><form:label	for="birthplace" path="birthplace" cssErrorClass="error">Birthplace</form:label></td>
    <td><form:input path="birthplace" /></td>
    <td><form:errors path="birthplace" /></td>
  </tr>
  <tr>
    <td><form:label	for="birthdate" path="birthdate" cssErrorClass="error">Birthdate</form:label></td>
    <td><form:input path="birthdate" /></td>
    <td><form:errors path="birthdate" /></td>
  </tr>
    <tr>
    <td><form:label	for="phone" path="phone" cssErrorClass="error">Phone</form:label></td>
    <td><form:input path="phone" /></td>
    <td><form:errors path="phone" /></td>
  </tr>
  <tr>
    <td><form:label	for="children" path="children" cssErrorClass="error">Children</form:label></td>
    <td><form:input path="children" /></td>
    <td><form:errors path="children" /></td>
  </tr>
  <tr>
    <td><form:label	for="religion" path="birthdate" cssErrorClass="error">Religion</form:label></td>
    <td><form:input path="religion" /></td>
    <td><form:errors path="religion" /></td>
  </tr>  
  
  <tr>
  	<td colspan="3">Passport Information</td>
  </tr>
  
  <tr>
    <td><form:label	for="passportNumber" path="birthdate" cssErrorClass="error">Passport Number</form:label></td>
    <td><form:input path="passportNumber" /></td>
    <td><form:errors path="passportNumber" /></td>
  </tr>
  <tr>
    <td><form:label	for="passportIssueDate" path="birthdate" cssErrorClass="error">Passport Issue Date</form:label></td>
    <td><form:input path="passportIssueDate" /></td>
    <td><form:errors path="passportIssueDate" /></td>
  </tr>
  <tr>
    <td><form:label	for="passportExpireDate" path="passportExpireDate" cssErrorClass="error">Passport Expire Date</form:label></td>
    <td><form:input path="passportExpireDate" /></td>
    <td><form:errors path="passportExpireDate" /></td>
  </tr>
  <tr>
    <td><form:label	for="passportIssuePlace" path="passportIssuePlace" cssErrorClass="error">Passport Issue Place</form:label></td>
    <td><form:input path="passportIssuePlace" /></td>
    <td><form:errors path="passportIssuePlace" /></td>
  </tr>
  
  <tr>
  	<td colspan="3">Seaman Book Information</td>
  </tr>
  
  <tr>
    <td><form:label	for="seamanBookNumber" path="seamanBookNumber" cssErrorClass="error">Seaman Book Number</form:label></td>
    <td><form:input path="seamanBookNumber" /></td>
    <td><form:errors path="seamanBookNumber" /></td>
  </tr>
  <tr>
    <td><form:label	for="seamanBookIssueDate" path="seamanBookIssueDate" cssErrorClass="error">Seaman Book Issue Date</form:label></td>
    <td><form:input path="seamanBookIssueDate" /></td>
    <td><form:errors path="seamanBookIssueDate" /></td>
  </tr>
  <tr>
    <td><form:label	for="seamanBookExpireDate" path="seamanBookExpireDate" cssErrorClass="error">Seaman Book Expire Date</form:label></td>
    <td><form:input path="seamanBookExpireDate" /></td>
    <td><form:errors path="seamanBookExpireDate" /></td>
  </tr>
  <tr>
    <td><form:label	for="seamanBookIssuePlace" path="seamanBookIssuePlace" cssErrorClass="error">Seaman Book Issue Place</form:label></td>
    <td><form:input path="seamanBookIssuePlace" /></td>
    <td><form:errors path="seamanBookIssuePlace" /></td>
  </tr>
  
  <tr>
  	<td colspan="3">License Book Information</td>
  </tr>
  
  <tr>
    <td><form:label	for="licenseNumber" path="licenseNumber" cssErrorClass="error">License Number</form:label></td>
    <td><form:input path="licenseNumber" /></td>
    <td><form:errors path="licenseNumber" /></td>
  </tr>
  <tr>
    <td><form:label	for="licenseIssueDate" path="licenseIssueDate" cssErrorClass="error">License Issue Date</form:label></td>
    <td><form:input path="licenseIssueDate" /></td>
    <td><form:errors path="licenseIssueDate" /></td>
  </tr>
  <tr>
    <td><form:label	for="licenseExpireDate" path="licenseExpireDate" cssErrorClass="error">License Expire Date</form:label></td>
    <td><form:input path="licenseExpireDate" /></td>
    <td><form:errors path="licenseExpireDate" /></td>
  </tr>
  <tr>
    <td><form:label	for="licenseIssuePlace" path="licenseIssuePlace" cssErrorClass="error">License Issue Place</form:label></td>
    <td><form:input path="licenseIssuePlace" /></td>
    <td><form:errors path="licenseIssuePlace" /></td>
  </tr>
  
  <tr>
  	<td colspan="3">Physical Information</td>
  </tr>
  
  <tr>
    <td><form:label	for="height" path="height" cssErrorClass="error">Height</form:label></td>
    <td><form:input path="height" /></td>
    <td><form:errors path="height" /></td>
  </tr>
  <tr>
    <td><form:label	for="weight" path="weight" cssErrorClass="error">Weight</form:label></td>
    <td><form:input path="weight" /></td>
    <td><form:errors path="weight" /></td>
  </tr>
  <tr>
    <td><form:label	for="cloth" path="cloth" cssErrorClass="error">Cloth</form:label></td>
    <td><form:input path="cloth" /></td>
    <td><form:errors path="cloth" /></td>
  </tr>
  <tr>
    <td><form:label	for="glove" path="glove" cssErrorClass="error">Glove</form:label></td>
    <td><form:input path="glove" /></td>
    <td><form:errors path="glove" /></td>
  </tr>
  <tr>
    <td><form:label	for="shoe" path="shoe" cssErrorClass="error">Shoe</form:label></td>
    <td><form:input path="shoe" /></td>
    <td><form:errors path="shoe" /></td>
  </tr>
  <tr>
    <td><form:label	for="smoking" path="smoking" cssErrorClass="error">Smoking</form:label></td>
    <td><form:checkbox path="smoking" /></td>
    <td><form:errors path="smoking" /></td>
  </tr>
  <tr>
    <td>Photo</td>
    <td><input type="file" name="photofile"></td>
    <td>&nbsp;</td>
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