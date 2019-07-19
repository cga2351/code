package com.viber.jni;

import android.os.Bundle;
import java.util.Arrays;

public class CSecondaryDeviceDetails
{
  public CSecondaryDeviceDetailsElement[] elements;
  public int status;

  private CSecondaryDeviceDetails(Bundle paramBundle)
  {
    this.status = paramBundle.getInt("Status");
    int i = paramBundle.getInt("MsgSize");
    if (i > 0)
    {
      this.elements = new CSecondaryDeviceDetailsElement[i];
      for (int j = 0; j < i; j++)
      {
        Bundle localBundle = paramBundle.getBundle("Msg" + j);
        this.elements[j] = new CSecondaryDeviceDetailsElement(localBundle, null);
      }
    }
  }

  public String toString()
  {
    return "CSecondaryDeviceDetails{elements=" + Arrays.toString(this.elements) + '}';
  }

  public static class CSecondaryDeviceDetailsElement
  {
    public long lastLogin;
    public String location;
    public String osName;
    public String osVersion;
    public int system;
    public String systemName;
    public byte[] udid;
    public String viberVersion;

    private CSecondaryDeviceDetailsElement(Bundle paramBundle)
    {
      this.udid = paramBundle.getByteArray("UDID");
      this.osName = paramBundle.getString("OSName");
      this.lastLogin = paramBundle.getLong("LastLogin");
      this.location = paramBundle.getString("Location");
      this.osVersion = paramBundle.getString("OSVersion");
      this.viberVersion = paramBundle.getString("ViberVersion");
      this.system = paramBundle.getInt("System");
      this.systemName = paramBundle.getString("SystemName");
    }

    public String toString()
    {
      return "CSecondaryDeviceDetailsElement{udid=" + Arrays.toString(this.udid) + ", osName='" + this.osName + '\'' + ", lastLogin=" + this.lastLogin + '\'' + ", location='" + this.location + '\'' + ", osVersion='" + this.osVersion + '\'' + ", viberVersion='" + this.viberVersion + '\'' + ", system='" + this.system + '\'' + ", systemName='" + this.systemName + '}';
    }
  }

  public static final class EState
  {
    public static final int FAILED = 1;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.CSecondaryDeviceDetails
 * JD-Core Version:    0.6.2
 */