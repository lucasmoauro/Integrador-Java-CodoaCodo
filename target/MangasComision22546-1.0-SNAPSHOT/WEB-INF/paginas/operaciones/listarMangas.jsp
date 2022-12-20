<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_AR"/>


<section id="mangas">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Mangas</h4>
                    </div>

                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr >
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Autor</th>
                                <th>Cantidad de paginas</th>
                                <th>Precio</th>
                                <th>Genero</th>
                                <th>-</th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach var="manga" items="${mangas}" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${manga.nombre}</td>
                                    <td>${manga.autor}</td>
                                    <td>${manga.cantPaginas}</td>
                                    <td><fmt:formatNumber value="${manga.precio}" type="currency" /></td>
                                    <td>${manga.genero}</td>

                                    <td>
                                        <a href="${pageContext.request.contextPath}/servletControlador?accion=editar&idmangas=${manga.idmangas}" class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i>
                                            Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div  class="col-md-3">
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3>
                            Cantidad de mangas
                        </h3>
                        <h4 class="display-4">
                            <i class="fas fa-users"></i>
                            ${totalMangas}
                        </h4>
                    </div>
                </div>
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>
                            Total Paginas
                        </h3>
                        <h4 class="display-4">
                            <i class="fas fa-users"></i>
                            ${totalPaginas}
                        </h4>
                    </div>
                </div>
            </div>

        </div>
    </div>

</section>


<jsp:include page="/WEB-INF/paginas/operaciones/agregarMangas.jsp" />