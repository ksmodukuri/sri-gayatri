<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="container">
	<div class="card">
		<h5 class="card-header">Student Details</h5>
		<div class="card-body">
			<nav
				class="management-bar management-bar-light">
				<div class="container-fluid container-fluid-max-xl">
					<div class="navbar-form">
						<form role="search">
							<div class="row">
								<div class="col">
								<label>Search By Admission Number</label>
									<div class="input-group">
										<div class="input-group-item">
											<input
												class="form-control input-group-inset input-group-inset-after"
												placeholder="Search" type="text" id="searchByAdmnNo" /> <span
												class="input-group-inset-item input-group-inset-item-after">
											</span>
										</div>
									</div>
								</div>
								<div class="col">
								<label>Search By Name</label>
									<div class="input-group">
										<div class="input-group-item">
											<input
												class="form-control input-group-inset input-group-inset-after"
												placeholder="Search" type="text" id="searchByName" /> <span
												class="input-group-inset-item input-group-inset-item-after">
											</span>
										</div>
									</div>
								</div>
								<div class="col">
								<label>Search By Class</label>
									<div class="input-group">
										<div class="input-group-item">
											<input
												class="form-control input-group-inset input-group-inset-after"
												placeholder="Search" type="text" id="searchByClass" /> <span
												class="input-group-inset-item input-group-inset-item-after">
											</span>
										</div>
									</div>
								</div>
								<div class="col" style="margin-top: 0.65cm">
									<button class="btn btn-success" type="button" id="searchBtn">
										Search
										<svg class="lexicon-icon lexicon-icon-search"
											focusable="false" role="presentation">
										<use href="/images/icons/icons.svg#search"></use>
									</svg>
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</nav>
			<hr>
			<div class="container">
				<table
					class="table table-hover table-responsive table-autofit table-cell-expand"
					id="bootstrap-table">
					<thead>
						<tr>
							<th abbr="admnNo">Adm. No. <svg
									class="lexicon-icon lexicon-icon-caret-top-l upArrow"
									id="upArrowfirstName" focusable="false" role="presentation">
							<use href="/images/icons/icons.svg#caret-top-l"></use>
					</svg> <svg class="lexicon-icon lexicon-icon-caret-bottom-l downArrow"
									id="downArrowfirstName" focusable="false" role="presentation">
							<use href="/images/icons/icons.svg#caret-bottom-l"></use>
					</svg>
							</th>
							<th abbr="std">Class<svg
									class="lexicon-icon lexicon-icon-caret-top-l upArrow"
									id="upArrowemailId" focusable="false" role="presentation">
							<use href="/images/icons/icons.svg#caret-top-l"></use>
					</svg> <svg class="lexicon-icon lexicon-icon-caret-bottom-l downArrow"
									id="downArrowemailId" focusable="false" role="presentation">
							<use href="/images/icons/icons.svg#caret-bottom-l"></use>
					</svg>
							</th>
							<th abbr="firstName">Student Name <svg
									class="lexicon-icon lexicon-icon-caret-top-l upArrow"
									id="upArrowlastName" focusable="false" role="presentation">
							<use href="/images/icons/icons.svg#caret-top-l"></use>
					</svg> <svg class="lexicon-icon lexicon-icon-caret-bottom-l downArrow"
									id="downArrowlastName" focusable="false" role="presentation">
							<use href="/images/icons/icons.svg#caret-bottom-l"></use>
					</svg>
							</th>
							<th abbr="aadhar">Student Aadhar <svg
									class="lexicon-icon lexicon-icon-caret-top-l upArrow"
									id="upArrowlastName" focusable="false" role="presentation">
							<use href="/images/icons/icons.svg#caret-top-l"></use>
					</svg> <svg class="lexicon-icon lexicon-icon-caret-bottom-l downArrow"
									id="downArrowlastName" focusable="false" role="presentation">
							<use href="/images/icons/icons.svg#caret-bottom-l"></use>
					</svg>
							</th>
							<th abbr="fatherName">Father Name<svg
									class="lexicon-icon lexicon-icon-caret-top-l upArrow"
									id="upArrowemailId" focusable="false" role="presentation">
							<use href="/images/icons/icons.svg#caret-top-l"></use>
					</svg> <svg class="lexicon-icon lexicon-icon-caret-bottom-l downArrow"
									id="downArrowemailId" focusable="false" role="presentation">
							<use href="/images/icons/icons.svg#caret-bottom-l"></use>
					</svg>
							</th>
							<th abbr="mobileNumber">Mobile Number<svg
									class="lexicon-icon lexicon-icon-caret-top-l upArrow"
									id="upArrowemailId" focusable="false" role="presentation">
							<use href="/images/icons/icons.svg#caret-top-l"></use>
					</svg> <svg class="lexicon-icon lexicon-icon-caret-bottom-l downArrow"
									id="downArrowemailId" focusable="false" role="presentation">
							<use href="/images/icons/icons.svg#caret-bottom-l"></use>
					</svg>
							</th>
							<th>Date of Birth
							</th>
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
				<br />
				<div class="pagination-bar">
					<div class="dropdown pagination-items-per-page">
						<a aria-expanded="false" aria-haspopup="true"
							class="dropdown-toggle" data-toggle="dropdown" href="#1"
							role="button"> <span id="selectedPageLimitText">10</span>&nbsp;entries
							<svg class="lexicon-icon lexicon-icon-caret-double-l"
								focusable="false" role="presentation">
				<use href="/images/icons/icons.svg#caret-double-l"></use>
			</svg>
						</a>
						<ul class="dropdown-menu dropdown-menu-top">
							<li><a class="dropdown-item" href="#1">5</a></li>
							<li><a class="dropdown-item" href="#1">10</a></li>
							<li><a class="dropdown-item" href="#1">20</a></li>
							<li><a class="dropdown-item" href="#1">30</a></li>
							<li><a class="dropdown-item" href="#1">50</a></li>
						</ul>
					</div>

					<!-- <div class="pagination-results">Showing 1 to 20 of 203 entries.</div> -->
					<input type="hidden" value=firstName id="sortBy" name="sortBy" />
					<input type="hidden" value="false" id="asc" name="asc" /> <input
						type="hidden" value="1" id="selectedPage" name="selectedPage" />
					<input type="hidden" value="10" id="selectedPageLimit"
						name="selectedPageLimit" /> <input type="hidden" value="students"
						id="dataQueryService" name="dataQueryService" />
					<div class="pagination-results"></div>
					<ul class="pagination">
						<li class="disabled page-item" id="pagePreviousBtn"><a
							class="page-link" href="#1" role="button" tabindex="-1"> <svg
									class="lexicon-icon lexicon-icon-angle-left" focusable="false"
									role="presentation">
					<use href="/images/icons/icons.svg#angle-left"></use>
				</svg> <span class="sr-only">Previous</span>
						</a></li>
						<li class="dropdown page-item"><a aria-expanded="false"
							aria-haspopup="true" class="dropdown-toggle page-link"
							data-toggle="dropdown" href="#1" role="button"><span
								id="selectedPageText"></span>&nbsp; of &nbsp; <span
								id="totalPageText"></span>&nbsp; pages <svg
									class="lexicon-icon lexicon-icon-caret-double-l"
									focusable="false" role="presentation">
				<use href="/images/icons/icons.svg#caret-double-l"></use>
			</svg></a>
							<ul class="dropdown-menu dropdown-menu-top-center">
								<li>
									<ul class="inline-scroller" id="pageSelectDropdown">
									</ul>
								</li>
							</ul></li>
						<li class="page-item" id="pageNextBtn"><a class="page-link"
							href="#1" role="button"> <svg
									class="lexicon-icon lexicon-icon-angle-right" focusable="false"
									role="presentation">
					<use href="/images/icons/icons.svg#angle-right"></use>
				</svg> <span class="sr-only">next</span>
						</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
<button onclick="window.print()">Print this page</button>