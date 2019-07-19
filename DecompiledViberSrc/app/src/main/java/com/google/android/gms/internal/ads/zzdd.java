package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class zzdd
  implements zzdc
{
  protected static volatile zzdy zzvd = null;
  protected MotionEvent zzvj;
  protected LinkedList<MotionEvent> zzvk = new LinkedList();
  protected long zzvl = 0L;
  protected long zzvm = 0L;
  protected long zzvn = 0L;
  protected long zzvo = 0L;
  protected long zzvp = 0L;
  protected long zzvq = 0L;
  protected long zzvr = 0L;
  protected double zzvs;
  private double zzvt;
  private double zzvu;
  protected float zzvv;
  protected float zzvw;
  protected float zzvx;
  protected float zzvy;
  private boolean zzvz = false;
  protected boolean zzwa = false;
  protected DisplayMetrics zzwb;

  protected zzdd(Context paramContext)
  {
    try
    {
      zzaci localzzaci = zzact.zzcrn;
      if (((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
        zzci.zzcb();
      while (true)
      {
        this.zzwb = paramContext.getResources().getDisplayMetrics();
        return;
        zzed.zzb(zzvd);
      }
    }
    catch (Throwable localThrowable)
    {
    }
  }

  // ERROR //
  private final String zza(Context paramContext, String paramString, boolean paramBoolean, View paramView, Activity paramActivity, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload 6
    //   2: ifnull +151 -> 153
    //   5: aload 6
    //   7: arraylength
    //   8: ifle +145 -> 153
    //   11: aload 6
    //   13: invokestatic 129	com/google/android/gms/internal/ads/zzdnn:zzaxe	()Lcom/google/android/gms/internal/ads/zzdnn;
    //   16: invokestatic 134	com/google/android/gms/internal/ads/zzbk$zza:zza	([BLcom/google/android/gms/internal/ads/zzdnn;)Lcom/google/android/gms/internal/ads/zzbk$zza;
    //   19: astore 27
    //   21: aload 27
    //   23: astore 7
    //   25: getstatic 39	com/google/android/gms/internal/ads/zzdd:zzvd	Lcom/google/android/gms/internal/ads/zzdy;
    //   28: ifnull +131 -> 159
    //   31: getstatic 137	com/google/android/gms/internal/ads/zzact:zzcrd	Lcom/google/android/gms/internal/ads/zzaci;
    //   34: astore 25
    //   36: invokestatic 80	com/google/android/gms/internal/ads/zzyr:zzpe	()Lcom/google/android/gms/internal/ads/zzacq;
    //   39: aload 25
    //   41: invokevirtual 86	com/google/android/gms/internal/ads/zzacq:zzd	(Lcom/google/android/gms/internal/ads/zzaci;)Ljava/lang/Object;
    //   44: checkcast 88	java/lang/Boolean
    //   47: invokevirtual 92	java/lang/Boolean:booleanValue	()Z
    //   50: ifeq +109 -> 159
    //   53: getstatic 39	com/google/android/gms/internal/ads/zzdd:zzvd	Lcom/google/android/gms/internal/ads/zzdy;
    //   56: invokevirtual 143	com/google/android/gms/internal/ads/zzdy:zzcm	()Lcom/google/android/gms/internal/ads/zzda;
    //   59: astore 8
    //   61: invokestatic 149	java/lang/System:currentTimeMillis	()J
    //   64: lstore 9
    //   66: iload_3
    //   67: ifeq +98 -> 165
    //   70: aload_0
    //   71: aload_1
    //   72: aload 4
    //   74: aload 5
    //   76: invokevirtual 152	com/google/android/gms/internal/ads/zzdd:zza	(Landroid/content/Context;Landroid/view/View;Landroid/app/Activity;)Lcom/google/android/gms/internal/ads/zzbp$zza$zza;
    //   79: astore 24
    //   81: aload 24
    //   83: astore 12
    //   85: aload_0
    //   86: iconst_1
    //   87: putfield 66	com/google/android/gms/internal/ads/zzdd:zzvz	Z
    //   90: goto +260 -> 350
    //   93: aload 8
    //   95: iload 23
    //   97: iconst_m1
    //   98: invokestatic 149	java/lang/System:currentTimeMillis	()J
    //   101: lload 9
    //   103: lsub
    //   104: invokevirtual 157	com/google/android/gms/internal/ads/zzda:zza	(IIJ)V
    //   107: aload 12
    //   109: astore 13
    //   111: invokestatic 149	java/lang/System:currentTimeMillis	()J
    //   114: lstore 14
    //   116: aload 13
    //   118: ifnull +20 -> 138
    //   121: aload 13
    //   123: invokevirtual 163	com/google/android/gms/internal/ads/zzdoa$zza:zzaya	()Lcom/google/android/gms/internal/ads/zzdpj;
    //   126: checkcast 165	com/google/android/gms/internal/ads/zzdoa
    //   129: checkcast 167	com/google/android/gms/internal/ads/zzbp$zza
    //   132: invokevirtual 171	com/google/android/gms/internal/ads/zzdoa:zzaxj	()I
    //   135: ifne +104 -> 239
    //   138: iconst_5
    //   139: invokestatic 177	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   142: astore 19
    //   144: aload 19
    //   146: astore 17
    //   148: aload 17
    //   150: areturn
    //   151: astore 26
    //   153: aconst_null
    //   154: astore 7
    //   156: goto -131 -> 25
    //   159: aconst_null
    //   160: astore 8
    //   162: goto -101 -> 61
    //   165: aload_0
    //   166: aload_1
    //   167: aload 7
    //   169: invokevirtual 180	com/google/android/gms/internal/ads/zzdd:zza	(Landroid/content/Context;Lcom/google/android/gms/internal/ads/zzbk$zza;)Lcom/google/android/gms/internal/ads/zzbp$zza$zza;
    //   172: astore 22
    //   174: aload 22
    //   176: astore 12
    //   178: goto +172 -> 350
    //   181: sipush 1000
    //   184: istore 23
    //   186: goto -93 -> 93
    //   189: astore 11
    //   191: aconst_null
    //   192: astore 12
    //   194: aload 8
    //   196: ifnull +28 -> 224
    //   199: iload_3
    //   200: ifeq +31 -> 231
    //   203: sipush 1003
    //   206: istore 21
    //   208: aload 8
    //   210: iload 21
    //   212: iconst_m1
    //   213: invokestatic 149	java/lang/System:currentTimeMillis	()J
    //   216: lload 9
    //   218: lsub
    //   219: aload 11
    //   221: invokevirtual 183	com/google/android/gms/internal/ads/zzda:zza	(IIJLjava/lang/Exception;)V
    //   224: aload 12
    //   226: astore 13
    //   228: goto -117 -> 111
    //   231: sipush 1001
    //   234: istore 21
    //   236: goto -28 -> 208
    //   239: aload 13
    //   241: invokevirtual 163	com/google/android/gms/internal/ads/zzdoa$zza:zzaya	()Lcom/google/android/gms/internal/ads/zzdpj;
    //   244: checkcast 165	com/google/android/gms/internal/ads/zzdoa
    //   247: checkcast 167	com/google/android/gms/internal/ads/zzbp$zza
    //   250: aload_2
    //   251: invokestatic 187	com/google/android/gms/internal/ads/zzci:zzj	(Lcom/google/android/gms/internal/ads/zzbp$zza;Ljava/lang/String;)Ljava/lang/String;
    //   254: astore 17
    //   256: aload 8
    //   258: ifnull -110 -> 148
    //   261: iload_3
    //   262: ifeq +67 -> 329
    //   265: sipush 1006
    //   268: istore 20
    //   270: aload 8
    //   272: iload 20
    //   274: iconst_m1
    //   275: invokestatic 149	java/lang/System:currentTimeMillis	()J
    //   278: lload 14
    //   280: lsub
    //   281: invokevirtual 157	com/google/android/gms/internal/ads/zzda:zza	(IIJ)V
    //   284: aload 17
    //   286: areturn
    //   287: astore 16
    //   289: bipush 7
    //   291: invokestatic 177	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   294: astore 17
    //   296: aload 8
    //   298: ifnull -150 -> 148
    //   301: iload_3
    //   302: ifeq +35 -> 337
    //   305: sipush 1007
    //   308: istore 18
    //   310: aload 8
    //   312: iload 18
    //   314: iconst_m1
    //   315: invokestatic 149	java/lang/System:currentTimeMillis	()J
    //   318: lload 14
    //   320: lsub
    //   321: aload 16
    //   323: invokevirtual 183	com/google/android/gms/internal/ads/zzda:zza	(IIJLjava/lang/Exception;)V
    //   326: aload 17
    //   328: areturn
    //   329: sipush 1004
    //   332: istore 20
    //   334: goto -64 -> 270
    //   337: sipush 1005
    //   340: istore 18
    //   342: goto -32 -> 310
    //   345: astore 11
    //   347: goto -153 -> 194
    //   350: aload 8
    //   352: ifnull -245 -> 107
    //   355: iload_3
    //   356: ifeq -175 -> 181
    //   359: sipush 1002
    //   362: istore 23
    //   364: goto -271 -> 93
    //
    // Exception table:
    //   from	to	target	type
    //   11	21	151	com/google/android/gms/internal/ads/zzdoj
    //   70	81	189	java/lang/Exception
    //   165	174	189	java/lang/Exception
    //   121	138	287	java/lang/Exception
    //   138	144	287	java/lang/Exception
    //   239	256	287	java/lang/Exception
    //   270	284	287	java/lang/Exception
    //   85	90	345	java/lang/Exception
    //   93	107	345	java/lang/Exception
  }

  protected abstract long zza(StackTraceElement[] paramArrayOfStackTraceElement)
    throws zzdv;

  protected abstract zzbp.zza.zza zza(Context paramContext, View paramView, Activity paramActivity);

  protected abstract zzbp.zza.zza zza(Context paramContext, zzbk.zza paramzza);

  public final String zza(Context paramContext)
  {
    if (zzef.isMainThread())
    {
      zzaci localzzaci = zzact.zzcrp;
      if (((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
        throw new IllegalStateException("The caller must not be called from the UI thread.");
    }
    return zza(paramContext, null, false, null, null, null);
  }

  public final String zza(Context paramContext, String paramString, View paramView)
  {
    return zza(paramContext, paramString, paramView, null);
  }

  public final String zza(Context paramContext, String paramString, View paramView, Activity paramActivity)
  {
    return zza(paramContext, paramString, true, paramView, paramActivity, null);
  }

  public final String zza(Context paramContext, byte[] paramArrayOfByte)
  {
    if (zzef.isMainThread())
    {
      zzaci localzzaci = zzact.zzcrp;
      if (((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
        throw new IllegalStateException("The caller must not be called from the UI thread.");
    }
    return zza(paramContext, null, false, null, null, paramArrayOfByte);
  }

  public final void zza(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.zzvj != null)
      this.zzvj.recycle();
    if (this.zzwb != null);
    for (this.zzvj = MotionEvent.obtain(0L, paramInt3, 1, paramInt1 * this.zzwb.density, paramInt2 * this.zzwb.density, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0); ; this.zzvj = null)
    {
      this.zzwa = false;
      return;
    }
  }

  public final void zza(MotionEvent paramMotionEvent)
  {
    if (this.zzvz)
    {
      this.zzvo = 0L;
      this.zzvn = 0L;
      this.zzvm = 0L;
      this.zzvl = 0L;
      this.zzvp = 0L;
      this.zzvr = 0L;
      this.zzvq = 0L;
      Iterator localIterator = this.zzvk.iterator();
      while (localIterator.hasNext())
        ((MotionEvent)localIterator.next()).recycle();
      this.zzvk.clear();
      this.zzvj = null;
      this.zzvz = false;
    }
    switch (paramMotionEvent.getAction())
    {
    default:
      switch (paramMotionEvent.getAction())
      {
      default:
      case 1:
      case 0:
      case 3:
      case 2:
      }
      break;
    case 0:
    case 1:
    case 2:
    }
    while (true)
    {
      this.zzwa = true;
      return;
      this.zzvs = 0.0D;
      this.zzvt = paramMotionEvent.getRawX();
      this.zzvu = paramMotionEvent.getRawY();
      break;
      double d1 = paramMotionEvent.getRawX();
      double d2 = paramMotionEvent.getRawY();
      double d3 = d1 - this.zzvt;
      double d4 = d2 - this.zzvu;
      this.zzvs += Math.sqrt(d3 * d3 + d4 * d4);
      this.zzvt = d1;
      this.zzvu = d2;
      break;
      this.zzvj = MotionEvent.obtain(paramMotionEvent);
      this.zzvk.add(this.zzvj);
      if (this.zzvk.size() > 6)
        ((MotionEvent)this.zzvk.remove()).recycle();
      this.zzvn = (1L + this.zzvn);
      try
      {
        this.zzvp = zza(new Throwable().getStackTrace());
      }
      catch (zzdv localzzdv2)
      {
      }
      continue;
      this.zzvv = paramMotionEvent.getX();
      this.zzvw = paramMotionEvent.getY();
      this.zzvx = paramMotionEvent.getRawX();
      this.zzvy = paramMotionEvent.getRawY();
      this.zzvl = (1L + this.zzvl);
      continue;
      this.zzvo = (1L + this.zzvo);
    }
    this.zzvm += 1 + paramMotionEvent.getHistorySize();
    while (true)
    {
      try
      {
        zzee localzzee = zzb(paramMotionEvent);
        if ((localzzee == null) || (localzzee.zzye == null) || (localzzee.zzyh == null))
          break label546;
        i = 1;
        if (i != 0)
          this.zzvq += localzzee.zzye.longValue() + localzzee.zzyh.longValue();
        if ((this.zzwb == null) || (localzzee == null) || (localzzee.zzyf == null) || (localzzee.zzyi == null))
          break label552;
        j = 1;
        if (j == 0)
          break;
        this.zzvr += localzzee.zzyf.longValue() + localzzee.zzyi.longValue();
      }
      catch (zzdv localzzdv1)
      {
      }
      break;
      label546: int i = 0;
      continue;
      label552: int j = 0;
    }
  }

  protected abstract zzee zzb(MotionEvent paramMotionEvent)
    throws zzdv;

  public void zzb(View paramView)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdd
 * JD-Core Version:    0.6.2
 */