<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="p-4">
<div class="container">
    <h2>Edit Student</h2>
    <form action="update" method="post">
        <input type="hidden" name="id" value="${student.id}">
        <div class="mb-3">
            <label>Name</label>
            <input type="text" name="name" value="${student.name}" class="form-control">
        </div>
        <div class="mb-3">
            <label>Email</label>
            <input type="email" name="email" value="${student.email}" class="form-control">
        </div>
        <div class="mb-3">
            <label>Course</label>
            <input type="text" name="course" value="${student.course}" class="form-control">
        </div>
        <input type="submit" value="Update" class="btn btn-primary">
    </form>
</div>
</body>
</html>
