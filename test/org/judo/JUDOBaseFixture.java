package org.judo;

import org.junit.*;

public class JUDOBaseFixture {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void squareRootWholeNumberIsCorrect() {
		JUDOBase base = new JUDOBase(JUDOBase.jud0_TYPE_BOTH, 500, 250, 10, 2);
		Assert.assertEquals(3, base.squareRoot(9), 0.001);
	}

}
