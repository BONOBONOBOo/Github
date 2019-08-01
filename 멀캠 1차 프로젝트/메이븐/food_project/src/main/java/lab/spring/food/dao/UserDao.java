package lab.spring.food.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lab.spring.food.model.UserVO;



@Repository
public class UserDao {
	
	@Autowired
	SqlSession sqlSession;
	
	public UserVO login(String userid,String userpwd) {
		UserVO vo = new UserVO();
		HashMap<String, String> hm = new HashMap<String, String>();
		
		hm.put("uid", userid);
		hm.put("upwd", userpwd);
		
		vo = sqlSession.selectOne("lab.mybatis.mappers.UserMapper.login",hm);
		
		return vo;
	}
	
	public int join(UserVO vo) {

		return sqlSession.insert("lab.mybatis.mappers.UserMapper.Join",vo);
	}
	
	public int hopeUpdate(String userid,String hopeKcal) {
		
		HashMap<String,String> hashmap = new HashMap<String, String>();
		
		hashmap.put("userid", userid);
		hashmap.put("hopeKcal",hopeKcal);
		
		return sqlSession.insert("lab.mybatis.mappers.UserMapper.HopeUpdate",hashmap);
	}
	

}
