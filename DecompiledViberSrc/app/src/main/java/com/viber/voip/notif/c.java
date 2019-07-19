package com.viber.voip.notif;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.content.Context;
import android.content.res.Resources;
import android.media.AudioAttributes.Builder;
import android.net.Uri;
import android.provider.Settings.System;
import android.text.TextUtils;
import com.viber.common.b.h;
import com.viber.common.d.a;
import com.viber.dexshared.Logger;
import com.viber.voip.R.raw;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.ag;
import com.viber.voip.settings.d.m;
import com.viber.voip.sound.RingtoneProvider;
import com.viber.voip.util.dk;

@TargetApi(26)
public enum c
{
  static final Logger g = ViberEnv.getLogger();
  public final b h;
  public final int i;
  public final int j;
  public int k;
  final String l;
  final long[] m;
  final int n;
  final int o;
  final boolean p;

  static
  {
    c[] arrayOfc = new c[6];
    arrayOfc[0] = a;
    arrayOfc[1] = b;
    arrayOfc[2] = c;
    arrayOfc[3] = d;
    arrayOfc[4] = e;
    arrayOfc[5] = f;
    q = arrayOfc;
  }

  private c(b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    this(paramb, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, 0, null, null);
  }

  private c(b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, String paramString, long[] paramArrayOfLong)
  {
    this.h = paramb;
    this.i = paramInt1;
    this.n = paramInt2;
    this.o = paramInt3;
    this.k = paramInt5;
    this.l = paramString;
    this.m = paramArrayOfLong;
    this.j = paramInt4;
    this.p = paramBoolean;
  }

  private NotificationChannel f(Context paramContext)
  {
    NotificationChannel localNotificationChannel = new NotificationChannel(this.h.b(), paramContext.getString(this.n), this.i);
    if (this.o != 0)
      localNotificationChannel.setDescription(paramContext.getString(this.o));
    if (this.j != 0)
    {
      localNotificationChannel.enableLights(true);
      localNotificationChannel.setLightColor(this.j);
    }
    Uri localUri = b(paramContext);
    if (localUri != null)
    {
      AudioAttributes.Builder localBuilder = new AudioAttributes.Builder();
      localBuilder.setContentType(4).setLegacyStreamType(5);
      localNotificationChannel.setSound(localUri, localBuilder.build());
    }
    while (true)
    {
      long[] arrayOfLong = c();
      if (arrayOfLong != null)
      {
        localNotificationChannel.enableVibration(true);
        localNotificationChannel.setVibrationPattern(arrayOfLong);
      }
      localNotificationChannel.setShowBadge(this.p);
      return localNotificationChannel;
      localNotificationChannel.setSound(null, null);
    }
  }

  public Uri a(Context paramContext)
  {
    if ((a.m()) || (this.k == 0))
      return null;
    return dk.a(this.k, paramContext);
  }

  final void a(Context paramContext, f paramf)
  {
    paramf.a(f(paramContext));
  }

  public final boolean a(f paramf)
  {
    NotificationChannel localNotificationChannel;
    if (a.m())
      localNotificationChannel = paramf.b(this.h.b());
    return (localNotificationChannel != null) && (localNotificationChannel.getImportance() != 0);
  }

  public long[] a()
  {
    if (a.m())
      return null;
    return this.m;
  }

  public int b()
  {
    if (a.m());
    while ((4 != this.i) || (!a.g()) || ((d.ag.a.d()) && (!a.o())))
      return 0;
    return 1;
  }

  Uri b(Context paramContext)
  {
    if (!a.m());
    String str;
    do
    {
      return null;
      str = c(paramContext);
    }
    while (str == null);
    return RingtoneProvider.getNotificationContentUri(str);
  }

  public final boolean b(f paramf)
  {
    NotificationChannel localNotificationChannel;
    if (a.m())
      localNotificationChannel = paramf.b(this.h.b());
    return (localNotificationChannel != null) && (localNotificationChannel.getImportance() > 2) && (localNotificationChannel.getSound() != null);
  }

  final String c(Context paramContext)
  {
    String str;
    if (this.k == 0)
      str = null;
    do
    {
      return str;
      str = this.l;
    }
    while (!TextUtils.isEmpty(str));
    return paramContext.getResources().getResourceEntryName(this.k);
  }

  long[] c()
  {
    if ((!a.m()) || (!d.m.b.d()))
      return null;
    return this.m;
  }

  // ERROR //
  final void d(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: invokestatic 247	com/viber/common/d/a:m	()Z
    //   5: ifeq +10 -> 15
    //   8: aload_0
    //   9: getfield 160	com/viber/voip/notif/c:k	I
    //   12: ifne +4 -> 16
    //   15: return
    //   16: aload_1
    //   17: invokevirtual 304	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   20: astore_3
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 284	com/viber/voip/notif/c:c	(Landroid/content/Context;)Ljava/lang/String;
    //   26: astore 4
    //   28: getstatic 322	com/viber/voip/util/dv:O	Lcom/viber/voip/util/dv;
    //   31: aload_1
    //   32: aload 4
    //   34: iconst_0
    //   35: invokevirtual 325	com/viber/voip/util/dv:b	(Landroid/content/Context;Ljava/lang/String;Z)Ljava/io/File;
    //   38: astore 5
    //   40: aload 5
    //   42: ifnull -27 -> 15
    //   45: aload 5
    //   47: invokevirtual 330	java/io/File:exists	()Z
    //   50: ifne -35 -> 15
    //   53: aload_3
    //   54: aload_0
    //   55: getfield 160	com/viber/voip/notif/c:k	I
    //   58: invokevirtual 334	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   61: astore 10
    //   63: aload 10
    //   65: astore 7
    //   67: new 336	java/io/FileOutputStream
    //   70: dup
    //   71: aload 5
    //   73: invokespecial 339	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   76: astore 9
    //   78: aload 7
    //   80: aload 9
    //   82: invokestatic 344	com/viber/voip/util/bj:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   85: aload 5
    //   87: invokestatic 350	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   90: aload_1
    //   91: invokestatic 355	com/viber/voip/util/upload/o:a	(Landroid/net/Uri;Landroid/content/Context;)Landroid/net/Uri;
    //   94: pop
    //   95: iconst_2
    //   96: anewarray 357	java/io/Closeable
    //   99: dup
    //   100: iconst_0
    //   101: aload 7
    //   103: aastore
    //   104: dup
    //   105: iconst_1
    //   106: aload 9
    //   108: aastore
    //   109: invokestatic 360	com/viber/voip/util/bj:a	([Ljava/io/Closeable;)V
    //   112: return
    //   113: astore 8
    //   115: aconst_null
    //   116: astore 9
    //   118: iconst_2
    //   119: anewarray 357	java/io/Closeable
    //   122: dup
    //   123: iconst_0
    //   124: aload_2
    //   125: aastore
    //   126: dup
    //   127: iconst_1
    //   128: aload 9
    //   130: aastore
    //   131: invokestatic 360	com/viber/voip/util/bj:a	([Ljava/io/Closeable;)V
    //   134: return
    //   135: astore 6
    //   137: aconst_null
    //   138: astore 7
    //   140: iconst_2
    //   141: anewarray 357	java/io/Closeable
    //   144: dup
    //   145: iconst_0
    //   146: aload 7
    //   148: aastore
    //   149: dup
    //   150: iconst_1
    //   151: aload_2
    //   152: aastore
    //   153: invokestatic 360	com/viber/voip/util/bj:a	([Ljava/io/Closeable;)V
    //   156: aload 6
    //   158: athrow
    //   159: astore 6
    //   161: aconst_null
    //   162: astore_2
    //   163: goto -23 -> 140
    //   166: astore 12
    //   168: aload 9
    //   170: astore_2
    //   171: aload 12
    //   173: astore 6
    //   175: goto -35 -> 140
    //   178: astore 14
    //   180: aload 7
    //   182: astore_2
    //   183: aconst_null
    //   184: astore 9
    //   186: goto -68 -> 118
    //   189: astore 11
    //   191: aload 7
    //   193: astore_2
    //   194: goto -76 -> 118
    //
    // Exception table:
    //   from	to	target	type
    //   53	63	113	java/io/IOException
    //   53	63	135	finally
    //   67	78	159	finally
    //   78	95	166	finally
    //   67	78	178	java/io/IOException
    //   78	95	189	java/io/IOException
  }

  final Uri e(Context paramContext)
  {
    String str = d.ag.i.d();
    Uri localUri;
    if (str == null)
      localUri = Settings.System.DEFAULT_NOTIFICATION_URI;
    do
    {
      boolean bool;
      do
      {
        return localUri;
        bool = TextUtils.isEmpty(str);
        localUri = null;
      }
      while (bool);
      localUri = Uri.parse(str);
    }
    while ((!a.k()) || (!dk.c(localUri)));
    return Settings.System.DEFAULT_NOTIFICATION_URI;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.c
 * JD-Core Version:    0.6.2
 */