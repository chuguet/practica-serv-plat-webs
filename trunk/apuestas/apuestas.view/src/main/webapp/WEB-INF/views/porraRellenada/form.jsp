<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript">
	porraRellenada.formatForm();
	<c:if test="${operacion == 'edit'}">
		function showInformationIntoView(porraRellenada){
			$('input[id=id]').val(porraRellenada.id);
			$('input[id=idPorra]').val(porraRellenada.idPorra);
			$('input[id=fecha_relleno]').val(porraRellenada.fechaRelleno);
			$('input[id=fecha_limite]').val(porraRellenada.fechaLimite);
			$("#marcoPrincipal").text("Competicion " + porraRellenada.competicion);
			
			var lastId = 1;
			for(var i = 0 ; i<porraRellenada.partidosRellenadosDTO.length ; i++){
				if ($('#lista').getDataIDs().length > 0) {
					lastId = parseInt($('#lista').getDataIDs().length) + 1;
				}
				if (porraRellenada.rowID == null) {
					$('#lista').jqGrid("addRowData", lastId, porraRellenada.partidosRellenadosDTO[i], "last");
				} else{
					$('#lista').jqGrid('setRowData', porra.rowID, porraRellenada.partidosRellenadosDTO[i]);
				}
			}
			$(window).bind('resize', function() {
				$('#lista').setGridWidth($('.ui-jqgrid').parent().innerWidth() - 30);
			}).trigger('resize');
		};
	</c:if>
</script>
<form id="alta">
	<fieldset>
		<legend id="marcoPrincipal"></legend>
		<input type="hidden" id="idPorra" />
		<input type="hidden" id="id" />
		<p>
			<label for="fecha_limite">Fecha l&iacute;mite:</label>
			<input readonly id="fecha_limite" class="text ui-widget-content ui-corner-all" />
		</p>
		<p>
			<label for="fecha_relleno">Fecha relleno:</label>
			<input readonly id="fecha_relleno" class="text ui-widget-content ui-corner-all" />
		</p>
		
		<fieldset>
			<legend>Partidos</legend>
			<table id="lista"></table>
			<div id="paginadorLista"></div>
		</fieldset>
		
		<div class="botonera">
			<input type="button" id="btnAceptar" value="Aceptar" />
			<input type="button" id="btnAsigResul" value="Asignar Resultado" />
			<input type="button" id="btnCancel" value="Cancelar" />
		</div>
	</fieldset>
</form>

<div id="dialog-form-resultado" title="Resultado">
	<form id="frmResultado">
		<div id="tabs-resultado">
			<a>1: </a><input type="radio" name="resul" value="1">Victoria Local<br>
			<a>X: </a><input type="radio" name="resul" value="X">Empate<br>
			<a>2: </a><input type="radio" name="resul" value="2">Victoria Visitante
		</div>
	</form>
</div>