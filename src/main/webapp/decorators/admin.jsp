<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>

<!DOCTYPE html>
<html lang="en">
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- Meta, title, CSS, favicons, etc. -->
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title><dec:title default="Admin"></dec:title></title>
	
	<link href="<c:url value='/template/admin/vendors/bootstrap/dist/css/bootstrap.min.css'/>" rel="stylesheet">
	
	<link href="<c:url value='/template/admin/vendors/font-awesome/css/font-awesome.min.css'/>" rel="stylesheet">
	
	<link href="<c:url value='/template/admin/vendors/nprogress/nprogress.css'/>" rel="stylesheet">
	
	<link href="<c:url value='/template/admin/vendors/iCheck/skins/flat/green.css'/>" rel="stylesheet">
	
	<link href="<c:url value='/template/admin/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css' />" rel="stylesheet">
	    
    <link href="<c:url value='/template/admin/vendors/jqvmap/dist/jqvmap.min.css' />" rel="stylesheet"/>
	
	<link href="<c:url value='/template/admin/vendors/bootstrap-daterangepicker/daterangepicker.css'/>" rel="stylesheet">

	<!-- Custom Theme Style -->
	<link href="<c:url value='/template/admin/build/css/custom.min.css'/>" rel="stylesheet">
	
	<!-- Data table -->
	<link href="<c:url value='/template/admin/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css'/>" rel="stylesheet">
<link href="<c:url value='/template/admin/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css'/>" rel="stylesheet">
<link href="<c:url value='/template/admin/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css'/>" rel="stylesheet">
<link href="<c:url value='/template/admin/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css' />" rel="stylesheet">
<link href="<c:url value='/template/admin/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css' />" rel="stylesheet">

	<!-- jQuery -->
	<script src="<c:url value='/template/admin/vendors/jquery/dist/jquery.min.js' />"></script>
	
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			
			<!-- sidebar -->
			<%@include file="/common/admin/sidebar.jsp" %>
			<!-- /sidebar -->
			
			<!-- top navigation -->
			<%@include file="/common/admin/header.jsp" %>
			<!-- /top navigation -->

			<!-- page content -->
			<div class="right_col" role="main">
				<dec:body></dec:body>
			</div>
			<!-- /page content -->

			<!-- footer content -->
			<%@include file="/common/admin/footer.jsp" %>
			<!-- /footer content -->
		</div>
	</div>

	
	<!-- Bootstrap -->
	<script src="<c:url value='/template/admin/vendors/bootstrap/dist/js/bootstrap.bundle.min.js' />"></script>
	<!-- FastClick -->
	<script src="<c:url value='/template/admin/vendors/fastclick/lib/fastclick.js' />"></script>
	<!-- NProgress -->
	<script src="<c:url value='/template/admin/vendors/nprogress/nprogress.js' />"></script>
	<!-- bootstrap-progressbar -->
	<script src="<c:url value='/template/admin/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js' />"></script>
	<!-- iCheck -->
	<script src="<c:url value='/template/admin/vendors/iCheck/icheck.min.js' />"></script>
	<!-- bootstrap-daterangepicker -->
	<script src="<c:url value='/template/admin/vendors/moment/min/moment.min.js'/>"></script>
	<script src="<c:url value='/template/admin/vendors/bootstrap-daterangepicker/daterangepicker.js'/>"></script>
	<!-- bootstrap-wysiwyg -->
	<script src="<c:url value='/template/admin/vendors/bootstrap-wysiwyg/js/bootstrap-wysiwyg.min.js'/>"></script>
	<script src="<c:url value='/template/admin/vendors/jquery.hotkeys/jquery.hotkeys.js'/>"></script>
	<script src="<c:url value='/template/admin/vendors/google-code-prettify/src/prettify.js' />"></script>
	<!-- jQuery Tags Input -->
	<script src="<c:url value='/template/admin/vendors/jquery.tagsinput/src/jquery.tagsinput.js'/>"></script>
	<!-- Switchery -->
	<script src="<c:url value='/template/admin/vendors/switchery/dist/switchery.min.js'/>"></script>
	<!-- Select2 -->
	<script src="<c:url value='/template/admin/vendors/select2/dist/js/select2.full.min.js' />"></script>
	<!-- Parsley -->
	<script src="<c:url value='/template/admin/vendors/parsleyjs/dist/parsley.min.js' />"></script>
	<!-- Autosize -->
	<script src="<c:url value='/template/admin/vendors/autosize/dist/autosize.min.js' />"></script>
	<!-- jQuery autocomplete -->
	<script src="<c:url value='/template/admin/vendors/devbridge-autocomplete/dist/jquery.autocomplete.min.js' />"></script>
	<!-- starrr -->
	<script src="<c:url value='/template/admin/vendors/starrr/dist/starrr.js' />"></script>
	<!-- Custom Theme Scripts -->
	<script src="<c:url value='/template/admin/build/js/custom.min.js' />"></script>
	
	<script src="<c:url value='/template/admin/vendors/datatables.net/js/jquery.dataTables.min.js'/>"></script>
    <script src="<c:url value='/template/admin/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js'/>"></script>
    <script src="<c:url value='/template/admin/vendors/datatables.net-buttons/js/dataTables.buttons.min.js'/>"></script>
    <script src="<c:url value='/template/admin/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js'/>"></script>
    <script src="<c:url value='/template/admin/vendors/datatables.net-buttons/js/buttons.flash.min.js'/>"></script>
    <script src="<c:url value='/template/admin/vendors/datatables.net-buttons/js/buttons.html5.min.js'/>"></script>
    <script src="<c:url value='/template/admin/vendors/datatables.net-buttons/js/buttons.print.min.js'/>"></script>
    <script src="<c:url value='/template/admin/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js'/>"></script>
    <script src="<c:url value='/template/admin/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js'/>"></script>
    <script src="<c:url value='/template/admin/vendors/datatables.net-responsive/js/dataTables.responsive.min.js'/>"></script>
    <script src="<c:url value='/template/admin/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js'/>"></script>
    <script src="<c:url value='/template/admin/vendors/datatables.net-scroller/js/dataTables.scroller.min.js'/>"></script>
    <script src="<c:url value='/template/admin/vendors/jszip/dist/jszip.min.js' />"></script>
    <script src="<c:url value='/template/admin/vendors/pdfmake/build/pdfmake.min.js' />"></script>
    <script src="<c:url value='/template/admin/vendors/pdfmake/build/vfs_fonts.js' />"></script>
    
    <script src="<c:url value='/template/admin/customJS/building-list.js'/>"></script>
    
    <script src="<c:url value='/template/admin/customJS/create-building.js' />"/></script>
    <script src="<c:url value='/template/admin/customJS/update-building.js' />"/></script>
</body></html>
