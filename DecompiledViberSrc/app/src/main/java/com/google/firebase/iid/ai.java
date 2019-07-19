package com.google.firebase.iid;

import android.os.Binder;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.ExecutorService;

public final class ai extends Binder
{
  private final zzc a;

  ai(zzc paramzzc)
  {
    this.a = paramzzc;
  }

  public final void a(ag paramag)
  {
    if (Binder.getCallingUid() != Process.myUid())
      throw new SecurityException("Binding only allowed within app");
    if (Log.isLoggable("EnhancedIntentService", 3))
      Log.d("EnhancedIntentService", "service received new intent via bind strategy");
    if (this.a.c(paramag.a))
    {
      paramag.a();
      return;
    }
    if (Log.isLoggable("EnhancedIntentService", 3))
      Log.d("EnhancedIntentService", "intent being queued for bg execution");
    this.a.a.execute(new ah(this, paramag));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.iid.ai
 * JD-Core Version:    0.6.2
 */