
/**
 * �����n�����ظ��ַ��������������
 * @author King
 *
 */
public class CombineString {

	/**
	 * <1>�ݹ�����ַ�����ÿ���ַ�ֻ��ȡ��ȡ����ȡ���ַ����Ͱ����ŵ�����ַ����У�������ϣ��������ַ�����
	 * @param c
	 * @param begin
	 * @param len
	 * @param sb
	 */
	public static void CombineRecursiveImpl(char[] c,int begin,int len,StringBuffer sb) {
		if(len == 0) {
			System.out.print(sb + " ");
			return;
		}
		if(begin == c.length) {
			return;
		}
		sb.append(c[begin]);
		CombineRecursiveImpl(c, begin + 1, len - 1, sb);
		sb.deleteCharAt(sb.length() - 1);
		CombineRecursiveImpl(c, begin + 1, len , sb);		
	}
	
	public static void main(String[] args) {
		String s = "abc";
		char[] c = s.toCharArray();
		StringBuffer sb = new StringBuffer("");
		int len = c.length;
		for(int i = 1;i <= len;i++) {
			CombineRecursiveImpl(c, 0, i, sb);
		}

	}

}
