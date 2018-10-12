package cn.zx.service.ipml;

import java.sql.SQLException;
import java.util.List;

import cn.zx.bean.PageBean;
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

	////模糊查询， 根据姓名或者根据性别，或者两者兼有。 
	@Override
	public List<Student> searchStudent(String sname, String sgender) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.searchStudent(sname, sgender);
	}

	//查询当页的数据
	@Override
	public PageBean findStudentByPage(int currentPage) throws SQLException {
		//封装分页的该页数据
		PageBean<Student> pageBean = new PageBean<Student>();
		
		int pageSize = StudentDao.PAGE_SIZE ;
		pageBean.setCurrentPage(currentPage); //设置当前页
		pageBean.setPageSize(pageSize); //设置每页显示多少记录
		
		StudentDao dao = new StudentDaoImpl() ;
		List<Student> list =dao .findStudentByPage(currentPage);
		pageBean.setList(list); //设置这一页的学生数据
		
		//总的记录数， 总的页数。
		int count = dao.findCount();
		pageBean.setTotalSize(count); //设置总的记录数
		//200 ， 10 ==20   201 ， 10 = 21   201 % 10 == 0 ?201 / 10 :201 % 10 + 1
		pageBean.setTotalPage(count % pageSize==0 ? count / pageSize : (count / pageSize) + 1); //总页数
		return pageBean;
		
	}

}
