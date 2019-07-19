package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
public final class zzbcr extends FrameLayout
  implements zzbco
{
  private final zzbdg zzebv;
  private final FrameLayout zzebw;
  private final zzadh zzebx;
  private final zzbdi zzeby;
  private final long zzebz;
  private zzbcp zzeca;
  private boolean zzecb;
  private boolean zzecc;
  private boolean zzecd;
  private boolean zzece;
  private long zzecf;
  private long zzecg;
  private String zzech;
  private String[] zzeci;
  private Bitmap zzecj;
  private ImageView zzeck;
  private boolean zzecl;

  public zzbcr(Context paramContext, zzbdg paramzzbdg, int paramInt, boolean paramBoolean, zzadh paramzzadh, zzbdf paramzzbdf)
  {
    super(paramContext);
    this.zzebv = paramzzbdg;
    this.zzebx = paramzzadh;
    this.zzebw = new FrameLayout(paramContext);
    addView(this.zzebw, new FrameLayout.LayoutParams(-1, -1));
    Preconditions.checkNotNull(paramzzbdg.zzye());
    this.zzeca = paramzzbdg.zzye().zzbqt.zza(paramContext, paramzzbdg, paramInt, paramBoolean, paramzzadh, paramzzbdf);
    if (this.zzeca != null)
    {
      this.zzebw.addView(this.zzeca, new FrameLayout.LayoutParams(-1, -1, 17));
      zzaci localzzaci3 = zzact.zzcme;
      if (((Boolean)zzyr.zzpe().zzd(localzzaci3)).booleanValue())
        zzxs();
    }
    this.zzeck = new ImageView(paramContext);
    zzaci localzzaci1 = zzact.zzcmi;
    this.zzebz = ((Long)zzyr.zzpe().zzd(localzzaci1)).longValue();
    zzaci localzzaci2 = zzact.zzcmg;
    this.zzece = ((Boolean)zzyr.zzpe().zzd(localzzaci2)).booleanValue();
    zzadh localzzadh;
    if (this.zzebx != null)
    {
      localzzadh = this.zzebx;
      if (!this.zzece)
        break label269;
    }
    label269: for (String str = "1"; ; str = "0")
    {
      localzzadh.zzh("spinner_used", str);
      this.zzeby = new zzbdi(this);
      if (this.zzeca != null)
        this.zzeca.zza(this);
      if (this.zzeca == null)
        zzl("AdVideoUnderlay Error", "Allocating player failed.");
      return;
    }
  }

  public static void zza(zzbdg paramzzbdg, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", "decoderProps");
    localHashMap.put("error", paramString);
    paramzzbdg.zza("onVideoEvent", localHashMap);
  }

  public static void zza(zzbdg paramzzbdg, Map<String, List<Map<String, Object>>> paramMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", "decoderProps");
    localHashMap.put("mimeTypes", paramMap);
    paramzzbdg.zza("onVideoEvent", localHashMap);
  }

  public static void zzb(zzbdg paramzzbdg)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", "no_video_view");
    paramzzbdg.zza("onVideoEvent", localHashMap);
  }

  private final void zzd(String paramString, String[] paramArrayOfString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", paramString);
    int i = paramArrayOfString.length;
    int j = 0;
    Object localObject = null;
    if (j < i)
    {
      String str = paramArrayOfString[j];
      if (localObject == null);
      while (true)
      {
        j++;
        localObject = str;
        break;
        localHashMap.put(localObject, str);
        str = null;
      }
    }
    this.zzebv.zza("onVideoEvent", localHashMap);
  }

  private final boolean zzxu()
  {
    return this.zzeck.getParent() != null;
  }

  private final void zzxv()
  {
    if (this.zzebv.zzyd() == null);
    while ((!this.zzecc) || (this.zzecd))
      return;
    this.zzebv.zzyd().getWindow().clearFlags(128);
    this.zzecc = false;
  }

  public final void destroy()
  {
    this.zzeby.pause();
    if (this.zzeca != null)
      this.zzeca.stop();
    zzxv();
  }

  public final void finalize()
    throws Throwable
  {
    try
    {
      this.zzeby.pause();
      if (this.zzeca != null)
      {
        zzbcp localzzbcp = this.zzeca;
        Executor localExecutor = zzbbn.zzeag;
        localzzbcp.getClass();
        localExecutor.execute(zzbcs.zza(localzzbcp));
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }

  public final void onPaused()
  {
    zzd("pause", new String[0]);
    zzxv();
    this.zzecb = false;
  }

  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
      this.zzeby.resume();
    while (true)
    {
      zzaxj.zzdvx.post(new zzbct(this, paramBoolean));
      return;
      this.zzeby.pause();
      this.zzecg = this.zzecf;
    }
  }

  public final void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    if (paramInt == 0)
      this.zzeby.resume();
    for (boolean bool = true; ; bool = false)
    {
      zzaxj.zzdvx.post(new zzbcw(this, bool));
      return;
      this.zzeby.pause();
      this.zzecg = this.zzecf;
    }
  }

  public final void pause()
  {
    if (this.zzeca == null)
      return;
    this.zzeca.pause();
  }

  public final void play()
  {
    if (this.zzeca == null)
      return;
    this.zzeca.play();
  }

  public final void seekTo(int paramInt)
  {
    if (this.zzeca == null)
      return;
    this.zzeca.seekTo(paramInt);
  }

  public final void setVolume(float paramFloat)
  {
    if (this.zzeca == null)
      return;
    zzbcp localzzbcp = this.zzeca;
    localzzbcp.zzebu.setVolume(paramFloat);
    localzzbcp.zzxk();
  }

  public final void zza(float paramFloat1, float paramFloat2)
  {
    if (this.zzeca != null)
      this.zzeca.zza(paramFloat1, paramFloat2);
  }

  public final void zzc(String paramString, String[] paramArrayOfString)
  {
    this.zzech = paramString;
    this.zzeci = paramArrayOfString;
  }

  public final void zzcy(int paramInt)
  {
    this.zzeca.zzcy(paramInt);
  }

  public final void zzcz(int paramInt)
  {
    this.zzeca.zzcz(paramInt);
  }

  public final void zzd(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt3 == 0) || (paramInt4 == 0))
      return;
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramInt3, paramInt4);
    localLayoutParams.setMargins(paramInt1, paramInt2, 0, 0);
    this.zzebw.setLayoutParams(localLayoutParams);
    requestLayout();
  }

  public final void zzda(int paramInt)
  {
    this.zzeca.zzda(paramInt);
  }

  public final void zzdb(int paramInt)
  {
    this.zzeca.zzdb(paramInt);
  }

  public final void zzdc(int paramInt)
  {
    this.zzeca.zzdc(paramInt);
  }

  @TargetApi(14)
  public final void zze(MotionEvent paramMotionEvent)
  {
    if (this.zzeca == null)
      return;
    this.zzeca.dispatchTouchEvent(paramMotionEvent);
  }

  public final void zzfr()
  {
    if (this.zzeca == null)
      return;
    if (!TextUtils.isEmpty(this.zzech))
    {
      this.zzeca.zzb(this.zzech, this.zzeci);
      return;
    }
    zzd("no_src", new String[0]);
  }

  public final void zzhd()
  {
    if (this.zzeca == null);
    while (this.zzecg != 0L)
      return;
    float f = this.zzeca.getDuration() / 1000.0F;
    int i = this.zzeca.getVideoWidth();
    int j = this.zzeca.getVideoHeight();
    String[] arrayOfString = new String[6];
    arrayOfString[0] = "duration";
    arrayOfString[1] = String.valueOf(f);
    arrayOfString[2] = "videoWidth";
    arrayOfString[3] = String.valueOf(i);
    arrayOfString[4] = "videoHeight";
    arrayOfString[5] = String.valueOf(j);
    zzd("canplaythrough", arrayOfString);
  }

  public final void zzk(int paramInt1, int paramInt2)
  {
    if (this.zzece)
    {
      zzaci localzzaci1 = zzact.zzcmh;
      int i = Math.max(paramInt1 / ((Integer)zzyr.zzpe().zzd(localzzaci1)).intValue(), 1);
      zzaci localzzaci2 = zzact.zzcmh;
      int j = Math.max(paramInt2 / ((Integer)zzyr.zzpe().zzd(localzzaci2)).intValue(), 1);
      if ((this.zzecj == null) || (this.zzecj.getWidth() != i) || (this.zzecj.getHeight() != j))
      {
        this.zzecj = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        this.zzecl = false;
      }
    }
  }

  public final void zzl(String paramString1, String paramString2)
  {
    zzd("error", new String[] { "what", paramString1, "extra", paramString2 });
  }

  public final void zzxl()
  {
    this.zzeby.resume();
    zzaxj.zzdvx.post(new zzbcu(this));
  }

  public final void zzxm()
  {
    if ((this.zzebv.zzyd() != null) && (!this.zzecc))
      if ((0x80 & this.zzebv.zzyd().getWindow().getAttributes().flags) == 0)
        break label87;
    label87: for (boolean bool = true; ; bool = false)
    {
      this.zzecd = bool;
      if (!this.zzecd)
      {
        this.zzebv.zzyd().getWindow().addFlags(128);
        this.zzecc = true;
      }
      this.zzecb = true;
      return;
    }
  }

  public final void zzxn()
  {
    zzd("ended", new String[0]);
    zzxv();
  }

  public final void zzxo()
  {
    if ((this.zzecl) && (this.zzecj != null) && (!zzxu()))
    {
      this.zzeck.setImageBitmap(this.zzecj);
      this.zzeck.invalidate();
      this.zzebw.addView(this.zzeck, new FrameLayout.LayoutParams(-1, -1));
      this.zzebw.bringChildToFront(this.zzeck);
    }
    this.zzeby.pause();
    this.zzecg = this.zzecf;
    zzaxj.zzdvx.post(new zzbcv(this));
  }

  public final void zzxp()
  {
    if ((this.zzecb) && (zzxu()))
      this.zzebw.removeView(this.zzeck);
    if (this.zzecj != null)
    {
      long l1 = zzk.zzln().elapsedRealtime();
      if (this.zzeca.getBitmap(this.zzecj) != null)
        this.zzecl = true;
      long l2 = zzk.zzln().elapsedRealtime() - l1;
      if (zzaxa.zzvj())
        zzaxa.zzds(46 + "Spinner frame grab took " + l2 + "ms");
      if (l2 > this.zzebz)
      {
        zzaxa.zzep("Spinner frame grab crossed jank threshold! Suspending spinner.");
        this.zzece = false;
        this.zzecj = null;
        if (this.zzebx != null)
          this.zzebx.zzh("spinner_jank", Long.toString(l2));
      }
    }
  }

  public final void zzxq()
  {
    if (this.zzeca == null)
      return;
    zzbcp localzzbcp = this.zzeca;
    localzzbcp.zzebu.setMuted(true);
    localzzbcp.zzxk();
  }

  public final void zzxr()
  {
    if (this.zzeca == null)
      return;
    zzbcp localzzbcp = this.zzeca;
    localzzbcp.zzebu.setMuted(false);
    localzzbcp.zzxk();
  }

  @TargetApi(14)
  public final void zzxs()
  {
    if (this.zzeca == null)
      return;
    TextView localTextView = new TextView(this.zzeca.getContext());
    String str1 = String.valueOf(this.zzeca.zzxg());
    if (str1.length() != 0);
    for (String str2 = "AdMob - ".concat(str1); ; str2 = new String("AdMob - "))
    {
      localTextView.setText(str2);
      localTextView.setTextColor(-65536);
      localTextView.setBackgroundColor(-256);
      this.zzebw.addView(localTextView, new FrameLayout.LayoutParams(-2, -2, 17));
      this.zzebw.bringChildToFront(localTextView);
      return;
    }
  }

  final void zzxt()
  {
    if (this.zzeca == null);
    long l;
    do
    {
      return;
      l = this.zzeca.getCurrentPosition();
    }
    while ((this.zzecf == l) || (l <= 0L));
    float f = (float)l / 1000.0F;
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "time";
    arrayOfString[1] = String.valueOf(f);
    zzd("timeupdate", arrayOfString);
    this.zzecf = l;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbcr
 * JD-Core Version:    0.6.2
 */