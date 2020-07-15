package edu.cientifica.papeleta.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import edu.cientifica.papeleta.model.Usuario;

@Mapper
public interface UsuarioMapper {
	
	public List<Usuario> listarUsuarios();
	public Usuario findUsername(String username);
	public int actualizarUsuario(Usuario usuario);
	
	

}
