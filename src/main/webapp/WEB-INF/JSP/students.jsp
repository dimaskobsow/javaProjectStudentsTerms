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
    <link rel="stylesheet" href="../../resoures/css/students.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@400;700&display=swap" rel="stylesheet">
    <script type="text/javascript" src="../../resoures/js/function.js?v=3" charset="UTF-8"></script>

    <title>Студенты</title>
</head>

<body>

<section class="sheme_students">


    <div class="container">
        <div class="sheme_input">
            <ul class="nav nav-pills navbar">
                <li class="nav-item ">
                    <a class="nav-link active home" aria-current="page" href="../index.jsp">На главную</a>
                </li>
                <li class="nav-item ">
                    <a class="nav-link active exit" aria-current="page" href="#">Выход</a>
                </li>

            </ul>

            <div></div>
            <h1>Система управления студентами и их успеваемостью</h1>
        </div>
        <div class="submin">
            <div class="row">
                <div class="col-md-6">
                    <div class="submin_left">
                        <input  onclick="studentProgress()" class="btn btn-primary  look" type="submit"
                                value="Посмотреть успеваемость выбранных студентов">
                        <input class="btn btn-primary mody" onclick="mofifyStudents()" type="submit"
                               value="Модифицировать выбранного студента">
                    </div>
                </div>


                <div class="col-md-6">
                    <div class="submin_right">
                        <form action="/student-create" method="get">
                            <input class="btn btn-primary create" type="submit" value="Создать студента">
                        </form>
                        <input onclick="deleteStudents()" class="btn btn-primary delite" type="submit" value="Удалить выбранных студентов">
                    </div>
                </div>
            </div>


        </div>



    </div>


    </div>


</section>
<section class="table_students">
    <div class="container">

        <table class="table table-success table-striped stud-table">


            <tr>
                <th width="10%" class="table-active"></th>
                <th width="30%" class="table-active">Фамилия</th>
                <th width="30%" class="table-active"> Имя</th>
                <th width="15%" class="table-active">Группа</th>
                <th width="15%" class="table-active">Дата</th>

            </tr>
            <c:forEach items="${students}" var="stud">
                <tr>
                    <td><input class="form-check-input mt-0" type="checkbox" value="${stud.id}"
                               aria-label="Checkbox for following text input"></td>
                    <td>${stud.lastName}</td>
                    <td>${stud.name}</td>
                    <td>${stud.group.name}</td>
                    <td>${stud.date}</td>
                </tr>
            </c:forEach>

        </table>
    </div>


</section>
<form  action="/student-modify" method="get" id="formStudModify">
    <input type="hidden" id="hiddenStudModify" name="hiddenStudModify">
</form>
<form id="formStudDelete" action="/delete-students" method="post">
    <input type="hidden" id="hiddenStudDelete" name="hiddenStudDelete">
</form>
<form  action="/student-progress" method="get" id="formStudentProgress">
    <input type="hidden" id="hiddenStudentProgress" name="hiddenStudentProgress">
</form>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
</body>

</html>