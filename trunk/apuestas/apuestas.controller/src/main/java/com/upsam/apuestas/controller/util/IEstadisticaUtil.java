package com.upsam.apuestas.controller.util;

import java.util.List;

import com.upsam.apuestas.batch.bean.EstadisticaCompeticion;
import com.upsam.apuestas.controller.dto.PorraRellenadaEstadisticaDTO;
import com.upsam.apuestas.model.bean.PorraRellenada;

// TODO: Auto-generated Javadoc
/**
 * The Interface IEstadisticaUtil.
 */
public interface IEstadisticaUtil {

	/**
	 * Calcular promedio total.
	 * 
	 * @param porrasRellenadasEstadisticaDTO
	 *            the porras rellenadas estadistica dto
	 * @return the string
	 */
	String calcularPromedioTotal(
			List<PorraRellenadaEstadisticaDTO> porrasRellenadasEstadisticaDTO);

	/**
	 * Conversor de porra.
	 * 
	 * @param porraRellenada
	 *            the porra rellenada
	 * @return the porra rellenada estadistica dto
	 */
	PorraRellenadaEstadisticaDTO conversorDePorra(PorraRellenada porraRellenada);

	/**
	 * Calcular estadistica competicion.
	 * 
	 * @param porrasRellnenadas
	 *            the porras rellnenadas
	 * @return the list
	 */
	List<EstadisticaCompeticion> calcularEstadisticaCompeticion(
			List<PorraRellenada> porrasRellenadas);

	/**
	 * Calcular estadistica total.
	 * 
	 * @param porrasRellenadas
	 *            the porras rellenadas
	 * @return the string
	 */
	String calcularEstadisticaTotal(List<PorraRellenada> porrasRellenadas);
}
