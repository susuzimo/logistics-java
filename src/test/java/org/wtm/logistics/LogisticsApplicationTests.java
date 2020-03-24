package org.wtm.logistics;

import org.apache.shiro.crypto.hash.Sha512Hash;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LogisticsApplicationTests {

	@Test
	void contextLoads() {
		//密码，盐,迭代次数
	//	Sha512Hash sha512Hash = new Sha512Hash("123");

		Sha512Hash suzimo = new Sha512Hash("123","zhangsan",1024);

		System.out.println(suzimo);
	}

}
