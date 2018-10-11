package cn.zx.service.ipml;

import java.sql.SQLException;
import java.util.List;

import cn.zx.bean.Student;
import cn.zx.dao.StudentDao;
import cn.zx.dao.impl.StudentDaoImpl;
import cn.zx.service.StudentService;

/**
 * ����ѧ��ҵ��ʵ��
 * @author 10831
 *
 */
public class StudentServiceImpl implements StudentService{

	//��ѯ����ѧ��
	@Override
	public List<Student> findAll() throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.findAll();
	}

	//���ѧ��
	@Override
	public void insert(Student student) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		dao.insert(student);
	}

	//ɾ��ѧ��
	@Override
	public void delete(int sid) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		dao.delete(sid);
	}

	//��id��ѯ����ѧ��
	@Override
	public Student findStudentById(int sid) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.findStudentById(sid);
	}

	//����ѧ����Ϣ
	@Override
	public void update(Student student) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		dao.update(student);
	}

}
