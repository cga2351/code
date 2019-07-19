package com.viber.voip.camera.b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.DocumentsContract;
import com.viber.voip.camera.activity.ViberCcamActivity.c;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class b
{
  private static final String a = com.viber.voip.camera.e.a.a(b.class);
  private Context b = null;
  private Uri c = null;

  public b(Context paramContext)
  {
    this.b = paramContext;
  }

  public static File a(String paramString)
  {
    if ((paramString.length() > 0) && (paramString.lastIndexOf('/') == -1 + paramString.length()))
      paramString = paramString.substring(0, -1 + paramString.length());
    if (paramString.startsWith("/"))
      return new File(paramString);
    return new File(d(), paramString);
  }

  private String a(int paramInt1, int paramInt2)
  {
    String str1 = "";
    if (paramInt2 > 0)
      str1 = "_" + paramInt2;
    String str2 = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date());
    SharedPreferences localSharedPreferences = com.viber.voip.camera.d.a.a(this.b);
    if (paramInt1 == 1)
    {
      String str4 = localSharedPreferences.getString(com.viber.voip.camera.d.a.w(), "IMG_");
      return str4 + str2 + str1 + ".jpg";
    }
    if (paramInt1 == 2)
    {
      String str3 = localSharedPreferences.getString(com.viber.voip.camera.d.a.x(), "VID_");
      return str3 + str2 + str1 + ".mp4";
    }
    throw new RuntimeException();
  }

  private void a(String paramString, Uri paramUri)
  {
    Activity localActivity = (Activity)this.b;
    if ("android.media.action.VIDEO_CAPTURE".equals(paramString))
    {
      Intent localIntent = new Intent();
      localIntent.setData(paramUri);
      localActivity.setResult(-1, localIntent);
      localActivity.finish();
    }
  }

  public static boolean a(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool1 = false;
    if (i >= 21)
    {
      boolean bool2 = com.viber.voip.camera.d.a.a(paramContext).getBoolean(com.viber.voip.camera.d.a.t(), false);
      bool1 = false;
      if (bool2)
        bool1 = true;
    }
    return bool1;
  }

  public static File d()
  {
    return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
  }

  @SuppressLint({"SimpleDateFormat"})
  public File a(int paramInt)
    throws IOException
  {
    File localFile1 = g();
    if (!localFile1.exists())
    {
      if (!localFile1.mkdirs())
        throw new IOException();
      a(localFile1, false, false);
    }
    File localFile2 = null;
    for (int i = 0; ; i++)
      if (i < 100)
      {
        String str = a(paramInt, i);
        localFile2 = new File(localFile1.getPath() + File.separator + str);
        if (localFile2.exists());
      }
      else
      {
        if (localFile2 != null)
          break;
        throw new IOException();
      }
    return localFile2;
  }

  public void a()
  {
    this.c = null;
  }

  public void a(Uri paramUri, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.b.sendBroadcast(new Intent("android.hardware.action.NEW_PICTURE", paramUri));
      this.b.sendBroadcast(new Intent("com.android.camera.NEW_PICTURE", paramUri));
    }
    while (!paramBoolean2)
      return;
    this.b.sendBroadcast(new Intent("android.hardware.action.NEW_VIDEO", paramUri));
  }

  public void a(File paramFile, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    if (paramFile.isDirectory())
      return;
    final String str = ((Activity)this.b).getIntent().getAction();
    ViberCcamActivity.c localc;
    if (((paramBoolean1) || (paramBoolean2)) && ((this.b instanceof ViberCcamActivity.c)) && (!"android.media.action.VIDEO_CAPTURE".equals(str)) && (!"android.media.action.IMAGE_CAPTURE".equals(str)) && (!"android.media.action.IMAGE_CAPTURE_SECURE".equals(str)))
    {
      localc = (ViberCcamActivity.c)this.b;
      if (((Activity)this.b).getCallingActivity() == null)
        break label142;
      localc.a(paramFile.getAbsolutePath(), Uri.fromFile(paramFile), paramBoolean1, paramBoolean2, 43);
    }
    while (new File(paramFile.getParentFile(), ".nomedia").exists())
    {
      a(str, Uri.fromFile(paramFile));
      return;
      label142: localc.a(paramFile.getAbsolutePath(), Uri.fromFile(paramFile), paramBoolean1, paramBoolean2);
    }
    Context localContext = this.b;
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramFile.getAbsolutePath();
    MediaScannerConnection.scanFile(localContext, arrayOfString, null, new MediaScannerConnection.OnScanCompletedListener()
    {
      public void onScanCompleted(String paramAnonymousString, Uri paramAnonymousUri)
      {
        b.a(b.this, paramAnonymousUri);
        b.this.a(paramAnonymousUri, paramBoolean1, paramBoolean2);
        b.a(b.this, str, paramAnonymousUri);
      }
    });
  }

  @TargetApi(21)
  public Uri b(int paramInt)
    throws IOException
  {
    Uri localUri3;
    while (true)
    {
      String str1;
      try
      {
        Uri localUri1 = e();
        Uri localUri2 = DocumentsContract.buildDocumentUriUsingTree(localUri1, DocumentsContract.getTreeDocumentId(localUri1));
        if (paramInt == 1)
        {
          str1 = "image/jpeg";
          String str2 = a(paramInt, 0);
          localUri3 = DocumentsContract.createDocument(this.b.getContentResolver(), localUri2, str1, str2);
          if (localUri3 != null)
            break;
          throw new IOException();
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw new IOException();
      }
      if (paramInt == 2)
        str1 = "video/mp4";
      else
        throw new RuntimeException();
    }
    return localUri3;
  }

  @TargetApi(21)
  public File b(String paramString)
  {
    String[] arrayOfString = paramString.split(":");
    if (arrayOfString.length >= 2)
    {
      String str1 = arrayOfString[0];
      String str2 = arrayOfString[1];
      File[] arrayOfFile = new File("/storage").listFiles();
      boolean bool = "primary".equalsIgnoreCase(str1);
      File localFile1 = null;
      if (bool)
        localFile1 = new File(Environment.getExternalStorageDirectory(), str2);
      localObject = localFile1;
      for (int i = 0; (i < arrayOfFile.length) && (localObject == null); i++)
      {
        File localFile2 = new File(arrayOfFile[i], str2);
        if (localFile2.exists())
          localObject = localFile2;
      }
    }
    Object localObject = null;
    return localObject;
  }

  public boolean b()
  {
    return a(this.b);
  }

  public String c()
  {
    return com.viber.voip.camera.d.a.a(this.b).getString(com.viber.voip.camera.d.a.u(), "ViberCamera");
  }

  Uri e()
  {
    return Uri.parse(com.viber.voip.camera.d.a.a(this.b).getString(com.viber.voip.camera.d.a.v(), ""));
  }

  @TargetApi(21)
  public String f()
  {
    Uri localUri = e();
    boolean bool = "com.android.externalstorage.documents".equals(localUri.getAuthority());
    String str = null;
    if (bool)
    {
      String[] arrayOfString = DocumentsContract.getTreeDocumentId(localUri).split(":");
      int i = arrayOfString.length;
      str = null;
      if (i >= 2)
      {
        arrayOfString[0];
        str = arrayOfString[1];
      }
    }
    return str;
  }

  @TargetApi(21)
  public File g()
  {
    if (b())
    {
      Uri localUri = e();
      boolean bool = "com.android.externalstorage.documents".equals(localUri.getAuthority());
      File localFile = null;
      if (bool)
        localFile = b(DocumentsContract.getTreeDocumentId(localUri));
      return localFile;
    }
    return a(c());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camera.b.b
 * JD-Core Version:    0.6.2
 */