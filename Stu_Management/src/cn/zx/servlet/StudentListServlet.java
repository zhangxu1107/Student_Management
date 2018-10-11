package cn.zx.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zx.bean.Student;
import cn.zx.dao.StudentDao;
import cn.zx.dao.impl.StudentDaoImpl;
import cn.zx.service.StudentService;
import cn.zx.service.ipml.StudentServiceImpl;

/**
 * Servlet implementation class StudentListServlet
 */
public class StudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//1.查询出来的学生
			StudentService service = new StudentServiceImpl();
			List<Student> list = service .findAll();
			//2.先把数据存储到作用域中
			request.setAttribute("list", list);
			//3.跳转页面
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
