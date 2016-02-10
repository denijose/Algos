package com.denis.effectivejava;

/**
 * An example demonstrating builder factory pattern
 *
 */


public class BuilderExample {
	// required params
	private final int someInteger1;
	private final String someString1;
	
	//optional params
	private int someInteger2;
	private String someString2;
	
	public int getSomeInteger2() {
		return someInteger2;
	}

	public void setSomeInteger2(int someInteger2) {
		this.someInteger2 = someInteger2;
	}

	public String getSomeString2() {
		return someString2;
	}

	public void setSomeString2(String someString2) {
		this.someString2 = someString2;
	}

	public int getSomeInteger1() {
		return someInteger1;
	}

	public String getSomeString1() {
		return someString1;
	}

	
	
	private BuilderExample(Builder builder) {
		someInteger1 = builder.someInteger1;
		someString1 = builder.someString2;
		someInteger2 = builder.someInteger2;
		someString2 = builder.someString2;			
	}
	
	public static class Builder {
		// required params
		private final int someInteger1;
		private final String someString1;
		
		// optional params
		private int someInteger2;
		private String someString2;
		
		public Builder(int n, String str) {
			someInteger1 = n;
			someString1 = str;
		}
		public Builder withInteger(int n) {
			someInteger2 = n;
			return this;
		}
		
		public Builder withString(String str) {
			someString2 = str;
			return this;
		}
		
		public BuilderExample build() {
			return new BuilderExample(this);
		}
	}
	
	public static void main(String[] args) {
	    BuilderExample example = new BuilderExample.Builder(1,"denis")
					.withInteger(2)
					.build();
	    System.out.println(example.getSomeInteger2());
	}
}
