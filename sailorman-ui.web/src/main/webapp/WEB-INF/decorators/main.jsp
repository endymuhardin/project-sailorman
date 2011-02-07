<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by Free CSS Templates
http://www.freecsstemplates.org
Released for free under a Creative Commons Attribution 2.5 License

Name       : Communication
Description: A two-column, fixed-width design with dark color scheme.
Version    : 1.0
Released   : 20090523

-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title><decorator:title></decorator:title></title>
<link href="<%=request.getContextPath()%>/resources/css/style.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.4.4.min.js"></script>
        
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-ui-1.8.9.custom.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/ui-lightness/jquery-ui-1.8.9.custom.css" type="text/css" />


<decorator:head></decorator:head>

</head>
<body>
<div id="wrapper">
	<div id="header">
		<div id="logo">
			<h1><a href="#">Sailor Database</a></h1>
			<p>Application for managing sailors</p>
		</div>
	</div>
	<!-- end #header -->
	<div id="menu">
		<ul>
			<li class="current_page_item"><a href="#">Home</a></li>
			<li><a href="#">Logout</a></li>
		</ul>
	</div>
	<!-- end #menu -->
	<div id="page">
	<div id="page-bgtop">
	<div id="page-bgbtm">
		<div id="content">
			<decorator:body></decorator:body>
		<div style="clear: both;">&nbsp;</div>
		</div>
		<!-- end #content -->
		<div id="sidebar">
			<ul>
				<li>
					<h2>Menu</h2>
					<ul>
						<li><a href="<%=request.getContextPath()%>/country/list">Country</a><span>Manage Country List</span></li>
						<li><a href="<%=request.getContextPath()%>/vessel/list">Vessel</a><span>Manage Vessel List</span></li>
						<li><a href="<%=request.getContextPath()%>/sailor/list">Sailor</a><span>Manage Sailor List</span></li>
					</ul>
				</li>
			</ul>
		</div>
		<!-- end #sidebar -->
		<div style="clear: both;">&nbsp;</div>
	</div>
	</div>
	</div>
	<!-- end #page -->
</div>
	<div id="footer">
		<p>Copyright (c) 2008 Sitename.com. All rights reserved. Design by <a href="http://www.freecsstemplates.org/">Free CSS Templates</a>.</p>
	</div>
	<!-- end #footer -->
</body>
</html>