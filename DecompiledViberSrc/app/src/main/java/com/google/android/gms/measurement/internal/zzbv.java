package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;

final class zzbv extends Thread
{
  private final Object zzaph;
  private final BlockingQueue<zzbu<?>> zzapi;

  public zzbv(String paramString, BlockingQueue<zzbu<?>> paramBlockingQueue)
  {
    Preconditions.checkNotNull(paramBlockingQueue);
    Object localObject;
    Preconditions.checkNotNull(localObject);
    this.zzaph = new Object();
    this.zzapi = localObject;
    setName(paramBlockingQueue);
  }

  private final void zza(InterruptedException paramInterruptedException)
  {
    this.zzape.zzgt().zzjj().zzg(String.valueOf(getName()).concat(" was interrupted"), paramInterruptedException);
  }

  // ERROR //
  public final void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iload_1
    //   3: ifne +29 -> 32
    //   6: aload_0
    //   7: getfield 15	com/google/android/gms/measurement/internal/zzbv:zzape	Lcom/google/android/gms/measurement/internal/zzbr;
    //   10: invokestatic 79	com/google/android/gms/measurement/internal/zzbr:zza	(Lcom/google/android/gms/measurement/internal/zzbr;)Ljava/util/concurrent/Semaphore;
    //   13: invokevirtual 84	java/util/concurrent/Semaphore:acquire	()V
    //   16: iconst_1
    //   17: istore_1
    //   18: goto -16 -> 2
    //   21: astore 20
    //   23: aload_0
    //   24: aload 20
    //   26: invokespecial 86	com/google/android/gms/measurement/internal/zzbv:zza	(Ljava/lang/InterruptedException;)V
    //   29: goto -27 -> 2
    //   32: invokestatic 92	android/os/Process:myTid	()I
    //   35: invokestatic 96	android/os/Process:getThreadPriority	(I)I
    //   38: istore 7
    //   40: aload_0
    //   41: getfield 31	com/google/android/gms/measurement/internal/zzbv:zzapi	Ljava/util/concurrent/BlockingQueue;
    //   44: invokeinterface 102 1 0
    //   49: checkcast 104	com/google/android/gms/measurement/internal/zzbu
    //   52: astore 8
    //   54: aload 8
    //   56: ifnull +90 -> 146
    //   59: aload 8
    //   61: getfield 108	com/google/android/gms/measurement/internal/zzbu:zzapg	Z
    //   64: ifeq +75 -> 139
    //   67: iload 7
    //   69: istore 9
    //   71: iload 9
    //   73: invokestatic 112	android/os/Process:setThreadPriority	(I)V
    //   76: aload 8
    //   78: invokevirtual 114	com/google/android/gms/measurement/internal/zzbu:run	()V
    //   81: goto -41 -> 40
    //   84: astore_2
    //   85: aload_0
    //   86: getfield 15	com/google/android/gms/measurement/internal/zzbv:zzape	Lcom/google/android/gms/measurement/internal/zzbr;
    //   89: invokestatic 118	com/google/android/gms/measurement/internal/zzbr:zzc	(Lcom/google/android/gms/measurement/internal/zzbr;)Ljava/lang/Object;
    //   92: astore_3
    //   93: aload_3
    //   94: monitorenter
    //   95: aload_0
    //   96: getfield 15	com/google/android/gms/measurement/internal/zzbv:zzape	Lcom/google/android/gms/measurement/internal/zzbr;
    //   99: invokestatic 79	com/google/android/gms/measurement/internal/zzbr:zza	(Lcom/google/android/gms/measurement/internal/zzbr;)Ljava/util/concurrent/Semaphore;
    //   102: invokevirtual 121	java/util/concurrent/Semaphore:release	()V
    //   105: aload_0
    //   106: getfield 15	com/google/android/gms/measurement/internal/zzbv:zzape	Lcom/google/android/gms/measurement/internal/zzbr;
    //   109: invokestatic 118	com/google/android/gms/measurement/internal/zzbr:zzc	(Lcom/google/android/gms/measurement/internal/zzbr;)Ljava/lang/Object;
    //   112: invokevirtual 124	java/lang/Object:notifyAll	()V
    //   115: aload_0
    //   116: aload_0
    //   117: getfield 15	com/google/android/gms/measurement/internal/zzbv:zzape	Lcom/google/android/gms/measurement/internal/zzbr;
    //   120: invokestatic 128	com/google/android/gms/measurement/internal/zzbr:zzd	(Lcom/google/android/gms/measurement/internal/zzbr;)Lcom/google/android/gms/measurement/internal/zzbv;
    //   123: if_acmpne +236 -> 359
    //   126: aload_0
    //   127: getfield 15	com/google/android/gms/measurement/internal/zzbv:zzape	Lcom/google/android/gms/measurement/internal/zzbr;
    //   130: aconst_null
    //   131: invokestatic 131	com/google/android/gms/measurement/internal/zzbr:zza	(Lcom/google/android/gms/measurement/internal/zzbr;Lcom/google/android/gms/measurement/internal/zzbv;)Lcom/google/android/gms/measurement/internal/zzbv;
    //   134: pop
    //   135: aload_3
    //   136: monitorexit
    //   137: aload_2
    //   138: athrow
    //   139: bipush 10
    //   141: istore 9
    //   143: goto -72 -> 71
    //   146: aload_0
    //   147: getfield 29	com/google/android/gms/measurement/internal/zzbv:zzaph	Ljava/lang/Object;
    //   150: astore 10
    //   152: aload 10
    //   154: monitorenter
    //   155: aload_0
    //   156: getfield 31	com/google/android/gms/measurement/internal/zzbv:zzapi	Ljava/util/concurrent/BlockingQueue;
    //   159: invokeinterface 134 1 0
    //   164: ifnonnull +27 -> 191
    //   167: aload_0
    //   168: getfield 15	com/google/android/gms/measurement/internal/zzbv:zzape	Lcom/google/android/gms/measurement/internal/zzbr;
    //   171: invokestatic 138	com/google/android/gms/measurement/internal/zzbr:zzb	(Lcom/google/android/gms/measurement/internal/zzbr;)Z
    //   174: istore 18
    //   176: iload 18
    //   178: ifne +13 -> 191
    //   181: aload_0
    //   182: getfield 29	com/google/android/gms/measurement/internal/zzbv:zzaph	Ljava/lang/Object;
    //   185: ldc2_w 139
    //   188: invokevirtual 144	java/lang/Object:wait	(J)V
    //   191: aload 10
    //   193: monitorexit
    //   194: aload_0
    //   195: getfield 15	com/google/android/gms/measurement/internal/zzbv:zzape	Lcom/google/android/gms/measurement/internal/zzbr;
    //   198: invokestatic 118	com/google/android/gms/measurement/internal/zzbr:zzc	(Lcom/google/android/gms/measurement/internal/zzbr;)Ljava/lang/Object;
    //   201: astore 12
    //   203: aload 12
    //   205: monitorenter
    //   206: aload_0
    //   207: getfield 31	com/google/android/gms/measurement/internal/zzbv:zzapi	Ljava/util/concurrent/BlockingQueue;
    //   210: invokeinterface 134 1 0
    //   215: ifnonnull +130 -> 345
    //   218: aload 12
    //   220: monitorexit
    //   221: aload_0
    //   222: getfield 15	com/google/android/gms/measurement/internal/zzbv:zzape	Lcom/google/android/gms/measurement/internal/zzbr;
    //   225: invokestatic 118	com/google/android/gms/measurement/internal/zzbr:zzc	(Lcom/google/android/gms/measurement/internal/zzbr;)Ljava/lang/Object;
    //   228: astore 14
    //   230: aload 14
    //   232: monitorenter
    //   233: aload_0
    //   234: getfield 15	com/google/android/gms/measurement/internal/zzbv:zzape	Lcom/google/android/gms/measurement/internal/zzbr;
    //   237: invokestatic 79	com/google/android/gms/measurement/internal/zzbr:zza	(Lcom/google/android/gms/measurement/internal/zzbr;)Ljava/util/concurrent/Semaphore;
    //   240: invokevirtual 121	java/util/concurrent/Semaphore:release	()V
    //   243: aload_0
    //   244: getfield 15	com/google/android/gms/measurement/internal/zzbv:zzape	Lcom/google/android/gms/measurement/internal/zzbr;
    //   247: invokestatic 118	com/google/android/gms/measurement/internal/zzbr:zzc	(Lcom/google/android/gms/measurement/internal/zzbr;)Ljava/lang/Object;
    //   250: invokevirtual 124	java/lang/Object:notifyAll	()V
    //   253: aload_0
    //   254: aload_0
    //   255: getfield 15	com/google/android/gms/measurement/internal/zzbv:zzape	Lcom/google/android/gms/measurement/internal/zzbr;
    //   258: invokestatic 128	com/google/android/gms/measurement/internal/zzbr:zzd	(Lcom/google/android/gms/measurement/internal/zzbr;)Lcom/google/android/gms/measurement/internal/zzbv;
    //   261: if_acmpne +35 -> 296
    //   264: aload_0
    //   265: getfield 15	com/google/android/gms/measurement/internal/zzbv:zzape	Lcom/google/android/gms/measurement/internal/zzbr;
    //   268: aconst_null
    //   269: invokestatic 131	com/google/android/gms/measurement/internal/zzbr:zza	(Lcom/google/android/gms/measurement/internal/zzbr;Lcom/google/android/gms/measurement/internal/zzbv;)Lcom/google/android/gms/measurement/internal/zzbv;
    //   272: pop
    //   273: aload 14
    //   275: monitorexit
    //   276: return
    //   277: astore 19
    //   279: aload_0
    //   280: aload 19
    //   282: invokespecial 86	com/google/android/gms/measurement/internal/zzbv:zza	(Ljava/lang/InterruptedException;)V
    //   285: goto -94 -> 191
    //   288: astore 11
    //   290: aload 10
    //   292: monitorexit
    //   293: aload 11
    //   295: athrow
    //   296: aload_0
    //   297: aload_0
    //   298: getfield 15	com/google/android/gms/measurement/internal/zzbv:zzape	Lcom/google/android/gms/measurement/internal/zzbr;
    //   301: invokestatic 147	com/google/android/gms/measurement/internal/zzbr:zze	(Lcom/google/android/gms/measurement/internal/zzbr;)Lcom/google/android/gms/measurement/internal/zzbv;
    //   304: if_acmpne +23 -> 327
    //   307: aload_0
    //   308: getfield 15	com/google/android/gms/measurement/internal/zzbv:zzape	Lcom/google/android/gms/measurement/internal/zzbr;
    //   311: aconst_null
    //   312: invokestatic 149	com/google/android/gms/measurement/internal/zzbr:zzb	(Lcom/google/android/gms/measurement/internal/zzbr;Lcom/google/android/gms/measurement/internal/zzbv;)Lcom/google/android/gms/measurement/internal/zzbv;
    //   315: pop
    //   316: goto -43 -> 273
    //   319: astore 15
    //   321: aload 14
    //   323: monitorexit
    //   324: aload 15
    //   326: athrow
    //   327: aload_0
    //   328: getfield 15	com/google/android/gms/measurement/internal/zzbv:zzape	Lcom/google/android/gms/measurement/internal/zzbr;
    //   331: invokevirtual 43	com/google/android/gms/measurement/internal/zzcr:zzgt	()Lcom/google/android/gms/measurement/internal/zzas;
    //   334: invokevirtual 152	com/google/android/gms/measurement/internal/zzas:zzjg	()Lcom/google/android/gms/measurement/internal/zzau;
    //   337: ldc 154
    //   339: invokevirtual 157	com/google/android/gms/measurement/internal/zzau:zzby	(Ljava/lang/String;)V
    //   342: goto -69 -> 273
    //   345: aload 12
    //   347: monitorexit
    //   348: goto -308 -> 40
    //   351: astore 13
    //   353: aload 12
    //   355: monitorexit
    //   356: aload 13
    //   358: athrow
    //   359: aload_0
    //   360: aload_0
    //   361: getfield 15	com/google/android/gms/measurement/internal/zzbv:zzape	Lcom/google/android/gms/measurement/internal/zzbr;
    //   364: invokestatic 147	com/google/android/gms/measurement/internal/zzbr:zze	(Lcom/google/android/gms/measurement/internal/zzbr;)Lcom/google/android/gms/measurement/internal/zzbv;
    //   367: if_acmpne +22 -> 389
    //   370: aload_0
    //   371: getfield 15	com/google/android/gms/measurement/internal/zzbv:zzape	Lcom/google/android/gms/measurement/internal/zzbr;
    //   374: aconst_null
    //   375: invokestatic 149	com/google/android/gms/measurement/internal/zzbr:zzb	(Lcom/google/android/gms/measurement/internal/zzbr;Lcom/google/android/gms/measurement/internal/zzbv;)Lcom/google/android/gms/measurement/internal/zzbv;
    //   378: pop
    //   379: goto -244 -> 135
    //   382: astore 4
    //   384: aload_3
    //   385: monitorexit
    //   386: aload 4
    //   388: athrow
    //   389: aload_0
    //   390: getfield 15	com/google/android/gms/measurement/internal/zzbv:zzape	Lcom/google/android/gms/measurement/internal/zzbr;
    //   393: invokevirtual 43	com/google/android/gms/measurement/internal/zzcr:zzgt	()Lcom/google/android/gms/measurement/internal/zzas;
    //   396: invokevirtual 152	com/google/android/gms/measurement/internal/zzas:zzjg	()Lcom/google/android/gms/measurement/internal/zzau;
    //   399: ldc 154
    //   401: invokevirtual 157	com/google/android/gms/measurement/internal/zzau:zzby	(Ljava/lang/String;)V
    //   404: goto -269 -> 135
    //
    // Exception table:
    //   from	to	target	type
    //   6	16	21	java/lang/InterruptedException
    //   32	40	84	finally
    //   40	54	84	finally
    //   59	67	84	finally
    //   71	81	84	finally
    //   146	155	84	finally
    //   194	206	84	finally
    //   293	296	84	finally
    //   356	359	84	finally
    //   181	191	277	java/lang/InterruptedException
    //   155	176	288	finally
    //   181	191	288	finally
    //   191	194	288	finally
    //   279	285	288	finally
    //   290	293	288	finally
    //   233	273	319	finally
    //   273	276	319	finally
    //   296	316	319	finally
    //   321	324	319	finally
    //   327	342	319	finally
    //   206	221	351	finally
    //   345	348	351	finally
    //   353	356	351	finally
    //   95	135	382	finally
    //   135	137	382	finally
    //   359	379	382	finally
    //   384	386	382	finally
    //   389	404	382	finally
  }

  public final void zzki()
  {
    synchronized (this.zzaph)
    {
      this.zzaph.notifyAll();
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzbv
 * JD-Core Version:    0.6.2
 */