package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;

final class zztf extends HandlerThread
  implements SurfaceTexture.OnFrameAvailableListener, Handler.Callback
{
  private Handler handler;
  private final int[] zzbny = new int[1];
  private SurfaceTexture zzbnz;
  private Error zzboa;
  private RuntimeException zzbob;
  private zztd zzboc;

  public zztf()
  {
    super("dummySurface");
  }

  // ERROR //
  public final boolean handleMessage(Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 43	android/os/Message:what	I
    //   4: tableswitch	default:+28 -> 32, 1:+30->34, 2:+654->658, 3:+663->667
    //   33: ireturn
    //   34: aload_1
    //   35: getfield 46	android/os/Message:arg1	I
    //   38: ifeq +443 -> 481
    //   41: iconst_1
    //   42: istore 17
    //   44: iconst_0
    //   45: invokestatic 52	android/opengl/EGL14:eglGetDisplay	(I)Landroid/opengl/EGLDisplay;
    //   48: astore 18
    //   50: aload 18
    //   52: ifnull +435 -> 487
    //   55: iconst_1
    //   56: istore 19
    //   58: iload 19
    //   60: ldc 54
    //   62: invokestatic 60	com/google/android/gms/internal/ads/zzsk:checkState	(ZLjava/lang/Object;)V
    //   65: iconst_2
    //   66: newarray int
    //   68: astore 20
    //   70: aload 18
    //   72: aload 20
    //   74: iconst_0
    //   75: aload 20
    //   77: iconst_1
    //   78: invokestatic 64	android/opengl/EGL14:eglInitialize	(Landroid/opengl/EGLDisplay;[II[II)Z
    //   81: ldc 66
    //   83: invokestatic 60	com/google/android/gms/internal/ads/zzsk:checkState	(ZLjava/lang/Object;)V
    //   86: bipush 17
    //   88: newarray int
    //   90: dup
    //   91: iconst_0
    //   92: sipush 12352
    //   95: iastore
    //   96: dup
    //   97: iconst_1
    //   98: iconst_4
    //   99: iastore
    //   100: dup
    //   101: iconst_2
    //   102: sipush 12324
    //   105: iastore
    //   106: dup
    //   107: iconst_3
    //   108: bipush 8
    //   110: iastore
    //   111: dup
    //   112: iconst_4
    //   113: sipush 12323
    //   116: iastore
    //   117: dup
    //   118: iconst_5
    //   119: bipush 8
    //   121: iastore
    //   122: dup
    //   123: bipush 6
    //   125: sipush 12322
    //   128: iastore
    //   129: dup
    //   130: bipush 7
    //   132: bipush 8
    //   134: iastore
    //   135: dup
    //   136: bipush 8
    //   138: sipush 12321
    //   141: iastore
    //   142: dup
    //   143: bipush 9
    //   145: bipush 8
    //   147: iastore
    //   148: dup
    //   149: bipush 10
    //   151: sipush 12325
    //   154: iastore
    //   155: dup
    //   156: bipush 11
    //   158: iconst_0
    //   159: iastore
    //   160: dup
    //   161: bipush 12
    //   163: sipush 12327
    //   166: iastore
    //   167: dup
    //   168: bipush 13
    //   170: sipush 12344
    //   173: iastore
    //   174: dup
    //   175: bipush 14
    //   177: sipush 12339
    //   180: iastore
    //   181: dup
    //   182: bipush 15
    //   184: iconst_4
    //   185: iastore
    //   186: dup
    //   187: bipush 16
    //   189: sipush 12344
    //   192: iastore
    //   193: astore 21
    //   195: iconst_1
    //   196: anewarray 68	android/opengl/EGLConfig
    //   199: astore 22
    //   201: iconst_1
    //   202: newarray int
    //   204: astore 23
    //   206: aload 18
    //   208: aload 21
    //   210: iconst_0
    //   211: aload 22
    //   213: iconst_0
    //   214: iconst_1
    //   215: aload 23
    //   217: iconst_0
    //   218: invokestatic 72	android/opengl/EGL14:eglChooseConfig	(Landroid/opengl/EGLDisplay;[II[Landroid/opengl/EGLConfig;II[II)Z
    //   221: ifeq +272 -> 493
    //   224: aload 23
    //   226: iconst_0
    //   227: iaload
    //   228: ifle +265 -> 493
    //   231: aload 22
    //   233: iconst_0
    //   234: aaload
    //   235: ifnull +258 -> 493
    //   238: iconst_1
    //   239: istore 24
    //   241: iload 24
    //   243: ldc 74
    //   245: invokestatic 60	com/google/android/gms/internal/ads/zzsk:checkState	(ZLjava/lang/Object;)V
    //   248: aload 22
    //   250: iconst_0
    //   251: aaload
    //   252: astore 25
    //   254: iload 17
    //   256: ifeq +243 -> 499
    //   259: iconst_5
    //   260: newarray int
    //   262: dup
    //   263: iconst_0
    //   264: sipush 12440
    //   267: iastore
    //   268: dup
    //   269: iconst_1
    //   270: iconst_2
    //   271: iastore
    //   272: dup
    //   273: iconst_2
    //   274: sipush 12992
    //   277: iastore
    //   278: dup
    //   279: iconst_3
    //   280: iconst_1
    //   281: iastore
    //   282: dup
    //   283: iconst_4
    //   284: sipush 12344
    //   287: iastore
    //   288: astore 26
    //   290: aload 18
    //   292: aload 25
    //   294: getstatic 78	android/opengl/EGL14:EGL_NO_CONTEXT	Landroid/opengl/EGLContext;
    //   297: aload 26
    //   299: iconst_0
    //   300: invokestatic 82	android/opengl/EGL14:eglCreateContext	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLConfig;Landroid/opengl/EGLContext;[II)Landroid/opengl/EGLContext;
    //   303: astore 27
    //   305: aload 27
    //   307: ifnull +442 -> 749
    //   310: iconst_1
    //   311: istore 28
    //   313: iload 28
    //   315: ldc 84
    //   317: invokestatic 60	com/google/android/gms/internal/ads/zzsk:checkState	(ZLjava/lang/Object;)V
    //   320: iload 17
    //   322: ifeq +201 -> 523
    //   325: bipush 7
    //   327: newarray int
    //   329: dup
    //   330: iconst_0
    //   331: sipush 12375
    //   334: iastore
    //   335: dup
    //   336: iconst_1
    //   337: iconst_1
    //   338: iastore
    //   339: dup
    //   340: iconst_2
    //   341: sipush 12374
    //   344: iastore
    //   345: dup
    //   346: iconst_3
    //   347: iconst_1
    //   348: iastore
    //   349: dup
    //   350: iconst_4
    //   351: sipush 12992
    //   354: iastore
    //   355: dup
    //   356: iconst_5
    //   357: iconst_1
    //   358: iastore
    //   359: dup
    //   360: bipush 6
    //   362: sipush 12344
    //   365: iastore
    //   366: astore 29
    //   368: aload 18
    //   370: aload 25
    //   372: aload 29
    //   374: iconst_0
    //   375: invokestatic 88	android/opengl/EGL14:eglCreatePbufferSurface	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLConfig;[II)Landroid/opengl/EGLSurface;
    //   378: astore 30
    //   380: aload 30
    //   382: ifnull +180 -> 562
    //   385: iconst_1
    //   386: istore 31
    //   388: iload 31
    //   390: ldc 90
    //   392: invokestatic 60	com/google/android/gms/internal/ads/zzsk:checkState	(ZLjava/lang/Object;)V
    //   395: aload 18
    //   397: aload 30
    //   399: aload 30
    //   401: aload 27
    //   403: invokestatic 94	android/opengl/EGL14:eglMakeCurrent	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;Landroid/opengl/EGLSurface;Landroid/opengl/EGLContext;)Z
    //   406: ldc 96
    //   408: invokestatic 60	com/google/android/gms/internal/ads/zzsk:checkState	(ZLjava/lang/Object;)V
    //   411: iconst_1
    //   412: aload_0
    //   413: getfield 29	com/google/android/gms/internal/ads/zztf:zzbny	[I
    //   416: iconst_0
    //   417: invokestatic 102	android/opengl/GLES20:glGenTextures	(I[II)V
    //   420: aload_0
    //   421: new 104	android/graphics/SurfaceTexture
    //   424: dup
    //   425: aload_0
    //   426: getfield 29	com/google/android/gms/internal/ads/zztf:zzbny	[I
    //   429: iconst_0
    //   430: iaload
    //   431: invokespecial 107	android/graphics/SurfaceTexture:<init>	(I)V
    //   434: putfield 109	com/google/android/gms/internal/ads/zztf:zzbnz	Landroid/graphics/SurfaceTexture;
    //   437: aload_0
    //   438: getfield 109	com/google/android/gms/internal/ads/zztf:zzbnz	Landroid/graphics/SurfaceTexture;
    //   441: aload_0
    //   442: invokevirtual 113	android/graphics/SurfaceTexture:setOnFrameAvailableListener	(Landroid/graphics/SurfaceTexture$OnFrameAvailableListener;)V
    //   445: aload_0
    //   446: new 115	com/google/android/gms/internal/ads/zztd
    //   449: dup
    //   450: aload_0
    //   451: aload_0
    //   452: getfield 109	com/google/android/gms/internal/ads/zztf:zzbnz	Landroid/graphics/SurfaceTexture;
    //   455: iload 17
    //   457: aconst_null
    //   458: invokespecial 118	com/google/android/gms/internal/ads/zztd:<init>	(Lcom/google/android/gms/internal/ads/zztf;Landroid/graphics/SurfaceTexture;ZLcom/google/android/gms/internal/ads/zzte;)V
    //   461: putfield 120	com/google/android/gms/internal/ads/zztf:zzboc	Lcom/google/android/gms/internal/ads/zztd;
    //   464: aload_0
    //   465: monitorenter
    //   466: aload_0
    //   467: invokevirtual 125	java/lang/Object:notify	()V
    //   470: aload_0
    //   471: monitorexit
    //   472: iconst_1
    //   473: ireturn
    //   474: astore 32
    //   476: aload_0
    //   477: monitorexit
    //   478: aload 32
    //   480: athrow
    //   481: iconst_0
    //   482: istore 17
    //   484: goto -440 -> 44
    //   487: iconst_0
    //   488: istore 19
    //   490: goto -432 -> 58
    //   493: iconst_0
    //   494: istore 24
    //   496: goto -255 -> 241
    //   499: iconst_3
    //   500: newarray int
    //   502: dup
    //   503: iconst_0
    //   504: sipush 12440
    //   507: iastore
    //   508: dup
    //   509: iconst_1
    //   510: iconst_2
    //   511: iastore
    //   512: dup
    //   513: iconst_2
    //   514: sipush 12344
    //   517: iastore
    //   518: astore 26
    //   520: goto -230 -> 290
    //   523: iconst_5
    //   524: newarray int
    //   526: astore 29
    //   528: aload 29
    //   530: iconst_0
    //   531: sipush 12375
    //   534: iastore
    //   535: aload 29
    //   537: iconst_1
    //   538: iconst_1
    //   539: iastore
    //   540: aload 29
    //   542: iconst_2
    //   543: sipush 12374
    //   546: iastore
    //   547: aload 29
    //   549: iconst_3
    //   550: iconst_1
    //   551: iastore
    //   552: aload 29
    //   554: iconst_4
    //   555: sipush 12344
    //   558: iastore
    //   559: goto -191 -> 368
    //   562: iconst_0
    //   563: istore 31
    //   565: goto -177 -> 388
    //   568: astore 14
    //   570: ldc 127
    //   572: ldc 129
    //   574: aload 14
    //   576: invokestatic 135	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   579: pop
    //   580: aload_0
    //   581: aload 14
    //   583: putfield 137	com/google/android/gms/internal/ads/zztf:zzbob	Ljava/lang/RuntimeException;
    //   586: aload_0
    //   587: monitorenter
    //   588: aload_0
    //   589: invokevirtual 125	java/lang/Object:notify	()V
    //   592: aload_0
    //   593: monitorexit
    //   594: iconst_1
    //   595: ireturn
    //   596: astore 16
    //   598: aload_0
    //   599: monitorexit
    //   600: aload 16
    //   602: athrow
    //   603: astore 11
    //   605: ldc 127
    //   607: ldc 129
    //   609: aload 11
    //   611: invokestatic 135	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   614: pop
    //   615: aload_0
    //   616: aload 11
    //   618: putfield 139	com/google/android/gms/internal/ads/zztf:zzboa	Ljava/lang/Error;
    //   621: aload_0
    //   622: monitorenter
    //   623: aload_0
    //   624: invokevirtual 125	java/lang/Object:notify	()V
    //   627: aload_0
    //   628: monitorexit
    //   629: iconst_1
    //   630: ireturn
    //   631: astore 13
    //   633: aload_0
    //   634: monitorexit
    //   635: aload 13
    //   637: athrow
    //   638: astore 9
    //   640: aload_0
    //   641: monitorenter
    //   642: aload_0
    //   643: invokevirtual 125	java/lang/Object:notify	()V
    //   646: aload_0
    //   647: monitorexit
    //   648: aload 9
    //   650: athrow
    //   651: astore 10
    //   653: aload_0
    //   654: monitorexit
    //   655: aload 10
    //   657: athrow
    //   658: aload_0
    //   659: getfield 109	com/google/android/gms/internal/ads/zztf:zzbnz	Landroid/graphics/SurfaceTexture;
    //   662: invokevirtual 142	android/graphics/SurfaceTexture:updateTexImage	()V
    //   665: iconst_1
    //   666: ireturn
    //   667: aload_0
    //   668: getfield 109	com/google/android/gms/internal/ads/zztf:zzbnz	Landroid/graphics/SurfaceTexture;
    //   671: invokevirtual 145	android/graphics/SurfaceTexture:release	()V
    //   674: aload_0
    //   675: aconst_null
    //   676: putfield 120	com/google/android/gms/internal/ads/zztf:zzboc	Lcom/google/android/gms/internal/ads/zztd;
    //   679: aload_0
    //   680: aconst_null
    //   681: putfield 109	com/google/android/gms/internal/ads/zztf:zzbnz	Landroid/graphics/SurfaceTexture;
    //   684: iconst_1
    //   685: aload_0
    //   686: getfield 29	com/google/android/gms/internal/ads/zztf:zzbny	[I
    //   689: iconst_0
    //   690: invokestatic 148	android/opengl/GLES20:glDeleteTextures	(I[II)V
    //   693: aload_0
    //   694: invokevirtual 152	com/google/android/gms/internal/ads/zztf:quit	()Z
    //   697: pop
    //   698: iconst_1
    //   699: ireturn
    //   700: astore_2
    //   701: aload_0
    //   702: aconst_null
    //   703: putfield 120	com/google/android/gms/internal/ads/zztf:zzboc	Lcom/google/android/gms/internal/ads/zztd;
    //   706: aload_0
    //   707: aconst_null
    //   708: putfield 109	com/google/android/gms/internal/ads/zztf:zzbnz	Landroid/graphics/SurfaceTexture;
    //   711: iconst_1
    //   712: aload_0
    //   713: getfield 29	com/google/android/gms/internal/ads/zztf:zzbny	[I
    //   716: iconst_0
    //   717: invokestatic 148	android/opengl/GLES20:glDeleteTextures	(I[II)V
    //   720: aload_2
    //   721: athrow
    //   722: astore 5
    //   724: ldc 127
    //   726: ldc 154
    //   728: aload 5
    //   730: invokestatic 135	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   733: pop
    //   734: aload_0
    //   735: invokevirtual 152	com/google/android/gms/internal/ads/zztf:quit	()Z
    //   738: pop
    //   739: iconst_1
    //   740: ireturn
    //   741: astore_3
    //   742: aload_0
    //   743: invokevirtual 152	com/google/android/gms/internal/ads/zztf:quit	()Z
    //   746: pop
    //   747: aload_3
    //   748: athrow
    //   749: iconst_0
    //   750: istore 28
    //   752: goto -439 -> 313
    //
    // Exception table:
    //   from	to	target	type
    //   466	472	474	finally
    //   476	478	474	finally
    //   34	41	568	java/lang/RuntimeException
    //   44	50	568	java/lang/RuntimeException
    //   58	238	568	java/lang/RuntimeException
    //   241	254	568	java/lang/RuntimeException
    //   259	290	568	java/lang/RuntimeException
    //   290	305	568	java/lang/RuntimeException
    //   313	320	568	java/lang/RuntimeException
    //   325	368	568	java/lang/RuntimeException
    //   368	380	568	java/lang/RuntimeException
    //   388	464	568	java/lang/RuntimeException
    //   499	520	568	java/lang/RuntimeException
    //   523	528	568	java/lang/RuntimeException
    //   588	594	596	finally
    //   598	600	596	finally
    //   34	41	603	java/lang/Error
    //   44	50	603	java/lang/Error
    //   58	238	603	java/lang/Error
    //   241	254	603	java/lang/Error
    //   259	290	603	java/lang/Error
    //   290	305	603	java/lang/Error
    //   313	320	603	java/lang/Error
    //   325	368	603	java/lang/Error
    //   368	380	603	java/lang/Error
    //   388	464	603	java/lang/Error
    //   499	520	603	java/lang/Error
    //   523	528	603	java/lang/Error
    //   623	629	631	finally
    //   633	635	631	finally
    //   34	41	638	finally
    //   44	50	638	finally
    //   58	238	638	finally
    //   241	254	638	finally
    //   259	290	638	finally
    //   290	305	638	finally
    //   313	320	638	finally
    //   325	368	638	finally
    //   368	380	638	finally
    //   388	464	638	finally
    //   499	520	638	finally
    //   523	528	638	finally
    //   570	586	638	finally
    //   605	621	638	finally
    //   642	648	651	finally
    //   653	655	651	finally
    //   667	674	700	finally
    //   674	693	722	java/lang/Throwable
    //   701	722	722	java/lang/Throwable
    //   674	693	741	finally
    //   701	722	741	finally
    //   724	734	741	finally
  }

  public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    this.handler.sendEmptyMessage(2);
  }

  public final void release()
  {
    this.handler.sendEmptyMessage(3);
  }

  public final zztd zzm(boolean paramBoolean)
  {
    int i = 0;
    start();
    this.handler = new Handler(getLooper(), this);
    try
    {
      Handler localHandler = this.handler;
      if (paramBoolean);
      for (int j = 1; ; j = 0)
      {
        localHandler.obtainMessage(1, j, 0).sendToTarget();
        while ((this.zzboc == null) && (this.zzbob == null))
        {
          Error localError = this.zzboa;
          if (localError != null)
            break;
          try
          {
            wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            i = 1;
          }
        }
      }
      if (i != 0)
        Thread.currentThread().interrupt();
      if (this.zzbob != null)
        throw this.zzbob;
    }
    finally
    {
    }
    if (this.zzboa != null)
      throw this.zzboa;
    return this.zzboc;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zztf
 * JD-Core Version:    0.6.2
 */