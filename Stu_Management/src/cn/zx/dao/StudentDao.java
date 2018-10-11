package cn.zx.dao;

import java.sql.SQLException;
import java.util.List;

import cn.zx.bean.Student;

/**
 * �������ѧ��������ݷ���
 * @author 10831
 *
 */
public interface StudentDao {
	
	/**
	 * ��ѯ����ѧ��
	 * @return
	 */
	List<Student> findAll() throws SQLException;
	
	/**
	 * ����ID��ѯ����ѧ������
	 * @param sid
	 * @return
	 * @throws SQLException
	 */
	Student findStudentById(int sid)  throws SQLException ;
	
	/**
	 * ���ѧ��
	 * @param student ��Ҫ��ӵ����ݿ��ѧ������
	 * @throws SQLException
	 */
	void insert(Student student) throws SQLException ;
	
	/**
	 * ����idɾ��ѧ��
	 * @param sid
	 * @throws SQLException
	 */
	void delete(int sid) throws SQLException ;
	
	/**
	 * ����ѧ����Ϣ
	 * @param student ��Ҫ���µ�ѧ������
	 * @throws SQLException
	 */
	void update (Student student )throws SQLException ;
}
