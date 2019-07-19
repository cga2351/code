package com.google.android.gms.wearable.internal;

import android.net.Uri;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;

final class zzhj
  implements Runnable
{
  zzhj(zzhg paramzzhg, Uri paramUri, BaseImplementation.ResultHolder paramResultHolder, String paramString, long paramLong1, long paramLong2)
  {
  }

  // ERROR //
  public final void run()
  {
    // Byte code:
    //   0: ldc 43
    //   2: iconst_2
    //   3: invokestatic 49	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   6: ifeq +11 -> 17
    //   9: ldc 43
    //   11: ldc 51
    //   13: invokestatic 55	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   16: pop
    //   17: ldc 57
    //   19: aload_0
    //   20: getfield 23	com/google/android/gms/wearable/internal/zzhj:zzco	Landroid/net/Uri;
    //   23: invokevirtual 63	android/net/Uri:getScheme	()Ljava/lang/String;
    //   26: invokevirtual 69	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   29: ifne +32 -> 61
    //   32: ldc 43
    //   34: ldc 71
    //   36: invokestatic 74	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   39: pop
    //   40: aload_0
    //   41: getfield 25	com/google/android/gms/wearable/internal/zzhj:zzfh	Lcom/google/android/gms/common/api/internal/BaseImplementation$ResultHolder;
    //   44: new 76	com/google/android/gms/common/api/Status
    //   47: dup
    //   48: bipush 10
    //   50: ldc 71
    //   52: invokespecial 79	com/google/android/gms/common/api/Status:<init>	(ILjava/lang/String;)V
    //   55: invokeinterface 85 2 0
    //   60: return
    //   61: new 87	java/io/File
    //   64: dup
    //   65: aload_0
    //   66: getfield 23	com/google/android/gms/wearable/internal/zzhj:zzco	Landroid/net/Uri;
    //   69: invokevirtual 90	android/net/Uri:getPath	()Ljava/lang/String;
    //   72: invokespecial 93	java/io/File:<init>	(Ljava/lang/String;)V
    //   75: astore_1
    //   76: aload_1
    //   77: ldc 94
    //   79: invokestatic 100	android/os/ParcelFileDescriptor:open	(Ljava/io/File;I)Landroid/os/ParcelFileDescriptor;
    //   82: astore 5
    //   84: aload_0
    //   85: getfield 21	com/google/android/gms/wearable/internal/zzhj:zzfi	Lcom/google/android/gms/wearable/internal/zzhg;
    //   88: invokevirtual 106	com/google/android/gms/wearable/internal/zzhg:getService	()Landroid/os/IInterface;
    //   91: checkcast 108	com/google/android/gms/wearable/internal/zzep
    //   94: new 110	com/google/android/gms/wearable/internal/zzhc
    //   97: dup
    //   98: aload_0
    //   99: getfield 25	com/google/android/gms/wearable/internal/zzhj:zzfh	Lcom/google/android/gms/common/api/internal/BaseImplementation$ResultHolder;
    //   102: invokespecial 113	com/google/android/gms/wearable/internal/zzhc:<init>	(Lcom/google/android/gms/common/api/internal/BaseImplementation$ResultHolder;)V
    //   105: aload_0
    //   106: getfield 27	com/google/android/gms/wearable/internal/zzhj:zzcs	Ljava/lang/String;
    //   109: aload 5
    //   111: aload_0
    //   112: getfield 29	com/google/android/gms/wearable/internal/zzhj:zzcq	J
    //   115: aload_0
    //   116: getfield 31	com/google/android/gms/wearable/internal/zzhj:zzcr	J
    //   119: invokeinterface 117 8 0
    //   124: aload 5
    //   126: invokevirtual 120	android/os/ParcelFileDescriptor:close	()V
    //   129: return
    //   130: astore 13
    //   132: ldc 43
    //   134: ldc 122
    //   136: aload 13
    //   138: invokestatic 125	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   141: pop
    //   142: return
    //   143: astore_2
    //   144: aload_1
    //   145: invokestatic 129	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   148: astore_3
    //   149: ldc 43
    //   151: new 131	java/lang/StringBuilder
    //   154: dup
    //   155: bipush 46
    //   157: aload_3
    //   158: invokestatic 129	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   161: invokevirtual 135	java/lang/String:length	()I
    //   164: iadd
    //   165: invokespecial 138	java/lang/StringBuilder:<init>	(I)V
    //   168: ldc 140
    //   170: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: aload_3
    //   174: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 74	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   183: pop
    //   184: aload_0
    //   185: getfield 25	com/google/android/gms/wearable/internal/zzhj:zzfh	Lcom/google/android/gms/common/api/internal/BaseImplementation$ResultHolder;
    //   188: new 76	com/google/android/gms/common/api/Status
    //   191: dup
    //   192: bipush 13
    //   194: invokespecial 148	com/google/android/gms/common/api/Status:<init>	(I)V
    //   197: invokeinterface 85 2 0
    //   202: return
    //   203: astore 9
    //   205: ldc 43
    //   207: ldc 150
    //   209: aload 9
    //   211: invokestatic 125	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   214: pop
    //   215: aload_0
    //   216: getfield 25	com/google/android/gms/wearable/internal/zzhj:zzfh	Lcom/google/android/gms/common/api/internal/BaseImplementation$ResultHolder;
    //   219: new 76	com/google/android/gms/common/api/Status
    //   222: dup
    //   223: bipush 8
    //   225: invokespecial 148	com/google/android/gms/common/api/Status:<init>	(I)V
    //   228: invokeinterface 85 2 0
    //   233: aload 5
    //   235: invokevirtual 120	android/os/ParcelFileDescriptor:close	()V
    //   238: return
    //   239: astore 11
    //   241: ldc 43
    //   243: ldc 122
    //   245: aload 11
    //   247: invokestatic 125	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   250: pop
    //   251: return
    //   252: astore 6
    //   254: aload 5
    //   256: invokevirtual 120	android/os/ParcelFileDescriptor:close	()V
    //   259: aload 6
    //   261: athrow
    //   262: astore 7
    //   264: ldc 43
    //   266: ldc 122
    //   268: aload 7
    //   270: invokestatic 125	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   273: pop
    //   274: goto -15 -> 259
    //
    // Exception table:
    //   from	to	target	type
    //   124	129	130	java/io/IOException
    //   76	84	143	java/io/FileNotFoundException
    //   84	124	203	android/os/RemoteException
    //   233	238	239	java/io/IOException
    //   84	124	252	finally
    //   205	233	252	finally
    //   254	259	262	java/io/IOException
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzhj
 * JD-Core Version:    0.6.2
 */