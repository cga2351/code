package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

final class zzcjd
  implements zzbao<SQLiteDatabase>
{
  zzcjd(zzcjb paramzzcjb, zzczb paramzzczb)
  {
  }

  public final void zzb(Throwable paramThrowable)
  {
    String str1 = String.valueOf(paramThrowable.getMessage());
    if (str1.length() != 0);
    for (String str2 = "Failed to get offline signal database: ".concat(str1); ; str2 = new String("Failed to get offline signal database: "))
    {
      zzaxa.zzen(str2);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcjd
 * JD-Core Version:    0.6.2
 */