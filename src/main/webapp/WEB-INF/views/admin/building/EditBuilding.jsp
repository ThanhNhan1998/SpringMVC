<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Building</title>
</head>
<body>

	<c:if test="${message != null}">
		<script>
			alert('${message}');
		</script>
	</c:if>


	<div class="row">
		<div class="col-md-12 col-sm-12">
			<div class="x_panel">
				<div class="x_title">
					
					<c:if test="${isEdit == true }">
						<h2>Cập nhập thông tin tòa nhà</h2>
					</c:if>
					
					<c:if test="${isEdit == false }">
						<h2>Thêm tòa nhà</h2>
					</c:if>
					
					<ul class="nav navbar-right panel_toolbox">
						<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
					</ul>
					<div class="clearfix"></div>
				</div>

				<div class="x_content">
					<div class="row">
						<div class="col-sm-12">
							<form id="form_edit" data-parsley-validate
								class="form-horizontal form-label-left">
								
								<c:if test="${isEdit == true }">
									<input type="text" name="id" value="${model.id }" hidden />
								</c:if>

								<div class="item form-group">
									<label class="col-form-label col-md-3 col-sm-3 label-align"
										for="first-name">Tên tòa nhà <span class="required">*</span>
									</label>
									<div class="col-md-6 col-sm-6 ">
										<input type="text" id="name" name="name" required="required"
											class="form-control " value="${model.name}">
									</div>
								</div>
								<div class="item form-group">
									<label class="col-form-label col-md-3 col-sm-3 label-align"
										for="last-name">Số tầng hầm <span class="required">*</span>
									</label>
									<div class="col-md-6 col-sm-6 ">
										<input type="number" id="numberOfBasement"
											name="numberOfBasement" required="required"
											class="form-control" value="${model.numberOfBasement }">
									</div>
								</div>

								<div class="item form-group">
									<label class="col-form-label col-md-3 col-sm-3 label-align"
										for="last-name">Loại tòa nhà <span class="required">*</span>
									</label>
									<div class="col-md-6 col-sm-6 ">
										<p style="padding: 5px;">

											<c:forEach var="type" items="${buildingTypes }">

												<input type="checkbox" name="buildingTypes"
													id="buildingTypes" value="${type.key }" class="flat"
													${fn:contains(model.type, type.value) ? 'checked' : '' } /> 
													${type.value }
	                          	
	                          				</c:forEach>
										<p>
									</div>
								</div>

								<div class="item form-group">
									<label class="col-form-label col-md-3 col-sm-3 label-align"
										for="last-name">Diện tích thuê <span class="required">*</span>
									</label>
									<div class="col-md-6 col-sm-6 ">
										<input type="text" id="areaRent" name="areaRent"
											required="required" class="form-control"
											value="${model.rentArea }">
									</div>
								</div>

								<div class="ln_solid"></div>
								<div class="item form-group">
									<div class="col-md-6 col-sm-6 offset-md-3">

										<c:if test="${isEdit == true }">
											<button type="button" class="btn btn-success"
												id="btnUpdateBuilding">Cập nhập thông tin</button>
										</c:if>

										<c:if test="${isEdit == false }">
										
											
											<button type="button" class="btn btn-success"
												id="btnAddBuilding">Thêm tòa nhà</button>
										</c:if>

										<button type="button" class="btn btn-primary" type="reset">Reset</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>