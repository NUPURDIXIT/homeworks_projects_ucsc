
public class TestPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		outerLoop:
			for (int i = 2; i < 20; i++)
			{
				for (int j = 2; j < i-1; j++)
				{
					int remainder = i % j;
					if (remainder == 0)
						continue outerLoop;
				}		
				System.out.println(i);
			}

	}

}
