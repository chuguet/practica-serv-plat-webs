var resultado = {
	'formatList' : function(estadistica) {
		$("#promedio").text(estadistica.promedioAciertos);
		var array = new Array();
		estadistica.porrasRellenadasEstadisticaDTO
				.forEach(function(porra) {
					array.push(porra.competicion);

					var vista = '<li>';

					vista = vista + "<h2>Competici&oacute;n: " + "<i>"
							+ porra.competicion + "</i>" + "</h2>";
					vista = vista
							+ "<h5>La fecha l&iacute;mite de relleno de esta competici&oacuten es el "
							+ porra.fechaLimite + "</h5>";
					vista = vista
							+ "<h5>Esta porra fue rellenada por &uacute;ltima vez el "
							+ porra.fechaRelleno + "</h5></br>";

					vista = vista
							+ '<table border-style="ridge" width="100%" border="5" cellpadding="3" cellspacing="1" bordercolor="olive" style="border-collapse:separate;">';
					vista = vista + "<tr>";
					vista = vista + "<td><b>Ordinal</b></td>";
					vista = vista + "<td><b>Equipo local</b></td>";
					vista = vista + "<td><b>Equipo visitante</b></td>";
					vista = vista + "<td><b>Resultado Real</b></td>";
					vista = vista + "<td><b>Resultado Pronosticado</b></td>";
					vista = vista + "<td><b>Soluci&oacute;n</b></td>";
					vista = vista + "</tr>";
					porra.partidosRellenadosEstadisticaDTO.forEach(function(
							partido) {
						var color = "olive";
						if (partido.solucion == "Acertado") {
							color = "blue";
						} else if (partido.solucion == "Fallado") {
							color = "red";
						}
						vista = vista + "<tr style='color:" + color + ";'>";
						vista = vista + "<td>" + partido.ordinal + "</td>";
						vista = vista + "<td>" + partido.local + "</td>";
						vista = vista + "<td>" + partido.visitante + "</td>";
						vista = vista + "<td align='center'>"
								+ partido.resultadoReal + "</td>";
						vista = vista + "<td align='center'>"
								+ partido.resultadoPronosticado + "</td>";
						vista = vista + "<td align='right'>" + partido.solucion
								+ "</td>";
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