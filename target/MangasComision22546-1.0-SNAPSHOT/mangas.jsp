<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control de Mangas</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/91992df9f4.js" crossorigin="anonymous"></script>


    </head>
    <body>

        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp" />

        <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacion.jsp" />

        <jsp:include page="/WEB-INF/paginas/operaciones/listarMangas.jsp"  />


        <jsp:include page="/WEB-INF/paginas/comunes/pieDePagina.jsp" />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
