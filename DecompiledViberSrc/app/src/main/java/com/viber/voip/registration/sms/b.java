package com.viber.voip.registration.sms;

import android.os.SystemClock;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import com.google.android.gms.tasks.Task;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.concurrent.TimeUnit;

public class b
{
  private static final Logger a = ViberEnv.getLogger();
  private static final long b = TimeUnit.MINUTES.toMillis(4L);
  private static long c = 0L;

  public static void a(SmsRetrieverClient paramSmsRetrieverClient)
  {
    long l = SystemClock.elapsedRealtime();
    if (l - c < b)
    {
      (l - c);
      return;
    }
    c = l;
    Task localTask = paramSmsRetrieverClient.startSmsRetriever();
    localTask.addOnSuccessListener(c.a);
    localTask.addOnFailureListener(d.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.sms.b
 * JD-Core Version:    0.6.2
 */