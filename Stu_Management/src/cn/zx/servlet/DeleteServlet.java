package cn.zx.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zx.service.StudentService;
import cn.zx.service.ipml.StudentServiceImpl;

/**
 * ���ڴ���ɾ��ѧ��
 * @author 10831
 *
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1.����id
			int sid = Integer.parseInt(request.getParameter("sid"));
			System.out.println("ɾ����id=" + sid + "��ѧ��");
			
			//2.ִ��ɾ��
			StudentService service = new StudentServiceImpl();
			service.delete(sid);
			
			//3.��ת���б�ҳ
			request.getRequestDispatcher("StudentListServlet").forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
