package oracle.java.omyBatis3.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;  // 
import org.springframework.stereotype.Repository;

import oracle.java.omyBatis3.model.Dept;
//import oracle.java.omyBatis3.model.DeptVO;
import oracle.java.omyBatis3.model.DeptVO;

@Repository
public class DeptDaoImpl implements DeptDao{
	@Autowired
	private SqlSession session;
	public List<Dept> deptList() {
		return session.selectList("TKselectDept");
	}
	@Override
	public void insertDept(DeptVO deptVO) {
		 session.selectOne("ProcDept",deptVO);
	}
	@Override
	public void selListDept(Map<String, Object> map) {
		 session.selectOne("ProcDeptList",map);
		
	}
	



}