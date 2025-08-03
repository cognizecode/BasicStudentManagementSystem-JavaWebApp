<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Student</title>
    <!-- Bootstrap CSS CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1

    response.setHeader("Pragma", "no-cache"); // HTTP 1.0

    response.setHeader("Expires", "0"); // Proxies
%>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">

            <div class="card shadow-lg rounded">
                <div class="card-header bg-primary text-white">
                    <h4 class="text-center mb-0">Add New Student</h4>
                </div>
                <div class="card-body">

                    <form action="add" method="post">
                        <div class="mb-3">
                            <label for="name" class="form-label">Full Name</label>
                            <input type="text" name="name" class="form-control" placeholder="Enter full name" required autocomplete="off">
                        </div>

                        <div class="mb-3">
                            <label for="email" class="form-label">Email address</label>
                            <input type="email" name="email" class="form-control" placeholder="Enter email" required autocomplete="off">
                        </div>

                        <div class="mb-3">
                            <label for="course" class="form-label">Course</label>
                            <input type="text" name="course" class="form-control" placeholder="Enter course name" required autocomplete="off">
                        </div>

                        <div class="d-grid">
                            <input type="submit" class="btn btn-success" value="Add Student">
                        </div>
                    </form>

                </div>
            </div>

        </div>
    </div>
</div>

<!-- Bootstrap JS (Optional for form components) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
