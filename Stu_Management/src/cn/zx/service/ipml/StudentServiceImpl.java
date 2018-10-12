package cn.zx.service.ipml;

import java.sql.SQLException;
import java.util.List;

import cn.zx.bean.PageBean;
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

	////ģ����ѯ�� �����������߸����Ա𣬻������߼��С� 
	@Override
	public List<Student> searchStudent(String sname, String sgender) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.searchStudent(sname, sgender);
	}

	//��ѯ��ҳ������
	@Override
	public PageBean findStudentByPage(int currentPage) throws SQLException {
		//��װ��ҳ�ĸ�ҳ����
		PageBean<Student> pageBean = new PageBean<Student>();
		
		int pageSize = StudentDao.PAGE_SIZE ;
		pageBean.setCurrentPage(currentPage); //���õ�ǰҳ
		pageBean.setPageSize(pageSize); //����ÿҳ��ʾ���ټ�¼
		
		StudentDao dao = new StudentDaoImpl() ;
		List<Student> list =dao .findStudentByPage(currentPage);
		pageBean.setList(list); //������һҳ��ѧ������
		
		//�ܵļ�¼���� �ܵ�ҳ����
		int count = dao.findCount();
		pageBean.setTotalSize(count); //�����ܵļ�¼��
		//200 �� 10 ==20   201 �� 10 = 21   201 % 10 == 0 ?201 / 10 :201 % 10 + 1
		pageBean.setTotalPage(count % pageSize==0 ? count / pageSize : (count / pageSize) + 1); //��ҳ��
		return pageBean;
		
	}

}
