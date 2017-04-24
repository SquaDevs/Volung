package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import model.OrganizacaoSocial;
import service.OrganizacaoSocialService;

@WebServlet("/osController.do")
public class OrganizacaoSocialController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		
		String acao = req.getParameter("acao");
		
		if(acao != null){
			if(acao.equals("buscaTodos")){

				Gson gson = new Gson();
				OrganizacaoSocialService service = new OrganizacaoSocialService();
				resp.getWriter().print(gson.toJson(service.selecionarTodos()));
				resp.getWriter().flush();
				resp.getWriter().close();
			}else if(acao.equals("busca")){
				
				String param = req.getParameter("id");
				if(param != null){
					Integer id = Integer.parseInt(param);
					
					Gson gson = new Gson();
					OrganizacaoSocialService service = new OrganizacaoSocialService();
					OrganizacaoSocial social = service.selecionar(id);
					
					resp.getWriter().print(gson.toJson(social));
					resp.getWriter().flush();
					resp.getWriter().close();
				}
			}
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String acao = req.getParameter("acao");
		
		String nomeOng = req.getParameter("nomeOng");
		String razaoSocial = req.getParameter("razaoSocial");
		String cnpj = req.getParameter("cnpj");
		String endereco = req.getParameter("endereco");
		String telefone = req.getParameter("telefone");
		String email = req.getParameter("email");
		String atividadesInicio = req.getParameter("atividadesInicio");
		
		OrganizacaoSocial organizacaoSocial = new OrganizacaoSocial();
		organizacaoSocial.setNome(nomeOng);
		organizacaoSocial.setRazaoSocial(razaoSocial);
		organizacaoSocial.setCnpj(cnpj);
		organizacaoSocial.setEndereco(endereco);
		organizacaoSocial.setTelefone(telefone);
		organizacaoSocial.setEmail(email);
		organizacaoSocial.setDataInicio(atividadesInicio);
		organizacaoSocial.setSituacao("Ativa");
		
		if(acao != null){
			if(acao.equals("alt")){
				
				OrganizacaoSocialService osService = new OrganizacaoSocialService();
				osService.alterar(organizacaoSocial);
			}
		}else{
			HttpSession session = req.getSession();
			
			OrganizacaoSocialService osService = new OrganizacaoSocialService();
			Integer id = osService.inserir(organizacaoSocial);
			organizacaoSocial.setId(id);
			
			session.setAttribute("organizacaoSocial", organizacaoSocial);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/cadastroGestor.jsp");
			dispatcher.forward(req, resp);
			
			
		}
	}
}
