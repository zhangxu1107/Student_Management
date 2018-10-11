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
 * ���ڴ���ѧ�����������
 * @author 10831
 *
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		
		try {

			//1. ��ȡ�ͻ����ύ����������
			String sname = request.getParameter("sname"); //sname:zhangsan
			String gender = request.getParameter("gender");
			int age = Integer.parseInt(request.getParameter("age"));
			String phone = request.getParameter("phone");
			String birthday = request.getParameter("birthday"); // 1989-10-18
			String info = request.getParameter("info");
			//String hobby = request.getParameter("hobby");//hobby : ��Ӿ��д�֣� ����
			String [] h  = request.getParameterValues("hobby");
//			[��������д��] --- ��������д��
			
			String hobby = Arrays.toString(h);
			hobby = hobby.substring(1, hobby.length()-1);
			
			//2. ��ӵ����ݿ�
			//string -- date
			Date date= new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			
			Student student = new Student(sname, gender, age, phone, hobby, info, date);
			StudentService service = new StudentServiceImpl();
			service.insert(student);
			
			//3. ��ת���б�ҳ
			//�ٲ�һ�����ݿ⣬Ȼ����װ���������� ��Ȼ������ת��
			//������ֱ����ת��ҳ���ϣ� ��ô���ҳ������·���һ�Σ�������Ǹ�request�������ŵ�������û���ˡ� 
			//request.getRequestDispatcher("list.jsp").forward(request, response);
			
			//servlet��������jsp֮�⡣ ������servlet
			request.getRequestDispatcher("StudentListServlet").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
