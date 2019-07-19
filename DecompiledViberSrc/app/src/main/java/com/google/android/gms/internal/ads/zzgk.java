package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

final class zzgk
  implements Handler.Callback
{
  private final Handler handler;
  private int state;
  private final Handler zzabq;
  private final boolean[] zzabt;
  private boolean zzabu;
  private final HandlerThread zzaby;
  private final zzgm zzabz;
  private final long zzaca;
  private final long zzacb;
  private final List<zzhp> zzacc;
  private zzhp[] zzacd;
  private zzhp zzace;
  private boolean zzacf;
  private boolean zzacg;
  private int zzach = 0;
  private int zzaci = 0;
  private long zzacj;
  private volatile long zzack;
  private volatile long zzacl;
  private volatile long zzacm;

  public zzgk(Handler paramHandler, boolean paramBoolean, boolean[] paramArrayOfBoolean, int paramInt1, int paramInt2)
  {
    this.zzabq = paramHandler;
    this.zzabu = paramBoolean;
    this.zzabt = new boolean[paramArrayOfBoolean.length];
    this.zzaca = 2500000L;
    this.zzacb = 5000000L;
    while (i < paramArrayOfBoolean.length)
    {
      this.zzabt[i] = paramArrayOfBoolean[i];
      i++;
    }
    this.state = 1;
    this.zzack = -1L;
    this.zzacm = -1L;
    this.zzabz = new zzgm();
    this.zzacc = new ArrayList(paramArrayOfBoolean.length);
    this.zzaby = new zzko(String.valueOf(getClass().getSimpleName()).concat(":Handler"), -16);
    this.zzaby.start();
    this.handler = new Handler(this.zzaby.getLooper(), this);
  }

  private final void setState(int paramInt)
  {
    if (this.state != paramInt)
    {
      this.state = paramInt;
      this.zzabq.obtainMessage(1, paramInt, 0).sendToTarget();
    }
  }

  private final void zza(int paramInt, long paramLong1, long paramLong2)
  {
    long l = paramLong1 + paramLong2 - SystemClock.elapsedRealtime();
    if (l <= 0L)
    {
      this.handler.sendEmptyMessage(paramInt);
      return;
    }
    this.handler.sendEmptyMessageDelayed(paramInt, l);
  }

  private final boolean zza(zzhp paramzzhp)
  {
    if (paramzzhp.zzdx());
    while (true)
    {
      return true;
      if (!paramzzhp.isReady())
        return false;
      if (this.state != 4)
      {
        long l1 = paramzzhp.getDurationUs();
        long l2 = paramzzhp.zzdu();
        if (this.zzacg);
        for (long l3 = this.zzacb; (l3 > 0L) && (l2 != -1L) && (l2 != -3L) && (l2 < l3 + this.zzacl) && ((l1 == -1L) || (l1 == -2L) || (l2 < l1)); l3 = this.zzaca)
          return false;
      }
    }
  }

  private static void zzb(zzhp paramzzhp)
    throws zzgd
  {
    if (paramzzhp.getState() == 3)
      paramzzhp.stop();
  }

  private final void zzdp()
    throws zzgd
  {
    this.zzacg = false;
    this.zzabz.start();
    for (int i = 0; i < this.zzacc.size(); i++)
      ((zzhp)this.zzacc.get(i)).start();
  }

  private final void zzdq()
    throws zzgd
  {
    this.zzabz.stop();
    for (int i = 0; i < this.zzacc.size(); i++)
      zzb((zzhp)this.zzacc.get(i));
  }

  private final void zzdr()
  {
    if ((this.zzace != null) && (this.zzacc.contains(this.zzace)) && (!this.zzace.zzdx()))
    {
      this.zzacl = this.zzace.zzdy();
      this.zzabz.zzdj(this.zzacl);
    }
    while (true)
    {
      this.zzacj = (1000L * SystemClock.elapsedRealtime());
      return;
      this.zzacl = this.zzabz.zzdv();
    }
  }

  private final void zzds()
  {
    zzdt();
    setState(1);
  }

  // ERROR //
  private final void zzdt()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 125	com/google/android/gms/internal/ads/zzgk:handler	Landroid/os/Handler;
    //   4: bipush 7
    //   6: invokevirtual 234	android/os/Handler:removeMessages	(I)V
    //   9: aload_0
    //   10: getfield 125	com/google/android/gms/internal/ads/zzgk:handler	Landroid/os/Handler;
    //   13: iconst_2
    //   14: invokevirtual 234	android/os/Handler:removeMessages	(I)V
    //   17: aload_0
    //   18: iconst_0
    //   19: putfield 169	com/google/android/gms/internal/ads/zzgk:zzacg	Z
    //   22: aload_0
    //   23: getfield 73	com/google/android/gms/internal/ads/zzgk:zzabz	Lcom/google/android/gms/internal/ads/zzgm;
    //   26: invokevirtual 200	com/google/android/gms/internal/ads/zzgm:stop	()V
    //   29: aload_0
    //   30: getfield 236	com/google/android/gms/internal/ads/zzgk:zzacd	[Lcom/google/android/gms/internal/ads/zzhp;
    //   33: astore_1
    //   34: iconst_0
    //   35: istore_2
    //   36: aload_1
    //   37: ifnonnull +4 -> 41
    //   40: return
    //   41: iload_2
    //   42: aload_0
    //   43: getfield 236	com/google/android/gms/internal/ads/zzgk:zzacd	[Lcom/google/android/gms/internal/ads/zzhp;
    //   46: arraylength
    //   47: if_icmpge +96 -> 143
    //   50: aload_0
    //   51: getfield 236	com/google/android/gms/internal/ads/zzgk:zzacd	[Lcom/google/android/gms/internal/ads/zzhp;
    //   54: iload_2
    //   55: aaload
    //   56: astore_3
    //   57: aload_3
    //   58: invokestatic 202	com/google/android/gms/internal/ads/zzgk:zzb	(Lcom/google/android/gms/internal/ads/zzhp;)V
    //   61: aload_3
    //   62: invokevirtual 183	com/google/android/gms/internal/ads/zzhp:getState	()I
    //   65: iconst_2
    //   66: if_icmpne +7 -> 73
    //   69: aload_3
    //   70: invokevirtual 239	com/google/android/gms/internal/ads/zzhp:disable	()V
    //   73: aload_3
    //   74: invokevirtual 242	com/google/android/gms/internal/ads/zzhp:release	()V
    //   77: iinc 2 1
    //   80: goto -39 -> 41
    //   83: astore 10
    //   85: ldc 244
    //   87: ldc 246
    //   89: aload 10
    //   91: invokestatic 252	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   94: pop
    //   95: goto -22 -> 73
    //   98: astore 4
    //   100: ldc 244
    //   102: ldc 246
    //   104: aload 4
    //   106: invokestatic 252	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   109: pop
    //   110: goto -37 -> 73
    //   113: astore 8
    //   115: ldc 244
    //   117: ldc 254
    //   119: aload 8
    //   121: invokestatic 252	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   124: pop
    //   125: goto -48 -> 77
    //   128: astore 6
    //   130: ldc 244
    //   132: ldc 254
    //   134: aload 6
    //   136: invokestatic 252	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   139: pop
    //   140: goto -63 -> 77
    //   143: aload_0
    //   144: aconst_null
    //   145: putfield 236	com/google/android/gms/internal/ads/zzgk:zzacd	[Lcom/google/android/gms/internal/ads/zzhp;
    //   148: aload_0
    //   149: aconst_null
    //   150: putfield 205	com/google/android/gms/internal/ads/zzgk:zzace	Lcom/google/android/gms/internal/ads/zzhp;
    //   153: aload_0
    //   154: getfield 80	com/google/android/gms/internal/ads/zzgk:zzacc	Ljava/util/List;
    //   157: invokeinterface 257 1 0
    //   162: return
    //
    // Exception table:
    //   from	to	target	type
    //   57	73	83	com/google/android/gms/internal/ads/zzgd
    //   57	73	98	java/lang/RuntimeException
    //   73	77	113	com/google/android/gms/internal/ads/zzgd
    //   73	77	128	java/lang/RuntimeException
  }

  public final long getBufferedPosition()
  {
    if (this.zzacm == -1L)
      return -1L;
    return this.zzacm / 1000L;
  }

  public final long getDuration()
  {
    if (this.zzack == -1L)
      return -1L;
    return this.zzack / 1000L;
  }

  // ERROR //
  public final boolean handleMessage(Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 264	android/os/Message:what	I
    //   4: tableswitch	default:+1448 -> 1452, 1:+52->56, 2:+136->140, 3:+498->502, 4:+1077->1081, 5:+1083->1087, 6:+945->949, 7:+617->621, 8:+1236->1240, 9:+1114->1118
    //   57: getfield 268	android/os/Message:obj	Ljava/lang/Object;
    //   60: checkcast 269	[Lcom/google/android/gms/internal/ads/zzhp;
    //   63: astore 61
    //   65: aload_0
    //   66: invokespecial 227	com/google/android/gms/internal/ads/zzgk:zzdt	()V
    //   69: aload_0
    //   70: aload 61
    //   72: putfield 236	com/google/android/gms/internal/ads/zzgk:zzacd	[Lcom/google/android/gms/internal/ads/zzhp;
    //   75: iconst_0
    //   76: istore 62
    //   78: iload 62
    //   80: aload 61
    //   82: arraylength
    //   83: if_icmpge +41 -> 124
    //   86: aload 61
    //   88: iload 62
    //   90: aaload
    //   91: invokevirtual 272	com/google/android/gms/internal/ads/zzhp:zzdw	()Z
    //   94: ifeq +1360 -> 1454
    //   97: aload_0
    //   98: getfield 205	com/google/android/gms/internal/ads/zzgk:zzace	Lcom/google/android/gms/internal/ads/zzhp;
    //   101: ifnonnull +1359 -> 1460
    //   104: iconst_1
    //   105: istore 64
    //   107: iload 64
    //   109: invokestatic 278	com/google/android/gms/internal/ads/zzkh:checkState	(Z)V
    //   112: aload_0
    //   113: aload 61
    //   115: iload 62
    //   117: aaload
    //   118: putfield 205	com/google/android/gms/internal/ads/zzgk:zzace	Lcom/google/android/gms/internal/ads/zzhp;
    //   121: goto +1333 -> 1454
    //   124: aload_0
    //   125: iconst_2
    //   126: invokespecial 229	com/google/android/gms/internal/ads/zzgk:setState	(I)V
    //   129: aload_0
    //   130: getfield 125	com/google/android/gms/internal/ads/zzgk:handler	Landroid/os/Handler;
    //   133: iconst_2
    //   134: invokevirtual 147	android/os/Handler:sendEmptyMessage	(I)Z
    //   137: pop
    //   138: iconst_1
    //   139: ireturn
    //   140: invokestatic 143	android/os/SystemClock:elapsedRealtime	()J
    //   143: lstore 46
    //   145: iconst_1
    //   146: istore 48
    //   148: iconst_0
    //   149: istore 49
    //   151: iload 49
    //   153: aload_0
    //   154: getfield 236	com/google/android/gms/internal/ads/zzgk:zzacd	[Lcom/google/android/gms/internal/ads/zzhp;
    //   157: arraylength
    //   158: if_icmpge +39 -> 197
    //   161: aload_0
    //   162: getfield 236	com/google/android/gms/internal/ads/zzgk:zzacd	[Lcom/google/android/gms/internal/ads/zzhp;
    //   165: iload 49
    //   167: aaload
    //   168: invokevirtual 183	com/google/android/gms/internal/ads/zzhp:getState	()I
    //   171: ifne +1295 -> 1466
    //   174: aload_0
    //   175: getfield 236	com/google/android/gms/internal/ads/zzgk:zzacd	[Lcom/google/android/gms/internal/ads/zzhp;
    //   178: iload 49
    //   180: aaload
    //   181: aload_0
    //   182: getfield 173	com/google/android/gms/internal/ads/zzgk:zzacl	J
    //   185: invokevirtual 282	com/google/android/gms/internal/ads/zzhp:zzdm	(J)I
    //   188: ifne +1278 -> 1466
    //   191: iconst_0
    //   192: istore 48
    //   194: goto +1272 -> 1466
    //   197: iload 48
    //   199: ifne +1275 -> 1474
    //   202: aload_0
    //   203: iconst_2
    //   204: lload 46
    //   206: ldc2_w 283
    //   209: invokespecial 286	com/google/android/gms/internal/ads/zzgk:zza	(IJJ)V
    //   212: goto +1260 -> 1472
    //   215: iload 54
    //   217: aload_0
    //   218: getfield 236	com/google/android/gms/internal/ads/zzgk:zzacd	[Lcom/google/android/gms/internal/ads/zzhp;
    //   221: arraylength
    //   222: if_icmpge +140 -> 362
    //   225: aload_0
    //   226: getfield 236	com/google/android/gms/internal/ads/zzgk:zzacd	[Lcom/google/android/gms/internal/ads/zzhp;
    //   229: iload 54
    //   231: aaload
    //   232: astore 57
    //   234: aload_0
    //   235: getfield 52	com/google/android/gms/internal/ads/zzgk:zzabt	[Z
    //   238: iload 54
    //   240: baload
    //   241: ifeq +1248 -> 1489
    //   244: aload 57
    //   246: invokevirtual 183	com/google/android/gms/internal/ads/zzhp:getState	()I
    //   249: iconst_1
    //   250: if_icmpne +1239 -> 1489
    //   253: aload 57
    //   255: aload_0
    //   256: getfield 173	com/google/android/gms/internal/ads/zzgk:zzacl	J
    //   259: iconst_0
    //   260: invokevirtual 290	com/google/android/gms/internal/ads/zzhp:zzc	(JZ)V
    //   263: aload_0
    //   264: getfield 80	com/google/android/gms/internal/ads/zzgk:zzacc	Ljava/util/List;
    //   267: aload 57
    //   269: invokeinterface 293 2 0
    //   274: pop
    //   275: iload 51
    //   277: ifeq +1218 -> 1495
    //   280: aload 57
    //   282: invokevirtual 158	com/google/android/gms/internal/ads/zzhp:zzdx	()Z
    //   285: ifeq +1210 -> 1495
    //   288: iconst_1
    //   289: istore 51
    //   291: iload 50
    //   293: ifeq +1208 -> 1501
    //   296: aload_0
    //   297: aload 57
    //   299: invokespecial 295	com/google/android/gms/internal/ads/zzgk:zza	(Lcom/google/android/gms/internal/ads/zzhp;)Z
    //   302: ifeq +1199 -> 1501
    //   305: iconst_1
    //   306: istore 50
    //   308: lload 52
    //   310: ldc2_w 63
    //   313: lcmp
    //   314: ifeq +1175 -> 1489
    //   317: aload 57
    //   319: invokevirtual 164	com/google/android/gms/internal/ads/zzhp:getDurationUs	()J
    //   322: lstore 59
    //   324: lload 59
    //   326: ldc2_w 63
    //   329: lcmp
    //   330: ifne +11 -> 341
    //   333: ldc2_w 63
    //   336: lstore 52
    //   338: goto +1151 -> 1489
    //   341: lload 59
    //   343: ldc2_w 174
    //   346: lcmp
    //   347: ifeq +1142 -> 1489
    //   350: lload 52
    //   352: lload 59
    //   354: invokestatic 301	java/lang/Math:max	(JJ)J
    //   357: lstore 52
    //   359: goto +1130 -> 1489
    //   362: aload_0
    //   363: lload 52
    //   365: putfield 66	com/google/android/gms/internal/ads/zzgk:zzack	J
    //   368: iload 51
    //   370: ifeq +53 -> 423
    //   373: aload_0
    //   374: iconst_5
    //   375: invokespecial 229	com/google/android/gms/internal/ads/zzgk:setState	(I)V
    //   378: aload_0
    //   379: getfield 125	com/google/android/gms/internal/ads/zzgk:handler	Landroid/os/Handler;
    //   382: bipush 7
    //   384: invokevirtual 147	android/os/Handler:sendEmptyMessage	(I)Z
    //   387: pop
    //   388: goto +1084 -> 1472
    //   391: astore 4
    //   393: ldc 244
    //   395: ldc_w 303
    //   398: aload 4
    //   400: invokestatic 252	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   403: pop
    //   404: aload_0
    //   405: getfield 48	com/google/android/gms/internal/ads/zzgk:zzabq	Landroid/os/Handler;
    //   408: iconst_3
    //   409: aload 4
    //   411: invokevirtual 306	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   414: invokevirtual 135	android/os/Message:sendToTarget	()V
    //   417: aload_0
    //   418: invokespecial 308	com/google/android/gms/internal/ads/zzgk:zzds	()V
    //   421: iconst_1
    //   422: ireturn
    //   423: iload 50
    //   425: ifeq +71 -> 496
    //   428: iconst_4
    //   429: istore 56
    //   431: aload_0
    //   432: iload 56
    //   434: invokespecial 229	com/google/android/gms/internal/ads/zzgk:setState	(I)V
    //   437: aload_0
    //   438: getfield 50	com/google/android/gms/internal/ads/zzgk:zzabu	Z
    //   441: ifeq -63 -> 378
    //   444: aload_0
    //   445: getfield 62	com/google/android/gms/internal/ads/zzgk:state	I
    //   448: iconst_4
    //   449: if_icmpne -71 -> 378
    //   452: aload_0
    //   453: invokespecial 310	com/google/android/gms/internal/ads/zzgk:zzdp	()V
    //   456: goto -78 -> 378
    //   459: astore_2
    //   460: ldc 244
    //   462: ldc_w 312
    //   465: aload_2
    //   466: invokestatic 252	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   469: pop
    //   470: aload_0
    //   471: getfield 48	com/google/android/gms/internal/ads/zzgk:zzabq	Landroid/os/Handler;
    //   474: iconst_3
    //   475: new 179	com/google/android/gms/internal/ads/zzgd
    //   478: dup
    //   479: aload_2
    //   480: iconst_1
    //   481: invokespecial 315	com/google/android/gms/internal/ads/zzgd:<init>	(Ljava/lang/Throwable;Z)V
    //   484: invokevirtual 306	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   487: invokevirtual 135	android/os/Message:sendToTarget	()V
    //   490: aload_0
    //   491: invokespecial 308	com/google/android/gms/internal/ads/zzgk:zzds	()V
    //   494: iconst_1
    //   495: ireturn
    //   496: iconst_3
    //   497: istore 56
    //   499: goto -68 -> 431
    //   502: aload_1
    //   503: getfield 318	android/os/Message:arg1	I
    //   506: istore 41
    //   508: iload 41
    //   510: ifeq +43 -> 553
    //   513: iconst_1
    //   514: istore 42
    //   516: aload_0
    //   517: iconst_0
    //   518: putfield 169	com/google/android/gms/internal/ads/zzgk:zzacg	Z
    //   521: aload_0
    //   522: iload 42
    //   524: putfield 50	com/google/android/gms/internal/ads/zzgk:zzabu	Z
    //   527: iload 42
    //   529: ifne +30 -> 559
    //   532: aload_0
    //   533: invokespecial 320	com/google/android/gms/internal/ads/zzgk:zzdq	()V
    //   536: aload_0
    //   537: invokespecial 322	com/google/android/gms/internal/ads/zzgk:zzdr	()V
    //   540: aload_0
    //   541: getfield 48	com/google/android/gms/internal/ads/zzgk:zzabq	Landroid/os/Handler;
    //   544: iconst_2
    //   545: invokevirtual 325	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
    //   548: invokevirtual 135	android/os/Message:sendToTarget	()V
    //   551: iconst_1
    //   552: ireturn
    //   553: iconst_0
    //   554: istore 42
    //   556: goto -40 -> 516
    //   559: aload_0
    //   560: getfield 62	com/google/android/gms/internal/ads/zzgk:state	I
    //   563: iconst_4
    //   564: if_icmpne +36 -> 600
    //   567: aload_0
    //   568: invokespecial 310	com/google/android/gms/internal/ads/zzgk:zzdp	()V
    //   571: aload_0
    //   572: getfield 125	com/google/android/gms/internal/ads/zzgk:handler	Landroid/os/Handler;
    //   575: bipush 7
    //   577: invokevirtual 147	android/os/Handler:sendEmptyMessage	(I)Z
    //   580: pop
    //   581: goto -41 -> 540
    //   584: astore 43
    //   586: aload_0
    //   587: getfield 48	com/google/android/gms/internal/ads/zzgk:zzabq	Landroid/os/Handler;
    //   590: iconst_2
    //   591: invokevirtual 325	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
    //   594: invokevirtual 135	android/os/Message:sendToTarget	()V
    //   597: aload 43
    //   599: athrow
    //   600: aload_0
    //   601: getfield 62	com/google/android/gms/internal/ads/zzgk:state	I
    //   604: iconst_3
    //   605: if_icmpne -65 -> 540
    //   608: aload_0
    //   609: getfield 125	com/google/android/gms/internal/ads/zzgk:handler	Landroid/os/Handler;
    //   612: bipush 7
    //   614: invokevirtual 147	android/os/Handler:sendEmptyMessage	(I)Z
    //   617: pop
    //   618: goto -78 -> 540
    //   621: ldc_w 327
    //   624: invokestatic 333	com/google/android/gms/internal/ads/zzkp:beginSection	(Ljava/lang/String;)V
    //   627: invokestatic 143	android/os/SystemClock:elapsedRealtime	()J
    //   630: lstore 27
    //   632: aload_0
    //   633: getfield 66	com/google/android/gms/internal/ads/zzgk:zzack	J
    //   636: ldc2_w 63
    //   639: lcmp
    //   640: ifeq +877 -> 1517
    //   643: aload_0
    //   644: getfield 66	com/google/android/gms/internal/ads/zzgk:zzack	J
    //   647: lstore 29
    //   649: iconst_1
    //   650: istore 31
    //   652: iconst_1
    //   653: istore 32
    //   655: aload_0
    //   656: invokespecial 322	com/google/android/gms/internal/ads/zzgk:zzdr	()V
    //   659: iconst_0
    //   660: istore 33
    //   662: iload 33
    //   664: aload_0
    //   665: getfield 80	com/google/android/gms/internal/ads/zzgk:zzacc	Ljava/util/List;
    //   668: invokeinterface 193 1 0
    //   673: if_icmpge +117 -> 790
    //   676: aload_0
    //   677: getfield 80	com/google/android/gms/internal/ads/zzgk:zzacc	Ljava/util/List;
    //   680: iload 33
    //   682: invokeinterface 197 2 0
    //   687: checkcast 154	com/google/android/gms/internal/ads/zzhp
    //   690: astore 34
    //   692: aload 34
    //   694: aload_0
    //   695: getfield 173	com/google/android/gms/internal/ads/zzgk:zzacl	J
    //   698: aload_0
    //   699: getfield 220	com/google/android/gms/internal/ads/zzgk:zzacj	J
    //   702: invokevirtual 336	com/google/android/gms/internal/ads/zzhp:zza	(JJ)V
    //   705: iload 31
    //   707: ifeq +818 -> 1525
    //   710: aload 34
    //   712: invokevirtual 158	com/google/android/gms/internal/ads/zzhp:zzdx	()Z
    //   715: ifeq +810 -> 1525
    //   718: iconst_1
    //   719: istore 31
    //   721: iload 32
    //   723: ifeq +808 -> 1531
    //   726: aload_0
    //   727: aload 34
    //   729: invokespecial 295	com/google/android/gms/internal/ads/zzgk:zza	(Lcom/google/android/gms/internal/ads/zzhp;)Z
    //   732: ifeq +799 -> 1531
    //   735: iconst_1
    //   736: istore 32
    //   738: lload 29
    //   740: ldc2_w 63
    //   743: lcmp
    //   744: ifeq +701 -> 1445
    //   747: aload 34
    //   749: invokevirtual 164	com/google/android/gms/internal/ads/zzhp:getDurationUs	()J
    //   752: lstore 35
    //   754: aload 34
    //   756: invokevirtual 167	com/google/android/gms/internal/ads/zzhp:zzdu	()J
    //   759: lstore 37
    //   761: lload 37
    //   763: ldc2_w 63
    //   766: lcmp
    //   767: ifne +770 -> 1537
    //   770: ldc2_w 63
    //   773: lstore 39
    //   775: goto +732 -> 1507
    //   778: lload 29
    //   780: lload 37
    //   782: invokestatic 339	java/lang/Math:min	(JJ)J
    //   785: lstore 39
    //   787: goto +720 -> 1507
    //   790: aload_0
    //   791: lload 29
    //   793: putfield 68	com/google/android/gms/internal/ads/zzgk:zzacm	J
    //   796: iload 31
    //   798: ifeq +60 -> 858
    //   801: aload_0
    //   802: iconst_5
    //   803: invokespecial 229	com/google/android/gms/internal/ads/zzgk:setState	(I)V
    //   806: aload_0
    //   807: invokespecial 320	com/google/android/gms/internal/ads/zzgk:zzdq	()V
    //   810: aload_0
    //   811: getfield 125	com/google/android/gms/internal/ads/zzgk:handler	Landroid/os/Handler;
    //   814: bipush 7
    //   816: invokevirtual 234	android/os/Handler:removeMessages	(I)V
    //   819: aload_0
    //   820: getfield 50	com/google/android/gms/internal/ads/zzgk:zzabu	Z
    //   823: ifeq +11 -> 834
    //   826: aload_0
    //   827: getfield 62	com/google/android/gms/internal/ads/zzgk:state	I
    //   830: iconst_4
    //   831: if_icmpeq +11 -> 842
    //   834: aload_0
    //   835: getfield 62	com/google/android/gms/internal/ads/zzgk:state	I
    //   838: iconst_3
    //   839: if_icmpne +84 -> 923
    //   842: aload_0
    //   843: bipush 7
    //   845: lload 27
    //   847: ldc2_w 283
    //   850: invokespecial 286	com/google/android/gms/internal/ads/zzgk:zza	(IJJ)V
    //   853: invokestatic 342	com/google/android/gms/internal/ads/zzkp:endSection	()V
    //   856: iconst_1
    //   857: ireturn
    //   858: aload_0
    //   859: getfield 62	com/google/android/gms/internal/ads/zzgk:state	I
    //   862: iconst_3
    //   863: if_icmpne +27 -> 890
    //   866: iload 32
    //   868: ifeq +22 -> 890
    //   871: aload_0
    //   872: iconst_4
    //   873: invokespecial 229	com/google/android/gms/internal/ads/zzgk:setState	(I)V
    //   876: aload_0
    //   877: getfield 50	com/google/android/gms/internal/ads/zzgk:zzabu	Z
    //   880: ifeq -70 -> 810
    //   883: aload_0
    //   884: invokespecial 310	com/google/android/gms/internal/ads/zzgk:zzdp	()V
    //   887: goto -77 -> 810
    //   890: aload_0
    //   891: getfield 62	com/google/android/gms/internal/ads/zzgk:state	I
    //   894: iconst_4
    //   895: if_icmpne -85 -> 810
    //   898: iload 32
    //   900: ifne -90 -> 810
    //   903: aload_0
    //   904: aload_0
    //   905: getfield 50	com/google/android/gms/internal/ads/zzgk:zzabu	Z
    //   908: putfield 169	com/google/android/gms/internal/ads/zzgk:zzacg	Z
    //   911: aload_0
    //   912: iconst_3
    //   913: invokespecial 229	com/google/android/gms/internal/ads/zzgk:setState	(I)V
    //   916: aload_0
    //   917: invokespecial 320	com/google/android/gms/internal/ads/zzgk:zzdq	()V
    //   920: goto -110 -> 810
    //   923: aload_0
    //   924: getfield 80	com/google/android/gms/internal/ads/zzgk:zzacc	Ljava/util/List;
    //   927: invokeinterface 345 1 0
    //   932: ifne -79 -> 853
    //   935: aload_0
    //   936: bipush 7
    //   938: lload 27
    //   940: ldc2_w 217
    //   943: invokespecial 286	com/google/android/gms/internal/ads/zzgk:zza	(IJJ)V
    //   946: goto -93 -> 853
    //   949: aload_1
    //   950: getfield 268	android/os/Message:obj	Ljava/lang/Object;
    //   953: checkcast 347	java/lang/Long
    //   956: invokevirtual 350	java/lang/Long:longValue	()J
    //   959: lstore 22
    //   961: aload_0
    //   962: iconst_0
    //   963: putfield 169	com/google/android/gms/internal/ads/zzgk:zzacg	Z
    //   966: aload_0
    //   967: lload 22
    //   969: ldc2_w 217
    //   972: lmul
    //   973: putfield 173	com/google/android/gms/internal/ads/zzgk:zzacl	J
    //   976: aload_0
    //   977: getfield 73	com/google/android/gms/internal/ads/zzgk:zzabz	Lcom/google/android/gms/internal/ads/zzgm;
    //   980: invokevirtual 200	com/google/android/gms/internal/ads/zzgm:stop	()V
    //   983: aload_0
    //   984: getfield 73	com/google/android/gms/internal/ads/zzgk:zzabz	Lcom/google/android/gms/internal/ads/zzgm;
    //   987: aload_0
    //   988: getfield 173	com/google/android/gms/internal/ads/zzgk:zzacl	J
    //   991: invokevirtual 216	com/google/android/gms/internal/ads/zzgm:zzdj	(J)V
    //   994: aload_0
    //   995: getfield 62	com/google/android/gms/internal/ads/zzgk:state	I
    //   998: iconst_1
    //   999: if_icmpeq +576 -> 1575
    //   1002: aload_0
    //   1003: getfield 62	com/google/android/gms/internal/ads/zzgk:state	I
    //   1006: iconst_2
    //   1007: if_icmpne +570 -> 1577
    //   1010: goto +565 -> 1575
    //   1013: iload 24
    //   1015: aload_0
    //   1016: getfield 80	com/google/android/gms/internal/ads/zzgk:zzacc	Ljava/util/List;
    //   1019: invokeinterface 193 1 0
    //   1024: if_icmpge +39 -> 1063
    //   1027: aload_0
    //   1028: getfield 80	com/google/android/gms/internal/ads/zzgk:zzacc	Ljava/util/List;
    //   1031: iload 24
    //   1033: invokeinterface 197 2 0
    //   1038: checkcast 154	com/google/android/gms/internal/ads/zzhp
    //   1041: astore 26
    //   1043: aload 26
    //   1045: invokestatic 202	com/google/android/gms/internal/ads/zzgk:zzb	(Lcom/google/android/gms/internal/ads/zzhp;)V
    //   1048: aload 26
    //   1050: aload_0
    //   1051: getfield 173	com/google/android/gms/internal/ads/zzgk:zzacl	J
    //   1054: invokevirtual 353	com/google/android/gms/internal/ads/zzhp:seekTo	(J)V
    //   1057: iinc 24 1
    //   1060: goto -47 -> 1013
    //   1063: aload_0
    //   1064: iconst_3
    //   1065: invokespecial 229	com/google/android/gms/internal/ads/zzgk:setState	(I)V
    //   1068: aload_0
    //   1069: getfield 125	com/google/android/gms/internal/ads/zzgk:handler	Landroid/os/Handler;
    //   1072: bipush 7
    //   1074: invokevirtual 147	android/os/Handler:sendEmptyMessage	(I)Z
    //   1077: pop
    //   1078: goto +497 -> 1575
    //   1081: aload_0
    //   1082: invokespecial 308	com/google/android/gms/internal/ads/zzgk:zzds	()V
    //   1085: iconst_1
    //   1086: ireturn
    //   1087: aload_0
    //   1088: invokespecial 227	com/google/android/gms/internal/ads/zzgk:zzdt	()V
    //   1091: aload_0
    //   1092: iconst_1
    //   1093: invokespecial 229	com/google/android/gms/internal/ads/zzgk:setState	(I)V
    //   1096: aload_0
    //   1097: monitorenter
    //   1098: aload_0
    //   1099: iconst_1
    //   1100: putfield 355	com/google/android/gms/internal/ads/zzgk:zzacf	Z
    //   1103: aload_0
    //   1104: invokevirtual 358	java/lang/Object:notifyAll	()V
    //   1107: aload_0
    //   1108: monitorexit
    //   1109: iconst_1
    //   1110: ireturn
    //   1111: astore 21
    //   1113: aload_0
    //   1114: monitorexit
    //   1115: aload 21
    //   1117: athrow
    //   1118: aload_1
    //   1119: getfield 318	android/os/Message:arg1	I
    //   1122: istore 14
    //   1124: aload_1
    //   1125: getfield 268	android/os/Message:obj	Ljava/lang/Object;
    //   1128: astore 15
    //   1130: aload 15
    //   1132: checkcast 360	android/util/Pair
    //   1135: astore 18
    //   1137: aload 18
    //   1139: getfield 363	android/util/Pair:first	Ljava/lang/Object;
    //   1142: checkcast 365	com/google/android/gms/internal/ads/zzgf
    //   1145: iload 14
    //   1147: aload 18
    //   1149: getfield 368	android/util/Pair:second	Ljava/lang/Object;
    //   1152: invokeinterface 371 3 0
    //   1157: aload_0
    //   1158: monitorenter
    //   1159: aload_0
    //   1160: iconst_1
    //   1161: aload_0
    //   1162: getfield 46	com/google/android/gms/internal/ads/zzgk:zzaci	I
    //   1165: iadd
    //   1166: putfield 46	com/google/android/gms/internal/ads/zzgk:zzaci	I
    //   1169: aload_0
    //   1170: invokevirtual 358	java/lang/Object:notifyAll	()V
    //   1173: aload_0
    //   1174: monitorexit
    //   1175: aload_0
    //   1176: getfield 62	com/google/android/gms/internal/ads/zzgk:state	I
    //   1179: iconst_1
    //   1180: if_icmpeq +21 -> 1201
    //   1183: aload_0
    //   1184: getfield 62	com/google/android/gms/internal/ads/zzgk:state	I
    //   1187: iconst_2
    //   1188: if_icmpeq +13 -> 1201
    //   1191: aload_0
    //   1192: getfield 125	com/google/android/gms/internal/ads/zzgk:handler	Landroid/os/Handler;
    //   1195: bipush 7
    //   1197: invokevirtual 147	android/os/Handler:sendEmptyMessage	(I)Z
    //   1200: pop
    //   1201: iconst_1
    //   1202: ireturn
    //   1203: astore 19
    //   1205: aload_0
    //   1206: monitorexit
    //   1207: aload 19
    //   1209: athrow
    //   1210: astore 16
    //   1212: aload_0
    //   1213: monitorenter
    //   1214: aload_0
    //   1215: iconst_1
    //   1216: aload_0
    //   1217: getfield 46	com/google/android/gms/internal/ads/zzgk:zzaci	I
    //   1220: iadd
    //   1221: putfield 46	com/google/android/gms/internal/ads/zzgk:zzaci	I
    //   1224: aload_0
    //   1225: invokevirtual 358	java/lang/Object:notifyAll	()V
    //   1228: aload_0
    //   1229: monitorexit
    //   1230: aload 16
    //   1232: athrow
    //   1233: astore 17
    //   1235: aload_0
    //   1236: monitorexit
    //   1237: aload 17
    //   1239: athrow
    //   1240: aload_1
    //   1241: getfield 318	android/os/Message:arg1	I
    //   1244: istore 6
    //   1246: aload_1
    //   1247: getfield 374	android/os/Message:arg2	I
    //   1250: ifeq +335 -> 1585
    //   1253: iconst_1
    //   1254: istore 7
    //   1256: aload_0
    //   1257: getfield 52	com/google/android/gms/internal/ads/zzgk:zzabt	[Z
    //   1260: iload 6
    //   1262: baload
    //   1263: iload 7
    //   1265: if_icmpeq +318 -> 1583
    //   1268: aload_0
    //   1269: getfield 52	com/google/android/gms/internal/ads/zzgk:zzabt	[Z
    //   1272: iload 6
    //   1274: iload 7
    //   1276: bastore
    //   1277: aload_0
    //   1278: getfield 62	com/google/android/gms/internal/ads/zzgk:state	I
    //   1281: iconst_1
    //   1282: if_icmpeq +301 -> 1583
    //   1285: aload_0
    //   1286: getfield 62	com/google/android/gms/internal/ads/zzgk:state	I
    //   1289: iconst_2
    //   1290: if_icmpne +6 -> 1296
    //   1293: goto +290 -> 1583
    //   1296: aload_0
    //   1297: getfield 236	com/google/android/gms/internal/ads/zzgk:zzacd	[Lcom/google/android/gms/internal/ads/zzhp;
    //   1300: iload 6
    //   1302: aaload
    //   1303: astore 8
    //   1305: aload 8
    //   1307: invokevirtual 183	com/google/android/gms/internal/ads/zzhp:getState	()I
    //   1310: istore 9
    //   1312: iload 9
    //   1314: iconst_1
    //   1315: if_icmpeq +15 -> 1330
    //   1318: iload 9
    //   1320: iconst_2
    //   1321: if_icmpeq +9 -> 1330
    //   1324: iload 9
    //   1326: iconst_3
    //   1327: if_icmpne +256 -> 1583
    //   1330: iload 7
    //   1332: ifeq +67 -> 1399
    //   1335: aload_0
    //   1336: getfield 50	com/google/android/gms/internal/ads/zzgk:zzabu	Z
    //   1339: ifeq +252 -> 1591
    //   1342: aload_0
    //   1343: getfield 62	com/google/android/gms/internal/ads/zzgk:state	I
    //   1346: iconst_4
    //   1347: if_icmpne +244 -> 1591
    //   1350: iconst_1
    //   1351: istore 10
    //   1353: aload 8
    //   1355: aload_0
    //   1356: getfield 173	com/google/android/gms/internal/ads/zzgk:zzacl	J
    //   1359: iload 10
    //   1361: invokevirtual 290	com/google/android/gms/internal/ads/zzhp:zzc	(JZ)V
    //   1364: aload_0
    //   1365: getfield 80	com/google/android/gms/internal/ads/zzgk:zzacc	Ljava/util/List;
    //   1368: aload 8
    //   1370: invokeinterface 293 2 0
    //   1375: pop
    //   1376: iload 10
    //   1378: ifeq +8 -> 1386
    //   1381: aload 8
    //   1383: invokevirtual 198	com/google/android/gms/internal/ads/zzhp:start	()V
    //   1386: aload_0
    //   1387: getfield 125	com/google/android/gms/internal/ads/zzgk:handler	Landroid/os/Handler;
    //   1390: bipush 7
    //   1392: invokevirtual 147	android/os/Handler:sendEmptyMessage	(I)Z
    //   1395: pop
    //   1396: goto +187 -> 1583
    //   1399: aload 8
    //   1401: aload_0
    //   1402: getfield 205	com/google/android/gms/internal/ads/zzgk:zzace	Lcom/google/android/gms/internal/ads/zzhp;
    //   1405: if_acmpne +15 -> 1420
    //   1408: aload_0
    //   1409: getfield 73	com/google/android/gms/internal/ads/zzgk:zzabz	Lcom/google/android/gms/internal/ads/zzgm;
    //   1412: aload 8
    //   1414: invokevirtual 212	com/google/android/gms/internal/ads/zzhp:zzdy	()J
    //   1417: invokevirtual 216	com/google/android/gms/internal/ads/zzgm:zzdj	(J)V
    //   1420: aload 8
    //   1422: invokestatic 202	com/google/android/gms/internal/ads/zzgk:zzb	(Lcom/google/android/gms/internal/ads/zzhp;)V
    //   1425: aload_0
    //   1426: getfield 80	com/google/android/gms/internal/ads/zzgk:zzacc	Ljava/util/List;
    //   1429: aload 8
    //   1431: invokeinterface 377 2 0
    //   1436: pop
    //   1437: aload 8
    //   1439: invokevirtual 239	com/google/android/gms/internal/ads/zzhp:disable	()V
    //   1442: goto +141 -> 1583
    //   1445: lload 29
    //   1447: lstore 39
    //   1449: goto +58 -> 1507
    //   1452: iconst_0
    //   1453: ireturn
    //   1454: iinc 62 1
    //   1457: goto -1379 -> 78
    //   1460: iconst_0
    //   1461: istore 64
    //   1463: goto -1356 -> 107
    //   1466: iinc 49 1
    //   1469: goto -1318 -> 151
    //   1472: iconst_1
    //   1473: ireturn
    //   1474: iconst_1
    //   1475: istore 50
    //   1477: iconst_1
    //   1478: istore 51
    //   1480: lconst_0
    //   1481: lstore 52
    //   1483: iconst_0
    //   1484: istore 54
    //   1486: goto -1271 -> 215
    //   1489: iinc 54 1
    //   1492: goto -1277 -> 215
    //   1495: iconst_0
    //   1496: istore 51
    //   1498: goto -1207 -> 291
    //   1501: iconst_0
    //   1502: istore 50
    //   1504: goto -1196 -> 308
    //   1507: iinc 33 1
    //   1510: lload 39
    //   1512: lstore 29
    //   1514: goto -852 -> 662
    //   1517: ldc2_w 378
    //   1520: lstore 29
    //   1522: goto -873 -> 649
    //   1525: iconst_0
    //   1526: istore 31
    //   1528: goto -807 -> 721
    //   1531: iconst_0
    //   1532: istore 32
    //   1534: goto -796 -> 738
    //   1537: lload 37
    //   1539: ldc2_w 170
    //   1542: lcmp
    //   1543: ifeq -98 -> 1445
    //   1546: lload 35
    //   1548: ldc2_w 63
    //   1551: lcmp
    //   1552: ifeq -774 -> 778
    //   1555: lload 35
    //   1557: ldc2_w 174
    //   1560: lcmp
    //   1561: ifeq -783 -> 778
    //   1564: lload 37
    //   1566: lload 35
    //   1568: lcmp
    //   1569: ifge -124 -> 1445
    //   1572: goto -794 -> 778
    //   1575: iconst_1
    //   1576: ireturn
    //   1577: iconst_0
    //   1578: istore 24
    //   1580: goto -567 -> 1013
    //   1583: iconst_1
    //   1584: ireturn
    //   1585: iconst_0
    //   1586: istore 7
    //   1588: goto -332 -> 1256
    //   1591: iconst_0
    //   1592: istore 10
    //   1594: goto -241 -> 1353
    //
    // Exception table:
    //   from	to	target	type
    //   0	56	391	com/google/android/gms/internal/ads/zzgd
    //   56	75	391	com/google/android/gms/internal/ads/zzgd
    //   78	104	391	com/google/android/gms/internal/ads/zzgd
    //   107	121	391	com/google/android/gms/internal/ads/zzgd
    //   124	138	391	com/google/android/gms/internal/ads/zzgd
    //   140	145	391	com/google/android/gms/internal/ads/zzgd
    //   151	191	391	com/google/android/gms/internal/ads/zzgd
    //   202	212	391	com/google/android/gms/internal/ads/zzgd
    //   215	275	391	com/google/android/gms/internal/ads/zzgd
    //   280	288	391	com/google/android/gms/internal/ads/zzgd
    //   296	305	391	com/google/android/gms/internal/ads/zzgd
    //   317	324	391	com/google/android/gms/internal/ads/zzgd
    //   350	359	391	com/google/android/gms/internal/ads/zzgd
    //   362	368	391	com/google/android/gms/internal/ads/zzgd
    //   373	378	391	com/google/android/gms/internal/ads/zzgd
    //   378	388	391	com/google/android/gms/internal/ads/zzgd
    //   431	456	391	com/google/android/gms/internal/ads/zzgd
    //   502	508	391	com/google/android/gms/internal/ads/zzgd
    //   540	551	391	com/google/android/gms/internal/ads/zzgd
    //   586	600	391	com/google/android/gms/internal/ads/zzgd
    //   621	649	391	com/google/android/gms/internal/ads/zzgd
    //   655	659	391	com/google/android/gms/internal/ads/zzgd
    //   662	705	391	com/google/android/gms/internal/ads/zzgd
    //   710	718	391	com/google/android/gms/internal/ads/zzgd
    //   726	735	391	com/google/android/gms/internal/ads/zzgd
    //   747	761	391	com/google/android/gms/internal/ads/zzgd
    //   778	787	391	com/google/android/gms/internal/ads/zzgd
    //   790	796	391	com/google/android/gms/internal/ads/zzgd
    //   801	810	391	com/google/android/gms/internal/ads/zzgd
    //   810	834	391	com/google/android/gms/internal/ads/zzgd
    //   834	842	391	com/google/android/gms/internal/ads/zzgd
    //   842	853	391	com/google/android/gms/internal/ads/zzgd
    //   853	856	391	com/google/android/gms/internal/ads/zzgd
    //   858	866	391	com/google/android/gms/internal/ads/zzgd
    //   871	887	391	com/google/android/gms/internal/ads/zzgd
    //   890	898	391	com/google/android/gms/internal/ads/zzgd
    //   903	920	391	com/google/android/gms/internal/ads/zzgd
    //   923	946	391	com/google/android/gms/internal/ads/zzgd
    //   949	1010	391	com/google/android/gms/internal/ads/zzgd
    //   1013	1057	391	com/google/android/gms/internal/ads/zzgd
    //   1063	1078	391	com/google/android/gms/internal/ads/zzgd
    //   1081	1085	391	com/google/android/gms/internal/ads/zzgd
    //   1087	1098	391	com/google/android/gms/internal/ads/zzgd
    //   1115	1118	391	com/google/android/gms/internal/ads/zzgd
    //   1118	1130	391	com/google/android/gms/internal/ads/zzgd
    //   1157	1159	391	com/google/android/gms/internal/ads/zzgd
    //   1175	1201	391	com/google/android/gms/internal/ads/zzgd
    //   1207	1210	391	com/google/android/gms/internal/ads/zzgd
    //   1212	1214	391	com/google/android/gms/internal/ads/zzgd
    //   1230	1233	391	com/google/android/gms/internal/ads/zzgd
    //   1237	1240	391	com/google/android/gms/internal/ads/zzgd
    //   1240	1253	391	com/google/android/gms/internal/ads/zzgd
    //   1256	1293	391	com/google/android/gms/internal/ads/zzgd
    //   1296	1312	391	com/google/android/gms/internal/ads/zzgd
    //   1335	1350	391	com/google/android/gms/internal/ads/zzgd
    //   1353	1376	391	com/google/android/gms/internal/ads/zzgd
    //   1381	1386	391	com/google/android/gms/internal/ads/zzgd
    //   1386	1396	391	com/google/android/gms/internal/ads/zzgd
    //   1399	1420	391	com/google/android/gms/internal/ads/zzgd
    //   1420	1442	391	com/google/android/gms/internal/ads/zzgd
    //   0	56	459	java/lang/RuntimeException
    //   56	75	459	java/lang/RuntimeException
    //   78	104	459	java/lang/RuntimeException
    //   107	121	459	java/lang/RuntimeException
    //   124	138	459	java/lang/RuntimeException
    //   140	145	459	java/lang/RuntimeException
    //   151	191	459	java/lang/RuntimeException
    //   202	212	459	java/lang/RuntimeException
    //   215	275	459	java/lang/RuntimeException
    //   280	288	459	java/lang/RuntimeException
    //   296	305	459	java/lang/RuntimeException
    //   317	324	459	java/lang/RuntimeException
    //   350	359	459	java/lang/RuntimeException
    //   362	368	459	java/lang/RuntimeException
    //   373	378	459	java/lang/RuntimeException
    //   378	388	459	java/lang/RuntimeException
    //   431	456	459	java/lang/RuntimeException
    //   502	508	459	java/lang/RuntimeException
    //   540	551	459	java/lang/RuntimeException
    //   586	600	459	java/lang/RuntimeException
    //   621	649	459	java/lang/RuntimeException
    //   655	659	459	java/lang/RuntimeException
    //   662	705	459	java/lang/RuntimeException
    //   710	718	459	java/lang/RuntimeException
    //   726	735	459	java/lang/RuntimeException
    //   747	761	459	java/lang/RuntimeException
    //   778	787	459	java/lang/RuntimeException
    //   790	796	459	java/lang/RuntimeException
    //   801	810	459	java/lang/RuntimeException
    //   810	834	459	java/lang/RuntimeException
    //   834	842	459	java/lang/RuntimeException
    //   842	853	459	java/lang/RuntimeException
    //   853	856	459	java/lang/RuntimeException
    //   858	866	459	java/lang/RuntimeException
    //   871	887	459	java/lang/RuntimeException
    //   890	898	459	java/lang/RuntimeException
    //   903	920	459	java/lang/RuntimeException
    //   923	946	459	java/lang/RuntimeException
    //   949	1010	459	java/lang/RuntimeException
    //   1013	1057	459	java/lang/RuntimeException
    //   1063	1078	459	java/lang/RuntimeException
    //   1081	1085	459	java/lang/RuntimeException
    //   1087	1098	459	java/lang/RuntimeException
    //   1115	1118	459	java/lang/RuntimeException
    //   1118	1130	459	java/lang/RuntimeException
    //   1157	1159	459	java/lang/RuntimeException
    //   1175	1201	459	java/lang/RuntimeException
    //   1207	1210	459	java/lang/RuntimeException
    //   1212	1214	459	java/lang/RuntimeException
    //   1230	1233	459	java/lang/RuntimeException
    //   1237	1240	459	java/lang/RuntimeException
    //   1240	1253	459	java/lang/RuntimeException
    //   1256	1293	459	java/lang/RuntimeException
    //   1296	1312	459	java/lang/RuntimeException
    //   1335	1350	459	java/lang/RuntimeException
    //   1353	1376	459	java/lang/RuntimeException
    //   1381	1386	459	java/lang/RuntimeException
    //   1386	1396	459	java/lang/RuntimeException
    //   1399	1420	459	java/lang/RuntimeException
    //   1420	1442	459	java/lang/RuntimeException
    //   516	527	584	finally
    //   532	540	584	finally
    //   559	581	584	finally
    //   600	618	584	finally
    //   1098	1109	1111	finally
    //   1113	1115	1111	finally
    //   1159	1175	1203	finally
    //   1205	1207	1203	finally
    //   1130	1157	1210	finally
    //   1214	1230	1233	finally
    //   1235	1237	1233	finally
  }

  public final void release()
  {
    while (true)
    {
      try
      {
        boolean bool1 = this.zzacf;
        if (bool1)
          return;
        this.handler.sendEmptyMessage(5);
        boolean bool2 = this.zzacf;
        if (!bool2)
        {
          try
          {
            wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
          }
          continue;
        }
      }
      finally
      {
      }
      this.zzaby.quit();
    }
  }

  public final void seekTo(long paramLong)
  {
    this.handler.obtainMessage(6, Long.valueOf(paramLong)).sendToTarget();
  }

  public final void stop()
  {
    this.handler.sendEmptyMessage(4);
  }

  public final void zza(zzgf paramzzgf, int paramInt, Object paramObject)
  {
    this.zzach = (1 + this.zzach);
    this.handler.obtainMessage(9, 1, 0, Pair.create(paramzzgf, paramObject)).sendToTarget();
  }

  public final void zza(zzhp[] paramArrayOfzzhp)
  {
    this.handler.obtainMessage(1, paramArrayOfzzhp).sendToTarget();
  }

  public final void zzb(zzgf paramzzgf, int paramInt, Object paramObject)
  {
    try
    {
      if (this.zzacf)
      {
        Log.w("ExoPlayerImplInternal", 57 + "Sent message(1" + ") after release. Message ignored.");
        return;
      }
      int i = this.zzach;
      this.zzach = (i + 1);
      this.handler.obtainMessage(9, 1, 0, Pair.create(paramzzgf, paramObject)).sendToTarget();
      while (true)
      {
        int j = this.zzaci;
        if (j > i)
          break;
        try
        {
          wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          Thread.currentThread().interrupt();
        }
      }
    }
    finally
    {
    }
  }

  public final void zzc(int paramInt, boolean paramBoolean)
  {
    Handler localHandler = this.handler;
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      localHandler.obtainMessage(8, 0, i).sendToTarget();
      return;
    }
  }

  public final void zzd(boolean paramBoolean)
  {
    Handler localHandler = this.handler;
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      localHandler.obtainMessage(3, i, 0).sendToTarget();
      return;
    }
  }

  public final long zzdn()
  {
    return this.zzacl / 1000L;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzgk
 * JD-Core Version:    0.6.2
 */