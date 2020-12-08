package com.fanhehe.user.business.doll.wave.pojo.result;

import java.io.Serializable;
import java.util.List;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/8 15:40
 */
public class WaveResult implements Serializable {

    private int energy;
    private long nextTime;
    private long serverTime;
    private List<WaveRecord> recordList;

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public long getNextTime() {
        return nextTime;
    }

    public void setNextTime(long nextTime) {
        this.nextTime = nextTime;
    }

    public long getServerTime() {
        return serverTime;
    }

    public void setServerTime(long serverTime) {
        this.serverTime = serverTime;
    }

    public List<WaveRecord> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<WaveRecord> recordList) {
        this.recordList = recordList;
    }
}
