package cn.zx.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zx.bean.Student;
import cn.zx.service.StudentService;
import cn.zx.service.ipml.StudentServiceImpl;

/**
 * ģ����ѯ
 * Servlet implementation class SearchStudentServlet
 */
public class SearchStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			//1. ȡ����Ҫ��ѯ�Ĺؼ����� ����  �� �Ա�
			String sname=  request.getParameter("sname");
			String sgender=  request.getParameter("sgender");
			
			//2. ��serviceȥ��ѯ
			StudentService service = new StudentServiceImpl();
			List<Student> list = service.searchStudent(sname, sgender);
			
			
			System.out.println("list�Ĵ�С�ǣ�"+list.size());
			for (Student student : list) {
				System.out.println("stu="+student);
			}
			
			request.setAttribute("list", list);
			
			//3. ��ת���档�б����
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
