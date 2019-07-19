package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.google.android.gms.ads.internal.zzk;

final class zzapq
  implements DialogInterface.OnClickListener
{
  zzapq(zzapp paramzzapp)
  {
  }

  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Intent localIntent = this.zzdhy.createIntent();
    zzk.zzlg();
    zzaxj.zza(zzapp.zza(this.zzdhy), localIntent);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzapq
 * JD-Core Version:    0.6.2
 */