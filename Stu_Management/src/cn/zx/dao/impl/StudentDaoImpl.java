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
	 * 查询所有学生
	 * 
	 * @throws SQLException
	 */
	@Override
	public List<Student> findAll() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from t_stu";
		return runner.query(sql, new BeanListHandler<Student>(Student.class));
	}

	//添加学生
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

	//删除学生
	@Override
	public void delete(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		runner.update("delete from t_stu where sid = ?",sid);
	}

	//更新学生信息
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

	//按id查找单个学生
	@Override
	public Student findStudentById(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from t_stu where sid = ?";
		return runner.query(sql, new BeanHandler<Student>(Student.class) ,sid);
	}

	//模糊查询， 根据姓名或者根据性别，或者两者兼有。 
	@Override
	public List<Student> searchStudent(String sname, String sgender) throws SQLException {
		System.out.println("现在要执行模糊查询了，收到的name ="+sname + "==genser=="+sgender);
		
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		
		//String sql = "select * from stu where sname=? or sgender=?";
		
		/*
		 * 这里要分析一下：
		 * 	如果只有姓名 ，select * from stu where sname like ? ;
		 * 	如果只有性别 ， select * from stu where gender = ?
		 * 
		 * 如果两个都有 select * from stu where sname like ? and gender=?
		 * 
		 * 如果两个都没有就查询所有。
		 * 
		 */
		String sql = "select * from t_stu where 1=1 ";
		List<String> list = new ArrayList<String> ();
				
		//判断有没有姓名， 如果有，就组拼到sql语句里面
		if(!TextUtils.isEmpty(sname)){
			sql = sql + "  and sname like ?";
			list.add("%"+sname+"%");
		}
		
		//判断有没有性别，有的话，就组拼到sql语句里面。
		if(!TextUtils.isEmpty(sgender)){
			sql = sql + " and gender = ?";
			list.add(sgender);
		}
			
		return runner.query(sql , new BeanListHandler<Student>(Student.class) ,list.toArray() );
	}

	@Override
	public List<Student> findStudentByPage(int currentPage) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		//第一个问号，代表一页返回多少条记录  ， 第二个问号， 跳过前面的多少条记录。
		//5 0 --- 第一页 (1-1)*5
		//5 5  --- 第二页 (2-1)*5
		//5 10  --- 第三页
		return runner.query("select * from t_stu limit ? offset ?", 
				new BeanListHandler<Student>(Student.class) , PAGE_SIZE , (currentPage-1)*PAGE_SIZE);
	}

	//查询总的学生记录数
	@Override
	public int findCount() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		//用于处理 平均值 、 总的个数。 
		Long  result = (Long) runner.query("SELECT COUNT(*) FROM t_stu" , new ScalarHandler() );
		return result.intValue();
	}

}
