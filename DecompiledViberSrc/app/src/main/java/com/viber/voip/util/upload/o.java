package com.viber.voip.util.upload;

import android.app.Application;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import com.viber.common.b.b;
import com.viber.common.dialogs.h.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.ad;
import com.viber.voip.ui.dialogs.k;
import com.viber.voip.util.at;
import com.viber.voip.util.bw;
import com.viber.voip.util.da;
import com.viber.voip.util.dk;
import com.viber.voip.util.dv;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

public class o
{
  private static final Logger a = ViberEnv.getLogger();
  private static final long b = TimeUnit.DAYS.toMillis(14L);

  public static Uri a(Uri paramUri)
  {
    if (!dk.b(paramUri))
      return null;
    String str = paramUri.getPath();
    long l = bw.b(ViberApplication.getApplication(), paramUri);
    ContentValues localContentValues = new ContentValues(3);
    localContentValues.put("mime_type", "video/mp4");
    localContentValues.put("_data", str);
    localContentValues.put("duration", Long.valueOf(l));
    try
    {
      Uri localUri2 = f().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, localContentValues);
      localUri1 = localUri2;
      a(str);
      return localUri1;
    }
    catch (Exception localException)
    {
      while (true)
        Uri localUri1 = null;
    }
  }

  public static Uri a(Uri paramUri, Context paramContext)
  {
    if (!dk.b(paramUri))
      return null;
    long l = bw.b(paramContext, paramUri);
    String str = paramUri.getPath();
    ContentValues localContentValues = new ContentValues(4);
    localContentValues.put("mime_type", "audio/mpeg");
    localContentValues.put("_data", str);
    localContentValues.put("duration", Long.valueOf(l));
    localContentValues.put("is_notification", Boolean.valueOf(true));
    try
    {
      Uri localUri2 = f().insert(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, localContentValues);
      localUri1 = localUri2;
      a(str);
      return localUri1;
    }
    catch (Exception localException)
    {
      while (true)
        Uri localUri1 = null;
    }
  }

  public static Uri a(Uri paramUri1, Uri paramUri2)
  {
    if (!dk.b(paramUri1));
    while (true)
    {
      return paramUri2;
      String[] arrayOfString = at.f(paramUri1);
      String str;
      ContentValues localContentValues;
      if ((arrayOfString != null) && (!da.a(arrayOfString[0])))
      {
        str = arrayOfString[0];
        localContentValues = new ContentValues(2);
        localContentValues.put("mime_type", str);
        localContentValues.put("_data", paramUri1.getPath());
      }
      try
      {
        Uri localUri2 = f().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, localContentValues);
        localUri1 = localUri2;
        a(paramUri1.getPath());
        if (localUri1 == null)
          continue;
        return localUri1;
        str = "image/jpeg";
      }
      catch (Exception localException)
      {
        while (true)
          Uri localUri1 = null;
      }
    }
  }

  public static File a(String paramString, int paramInt, Context paramContext)
  {
    dv localdv;
    switch (paramInt)
    {
    default:
      localdv = dv.g;
    case 1:
    case 1005:
    case 3:
    case 1003:
    case 1004:
    case 1010:
    }
    while (true)
    {
      return localdv.b(paramContext, paramString, false);
      localdv = dv.a;
      continue;
      localdv = dv.c;
      continue;
      localdv = dv.b;
      continue;
      localdv = dv.e;
      continue;
      localdv = dv.A;
    }
  }

  public static File a(String paramString, Context paramContext)
  {
    File localFile = dv.c.b(paramContext, paramString);
    if (at.a(localFile))
      return localFile;
    return dv.u.b(paramContext, paramString);
  }

  public static void a(final String paramString)
  {
    MediaScannerConnection[] arrayOfMediaScannerConnection = new MediaScannerConnection[1];
    MediaScannerConnection.MediaScannerConnectionClient local1 = new MediaScannerConnection.MediaScannerConnectionClient()
    {
      public void onMediaScannerConnected()
      {
        if (this.a[0] != null)
          this.a[0].scanFile(paramString, null);
      }

      public void onScanCompleted(String paramAnonymousString, Uri paramAnonymousUri)
      {
        if (this.a[0] != null)
          this.a[0].disconnect();
      }
    };
    arrayOfMediaScannerConnection[0] = new MediaScannerConnection(ViberApplication.getApplication(), local1);
    arrayOfMediaScannerConnection[0].connect();
  }

  public static boolean a()
  {
    return a(false);
  }

  public static boolean a(String paramString, boolean paramBoolean)
  {
    if ((at.f(paramString) > 25165824L) && (!d.ad.G.d()))
      return true;
    if (paramBoolean)
      k.m().d();
    return false;
  }

  public static boolean a(boolean paramBoolean)
  {
    return a(Environment.getExternalStorageDirectory().getPath(), paramBoolean);
  }

  public static Uri b(Uri paramUri)
  {
    return a(paramUri, paramUri);
  }

  public static File b(String paramString, int paramInt, Context paramContext)
  {
    if ((1003 == paramInt) || (1004 == paramInt));
    for (dv localdv = dv.e; ; localdv = dv.g)
      return at.g(localdv.b(paramContext, paramString, false));
  }

  public static void b(String paramString)
  {
    try
    {
      f().delete(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_data=?", new String[] { paramString });
      label20: a(paramString);
      return;
    }
    catch (Exception localException)
    {
      break label20;
    }
  }

  public static boolean b()
  {
    return b(false);
  }

  public static boolean b(boolean paramBoolean)
  {
    if ("mounted".equals(e()))
      return true;
    if (paramBoolean)
      k.g().d();
    return false;
  }

  public static boolean c()
  {
    String str = e();
    return (str != null) && ((str.equals("mounted")) || (str.equals("mounted_ro")));
  }

  public static void d()
  {
    File[] arrayOfFile;
    if (b())
    {
      File localFile1 = dv.J.a(ViberApplication.getApplication());
      if (localFile1.exists())
      {
        arrayOfFile = localFile1.listFiles();
        if (arrayOfFile != null)
          break label33;
      }
    }
    while (true)
    {
      return;
      label33: Arrays.sort(arrayOfFile, new Comparator()
      {
        public int a(File paramAnonymousFile1, File paramAnonymousFile2)
        {
          long l = paramAnonymousFile1.lastModified();
          return Long.compare(paramAnonymousFile2.lastModified(), l);
        }
      });
      long l = 0L;
      int i = arrayOfFile.length;
      for (int j = 0; j < i; j++)
      {
        File localFile2 = arrayOfFile[j];
        l += localFile2.length();
        if ((l >= 209715200L) || (System.currentTimeMillis() - localFile2.lastModified() >= b))
          at.f(localFile2);
      }
    }
  }

  public static String e()
  {
    try
    {
      String str = Environment.getExternalStorageState();
      return str;
    }
    catch (RuntimeException localRuntimeException)
    {
      a.a(localRuntimeException, "getExternalStorageState(): unable to obtain external storage state.");
    }
    return null;
  }

  private static ContentResolver f()
  {
    return ViberApplication.getApplication().getContentResolver();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.upload.o
 * JD-Core Version:    0.6.2
 */