package GameEngine;


public class Resource<T> {

	private T data;
	private String name;
	
	public Resource(T data, String name){
		this.data = data;
		this.name = name;
	}
	
	public T getData(){
		return this.data;
	}
	
}
