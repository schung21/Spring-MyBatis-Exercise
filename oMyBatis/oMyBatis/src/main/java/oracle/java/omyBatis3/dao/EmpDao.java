package oracle.java.omyBatis3.dao;

import java.util.List;

import oracle.java.omyBatis3.model.Emp;
import oracle.java.omyBatis3.model.EmpDept;

public interface EmpDao {
   void insertEmp();
	List<Emp> list(Emp emp);
	int total();
	List<Emp> listManager();
	int insert(Emp emp);
	Emp detail(int empno);
	int update(Emp emp);   
	int delete(int empno);
	List<EmpDept> listEmp(EmpDept empDept);
	String	deptName(int deptNo);

}
