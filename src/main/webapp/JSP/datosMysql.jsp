
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"/>
<!DOCTYPE html>
<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="session"/>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos Mysql</title>
        <link href="https://cdn.jsdelivr.net/npm/daisyui@4.10.1/dist/full.min.css" rel="stylesheet" type="text/css"/>
        <script src="https://cdn.tailwindcss.com"></script>
    </head>
    <body class="bg-green-200 flex items-center justify-center min-h-screen">
        <div class="w-full max-w-4xl p-6 bg-white rounded-lg shadow-lg">
            <h1 class="text-4xl font-black text-blue-900 mb-6 text-center ">Consultas de Alumnos y Ciclos</h1>

            <c:choose>
                <c:when test="${consulta == 'diezprimeros'}">
                    <h2 class="text-3xl font-black text-blue-700 mb-6 text-center mb-4 ">Los Diez primeros alumnos clasificados alfabéticamente</h2>
                </c:when>
                <c:when test="${consulta == 'alumnasmenores'}">
                    <h2 class="text-3xl font-black text-blue-700 mb-6 text-center mb-4 ">Alumnas que tengan menos de 20 años</h2>
                </c:when>
                <c:when test="${consulta == 'apellidosuperior'}">
                    <h2 class="text-3xl font-black text-blue-700 mb-6 text-center mb-4 ">Alumnos con un apellido que estén cursando un ciclo de grado superior</h2>
                </c:when>
                <c:otherwise>
                    <h2 class="text-3xl font-black text-blue-700 mb-6 text-center mb-4">Resultados</h2>
                </c:otherwise>
            </c:choose>       

            <table class="min-w-full bg-white border border-gray-300">                             
                <thead>
                    <tr class="text-xl font-black text-blue-700 bg-blue-400">
                        <th class="py-2 px-4 border-b">Nombre</th>
                        <th class="py-2 px-4 border-b">Apellidos</th>
                        <th class="py-2 px-4 border-b">Fecha Nacimiento</th>
                        <th class="py-2 px-4 border-b">Genero</th>
                        <th class="py-2 px-4 border-b">idUsuario</th>
                        <th class="py-2 px-4 border-b">Ciclo</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="alum" items="${alumnList}" varStatus="status">
                        <tr class="${status.index % 2 == 0 ? 'bg-blue-100' : 'bg-white'} text-lg font-bold text-blue-500">
                            <td class="py-2 px-4 border-b"><c:out value="${alum.nombre}" /></td>
                            <td class="py-2 px-4 border-b"><c:out value="${alum.apellidos}" /></td>
                            <td class="py-2 px-4 border-b"><c:out value="${alum.fechaNacimiento}" /></td>
                            <td class="py-2 px-4 border-b"><c:out value="${alum.genero}" /></td>
                            <td class="py-2 px-4 border-b"><c:out value="${alum.idUsuario}" /></td>
                            <td class="py-2 px-4 border-b"><c:out value="${alum.ciclo}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <form action="<c:out value="${contextPath}" />/Return" method="post" class="mt-4 text-center">
                <button type="submit" class="bg-blue-500 text-white font-bold py-2 px-4 rounded hover:bg-blue-700 transition duration-300 ease-in-out">
                    Volver al inicio
                </button>
            </form>
        </div>
    </body>
</html>

