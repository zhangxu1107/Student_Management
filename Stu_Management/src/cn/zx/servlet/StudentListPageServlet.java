package cn.zx.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zx.bean.PageBean;
import cn.zx.service.StudentService;
import cn.zx.service.ipml.StudentServiceImpl;

/**
 * 
 * �������ڷ�ҳ��ʾѧ���б��servlet
 * 
 * @author 10831
 *
 */
public class StudentListPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1. ��ȡ��Ҫ��ʾ��ҳ����
			int currentPage =Integer.parseInt( request.getParameter("currentPage"));
			
			//2. ����ָ����ҳ����ȥ��ȡ��ҳ�����ݻ���
			//List<Student> --- list.jsp
			
			StudentService service = new StudentServiceImpl();
			PageBean pageBean= service.findStudentByPage(currentPage);
			request.setAttribute("pageBean", pageBean);
			//3. ��ת���档
			request.getRequestDispatcher("list_page.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
