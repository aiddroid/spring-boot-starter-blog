<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--jstl核心标签库-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--功能函数标签库-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!--格式化标签库-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<!DOCTYPE html>
<html lang="en">

<head>
  <base href="/static/">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Starter Blog - Start Bootstrap Theme</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

  <!-- Custom styles for this template -->
  <link href="css/clean-blog.min.css" rel="stylesheet">
  <link href="css/site.css" rel="stylesheet">
</head>

<body>
  <!--引入公共导航头-->
  <jsp:include flush="true" page="./_partial/nav.jsp" />

  <!-- Page Header -->
  <header class="masthead" style="background-image: url('img/home-bg.jpg')">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="site-heading">
            
            <!--判断是否需要显示alert-->
            <c:if test="${alert != null}">
            <div class="alert alert-warning alert-dismissible fade show" role="alert">
                ${alert}
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
            </div>
            </c:if>
              
            <h1>A Starter Blog</h1>
            <span class="subheading">A Blog Theme by Bootstrap and powered by Springboot 2.x</span>
          </div>
        </div>
      </div>
    </div>
  </header>
  
  <!-- Main Content -->
  <div class="container">
    <div class="row">
      <div class="col-lg-8 col-md-10 mx-auto">
        <!--根据博文列表显示博文-->
        <c:choose>
          <c:when test="${articles.size() > 0}">
            <c:forEach var="article" items="${articles}">
              <div class="post-preview">
                <a href="/article/view/<c:out value="${article.id}"/>">
                  <h2 class="post-title">
                    <c:out value="${article.title}"/>
                  </h2>
                  <h3 class="post-subtitle">
                    <c:out value="${fn:substring(article.slug, 0, 100)}..."/>
                  </h3>
                </a>
                <p class="post-meta">Posted by
                  <a href="/?author=admin">admin</a>
                  <i>
                      <!--日期格式化-->
                      <fmt:formatDate value="${article.createdAt}" pattern="yyyy-MM-dd HH:mm"/>
                  </i>

                  <!--判断是否需要显示管理选项-->
                  <c:if test="${sessionScope.username != null}">
                      <a href="/admin/delete-article?id=${article.id}" class="delete-link text-danger">Delete</a>
                      <a href="/admin/update-article?id=${article.id}" class="edit-link text-danger">Edit</a>
                  </c:if>
                </p>
              </div>
            </c:forEach>
          </c:when>
          <c:otherwise>
              <p>No contents!</p>
          </c:otherwise>
        </c:choose>
        <hr>

        <!-- Pager -->
        <div class="clearfix">
          <c:if test="${page > 1}">
          <a class="btn btn-primary float-left" href="/?page=${page-1}">&larr; Newer Posts</a>
          </c:if>
          
          <c:if test="${maxPage > page}">
          <a class="btn btn-primary float-right" href="/?page=${page+1}">Older Posts &rarr;</a>
          </c:if>
        </div>
      </div>
    </div>
  </div>

  <hr>

  <!--引入公共页脚-->
  <!-- Footer -->
  <jsp:include flush="true" page="./_partial/footer.jsp" />

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Custom scripts for this template -->
  <script src="js/clean-blog.min.js"></script>

</body>

</html>
