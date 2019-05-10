package com.dxtx.codec;

import java.io.Serializable;

/**
 * Created by user on 2016/8/29.
 */
public class VideoCodecModel implements Serializable {

    private static final long serialVersionUID = -1307249622002520298L;
    public String srcPath;
   
    public String dstPath;
   
    public long videoCreateTime;

    public int id;
    //0为被限制的状态,50为渲染中,或渲染队列中,100为已完成,-100为已删除,500为已上传
   
    public int finish = 0;
   
    public String serno;

    //操作是用到,不需要存数据库
    public boolean select;

    public VideoCodecModel(String srcPath, String dstPath, long videoCreateTime) {
        this.srcPath = srcPath;
        this.videoCreateTime = videoCreateTime;
        this.dstPath = dstPath;
    }

    public VideoCodecModel() {
    }

    public String getSrcPath() {
        return srcPath;
    }

    public void setSrcPath(String srcPath) {
        this.srcPath = srcPath;
    }

    public String getDstPath() {
        return dstPath;
    }

    public void setDstPath(String dstPath) {
        this.dstPath = dstPath;
    }

    public long getVideoCreateTime() {
        return videoCreateTime;
    }

    public void setVideoCreateTime(long videoCreateTime) {
        this.videoCreateTime = videoCreateTime;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VideoCodecModel)) return false;

        VideoCodecModel that = (VideoCodecModel) o;

        if (videoCreateTime != that.videoCreateTime) return false;
        if (!srcPath.equals(that.srcPath)) return false;
        return dstPath.equals(that.dstPath);

    }
}
