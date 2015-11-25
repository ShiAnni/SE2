package vo;

public class UserVO {
	/** serialVersionUID */
	public static final long serialVersionUID = 1L;
	/**
	 * 用户ID
	 */
	public String id;
	/** 用户名 */
	public String userName;

	/** 密码 */
	public String password;
	/** 用户身份 */
	public String iden;
	/** 联系电话 */
	public String phoneNumber;

	/** 用户权限 */
	public String authority;
	/** 地址 */
	public String address;

	/**
	 * 
	 * @param id
	 *            用户id
	 * @param password
	 *            用户密码
	 * @param userName
	 *            用户名字
	 * @param phoneNumber
	 *            联系电话
	 * @param iden
	 *            用户身份
	 * @param authority
	 *            用户权限
	 * @param address
	 *            用户地址
	 */
	public UserVO(String id, String password, String userName, String phoneNumber, String iden, String authority,
			String address) {
		this.id = id;
		this.password = password;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.iden = iden;
		this.authority = authority;
		this.address = address;

	}

	@Override

	public String toString() {
		return id + "," + password + "," + "userName" + "," + phoneNumber + "," + iden + "," + authority + ","
				+ address;

	}

}
