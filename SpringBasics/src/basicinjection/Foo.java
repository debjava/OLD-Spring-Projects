package basicinjection;
/**
 * 
 * @author Apurav
 *
 */
public class Foo {
	private String name;

	public Foo() {
	}

	public Foo(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
