package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Area;
import model.Voluntario;
import service.VoluntarioService;

@WebServlet("/voluntarioController.do")
public class VoluntarioController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String acao = req.getParameter("acao");
		
		if(acao != null){
			if(acao.equals("per")){
				RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/perfilVoluntario.jsp");
				dispatcher.forward(req, resp);
			}else if(acao.equals("ong")){
				RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/ongVoluntario.jsp");
				dispatcher.forward(req, resp);
			}else if(acao.equals("pro")){
				RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/projetoVoluntario.jsp");
				dispatcher.forward(req, resp);
			}else{
				
			}
		}		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String acao = req.getParameter("acao");
		
		String id = req.getParameter("id");
		String nome = req.getParameter("nome"); 
		String email = req.getParameter("email"); 
		String senha = req.getParameter("senha"); 
		String cpf = req.getParameter("cpf"); 
		String telefone = req.getParameter("telefone"); 
		String endereco = req.getParameter("endereco");
		String dataNascimento = req.getParameter("dataNasc");
		String genero = req.getParameter("sexo"); 
		//String estadoCivil = req.getParameter("estadoCivil");
		String[] areas = req.getParameterValues("area");
		String situacao = req.getParameter("situacao");
		
		ArrayList<Area> listaArea = new ArrayList<>();
		for(int i=0; i< areas.length; i++){
			Area area = new Area();
			area.setNome(areas[i]);
			listaArea.add(area);
		}
		
		Voluntario voluntario = new Voluntario();
		if(id != null){
			voluntario.setId(Integer.parseInt(id));
		}
		voluntario.setNome(nome);
		voluntario.setEmail(email);
		voluntario.setSenha(senha);
		voluntario.setCpf(cpf);
		voluntario.setTelefone(telefone);
		voluntario.setEndereco(endereco);
		voluntario.setDataNascimento(dataNascimento);
		voluntario.setEstadoCivil("dgdsgds");
		voluntario.setGenero(genero);
		voluntario.setListaDeAreas(listaArea);
		voluntario.setSituacao(situacao);
		
		if(acao != null){
			if(acao.equals("alt")){
				
				req.setAttribute("voluntario", voluntario);
				RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/cadastrarVoluntario.jsp");
				dispatcher.forward(req, resp);
			}
		}else{

			VoluntarioService service = new VoluntarioService();
			service.salvar(voluntario);

			req.setAttribute("voluntario", voluntario);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/perfilVoluntario.jsp");
			dispatcher.forward(req, resp);
		}
	}
		
}

