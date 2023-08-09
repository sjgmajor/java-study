package prob04;

public class StringUtil {

	public static String concatenate(String[] strArr) {
		StringBuilder resultStr = new StringBuilder();
		for(String s : strArr) {
			resultStr.append(s);
		}
		return resultStr.toString();
	}
}
