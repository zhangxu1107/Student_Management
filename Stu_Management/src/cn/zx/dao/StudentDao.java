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
	
	int PAGE_SIZE = 5; //һҳ��ʾ��������¼
	
	/**
	 * ��ѯ��ҳ��ѧ������
	 * @param currentPage
	 * @return
	 * @throws SQLException
	 */
	List<Student> findStudentByPage(int currentPage) throws SQLException ;
	
	
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
	 * ģ����ѯ�� �����������߸����Ա𣬻������߼��С� 
	 * @param sname
	 * @param sgender
	 * @return ����
	 * @throws SQLException
	 */
	List<Student> searchStudent(String sname , String sgender)  throws SQLException ;
	
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
	
	/**
	 * ��ѯ�ܵ�ѧ����¼��
	 * @return
	 * @throws SQLException
	 */
	int findCount()throws SQLException ;
}
