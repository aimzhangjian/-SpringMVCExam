<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>资料</title>
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/css/bootstrap.css"
	rel="stylesheet" type="text/css" media="all" />

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" media="all" />

<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Playfair+Display:400,700,900,400italic,700italic,900italic'
	rel='stylesheet' type='text/css'>
<!-- js -->
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/css/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/css/bootstrap.min.js"></script>
<!-- //js -->








<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Floral Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	
	
	
	
	
	
	 addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);
    function hideURLbar() {
        window.scrollTo(0, 1);
    } 








</script>

<script type="text/javascript">
	function createXMLHttpRequest() {
		try {
			return new XMLHttpRequest();
		} catch (e) {
			try {
				return new ActiveXObject("Msxm12.XMLHTTP");
			} catch (e) {
				return new ActiveXObject("Micorsoft.XMLHTTP");
			}
		}

	};
	
	
	
	
	
	window.onload = function(){
         
		
		
		 
			var urlCustomer="<c:url value='/customerHandler/getCustomers'/>";
		
		
		
		//得到核心对象
		var xmlHttp = createXMLHttpRequest();
		//打开连接
		xmlHttp.open("GET",urlCustomer,
				true);
		//发送
		xmlHttp.send(null);
		//添加监听
        
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
				//执行服务器发送过来的json字符串，得到js的对象

				var pb = eval("(" + xmlHttp.responseText + ")");
				var customers = pb.beanList;
				for ( var i = 0; i < customers.length; i++) {
					var customer = customers[i];//得到每个pro对象
					//创建<option>元素

					var trEle = document.createElement("tr");

					var tdEle = document.createElement("td");
					//给<option>元素的value属性赋值
					/* tdEle. = pro.pid;//给<option>的实际值赋值为pid，而不是name */
					var textNode = document.createTextNode(customer.store_id);//使用省名称来创建textNode
					tdEle.appendChild(textNode);//把textNode添加到option元素中
					//把option元素添加到select元素中

					trEle.appendChild(tdEle);

					var tdEle1 = document.createElement("td");
					var textNode1 = document
							.createTextNode(customer.first_name);//使用省名称来创建textNode
					tdEle1.appendChild(textNode1);//把textNode添加到option元素中
					trEle.appendChild(tdEle1);

					var tdEle2 = document.createElement("td");
					var textNode2 = document.createTextNode(customer.last_name);//使用省名称来创建textNode
					tdEle2.appendChild(textNode2);//把textNode添加到option元素中
					trEle.appendChild(tdEle2);

					var tdEle3 = document.createElement("td");
					var textNode3 = document.createTextNode(customer.email);//使用省名称来创建textNode
					tdEle3.appendChild(textNode3);//把textNode添加到option元素中
					trEle.appendChild(tdEle3);

					var tdEle4 = document.createElement("td");
					var textNode4 = document
							.createTextNode(customer.address_id);//使用省名称来创建textNode
					tdEle4.appendChild(textNode4);//把textNode添加到option元素中
					trEle.appendChild(tdEle4);

					var tdEle5 = document.createElement("td");
					var textNode5 = document.createTextNode(customer.active);//使用省名称来创建textNode
					tdEle5.appendChild(textNode5);//把textNode添加到option元素中
					trEle.appendChild(tdEle5);

					var tdEle6 = document.createElement("td");
					var textNode6 = document
							.createTextNode(customer.last_update);//使用省名称来创建textNode
					tdEle6.appendChild(textNode6);//把textNode添加到option元素中
					trEle.appendChild(tdEle6);

					/* 	<td><a
						href="<c:url value='/FilmServlet?method=editerFilm&fid=${f.film_id}'/>">编辑</a>
					</td>
					<td><a onclick="return confirm('你真的要删除吗？')"
						href="<c:url value='/FilmServlet?method=deleteFilm&fid=${f.film_id}'/>">删除</a>
					</td> */

					var tdEle7 = document.createElement("td");
					var aEle = document.createElement("a");
					aEle.setAttribute("onclick", "return confirm('你真的要删除吗？')");
					aEle.setAttribute("href",
							"<c:url value='/customerHandler/deleteCustomer?customer_id="
									+ customer.customer_id + "'/>");

					var textNode7 = document.createTextNode("删除");
					aEle.appendChild(textNode7);

					tdEle7.appendChild(aEle);//把textNode添加到option元素中
					trEle.appendChild(tdEle7);

					var tdEle8 = document.createElement("td");
					var button = document.createElement("a");
					button.setAttribute("class", "btn btn-primary");
					button.setAttribute("data-toggle", "modal");
					button.setAttribute("data-target", ".bs-example-modal-sm");
					button.setAttribute("href","<c:url value='/customerHandler/toEditerCustomer?customer_id="+customer.customer_id+"'/>");
					var textNode8 = document.createTextNode("编辑");
					button.appendChild(textNode8);
					tdEle8.appendChild(button);

					trEle.appendChild(tdEle8);

					trEle.bordercolor = "rgb(78,78,78)";

					document.getElementById("cutomerTable").appendChild(trEle);

				}
				/* 第${pb.pc}页/共${pb.tp}页 
				   href="${pb.url}&pc=1" id="pburl"
				 */
				var text = document.createTextNode("第" + pb.pc + "页/共" + pb.tp
						+ "页");
				document.getElementById("firsth6").appendChild(text);
				
				
			}

		};

	};
</script>



<!-- //for-mobile-apps -->
<!-- start-smoth-scrolling -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/move-top.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
		});
	});
</script>
<!-- start-smoth-scrolling -->
</head>

<body>
	<!-- header -->
	<div class="header">
		<div class="container">
			<div class="header-info">
				<div class="logo">
					<a href="index.html"><img
						src="${pageContext.request.contextPath}/images/logo.png" alt=" " /></a>
				</div>
				<div class="logo-right">
					<span class="menu"><img
						src="${pageContext.request.contextPath}/images/menu.png" alt=" " /></span>
					<ul class="nav1">
						<li><a
							href="${pageContext.request.contextPath}/loginHandler/quit">退出</a></li>
						<!-- <li><s:a action="VideoAction-findAllVideo" namespace="/">视频</s:a></li>
						<li><s:a action="NotebookAction-findAllNotebook">笔记</s:a></li>
						<li class="cap"><s:a action="MaterialAction-findAllMaterial" namespace="/">资料</s:a></li>
						<li><a href="news.html">新闻</a></li>
						<li><s:a action="ManagerAction-goManeger">管理</s:a></li>
						<li><s:a action="ManagerAction-goLogin">登录/注册</s:a></li> -->
					</ul>
				</div>
				<div class="clearfix"></div>
				<!-- script for menu -->
				<script>
					$("span.menu").click(function() {
						$("ul.nav1").slideToggle(300, function() {
							// Animation complete.
						});
					});
				</script>
				<!-- //script for menu -->
			</div>
		</div>
	</div>
	<!-- header -->
	<!-- content -->

	<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog"
		aria-labelledby="mySmallModalLabel">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<%-- <form:form action="${pageContext.request.contextPath}/customerHandler/addCustomer"
						method="POST" modelAttribute="customer">

                      first_name:<form:input path="first_name" />
                      <br />
                      last_name:<form:input path="last_name" />
                      <br />
                      Email:<form:input path="email" />
                      <br />
                      Address:<form:select path="address.address_id"
							items="${address}" itemLabel="address" itemValue="address_id"></form:select>
						<br />
						<input type="submit" value="Submit" />
					</form:form>
                  --%>
			</div>
		</div>
	</div>



	<div class="content">
		<div class="container">
			<div class="content-text">
				<div class="title" align="center">
					<a
						href="${pageContext.request.contextPath}/customerHandler/toAddCustomer">新建</a>
					<table align="center" border="1" cellpadding="0" cellspacing="0"
						id="cutomerTable">
						<tr id="th" bordercolor="rgb(78,78,78)">
							<th>store_id</th>
							<th>first_name</th>
							<th>last_name</th>
							<th>email</th>
							<th>address_id</th>
							<th>active</th>
							<th>last_update</th>
							<th>option</th>
							<th>option</th>
						</tr>

						<%-- <tr bordercolor="rgb(78,78,78)" id="cutomerTr">
							
							<td><a
								href="<c:url value='/FilmServlet?method=editerFilm&fid=${f.film_id}'/>">编辑</a>
							</td>
							<td><a onclick="return confirm('你真的要删除吗？')"
								href="<c:url value='/FilmServlet?method=deleteFilm&fid=${f.film_id}'/>">删除</a>
							</td>
						</tr> --%>

					</table>

					<div class="border1" align="center">

						<h6 id="firsth6"></h6>
						<button id="pburl">首页</button>
						<c:if test="${pb.pc>1}">
							<a href="${pb.url}&pc=${pb.pc-1}">上一页</a>
						</c:if>

						<c:choose>
							<%-- 如果总页数不大于10页，那么把所有的页数都显示出来 --%>
							<c:when test="${pb.tp<=10}">
								<c:set var="begin" value="1" />
								<c:set var="end" value="${pb.tp}" />
							</c:when>
							<c:otherwise>
								<%-- 当总页数大于10时--%>
								<c:set var="begin" value="${pb.pc-5}" />
								<c:set var="end" value="${pb.pc+4}" />
								<%-- 头溢出 --%>
								<c:if test="${begin<1}">
									<c:set var="begin" value="1" />
									<c:set var="end" value="10" />
								</c:if>
								<c:if test="${end>pb.tp}">
									<c:set var="begin" value="${pb.tp-9}" />
									<c:set var="end" value="${pb.tp}" />
								</c:if>
							</c:otherwise>
						</c:choose>

						<c:forEach var="i" begin="${begin}" end="${end}">
							<c:choose>
								<c:when test="${i eq pb.pc}">[${i}]</c:when>
								<c:otherwise>
									<a href="${pb.url}&pc=${i}">[${i}]</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>


						<c:if test="${pb.pc<pb.tp}">
							<a href="${pb.url}&pc=${pb.pc+1}">下一页</a>
						</c:if>
						<a href="${pb.url}&pc=${pb.tp}">尾页</a>
						<div class="clearfix"></div>
					</div>
				</div>
				<div class="categories">
					<div class="categ">
						<div class="cat">


							<ul>
								<li><a href="single.html">Customer管理</a></li>
								<li><a href="single.html">Film管理</a></li>
							</ul>
						</div>

					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- //content -->
	<!-- footer -->
	<div class="footer">
		<div class="container">
			<div class="footer-grids">
				<div class="footer-grid">
					<h3>关于我们</h3>
					<p>果冻网是开放、多元的泛科技兴趣社区，并提供负责任、有智趣的科技主题内容。你可以在这里：
						依兴趣关注不同的主题站和小组，阅读有意思的科技内容； 在“果冻问答”里提出困惑你的科技问题，或提供靠谱的答案；
						关注各个门类和领域的果壳达人，加入兴趣讨论，分享智趣话题。</p>
				</div>
				<div class="footer-grid">
					<h3>相关信息</h3>
					<ul>
						<li class="cap1"><a href="index.html">首页</a></li>
						<li><a href="maneger.html">管理</a></li>
						<li><a href="javascript:void(0)">联系我们：18408269863
								011-87992352</a></li>
					</ul>
				</div>
				<div class="footer-grid">
					<h3>友情链接</h3>
					<ul>
						<li><a href="http://www.cnblogs.com/">博客园</a></li>
						<li><a href="http://www.w3school.com.cn/">w3cSchool</a></li>
						<li><a href="http://www.51cto.com/">51cto.com</a></li>
						<li><a href="http://www.2cto.com/">红黑联盟</a></li>

					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- //footer -->
	<!-- here stars scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
			 var defaults = {
			 containerID: 'toTop', // fading element id
			 containerHoverID: 'toTopHover', // fading element hover id
			 scrollSpeed: 1200,
			 easingType: 'linear'
			 };
			 */

			$().UItoTop({
				easingType : 'easeOutQuart'
			});

		});
	</script>
	<!-- //here ends scrolling icon -->
</body>
</html>