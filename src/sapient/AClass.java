package sapient;

public class AClass {
	String str;

	AClass(String str) {
		this.str = str;
	}

	public int hashCode() {
		int result = 1;
		return 31 * result + ((str != null) ? str.hashCode() : 0);
	}

	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (o == null) {
			return false;
		} else if (!(o instanceof AClass)) {
			return false;
		}

		AClass acl = (AClass) o;
		if (str != null) {
			if (acl.str == null)
				return false;
		} else if (!(str.equals(acl.str)))
			return false;

		return true;
	}

	public static void main(String[] args) {
		AClass a = new AClass("one");
		AClass b = new AClass("one");
		System.out.println(a.equals(b));
		
		AClass c = a;
		System.out.println(a == c);
	}
}
