<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
    <style>
        #div{
            width:600px;
            height:350px;
            margin:auto;
            margin-top:100px;
        }
    </style>
</head>
<body class="container-fluid">
<div class="card" id="div">
    <h2 class="card-header text-center bg-danger text-light">Todo Registration Form</h2>
    <form action="register" method="post">
        <table class="table table-hover table-striped">
            <tr>
                <td>Enter Name</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>Enter priorityID</td>
                <td><input type="number" min=1 max= 5 name="prioID"></td>
            </tr>
            <tr>
                <td>Enter Completion</td>
                <td><input type="radio" name="Done" value="true">True
                    <input type="radio" name="Done" value="false">False</td>
            </tr>

            <tr>
                <td><input type="submit" value="register" class="btn btn-outline-success"></td>
                <td><input type="reset" value="reset" class="btn btn-outline-danger"></td>
            </tr>
        </table>
        <button class="btn btn-outline-success d-block"><a href="showdata">Show Users</a></button>

    </form>
</div>
</body>
</html>