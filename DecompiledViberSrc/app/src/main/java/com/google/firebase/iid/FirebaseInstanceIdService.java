package com.google.firebase.iid;

import android.content.Intent;
import android.util.Log;
import java.util.Queue;

@Deprecated
public class FirebaseInstanceIdService extends zzc
{
  protected final Intent a(Intent paramIntent)
  {
    return (Intent)x.a().a.poll();
  }

  @Deprecated
  public void a()
  {
  }

  public final void b(Intent paramIntent)
  {
    if ("com.google.firebase.iid.TOKEN_REFRESH".equals(paramIntent.getAction()))
      a();
    String str1;
    do
    {
      do
      {
        return;
        str1 = paramIntent.getStringExtra("CMD");
      }
      while (str1 == null);
      if (Log.isLoggable("FirebaseInstanceId", 3))
      {
        String str2 = String.valueOf(paramIntent.getExtras());
        Log.d("FirebaseInstanceId", 21 + String.valueOf(str1).length() + String.valueOf(str2).length() + "Received command: " + str1 + " - " + str2);
      }
      if (("RST".equals(str1)) || ("RST_FULL".equals(str1)))
      {
        FirebaseInstanceId.getInstance().zzn();
        return;
      }
    }
    while (!"SYNC".equals(str1));
    FirebaseInstanceId.getInstance().zzp();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.iid.FirebaseInstanceIdService
 * JD-Core Version:    0.6.2
 */