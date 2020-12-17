package springboot.demo.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * session 截取 省份
 * @author hyq
 *
 */
public class SessionCutUtil {

	/**
	 * sessionId 中获取多个省份id
	 * @param sessionId
	 * @return
	 */
	public static List<String> getProvinceId(String sessionId) {
		//acc9a8ba-64ef-487a-87ea-674d3ef715cb_18516293301_31|11
		List<String> list=new ArrayList<String>();
		if(null!=sessionId) {
			String str = sessionId.split("_")[2];
			String[] arr=str.split("\\|");
			for (int i = 0; i < arr.length; i++) {
				list.add(arr[i]);
			}
		}
		return list;
	}
	
	
	public static void main(String[] args) {
		String sessionId="12_12_31";
		List<String> list=new ArrayList<String>();
		if(null!=sessionId) {
			String str = sessionId.split("_")[2];
			String[] arr=str.split("\\|");
			System.out.println(arr[0]);
			for (int i = 0; i < arr.length; i++) {
				list.add(arr[i]);
			}
		}
		System.out.println(list);
	}
}
