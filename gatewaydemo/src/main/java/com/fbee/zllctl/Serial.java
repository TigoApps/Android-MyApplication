package com.fbee.zllctl;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
 
import java.util.List; 
 
  
public class Serial {
	private static final String TAG = "Serial";
	private static Context mContext;

	public void setmContext(Context mContext) {
		Serial.mContext = mContext;
	}

	static {
		System.loadLibrary("zllcmd");
	}

	/* about net system */

	/* about serial system */

	/**
	 * ���˳���appʱ������ô˺������ͷ�����jni�����õ�����Դ
	 */
	public native void releaseSource();

	/* about net system */

	public native int setserver(String serverIP, short serverPort);

	/**
	 * �������� >0 ����
	 * 
	 * @return
	 */
	public native int setLanguageType(int isCN);

	
	/**
	 * ���ӵ����ؾ�����������
	 * 
	 * @return ����0���Ҹ�n�����أ����ӳɹ���-3 ���ӳ�ʱ����������ԭ������ʧ��
	 */
	public native int connectLANZll();

	/**
	 * ���ӵ�Զ�̵�����
	 * 
	 * @param userName
	 *            �û���
	 * @param passWd
	 *            ����
	 * @return ����0�����ӳɹ�������ʧ��,-2Ϊ�˺Ż��������
	 */
	public native int connectRemoteZll(String userName, String passWd);

	/**
	 * ͨ������ip�ķ�ʽ�����ӵ����ص�����
	 * 
	 * @param ip
	 * @param snid
	 * @return -1 ����ʧ�ܣ�-3���ӳ�ʱ��>0���ӳɹ�
	 */
	public native int connectLANZllByIp(String ip, String snid);

	/**
	 * ��ȡ��ǰ���ӵ�����ip (���ޱ�������)
	 * 
	 * @return
	 */
	public native String getGatewayIp();

	/**
	 * ��ȡ��ǰ���ӵ�����snid (���ޱ�������)
	 * 
	 * @return
	 */
	public native String getBoxSnid();

	/**
	 * ��ȡ��ǰ�ҵ����е�����ip
	 * 
	 * @return
	 */
	public native String[] getGatewayIps(int len);

	/**
	 * ��ȡ��ǰ�������صķ�ʽ
	 * 
	 * @return 0 ������
	 *         <p/>
	 *         1��������
	 *         <p/>
	 *         2���ؾ���������
	 *         <p/>
	 *         3Զ������
	 *         <p/>
	 */
	public native int getConnectType();

	/**
	 * ��ȡ��ǰ�����ҵ�������snid
	 * 
	 * @return
	 */
	public native String[] getBoxSnids(int len);

	/**
	 * �鿴������Ϣ, �����gatewayInfo_CallBack����
	 */
	public native void getGateWayInfo();
	
	/**
	 * ��ȡ��ǰso�汾��Ϣ
	 * 
	 * @return
	 */
	public native String getSoVer();

	/**
	 * ��λ����
	 * @return
	 */
	public native int resetGateway();
	
	/**
	 * ��ȡ��ǰ���ӵ������豸
	 * 
	 * @return ��ʹ�ô�������ʱ�����������ص�ǰ�����豸��
	 *         <p/>
	 *         ��ʹ��net��lanʱ������ΪNULL���������newDevice_CallBack��������ص��У�����������豸
	 */
	public native DeviceInfo[] getDevices();

	/**
	 * ��õ�ǰ�����豸��Ŀ
	 * 
	 * @return ��ȡ��ǰ�����豸��Ŀ
	 */
	public native int getDeviceNum();

	/**
	 * �����豸��������,�����ַ�����
	 * 
	 * @param dInfo
	 *            Ҫ���ĵ��豸��������device UId ��deviceName��
	 * @param dName
	 *            �µ��豸��
	 */
	public native int ChangeDeviceName(DeviceInfo dInfo, byte[] dName);

	/**
	 * ɾ����ǰ�豸
	 * 
	 * @param info
	 *            Ҫɾ�����豸��������device Uid��
	 */
    public native int deleteDevice(DeviceInfo info);

	/**
	 * �ı��豸״̬��1 ��/ 0 ��
	 * 
	 * @param info
	 *            Ҫ�ı�״̬���豸������Ҫ��Uid��
	 * @param state
	 *            Ҫ�ı��״̬
	 */
    public native int setDeviceState(DeviceInfo info, int state);
	
 /**
     * Ҫ��ȡ�¿������豸״̬��type 0��localtemp type 1��state ,type 2��mode,type 3��fan,type 4��time type 5��temp
     *
     * @param info  Ҫ��ȡ���豸������Ҫ��Uid��
     * @param type Ҫ��ȡ��״̬
     */
    public native int  GetThermostatState(DeviceInfo info,int type);
    /**
     * Ҫ��ȡ�¿������豸״̬��type 1��state ,type 2��mode,type 3��fan,type 4��time type 5��temp
     *
     * @param info  Ҫ��ȡ���豸������Ҫ��Uid��
     * @param type Ҫ��ȡ��״̬
     * @param  value Ҫ���õ�ֵ
     */
    public native int  SetThermostatState(DeviceInfo info,int type,int value);
  /**
     * Ҫ��ȡ���ܲ����豸���豸״̬��type 0������  1��˲ʱ����
     *
     * @param info  Ҫ��ȡ���豸������Ҫ��Uid��
     * @param type Ҫ��ȡ��״̬
     * @param  value Ҫ���õ�ֵ
     */
    public native int  GetMeteringState(DeviceInfo info,int type);
	/**
	 * ����豸״̬�������getDeviceState_CallBack����ص��л��з���
	 * 
	 * @param info
	 *            Ҫ��ȡ���豸������Ҫ��Uid��
	 */
    public native int getDeviceState(DeviceInfo info);

	/**
	 * �ı��豸ֵ�������ȣ�
	 * 
	 * @param info
	 *            Ҫ�ı��豸ֵ���豸������Ҫ��Uid��
	 * @param value
	 *            Ҫ�ı��ֵ
	 */
    public native int setDeviceLevel(DeviceInfo info, byte value);
    
    /**
	 * �ı��豸ֵ�������ȣ�
	 * 
	 * @param info
	 *            Ҫ�ı��豸ֵ���豸������Ҫ��Uid��
	 * @param value
	 *            Ҫ�ı��ֵ
	 * @param transitionTime
	 *            ��ʱʱ�䣨��λ100ms��
	 * @return
	 */
    public native int setDeviceLevel(DeviceInfo info, byte value, short transitionTime);
    
	/**
	 * ����豸ֵ��������� �����ȣ� �� �����getDeviceLevel_CallBack����ص����з���
	 * 
	 * @param info
	 *            Ҫ��ȡ�豸ֵ���豸������Ҫ��Uid��
	 */
    public native int getDeviceLevel(DeviceInfo info);

	/**
	 * �ı��豸ɫ�������Ͷ�
	 * 
	 * @param info
	 *            Ҫ�ı�ɫ�������Ͷȵ��豸
	 * @param hue
	 *            ɫ��
	 * @param sat
	 *            ���Ͷ�
	 */
	public native int setDeviceHueSat(DeviceInfo info, byte hue, byte sat);

	/**
	 * �ı��豸ɫ�������Ͷ�
	 * 
	 * @param info
	 *            Ҫ�ı�ɫ�������Ͷȵ��豸
	 * @param hue
	 *            ɫ��
	 * @param sat
	 *            ���Ͷ�
	 * @param transitionTime
	 *            ��ʱʱ�䣨��λ100ms��
	 * 
	 * @return
	 */
    public native int setDeviceHueSat(DeviceInfo info, byte hue, byte sat, short transitionTime);
	
	/**
	 * �ı��豸ɫ��
	 * 
	 * @param info
	 *            Ҫ�ı�ɫ�µ��豸
	 * @param value
	 *            ɫ��ֵ
	 */
    public native int SetColorTemperature(DeviceInfo info, int value);
    
    /**
	 * 
	 * �ı��豸ɫ��
	 * 
	 * @param info
	 *            Ҫ�ı�ɫ�µ��豸
	 * @param value
	 *            ɫ��ֵ
	 * @param transitionTime
	 *            ��ʱʱ�䣨��λ100ms��
	 * @return
	 */
    public native int SetColorTemperature(DeviceInfo info, int value, short transitionTime);

	/**
	 * ��ȡ�豸ɫ��������� getDeviceHue_CallBack����ص���
	 * 
	 * @param info
	 *            Ҫ��ȡ�豸ɫ�����豸 ������Ҫ��Uid��
	 */
    public native int getDeviceHue(DeviceInfo info);

	/**
	 * ��ȡ�豸���Ͷ�
	 * 
	 * @param info
	 *            Ҫ��ȡ�豸���Ͷȵ��豸������Ҫ��Uid��
	 */
    public native int getDeviceSat(DeviceInfo info);
    
	/**
	 * ��ȡ�豸ɫ��ֵ
	 * 
	 * @param info
	 *            Ҫ��ȡ�豸ɫ�µ��豸������Ҫ��Uid��
	 */
	public native int getColorTemperature(DeviceInfo info);
    
    /**
     * ���õƶ��Զ���ɫ
     * 
     * @param info Ҫ�ı��Զ���ɫ�ĵƾߣ�����Ҫ��Uid��
     * @param cmd  0x44
     * @param colorloop  1 ����
     * @param direction	 ����  1
     * @param times һ�����ڵ�ʱ�� 32
     * @param starthue hue��ʼֵ Ĭ��Ϊ0
     * @return
     */
	public native int SendautocolorZCL(DeviceInfo info, byte cmd,
			byte colorloop, byte direction, short times, short starthue);

    
	/***********************************************/
	/* about group */

	/**
	 * ��ȡ��ǰ������
	 * 
	 * @return ��ʹ�ô�������ʱ�����������������飻 ��ʹ��net��lanʱҪ���ô˺��������ͻ�ȡ�����飬�������
	 *         newGroup_CallBack ����ص��з��ء�
	 */
	public native GroupInfo[] getGroups();

	/**
	 * ��ȡָ�����Ա
	 * 
	 * @param groupId
	 *            ������ID
	 * @param Dinfo
	 *            ����null����
	 * @return ��ǰ�������г�Ա,��Ϊnet��lan����ʱ�������groupMember_CallBack�����з���
	 */
	public native DeviceInfo[] getGroupMember(short groupId, DeviceInfo Dinfo);

	/**
	 * ���һ������
	 * 
	 * @param groupName
	 *            Ҫ������������
	 * @return ��������ʱ���ɹ����ظ����id��ʧ�ܷ���-1��net��lan����ʱ������0����ӽ����newGroup_CallBack����ص���
	 */
	public native int addGroup(String groupName);

	/**
	 * �������������豸��״̬
	 * 
	 * @param groupId
	 *            Ҫ���õ�״̬�����id
	 * @param state
	 *            Ҫ���õ�״̬��0��1
	 */
    public native int setGroupState(short groupId, byte state);

	/**
	 * ������������lamp������
	 * 
	 * @param groupId
	 *            Ҫ���õ�״̬�����id
	 * @param level
	 *            ����ֵ
	 */
    public native int setGroupLevel(short groupId, byte level);

	/**
	 * ������������lamp��ɫ��
	 * 
	 * @param groupId
	 *            Ҫ���õ�״̬�����id
	 * @param hue
	 *            ɫ��ֵ
	 */
    public native int setGroupHue(short groupId, byte hue);

	/**
	 * ������������lamp�ı��Ͷ�
	 * 
	 * @param groupId
	 *            Ҫ���õ�״̬�����id
	 * @param sat
	 *            ���Ͷ�
	 */
    public native int setGroupSat(short groupId, byte sat);

	/**
	 * �������������豸�ı��Ͷȼ�ɫ��
	 * 
	 * @param groupId
	 *            Ҫ���õ�״̬�����id
	 * @param hue
	 *            ɫ��ֵ
	 * @param sat
	 *            ���Ͷ�
	 */
    public native int setGroupHueSat(short groupId, byte hue, byte sat);

	/**
	 * �������������豸��ɫ��
	 * 
	 * @param groupId
	 *            Ҫ���õ�״̬�����id
	 * @param hue
	 *            ɫ��ֵ
	 */
	public native int setGroupColorTemperature(short groupId, int value);

	/**
	 * ��ָ�����豸���뵽ָ��������
	 * 
	 * @param info
	 *            �豸��Ϣ ��������device uId��
	 * @param groupInfo
	 *            (�������groupName) ����Ϣ
	 */
    public native int addDeviceToGroup(DeviceInfo info, GroupInfo groupInfo);

	/**
	 * ��ָ�����豸������ɾ��
	 * 
	 * @param info
	 *            ��������device uId��
	 * @param groupInfo
	 *            (�������groupName)
	 */
    public native int deleteDeviceFromGroup(DeviceInfo info, GroupInfo groupInfo);

	/**
	 * ɾ��������
	 * 
	 * @param groupName
	 */
	public native int deleteGroup(String groupName);

	/***********************************************/
	/* about sence */

	/**
	 * ��ȡ��ǰ���г���
	 * 
	 * @return 
	 *         ���Ǵ�������ʱ�����������ص�ǰ���г���������lan��net����ʱ������NULL��������newSence_CallBack�����з���
	 */
	public native SenceInfo[] getSences();

	/**
	 * (��������)
	 * <p>
	 * ��֧��serial���ӷ�ʽ����Ҫ�� net����ʱ����
	 * <p>
	 * ��net������ʹ��addDeviceToSence���������������
	 * 
	 * @param sceneName
	 */
	public native void addSence(String sceneName);

	/**
	 * ��ָ�����豸������ӵ�ָ���ĳ����У������������ڣ��򴴽��³���
	 * 
	 * @param senceName
	 *            ������
	 * @param uid
	 *            Ҫ��ӵ��豸uid
	 * @param deviceId
	 *            Ҫ��ӵ��豸��deviceId
	 * @param data1
	 * @param data2
	 * @param data3
	 * @param data4
	 * @param IRID   deviceId ��Ϊ162����161������
	 * @param delaytime �ӳ�ʱ��Ϊ0-60s
	 */
	public native int addDeviceToSence(String senceName, int uid,
			short deviceId, byte data1, byte data2, byte data3, byte data4, int IRID, byte delaytime);
	

	/**
	 * ��ָ���ĳ���
	 * 
	 * @param senceId
	 *            Ҫ�򿪵ĳ�����ID
	 */
    public native int setSence(short sceneId);

	/**
	 * ��ȡָ����������ϸ��Ϣ�� �����getSenceDetails_CallBack()����ص��з���(ֻ��net��ʽ����ʱ�ɵ���)
	 * 
	 * @param senceId
	 *            ����Id
	 * @param senceName
	 *            ������
	 */
    public native int getSenceDetails(short sceneId, String sceneName);

	/**
	 * ɾ��������ָ���豸��Ա
	 * 
	 * @param senceName
	 *            ������
	 * @param uId
	 *            �豸uId
	 */
    public native int deleteSenceMember(String sceneName, int uId);


	/**
	 * ɾ��������ָ���豸��Ա
	 * 
	 * @param senceName
	 *            ������
	 * @param uId
	 *            �豸uId
	 * @param irId
	 *            ����id (0-255)
	 */
	public native int deleteSenceMember(String senceName, int uId, short irId);
	
	/**
	 * ɾ��ָ������
	 * 
	 * @param senceName
	 */
    public native int deleteSence(String sceneName);

	/**
	 * �޸ĳ�������
	 * 
	 * @param senceId
	 *            ����Id
	 * @param sName
	 *            �µĳ�����
	 */
	public native int ChangeSceneName(short sceneId, String newSceneName);

    
	/***********************************************/
	/* about task */
	/***********************************************/
	/**
	 * ��ȡ��ǰ��������
	 * 
	 * @return ��ʹ��wap��lan����ʱ����Ϊ�գ���ȡ�ĳ�����newTask_CallBack����ص�������
	 */
	public native TaskInfo[] getTasks();

	/**
	 * ��Ӷ�ʱ����
	 * 
	 * @param taskInfo
	 * @return
	 */
	public native int addTimerTask(String taskName, TaskTimerAction timerAction, short sceneId);

	/**
	 * ����豸��������
	 * 
	 * @param taskInfo
	 * @param isAlarm
	 *            �Ƿ���Ҫ����
	 * @return
	 */
	public native int addDeviceTask(String taskName, TaskDeviceAction deviceAction, short sceneId, byte isAlarm);

	/**
	 * ����豸��������
	 * 
	 * @param taskName
	 * @param deviceAction
	 * @param SenceName
	 * @param isAlarm
	 * @return
	 */
	public native int addDeviceAlarmTask(String taskName, TaskDeviceAction deviceAction);

	/**
	 * ��ӳ�������
	 * 
	 * @param taskInfo
	 * @return
	 */
	public native int addSenceTask(String taskName, short sceneId1, short sceneId2);

	/**
	 * ɾ��ָ������
	 * 
	 * @param taskName
	 *            ָ����������
	 * @return
	 */
	public native int deleteTask(String taskName);

	/**
	 * �鿴ָ���������ϸ��Ϣ,�����getTimerTaskDetails_CallBack/getDeviceTaskDetails_CallBack
	 * /getSenceTaskDetails_CallBack�з���
	 * 
	 * @param taskName
	 *            ָ����������
	 * @return
	 */
	public native TaskInfo getTaskInfo(String taskName);

	//
	// don't use timer
	//

	/**
	 * (��������)
	 * <p/>
	 * ��ʼ����ʱ��أ���ʹ��lan��wap����ʱ����Ҫ����
	 * 
	 * @return ���ص�ǰ���еĶ�ʱ����
	 */
	public native TimerInfo[] initTimer();

	/**
	 * �豸��ʱ
	 */
	public native int addDeviceTimer(int uid, byte workMode, byte h, byte m,
			byte s, byte taskId, byte data1, byte data2);

	/**
	 * �鶨ʱ
	 */
	public native int addGroupTimer(short groupId, byte workMode, byte h,
			byte m, byte s, byte taskId, byte data1, byte data2);

	/**
	 * (��������)
	 * <p/>
	 * ������ʱ
	 */
	public native int addSenceTimer(byte sceneId, byte workMode, byte h,
			byte m, byte s, byte taskId, byte data1, byte data2);

	/**
	 * ��ȡ���ж�ʱ����
	 * 
	 * @return ��Ϊserial����ʱ�����������ж�ʱ���񣬵�Ϊnet����ʱ�������getTimers_CallBack����ص��з���
	 */
	public native TimerInfo[] getTimers();

	/**
	 * ɾ����ʱ����
	 * 
	 * @param info
	 *            Ҫɾ���Ķ�ʱ����
	 * @return ɾ��ʧ�ܷ���С��0������ɾ���ɹ�
	 */
	public native int deleteTimer(TimerInfo info);

	/**
	 * ��������ָ��
	 */
    public native int permitJoin();
    
    /**
	 * �޸ĳ�������
	 * 
	 * @param info  Ҫ���õ��豸
     * @param cmd   0x04 (Store Scene)
     * @param sceneID ����ID
	 */
    public native int ModifySceneSwitchZCL(DeviceInfo info, byte cmd, byte sceneID);


	/**
	 * ��ָ���������豸��
	 * 
	 * @param sourceInfo
	 *            Դ�豸
	 * @param targetInfo
	 *            Ŀ���豸
	 */
	public native int bindDevices(DeviceInfo sourceInfo, DeviceInfo targetInfo);

	/**
	 * ��ָ���������豸�����
	 * 
	 * @param sourceInfo Դ�豸
	 * @param targetInfo Ŀ���豸
	 * @return
	 */
	public native int unBindDevice(DeviceInfo sourceInfo, DeviceInfo targetInfo);

	/**
	 * �������أ��������ݲ���
	 * 
	 * @param data
	 *            ���͵�����bin������
	 * @param readcnt
	 *            ���͵��ֽڳ��ȣ������һ����ÿ��ӦΪ256
	 * @param fileaddr
	 *            �ѷ��͵��ֽ��ܳ���
	 * @return
	 */

	public native int upd(byte[] data, int readcnt, long fileaddr);

	/**
	 * �����ݴ���󣬼��У�飬��ʼ����
	 * 
	 * @param fcrc
	 *            У���ֵ
	 * @return
	 */
	public native int updStart(long fcrc);
	
	/**
	 * �����û��Զ����ַ���
	 * @param info
	 *            �û��ַ���
	 * @return ��
	 */
	public native int setUserString(String userstring);
	
	/**
	 * ��ȡ�û��Զ����ַ����������getUserString_CallBack����
	 */
	public native void GetUserString();

	/**
	* ���ڲ��Զ������ݱȽϣ���ͬ�ſ��Խ��и��๦��
	*/
	public native void VerifyUserString(byte[] data);
	
	/***********************************************/
	/* about IR */
	/***********************************************/
	
	/**
	 *���ͺ���ѧϰ, �����IRstudyData_CallBack����
	 * @return
	 */	
	public native int IRStudy(DeviceInfo dInfo);
	
	/**
	 * �������ݵ�ת��
	 * @param learn_data_out IRstudyData_CallBack�з��ص�IRdata
	 * @return
	 */
    public native byte[] IRlearndatainout(byte learn_data_out[]);

	/**
	 *͸��
	 * @return
	 */
	public native int Transmit(DeviceInfo dInfo, byte[] dTransmitData);
	
	/**
	 *����������ݵ�������
	 * @return
	 */
	public native int SaveIRDataToGW(IRDataInfo irInfo, byte[] dIRData);
	
	/**
	 *��ȡ���к������������
	 * @return
	 */
	 public native int getAllIRdataName();
	
	/**
	 *ɾ����������
	 * @return
	 */
	public native int RemoveIRDataByIRDataId(IRDataInfo irInfo);

	/***********************************************/
	/* about DoorLock */
	/***********************************************/
	
	/**
	 * ��������ʱ��
	 * @param info ������uid��
	 * @param timeSeconds ��2000��1��1�տ�ʼ������
	 * @return
	 */
	public native int SetDoorLockTime(DeviceInfo info, int timeSeconds);

	/**
	 * ��ȡ����ʱ��
	 * @param info ������uid��
	 * @return
	 */
	public native int GetDoorLockTime(DeviceInfo info);
	
	/**
	 * ����������������״̬
	 * @param info������uid��
	 * @param controlable true �ɿ�/ false ���ɿ�
	 * @return
	 */
	public native int SetControlableState(DeviceInfo info, boolean controlable);

	/**
	 * ��ȡ������������״̬
	 * @param info ������uid��
	 * @return
	 */
	public native int GetControlableState(DeviceInfo info);

	/**
	 * ��ȡ����״̬
	 * 
	 * @param info������uid��
	 * @param witchState Ҫ��ȡ��״̬������д1    
	 * @return
	 */
	public native int GetDoorLockState(DeviceInfo info, byte witchState);
	
	/**
	 * �ı�����״̬
	 * 
	 * @param info Ҫ�ı�״̬���豸������Ҫ��Uid��
	 * @param state 1 �� / 0 ��
	 * @param gatedoorpassword ����
	 * @return
	 */
	public native int setGatedoorState(DeviceInfo info, int state, byte[] gatedoorpassword);
	
	/**
	 * ��ȡЭ������Ϣ�������getZigbeeModuleInfo_CallBack()����
	 * 
	 * @return
	 */
	public native int getZigbeeModuleInfo();
	

	
	/**
	 * �����ŵ�
	 * 
	 * @param channel �ŵ�
	 * @return
	 */
	public native int setChannel(byte channel);
	
	/**
	 * ��ȡָ���豸��RSSI�������getDeviceRSSI_CallBack����
	 * 
	 * @param info ָ���豸
	 * @return
	 */
	public native int getDeviceRSSI(DeviceInfo info);
	
	/*
	 * & ����Ϊjava�Ļص����� ��������Եõ���Ӧ�Ĵ��豸���صĸ������ݣ���Ҫ����ȥ������ & �����в�����Ϊ���ص��豸��Ϣ�����豸��ʶuId
	 */
	// ��ȡ�豸״̬,�ײ��һֱ�����豸״̬���ݴ˿���ͨ��uId���ж�ĳ���豸�Ƿ�����,��ͨ��state���ж��豸״̬��>0 ����<= 0�أ�
	public void getDeviceState_CallBack(int state, int uid) {
	}
	
	// ��ȡ�豸����
	public void getDeviceLevel_CallBack(int level, int uId)
	{
	}

	// ��ȡ�豸ɫ��
	public void getDeviceHue_CallBack(int hue, int uId)
	{
	}


	// ��ȡ�豸���Ͷ�
	public void getDeviceSat_CallBack(int sat, int uId)
	{
	}

	public void getColorTemperature_CallBack(int value, int uId)
	{
	}
	
	// ��ȡ�豸SNID��
	public void getDeviceSNID_CallBack(int snid, int uId)
	{
		
	}

	// ���豸����
	public void newDevice_CallBack(DeviceInfo dinfo)
	{
	
	}

	// �����µ���
	public void newGroup_CallBack(GroupInfo gInfo)
	{
	}
	
	// �����µĳ���
	public void newSence_CallBack(short senceId, String senceName)
	{
	}

	/**
	 * ���ػ�ȡ����ָ�������ϸ��Ϣ
	 * @param groupId
	 * @param deviceUid
	 */
	public void groupMember_CallBack(short groupId, int[] deviceUid) {
	}

	/**
	 * ���ػ�ȡ����ָ����������ϸ��Ϣ
	 * 
	 * @param senceId
	 * @param deviceNumber
	 * @param uId
	 * @param deviceId
	 * @param data1
	 * @param data2
	 * @param data3
	 * @param data4
	 * @param IRID
	 * @param delaytime
	 */
	public void getSenceDetails_CallBack(short senceId, int deviceNumber,
			int[] uId, short[] deviceId, byte[] data1, byte[] data2,
			byte[] data3, byte[] data4, byte[] IRID, byte[] delaytime) {
	}
	
	/**
	 * ����������Ϣ
	 * 
	 * @param ver ���ذ汾
	 * @param snid snid��
	 * @param uname �û���
	 * @param passwd �û�����
	 * @param DevSum �豸����
	 * @param GroupSum �����
	 * @param TimerSum ��ʱ����
	 * @param SceneSum ��������
	 * @param TaskSum �������
	 */
	public void gatewayInfo_CallBack(byte[] ver, byte[] snid, byte[] uname,
			byte[] passwd, byte DevSum, byte GroupSum, byte TimerSum,
			byte SceneSum, byte TaskSum) {
	}
	
	/**
	 * ���ش���������
	 * n
	 * @param uId
	 *            �������豸uId
	 * @param data
	 *            �������豸���ص�����ֵ
	 * @param attribID
	 *            �������������ͣ�00 �� �¶� 17��ʪ��
	 */
	public void arriveReport_CallBack(int uId, long data, char clusterId, char attribID) {

		
	}
	
	/**
	 * ��������״̬
	 * 
	 * @param uId
	 * @param data
	 * @param clusterId
	 * @param attribID
	 */
	public void arriveReportgatedoor_CallBack(int uId, byte[] data, char clusterId, char attribID) {
	}


	/**
	 * ������getTimerTasks()��addTask����ʱ����
	 */
	public void newTask_CallBack(byte taskType1, String taskName, short taskId) 
	{

	}

	/**
	 * ������getTaskInfo()ʱ����
	 * 
	 * @param taskId
	 *            task's id
	 * @param taskName
	 *            task's name
	 * @param action1
	 *            first task's action
	 * @param action2
	 *            second task's action
	 */
	public void getTimerTaskDetails_CallBack(String taskName, TaskTimerAction timerAction, short sceneId) 
	{

	}

	/**
	 * ������getTaskInfo()ʱ���أ����ػ�ȡ�豸��������
	 * 
	 * @param taskName
	 *            ������
	 * @param deviceAction
	 *            �豸����ʱ���豸������Ϣ
	 * @param senceName
	 *            ����ִ�г���
	 * @param isAlarm
	 *            �Ƿ񱨾���־
	 */
	public void getDeviceTaskDetails_CallBack(String taskName, TaskDeviceAction deviceAction, short sceneId, byte isAlarm)
	{

	}

	/**
	 * ������getTaskInfo()ʱ���أ����ػ�ȡ������������
	 * 
	 * @param taskName
	 *            ������
	 * @param senceName1
	 *            ִ�г���һ
	 * @param senceName2
	 *            ����ִ�г�����
	 */
	public void getSceneTaskDetails_CallBack(String taskName, short sceneId1, short sceneId2)
	{

	}

	/**
	 * ������getTimers()�����ض�ʱ��������
	 * 
	 * @param uid
	 * @param workMode
	 * @param h
	 * @param m
	 * @param s
	 * @param taskTye
	 * @param data1
	 * @param data2
	 * @param TaskId
	 */
	public void getTimers_CallBack(int uid, byte addrMode, byte workMode, byte h, byte m,
			byte s, byte taskType, byte data1, byte data2, byte taskId)
	{
	}
	
	/**
	 * ������GetUserString()ʱ���أ������û��Զ����ַ���
	 * 
	 * @param userStr
	 */
	public void getUserString_CallBack(String userStr)
	{

	}
	
	public void VerifiAccessString_CallBack(byte result)
	{
	}

	/**
	 * ������ getAllIRdataName()ʱ���أ������µĺ������� 
	 * 
	 * @param irInfo ����Ϣ������IRDataId��IRDataName��
	 */
	public void newIRData_CallBack(IRDataInfo irInfo) 
	{

	}

	/**
	 * ������IRStudy()ʱ���أ�����ѧϰ����
	 * 
	 * @param IRlen ���������ܳ�
	 * @param IRcurlen ����
	 * @param IRdata  ѧϰ����
	 */
	public void IRstudyData_CallBack(int IRlen, int IRcurlen, byte[] IRdata) 
	{
		
	}
	
	/**
	 * ������getZigbeeModuleInfoʱ����Э������Ϣ
	 * 
	 * @param channel �ŵ�
	 * @param pandId 
	 * @param expan
	 * @param version Э�����汾
	 */
	public void getZigbeeModuleInfo_CallBack(byte channel, byte[] pandId, byte[] expan, byte[] version){
	}
	
	/**
	 * ������addDeviceTimerʱ����
	 * 
	 * @param taskId 1~30 ��ӳɹ���0 ���ʧ��
	 */
	public void addTimer_CallBack(byte taskId) {

	}
	
	/**
	 * ������deleteTimerʱ����
	 * 
	 * @param taskId 1~30 ɾ���ɹ���0 ɾ��ʧ��
	 */
	public void delTimer_CallBack(byte taskId) {
		Log.d(TAG, "delTimer_CallBack  taskId = " + taskId);
	}
	
	/**
	 * ������getDeviceRSSIʱ�����豸RSSI
	 * 
	 * @param revRSSI   ����RSSI
	 * @param sendRSSI	����RSSI
	 */
	public void getDeviceRSSI_CallBack(int uid, byte revRSSI, byte sendRSSI)
	{
		
	}
	
	/**
	 * �ϱ�͸������
	 * 
	 * @param uid �豸uid
	 * @param data ����
	 */
	public void arriveReportTransmit_CallBack(int uid, byte[] data) {
		
	}
	
	
	/**
	 * �������ر�match description 30��
	 * 
	 * @return
	 */
	public native int setGatewayToMatchDes();
	
	/**
	 * ��ָ�����豸������
	 * 
	 * @param info
	 * @return
	 */
	public native int bindDeviceToGateway(DeviceInfo info);
	
	/**
	 * �޸�Ŀ���豸��IAS_CIE_AddressΪ����(�ᴥ��match description 30��)
	 * 
	 * @return
	 */
	public native int setDeviceCIEAddress();
	
	/**
	 * ���������������createZONE_CallBack���أ�
	 * 
	 * @param zoneName ��������(utf-8����)
	 * @param isdefense 1 ����/0 ����
	 * @param taskList �����б�TaskInfo�������taskId��isAble��
	 * @return
	 */
	public native int createZONE(byte[] zoneName, byte isdefense, List<TaskInfo> taskList);

	/**
	 * ������createZONEʱ�ص�
	 * 
	 * @param zoneName  ��������(���Ȳ�����36)
	 * @param zone		������
	 * @param isdefense	1 ����/0 ����
	 * @param ret		��ӷ���������λ  1 �ɹ�/0 ʧ��
	 */
	public void createZONE_CallBack(String zoneName, byte zone, byte isdefense, byte ret) {

	}
	
	/**
	 * �����������destoryZONE_CallBack���أ�
	 * 
	 * @param zone ������
	 * @param taskId ����ID�ϼ� (taskIdsΪNULL��ɾ������)
	 * @return
	 */
	public native int destoryZONE(byte zone, byte[] taskIds);
	
	/**
	 * ������destoryZONEʱ�ص�
	 * 
	 * @param zone		������
	 * @param taskId	����Id�ϼ�
	 * @param ret		���ٷ���������λ  1 �ɹ�/0 ʧ��
	 */
	public void destoryZONE_CallBack(byte zone, byte[] taskId, byte ret) {

	}
	
	/**
	 * ��ȡ������Ϣ�������getZONEInfo_CallBack����
	 * 
	 * @return
	 */
	public native int getZONEInfos();
	
	/**
	 * ������getZONEInfosʱ�������з���
	 * 
	 * @param zoneName	��������
	 * @param zone		������
	 * @param isdefense 1 ����/0 ����
	 */
	public void getZONEInfos_CallBack(String zoneName, byte zone, byte isdefense) {
	}
	
	/**
	 * ��ȡָ����������
	 * 
	 * @param zone	������
	 * @return
	 */
	public native int getZONEDetails(byte zone);
	
	/**
	 * ������getZONEDetailsʱ���ط�������
	 * 
	 * @param zoneName	��������
	 * @param zone		������
	 * @param isdefense 1 ����/0 ����
	 * @param taskId	����Id�ϼ�
	 * @param taskIsAble ����ʹ��λ�ϼ�
	 */
	public void getZONEDetails_CallBack(String zoneName, byte zone, byte isdefense, byte[] taskId, byte[] taskIsAble) {
	}
	
	/**
	 * ���÷���ʹ�ܣ������setZONEToAble_CallBack����
	 * 
	 * @param zone		������
	 * @param isable	1 ������Ч/0 ������Ч
	 * @return
	 */
	public native int setZONEToAble(byte zone, byte isable);
	
	/**
	 * ������setDefenseToAbleʱ���أ�����ʹ��λ
	 * 
	 * @param zone	������
	 * @param ret	1 �ɹ�/0 ʧ��
	 */
	public void setZONEToAble_CallBack(byte zone, byte ret) {

	}

	/**
	 * �޸ķ������ƣ������changeZONEName_CallBack����
	 * 
	 * @param zone		ָ��������
	 * @param zoneName	�µ�����
	 * @return
	 */
	public native int changeZONEName(byte zone, byte[] zoneName);
	
	/**
	 * ������changeZONENameʱ����(���Ȳ�����36)
	 * 
	 * @param zone		������
	 * @param zoneName	��������
	 * @param ret		1 �ɹ�/0 ʧ��
	 */
	public void changeZONEName_CallBack(byte zone, String zoneName, byte ret) {

	}
	
	/**
	 * ��ȡ�龰���صİ���Ϣ�������getBindScene_CallBack��getBindDevice_CallBack����
	 * 
	 * @return
	 */
	public native int getBindInfo();
	
	/**
	 * ������getBindInfoʱ����
	 * 
	 * @param uid		Դ�豸UID
	 * @param sceneId 	Ŀ���龰ID
	 */
	public void getBindScene_CallBack(int uid, int sceneId) {
		
	}
	
	/**
	 * ������getBindInfoʱ����
	 * 
	 * @param uid		Դ�豸UID
	 * @param tarUid	Ŀ���豸UID
	 */
	public void getBindDevice_CallBack(int uid, int[] tarUid) {
		
	}
	
		/**
	 * �����������ƣ�
	 * 
	 * @param groupId	ָ������ID
	 * @param name		�µ�����(utf-8����)
	 * @return
	 */
	public native int changeGroupName(short groupId, byte[] name);
	
	/**
	 * ������changeGroupNameʱ����
	 * 
	 * @param groupId	ָ������ID
	 * @param name		�µ�����
	 */
	public void changeGroupName_CallBack(short groupId, String name) {
		
	}
	
	/**
	 *  ��ȡָ���豸��ǰ��״̬
	 * 
	 * @param deviceInfo	ָ���豸(���� uid)
	 * @param cmd			0x00 ��ȡ�豸��ǰ��״̬,�����getDeviceInfo_CallBack����
	 * @return
	 */
	public native int identifyDevice(DeviceInfo deviceInfo, byte cmd);
	
	/**
	 * ������identifyDevice��cmdΪ0x00ʱ����
	 * 
	 * @param uid		ָ���豸
	 * @param loopColor	�Զ���ɫ���λ
	 * @param reserve1
	 * @param reserve2
	 * @param reserve3
	 */
	public void getDeviceInfo_CallBack(int uid, int loopColor, int reserve1, int reserve2, int reserve3) {
		
	}
	
		/**
	 * ������resetGateway����
	 * 
	 * @param ret 0xa1 �ɹ�������ʧ��
	 */
	public void resetGateway_Callback(int ret) {
		
	}

	public void PermissionState_CallBack(byte per){
	}
}
