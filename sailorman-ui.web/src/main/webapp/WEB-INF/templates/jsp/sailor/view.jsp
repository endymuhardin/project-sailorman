<%@ include file="/WEB-INF/includes/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sailor Info</title>
</head>
<body>

<div class="post">
<div class="post-bgtop">
<div class="post-bgbtm">



<h2 class="title"><a href="#">Sailor Information</a></h2>
<div class="entry">

<table>
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
    <td><c:out value="${sailor.birthdate}" /></td>
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
  	<td colspan="3">Passport Information</td>
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
    <td><c:out value="${sailor.passportIssueDate}" /></td>
  </tr>
  <tr>
    <td>Passport Expire Date</td>
    <td>:</td>
    <td><c:out value="${sailor.passportExpireDate}" /></td>
  </tr>
  
  <tr>
  	<td colspan="3">Seaman Book Information</td>
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
    <td><c:out value="${sailor.seamanBookIssueDate}" /></td>
  </tr>
  <tr>
    <td>Seaman Book Expire Date</td>
    <td>:</td>
    <td><c:out value="${sailor.seamanBookExpireDate}" /></td>
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

</div>
</div>
</div>
</body>
</html>