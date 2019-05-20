package mqms.ncp.navercorp.com.testgpuimage;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by xiangning on 2019/2/12.
 */

public class StartPlayVideoReq implements Parcelable {
    Long addWaterMarkTimeStamp;
    Long duration;
    String playVideoFullPath;
    String recordVideoFullPath;

    public Long getAddWaterMarkTimeStamp() {
        return addWaterMarkTimeStamp;
    }

    public void setAddWaterMarkTimeStamp(Long addWaterMarkTimeStamp) {
        this.addWaterMarkTimeStamp = addWaterMarkTimeStamp;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getPlayVideoFullPath() {
        return playVideoFullPath;
    }

    public void setPlayVideoFullPath(String playVideoFullPath) {
        this.playVideoFullPath = playVideoFullPath;
    }

    public String getRecordVideoFullPath() {
        return recordVideoFullPath;
    }

    public void setRecordVideoFullPath(String recordVideoFullPath) {
        this.recordVideoFullPath = recordVideoFullPath;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.addWaterMarkTimeStamp);
        dest.writeValue(this.duration);
        dest.writeString(this.playVideoFullPath);
        dest.writeString(this.recordVideoFullPath);
    }

    public StartPlayVideoReq() {
    }

    protected StartPlayVideoReq(Parcel in) {
        this.addWaterMarkTimeStamp = (Long) in.readValue(Long.class.getClassLoader());
        this.duration = (Long) in.readValue(Long.class.getClassLoader());
        this.playVideoFullPath = in.readString();
        this.recordVideoFullPath = in.readString();
    }

    public static final Creator<StartPlayVideoReq> CREATOR = new Creator<StartPlayVideoReq>() {
        @Override
        public StartPlayVideoReq createFromParcel(Parcel source) {
            return new StartPlayVideoReq(source);
        }

        @Override
        public StartPlayVideoReq[] newArray(int size) {
            return new StartPlayVideoReq[size];
        }
    };
}
