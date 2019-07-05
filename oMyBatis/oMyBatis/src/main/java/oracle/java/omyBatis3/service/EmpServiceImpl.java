package oracle.java.omyBatis3.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oracle.java.omyBatis3.dao.DeptDao;
import oracle.java.omyBatis3.dao.EmpDao;
import oracle.java.omyBatis3.model.Dept;
import oracle.java.omyBatis3.model.Emp;
import oracle.java.omyBatis3.model.EmpDept;
import oracle.java.omyBatis3.dao.Member1Dao;
import oracle.java.omyBatis3.model.Member1;
import oracle.java.omyBatis3.model.DeptVO;

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpDao ed;
	@Autowired
	private DeptDao dd;
	@Autowired
	private Member1Dao md;

	@Override
	public void insertEmp() {
		ed.insertEmp();
	}
	@Override
	public List<Emp> list(Emp emp) {
		System.out.println("EmpServiceImpl list ...");
		return ed.list(emp);
	}
	// ed->EmpDaoImpl 
	public int total() {
		System.out.println("EmpServiceImpl total ...");
		return ed.total();
	}
	@Override
	public List<Emp> listManager() {
		System.out.println("EmpServiceImpl listManager ...");
		return ed.listManager();
	}
	@Override
	public List<Dept> deptList() {
		System.out.println("EmpServiceImpl deptList ...");
		return dd.deptList();
	}
	
	@Override
	public int insert(Emp emp) {
		return ed.insert(emp);
	}	

	// ed->EmpDaoImpl 
	public Emp detail(int empno) {
		return ed.detail(empno);
	}
	
	// ed->EmpDaoImpl 
	public int update(Emp emp) {
		return ed.update(emp);
	}

	// ed->EmpDaoImpl 
	public void delete(int empno) {
		ed.delete(empno);
	}
	// ed->EmpDaoImpl 
	public List<EmpDept> listEmp(EmpDept empDept) {
		return ed.listEmp(empDept);
	}
	
	@Override
	public String deptName(int deptno) {
		// TODO Auto-generated method stub
		return ed.deptName(deptno);
	}
	
	// dd->DeptDao 
	public List<Dept> select() {
		return dd.deptList();
	}
    // interCepter
	// Member1 -> InterCeptor
	@Override
	public int memCount(String id) {
		// TODO Auto-generated method stub
		System.out.println("EmpServiceImpl memCount id ->"+id);
	    return md.memCount(id); 
	}

	// Member1 -> InterCeptor
	@Override
	public List<Member1> listMem(Member1 member1) {
		// TODO Auto-generated method stub
		System.out.println("EmpServiceImpl listMem ");
		return md.listMem(member1);
	}

	// Procedure Call Test 
	@Override
	public void insertDept(DeptVO deptVO) {
		// TODO Auto-generated method stub
		 dd.insertDept(deptVO);
	}

	@Override
	public void selListDept(Map<String, Object> map) {
		// TODO Auto-generated method stub
		dd.selListDept(map);
		
	}
	
	

}
