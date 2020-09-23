<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<c:url var="assignmentStaffAPI" value="/api-assignmentstaff" />
<c:url var="buildingList" value="/admin/building/list" />
<c:url var="editBuilding" value="/admin/building/edit" />

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>List Building</title>

</head>

<body>
	<c:if test="${message != null}">
		<script>alert('${message}');</script>
	</c:if>

	<!-- top tiles -->
	<div class="row">
		<div class="col-md-12 col-sm-12 ">
			<div class="x_panel">
				<div class="x_title">
					<h2>Tìm kiếm</h2>
					<ul class="nav navbar-right panel_toolbox">
						<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
						</li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="x_content">
					<br />
					<form:form id="demo-form2" class="form-horizontal form-label-left"
						method="get" action="${buildingList }" modelAttribute="model">
						<div class="row mgr-bot">
							<div class="col-md-6 col-sm-6">

								<div>
									<label>Tên sản phẩm </label> <input type="text" id="first-name"
										name="name" class="form-control ">
								</div>
							</div>

							<div class="col-md-6 col-sm-6">
								<div>
									<label>Diện tích sàn </label> <input type="text"
										id="first-name" name="buildingArea" class="form-control ">
								</div>
							</div>
						</div>

						<div class="row mgr-bot">
							<div class="col-md-4 col-sm-4">
								<div>
									<label for="heard">Quận huyện</label> <select id="heard"
										class="form-control" name="district">
										<option value="">Choose..</option>
										<c:forEach var="district" items="${districts }">

											<option value="${district.key }"
												${model.district == district.key ? 'selected' : '' }>${district.value}
											</option>

										</c:forEach>
									</select>
								</div>
							</div>

							<div class="col-md-4 col-sm-4">
								<div>
									<label>Phường </label> <input type="text" id="first-name"
										name="ward" class="form-control" value="${model.ward }">

								</div>
							</div>

							<div class="col-md-4 col-sm-4">
								<div>
									<label>Đường </label> <input type="text" id="first-name"
										name="street" class="form-control " value="${model.street }">

								</div>
							</div>
						</div>

						<div class="row mgr-bot">
							<div class="col-md-4 col-sm-4">
								<div>
									<label>Số tầng hầm </label> <input type="text" id="first-name"
										name="numberOfBasement" class="form-control "
										value="${model.numberOfBasement }">

								</div>
							</div>

							<div class="col-md-4 col-sm-4">
								<div>
									<label>Hướng </label> <input type="text" id="first-name"
										name="direction" class="form-control ">

								</div>
							</div>

							<div class="col-md-4 col-sm-4">
								<div>
									<label>Hạng </label> <input type="text" id="first-name"
										name="rank" class="form-control ">
								</div>
							</div>
						</div>

						<div class="row mgr-bot">
							<div class="col-md-3 col-sm-3">
								<div>
									<label>Diện tích từ </label> <input type="text" id="first-name"
										name="areaRentFrom" class="form-control "
										value="${model.areaRentFrom }">

								</div>
							</div>

							<div class="col-md-3 col-sm-3">
								<div>
									<label>Diện tích đến </label> <input type="text"
										id="first-name" name="areaRentTo" class="form-control "
										value="${model.areaRentTo }">

								</div>
							</div>

							<div class="col-md-3 col-sm-3">
								<div>
									<label>Giá thuê từ </label> <input type="text" id="first-name"
										name="costRentFrom" class="form-control "
										value="${model.costRentFrom }">
								</div>
							</div>

							<div class="col-md-3 col-sm-3">
								<div>
									<label>Giá thuê đến </label> <input type="text" id="first-name"
										name="costRentTo" class="form-control "
										value="${model.costRentTo }">
								</div>
							</div>
						</div>

						<div class="row mgr-bot">
							<div class="col-md-4 col-sm-4">
								<div>
									<label>Tên quản lý </label> <input type="text" id="first-name"
										name="managerName" class="form-control "
										value="${model.managerName }">

								</div>
							</div>

							<div class="col-md-4 col-sm-4">
								<div>
									<label>Điện thoại quản lý </label> <input type="text"
										id="first-name" name="managerPhone" class="form-control "
										value="${model.managerPhone }">

								</div>
							</div>

							<div class="col-md-4 col-sm-4">
								<label for="heard">Nhân viên phụ trách</label> <select
									id="heard" class="form-control" name="staffId">
									<option value="">Choose..</option>
									<c:forEach var="user" items="${users }">
										<option value="${user.id }"
											${model.staffId == user.id ? 'selected' : '' }>${user.fullName }
										</option>
									</c:forEach>

								</select>
							</div>
						</div>

						<div class="row mgr-bot">
							<div class="col-md-4 col-sm-4">
								<p style="padding: 5px;">
									<!-- data-parsley-mincheck="2"   require checkbox-->

									<c:forEach var="type" items="${buildingTypes }">

										<input type="checkbox" name="buildingTypes" id="buildingTypes"
											value="${type.key }" class="flat"
											${fn:contains(fn:join(model.buildingTypes, ', '), type.key) ? 'checked' : '' } /> ${type.value }
                          	
                          </c:forEach>
								<p>
							</div>
						</div>

						<div class="row mgr-bot">
							<div class="col-md-4 col-sm-4">
								<button type="submit" class="btn btn-success">Tìm kiếm</button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-12 col-sm-12">
			<div class="x_panel">
				<div class="x_title">
					<h2>Danh sách tòa nhà</h2>
					<ul class="nav navbar-right panel_toolbox">
						<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
					</ul>
					<div class="clearfix"></div>
				</div>

				<div class="x_content">
					<div class="row">
						<div class="col-sm-12">

							<div class="card-box table-responsive">

								<div id="buildingList">
									<table id="datatable-buttons"
										class="table table-striped table-bordered" style="width: 100%">
										<thead>
											<tr class="headings">
												<th><input type="checkbox" name="chkAll" id="check-all"
													onclick="toggle(this)"></th>

												<th>Tên sản phẩm</th>
												<th>Địa chỉ</th>
												<th>Tên quản lý</th>
												<th>Số điện thoại</th>
												<th>Diện tích sàn</th>
												<th>Giá thuê</th>
												<th>Phí dịch vụ</th>
												<th>Loại tòa nhà</th>
												<th>Thao tác</th>
											</tr>
										</thead>
										<tbody>

											<c:forEach var="building" items="${buildings}">
												<tr>
													<td><input type="checkbox" name="chkBuilding"
														id="chkAll" value="${building.id}"></td>
													
													<td>${building.name}</td>

													<td>${building.address}</td>

													<td>${building.managerName}</td>

													<td>${building.managerPhone}</td>

													<td>${building.buildingArea}</td>

													<td>${building.costRent}</td>

													<td>${building.serviceCost}</td>

													<td>${building.type}</td>

													<td>
														<button class="btn btn-primary"
															onclick="assignmentBuilding(${building.id})">
															<i class="fa fa-list" aria-hidden="true"></i>
														</button> 
														
														<a
															href="<c:url value='${editBuilding}?id=${building.id }'/>"
															class="btn btn-primary"> <i class="fa fa-pencil"
															aria-hidden="true"></i>
														</a>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>

							<div class="mgr-top" style="text-align: right;">

								<form method="get" action="<c:url value='/admin'/>">
									<input type="text" hidden name="action" class="form-control "
										value="ListBuilding">

									<button type="button" class="btn btn-danger" id="btnDeleteBuilding">
										<i class="fa fa-trash" aria-hidden="true"></i>
									</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="modal" id="assignmentBuildingModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Danh sách nhân viên</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<table class="table table-striped jambo_table bulk_action"
						id="staffList">
						<thead>
							<tr class="headings">
								<th><input type="checkbox" id="check-all" class="flat">
								</th>

								<th>Tên nhân viên</th>
						</thead>

						<tbody>


						</tbody>
					</table>
				</div>

				<input type="hidden" name="buildingId" id="buildingId" value="" />
				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal"
						id="btnAssignmentBuilding">Giao tòa nhà</button>
					<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				</div>

			</div>
		</div>
	</div>

	<div class="modal" id="deleteModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Danh sách nhân viên</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<p>Bạn có chắc muốn xóa</p>
				</div>

				<input type="hidden" name="buildingId" id="buildingId" value="" />
				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal"
						id="confirmDelete">Xóa</button>
					<button type="button" class="btn btn-danger" data-dismiss="modal">Hủy</button>
				</div>

			</div>
		</div>
	</div>
	<!-- /top tiles -->

</body>