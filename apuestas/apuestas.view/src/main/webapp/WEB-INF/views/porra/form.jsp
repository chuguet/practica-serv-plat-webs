<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript">
	porra.formatForm();
	<c:if test="${operacion == 'edit'}">
		function showInformationIntoView(porra){
			$('input[id=id]').val(porra.id);
			$('input[id=fecha_limite]').val(porra.fechaLimite);
			$('input[id=competicion]').val(porra.competicion);
			$("#lista").setGridParam({
				data : porra.partidosDTO
			}).trigger("reloadGrid");
			$(window).bind('resize', function() {
				$('#lista').setGridWidth($('.ui-jqgrid').parent().innerWidth() - 30);
			}).trigger('resize');
			
			if(porra.publicada == "Si"){
				$("#btnAddPartido").hide();
				$("#btnModifyPartido").hide();
				$("#btnDeletePartido").hide();
			}
		};
	</c:if>
</script>
<form id="alta">
	<fieldset>
		<legend>
		<c:choose>
			<c:when test="${operacion == 'new'}">Alta de Porra</c:when>
			<c:otherwise>Vista Porra</c:otherwise>
		</c:choose>
		</legend>
		<input type="hidden" id="id" />
		<p>
			<label for="competicion">Competci&oacute;n:</label>
			<input id="competicion" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			<label for="fecha_limite">Fecha l&iacute;mite:</label>
			<input id="fecha_limite" class="text ui-widget-content ui-corner-all" />
		</p>
		
		<fieldset>
			<legend>Partidos</legend>
			<table id="lista"></table>
			<div id="paginadorLista"></div>
		</fieldset>
		
		<div class="botonera">
			<c:choose>
				<c:when test="${operacion == 'new'}">
					<input type="button" id="btnSavePorra" value="Guardar" />
				</c:when>
				<c:otherwise>
					<input type="button" id="btnSavePorra" value="Modificar" />
				</c:otherwise>
			</c:choose>
			<input type="button" id="btnAddPartido" value="Añadir Partido" />
			<input type="button" id="btnModifyPartido" value="Modificar Partido" />
			<input type="button" id="btnDeletePartido" value="Borrar Partido" />
			<input type="button" id="btnAsigResul" value="Asignar Resultado" />
			<input type="button" id="btnCancel" value="Cancelar" />
		</div>
	</fieldset>
</form>

<div id="dialog-form-partido" title="Partido">
	<form id="frmPartido">
		<div id="tabs-partido">
			<label for="ordinal">N&uacute;mero:</label>
			<input id="ordinal" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			<label for="local">Local:</label>
			<input id="local" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			<label for="visitante">Visitante:</label>
			<input id="visitante" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
		</div>
	</form>
</div>

<div id="dialog-form-resultado-real" title="Resultado">
	<form id="frmResultadoReal">
		<div id="tabs-resultado-real">
			<a>1: </a><input type="radio" name="resul" value="1">Victoria Local<br>
			<a>X: </a><input type="radio" name="resul" value="X">Empate<br>
			<a>2: </a><input type="radio" name="resul" value="2">Victoria Visitante
		</div>
	</form>
</div>