package cn.zx.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zx.bean.Student;
import cn.zx.service.StudentService;
import cn.zx.service.ipml.StudentServiceImpl;

/**
 * ������ѧ���ĸ��£� ��ѯһ��ѧ������Ϣ��Ȼ����ת������ҳ��
 * @author 10831
 *
 */
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1. ����id
			int sid = Integer.parseInt(request.getParameter("sid"));
			
			//2. ��ѯѧ������
			StudentService service = new StudentServiceImpl();
			Student stu = service.findStudentById(sid);
			
			//3. ��ʾ����
			//������
			request.setAttribute("stu", stu);
			//��ת
			request.getRequestDispatcher("edit.jsp").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
