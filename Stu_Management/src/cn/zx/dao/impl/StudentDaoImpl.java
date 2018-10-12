package cn.zx.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.zx.bean.Student;
import cn.zx.dao.StudentDao;
import cn.zx.util.JDBCUtil;
import cn.zx.util.TextUtils;

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

	//ģ����ѯ�� �����������߸����Ա𣬻������߼��С� 
	@Override
	public List<Student> searchStudent(String sname, String sgender) throws SQLException {
		System.out.println("����Ҫִ��ģ����ѯ�ˣ��յ���name ="+sname + "==genser=="+sgender);
		
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		
		//String sql = "select * from stu where sname=? or sgender=?";
		
		/*
		 * ����Ҫ����һ�£�
		 * 	���ֻ������ ��select * from stu where sname like ? ;
		 * 	���ֻ���Ա� �� select * from stu where gender = ?
		 * 
		 * ����������� select * from stu where sname like ? and gender=?
		 * 
		 * ���������û�оͲ�ѯ���С�
		 * 
		 */
		String sql = "select * from t_stu where 1=1 ";
		List<String> list = new ArrayList<String> ();
				
		//�ж���û�������� ����У�����ƴ��sql�������
		if(!TextUtils.isEmpty(sname)){
			sql = sql + "  and sname like ?";
			list.add("%"+sname+"%");
		}
		
		//�ж���û���Ա��еĻ�������ƴ��sql������档
		if(!TextUtils.isEmpty(sgender)){
			sql = sql + " and gender = ?";
			list.add(sgender);
		}
			
		return runner.query(sql , new BeanListHandler<Student>(Student.class) ,list.toArray() );
	}

	@Override
	public List<Student> findStudentByPage(int currentPage) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		//��һ���ʺţ�����һҳ���ض�������¼  �� �ڶ����ʺţ� ����ǰ��Ķ�������¼��
		//5 0 --- ��һҳ (1-1)*5
		//5 5  --- �ڶ�ҳ (2-1)*5
		//5 10  --- ����ҳ
		return runner.query("select * from t_stu limit ? offset ?", 
				new BeanListHandler<Student>(Student.class) , PAGE_SIZE , (currentPage-1)*PAGE_SIZE);
	}

	//��ѯ�ܵ�ѧ����¼��
	@Override
	public int findCount() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		//���ڴ��� ƽ��ֵ �� �ܵĸ����� 
		Long  result = (Long) runner.query("SELECT COUNT(*) FROM t_stu" , new ScalarHandler() );
		return result.intValue();
	}

}
