package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.TextureView;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Clock;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

@zzare
public final class zzbdh
{
  private final zzbaj zzdlf;
  private final String zzdlz;
  private final zzadh zzebx;
  private boolean zzecb;
  private final zzadf zzeeo;
  private final zzayr zzeep = new zzayu().zza("min_1", 4.9E-324D, 1.0D).zza("1_5", 1.0D, 5.0D).zza("5_10", 5.0D, 10.0D).zza("10_20", 10.0D, 20.0D).zza("20_30", 20.0D, 30.0D).zza("30_max", 30.0D, 1.7976931348623157E+308D).zzwq();
  private final long[] zzeeq;
  private final String[] zzeer;
  private boolean zzees = false;
  private boolean zzeet = false;
  private boolean zzeeu = false;
  private boolean zzeev = false;
  private zzbcp zzeew;
  private boolean zzeex;
  private boolean zzeey;
  private long zzeez = -1L;
  private final Context zzlj;

  public zzbdh(Context paramContext, zzbaj paramzzbaj, String paramString, zzadh paramzzadh, zzadf paramzzadf)
  {
    this.zzlj = paramContext;
    this.zzdlf = paramzzbaj;
    this.zzdlz = paramString;
    this.zzebx = paramzzadh;
    this.zzeeo = paramzzadf;
    zzaci localzzaci = zzact.zzcmc;
    String str = (String)zzyr.zzpe().zzd(localzzaci);
    if (str == null)
    {
      this.zzeer = new String[0];
      this.zzeeq = new long[0];
      return;
    }
    String[] arrayOfString = TextUtils.split(str, ",");
    this.zzeer = new String[arrayOfString.length];
    this.zzeeq = new long[arrayOfString.length];
    int i = 0;
    while (i < arrayOfString.length)
      try
      {
        this.zzeeq[i] = Long.parseLong(arrayOfString[i]);
        i++;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        while (true)
        {
          zzaxa.zzd("Unable to parse frame hash target time number.", localNumberFormatException);
          this.zzeeq[i] = -1L;
        }
      }
  }

  public final void onStop()
  {
    zzaci localzzaci = zzact.zzcmb;
    if ((((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue()) && (!this.zzeex))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("type", "native-player-metrics");
      localBundle.putString("request", this.zzdlz);
      localBundle.putString("player", this.zzeew.zzxg());
      Iterator localIterator = this.zzeep.zzwp().iterator();
      if (localIterator.hasNext())
      {
        zzayt localzzayt = (zzayt)localIterator.next();
        String str3 = String.valueOf("fps_c_");
        String str4 = String.valueOf(localzzayt.name);
        String str5;
        label133: String str6;
        String str7;
        if (str4.length() != 0)
        {
          str5 = str3.concat(str4);
          localBundle.putString(str5, Integer.toString(localzzayt.count));
          str6 = String.valueOf("fps_p_");
          str7 = String.valueOf(localzzayt.name);
          if (str7.length() == 0)
            break label212;
        }
        label212: for (String str8 = str6.concat(str7); ; str8 = new String(str6))
        {
          localBundle.putString(str8, Double.toString(localzzayt.zzdxf));
          break;
          str5 = new String(str3);
          break label133;
        }
      }
      for (int i = 0; i < this.zzeeq.length; i++)
      {
        String str1 = this.zzeer[i];
        if (str1 != null)
        {
          String str2 = String.valueOf(Long.valueOf(this.zzeeq[i]));
          localBundle.putString(3 + String.valueOf(str2).length() + "fh_" + str2, str1);
        }
      }
      zzk.zzlg().zza(this.zzlj, this.zzdlf.zzbsy, "gmob-apps", localBundle, true);
      this.zzeex = true;
    }
  }

  public final void zzb(zzbcp paramzzbcp)
  {
    zzada.zza(this.zzebx, this.zzeeo, new String[] { "vpc2" });
    this.zzees = true;
    if (this.zzebx != null)
      this.zzebx.zzh("vpn", paramzzbcp.zzxg());
    this.zzeew = paramzzbcp;
  }

  public final void zzc(zzbcp paramzzbcp)
  {
    if ((this.zzeeu) && (!this.zzeev))
    {
      if ((zzaxa.zzvj()) && (!this.zzeev))
        zzaxa.zzds("VideoMetricsMixin first frame");
      zzada.zza(this.zzebx, this.zzeeo, new String[] { "vff2" });
      this.zzeev = true;
    }
    long l1 = zzk.zzln().nanoTime();
    if ((this.zzecb) && (this.zzeey) && (this.zzeez != -1L))
    {
      double d = TimeUnit.SECONDS.toNanos(1L) / (l1 - this.zzeez);
      this.zzeep.zza(d);
    }
    this.zzeey = this.zzecb;
    this.zzeez = l1;
    zzaci localzzaci = zzact.zzcmd;
    long l2 = ((Long)zzyr.zzpe().zzd(localzzaci)).longValue();
    long l3 = paramzzbcp.getCurrentPosition();
    for (int i = 0; ; i++)
      if (i < this.zzeer.length)
      {
        if ((this.zzeer[i] == null) && (l2 > Math.abs(l3 - this.zzeeq[i])))
        {
          String[] arrayOfString = this.zzeer;
          Bitmap localBitmap = paramzzbcp.getBitmap(8, 8);
          long l4 = 0L;
          long l5 = 63L;
          int j = 0;
          while (j < 8)
          {
            int k = 0;
            long l6 = l4;
            long l7 = l5;
            if (k < 8)
            {
              int m = localBitmap.getPixel(k, j);
              if (Color.blue(m) + Color.red(m) + Color.green(m) > 128);
              for (long l8 = 1L; ; l8 = 0L)
              {
                l6 |= l8 << (int)l7;
                k++;
                l7 -= 1L;
                break;
              }
            }
            j++;
            l5 = l7;
            l4 = l6;
          }
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Long.valueOf(l4);
          arrayOfString[i] = String.format("%016X", arrayOfObject);
        }
      }
      else
        return;
  }

  public final void zzhd()
  {
    if ((!this.zzees) || (this.zzeet))
      return;
    zzada.zza(this.zzebx, this.zzeeo, new String[] { "vfr2" });
    this.zzeet = true;
  }

  public final void zzyl()
  {
    this.zzecb = true;
    if ((this.zzeet) && (!this.zzeeu))
    {
      zzada.zza(this.zzebx, this.zzeeo, new String[] { "vfp2" });
      this.zzeeu = true;
    }
  }

  public final void zzym()
  {
    this.zzecb = false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbdh
 * JD-Core Version:    0.6.2
 */