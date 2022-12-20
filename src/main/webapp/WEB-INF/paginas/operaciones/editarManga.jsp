<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Mangas</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/91992df9f4.js" crossorigin="anonymous"></script>


    </head>
    <body>

        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp" />

        <form action="${pageContext.request.contextPath}/servletControlador?accion=modificar&idManga=${manga.idmangas}"
              method="POST"
              class="was-validated">
            <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacionEditar.jsp" />

            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Modificar Manga</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="nombre">Nombre</label>
                                        <input type="text" class="form-control" name="nombre" id="nombre" value="${manga.nombre}" required />
                                    </div>
                                    <div class="form-group">
                                        <label for="autor">Autor</label>
                                        <input type="text" class="form-control" name="autor" id="autor" value="${manga.autor}" required/>
                                    </div>
                                    <div class="form-group">
                                        <label for="cantPaginas">Cantidad de Paginas</label>
                                        <input type="number" class="form-control" name="cantPaginas" id="cantPaginas" value="${manga.cantPaginas}" required/>
                                    </div>
                                    <div class="form-group">
                                        <label for="precio">Precio</label>
                                        <input type="number" class="form-control" name="precio" id="precio" value="${manga.precio}" required/>
                                    </div>
                                    <div class="form-group">
                                        <label for="genero">Genero</label>
                                        <input type="text" class="form-control" name="genero" id="genero" value="${manga.genero}" required/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>


        </form>




        <jsp:include page="/WEB-INF/paginas/comunes/pieDePagina.jsp" />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
