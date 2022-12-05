package br.com.TaskManager.services;

import br.com.TaskManager.controllers.request.UsuarioRequest;
import br.com.TaskManager.controllers.response.UsuarioResponse;
import br.com.TaskManager.entities.Departamento;
import br.com.TaskManager.entities.Funcao;
import br.com.TaskManager.entities.Usuario;
import br.com.TaskManager.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    DepartamentoService departamentoService;

    FuncaoService funcaoService;

    public UsuarioResponse findUsuarioRequestById(Long idUsuario){
        UsuarioResponse usuarioResponse =  new UsuarioResponse();
        Usuario usuario = findById(idUsuario);
        usuarioResponse.setId_usuario(usuario.getId_usuario());
        usuarioResponse.setNm_usuario(usuario.getNm_usuario());
        usuarioResponse.setTipo_usuario(usuario.getTipo_usuario());
        usuarioResponse.setDepartamento_id(usuario.getDepartamento().getId_departamento());
        usuarioResponse.setFuncao_id(usuario.getFuncao().getId_funcao());
        return usuarioResponse;
    }

    public Usuario findById(Long idUsuario) {
        Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
        if(usuario.isEmpty())
            return null;
        return usuario.get();
    }

    public List<UsuarioResponse> findAll(){
        List<UsuarioResponse> listaUsuarioResponse = new ArrayList<>();
        List<Usuario> listaUsuario = usuarioRepository.findAll();

        for (Usuario usuario :  listaUsuario){
            listaUsuarioResponse.add(new UsuarioResponse(
                    usuario.getId_usuario(),
                    usuario.getNm_usuario(),
                    usuario.getFuncao().getId_funcao(),
                    usuario.getDepartamento().getId_departamento(),
                    usuario.getTipo_usuario()
            ));
        }
        return listaUsuarioResponse;
    }


    public void save(UsuarioRequest request) throws Exception{
        Departamento departamento = departamentoService.findDepartamentoById(request.getDepartamento_id());
        Funcao funcao = funcaoService.getFuncaoById(request.getFuncao_id());
        usuarioRepository.save(new Usuario(
                usuarioRepository.count()+1,
                request.getNm_usuario(),
                funcao,
                departamento,
                request.getTipo_usuario()

                ));
    }
    public void delete(Long  requestId)throws Exception{

        usuarioRepository.deleteById(requestId);


    }

}
