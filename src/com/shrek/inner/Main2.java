package com.shrek.inner;

class In{
	private int inVar;
	public int getInVar() {
		return inVar;
	}
	public void setInVar(int inVar) {
		this.inVar = inVar;
	}
	public In() {
		super();
	}
	public In(int inVar) {
		super();
		this.inVar = inVar;
	}

	class Inner{
		public int innerVar;
		public int getInnerVar() {
			return innerVar;
		}
		public void setInnerVar(int innerVar) {
			this.innerVar = innerVar;
		}
		public Inner() {
			super();
		}
		public Inner(int innerVar) {
			super();
			this.innerVar = innerVar;
		}

		class Inert{
			public int inertVar;
			public int getInertVar() {
				return inertVar;
			}
			public void setInertVar(int inertVar) {
				this.inertVar = inertVar;
			}
			public Inert() {
				super();
			}
			public Inert(int inertVar) {
				super();
				this.inertVar = inertVar;
			}			
		}
		
		public Inert getInertMethod(int value){
			return new Inert(value);
		}
	}
	
	public Inner getInnerMethod(int value){
		return new Inner(value);
	}
	
}

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		In inObj=new In(333);
		System.out.println(inObj.getInVar());
		In.Inner innerObj=inObj.getInnerMethod(33);
		System.out.println(innerObj.getInnerVar());		
		In.Inner.Inert inertObj=innerObj.getInertMethod(3);
		System.out.println(inertObj.getInertVar());
	}

}
