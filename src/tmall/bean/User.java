package tmall.bean;

/**
 * �û�
 * 
 * @author ZhanShiLun
 * @date 2017��9��5�� ����2:33:09
 *
 */
public class User {
	/**
	 * �û�ID
	 */
	private int id;

	/**
	 * �û���
	 */
	private String name;

	/**
	 * ����
	 */
	private String password;

	/**
	 * ��ȡ�û�ID
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��5�� ����2:19:28
	 * @return �û�ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * �����û�ID
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��5�� ����2:19:38
	 * @param id
	 *            �û�ID
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * ��ȡ�û���
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��5�� ����2:19:57
	 * @return �û���
	 */
	public String getName() {
		return name;
	}

	/**
	 * �����û���
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��5�� ����2:20:04
	 * @param name
	 *            �û���
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ��ȡ����
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��5�� ����2:20:14
	 * @return ����
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * ��������
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��5�� ����2:20:23
	 * @param password
	 *            ����
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * ��ȡ�����û���
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��5�� ����2:24:45
	 * @return �����û���
	 */
	public String getAnonymousName() {
		if (null == name) {
			return null;
		}
		if (name.length() <= 1) {
			return "*";
		}
		if (name.length() == 2) {
			return name.substring(0, 1) + "*";
		}

		char[] cs = name.toCharArray();
		for (int i = 1; i < cs.length - 1; i++) {
			cs[i] = '*';
		}
		return new String(cs);

	}
}
