class test {
	int a = 0;
	public int cal(int a, int b, int c) {
		return a + b + c;
	}

	public static void main(String[] args) {
		test t1 = new test();
		System.out.println(t1.cal(1,2,3));
	}
}
