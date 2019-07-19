package com.google.android.gms.auth.api.signin;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.zzw;

public final class RevocationBoundService extends Service
{
  public final IBinder onBind(Intent paramIntent)
  {
    if (("com.google.android.gms.auth.api.signin.RevocationBoundService.disconnect".equals(paramIntent.getAction())) || ("com.google.android.gms.auth.api.signin.RevocationBoundService.clearClientState".equals(paramIntent.getAction())))
    {
      String str1;
      if (Log.isLoggable("RevocationService", 2))
      {
        str1 = String.valueOf(paramIntent.getAction());
        if (str1.length() == 0)
          break label71;
      }
      label71: for (String str2 = "RevocationBoundService handling ".concat(str1); ; str2 = new String("RevocationBoundService handling "))
      {
        Log.v("RevocationService", str2);
        return new zzw(this);
      }
    }
    String str3 = String.valueOf(paramIntent.getAction());
    if (str3.length() != 0);
    for (String str4 = "Unknown action sent to RevocationBoundService: ".concat(str3); ; str4 = new String("Unknown action sent to RevocationBoundService: "))
    {
      Log.w("RevocationService", str4);
      return null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.RevocationBoundService
 * JD-Core Version:    0.6.2
 */