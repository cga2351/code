package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;

@zzare
public final class zzbin extends MutableContextWrapper
{
  private Activity zzdym;
  private Context zzeml;
  private Context zzys;

  public zzbin(Context paramContext)
  {
    super(paramContext);
    setBaseContext(paramContext);
  }

  public final Object getSystemService(String paramString)
  {
    return this.zzeml.getSystemService(paramString);
  }

  public final void setBaseContext(Context paramContext)
  {
    this.zzys = paramContext.getApplicationContext();
    if ((paramContext instanceof Activity));
    for (Activity localActivity = (Activity)paramContext; ; localActivity = null)
    {
      this.zzdym = localActivity;
      this.zzeml = paramContext;
      super.setBaseContext(this.zzys);
      return;
    }
  }

  public final void startActivity(Intent paramIntent)
  {
    if (this.zzdym != null)
    {
      this.zzdym.startActivity(paramIntent);
      return;
    }
    paramIntent.setFlags(268435456);
    this.zzys.startActivity(paramIntent);
  }

  public final Context zzaad()
  {
    return this.zzeml;
  }

  public final Activity zzyd()
  {
    return this.zzdym;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbin
 * JD-Core Version:    0.6.2
 */