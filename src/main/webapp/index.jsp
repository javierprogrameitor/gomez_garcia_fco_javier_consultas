<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"/>
<!DOCTYPE html>
<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="session"/>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/daisyui@4.10.1/dist/full.min.css" rel="stylesheet" type="text/css"/>
        <script src="https://cdn.tailwindcss.com"></script>
        <title>Conexion</title>
    </head>
    <body class="flex bg-green-200 flex items-start justify-center h-screen columns-1 pt-10">
        <div class="flex flex-col items-center justify-center text-xl font-bold">

            <h1 class="m-4 text-3xl font-black text-blue-900">Alumnos y ciclos de Formación Profesional</h1>

            <form id="form1" action="<c:out value="${contextPath}" />/FrontController" method="post">
                <div class="flex">
                    <button type="submit" class="underline text-blue-400 hover:text-blue-800">-- Diez primeros alumnos clasificados alfabeticamente</button>
                    <input type="hidden" name="consulta" value="diezprimeros">
                </div>
            </form>

            <form id="form2" action="<c:out value="${contextPath}" />/FrontController" method="post">
                <div class="flex">
                    <button type="submit" class="underline text-blue-400 hover:text-blue-800">-- Alumnas que tengan menos de 20 años</button>
                    <input type="hidden" name="consulta" value="alumnasmenores">
                </div>
            </form>

            <form id="form2" action="<c:out value="${contextPath}" />/FrontController" method="post">
                <div class="flex">
                    <button type="submit" class="underline text-blue-400 hover:text-blue-800">-- Alumnos con un apellido que estén cursando un ciclo de grado superior</button>
                    <input type="hidden" name="consulta" value="apellidosuperior">
                </div>
            </form>

            <form id="form2" action="<c:out value="${contextPath}" />/FrontController" method="post">
                <div class="flex">
                    <button type="submit" class="underline text-blue-400 hover:text-blue-800">-- Numero de alumnos en cada ciclo</button>
                    <input type="hidden" name="consulta" value="numeroalumnociclo">
                </div>
            </form>
            <form id="form2" action="<c:out value="${contextPath}" />/FrontController" method="post">
                <div class="flex">
                    <button type="submit" class="underline text-blue-400 hover:text-blue-800">-- Ciclo cuya abreviatura sea 4 caracteres y 400 horas</button>
                    <input type="hidden" name="consulta" value="abreviaturacuatro">
                </div>
            </form>
            <form id="form2" action="<c:out value="${contextPath}" />/FrontController" method="post">
                <div class="flex">
                    <button type="submit" class="underline text-blue-400 hover:text-blue-800">--Alumnos varones cuya edad sea inferior a la media aritmética en años, que hayan nacido en un año par y en domingo. </button>
                    <input type="hidden" name="consulta" value="edadaritmetica">
                </div>
            </form>
            <form id="form2" action="<c:out value="${contextPath}" />/FrontController" method="post">
                <div class="flex">
                    <button type="submit" class="underline text-blue-400 hover:text-blue-800">--Edad en años del alumno más viejo, la edad en años del alumno más joven, la media aritmética de las edades en años redondeada a cero decimales y la suma de las edades en años de los alumnos.  </button>
                    <input type="hidden" name="consulta" value="jovenviejo">
                </div>
            </form>
        </div>
    </body>
</html>