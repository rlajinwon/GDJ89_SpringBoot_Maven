package com.one.app.board.lamda;

public class LamdaTest {
	
	public void test() {
		TestInterface t = new Plus();
		t.cal(10, 20);
		
		t = new Minus();
		t.cal(10, 20);
		
		
		t = (int n1, int n2) -> n1+n2;
		int result = t.cal(10, 20);
		
		
	}

}
