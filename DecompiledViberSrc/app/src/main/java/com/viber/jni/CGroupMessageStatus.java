package com.viber.jni;

import android.os.Bundle;
import java.util.Arrays;

public class CGroupMessageStatus
{
  public int status;
  public long token;
  public CReadData[] users;

  private CGroupMessageStatus(Bundle paramBundle)
  {
    this.token = paramBundle.getLong("Token");
    this.status = paramBundle.getInt("Status");
    int i = paramBundle.getInt("UsersSize");
    if (i > 0)
    {
      this.users = new CReadData[i];
      for (int j = 0; j < i; j++)
      {
        Bundle localBundle = paramBundle.getBundle("User" + j);
        this.users[j] = new CReadData(localBundle, null);
      }
    }
  }

  public String toString()
  {
    return "CGroupMessageStatus{token=" + this.token + ", status=" + this.status + ", users=" + Arrays.toString(this.users) + '}';
  }

  public static class CReadData
  {
    public String phoneNumber;
    public long timeSeen;

    private CReadData(Bundle paramBundle)
    {
      this.phoneNumber = paramBundle.getString("PhoneNumber");
      this.timeSeen = paramBundle.getLong("TimeSeen");
    }

    public String toString()
    {
      return "CReadData{phoneNumber='" + this.phoneNumber + '\'' + ", timeSeen=" + this.timeSeen + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.CGroupMessageStatus
 * JD-Core Version:    0.6.2
 */