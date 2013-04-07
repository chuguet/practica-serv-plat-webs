var porraRellenada = {
	'rowID' : null,
	'formatList' : function() {
		
		$("#lista").jqGrid({
			datatype : 'local',
			data : [],
			colNames : [
					"Id", "Competici&oacute;n", "Fecha L&iacute;mite"
			],
			colModel : [
					{
						name : 'id',
						index : 'id',
						width : 0,
						hidden : true
					}, {
						name : 'competicion',
						index : 'competicion',
						width : 80,
						sorttype : 'string',
						sortable : true,
						align : 'left'
					}, {
						name : 'fechaLimite',
						index : 'fechaLimite',
						width : 40,
						sorttype : 'string',
						sortable : true,
						align : 'right'
					}
			],
			rowNum : 20,
			rowList : [
					10, 20, 30
			],
			pager : '#paginadorLista',
			sortname : 'apellidos',
			sortorder : 'asc',
			viewrecords : true,
			rownumbers : false,
			scroll : false,
			onSelectRow : function(rowid, status) {
				$("#btnRellenar").button("enable");
				porraRellenada.rowID = rowid;
			}
		});
		$(window).bind('resize', function() {
			$('#lista').setGridWidth($('.ui-jqgrid').parent().innerWidth() - 30);
		}).trigger('resize');
		
		/**
		 * *****Configuración de los botones del Listado de porras**********
		 */
		
		$("#btnRellenar").button().click(function() {
			generic.getForm('porraRellenada', $('#lista').jqGrid('getRowData', porraRellenada.rowID).id);
		});
		$("#btnRellenar").button("disable");
	},

	'formatForm' : function() {
		this.rowID = null;
		
		$("#lista").jqGrid({
			datatype : 'local',
			data : [],
			colNames : [
					"Id", "Orden", "Local", "Visitante", "Resultado"
			],
			colModel : [
					{
						name : 'id',
						index : 'id',
						width : 0,
						hidden : true
					}, {
						name : 'ordinal',
						index : 'ordinal',
						width : 30,
						sorttype : 'string',
						sortable : true,
						align : 'left'
					}, {
						name : 'local',
						index : 'local',
						width : 30,
						sorttype : 'string',
						sortable : true,
						align : 'left'
					}, {
						name : 'visitante',
						index : 'visitante',
						width : 30,
						sorttype : 'string',
						sortable : true,
						align : 'left'
					}, {
						name : 'resultado',
						index : 'resultado',
						width : 30,
						sorttype : 'string',
						sortable : true,
						align : 'center'
					}
			],
			rowNum : 20,
			rowList : [
					10, 20, 30
			],
			pager : '#paginadorLista',
			sortname : 'nombre',
			sortorder : 'asc',
			viewrecords : true,
			rownumbers : false,
			scroll : false,
			onSelectRow : function(rowid, status) {
				$("#btnAsigResul").button("enable");
				porraRellenada.rowID = rowid;
			}
		});
		
		$(window).bind('resize', function() {
			$('#lista').setGridWidth($('.ui-jqgrid').parent().innerWidth() - 30);
		}).trigger('resize');
		
		$("#btnCancel").button().click(function() {
			generic.getList('porraRellenada');
		});
		
		$("#btnAceptar").button().click(function() {
			porraRellenada.getParams();
		});
		
		$("#btnAsigResul").button().click(function() {
			$('#dialog-form-resultado').dialog('option', 'title', 'Asignar Resultado');
			$("#dialog-form-resultado").dialog("open");
			$('input:radio[name=resul]')[0].checked = true;
		});

		$("#btnAsigResul").button("disable");
		
		$("#tabs-resultado").tabs();
		
		$("#dialog-form-resultado").dialog({
			autoOpen : false,
			height : 210,
			width : 300,
			modal : true,
			buttons : {
				"Aceptar" : function() {
					var resultado = {
						resultado : $("input[name='resul']:checked").val(),
					};
					
					if (resultado.resultado != null) {
						$('#lista').jqGrid('setRowData', porraRellenada.rowID, resultado);
					}

					$(this).dialog("close");
				},
				"Cancelar" : function() {
					$(this).dialog("close");
				}
			},
			close : function() {
			}
		});
		
	},
	'deseleccionarPartido' : function(){
		this.rowID = null;
		$('#lista').jqGrid('resetSelection');
		$("#btnAsigResul").button("disable");
	},
	'getParams' : function() {
		var idPorra = $("#idPorra").val();
		var id = ($("#id").val()) ? $("#id").val() : null;
		var partidosRellenados = $('#lista').jqGrid('getRowData');
		
		var errores = '';
		if (errores != '') {
			jAlert(errores, "Validaci&oacute;n");
		}
		else {
			var porraRellenada = {
				id : id,
				idPorra : idPorra,
				partidosRellenadosDTO : partidosRellenados
			};
			
			var entity = (id != null) ? 'porraRellenada/' + id : 'porraRellenada';
			generic.post(entity, porraRellenada, function() {
				generic.getList('porraRellenada');
			});
		};
	},'buscar' : function(competicion, equipo) {
		var data = {
			competicion : competicion,
			equipo : equipo
		};
		generic.post('porraRellenada/busqueda',data,generic.showInformation);
	}
};