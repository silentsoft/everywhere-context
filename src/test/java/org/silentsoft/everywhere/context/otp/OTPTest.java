package org.silentsoft.everywhere.context.otp;

import org.junit.Test;

public class OTPTest {

	@Test
	public void test() throws Exception {
		String code = OTP.create();
		
		System.out.println("Created OTP : " + code);
		
		System.out.println("Vertify OTP : " + OTP.vertify(code));
	}
}
