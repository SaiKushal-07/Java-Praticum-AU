class Main
{
	public void sum(int a, int b) {
		int sum = a + b;
		System.out.println("The sum of " + a + " and " + b + " is " + sum);
	}
	public static void main(String[] args) {
		Main obj = new Main();
		obj.sum(5, 10);
	}
}
