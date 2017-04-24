package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Gestor;
import model.OrganizacaoSocial;
import service.GestorService;

@WebServlet("/gestorController.do")
public class GestorController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		OrganizacaoSocial social = (OrganizacaoSocial) session.getAttribute("organizacaoSocial");
		
		String acao = req.getParameter("acao");
		
		String id = req.getParameter("id");
		String nome = req.getParameter("nomeGestor");
		String cpf = req.getParameter("cpfGestor");
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		GestorService gestorService = new GestorService();
		Gestor gestor = new Gestor();
		if(id != null){
			gestor.setId(Integer.parseInt(id));
		}
		if(social != null){
			gestor.setOng(social);
		}
		gestor.setNome(nome);
		gestor.setCpf(cpf);
		gestor.setEmail(email);
		gestor.setSenha(senha);
		gestor.setDataNascimento("asdasdas");
		gestor.setTelefone("ddfsadfasdf");
		
		if(acao != null){

			if(acao.equals("cad")){
	
			}
		}else{

			gestorService.inserir(gestor);
			req.setAttribute("gestor", gestor);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/perfilGestor.jsp");
			dispatcher.forward(req, resp);
			
		}

	}
}
