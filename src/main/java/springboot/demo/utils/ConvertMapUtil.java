package springboot.demo.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * list<Map> 转换Map 工具类
 * @author chenxb
 *
 */
public class ConvertMapUtil {

	/**
	 * 组装map 返回前端
	 * @param List<Map<String,Object>>
	 * @return
	 */
	public static Map<String,Object> getResourceMap(List<Map<String,Object>> list){
		if(null==list || list.isEmpty()) {
			return null;
		}
		Map<String,Object> map=new HashMap<String,Object>();
		for (Map<String, Object> m : list) {
			map.put(m.get("key").toString(), m.get("value"));
		}
		return map;
	}
	/**
	 * 组装 当前时间 map数据 返回前端
	 * @param list
	 * @return
	 */
	public static Map<String,Object> getResourceToday(List<Map<String,Object>> list){
		if(null==list || list.isEmpty()) {
			return null;
		}
		Map<String,Object> map=new HashMap<String,Object>();
		for (Map<String, Object> m : list) {
			map.put(m.get("key").toString()+"Today", m.get("value"));
		}
		return map;
	}
}
