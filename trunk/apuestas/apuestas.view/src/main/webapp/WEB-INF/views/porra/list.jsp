<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<fieldset id="parent">
	<legend>Listado de Porras</legend>

	<fieldset>
		<legend>Buscador de Porras</legend>
		<div class="buscador">
			<p>
				<label for="competicion">Competici&oacute;n:</label> 
				<input id="competicion" onkeyup="porra.buscar($('input[id=competicion]').val(),$('input[id=equipo]').val())" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
				<label for="equipo">Equipo:</label>
				<input id="equipo" onkeyup="porra.buscar($('input[id=competicion]').val(),$('input[id=equipo]').val())" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" /> 
			</p>
		</div>
	</fieldset>
	<div class="botonera">
		<input type="button" id="btnAlta" value="Alta" /> 
		<input type="button" id="btnEditar" value="Editar" />
		<input type="button" id="btnEliminar" value="Eliminar" />
	</div>
	<table id="lista"></table>
	<div id=paginadorLista></div>
</fieldset>

<script type="text/javascript">
	porra.formatList();
	function showInformationIntoView(information) {
		$("#lista").jqGrid("clearGridData", true).trigger("reloadGrid");
		$("#lista").setGridParam({
			data : information
		}).trigger('reloadGrid');
		$(window).bind('resize', function() {
			$('#lista').setGridWidth($('.ui-jqgrid').parent().innerWidth() - 30);
		}).trigger('resize');
	};
</script>