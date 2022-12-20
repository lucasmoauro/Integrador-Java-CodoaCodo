package controller;

import data.MangaDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Manga;
//WebServlet habilita a la clase a escuchar Request

@WebServlet("/servletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String accionJava = req.getParameter("accion");

        if (accionJava != null) {
            switch (accionJava) {
                case "editar":
                    editarManga(req, res);
                    break;
                case "eliminar":
                    eliminarManga(req, res);
                    break;
                default:
                    accionDefault(req, res);
                    break;

            }
        } else {
            accionDefault(req, res);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String accionJava = req.getParameter("accion");

        if (accionJava != null) {
            switch (accionJava) {
                case "insertar":
                    insertarManga(req, res);
                    break;
                case "modificar":
                    modificarManga(req, res);
                    break;
                default:
                    accionDefault(req, res);
                    break;

            }
        } else {
            accionDefault(req, res);
        }
    }

    private Integer calcularPaginas(List<Manga> mangasLista) {

        Integer cantidad = 0;

        for (int i = 0; i < mangasLista.size(); i++) {
            cantidad += mangasLista.get(i).getCantPaginas();
        }

        return cantidad;

    }

    private void accionDefault(HttpServletRequest req, HttpServletResponse res
    ) throws ServletException, IOException {
        List<Manga> mangas = new MangaDAO().seleccionar();
        mangas.forEach(System.out::println);

        HttpSession sesion = req.getSession();

        sesion.setAttribute("mangas", mangas);
        sesion.setAttribute("totalMangas", mangas.size());
        sesion.setAttribute("totalPaginas", calcularPaginas(mangas));

        res.sendRedirect("mangas.jsp");
    }

    private void insertarManga(HttpServletRequest req, HttpServletResponse res
    ) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String autor = req.getParameter("autor");
        String cantPaginasString = req.getParameter("cantPaginas");
        String precioString = req.getParameter("precio");
        String genero = req.getParameter("genero");
        int cantPaginas = 0;
        double precio = 0;
//        int genero =  0;

        if (cantPaginasString != null & !cantPaginasString.equals("")) {
            cantPaginas = Integer.parseInt(cantPaginasString);

        }

        if (precioString != null & !precioString.equals("")) {
            precio = Double.parseDouble(precioString);

        }

//        if (genero != null & !genero.equals("")) {
//            genero = Integer.parseInt(genero);
//
//        }
        Manga manga = new Manga(nombre, autor, cantPaginas, precio, genero);

        int regMod = new MangaDAO().insertar(manga);

        System.out.println("Registros guardados: " + regMod);

        accionDefault(req, res);

    }

    private void editarManga(HttpServletRequest req, HttpServletResponse res
    ) throws ServletException, IOException {

        int idmanga = Integer.parseInt(req.getParameter("idmangas"));
        Manga manga = new MangaDAO().seleccionarPorId(idmanga);
        System.out.println(manga + "asdasdsd");

        req.setAttribute("manga", manga);
        String jspEditar = "/WEB-INF/paginas/operaciones/editarManga.jsp";

        req.getRequestDispatcher(jspEditar).forward(req, res);
    }

    private void modificarManga(HttpServletRequest req, HttpServletResponse res
    ) throws ServletException, IOException {

        int idmanga = Integer.parseInt(req.getParameter("idManga"));
        String nombre = req.getParameter("nombre");
        String autor = req.getParameter("autor");
        String cantPaginasString = req.getParameter("cantPaginas");
        String precioString = req.getParameter("precio");
        String genero = req.getParameter("genero");
        int cantPaginas = 0;
        double precio = 0;
//        int genero = 0;

        if (cantPaginasString != null & !cantPaginasString.equals("")) {
            cantPaginas = Integer.parseInt(cantPaginasString);

        }

        if (precioString != null & !precioString.equals("")) {
            precio = Double.parseDouble(precioString);

        }

//        if (genero != null & !genero.equals("")) {
//            genero = Integer.parseInt(genero);
//
//        }
        Manga manga = new Manga(idmanga, nombre, autor, cantPaginas, precio, genero);

        int regMod = new MangaDAO().actualizar(manga);

        System.out.println("Registros actualizados: " + regMod);

        accionDefault(req, res);

    }

    private void eliminarManga(HttpServletRequest req, HttpServletResponse res
    ) throws ServletException, IOException {
        int idmanga = Integer.parseInt(req.getParameter("idManga"));

        int regBorrados = new MangaDAO().eliminar(idmanga);

        System.out.println("Registros eliminados: " + regBorrados);

        accionDefault(req, res);

    }
}
