package oracle.java.omyBatis3.dao;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import oracle.java.omyBatis3.model.Emp;
import oracle.java.omyBatis3.model.EmpDept;
@Repository
public class EmpDaoImpl implements EmpDao {
	@Autowired
	private SqlSession session;

	@Override
	public void insertEmp() {
		Emp emp = new Emp();
		System.out.println("EmpDaoImpl insertEmp Run...");
		for (int i = 3001; i <= 3120;i++) {
			emp.setEmpno(i);
			emp.setEname("준민"+i);
			emp.setJob("영업");
			emp.setMgr(7369);
			emp.setHiredate("2019-05-26");
			emp.setSal(3000);
			emp.setComm(500);
			emp.setDeptno(20);
			// MyBatis 연동
			session.insert("insert",emp);
		}

	}

	@Override
	public List<Emp> list(Emp emp) {
		// emp.xml->id(listALL), parameterType(emp), return List
		System.out.println("EmpDaoImpl  list... ");
		List<Emp> list = null;
		try {
			list = session.selectList("listAll", emp);
			System.out.println("list.size->"+list.size());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("e.getMessage->"+e.getMessage());
		}
		return list;
	}
	
	
	public int total() {
		System.out.println("EmpDaoImpl  total... ");
		// emp.xml->id(total), return int
		return session.selectOne("total");
	}
	@Override
	public List<Emp> listManager() {
		return session.selectList("selectManager");
	}	
	public int insert(Emp emp) {
		int kkk = 1;
		try {
			kkk = session.insert("insert",emp);
		} catch (Exception e) {
			kkk = -1;
			System.out.println("e.getMessage()->"+e.getMessage());
		}
		return kkk;
	}

	public Emp detail(int empno) {
		return session.selectOne("detail",empno);
	}
	
	public int update(Emp emp) {
		return session.update("TKempUpdate",emp);
	}
	public int delete(int empno) {
		return session.delete("delete",empno);
	}
	// EmpDept.xml->id(listEmp), parameterType(empDept), return List
	public List<EmpDept> listEmp(EmpDept empDept) {
		return session.selectList("TKlistEmp", empDept);
	}
	@Override
	public String deptName(int deptNo) {
		// TODO Auto-generated method stub
		return session.selectOne("TKdeptName",deptNo);
	}

	
}
