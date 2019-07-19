package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;

final class zzayk
  implements Runnable
{
  zzayk(zzayj paramzzayj, Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
  }

  public final void run()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.val$context);
    localBuilder.setMessage(this.zzdwt);
    if (this.zzdwu)
    {
      localBuilder.setTitle("Error");
      if (!this.zzdwv)
        break label68;
      localBuilder.setNeutralButton("Dismiss", null);
    }
    while (true)
    {
      localBuilder.create().show();
      return;
      localBuilder.setTitle("Info");
      break;
      label68: localBuilder.setPositiveButton("Learn More", new zzayl(this));
      localBuilder.setNegativeButton("Dismiss", null);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzayk
 * JD-Core Version:    0.6.2
 */