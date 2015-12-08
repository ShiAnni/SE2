package businesslogic.userbl;

import java.io.File;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import config.RMIConfig;
import dataservice.userdataservice.LoginInfo;
import dataservice.userdataservice.UserDataService;
import po.UserPO;
import state.ConfirmState;
import state.ResultMessage;
import state.UserIdentity;
import util.SerSaveAndLoad;
import vo.UserVO;
/**
 * 
 * @author Ann
 * @version 创建时间：2015年12月3日 下午3:38:54
 */
public class User {
	private UserDataService userData;
	public static String currentUserFileName;
	private SerSaveAndLoad<UserPO> currentUserFile;
	static{
		currentUserFileName="user/userdata.ser";
	}
	public User() throws MalformedURLException, RemoteException, NotBoundException {
		currentUserFile = new SerSaveAndLoad<>("user",User.currentUserFileName);
		File file = new File(currentUserFileName);
		file.deleteOnExit();
		userData = (UserDataService) Naming.lookup(RMIConfig.PREFIX + UserDataService.NAME);
	}

	public ConfirmState confirmOperation() {
		return ConfirmState.CONFIRM;
	}

	public ArrayList<UserVO> show() throws RemoteException {
		ArrayList<UserPO> pos = userData.find();
		ArrayList<UserVO> vos = UserTrans.transPOstoVOs(pos);
		return vos;
	}

	public String getID() throws RemoteException {
		return userData.getID();
	}

	public ResultMessage addUser(UserVO vo) throws RemoteException {
		UserPO userPO = UserTrans.transVOtoPO(vo);
		return userData.add(userPO);
	}

	public ResultMessage deleteUser(String username) throws RemoteException {
		return userData.delete(username);
	}

	public ResultMessage updateUser(UserVO vo) throws RemoteException {
		UserPO userPO = UserTrans.transVOtoPO(vo);
		return userData.modify(userPO);
	}
	/**
	 * 验证用户登录
	 * @param loginInfo
	 * @return 返回登录的用户的身份，登录失败时返回NULL
	 * @author zsq
	 * @version Oct 22,2015
	 * @author Ann
	 * @version Nov 29,2015
	 */
	public UserIdentity login(LoginInfo loginInfo) throws RemoteException {
		/*if(loginInfo.username.equals("admin")&&loginInfo.password.equals("admin")){
			return UserIdentity.ADMIN;
		}*/
		ArrayList<UserPO> pos = userData.find();
		for (UserPO po : pos) {
			if (po.getUserName().equals(loginInfo.username)){
				if (po.getPassword().equals(loginInfo.password)) {
					this.currentUserFile.add(po);
					return po.getIden();
				}else {
					//密码不正确
					return null;
				}
			}
		}
		//无用户
		return null;
	}
	/**
	 * 更改用户密码
	 * @param oldPassword，旧密码
	 * @param newPassword，新密码
	 * @return 处理信息
	 * @author zsq
	 * @version Oct 22,2015
	 * @author Ann
	 * @version Nov 29,2015
	 */
	public ResultMessage updateAdmin(String oldPassword,String newPassword) throws RemoteException{
		UserPO admin = userData.find("0000");
		if(!admin.getPassword().equals(oldPassword))
			//旧密码不正确
			return ResultMessage.FAIL;
		else {
			admin.setPassword(newPassword);
			userData.modify(admin);
			return ResultMessage.SUCCESS;
		}
	}
	
	public ArrayList<UserVO> showUser(UserIdentity userIdentity) throws RemoteException{
		ArrayList<UserPO> pos = userData.find();
		ArrayList<UserVO> vos = new ArrayList<>();
		for (UserPO userPO : pos) {
			if (userPO.getIden()==userIdentity) {
				UserVO vo = UserTrans.transPOtoVO(userPO);
				vos.add(vo);
			}
		}
		return vos;
	}
}
