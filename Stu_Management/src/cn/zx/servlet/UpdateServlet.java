package cn.zx.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zx.bean.Student;
import cn.zx.service.StudentService;
import cn.zx.service.ipml.StudentServiceImpl;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			//1. ��ȡ�ͻ����ύ����������
			int sid = Integer.parseInt(request.getParameter("sid"));
			String sname = request.getParameter("sname"); //sname:zhangsan
			int age = Integer.parseInt(request.getParameter("age"));
			String gender = request.getParameter("gender");
			String phone = request.getParameter("phone");
			String birthday = request.getParameter("birthday"); // 1989-10-18
			String info = request.getParameter("info");
			//String hobby = request.getParameter("hobby");//hobby : ��Ӿ��д�֣� ����
			String[] h = request.getParameterValues("hobby");
			//		[��������д��] --- ��������д��
			String hobby = Arrays.toString(h);
			hobby = hobby.substring(1, hobby.length() - 1);
			//2. ��ӵ����ݿ�
			//string -- date
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			Student student = new Student(sid ,sname, gender , age, phone, hobby, info, date);
			
			//2. �������ݿ�����
			StudentService service = new StudentServiceImpl();
			service.update(student);
			
			//3. ��ת����
			request.getRequestDispatcher("StudentListServlet").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
