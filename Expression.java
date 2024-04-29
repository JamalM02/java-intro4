

public class Expression {
	private String Exp;//הגדרת שדה
	

	public Expression(String Exp) {//השמה דרך הבנאי של המחלקה
		this.Exp=Exp;
			
	}
	
	public boolean checkValidity() {
		int i=0;
		int j=0;
		String x = Exp + ' ';//יצירת STRING חדש
		
		for(i=0;i<Exp.length();i++)// בדיקת תקינות הביטוי 
		{
			
			if(Exp.codePointAt(i)>=48 && Exp.codePointAt(i)<=57 || Exp.codePointAt(i)==' ' )//בודק אם זה מספר או רווח אם כן אז ממשיך לאיבר הבא
				continue;
			
			
			else if (Exp.codePointAt(i)>=65 || Exp.codePointAt(i)<=39 )// פוסל כל אופציה שהאיבר הוא משהו חוץ ממספר או אופרטור
					return false;
			
			else if (Exp.charAt(0)=='*'||Exp.charAt(0)=='-'||Exp.charAt(0)=='+'||Exp.charAt(0)=='/')//פוסל אופרטור שנמצא בהתחלת הביטוי
					return false;
			
			else if(Exp.charAt(i)=='*'||Exp.charAt(i)=='-'||Exp.charAt(i)=='+'||Exp.charAt(i)=='/') {//תנאי אשר מוודא שאין שני אופרטורים אחד אחרי השני
					
					j=i+1;
					if (Exp.charAt(i)== x.charAt(j))  
					return false;
												
					else 
					continue;  }
			
					}
		//אחרי שמסיים את הלולאה , עוד צעד לוודא שהביטוי לא נגמר באופרטור
		i--;
		
		if (Exp.charAt(i)=='*'||Exp.charAt(i)=='-'||Exp.charAt(i)=='+'||Exp.charAt(i)=='/')
			return false;
		
		else 
			return true;
		
		
	}
	
		
		

	
		public Double calculateExp() {
			
			String[] x =Exp.split(" ");//פיצול את הביטוי לפי רווחים עם מתודת SPLIT
			double[] num = new double [x.length] ;
			

			for(int i=0;i<x.length;i++) {//לולאה אשר עוסקת בהמרת הביטוי הקיים מSTRING למספרים מסוג DOUBLE ואת האופרטורים משאירה כמו שהן ומוסיפה למערך החדש num [] 
				
				
				if (x[i].equals("*") ) 
					num[i]='*';
				
				else if ( x[i].equals("+") )
					num[i]='+';
				
				else if ( x[i].equals("-") )
					num[i]='-';
	
					
				else if ( x[i].equals("/") )
					num[i]='/';
				
				else if ( x[i].equals("(") )
					continue;
				
				else if ( x[i].equals(")") )
					continue;
				
				
				else
					num[i]=Double.parseDouble(x[i]);//המרת הביטוי מSTRING ל ביטוי מספרי
				
				
				
			}
			
			for(int i=0;i<num.length;i++) {//לולאה מבצעת חישוב של כפל וחילוק בלבד משום ששני האופרטרים האלה הם ראשונים מבחינת קדימות אופרטורים 
				
				//  בלולאה הבאה מבצעים את הפעולה ומצבים במקום ה (i+1) כך שהביטוי כל הזמן נדחף ימינה ומאפס את המקומות אחרי חישוב מצד שמאל
				//לדוגמה ( 10 * 5 ----> 0 0 50)
				if(num[i] =='*' || num[i]=='/') {
					
					switch ((char)num[i]) {
					
					case '*' :
					num[i+1]= (num[i-1]) * ( num[i+1]);//ביצוע הכפל בין שני המספרים שלפני ואחרי האופרטור ומציבה את התשובה באיבר ה (I+1)
					num[i-1]=0;//איפוס ערך
					num[i]=0;//איפוס ערך
					break;
				
				
				
					case '/':
					num[i+1]= (num[i-1]) / ( num[i+1]);
					num[i-1]=0;
					num[i]=0;
					break;
						}
				
					}
				
				else 
					continue;
			}	
			
			
			for(int i=0;i<num.length;i++) {//לולאה אשר עוסקת בחישוב של + ו - 
				if(num[i] =='+' || num[i]=='-') {
					
					switch ((char)num[i]) {
					
					case '+' :
					num[i+1]= (num[i-1]) + ( num[i+1]);
					num[i-1]=0;
					num[i]=0;
					break;
				
				
				
					case '-':
						
						if(num[i-1]>num[i+1]) {
					num[i+1]= (num[i-1]) - ( num[i+1]);
					num[i-1]=0;
					num[i]=0;
						}
						
						else
						 {
							num[i+1]= (num[i+1]) - ( num[i-1]);
							num[i-1]=0;
							num[i]=0;
						}
						
					break;
					
						}
				
					}
				
				else 
					continue;
			
				
			}


			
			return  num[num.length -1];// החזרת הערך במקום האחרון שבעצם לשם נדחפה התשובה אחרי ביצוע שתי הלולאות לעיל 
			
		}
		
		

		public static Expression compositeExp(Expression expression, Expression expression2, String string) {

			//בדיקת תקינות שני הביטויים וגם תקינות האופרטור
			if ((expression.checkValidity()==true) &&(expression2.checkValidity()==true) &&
					(string.codePointAt(0)=='*'||string.codePointAt(0)=='-' || string.codePointAt(0)=='+' ||string.codePointAt(0)=='/'))
				
			{
				
				return new Expression(expression + " * " + expression2);//מחזירה הביטוי החדש שמורכב משני הביטויים וביניהם האופרטור שקיבלנו
				
			}
			
			else 
			return null;
			
			
		}
		
		
		public String toString() {
			return Exp;
			}

		
}