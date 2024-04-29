/*
 גמאל מגאדלה
207513722
------------
אן גאנם
314627951

*/

public class Calculator {
public static void main(String [] args) {
	
Expression [] exp = new Expression [11];

	exp[0] = new Expression("10 * 125 / 0.5 + 20 - 10");//+17-14");
	exp[1] = new Expression("170 / 10 * 15");
	exp[2] = new Expression("15** 3-6 / 12 - 8");
	exp[3] = new Expression("-- 10.76");
	exp[4] = new Expression("11 * 18 /");
	exp[5] = new Expression("+ 112 . 33.25.55 ");
	exp[6] = new Expression("10 * 125 / 0.5 + 20 - 10");
	exp[7] = new Expression("10 + 12r12");
	exp[8] = Expression.compositeExp( exp[0] ,exp[1], "*");
	exp[9] = new Expression("15 + 78 * 13 / 0");
	exp[10 ] = new Expression("15 * ( & 3 - 6 ) / ( 12 - 8 ) )");
	
	for (int i = 0; i <= 10 ; i++) {
		if (!(exp[i].checkValidity())){
			System.out.println("\n"+ exp[i]+ " is not valid." );
		}
		
	
		else {
		System.out.println ("\n" + exp[i] +" = " + exp[i].calculateExp());
		}
		}
}
}