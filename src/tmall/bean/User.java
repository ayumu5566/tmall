package tmall.bean;

/**
 * 用户
 * 
 * @author ZhanShiLun
 * @date 2017年9月5日 下午2:33:09
 *
 */
public class User {
	/**
	 * 用户ID
	 */
	private int id;

	/**
	 * 用户名
	 */
	private String name;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 获取用户ID
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月5日 下午2:19:28
	 * @return 用户ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置用户ID
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月5日 下午2:19:38
	 * @param id
	 *            用户ID
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 获取用户名
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月5日 下午2:19:57
	 * @return 用户名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置用户名
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月5日 下午2:20:04
	 * @param name
	 *            用户名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取密码
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月5日 下午2:20:14
	 * @return 密码
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置密码
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月5日 下午2:20:23
	 * @param password
	 *            密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取匿名用户名
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月5日 下午2:24:45
	 * @return 匿名用户名
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
