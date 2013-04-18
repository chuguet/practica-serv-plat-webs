package com.upsam.apuestas.controller.dto.util.impl;

import com.upsam.apuestas.model.bean.Resultado;

// TODO: Auto-generated Javadoc
/**
 * The Class ResultadoUtil.
 */
public abstract class ResultadoUtil {

	/**
	 * Gets the resultado by name id.
	 * 
	 * @param nameId
	 *            the name id
	 * @return the resultado by name id
	 */
	protected Resultado getResultadoByNameId(String nameId) {
		Resultado result = null;
		if (nameId.equals(Resultado.UNO.getNameId())) {
			result = Resultado.UNO;
		} else if (nameId.equals(Resultado.X.getNameId())) {
			result = Resultado.X;
		} else if (nameId.equals(Resultado.DOS.getNameId())) {
			result = Resultado.DOS;
		}
		return result;
	}
}
