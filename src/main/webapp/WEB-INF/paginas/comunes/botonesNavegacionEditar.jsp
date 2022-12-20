<section class="py-4 mb-4 bg-light" id="actions">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <a class="btn btn-light btn-block" href="index.jsp">
                    <i class="fas fa-arrow-left"></i>
                    Regresar a inicio
                </a>
            </div>
            <div class="col-md-3">
                <button type="submit" class="btn btn-success btn-block">
                    <i class="fas fa-check"></i>
                    Guardar Modificacion
                </button>
            </div>


            <div class="col-md-3">

                <a href="${pageContext.request.contextPath}/servletControlador?accion=eliminar&idManga=${manga.idmangas}" 
                   class="btn btn-danger btn-block">
                    <i class="fas fa-trash"></i>
                    Eliminar Manga
                </a>

            </div>


        </div>
    </div>
</section>