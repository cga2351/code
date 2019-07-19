package com.my.target;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ao extends al
{
  private boolean a;
  private String b;

  private void a(NetworkInfo paramNetworkInfo)
  {
    if (paramNetworkInfo.getType() == 0)
    {
      if (paramNetworkInfo.getSubtypeName() != null);
      for (String str2 = paramNetworkInfo.getSubtypeName(); ; str2 = "")
      {
        a("connection_type", str2);
        return;
      }
    }
    if (paramNetworkInfo.getTypeName() != null);
    for (String str1 = paramNetworkInfo.getTypeName(); ; str1 = "")
    {
      a("connection_type", str1);
      return;
    }
  }

  @SuppressLint({"MissingPermission"})
  public void a(Context paramContext)
  {
    while (true)
    {
      try
      {
        b();
        this.a = true;
        this.b = "";
        try
        {
          ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
          if (localConnectivityManager != null)
          {
            localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
            if (localNetworkInfo != null)
            {
              this.a = localNetworkInfo.isConnected();
              this.b = localNetworkInfo.getTypeName();
              a("connection", this.b);
              a(localNetworkInfo);
            }
            return;
          }
        }
        catch (SecurityException localSecurityException)
        {
          dp.a("No permissions for access to network state");
          continue;
        }
      }
      finally
      {
      }
      NetworkInfo localNetworkInfo = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.ao
 * JD-Core Version:    0.6.2
 */