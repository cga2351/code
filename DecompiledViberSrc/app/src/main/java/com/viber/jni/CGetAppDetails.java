package com.viber.jni;

import android.os.Bundle;

public class CGetAppDetails
{
  public final int appId;
  public final String clientData;
  public final String name;
  public final String platformData;
  public final boolean replyable;
  public final int status;
  public final int type;

  private CGetAppDetails(Bundle paramBundle)
  {
    this.appId = paramBundle.getInt("AppID");
    this.type = paramBundle.getInt("type");
    this.name = paramBundle.getString("Name");
    this.status = paramBundle.getInt("Status");
    this.clientData = paramBundle.getString("ClientData");
    this.replyable = paramBundle.getBoolean("Replyable");
    this.platformData = paramBundle.getString("PlatformData");
  }

  public String toString()
  {
    return "CGetAppDetails{appId=" + this.appId + ", type=" + this.type + ", name='" + this.name + '\'' + ", status=" + this.status + ", clientData='" + this.clientData + '\'' + ", replyable=" + this.replyable + ", platformData='" + this.platformData + '\'' + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.CGetAppDetails
 * JD-Core Version:    0.6.2
 */