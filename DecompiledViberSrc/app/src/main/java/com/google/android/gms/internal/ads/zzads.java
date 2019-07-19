package com.google.android.gms.internal.ads;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;

@zzare
public final class zzads extends zzaea
{
  private static final int zzcxy = Color.rgb(12, 174, 206);
  private static final int zzcxz = i;
  private static final int zzcya = i;
  private static final int zzcyb = zzcxy;
  private final int backgroundColor;
  private final int textColor;
  private final int textSize;
  private final String zzcyc;
  private final List<zzadv> zzcyd = new ArrayList();
  private final List<zzaeh> zzcye = new ArrayList();
  private final int zzcyf;
  private final int zzcyg;
  private final boolean zzcyh;

  static
  {
    int i = Color.rgb(204, 204, 204);
  }

  public zzads(String paramString, List<zzadv> paramList, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.zzcyc = paramString;
    if (paramList != null)
      for (int m = 0; m < paramList.size(); m++)
      {
        zzadv localzzadv = (zzadv)paramList.get(m);
        this.zzcyd.add(localzzadv);
        this.zzcye.add(localzzadv);
      }
    int i;
    int j;
    if (paramInteger1 != null)
    {
      i = paramInteger1.intValue();
      this.backgroundColor = i;
      if (paramInteger2 == null)
        break label171;
      j = paramInteger2.intValue();
      label120: this.textColor = j;
      if (paramInteger3 == null)
        break label179;
    }
    label171: label179: for (int k = paramInteger3.intValue(); ; k = 12)
    {
      this.textSize = k;
      this.zzcyf = paramInt1;
      this.zzcyg = paramInt2;
      this.zzcyh = paramBoolean;
      return;
      i = zzcya;
      break;
      j = zzcyb;
      break label120;
    }
  }

  public final int getBackgroundColor()
  {
    return this.backgroundColor;
  }

  public final String getText()
  {
    return this.zzcyc;
  }

  public final int getTextColor()
  {
    return this.textColor;
  }

  public final int getTextSize()
  {
    return this.textSize;
  }

  public final List<zzaeh> zzra()
  {
    return this.zzcye;
  }

  public final List<zzadv> zzrb()
  {
    return this.zzcyd;
  }

  public final int zzrc()
  {
    return this.zzcyf;
  }

  public final int zzrd()
  {
    return this.zzcyg;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzads
 * JD-Core Version:    0.6.2
 */