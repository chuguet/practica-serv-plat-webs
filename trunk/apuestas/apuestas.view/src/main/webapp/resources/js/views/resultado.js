var resultado = {
	'formatList' : function(estadistica) {
		$("#promedio").text(estadistica.promedioAciertos);
		var array = new Array();
		estadistica.porrasRellenadasEstadisticaDTO
				.forEach(function(porra) {
					array.push(porra.competicion);

					var vista = '<li>';

					vista = vista + "<h2>Competici&oacute;n: "
							+ porra.competicion + "</h2>";
					vista = vista + "<h5>La fecha l&iacute;mite de relleno de esta competici&oacuten es el "
					+ porra.fechaLimite + "</h5>";
					vista = vista + "<h5>Esta porra fue rellenada por &uacute;ltima vez el "
					+ porra.fechaRelleno + "</h5></br></br>";
					
					vista = vista
							+ '<table width="100%" border="1" cellpadding="0" cellspacing="1" bordercolor="#000000" style="border-collapse:separate;">';
					vista = vista + "<tr>";
					vista = vista + "<td>Ordinal</td>";
					vista = vista + "<td>Equipo local</td>";
					vista = vista + "<td>Equipo visitante</td>";
					vista = vista + "<td>Resultado Real</td>";
					vista = vista + "<td>Resultado Pronosticado</td>";
					vista = vista + "<td>Soluci&oacute;n</td>";
					vista = vista + "</tr>";
					porra.partidosRellenadosEstadisticaDTO.forEach(function(
							partido) {
						vista = vista + "<tr>";
						vista = vista + "<td>" + partido.ordinal + "</td>";
						vista = vista + "<td>" + partido.local + "</td>";
						vista = vista + "<td>" + partido.visitante + "</td>";
						vista = vista + "<td>" + partido.resultadoReal + "</td>";
						vista = vista + "<td>" + partido.resultadoPronosticado + "</td>";
						vista = vista + "<td>" + partido.solucion +"</td>";
						vista = vista + "</tr>";
					});
					vista = vista + "</table>";

					vista = vista + "<h4>Indice de aciertos: "
							+ porra.indiceAciertos + "</h4>";

					vista = vista + '</li>';

					$('#slider').append(vista).anythingSlider({
						navigationFormatter : function(index, panel) {
							return array[index - 1];
						}
					});

				});
	}
};