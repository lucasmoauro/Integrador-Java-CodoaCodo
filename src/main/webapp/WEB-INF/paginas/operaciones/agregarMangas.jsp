


<div class="modal fade" id="agregarMangaModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">
                    Agregar Manga
                </h5>
                <button class="close" data-dismiss="modal">
                    <span> 
                        &times;
                    </span>
                </button>
            </div>
            <form 
                action="${pageContext.request.contextPath}/servletControlador?accion=insertar"
                method="POST"
                class="was-validated"
                >
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" id="nombre" required />
                    </div>
                    <div class="form-group">
                        <label for="autor">Autor</label>
                        <input type="text" class="form-control" name="autor" id="autor" required/>
                    </div>
                    <div class="form-group">
                        <label for="cantPaginas">Cantidad de Paginas</label>
                        <input type="number" class="form-control" name="cantPaginas" id="cantPaginas" required/>
                    </div>
                    <div class="form-group">
                        <label for="precio">Precio</label>
                        <input type="number" class="form-control" name="precio" id="precio" required/>
                    </div>
                    <div class="form-group">
                        <label for="genero">genero</label>
                        <input type="text" class="form-control" name="genero" id="genero" required/>
                    </div>
                </div>

                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit" >
                        Guardar
                    </button>
                </div>

            </form>
        </div>
    </div>
</div>
