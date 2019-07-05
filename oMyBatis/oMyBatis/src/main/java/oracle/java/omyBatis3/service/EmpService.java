package oracle.java.omyBatis3.service;

import java.util.List;
import java.util.Map;

import oracle.java.omyBatis3.model.Emp;
import oracle.java.omyBatis3.model.EmpDept;
import oracle.java.omyBatis3.model.Member1;
import oracle.java.omyBatis3.model.DeptVO;
import oracle.java.omyBatis3.model.Dept;

public interface EmpService {
    void       insertEmp();
	int        total();
	List<Emp>  list(Emp emp);
	List<Emp>  listManager(); // 관리자
	List<Dept> deptList();     // 부서 List 
	int 	insert(Emp emp);
	Emp 	detail(int empno);
	int 	update(Emp emp);
	void 	delete(int empno);
	List<EmpDept> listEmp(EmpDept empDept);
	String  deptName(int deptno); // Ajax Test
	List<Dept> select();
    // interCepter
	int     memCount(String id); 
	List<Member1> listMem(Member1 member1);
	void 	insertDept(DeptVO deptVO);
	void    selListDept(Map<String,Object> map); 


}
