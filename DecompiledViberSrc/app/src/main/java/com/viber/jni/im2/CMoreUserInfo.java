package com.viber.jni.im2;

import java.util.Map;

public class CMoreUserInfo
{
  private static final String BAN = "Ban";
  public final Map<Integer, String> data;

  public CMoreUserInfo(Map<Integer, String> paramMap)
  {
    this.data = Im2Utils.checkMapValue(paramMap);
    init();
  }

  private void init()
  {
  }

  public boolean isBanned()
  {
    return "Ban".equalsIgnoreCase((String)this.data.get(Integer.valueOf(5)));
  }

  public String toString()
  {
    return "CMoreUserInfo{data=" + this.data + '}';
  }

  public static class MoreUserInfoKeys
  {
    public static final int Banned = 5;
    public static final int ChatBackground = 6;
    public static final int DownloadID = 3;
    public static final int EncryptedMID = 2;
    public static final int EncryptedPhoneNumber = 1;
    public static final int SenderName = 4;
    public static final int UserType;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CMoreUserInfo
 * JD-Core Version:    0.6.2
 */