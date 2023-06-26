package org.zerock.a5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class A5ApplicationTests {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Test
	void contextLoads() {
	}

	@Test
	public void testEncode(){

	String pw = "1111";

	String enPw = passwordEncoder.encode(pw);

	log.info(enPw);

	// 1111이 비밀번호로 가능한지 판단
	boolean result = passwordEncoder.matches("1111",enPw);

	log.info(result);
	}

}
