package com.fbee.zllctl;

/**
 * ÿ���������������������һ��Ψһ������id��taskId����������
 * 
 * @author Administrator
 */
public class TaskInfo
{
    // ����id��it can only get from gateway ,don't modify it
    private short taskId;
    // ������
    private String taskName;
    //��һ����������
    private byte taskType;
    //�жϸ����񴥷�ʱ���Ƿ�ᱨ��
    private byte isAlarm;
    //ʹ��λ
    private byte isAble;

    public short getTaskId()
    {
        return taskId;
    }

    public void setTaskId(short taskId)
    {
        this.taskId = taskId;
    }

    public String getTaskName()
    {
        return taskName;
    }

    public void setTaskName(String taskName)
    {
        this.taskName = taskName;
    }

    public byte getTaskType()
    {
        return taskType;
    }

    public void setTaskType(byte taskType)
    {
        this.taskType = taskType;
    }

    public byte getIsAlarm()
    {
        return isAlarm;
    }

    public void setIsAlarm(byte isAlarm)
    {
        this.isAlarm = isAlarm;
    }
	
		public byte getIsAble() {
		return isAble;
	}

	public void setIsAble(byte isAble) {
		this.isAble = isAble;
	}
}
