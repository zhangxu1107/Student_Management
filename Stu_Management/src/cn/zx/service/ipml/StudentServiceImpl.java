package cn.zx.service.ipml;

import java.sql.SQLException;
import java.util.List;

import cn.zx.bean.Student;
import cn.zx.dao.StudentDao;
import cn.zx.dao.impl.StudentDaoImpl;
import cn.zx.service.StudentService;

/**
 * 这是学生业务实现
 * @author 10831
 *
 */
public class StudentServiceImpl implements StudentService{

	//查询所有学生
	@Override
	public List<Student> findAll() throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.findAll();
	}

	//添加学生
	@Override
	public void insert(Student student) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		dao.insert(student);
	}

	//删除学生
	@Override
	public void delete(int sid) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		dao.delete(sid);
	}

	//按id查询单个学生
	@Override
	public Student findStudentById(int sid) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.findStudentById(sid);
	}

	//更新学生信息
	@Override
	public void update(Student student) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		dao.update(student);
	}

}
