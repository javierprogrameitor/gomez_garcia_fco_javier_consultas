package es.albarregas.controller;

import es.albarregas.bean.Alumno;
import es.albarregas.bean.Ciclo;
import es.albarregas.connection.Conexion;
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = null;
        Connection conexion = null;

        Statement sentencia = null;
        PreparedStatement preparada = null;
        ResultSet resultado = null;
        conexion = Conexion.getConnection();
        String sql = null;
        String sql_1 = null;
        String sql_2 = null;
        String sql_3 = null;
        String sql_4 = null;
        Alumno alumno = null;
        Ciclo ciclo = null;
        List<Alumno> alumnList = null;
        List<Ciclo> cicloList = null;

        String boton = request.getParameter("consulta");

        switch (boton) {
            case "diezprimeros":
                sql = "SELECT * FROM datosalumnos WHERE nombre IS NOT NULL ORDER BY nombre ASC LIMIT 10";
                request.setAttribute("consulta", "diezprimeros");
                break;
            case "alumnasmenores":
                sql = "SELECT * FROM datosalumnos WHERE Genero = 'MUJER' AND TIMESTAMPDIFF(YEAR, FechaNacimiento, CURDATE()) < 20";
                request.setAttribute("consulta", "alumnasmenores");
                break;
            case "apellidosuperior":
                sql = "SELECT * FROM datosalumnos WHERE apellidos IS NOT NULL AND apellidos NOT LIKE '% %' AND Ciclo LIKE '%3%'";
                request.setAttribute("consulta", "apellidosuperior");
                break;
            case "numeroalumnociclo":
                sql_1 = "SELECT Ciclo, COUNT(*) AS numAlumnosMatriculados\n"
                        + "FROM datosalumnos\n"
                        + "GROUP BY Ciclo\n"
                        + "HAVING COUNT(*) > 0";
                request.setAttribute("consulta", "numeroalumnociclo");
                break;
            case "abreviaturacuatro":
                sql_2 = "SELECT *\n"
                        + "FROM ciclos\n"
                        + "WHERE LENGTH(Abreviatura) = 4\n"
                        + "AND HorasFCT = 400";
                request.setAttribute("consulta", "abreviaturacuatro");
                break;
            case "edadaritmetica":
                sql_3 = "SELECT nombre, apellidos, YEAR(CURDATE()) - YEAR(FechaNacimiento) AS edad\n"
                        + "FROM datosalumnos\n"
                        + "WHERE Genero = 'HOMBRE'\n"
                        + "AND YEAR(FechaNacimiento) % 2 = 0\n"
                        + "AND DAYOFWEEK(FechaNacimiento) = 1\n"
                        + "HAVING edad < (SELECT AVG(YEAR(CURDATE()) - YEAR(FechaNacimiento)) FROM datosalumnos WHERE Genero = 'HOMBRE')";
                request.setAttribute("consulta", "edadaritmetica");
                break;
            case "jovenviejo":
                sql_4 = "SELECT \n"
                        + "    MAX(YEAR(CURDATE()) - YEAR(FechaNacimiento)) AS edadMaxima,\n"
                        + "    MIN(YEAR(CURDATE()) - YEAR(FechaNacimiento)) AS edadMinima,\n"
                        + "    ROUND(AVG(YEAR(CURDATE()) - YEAR(FechaNacimiento)), 0) AS edadMedia,\n"
                        + "    SUM(YEAR(CURDATE()) - YEAR(FechaNacimiento)) AS sumaEdades\n"
                        + "FROM \n"
                        + "    datosalumnos\n"
                        + "WHERE \n"
                        + "    FechaNacimiento IS NOT NULL";
                  request.setAttribute("consulta", "jovenviejo");
                break;
            default:
                url = "index.jsp";
                break;
        }

        try {
            if (sql != null) {
                preparada = conexion.prepareStatement(sql);
                resultado = preparada.executeQuery();
                alumnList = new ArrayList<>();
                while (resultado.next()) {
                    alumno = new Alumno();
                    alumno.setNombre(resultado.getString("nombre"));
                    alumno.setApellidos(resultado.getString("apellidos"));
                    alumno.setFechaNacimiento(resultado.getString("FechaNacimiento"));
                    alumno.setGenero(resultado.getString("Genero"));
                    alumno.setIdUsuario(resultado.getInt("IdUsuario"));
                    alumno.setCiclo(resultado.getString("Ciclo"));
                    alumnList.add(alumno);
                }
                request.setAttribute("alumnList", alumnList);
                url = "JSP/datosMysql.jsp";
            }

            if (sql_1 != null) {
                preparada = conexion.prepareStatement(sql_1);
                resultado = preparada.executeQuery();
                alumnList = new ArrayList<>();
                while (resultado.next()) {
                    alumno = new Alumno();
                    alumno.setCiclo(resultado.getString("Ciclo"));
                    alumno.setNumAlumnosMatriculados(resultado.getInt("numAlumnosMatriculados"));
                    alumnList.add(alumno);
                }
                request.setAttribute("alumnList", alumnList);
                url = "JSP/datosMysql1.jsp";

            }
            if (sql_2 != null) {
                preparada = conexion.prepareStatement(sql_2);
                resultado = preparada.executeQuery();
                cicloList = new ArrayList<>();
                while (resultado.next()) {
                    ciclo = new Ciclo();
                    ciclo.setIdCiclo(resultado.getString("IdCiclo"));
                    ciclo.setAbreviatura(resultado.getString("Abreviatura"));
                    ciclo.setHorasFCT(resultado.getInt("HorasFCT"));
                    ciclo.setLey(resultado.getString("Ley"));
                    ciclo.setNombre(resultado.getString("Nombre"));

                    cicloList.add(ciclo);

                }
                request.setAttribute("cicloList", cicloList);
                url = "JSP/datosMysql2.jsp";

            }
            if (sql_3 != null) {
                preparada = conexion.prepareStatement(sql_3);
                resultado = preparada.executeQuery();
                alumnList = new ArrayList<>();
                while (resultado.next()) {
                    alumno = new Alumno();
                    alumno.setNombre(resultado.getString("nombre"));
                    alumno.setApellidos(resultado.getString("apellidos"));
                    alumno.setEdad(resultado.getInt("edad"));

                    alumnList.add(alumno);
                }
                request.setAttribute("alumnList", alumnList);
                url = "JSP/datosMysql3.jsp";
            }
            if (sql_4 != null) {
                preparada = conexion.prepareStatement(sql_4);
                resultado = preparada.executeQuery();
                alumnList = new ArrayList<>();
                while (resultado.next()) {
                    alumno = new Alumno();
                  
                    alumno.setEdadMaxima(resultado.getInt("edadMaxima"));
                    alumno.setEdadMinima(resultado.getInt("edadMinima"));
                    alumno.setEdadMedia(resultado.getInt("edadMedia"));
                    alumno.setSumaEdades(resultado.getInt("sumaEdades"));
                    
                    alumnList.add(alumno);
                }
                request.setAttribute("alumnList", alumnList);
                url = "JSP/datosMysql4.jsp";
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexion.closeConexion();
        }

        // Redirigir a la URL adecuada
        request.getRequestDispatcher(url).forward(request, response);
    }
// </editor-fold>

}
