package com.google.firebase.messaging;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_messaging.zzk;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.io.Closeable;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executor;

final class h
  implements Closeable
{
  private final URL a;
  private Task<Bitmap> b;
  private volatile InputStream c;

  private h(URL paramURL)
  {
    this.a = paramURL;
  }

  public static h a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    String str1;
    try
    {
      h localh = new h(new URL(paramString));
      return localh;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      str1 = String.valueOf(paramString);
      if (str1.length() == 0);
    }
    for (String str2 = "Not downloading image, bad URL: ".concat(str1); ; str2 = new String("Not downloading image, bad URL: "))
    {
      Log.w("FirebaseMessaging", str2);
      return null;
    }
  }

  public final Task<Bitmap> a()
  {
    return (Task)Preconditions.checkNotNull(this.b);
  }

  public final void a(Executor paramExecutor)
  {
    this.b = Tasks.call(paramExecutor, new g(this));
  }

  // ERROR //
  public final Bitmap b()
    throws java.io.IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 20	com/google/firebase/messaging/h:a	Ljava/net/URL;
    //   4: invokestatic 42	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   7: astore_1
    //   8: ldc 54
    //   10: new 103	java/lang/StringBuilder
    //   13: dup
    //   14: bipush 22
    //   16: aload_1
    //   17: invokestatic 42	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   20: invokevirtual 46	java/lang/String:length	()I
    //   23: iadd
    //   24: invokespecial 106	java/lang/StringBuilder:<init>	(I)V
    //   27: ldc 108
    //   29: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_1
    //   33: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 119	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   42: pop
    //   43: aload_0
    //   44: getfield 20	com/google/firebase/messaging/h:a	Ljava/net/URL;
    //   47: invokevirtual 123	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   50: invokevirtual 129	java/net/URLConnection:getInputStream	()Ljava/io/InputStream;
    //   53: astore 6
    //   55: aload 6
    //   57: ldc2_w 130
    //   60: invokestatic 136	com/google/android/gms/internal/firebase_messaging/zzj:zza	(Ljava/io/InputStream;J)Ljava/io/InputStream;
    //   63: astore 11
    //   65: aload_0
    //   66: aload 6
    //   68: putfield 138	com/google/firebase/messaging/h:c	Ljava/io/InputStream;
    //   71: aload 11
    //   73: invokestatic 144	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   76: astore 16
    //   78: aload 16
    //   80: ifnonnull +167 -> 247
    //   83: aload_0
    //   84: getfield 20	com/google/firebase/messaging/h:a	Ljava/net/URL;
    //   87: invokestatic 42	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   90: astore 17
    //   92: new 103	java/lang/StringBuilder
    //   95: dup
    //   96: bipush 24
    //   98: aload 17
    //   100: invokestatic 42	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   103: invokevirtual 46	java/lang/String:length	()I
    //   106: iadd
    //   107: invokespecial 106	java/lang/StringBuilder:<init>	(I)V
    //   110: ldc 146
    //   112: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload 17
    //   117: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: astore 18
    //   125: ldc 54
    //   127: aload 18
    //   129: invokestatic 60	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   132: pop
    //   133: new 101	java/io/IOException
    //   136: dup
    //   137: aload 18
    //   139: invokespecial 147	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   142: athrow
    //   143: astore 14
    //   145: aload 14
    //   147: athrow
    //   148: astore 15
    //   150: aload 14
    //   152: astore 13
    //   154: aload 15
    //   156: astore 12
    //   158: aload 13
    //   160: aload 11
    //   162: invokestatic 149	com/google/firebase/messaging/h:a	(Ljava/lang/Throwable;Ljava/io/InputStream;)V
    //   165: aload 12
    //   167: athrow
    //   168: astore 9
    //   170: aload 9
    //   172: athrow
    //   173: astore 10
    //   175: aload 9
    //   177: astore 8
    //   179: aload 10
    //   181: astore 7
    //   183: aload 6
    //   185: ifnull +10 -> 195
    //   188: aload 8
    //   190: aload 6
    //   192: invokestatic 149	com/google/firebase/messaging/h:a	(Ljava/lang/Throwable;Ljava/io/InputStream;)V
    //   195: aload 7
    //   197: athrow
    //   198: astore_3
    //   199: aload_0
    //   200: getfield 20	com/google/firebase/messaging/h:a	Ljava/net/URL;
    //   203: invokestatic 42	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   206: astore 4
    //   208: ldc 54
    //   210: new 103	java/lang/StringBuilder
    //   213: dup
    //   214: bipush 26
    //   216: aload 4
    //   218: invokestatic 42	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   221: invokevirtual 46	java/lang/String:length	()I
    //   224: iadd
    //   225: invokespecial 106	java/lang/StringBuilder:<init>	(I)V
    //   228: ldc 151
    //   230: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload 4
    //   235: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 60	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   244: pop
    //   245: aload_3
    //   246: athrow
    //   247: ldc 54
    //   249: iconst_3
    //   250: invokestatic 155	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   253: ifeq +49 -> 302
    //   256: aload_0
    //   257: getfield 20	com/google/firebase/messaging/h:a	Ljava/net/URL;
    //   260: invokestatic 42	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   263: astore 20
    //   265: ldc 54
    //   267: new 103	java/lang/StringBuilder
    //   270: dup
    //   271: bipush 31
    //   273: aload 20
    //   275: invokestatic 42	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   278: invokevirtual 46	java/lang/String:length	()I
    //   281: iadd
    //   282: invokespecial 106	java/lang/StringBuilder:<init>	(I)V
    //   285: ldc 157
    //   287: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload 20
    //   292: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 160	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   301: pop
    //   302: aconst_null
    //   303: aload 11
    //   305: invokestatic 149	com/google/firebase/messaging/h:a	(Ljava/lang/Throwable;Ljava/io/InputStream;)V
    //   308: aload 6
    //   310: ifnull +9 -> 319
    //   313: aconst_null
    //   314: aload 6
    //   316: invokestatic 149	com/google/firebase/messaging/h:a	(Ljava/lang/Throwable;Ljava/io/InputStream;)V
    //   319: aload 16
    //   321: areturn
    //   322: astore 7
    //   324: aconst_null
    //   325: astore 8
    //   327: goto -144 -> 183
    //   330: astore 12
    //   332: aconst_null
    //   333: astore 13
    //   335: goto -177 -> 158
    //
    // Exception table:
    //   from	to	target	type
    //   65	78	143	java/lang/Throwable
    //   83	143	143	java/lang/Throwable
    //   247	302	143	java/lang/Throwable
    //   145	148	148	finally
    //   55	65	168	java/lang/Throwable
    //   158	168	168	java/lang/Throwable
    //   302	308	168	java/lang/Throwable
    //   170	173	173	finally
    //   43	55	198	java/io/IOException
    //   188	195	198	java/io/IOException
    //   195	198	198	java/io/IOException
    //   313	319	198	java/io/IOException
    //   55	65	322	finally
    //   158	168	322	finally
    //   302	308	322	finally
    //   65	78	330	finally
    //   83	143	330	finally
    //   247	302	330	finally
  }

  public final void close()
  {
    zzk.zza(this.c);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.messaging.h
 * JD-Core Version:    0.6.2
 */