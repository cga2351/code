package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.graphics.PointF;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager.BadTokenException;
import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.List;

@zzare
public final class zzayc
{
  private Handler handler;
  private int state = 0;
  private String zzbsy;
  private String zzchl;
  private String zzdku;
  private String zzdof;
  private int zzdwg;
  private PointF zzdwh;
  private PointF zzdwi;
  private Runnable zzdwj = new zzayd(this);
  private final Context zzlj;

  public zzayc(Context paramContext)
  {
    this.zzlj = paramContext;
    this.zzdwg = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    zzk.zzlu().zzwr();
    this.handler = zzk.zzlu().getHandler();
  }

  public zzayc(Context paramContext, String paramString)
  {
    this(paramContext);
    this.zzdku = paramString;
  }

  private static int zza(List<String> paramList, String paramString, boolean paramBoolean)
  {
    paramList.add(paramString);
    return -1 + paramList.size();
  }

  private final boolean zza(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (Math.abs(this.zzdwh.x - paramFloat1) < this.zzdwg) && (Math.abs(this.zzdwh.y - paramFloat2) < this.zzdwg) && (Math.abs(this.zzdwi.x - paramFloat3) < this.zzdwg) && (Math.abs(this.zzdwi.y - paramFloat4) < this.zzdwg);
  }

  public final void setAdUnitId(String paramString)
  {
    this.zzchl = paramString;
  }

  public final void showDialog()
  {
    while (true)
    {
      try
      {
        if (!(this.zzlj instanceof Activity))
        {
          zzaxa.zzeo("Can not create dialog without Activity Context");
          return;
        }
        if (!TextUtils.isEmpty(zzk.zzlq().zzwn()))
        {
          str1 = "Creative Preview (Enabled)";
          if (!zzk.zzlq().zzwo())
            break label161;
          str2 = "Troubleshooting (Enabled)";
          ArrayList localArrayList = new ArrayList();
          int i = zza(localArrayList, "Ad Information", true);
          int j = zza(localArrayList, str1, true);
          int k = zza(localArrayList, str2, true);
          AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.zzlj, zzk.zzli().zzwi());
          localBuilder.setTitle("Select a Debug Mode").setItems((CharSequence[])localArrayList.toArray(new String[0]), new zzaye(this, i, j, k));
          localBuilder.create().show();
          return;
        }
      }
      catch (WindowManager.BadTokenException localBadTokenException)
      {
        zzaxa.zza("", localBadTokenException);
        return;
      }
      String str1 = "Creative Preview";
      continue;
      label161: String str2 = "Troubleshooting";
    }
  }

  public final String toString()
  {
    return 100 + "{Dialog: " + this.zzdku + ",DebugSignal: " + this.zzdof + ",AFMA Version: " + this.zzbsy + ",Ad Unit ID: " + this.zzchl + "}";
  }

  public final void zzd(MotionEvent paramMotionEvent)
  {
    int i = 1;
    int j = paramMotionEvent.getActionMasked();
    int k = paramMotionEvent.getHistorySize();
    int m = paramMotionEvent.getPointerCount();
    if (j == 0)
    {
      this.state = 0;
      this.zzdwh = new PointF(paramMotionEvent.getX(0), paramMotionEvent.getY(0));
    }
    while (true)
    {
      return;
      if (this.state != -1)
      {
        if ((this.state == 0) && (j == 5))
        {
          this.state = 5;
          this.zzdwi = new PointF(paramMotionEvent.getX(i), paramMotionEvent.getY(i));
          Handler localHandler = this.handler;
          Runnable localRunnable = this.zzdwj;
          zzaci localzzaci = zzact.zzcub;
          localHandler.postDelayed(localRunnable, ((Long)zzyr.zzpe().zzd(localzzaci)).longValue());
          return;
        }
        if (this.state != 5)
          break;
        if (m != 2);
        while (i != 0)
        {
          this.state = -1;
          this.handler.removeCallbacks(this.zzdwj);
          return;
          if (j == 2)
          {
            int n = 0;
            int i1 = 0;
            while (n < k)
            {
              if (!zza(paramMotionEvent.getHistoricalX(0, n), paramMotionEvent.getHistoricalY(0, n), paramMotionEvent.getHistoricalX(i, n), paramMotionEvent.getHistoricalY(i, n)))
                i1 = i;
              n++;
            }
            if (zza(paramMotionEvent.getX(), paramMotionEvent.getY(), paramMotionEvent.getX(i), paramMotionEvent.getY(i)))
              i = i1;
          }
          else
          {
            i = 0;
          }
        }
      }
    }
  }

  public final void zzee(String paramString)
  {
    this.zzdku = paramString;
  }

  public final void zzef(String paramString)
  {
    this.zzdof = paramString;
  }

  public final void zzp(String paramString)
  {
    this.zzbsy = paramString;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzayc
 * JD-Core Version:    0.6.2
 */