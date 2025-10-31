package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBconnect;
import com.Dao.PostDao;

@WebServlet("/EditNotesServlet")
public class EditNotesServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			Integer noteid = Integer.parseInt(request.getParameter("noteid"));
			String Title=request.getParameter("title");
			String Content=request.getParameter("content");
			
	
			PostDao dao = new PostDao(DBconnect.getConn());
			boolean f= dao.PostUpate(noteid, Title, Content);
			
			if(f)
			{
				System.out.println("data update sucessfully");
				HttpSession session = request.getSession();
				session.setAttribute("updateMsg", "Notes Update Sucessfully");
			     response.sendRedirect("showNotes.jsp");
			}else
			{
				System.out.println("data not updated");
			}
		}catch(Exception e)
		{
		e.printStackTrace();	
		}
	}

}
