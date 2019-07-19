package com.google.android.gms.wearable.internal;

import android.net.Uri;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;

final class zzhi
  implements Runnable
{
  zzhi(zzhg paramzzhg, Uri paramUri, BaseImplementation.ResultHolder paramResultHolder, boolean paramBoolean, String paramString)
  {
  }

  // ERROR //
  public final void run()
  {
    // Byte code:
    //   0: ldc 40
    //   2: iconst_2
    //   3: invokestatic 46	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   6: ifeq +11 -> 17
    //   9: ldc 40
    //   11: ldc 48
    //   13: invokestatic 52	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   16: pop
    //   17: ldc 54
    //   19: aload_0
    //   20: getfield 22	com/google/android/gms/wearable/internal/zzhi:zzco	Landroid/net/Uri;
    //   23: invokevirtual 60	android/net/Uri:getScheme	()Ljava/lang/String;
    //   26: invokevirtual 66	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   29: ifne +32 -> 61
    //   32: ldc 40
    //   34: ldc 68
    //   36: invokestatic 71	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   39: pop
    //   40: aload_0
    //   41: getfield 24	com/google/android/gms/wearable/internal/zzhi:zzfh	Lcom/google/android/gms/common/api/internal/BaseImplementation$ResultHolder;
    //   44: new 73	com/google/android/gms/common/api/Status
    //   47: dup
    //   48: bipush 10
    //   50: ldc 68
    //   52: invokespecial 76	com/google/android/gms/common/api/Status:<init>	(ILjava/lang/String;)V
    //   55: invokeinterface 82 2 0
    //   60: return
    //   61: new 84	java/io/File
    //   64: dup
    //   65: aload_0
    //   66: getfield 22	com/google/android/gms/wearable/internal/zzhi:zzco	Landroid/net/Uri;
    //   69: invokevirtual 87	android/net/Uri:getPath	()Ljava/lang/String;
    //   72: invokespecial 90	java/io/File:<init>	(Ljava/lang/String;)V
    //   75: astore_1
    //   76: aload_0
    //   77: getfield 26	com/google/android/gms/wearable/internal/zzhi:zzcp	Z
    //   80: ifeq +69 -> 149
    //   83: ldc 91
    //   85: istore_2
    //   86: iload_2
    //   87: ldc 92
    //   89: ior
    //   90: istore_3
    //   91: aload_1
    //   92: iload_3
    //   93: invokestatic 98	android/os/ParcelFileDescriptor:open	(Ljava/io/File;I)Landroid/os/ParcelFileDescriptor;
    //   96: astore 7
    //   98: aload_0
    //   99: getfield 20	com/google/android/gms/wearable/internal/zzhi:zzfi	Lcom/google/android/gms/wearable/internal/zzhg;
    //   102: invokevirtual 104	com/google/android/gms/wearable/internal/zzhg:getService	()Landroid/os/IInterface;
    //   105: checkcast 106	com/google/android/gms/wearable/internal/zzep
    //   108: new 108	com/google/android/gms/wearable/internal/zzhf
    //   111: dup
    //   112: aload_0
    //   113: getfield 24	com/google/android/gms/wearable/internal/zzhi:zzfh	Lcom/google/android/gms/common/api/internal/BaseImplementation$ResultHolder;
    //   116: invokespecial 111	com/google/android/gms/wearable/internal/zzhf:<init>	(Lcom/google/android/gms/common/api/internal/BaseImplementation$ResultHolder;)V
    //   119: aload_0
    //   120: getfield 28	com/google/android/gms/wearable/internal/zzhi:zzcs	Ljava/lang/String;
    //   123: aload 7
    //   125: invokeinterface 115 4 0
    //   130: aload 7
    //   132: invokevirtual 118	android/os/ParcelFileDescriptor:close	()V
    //   135: return
    //   136: astore 15
    //   138: ldc 40
    //   140: ldc 120
    //   142: aload 15
    //   144: invokestatic 123	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   147: pop
    //   148: return
    //   149: iconst_0
    //   150: istore_2
    //   151: goto -65 -> 86
    //   154: astore 4
    //   156: aload_1
    //   157: invokestatic 127	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   160: astore 5
    //   162: ldc 40
    //   164: new 129	java/lang/StringBuilder
    //   167: dup
    //   168: bipush 49
    //   170: aload 5
    //   172: invokestatic 127	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   175: invokevirtual 133	java/lang/String:length	()I
    //   178: iadd
    //   179: invokespecial 136	java/lang/StringBuilder:<init>	(I)V
    //   182: ldc 138
    //   184: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload 5
    //   189: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 71	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   198: pop
    //   199: aload_0
    //   200: getfield 24	com/google/android/gms/wearable/internal/zzhi:zzfh	Lcom/google/android/gms/common/api/internal/BaseImplementation$ResultHolder;
    //   203: new 73	com/google/android/gms/common/api/Status
    //   206: dup
    //   207: bipush 13
    //   209: invokespecial 146	com/google/android/gms/common/api/Status:<init>	(I)V
    //   212: invokeinterface 82 2 0
    //   217: return
    //   218: astore 11
    //   220: ldc 40
    //   222: ldc 148
    //   224: aload 11
    //   226: invokestatic 123	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   229: pop
    //   230: aload_0
    //   231: getfield 24	com/google/android/gms/wearable/internal/zzhi:zzfh	Lcom/google/android/gms/common/api/internal/BaseImplementation$ResultHolder;
    //   234: new 73	com/google/android/gms/common/api/Status
    //   237: dup
    //   238: bipush 8
    //   240: invokespecial 146	com/google/android/gms/common/api/Status:<init>	(I)V
    //   243: invokeinterface 82 2 0
    //   248: aload 7
    //   250: invokevirtual 118	android/os/ParcelFileDescriptor:close	()V
    //   253: return
    //   254: astore 13
    //   256: ldc 40
    //   258: ldc 120
    //   260: aload 13
    //   262: invokestatic 123	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   265: pop
    //   266: return
    //   267: astore 8
    //   269: aload 7
    //   271: invokevirtual 118	android/os/ParcelFileDescriptor:close	()V
    //   274: aload 8
    //   276: athrow
    //   277: astore 9
    //   279: ldc 40
    //   281: ldc 120
    //   283: aload 9
    //   285: invokestatic 123	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   288: pop
    //   289: goto -15 -> 274
    //
    // Exception table:
    //   from	to	target	type
    //   130	135	136	java/io/IOException
    //   91	98	154	java/io/FileNotFoundException
    //   98	130	218	android/os/RemoteException
    //   248	253	254	java/io/IOException
    //   98	130	267	finally
    //   220	248	267	finally
    //   269	274	277	java/io/IOException
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzhi
 * JD-Core Version:    0.6.2
 */