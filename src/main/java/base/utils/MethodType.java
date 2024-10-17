package base.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodType {
	
	
		boolean isAPI();
	


}
