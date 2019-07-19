package com.google.android.gms.internal.ads;

final class zzbcw
  implements Runnable
{
  zzbcw(zzbcr paramzzbcr, boolean paramBoolean)
  {
  }

  public final void run()
  {
    zzbcr localzzbcr = this.zzecp;
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "isVisible";
    arrayOfString[1] = String.valueOf(this.zzecq);
    zzbcr.zza(localzzbcr, "windowVisibilityChanged", arrayOfString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbcw
 * JD-Core Version:    0.6.2
 */