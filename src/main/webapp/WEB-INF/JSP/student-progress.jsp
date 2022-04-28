<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="ru">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
  <link rel="stylesheet" href="../../resoures/css/student-progress.css">
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@400;700&display=swap" rel="stylesheet">
  <script type="text/javascript" src="../../resoures/js/function.js?v=3" charset="UTF-8"></script>

  <title>Успеваемость</title>
</head>

<body>

<section class="table_students">
  <div class="container">
    <ul class="nav nav-pills navbar">
      <li class="nav-item ">
        <a class="nav-link active home" aria-current="page" href="../index.jsp">На главную</a>
      </li>
      <li class="nav-item ">
        <a class="nav-link active exit" aria-current="page" href="#">Выход</a>
      </li>

    </ul>
    <h1>Система управления студентами и их успеваемостью</h1>

    <h3>Отображена успеваемость для следующего студента:</h3>
    <form action="/student-progress" method="get" >
      <input name="id" type="hidden" value="${stud.id}">
      <table class="table table-success table-striped">


        <tr>

          <th width="35%" class="table-active">Фамилия</th>
          <th width="35%" class="table-active"> Имя</th>
          <th width="15%" class="table-active">Группа</th>
          <th width="15%" class="table-active">Дата</th>

        </tr>
        <%--<c:forEach items="${students}" var="stud">--%>
        <tr>

          <td>${stud.lastName}</td>

          <td>${stud.name}</td>
          <td>${stud.group.name}</td>
          <td>${stud.date}</td>
        </tr>
        <%--</c:forEach>--%>

      </table>
    </form>
    <div class="table_progres">
      <div class="row">
        <div class="col-md-6">
          <table class="table table-success table-striped">


            <tr>
              <th width="30%" class="table-active">Группа</th>
              <th width="15%" class="table-active">Оценка</th>
            </tr>
            <tr>
              <td>dfd</td>
              <td>dfd</td>

            </tr>
            <tr>
              <td>dfd</td>
              <td>dfd</td>
            </tr>
            <tr>
              <td>dfd</td>
              <td>dfd</td>
            </tr>
            <tr>
              <td>dfd</td>
              <td>dfd</td>
            </tr>
          </table>

        </div>


        <div class="col-md-3">
          <div class="submin_le">

            <select class="form-select semestr list_emestr" aria-label="Default select example">
              <option selected>Выберите семестр</option>
              <option value="1">Семестр 1</option>
              <option value="2">Семестр 2</option>
              <option value="3">Семестр 3</option>
            </select>

          </div>
        </div>
        <div class="col-md-3">
          <div class="choose_input">
            <button type="button" class="btn btn-outline-primary ">Выбрать</button>
          </div>
        </div>

      </div>
    </div>


  </div>


</section>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
</body>

</html>