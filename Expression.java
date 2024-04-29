

public class Expression {
	private String Exp;//����� ���
	

	public Expression(String Exp) {//���� ��� ����� �� ������
		this.Exp=Exp;
			
	}
	
	public boolean checkValidity() {
		int i=0;
		int j=0;
		String x = Exp + ' ';//����� STRING ���
		
		for(i=0;i<Exp.length();i++)// ����� ������ ������ 
		{
			
			if(Exp.codePointAt(i)>=48 && Exp.codePointAt(i)<=57 || Exp.codePointAt(i)==' ' )//���� �� �� ���� �� ���� �� �� �� ����� ����� ���
				continue;
			
			
			else if (Exp.codePointAt(i)>=65 || Exp.codePointAt(i)<=39 )// ���� �� ������ ������ ��� ���� ��� ����� �� �������
					return false;
			
			else if (Exp.charAt(0)=='*'||Exp.charAt(0)=='-'||Exp.charAt(0)=='+'||Exp.charAt(0)=='/')//���� ������� ����� ������ ������
					return false;
			
			else if(Exp.charAt(i)=='*'||Exp.charAt(i)=='-'||Exp.charAt(i)=='+'||Exp.charAt(i)=='/') {//���� ��� ����� ���� ��� ��������� ��� ���� ����
					
					j=i+1;
					if (Exp.charAt(i)== x.charAt(j))  
					return false;
												
					else 
					continue;  }
			
					}
		//���� ������ �� ������ , ��� ��� ����� ������� �� ���� ��������
		i--;
		
		if (Exp.charAt(i)=='*'||Exp.charAt(i)=='-'||Exp.charAt(i)=='+'||Exp.charAt(i)=='/')
			return false;
		
		else 
			return true;
		
		
	}
	
		
		

	
		public Double calculateExp() {
			
			String[] x =Exp.split(" ");//����� �� ������ ��� ������ �� ����� SPLIT
			double[] num = new double [x.length] ;
			

			for(int i=0;i<x.length;i++) {//����� ��� ����� ����� ������ ����� �STRING ������� ���� DOUBLE ��� ���������� ������ ��� ��� ������� ����� ���� num [] 
				
				
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
					num[i]=Double.parseDouble(x[i]);//���� ������ �STRING � ����� �����
				
				
				
			}
			
			for(int i=0;i<num.length;i++) {//����� ����� ����� �� ��� ������ ���� ���� ���� ��������� ���� �� ������� ������ ������ ��������� 
				
				//  ������ ���� ������ �� ������ ������ ����� � (i+1) �� ������� �� ���� ���� ����� ����� �� ������� ���� ����� ��� ����
				//������ ( 10 * 5 ----> 0 0 50)
				if(num[i] =='*' || num[i]=='/') {
					
					switch ((char)num[i]) {
					
					case '*' :
					num[i+1]= (num[i-1]) * ( num[i+1]);//����� ���� ��� ��� ������� ����� ����� �������� ������ �� ������ ����� � (I+1)
					num[i-1]=0;//����� ���
					num[i]=0;//����� ���
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
			
			
			for(int i=0;i<num.length;i++) {//����� ��� ����� ������ �� + � - 
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


			
			return  num[num.length -1];// ����� ���� ����� ������ ����� ��� ����� ������ ���� ����� ��� ������� ���� 
			
		}
		
		

		public static Expression compositeExp(Expression expression, Expression expression2, String string) {

			//����� ������ ��� �������� ��� ������ ��������
			if ((expression.checkValidity()==true) &&(expression2.checkValidity()==true) &&
					(string.codePointAt(0)=='*'||string.codePointAt(0)=='-' || string.codePointAt(0)=='+' ||string.codePointAt(0)=='/'))
				
			{
				
				return new Expression(expression + " * " + expression2);//������ ������ ���� ������ ���� �������� ������� �������� �������
				
			}
			
			else 
			return null;
			
			
		}
		
		
		public String toString() {
			return Exp;
			}

		
}