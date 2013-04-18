package com.upsam.apuestas.controller.dto.util.impl;

import org.springframework.stereotype.Component;

import com.upsam.apuestas.batch.bean.InfoUsuario;
import com.upsam.apuestas.controller.dto.UsuarioDTO;
import com.upsam.apuestas.controller.dto.util.IUsuarioUtilDTO;
import com.upsam.apuestas.model.bean.Rol;
import com.upsam.apuestas.model.bean.Usuario;
import com.upsam.apuestas.model.exception.AppException;

// TODO: Auto-generated Javadoc
/**
 * The Class DataTransferObjectUsuario.
 */
@Component
public class UsuarioUtilDTO implements IUsuarioUtilDTO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.controller.dto.util.IUsuarioUtilDTO#toBusiness(com
	 * .upsam.apuestas.controller.dto.UsuarioDTO)
	 */
	@Override
	public Usuario toBusiness(UsuarioDTO usuarioDTO) throws AppException {
		Usuario usuario = new Usuario();
		usuario.setId(usuarioDTO.getId());
		usuario.setNombre(usuarioDTO.getNombre());
		usuario.setApellidos(usuarioDTO.getApellidos());
		if (usuarioDTO.getRol().equals(Rol.ROLE_ADMIN.getNameId())) {
			usuario.setRol(Rol.ROLE_ADMIN);
		} else if (usuarioDTO.getRol().equals(Rol.ROLE_USER.getNameId())) {
			usuario.setRol(Rol.ROLE_USER);
		}
		usuario.setUser(usuarioDTO.getUser());
		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setPassword(usuarioDTO.getPassword());
		return usuario;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.controller.dto.util.IUsuarioUtilDTO#toRest(com.upsam
	 * .apuestas.model.bean.Usuario)
	 */
	@Override
	public UsuarioDTO toRest(Usuario usuario) throws AppException {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setId(usuario.getId());
		usuarioDTO.setNombre(usuario.getNombre());
		usuarioDTO.setApellidos(usuario.getApellidos());
		usuarioDTO.setRol(usuario.getRol().getNameId());
		usuarioDTO.setUser(usuario.getUser());
		usuarioDTO.setPassword(usuario.getPassword());
		usuarioDTO.setEmail(usuario.getEmail());
		return usuarioDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.controller.dto.util.IUsuarioUtilDTO#toInfoUsuario(
	 * com.upsam.apuestas.model.bean.Usuario)
	 */
	@Override
	public InfoUsuario toInfoUsuario(Usuario usuario) throws AppException {
		InfoUsuario result = new InfoUsuario();
		result.setEmail(usuario.getEmail());
		return result;
	}
}
