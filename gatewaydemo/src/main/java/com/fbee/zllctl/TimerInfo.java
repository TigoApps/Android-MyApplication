package com.fbee.zllctl;

import java.io.Serializable;

/**
 * not used int this project
 *
 * @author Administrator 
 */
public class TimerInfo implements Serializable
{
    private static final long serialVersionUID = 4648754865930431655L;
    // ��ʱ����id
    private byte timerId;
    // 0x01 for device,0x02 for group,0x03 for sence
    private byte timerType;
    /*
     * if timerType is 0x01 then "device" is Uid, if timerType == 0x02 then
     * "device" is groupId, else if timerType == 0x03 then "device" is senceId,
     */
    private int device;
    /*
     * 0x01 ��һ��Ч 0x02 �ܶ���Ч 0x04 ������Ч 0x08 ������Ч 0x10 ������Ч 0x20 ������Ч 0x40 ������Ч
     */
    private byte workMode;
    private byte h;
    private byte m;
    private byte s;
    // taskType : 0x01 for on-off ,0x02 for level ,0x03 for hue-sat
    private byte taskType;
    private byte data1;
    private byte data2;
	public byte AddressMode;

    public TimerInfo(int device, byte timerId, byte workMode, byte h, byte m,
            byte s, byte taskType, byte data1, byte data2)
    {
        this.device = device;
        this.timerId = timerId;
        this.workMode = workMode;
        this.h = h;
        this.m = m;
        this.s = s;
        this.taskType = taskType;
        this.data1 = data1;
        this.data2 = data2;
    }
	
	public TimerInfo(int device, byte addressMode, byte timerId, byte workMode,
			byte h, byte m, byte s, byte taskType, byte data1, byte data2)
	{
		this.device = device;
		this.AddressMode = addressMode;
		this.timerId = timerId;
		this.workMode = workMode;
		this.h = h;
		this.m = m;
		this.s = s;
		this.taskType = taskType;
		this.data1 = data1;
		this.data2 = data2;
	}

    public byte getTimerId()
    {
        return timerId;
    }

    public void setTimerId(byte timerId)
    {
        this.timerId = timerId;
    }

    public byte getTimerType()
    {
        return timerType;
    }

    public void setTimerType(byte timerType)
    {
        this.timerType = timerType;
    }

    public int getDevice()
    {
        return device;
    }

    public void setDevice(int device)
    {
        this.device = device;
    }

    public byte getWorkMode()
    {
        return workMode;
    }

    public void setWorkMode(byte workMode)
    {
        this.workMode = workMode;
    }

    public byte getH()
    {
        return h;
    }

    public void setH(byte h)
    {
        this.h = h;
    }

    public byte getM()
    {
        return m;
    }

    public void setM(byte m)
    {
        this.m = m;
    }

    public byte getS()
    {
        return s;
    }

    public void setS(byte s)
    {
        this.s = s;
    }

    public byte getTaskType()
    {
        return taskType;
    }

    public void setTaskType(byte taskType)
    {
        this.taskType = taskType;
    }

    public byte getData1()
    {
        return data1;
    }

    public void setData1(byte data1)
    {
        this.data1 = data1;
    }

    public byte getData2()
    {
        return data2;
    }

    public void setData2(byte data2)
    {
        this.data2 = data2;
    }

}
