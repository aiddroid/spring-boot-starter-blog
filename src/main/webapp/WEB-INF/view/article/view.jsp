<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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

  <jsp:include flush="true" page="../_partial/nav.jsp" />

  <!-- Page Header -->
  <header class="masthead" style="background-image: url('img/post-bg.jpg')">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="post-heading">
            <h1><c:out value="${article.title}"/></h1>
            <h2 class="subheading"><c:out value="${fn:substring(article.slug, 0, 100)}..."/></h2>
            <span class="meta">Posted by
              <a href="/?author=admin">admin</a>
              <i>
                  <fmt:formatDate value="${article.createdAt}" pattern="yyyy-MM-dd HH:mm"/>
              </i>
            
            <!--判断是否需要显示管理选项-->
            <c:if test="${sessionScope.username != null}">
                <a href="/admin/delete-article?id=${article.id}" class="delete-link text-danger">Delete</a>
                <a href="/admin/update-article?id=${article.id}" class="edit-link text-danger">Edit</a>
            </c:if>
            </span>
          </div>
        </div>
      </div>
    </div>
  </header>

  <!-- Post Content -->
  <article>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
            <!--显示博文正文,不进行转义-->
            <c:out value="${article.content}" escapeXml="false"/>
        </div>
      </div>
    </div>
  </article>

  <hr>

  <!-- Footer -->
  <jsp:include flush="true" page="../_partial/footer.jsp" />

</body>

</html>

