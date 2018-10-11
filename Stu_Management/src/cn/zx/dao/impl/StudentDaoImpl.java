package cn.zx.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.zx.bean.Student;
import cn.zx.dao.StudentDao;
import cn.zx.util.JDBCUtil;

public class StudentDaoImpl implements StudentDao {

	/**
	 * ��ѯ����ѧ��
	 * 
	 * @throws SQLException
	 */
	@Override
	public List<Student> findAll() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from t_stu";
		return runner.query(sql, new BeanListHandler<Student>(Student.class));
	}

	//���ѧ��
	@Override
	public void insert(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		
		runner.update("insert into t_stu values(null , ?,?,?,?,?,?,?)" ,
				student.getSname(),
				student.getAge(),
				student.getGender(),
				student.getPhone(),
				student.getBirthday(),
				student.getHobby(),
				student.getInfo()
				);
	}

	//ɾ��ѧ��
	@Override
	public void delete(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		runner.update("delete from t_stu where sid = ?",sid);
	}

	//����ѧ����Ϣ
	@Override
	public void update(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		runner.update("update t_stu set sname=? , age = ?, gender=? , phone=? , birthday=? , hobby=? , info=? where sid = ?", 
				student.getSname(),
				student.getAge(),
				student.getGender(),
				student.getPhone(),
				student.getBirthday(),
				student.getHobby(),
				student.getInfo(),
				student.getSid());
	}

	//��id���ҵ���ѧ��
	@Override
	public Student findStudentById(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from t_stu where sid = ?";
		return runner.query(sql, new BeanHandler<Student>(Student.class) ,sid);
	}

}
