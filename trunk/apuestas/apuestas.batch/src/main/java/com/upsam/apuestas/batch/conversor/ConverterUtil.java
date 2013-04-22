package com.upsam.apuestas.batch.conversor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.upsam.apuestas.batch.bean.EstadisticaCompeticion;
import com.upsam.apuestas.batch.bean.InfoUsuario;
import com.upsam.apuestas.mail.core.beans.EstadisticaCompeticionMail;
import com.upsam.apuestas.mail.core.beans.InfoUsuarioMail;

// TODO: Auto-generated Javadoc
/**
 * The Class ConverterUtil.
 */
@Component
public class ConverterUtil implements IConverterUtil {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.batch.conversor.IConverterUtil#infoUsuarioToUsuarioMail
	 * (com.upsam.apuestas.batch.bean.InfoUsuario)
	 */
	@Override
	public InfoUsuarioMail infoUsuarioToUsuarioMail(InfoUsuario usuario) {
		InfoUsuarioMail result = new InfoUsuarioMail();
		result.setEmail(usuario.getEmail());
		result.setApellidos(usuario.getApellidos());
		result.setNombre(usuario.getNombre());
		result.setPromedioTotal(usuario.getPromedioTotal());
		List<EstadisticaCompeticionMail> estadisticasCompeticionMail = new ArrayList<EstadisticaCompeticionMail>();
		EstadisticaCompeticionMail estadisticaCompeticionMail;
		for (EstadisticaCompeticion estadisticaCompeticion : usuario
				.getEstadisticaCompeticion()) {
			estadisticaCompeticionMail = new EstadisticaCompeticionMail();
			estadisticaCompeticionMail.setCompeticion(estadisticaCompeticion
					.getCompeticion());
			estadisticaCompeticionMail.setFechaLimite(estadisticaCompeticion
					.getFechaLimite());
			estadisticaCompeticionMail.setFechaRelleno(estadisticaCompeticion
					.getFechaRelleno());
			estadisticaCompeticionMail
					.setPromedioParcial(estadisticaCompeticion
							.getPromedioParcial());
			estadisticasCompeticionMail.add(estadisticaCompeticionMail);
		}
		result.setEstadisticaCompeticionMail(estadisticasCompeticionMail);
		return result;
	}

}
