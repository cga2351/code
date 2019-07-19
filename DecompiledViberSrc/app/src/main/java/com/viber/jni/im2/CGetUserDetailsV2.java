package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CGetUserDetailsV2
{
  public final String downloadID;
  public final String mid;
  public final CMoreUserInfo moreInfo;
  public final String name;
  public final String phoneNumber;
  public final int status;
  public final String vid;

  public CGetUserDetailsV2(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, CMoreUserInfo paramCMoreUserInfo, int paramInt)
  {
    this.phoneNumber = Im2Utils.checkStringValue(paramString1);
    this.mid = Im2Utils.checkStringValue(paramString2);
    this.vid = Im2Utils.checkStringValue(paramString3);
    this.downloadID = Im2Utils.checkStringValue(paramString4);
    this.name = Im2Utils.checkStringValue(paramString5);
    this.moreInfo = ((CMoreUserInfo)Im2Utils.checkStructValue(paramCMoreUserInfo));
    this.status = paramInt;
    init();
  }

  private void init()
  {
  }

  public String toString()
  {
    return "CGetUserDetailsV2{phoneNumber='" + this.phoneNumber + '\'' + ", mid='" + this.mid + '\'' + ", vid='" + this.vid + '\'' + ", downloadID='" + this.downloadID + '\'' + ", name='" + this.name + '\'' + ", moreInfo=" + this.moreInfo + ", status=" + this.status + '}';
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int USER_DETAILS_INVALID_INPUT = 2;
    public static final int USER_DETAILS_NOT_REG = 3;
    public static final int USER_DETAILS_OK = 1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CGetUserDetailsV2
 * JD-Core Version:    0.6.2
 */