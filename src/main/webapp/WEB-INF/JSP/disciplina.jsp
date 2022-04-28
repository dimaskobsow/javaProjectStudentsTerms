
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
<%--    <link rel="stylesheet" href="../../resoures/css/discipline-list.css?v=2">--%>
    <link rel="stylesheet" href="../../resourse/css/discipline-list.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@400;700&display=swap" rel="stylesheet">
    <script type="text/javascript" src="../../resoures/js/function.js?v=2" charset="UTF-8"></script>


    <title>Студенты</title>
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


        <div class="table_progres">
            <div class="row">
                <div class="col-md-5">
                    <h3>Список дисциплин</h3>
                    <table class="table table-bordered border-primary">


                        <tr>
                            <th width="5%" class="table-active"></th>
                            <th width="95%" class="table-active">Название дисциплины</th>
                        </tr>
                        <c:forEach items="${disciplines}" var="disc">
                            <tr>
                                <td><input class="form-check-input mt-0" type="checkbox" value="${disc.id}"
                                           aria-label="Checkbox for following text input"></td>
                                <td>${disc.discipline}</td>
                            </tr>
                        </c:forEach>

                    </table>

                </div>


                <div class="col-md-4">
                    <div class="submin_le">

                        <form action="/discipline-create" method="get">
                            <input class="btn btn-primary look " type="submit"
                                   value="Создать дисциплину">
                        </form>

                        <input class="btn btn-primary  mody" type="submit" onclick="modifyDiscipline()"
                               value="Модифицировать выбранную дисциплину">


                        <input type="hidden" value="${deleteDisc.discipline}">

                        <input name="deletetDisc" class="btn btn-primary  delite" type="submit"
                               onclick="deleteDiscipline()"
                               value="Удалить выбранные дисциплины">

                        <form id="formModify" action="/discipline-modify" method="get">
                            <input type="hidden" id="hiddenModify" name="hiddenModify">
                        </form>
                        <form id="formDelete" action="/discipline-delete" method="post">
                            <input type="hidden" id="hiddenDelete" name="hiddenDelete">
                        </form>

                    </div>
                </div>


            </div>
        </div>


    </div>


</section>


<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"--%>
<%--        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"--%>
<%--        crossorigin="anonymous"></script>--%>
</body>

</html>