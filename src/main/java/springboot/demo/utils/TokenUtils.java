package springboot.demo.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Date;

public class TokenUtils {

	private static final String DESTYPE = "DES";
	private static String MD5ENCRYPTION = "123";
	private static String TOKENENCRYPTION = "12345678";
	private static long EXPIRATIONTIME = 1000*60*26*24*7;
	
	public static String encrypt(String body, String key) {

		try { // 生成密钥
			SecretKey deskey = new SecretKeySpec(key.getBytes(), DESTYPE); // 加密
			Cipher c1 = Cipher.getInstance(DESTYPE);
			c1.init(Cipher.ENCRYPT_MODE, deskey);
			byte[] result = c1.doFinal(body.getBytes("utf-8"));
			return bytesToHexString(result);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String decrypt(String body, String key) {
		try { // 生成密钥
			SecretKey deskey = new SecretKeySpec(key.getBytes(), DESTYPE); // 解密
			Cipher c1 = Cipher.getInstance(DESTYPE);
			c1.init(Cipher.DECRYPT_MODE, deskey);
			return new String(c1.doFinal(hexStringToBytes(body)), "utf-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder("");
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}

	private static byte[] hexStringToBytes(String hexString) {
		if (hexString == null || hexString.equals("")) {
			return null;
		}
		hexString = hexString.toUpperCase();
		int length = hexString.length() / 2;
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++) {
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
		}
		return d;
	}

	private static byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
	}
	public static void main(String[] args) {


		String token加密密钥 = "12345678";
		String MD5加密密钥 = "123";

		String id = "test1234567";
		System.out.println("=================加密=================");
		String 时间戳 = new Date().getTime()+"";
		System.out.println("id:"+id);
		System.out.println("时间戳:"+时间戳);
		String 生成的Md5 = MD5(id+时间戳+MD5加密密钥);
		System.out.println("生成的Md5:"+生成的Md5);
		String 未加密的token = id+"_"+时间戳+"_"+生成的Md5;
		System.out.println("未加密的token:"+未加密的token);
		String 加密的token = encrypt(未加密的token, token加密密钥);
		System.out.println("加密的token:"+加密的token);
		System.out.println("=================解密=================");
		String 解密的token = decrypt(加密的token, token加密密钥);
		System.out.println("解密的token:"+解密的token);
		String temp[] = 解密的token.split("\\_");
		String 解密获得的id = temp[0];
		String 解密获得的时间戳 = temp[1];
		String 解密获得的md5 = temp[2];
		System.out.println("解密获得的id:"+解密获得的id);
		System.out.println("解密获得的时间戳:"+解密获得的时间戳);
		System.out.println("解密获得的md5:"+解密获得的md5);
		String 从新生成MD5 = MD5(解密获得的id+解密获得的时间戳+MD5加密密钥);
		System.out.println("从新生成MD5:"+从新生成MD5);
		System.out.println("比较两个MD5:"+(解密获得的md5.equals(从新生成MD5) ? "一样的":"不一样"));


	}
	public final static String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] btInput = s.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
