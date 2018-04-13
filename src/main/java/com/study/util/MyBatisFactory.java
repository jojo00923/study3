package com.study.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisFactory {
	
	public static SqlSessionFactory getSqlSession() {
		String resource = "resource/mybatis-config.xml";	//resource 밑에 mybatis파일을 넣겠다는뜻... // 멤버.sml 보드.sml 등 만들거임.	
		try {
			//ResourceAsStream 가 리소스파일 컴파일되면 가는 클래스파일 안에 있음 실제 클래스 폴더
			InputStream inputStream = Resources.getResourceAsStream(resource); //IBatis에 있는 Resources. 클래스임. 데이터베이스 연결하는 콘피그파일이랑 sql구문 연결???? 매핑파일 총 둘로 나뉜대..
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			return sqlSessionFactory;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("MyBatis 오류", e);
		}
			
	}
	
}