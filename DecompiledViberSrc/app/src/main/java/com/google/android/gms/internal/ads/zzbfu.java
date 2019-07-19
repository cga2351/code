package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
public abstract class zzbfu
  implements Releasable
{
  protected Context mContext;
  protected String zzdyd;
  protected WeakReference<zzbdg> zzehv;

  public zzbfu(zzbdg paramzzbdg)
  {
    this.mContext = paramzzbdg.getContext();
    this.zzdyd = zzk.zzlg().zzq(this.mContext, paramzzbdg.zzyh().zzbsy);
    this.zzehv = new WeakReference(paramzzbdg);
  }

  private final void zza(String paramString, Map<String, String> paramMap)
  {
    zzbdg localzzbdg = (zzbdg)this.zzehv.get();
    if (localzzbdg != null)
      localzzbdg.zza(paramString, paramMap);
  }

  private static String zzez(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case -659376217:
    case 96784904:
    case -1347010958:
    case -1947652542:
    case 3387234:
    case -642208130:
    case 580119100:
    case 725497484:
    case -1396664534:
    case -918817863:
    case -32082395:
    case -354048396:
    }
    while (true)
      switch (i)
      {
      default:
        return "internal";
        if (paramString.equals("contentLengthMissing"))
        {
          i = 0;
          continue;
          if (paramString.equals("error"))
          {
            i = 1;
            continue;
            if (paramString.equals("inProgress"))
            {
              i = 2;
              continue;
              if (paramString.equals("interrupted"))
              {
                i = 3;
                continue;
                if (paramString.equals("noop"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("playerFailed"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("expireFailed"))
                    {
                      i = 6;
                      continue;
                      if (paramString.equals("noCacheDir"))
                      {
                        i = 7;
                        continue;
                        if (paramString.equals("badUrl"))
                        {
                          i = 8;
                          continue;
                          if (paramString.equals("downloadTimeout"))
                          {
                            i = 9;
                            continue;
                            if (paramString.equals("externalAbort"))
                            {
                              i = 10;
                              continue;
                              if (paramString.equals("sizeExceeded"))
                                i = 11;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
      case 11:
      }
    return "internal";
    return "io";
    return "network";
    return "policy";
  }

  public abstract void abort();

  public void release()
  {
  }

  protected final void zza(String paramString1, String paramString2, int paramInt)
  {
    zzazu.zzyr.post(new zzbga(this, paramString1, paramString2, paramInt));
  }

  @VisibleForTesting
  public final void zza(String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    zzazu.zzyr.post(new zzbfz(this, paramString1, paramString2, paramInt1, paramInt2, paramLong1, paramLong2, paramBoolean, paramInt3, paramInt4));
  }

  @VisibleForTesting
  public final void zza(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    zzazu.zzyr.post(new zzbfw(this, paramString1, paramString2, paramInt1, 0, paramBoolean, paramInt3, paramInt4));
  }

  @VisibleForTesting
  public final void zza(String paramString1, String paramString2, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    zzazu.zzyr.post(new zzbfx(this, paramString1, paramString2, paramLong1, paramLong2, paramBoolean));
  }

  @VisibleForTesting
  public final void zza(String paramString1, String paramString2, long paramLong1, long paramLong2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    zzazu.zzyr.post(new zzbfy(this, paramString1, paramString2, paramLong1, paramLong2, paramBoolean, paramInt1, paramInt2));
  }

  @VisibleForTesting
  public final void zza(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    zzazu.zzyr.post(new zzbgc(this, paramString1, paramString2, paramString3, paramString4));
  }

  @VisibleForTesting
  public final void zzb(String paramString1, String paramString2, long paramLong)
  {
    zzazu.zzyr.post(new zzbgb(this, paramString1, paramString2, paramLong));
  }

  protected void zzcy(int paramInt)
  {
  }

  protected void zzcz(int paramInt)
  {
  }

  protected void zzda(int paramInt)
  {
  }

  protected void zzdb(int paramInt)
  {
  }

  public boolean zze(String paramString, String[] paramArrayOfString)
  {
    return zzex(paramString);
  }

  public abstract boolean zzex(String paramString);

  protected String zzey(String paramString)
  {
    zzyr.zzpa();
    return zzazu.zzei(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbfu
 * JD-Core Version:    0.6.2
 */