package com.viber.common.d;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class e
{
  private Bundle a;

  public e(Bundle paramBundle)
  {
    this.a = paramBundle;
  }

  public void a(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent1 = new Intent("android.intent.action.SEND");
    localIntent1.setType(paramString1);
    localIntent1.putExtras(this.a);
    Intent localIntent2 = Intent.createChooser(localIntent1, paramString2);
    localIntent2.addFlags(268435456);
    paramContext.startActivity(localIntent2);
  }

  public static class a
  {
    private List<String> a;
    private List<String> b;
    private String c;
    private CharSequence d;
    private Uri e;

    private static void a(File paramFile, String paramString, ZipOutputStream paramZipOutputStream)
      throws IOException
    {
      File localFile = new File(paramFile, paramString);
      if (!localFile.isDirectory())
      {
        FileInputStream localFileInputStream = new FileInputStream(localFile);
        byte[] arrayOfByte = new byte[1024];
        paramZipOutputStream.putNextEntry(new ZipEntry(paramString));
        while (true)
        {
          int i = localFileInputStream.read(arrayOfByte);
          if (i == -1)
            break;
          paramZipOutputStream.write(arrayOfByte, 0, i);
        }
        paramZipOutputStream.flush();
        paramZipOutputStream.closeEntry();
        f.a(new Closeable[] { localFileInputStream });
      }
    }

    public a a(Context paramContext, Uri paramUri, String paramString)
    {
      this.e = d.a(paramUri, paramContext, paramString);
      return this;
    }

    // ERROR //
    public a a(Context paramContext, File paramFile1, File paramFile2, String paramString)
    {
      // Byte code:
      //   0: aload_2
      //   1: invokevirtual 82	java/io/File:list	()[Ljava/lang/String;
      //   4: astore 5
      //   6: aload 5
      //   8: ifnull +187 -> 195
      //   11: aconst_null
      //   12: astore 6
      //   14: new 84	java/io/FileOutputStream
      //   17: dup
      //   18: aload_3
      //   19: invokespecial 85	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   22: astore 7
      //   24: new 42	java/util/zip/ZipOutputStream
      //   27: dup
      //   28: aload 7
      //   30: invokespecial 88	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   33: astore 8
      //   35: iconst_0
      //   36: istore 9
      //   38: iload 9
      //   40: aload 5
      //   42: arraylength
      //   43: if_icmpge +101 -> 144
      //   46: new 23	java/io/File
      //   49: dup
      //   50: aload_2
      //   51: aload 5
      //   53: iload 9
      //   55: aaload
      //   56: invokespecial 26	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   59: astore 14
      //   61: aload 14
      //   63: invokevirtual 30	java/io/File:isDirectory	()Z
      //   66: ifeq +64 -> 130
      //   69: aload 14
      //   71: invokevirtual 82	java/io/File:list	()[Ljava/lang/String;
      //   74: astore 15
      //   76: iconst_0
      //   77: istore 16
      //   79: iload 16
      //   81: aload 15
      //   83: arraylength
      //   84: if_icmpge +211 -> 295
      //   87: aload_2
      //   88: new 90	java/lang/StringBuilder
      //   91: dup
      //   92: invokespecial 91	java/lang/StringBuilder:<init>	()V
      //   95: aload 5
      //   97: iload 9
      //   99: aaload
      //   100: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   103: ldc 97
      //   105: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   108: aload 15
      //   110: iload 16
      //   112: aaload
      //   113: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   116: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   119: aload 8
      //   121: invokestatic 103	com/viber/common/d/e$a:a	(Ljava/io/File;Ljava/lang/String;Ljava/util/zip/ZipOutputStream;)V
      //   124: iinc 16 1
      //   127: goto -48 -> 79
      //   130: aload_2
      //   131: aload 5
      //   133: iload 9
      //   135: aaload
      //   136: aload 8
      //   138: invokestatic 103	com/viber/common/d/e$a:a	(Ljava/io/File;Ljava/lang/String;Ljava/util/zip/ZipOutputStream;)V
      //   141: goto +154 -> 295
      //   144: aload 7
      //   146: invokevirtual 106	java/io/OutputStream:flush	()V
      //   149: iconst_2
      //   150: anewarray 64	java/io/Closeable
      //   153: dup
      //   154: iconst_0
      //   155: aload 8
      //   157: aastore
      //   158: dup
      //   159: iconst_1
      //   160: aload 7
      //   162: aastore
      //   163: invokestatic 69	com/viber/common/d/f:a	([Ljava/io/Closeable;)V
      //   166: aload_0
      //   167: aload_1
      //   168: aload_3
      //   169: invokestatic 112	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
      //   172: aload 4
      //   174: invokevirtual 114	com/viber/common/d/e$a:a	(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;)Lcom/viber/common/d/e$a;
      //   177: pop
      //   178: iconst_2
      //   179: anewarray 64	java/io/Closeable
      //   182: dup
      //   183: iconst_0
      //   184: aload 8
      //   186: aastore
      //   187: dup
      //   188: iconst_1
      //   189: aload 7
      //   191: aastore
      //   192: invokestatic 69	com/viber/common/d/f:a	([Ljava/io/Closeable;)V
      //   195: aload_0
      //   196: areturn
      //   197: astore 20
      //   199: aconst_null
      //   200: astore 11
      //   202: aconst_null
      //   203: astore 8
      //   205: iconst_2
      //   206: anewarray 64	java/io/Closeable
      //   209: dup
      //   210: iconst_0
      //   211: aload 8
      //   213: aastore
      //   214: dup
      //   215: iconst_1
      //   216: aload 11
      //   218: aastore
      //   219: invokestatic 69	com/viber/common/d/f:a	([Ljava/io/Closeable;)V
      //   222: aload_0
      //   223: areturn
      //   224: astore 19
      //   226: aconst_null
      //   227: astore 7
      //   229: aload 19
      //   231: astore 13
      //   233: iconst_2
      //   234: anewarray 64	java/io/Closeable
      //   237: dup
      //   238: iconst_0
      //   239: aload 6
      //   241: aastore
      //   242: dup
      //   243: iconst_1
      //   244: aload 7
      //   246: aastore
      //   247: invokestatic 69	com/viber/common/d/f:a	([Ljava/io/Closeable;)V
      //   250: aload 13
      //   252: athrow
      //   253: astore 13
      //   255: aconst_null
      //   256: astore 6
      //   258: goto -25 -> 233
      //   261: astore 12
      //   263: aload 8
      //   265: astore 6
      //   267: aload 12
      //   269: astore 13
      //   271: goto -38 -> 233
      //   274: astore 18
      //   276: aload 7
      //   278: astore 11
      //   280: aconst_null
      //   281: astore 8
      //   283: goto -78 -> 205
      //   286: astore 10
      //   288: aload 7
      //   290: astore 11
      //   292: goto -87 -> 205
      //   295: iinc 9 1
      //   298: goto -260 -> 38
      //
      // Exception table:
      //   from	to	target	type
      //   14	24	197	java/io/IOException
      //   14	24	224	finally
      //   24	35	253	finally
      //   38	76	261	finally
      //   79	124	261	finally
      //   130	141	261	finally
      //   144	178	261	finally
      //   24	35	274	java/io/IOException
      //   38	76	286	java/io/IOException
      //   79	124	286	java/io/IOException
      //   130	141	286	java/io/IOException
      //   144	178	286	java/io/IOException
    }

    public a a(CharSequence paramCharSequence)
    {
      this.d = paramCharSequence;
      return this;
    }

    public a a(String paramString)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        if (this.a == null)
          this.a = new ArrayList();
        this.a.add(paramString);
      }
      return this;
    }

    public e a()
    {
      Bundle localBundle = new Bundle();
      if ((this.a != null) && (!this.a.isEmpty()))
        localBundle.putStringArray("android.intent.extra.EMAIL", (String[])this.a.toArray(new String[this.a.size()]));
      if ((this.b != null) && (!this.b.isEmpty()))
        localBundle.putStringArray("android.intent.extra.CC", (String[])this.b.toArray(new String[this.b.size()]));
      if (!TextUtils.isEmpty(this.c))
        localBundle.putString("android.intent.extra.SUBJECT", this.c);
      if (!TextUtils.isEmpty(this.d))
        localBundle.putCharSequence("android.intent.extra.TEXT", this.d);
      if (this.e != null)
        localBundle.putParcelable("android.intent.extra.STREAM", this.e);
      return new e(localBundle);
    }

    public a b(String paramString)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        if (this.b == null)
          this.b = new ArrayList();
        this.b.add(paramString);
      }
      return this;
    }

    public a c(String paramString)
    {
      this.c = paramString;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.d.e
 * JD-Core Version:    0.6.2
 */