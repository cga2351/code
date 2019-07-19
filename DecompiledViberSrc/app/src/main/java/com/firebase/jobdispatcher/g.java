package com.firebase.jobdispatcher;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public final class g
  implements c
{
  private final s a;
  private final Context b;
  private final PendingIntent c;
  private final i d;
  private final boolean e = true;

  public g(Context paramContext)
  {
    this.b = paramContext;
    this.c = PendingIntent.getBroadcast(paramContext, 0, new Intent(), 0);
    this.d = new i();
    this.a = new b(paramContext);
  }

  private Intent a(p paramp)
  {
    Intent localIntent = c("SCHEDULE_TASK");
    localIntent.putExtras(this.d.a(paramp, localIntent.getExtras()));
    return localIntent;
  }

  private Intent c(String paramString)
  {
    Intent localIntent = new Intent("com.google.android.gms.gcm.ACTION_SCHEDULE");
    localIntent.setPackage("com.google.android.gms");
    localIntent.putExtra("scheduler_action", paramString);
    localIntent.putExtra("app", this.c);
    localIntent.putExtra("source", 8);
    localIntent.putExtra("source_version", 1);
    return localIntent;
  }

  public int a(l paraml)
  {
    this.b.sendBroadcast(a(paraml));
    GooglePlayReceiver.a(paraml);
    return 0;
  }

  public int a(String paramString)
  {
    this.b.sendBroadcast(b(paramString));
    return 0;
  }

  public s a()
  {
    return this.a;
  }

  protected Intent b(String paramString)
  {
    Intent localIntent = c("CANCEL_TASK");
    localIntent.putExtra("tag", paramString);
    localIntent.putExtra("component", new ComponentName(this.b, c()));
    return localIntent;
  }

  public boolean b()
  {
    return true;
  }

  protected Class<GooglePlayReceiver> c()
  {
    return GooglePlayReceiver.class;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.firebase.jobdispatcher.g
 * JD-Core Version:    0.6.2
 */