package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.ProjetoService;

@WebServlet("/projetoController.do")
public class ProjetoController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		
		String acao = req.getParameter("acao");
		
		if(acao != null){
			if(acao.equals("buscaOngProj")){
				
				String param = req.getParameter("idOs");
				
				if(param != null){
					
					Integer idos = Integer.parseInt(param);
					
					Gson gson = new Gson();
					ProjetoService projetoService = new ProjetoService();

					resp.getWriter().print(gson.toJson(projetoService.selecionarPorOs(idos)));
					resp.getWriter().flush();
					resp.getWriter().close();
				}
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
