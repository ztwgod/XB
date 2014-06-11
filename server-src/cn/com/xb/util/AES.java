package cn.com.xb.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AES {

	private static final String key = "XB_XUNBAO";
	
	/**
	 * AES加密算法
	 */
	public AES() {}

	/**
	 * 加密
	 * 
	 * @param content
	 *            需要加密的内容
	 * @param keyWord
	 *            加密密钥
	 * @return byte[] 加密后的字节数组
	 */
	private static byte[] encrypt(String content, String keyWord) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(keyWord.getBytes());
			kgen.init(128, secureRandom);
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");// 创建密码器
			byte[] byteContent = content.getBytes("utf-8");
			cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(byteContent);
			return result; // 加密
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param content
	 *            需要加密的内容
	 * @param password
	 *            加密密钥
	 * @return String 加密后的字符串
	 */
	public static String encrypt2str(String content) {
		return parseByte2HexStr(encrypt(content, key));
	}

	/**
	 * 解密
	 * 
	 * @param content
	 *            待解密内容
	 * @param keyWord
	 *            解密密钥
	 * @return byte[]
	 */
	private static byte[] decrypt(byte[] content, String keyWord) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(keyWord.getBytes());
			kgen.init(128, secureRandom);
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");// 创建密码器
			cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(content);
			return result; // 加密
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param content
	 *            待解密内容(字符串)
	 * @param keyWord
	 *            解密密钥
	 * @return byte[]
	 */
	/*private static byte[] decrypt(String content, String keyWord) {
		return decrypt(parseHexStr2Byte(content), keyWord);
	}*/
	
	/**
	 * @param content
	 *            待解密内容(字符串)
	 * @param keyWord
	 *            解密密钥
	 * @return byte[]
	 */
	public static String decrypt2str(String content) {
		byte[] byt = decrypt(parseHexStr2Byte(content), key);
		return new String(byt);
	}
	
	
	/**
	 * 将二进制转换成16进制
	 * 
	 * @param buf
	 * @return String
	 */
	private static String parseByte2HexStr(byte buf[]) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * 将16进制转换为二进制
	 * 
	 * @param hexStr
	 * @return byte[]
	 */
	private static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2),
					16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}

	public static void main(String[] args) {

		String SERVICEAUTHPASSWD = "ftp123";
		// 加密
		/*System.out.println("加密前：" + SERVICEAUTHPASSWD);
		System.out.println("加密后：" + encrypt2str(SERVICEAUTHPASSWD));
		
		String EMAIL_PASSWORD = "xieT123456";
		System.out.println("加密前："+EMAIL_PASSWORD);
		System.out.println("加密后："+encrypt2str(EMAIL_PASSWORD));
		
		String dbc_password = "SFSS2";
		System.out.println("加密前："+dbc_password);
		System.out.println("加密后："+encrypt2str(dbc_password));*/
		String str = encrypt2str("{\"Test\":{\"testId\":10010,\"lists\":{\"cn.com.xb.domain.request.RemoteUnpackeInfoWarpper\":[{\"userId\":\"12660E2343D90\",\"sequenceNumber\":2,\"storageStationId\":1000000002001001,\"boxCode\":1,\"randomNum\":2009,\"transactionID\":\"0000000001\"},{\"userId\":\"432660E2123D90\",\"sequenceNumber\":4,\"storageStationId\":1000021312312301,\"boxCode\":2,\"randomNum\":2019,\"transactionID\":\"0001230001\"}]},\"remoteUnpackeInfoResult\":{\"sequenceNumber\":1,\"resultStatus\":0}}}");
		System.out.println(str);
		System.out.println(decrypt2str("621A4D730110BB7E98C9347C42D16894E69CAFD3E00B7932D3A7B5B4929944E0425A57E0760B3AA65965EAC5A29AD90D90D3CB25B9406B01CD4D093296596D1BC7FB3A8547FBB56EAE6C210CA3CD1607A61C53B6A1548FD5666FFDD6C3B1D7D9BE6A40C5AA690582D79CB9F567169FE39CFDFA214952BE1C8843D0CF7030BA22F61C1C23C0C86F5687BFCAC9110083E1B5A57563FC5F6847D3DD560B104B67F8ED46BE49B0343786E50FFFFBDE7DDAC72D4FBA3DAEA5C124E1A357296E2B44308AF06A886BD4E4AC2953185E675C5B0E0C62DF8310B1BC2BC5D5D176C73519D884C380127EEFAC1752CAF18285B27843D50FBFACAAE1D1E78E61EBD13B78AEEA853B745F0610B704405AE6C0A97B61EB510937D7C6E850184D2F6FA71B393BE8991DD7BA0F954EE9F34054A37EE88605E61CFDF4A1B7E1047AAF05D75BA54C16D69D2EDFC5DD41CA3BC7767EAD897C78EFCDC32AECCB41EA32D3C49DC0999EAACB6C2BEA4C6A8FD7378885F97005C53B615000CC544E07904B65A61404955F2E92FEBD459678A1B7D9CA93A7F8DD43BAFAD2680D9FBE374ABB5A4E4191927885E821D9F6265E59F0C25C5387AEF058CA9F3FDE7DDC2AACD9706977E2D78DE0AC"));
		
	}
}
