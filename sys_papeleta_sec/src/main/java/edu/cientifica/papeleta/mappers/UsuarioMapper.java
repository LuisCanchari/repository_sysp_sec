package edu.cientifica.papeleta.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import edu.cientifica.papeleta.model.Usuario;

@Mapper
public interface UsuarioMapper {
	
//	@Select("SELECT login_name as username, password from usuario WHERE login_name = #{usuario}")
//	public Usuario findUsername (String usuario);
	
	public List<Usuario> listarUsuarios();
	public Usuario findUsername(String username);
	
	

}
