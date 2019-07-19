package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

final class zzm
  implements zzn
{
  private final PendingIntent zzav;
  private final Context zzl;

  zzm(Context paramContext)
  {
    this.zzl = paramContext;
    this.zzav = PendingIntent.getBroadcast(paramContext, 0, new Intent().setPackage("com.google.example.invalidpackage"), 0);
  }

  private final Intent zzh(String paramString)
  {
    Intent localIntent = new Intent("com.google.android.gms.gcm.ACTION_SCHEDULE");
    localIntent.setPackage("com.google.android.gms");
    localIntent.putExtra("app", this.zzav);
    localIntent.putExtra("source", 4);
    localIntent.putExtra("source_version", 12451000);
    localIntent.putExtra("scheduler_action", paramString);
    return localIntent;
  }

  public final boolean zzd(ComponentName paramComponentName)
  {
    Intent localIntent = zzh("CANCEL_ALL");
    localIntent.putExtra("component", paramComponentName);
    this.zzl.sendBroadcast(localIntent);
    return true;
  }

  public final boolean zzd(ComponentName paramComponentName, String paramString)
  {
    Intent localIntent = zzh("CANCEL_TASK");
    localIntent.putExtra("component", paramComponentName);
    localIntent.putExtra("tag", paramString);
    this.zzl.sendBroadcast(localIntent);
    return true;
  }

  public final boolean zzd(Task paramTask)
  {
    Intent localIntent = zzh("SCHEDULE_TASK");
    Bundle localBundle = new Bundle();
    paramTask.toBundle(localBundle);
    localIntent.putExtras(localBundle);
    this.zzl.sendBroadcast(localIntent);
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.gcm.zzm
 * JD-Core Version:    0.6.2
 */