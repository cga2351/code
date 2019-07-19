package com.viber.voip.util;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import android.support.v4.app.FragmentActivity;
import android.webkit.MimeTypeMap;
import com.viber.common.d.a;
import com.viber.common.dialogs.h.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.extras.image.c;
import com.viber.voip.messages.k;
import com.viber.voip.util.e.j;
import com.viber.voip.util.upload.ObjectId;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class at
{
  private static final Logger a = ViberEnv.getLogger();
  private static Pattern b;
  private static final String[] c = { "apk", "prg", "ipa", "ksh", "out", "run", "action", "app", "command", "osx", "workflow", "csh", "bat", "cmd", "com", "cpl", "exe", "gadget", "inf1", "ins", "inx", "isu", "job", "jse", "lnk", "msc", "msi", "msp", "mst", "paf", "pif", "ps1", "reg", "rgs", "sct", "shb", "shs", "u3p", "vb", "vbe", "vbs", "vbscript", "ws", "wsf", "bin" };
  private static HashSet<String> d;

  public static long a()
  {
    return f(Environment.getExternalStorageDirectory().getPath());
  }

  public static Uri a(Uri paramUri, ObjectId paramObjectId, Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean);
    for (Uri localUri = dx.a(paramObjectId); ; localUri = dx.b(paramObjectId))
    {
      if (localUri != null)
      {
        File localFile1 = new File(paramUri.getPath());
        File localFile2 = dv.B.b(paramContext, localUri.toString(), false);
        if ((localFile2 != null) && (localFile1.renameTo(localFile2)))
          paramUri = localUri;
      }
      return paramUri;
    }
  }

  public static File a(Context paramContext)
  {
    File localFile1;
    if (a.k())
      localFile1 = paramContext.getDataDir();
    try
    {
      while (true)
      {
        File localFile2 = localFile1.getCanonicalFile();
        return localFile2;
        localFile1 = paramContext.getFilesDir().getParentFile();
      }
    }
    catch (IOException localIOException)
    {
    }
    return localFile1;
  }

  public static File a(Context paramContext, Uri paramUri)
  {
    String str = b(paramContext, paramUri);
    if (str == null)
      return null;
    return new File(str);
  }

  public static File a(Context paramContext, String paramString)
  {
    return new File(paramContext.getFilesDir(), paramString);
  }

  public static File a(File paramFile, String paramString1, String paramString2)
  {
    File localFile = new File(paramFile, paramString1 + paramString2);
    int i = 0;
    while (localFile.exists())
    {
      StringBuilder localStringBuilder = new StringBuilder().append(paramString1).append('(');
      i++;
      localFile = new File(paramFile, i + ')' + paramString2);
    }
    return localFile;
  }

  public static File a(File paramFile, String paramString, boolean paramBoolean)
  {
    File localFile;
    if (com.viber.voip.util.upload.o.b())
    {
      if (!paramFile.exists())
        paramFile.mkdirs();
      if (paramFile.getName().startsWith("."))
        j(paramFile.getAbsolutePath());
      localFile = new File(paramFile, paramString);
      if ((!paramBoolean) || (localFile.exists()));
    }
    try
    {
      localFile.createNewFile();
      return localFile;
      return null;
    }
    catch (IOException localIOException)
    {
    }
    return localFile;
  }

  public static File a(String paramString)
  {
    return new File(Environment.getExternalStoragePublicDirectory("viber"), paramString);
  }

  public static String a(long paramLong)
  {
    return a(paramLong, true);
  }

  public static String a(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean);
    for (String str = " "; paramLong < 1024L; str = "")
    {
      Object[] arrayOfObject4 = new Object[2];
      arrayOfObject4[0] = Long.valueOf(paramLong);
      arrayOfObject4[1] = str;
      return String.format("%d%sB", arrayOfObject4);
    }
    if (paramLong < 1048576L)
    {
      Object[] arrayOfObject3 = new Object[2];
      arrayOfObject3[0] = Float.valueOf((float)paramLong / 1024.0F);
      arrayOfObject3[1] = str;
      return String.format("%.1f%sKB", arrayOfObject3);
    }
    if (paramLong < 1073741824L)
    {
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = Float.valueOf((float)paramLong / 1024.0F / 1024.0F);
      arrayOfObject2[1] = str;
      return String.format("%.1f%sMB", arrayOfObject2);
    }
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = Float.valueOf((float)paramLong / 1024.0F / 1024.0F / 1024.0F);
    arrayOfObject1[1] = str;
    return String.format("%.1f%sGB", arrayOfObject1);
  }

  // ERROR //
  public static String a(Context paramContext, Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: invokestatic 290	com/viber/common/d/a:d	()Z
    //   3: ifeq +79 -> 82
    //   6: ldc_w 292
    //   9: astore 4
    //   11: iconst_1
    //   12: anewarray 25	java/lang/String
    //   15: dup
    //   16: iconst_0
    //   17: aload 4
    //   19: aastore
    //   20: astore 5
    //   22: aload_0
    //   23: invokevirtual 296	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   26: aload_1
    //   27: aload 5
    //   29: aload_2
    //   30: aload_3
    //   31: aconst_null
    //   32: invokevirtual 302	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   35: astore 10
    //   37: aload 10
    //   39: astore 7
    //   41: aload 7
    //   43: ifnull +47 -> 90
    //   46: aload 7
    //   48: invokeinterface 307 1 0
    //   53: ifeq +37 -> 90
    //   56: aload 7
    //   58: aload 7
    //   60: aload 4
    //   62: invokeinterface 311 2 0
    //   67: invokeinterface 315 2 0
    //   72: astore 12
    //   74: aload 7
    //   76: invokestatic 320	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   79: aload 12
    //   81: areturn
    //   82: ldc_w 292
    //   85: astore 4
    //   87: goto -76 -> 11
    //   90: aload 7
    //   92: invokestatic 320	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   95: aconst_null
    //   96: areturn
    //   97: astore 8
    //   99: aconst_null
    //   100: astore 9
    //   102: aload 9
    //   104: invokestatic 320	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   107: goto -12 -> 95
    //   110: astore 6
    //   112: aconst_null
    //   113: astore 7
    //   115: aload 7
    //   117: invokestatic 320	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   120: aload 6
    //   122: athrow
    //   123: astore 6
    //   125: goto -10 -> 115
    //   128: astore 11
    //   130: aload 7
    //   132: astore 9
    //   134: goto -32 -> 102
    //
    // Exception table:
    //   from	to	target	type
    //   22	37	97	java/lang/Exception
    //   22	37	110	finally
    //   46	74	123	finally
    //   46	74	128	java/lang/Exception
  }

  private static String a(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt >= -4 + paramArrayOfByte.length)
      return "";
    StringBuilder localStringBuilder = new StringBuilder(4);
    for (int i = 0; i < 4; i++)
      if (paramArrayOfByte[(paramInt + i)] > 32)
        localStringBuilder.append((char)paramArrayOfByte[(paramInt + i)]);
    return localStringBuilder.toString().toUpperCase();
  }

  public static void a(Uri paramUri, ObjectId paramObjectId, Context paramContext)
  {
    Uri localUri = dx.f(paramObjectId.toDecString());
    if (localUri != null)
    {
      File localFile1 = new File(paramUri.getPath());
      File localFile2 = dv.n.b(paramContext, localUri.toString(), false);
      if (localFile2 != null)
        localFile1.renameTo(localFile2);
    }
  }

  public static void a(FragmentActivity paramFragmentActivity, Uri paramUri, boolean paramBoolean, b paramb)
  {
    a(paramFragmentActivity, Collections.singletonList(paramUri), paramBoolean, paramb);
  }

  public static void a(FragmentActivity paramFragmentActivity, List<Uri> paramList, boolean paramBoolean, final b paramb)
  {
    if (paramb == null)
      return;
    ArrayList localArrayList = new ArrayList(paramList);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      Uri localUri = (Uri)localIterator.next();
      File localFile = a(paramFragmentActivity, localUri);
      if ((localFile == null) || (!localFile.exists()))
      {
        localHashMap.put(localUri.getPath(), Boolean.valueOf(false));
        localIterator.remove();
      }
      else
      {
        String str = localFile.getPath();
        long l = c(str);
        if ((!h(str)) || (j.a(Uri.fromFile(localFile))))
        {
          if (paramBoolean)
            com.viber.voip.ui.dialogs.o.c().b(paramFragmentActivity);
          localHashMap.put(localUri.getPath(), Boolean.valueOf(false));
          localIterator.remove();
        }
        else if (c.c(paramFragmentActivity, localUri, 3) > 190000L)
        {
          if (paramBoolean)
            com.viber.voip.ui.dialogs.o.d().b(paramFragmentActivity);
          localHashMap.put(localUri.getPath(), Boolean.valueOf(false));
          localIterator.remove();
        }
        else if (l <= 25165824L)
        {
          localHashMap.put(localUri.getPath(), Boolean.valueOf(true));
          localIterator.remove();
        }
      }
    }
    if (localArrayList.size() > 0)
    {
      dy.a().a(localArrayList, new dy.a()
      {
        public void a(Map<String, Boolean> paramAnonymousMap)
        {
          this.a.putAll(paramAnonymousMap);
          paramb.a(this.a);
        }
      });
      return;
    }
    paramb.a(localHashMap);
  }

  // ERROR //
  public static void a(String paramString, Object paramObject, ReentrantLock paramReentrantLock)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_2
    //   3: ifnull +7 -> 10
    //   6: aload_2
    //   7: invokevirtual 451	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   10: new 199	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   17: aload_0
    //   18: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: ldc_w 453
    //   24: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: astore 8
    //   32: new 126	java/io/File
    //   35: dup
    //   36: aload 8
    //   38: invokespecial 147	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: astore 9
    //   43: aload 9
    //   45: invokevirtual 209	java/io/File:exists	()Z
    //   48: ifeq +9 -> 57
    //   51: aload 9
    //   53: invokevirtual 456	java/io/File:delete	()Z
    //   56: pop
    //   57: new 458	java/io/ObjectOutputStream
    //   60: dup
    //   61: new 460	java/io/FileOutputStream
    //   64: dup
    //   65: aload 8
    //   67: invokespecial 461	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   70: invokespecial 464	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   73: astore 5
    //   75: aload 5
    //   77: aload_1
    //   78: invokevirtual 468	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   81: aload 5
    //   83: invokevirtual 471	java/io/ObjectOutputStream:flush	()V
    //   86: new 126	java/io/File
    //   89: dup
    //   90: aload_0
    //   91: invokespecial 147	java/io/File:<init>	(Ljava/lang/String;)V
    //   94: astore 11
    //   96: aload 11
    //   98: invokevirtual 209	java/io/File:exists	()Z
    //   101: ifeq +9 -> 110
    //   104: aload 11
    //   106: invokevirtual 456	java/io/File:delete	()Z
    //   109: pop
    //   110: aload 9
    //   112: aload 11
    //   114: invokevirtual 163	java/io/File:renameTo	(Ljava/io/File;)Z
    //   117: pop
    //   118: aload 5
    //   120: invokestatic 476	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   123: aload_2
    //   124: ifnull +7 -> 131
    //   127: aload_2
    //   128: invokevirtual 479	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   131: return
    //   132: astore 7
    //   134: aload_3
    //   135: invokestatic 476	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   138: aload_2
    //   139: ifnull -8 -> 131
    //   142: aload_2
    //   143: invokevirtual 479	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   146: return
    //   147: astore 4
    //   149: aconst_null
    //   150: astore 5
    //   152: aload 4
    //   154: astore 6
    //   156: aload 5
    //   158: invokestatic 476	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   161: aload_2
    //   162: ifnull +7 -> 169
    //   165: aload_2
    //   166: invokevirtual 479	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   169: aload 6
    //   171: athrow
    //   172: astore 6
    //   174: goto -18 -> 156
    //   177: astore 10
    //   179: aload 5
    //   181: astore_3
    //   182: goto -48 -> 134
    //
    // Exception table:
    //   from	to	target	type
    //   6	10	132	java/io/IOException
    //   10	57	132	java/io/IOException
    //   57	75	132	java/io/IOException
    //   6	10	147	finally
    //   10	57	147	finally
    //   57	75	147	finally
    //   75	110	172	finally
    //   110	118	172	finally
    //   75	110	177	java/io/IOException
    //   110	118	177	java/io/IOException
  }

  public static void a(String paramString, ReentrantLock paramReentrantLock)
  {
    if (paramReentrantLock != null)
      paramReentrantLock.lock();
    File localFile = new File(paramString);
    if (localFile.exists())
      localFile.delete();
    if (paramReentrantLock != null)
      paramReentrantLock.unlock();
  }

  public static boolean a(Uri paramUri)
  {
    return "com.android.externalstorage.documents".equals(paramUri.getAuthority());
  }

  public static boolean a(Uri paramUri1, Uri paramUri2)
  {
    if ((paramUri1 == null) || (paramUri2 == null));
    File localFile1;
    do
    {
      return false;
      localFile1 = new File(paramUri1.getPath());
    }
    while (!localFile1.exists());
    File localFile2 = new File(paramUri2.getPath());
    try
    {
      if (!localFile2.exists())
        localFile2.createNewFile();
      boolean bool = bj.a(localFile1, localFile2);
      return bool;
    }
    catch (IOException localIOException)
    {
      a.a(localIOException, "copyFile srcFile:" + paramUri1 + " dstUri:" + paramUri2);
    }
    return false;
  }

  public static boolean a(File paramFile)
  {
    return (paramFile != null) && (paramFile.exists());
  }

  public static boolean a(File paramFile1, File paramFile2)
  {
    boolean bool1 = false;
    if (paramFile1 != null)
    {
      bool1 = false;
      if (paramFile2 != null)
        break label14;
    }
    label14: 
    do
    {
      boolean bool2;
      do
      {
        return bool1;
        bool2 = paramFile1.exists();
        bool1 = false;
      }
      while (!bool2);
      bool1 = paramFile1.renameTo(paramFile2);
    }
    while (bool1);
    try
    {
      bj.a(paramFile1, paramFile2);
      paramFile2.delete();
      return true;
    }
    catch (IOException localIOException)
    {
    }
    return bool1;
  }

  public static boolean a(File paramFile, boolean paramBoolean)
  {
    if (paramFile.exists())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile != null)
      {
        int i = 0;
        if (i < arrayOfFile.length)
        {
          if (arrayOfFile[i].isDirectory())
            a(arrayOfFile[i], paramBoolean);
          while (true)
          {
            i++;
            break;
            arrayOfFile[i].delete();
          }
        }
      }
    }
    boolean bool1;
    if (paramBoolean)
    {
      boolean bool2 = paramFile.delete();
      bool1 = false;
      if (!bool2);
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }

  public static String[] a(String paramString, boolean paramBoolean)
  {
    if (paramString == null)
      return null;
    int i = paramString.lastIndexOf('.');
    if (i > 0)
    {
      String str = paramString.substring(0, i);
      if (paramBoolean);
      while (true)
      {
        return new String[] { str, paramString.substring(i) };
        i++;
      }
    }
    return null;
  }

  public static long b(File paramFile)
  {
    long l = 0L;
    if ((paramFile.exists()) && (paramFile.isDirectory()))
    {
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile != null)
        for (int i = 0; i < arrayOfFile.length; i++)
          l += arrayOfFile[i].length();
    }
    return l;
  }

  public static a b(long paramLong)
  {
    if (paramLong == 0L)
      return a.d;
    if (paramLong > 209715200L)
      return a.c;
    if (paramLong > 52428800L)
      return a.b;
    return a.a;
  }

  public static File b(Context paramContext)
  {
    return dv.e.a(paramContext);
  }

  public static File b(Context paramContext, String paramString)
  {
    try
    {
      File localFile2 = paramContext.getExternalFilesDir(paramString);
      localFile1 = localFile2;
      if (localFile1 == null)
        localFile1 = new File(new File(Environment.getExternalStorageDirectory(), "Android/data/" + paramContext.getPackageName() + "/files"), paramString);
      return localFile1;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        File localFile1 = null;
    }
  }

  private static File b(File paramFile, String paramString1, String paramString2)
  {
    try
    {
      File localFile = File.createTempFile(paramString1, paramString2, paramFile);
      if (localFile != null)
        return localFile;
    }
    catch (IOException localIOException)
    {
      a.a(localIOException, "pickUniqueTempFile ");
      return a(paramFile, paramString1, paramString2);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label17;
    }
    catch (SecurityException localSecurityException)
    {
      label17: break label17;
    }
  }

  public static File b(File paramFile, String paramString, boolean paramBoolean)
  {
    String str1 = l(paramString);
    String[] arrayOfString = a(str1, true);
    if (arrayOfString == null);
    for (String str2 = ""; paramBoolean; str2 = arrayOfString[1])
    {
      return b(paramFile, str1, str2);
      str1 = arrayOfString[0];
    }
    return a(paramFile, str1, str2);
  }

  // ERROR //
  public static Object b(String paramString, ReentrantLock paramReentrantLock)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: invokevirtual 451	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   8: new 126	java/io/File
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 147	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: astore_2
    //   17: aload_2
    //   18: invokevirtual 209	java/io/File:exists	()Z
    //   21: ifeq +211 -> 232
    //   24: new 590	java/io/ObjectInputStream
    //   27: dup
    //   28: new 592	java/io/FileInputStream
    //   31: dup
    //   32: aload_2
    //   33: invokespecial 595	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   36: invokespecial 598	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   39: astore 5
    //   41: aload 5
    //   43: invokevirtual 601	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   46: astore 15
    //   48: aload 15
    //   50: astore 10
    //   52: aload 5
    //   54: ifnull +8 -> 62
    //   57: aload 5
    //   59: invokevirtual 604	java/io/ObjectInputStream:close	()V
    //   62: aload_1
    //   63: ifnull +7 -> 70
    //   66: aload_1
    //   67: invokevirtual 479	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   70: aload 10
    //   72: areturn
    //   73: astore 14
    //   75: aload_1
    //   76: ifnull -14 -> 62
    //   79: aload_1
    //   80: invokevirtual 479	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   83: goto -21 -> 62
    //   86: astore 9
    //   88: aconst_null
    //   89: astore 5
    //   91: aload 5
    //   93: ifnull +8 -> 101
    //   96: aload 5
    //   98: invokevirtual 604	java/io/ObjectInputStream:close	()V
    //   101: aconst_null
    //   102: astore 10
    //   104: aload_1
    //   105: ifnull -35 -> 70
    //   108: aload_1
    //   109: invokevirtual 479	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   112: aconst_null
    //   113: areturn
    //   114: astore 11
    //   116: aload_1
    //   117: ifnull -16 -> 101
    //   120: aload_1
    //   121: invokevirtual 479	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   124: goto -23 -> 101
    //   127: astore 7
    //   129: aconst_null
    //   130: astore 5
    //   132: aload 7
    //   134: astore 8
    //   136: new 606	java/lang/RuntimeException
    //   139: dup
    //   140: new 199	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 608
    //   150: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload 8
    //   155: invokevirtual 611	java/lang/ClassNotFoundException:getMessage	()Ljava/lang/String;
    //   158: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokespecial 612	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   167: athrow
    //   168: astore 4
    //   170: aload 5
    //   172: ifnull +8 -> 180
    //   175: aload 5
    //   177: invokevirtual 604	java/io/ObjectInputStream:close	()V
    //   180: aload_1
    //   181: ifnull +7 -> 188
    //   184: aload_1
    //   185: invokevirtual 479	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   188: aload 4
    //   190: athrow
    //   191: astore 6
    //   193: aload_1
    //   194: ifnull -14 -> 180
    //   197: aload_1
    //   198: invokevirtual 479	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   201: goto -21 -> 180
    //   204: astore 13
    //   206: aconst_null
    //   207: astore 10
    //   209: goto -157 -> 52
    //   212: astore_3
    //   213: aload_3
    //   214: astore 4
    //   216: aconst_null
    //   217: astore 5
    //   219: goto -49 -> 170
    //   222: astore 8
    //   224: goto -88 -> 136
    //   227: astore 12
    //   229: goto -138 -> 91
    //   232: aconst_null
    //   233: astore 10
    //   235: aconst_null
    //   236: astore 5
    //   238: goto -186 -> 52
    //
    // Exception table:
    //   from	to	target	type
    //   57	62	73	java/io/IOException
    //   4	8	86	java/io/IOException
    //   8	41	86	java/io/IOException
    //   96	101	114	java/io/IOException
    //   4	8	127	java/lang/ClassNotFoundException
    //   8	41	127	java/lang/ClassNotFoundException
    //   41	48	168	finally
    //   136	168	168	finally
    //   175	180	191	java/io/IOException
    //   41	48	204	java/io/EOFException
    //   4	8	212	finally
    //   8	41	212	finally
    //   41	48	222	java/lang/ClassNotFoundException
    //   41	48	227	java/io/IOException
  }

  @SuppressLint({"NewApi"})
  public static String b(Context paramContext, Uri paramUri)
  {
    if (paramUri == null);
    while (true)
    {
      return null;
      if ((a.d()) && (DocumentsContract.isDocumentUri(paramContext, paramUri)))
      {
        if (a(paramUri))
        {
          String[] arrayOfString3 = DocumentsContract.getDocumentId(paramUri).split(":");
          if ("primary".equalsIgnoreCase(arrayOfString3[0]))
            return Environment.getExternalStorageDirectory() + "/" + arrayOfString3[1];
        }
        else if (!b(paramUri));
      }
      else
        try
        {
          String str2 = DocumentsContract.getDocumentId(paramUri);
          String str3 = a(paramContext, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(str2).longValue()), null, null);
          return str3;
          if (c(paramUri))
          {
            String[] arrayOfString1 = DocumentsContract.getDocumentId(paramUri).split(":");
            String str1 = arrayOfString1[0];
            Uri localUri;
            if ("image".equals(str1))
              localUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            while (true)
            {
              String[] arrayOfString2 = new String[1];
              arrayOfString2[0] = arrayOfString1[1];
              return a(paramContext, localUri, "_id=?", arrayOfString2);
              if ("video".equals(str1))
              {
                localUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
              }
              else
              {
                boolean bool = "audio".equals(str1);
                localUri = null;
                if (bool)
                  localUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
              }
            }
            if ("content".equalsIgnoreCase(paramUri.getScheme()))
            {
              if (d(paramUri))
                return paramUri.getLastPathSegment();
              return a(paramContext, paramUri, null, null);
            }
            if (("file".equalsIgnoreCase(paramUri.getScheme())) || (new File(paramUri.getPath()).exists()))
              return paramUri.getPath();
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
        }
    }
    return null;
  }

  public static void b()
  {
  }

  public static boolean b(Uri paramUri)
  {
    return "com.android.providers.downloads.documents".equals(paramUri.getAuthority());
  }

  public static boolean b(Uri paramUri1, Uri paramUri2)
  {
    if ((paramUri1 == null) || (paramUri2 == null));
    File localFile;
    do
    {
      return false;
      localFile = new File(paramUri1.getPath());
    }
    while (!localFile.exists());
    return a(localFile, new File(paramUri2.getPath()));
  }

  public static boolean b(String paramString)
  {
    return d(ViberApplication.getApplication(), paramString);
  }

  // ERROR //
  public static long c(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokevirtual 296	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   6: aload_1
    //   7: invokevirtual 711	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   10: astore_2
    //   11: aload_2
    //   12: invokevirtual 716	java/io/InputStream:available	()I
    //   15: istore 5
    //   17: iload 5
    //   19: i2l
    //   20: lstore 6
    //   22: aload_2
    //   23: invokestatic 476	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   26: lload 6
    //   28: lreturn
    //   29: astore 4
    //   31: aload_2
    //   32: invokestatic 476	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   35: lconst_0
    //   36: lreturn
    //   37: astore_3
    //   38: aload_2
    //   39: invokestatic 476	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   42: aload_3
    //   43: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   2	17	29	java/lang/Exception
    //   2	17	37	finally
  }

  public static long c(String paramString)
  {
    return new File(paramString).length();
  }

  public static File c(Context paramContext, String paramString)
  {
    if (a.g());
    while (true)
    {
      try
      {
        File[] arrayOfFile = paramContext.getExternalMediaDirs();
        if ((arrayOfFile != null) && (arrayOfFile.length > 0))
        {
          localFile1 = new File(arrayOfFile[0], paramString);
          if (localFile1 == null)
          {
            if (a.g())
            {
              localFile2 = new File(Environment.getExternalStorageDirectory(), "Android/media/" + paramContext.getPackageName());
              localFile1 = new File(localFile2, paramString);
            }
          }
          else
            return localFile1;
        }
        else
        {
          localFile1 = null;
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        localFile1 = null;
        continue;
        File localFile2 = Environment.getExternalStorageDirectory();
        continue;
      }
      File localFile1 = null;
    }
  }

  private static Pattern c()
  {
    if (b == null)
      b = Pattern.compile("^[a-zA-Z0-9_]+$");
    return b;
  }

  public static boolean c(Uri paramUri)
  {
    return "com.android.providers.media.documents".equals(paramUri.getAuthority());
  }

  public static boolean c(File paramFile)
  {
    if (paramFile == null);
    while (paramFile.exists())
      return false;
    return paramFile.mkdirs();
  }

  public static String d(String paramString)
  {
    String[] arrayOfString = a(paramString, false);
    if (arrayOfString == null)
      return "";
    return arrayOfString[1];
  }

  private static HashSet<String> d()
  {
    if (d == null)
      d = new HashSet(Arrays.asList(new String[] { "3G2A", "3GE6", "3GE7", "3GG6", "3GP1", "3GP2", "3GP3", "3GP4", "3GP5", "3GP6", "3GR6", "3GS6", "3GS7", "AVC1", "F4V", "F4P", "F4A", "F4B", "FACE", "ISO2", "ISOM", "MMP4", "MP41", "MP42", "MSNV", "MSNV", "NDSC", "NDSH", "NDSM", "NDSP", "NDSS", "NDXC", "NDXH", "NDXM", "NDXP", "NDXS", "M4V" }));
    return d;
  }

  public static boolean d(Context paramContext, Uri paramUri)
  {
    boolean bool1 = false;
    boolean bool2;
    if (paramUri != null)
    {
      bool2 = j.a(paramUri);
      File localFile1 = new File(paramUri.getPath());
      if (!localFile1.exists())
        break label66;
      bool1 = f(localFile1);
    }
    while (true)
    {
      if ((bool1) && (!dk.b(paramUri)) && (!bool2));
      try
      {
        paramContext.getContentResolver().delete(paramUri, null, null);
        return bool1;
        label66: bool1 = false;
        if (!bool2)
        {
          File localFile2 = a(paramContext, paramUri);
          bool1 = false;
          if (localFile2 != null)
          {
            boolean bool3 = localFile2.exists();
            bool1 = false;
            if (bool3)
              bool1 = f(localFile2);
          }
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        a.a(localIllegalArgumentException, "Unable to delete temp image from database.");
        return bool1;
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        a.a(localUnsupportedOperationException, "ImageUtils.deleteFile, deletion unsupported, media: " + paramUri);
      }
    }
    return bool1;
  }

  public static boolean d(Context paramContext, String paramString)
  {
    if (!da.a(paramString))
      return a(a(paramContext, Uri.parse(paramString)));
    return false;
  }

  public static boolean d(Uri paramUri)
  {
    return "com.google.android.apps.photos.content".equals(paramUri.getAuthority());
  }

  public static boolean d(File paramFile)
  {
    return (paramFile != null) && (c(paramFile.getParentFile()));
  }

  // ERROR //
  public static String e(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +27 -> 28
    //   4: new 126	java/io/File
    //   7: dup
    //   8: aload_1
    //   9: invokevirtual 143	android/net/Uri:getPath	()Ljava/lang/String;
    //   12: invokespecial 147	java/io/File:<init>	(Ljava/lang/String;)V
    //   15: astore_2
    //   16: aload_2
    //   17: invokevirtual 209	java/io/File:exists	()Z
    //   20: ifeq +8 -> 28
    //   23: aload_2
    //   24: invokevirtual 226	java/io/File:getName	()Ljava/lang/String;
    //   27: areturn
    //   28: aload_1
    //   29: invokestatic 847	com/viber/voip/util/dk:a	(Landroid/net/Uri;)Z
    //   32: ifeq +71 -> 103
    //   35: aload_0
    //   36: invokevirtual 296	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   39: aload_1
    //   40: aconst_null
    //   41: aconst_null
    //   42: aconst_null
    //   43: aconst_null
    //   44: invokevirtual 302	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   47: astore 6
    //   49: aload 6
    //   51: astore 4
    //   53: aload 4
    //   55: invokestatic 850	com/viber/voip/util/af:b	(Landroid/database/Cursor;)Z
    //   58: ifne +40 -> 98
    //   61: aload 4
    //   63: invokeinterface 307 1 0
    //   68: ifeq +30 -> 98
    //   71: aload 4
    //   73: aload 4
    //   75: ldc_w 852
    //   78: invokeinterface 311 2 0
    //   83: invokeinterface 315 2 0
    //   88: astore 7
    //   90: aload 4
    //   92: invokestatic 320	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   95: aload 7
    //   97: areturn
    //   98: aload 4
    //   100: invokestatic 320	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   103: aconst_null
    //   104: areturn
    //   105: astore 5
    //   107: aconst_null
    //   108: astore 4
    //   110: getstatic 23	com/viber/voip/util/at:a	Lcom/viber/dexshared/Logger;
    //   113: aload 5
    //   115: ldc_w 854
    //   118: invokeinterface 505 3 0
    //   123: aload 4
    //   125: invokestatic 320	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   128: goto -25 -> 103
    //   131: astore_3
    //   132: aconst_null
    //   133: astore 4
    //   135: aload 4
    //   137: invokestatic 320	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   140: aload_3
    //   141: athrow
    //   142: astore_3
    //   143: goto -8 -> 135
    //   146: astore 5
    //   148: goto -38 -> 110
    //
    // Exception table:
    //   from	to	target	type
    //   35	49	105	java/lang/Exception
    //   35	49	131	finally
    //   53	90	142	finally
    //   110	123	142	finally
    //   53	90	146	java/lang/Exception
  }

  public static String e(Uri paramUri)
  {
    return MimeTypeMap.getSingleton().getExtensionFromMimeType(h(ViberApplication.getApplication(), paramUri));
  }

  public static String e(String paramString)
  {
    String str1 = MimeTypeMap.getFileExtensionFromUrl(paramString.replace(" ", "")).toLowerCase(Locale.getDefault());
    boolean bool = MimeTypeMap.getSingleton().hasExtension(str1);
    String str2 = null;
    if (bool)
      str2 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str1);
    return str2;
  }

  public static boolean e(File paramFile)
  {
    File localFile = new File(paramFile, ".nomedia");
    boolean bool1 = localFile.exists();
    boolean bool2 = false;
    if (!bool1);
    try
    {
      boolean bool3 = paramFile.exists();
      if (!bool3)
        bool3 = paramFile.mkdirs();
      bool2 = false;
      if (bool3)
      {
        boolean bool4 = localFile.createNewFile();
        bool2 = false;
        if (bool4)
          bool2 = true;
      }
      return bool2;
    }
    catch (IOException localIOException)
    {
    }
    return false;
  }

  public static long f(String paramString)
  {
    try
    {
      StatFs localStatFs = new StatFs(paramString);
      localStatFs.restat(paramString);
      long l = localStatFs.getAvailableBlocks();
      int i = localStatFs.getBlockSize();
      return l * i;
    }
    catch (Exception localException)
    {
    }
    return -1L;
  }

  // ERROR //
  public static Uri f(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 296	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: aload_1
    //   5: ldc_w 907
    //   8: invokevirtual 911	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   11: astore 9
    //   13: aload 9
    //   15: astore_3
    //   16: aload_3
    //   17: ifnull +99 -> 116
    //   20: aload_3
    //   21: invokevirtual 917	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   24: astore 12
    //   26: aload_0
    //   27: aload_1
    //   28: invokestatic 919	com/viber/voip/util/at:e	(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;
    //   31: astore 13
    //   33: aload_0
    //   34: invokestatic 921	com/viber/voip/util/at:b	(Landroid/content/Context;)Ljava/io/File;
    //   37: astore 14
    //   39: aload 14
    //   41: invokevirtual 209	java/io/File:exists	()Z
    //   44: ifne +9 -> 53
    //   47: aload 14
    //   49: invokevirtual 223	java/io/File:mkdirs	()Z
    //   52: pop
    //   53: aload 13
    //   55: ifnull +55 -> 110
    //   58: new 126	java/io/File
    //   61: dup
    //   62: aload_0
    //   63: invokestatic 921	com/viber/voip/util/at:b	(Landroid/content/Context;)Ljava/io/File;
    //   66: aload 13
    //   68: invokespecial 196	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   71: astore 15
    //   73: aload 15
    //   75: ifnull +41 -> 116
    //   78: aload 12
    //   80: aload 15
    //   82: invokestatic 924	com/viber/voip/util/bj:a	(Ljava/io/FileDescriptor;Ljava/io/File;)Z
    //   85: ifeq +31 -> 116
    //   88: aload 15
    //   90: invokestatic 397	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   93: astore 16
    //   95: aload 16
    //   97: astore 7
    //   99: aload_3
    //   100: ifnull +7 -> 107
    //   103: aload_3
    //   104: invokevirtual 925	android/os/ParcelFileDescriptor:close	()V
    //   107: aload 7
    //   109: areturn
    //   110: aconst_null
    //   111: astore 15
    //   113: goto -40 -> 73
    //   116: aconst_null
    //   117: astore 7
    //   119: aload_3
    //   120: ifnull -13 -> 107
    //   123: aload_3
    //   124: invokevirtual 925	android/os/ParcelFileDescriptor:close	()V
    //   127: aconst_null
    //   128: areturn
    //   129: astore 10
    //   131: aconst_null
    //   132: areturn
    //   133: astore 6
    //   135: aconst_null
    //   136: astore_3
    //   137: aconst_null
    //   138: astore 7
    //   140: aload_3
    //   141: ifnull -34 -> 107
    //   144: aload_3
    //   145: invokevirtual 925	android/os/ParcelFileDescriptor:close	()V
    //   148: aconst_null
    //   149: areturn
    //   150: astore 8
    //   152: aconst_null
    //   153: areturn
    //   154: astore_2
    //   155: aconst_null
    //   156: astore_3
    //   157: aload_2
    //   158: astore 4
    //   160: aload_3
    //   161: ifnull +7 -> 168
    //   164: aload_3
    //   165: invokevirtual 925	android/os/ParcelFileDescriptor:close	()V
    //   168: aload 4
    //   170: athrow
    //   171: astore 17
    //   173: aload 7
    //   175: areturn
    //   176: astore 5
    //   178: goto -10 -> 168
    //   181: astore 4
    //   183: goto -23 -> 160
    //   186: astore 11
    //   188: goto -51 -> 137
    //
    // Exception table:
    //   from	to	target	type
    //   123	127	129	java/io/IOException
    //   0	13	133	java/lang/Exception
    //   144	148	150	java/io/IOException
    //   0	13	154	finally
    //   103	107	171	java/io/IOException
    //   164	168	176	java/io/IOException
    //   20	53	181	finally
    //   58	73	181	finally
    //   78	95	181	finally
    //   20	53	186	java/lang/Exception
    //   58	73	186	java/lang/Exception
    //   78	95	186	java/lang/Exception
  }

  public static boolean f(File paramFile)
  {
    boolean bool1 = false;
    if (paramFile == null);
    boolean bool2;
    String str;
    do
    {
      Application localApplication;
      boolean bool4;
      do
      {
        boolean bool3;
        do
        {
          return bool1;
          long l = paramFile.length();
          localApplication = ViberApplication.getApplication();
          if (l == 0L)
            break;
          bool3 = dv.a(paramFile, dv.a, localApplication);
          bool1 = false;
        }
        while (bool3);
        bool4 = dv.a(paramFile, dv.b, localApplication);
        bool1 = false;
      }
      while (bool4);
      bool2 = dv.a(paramFile, dv.g, localApplication);
      str = paramFile.getPath();
      bool1 = paramFile.delete();
    }
    while ((!bool1) || (!bool2));
    com.viber.voip.util.upload.o.b(str);
    return bool1;
  }

  @SuppressLint({"DefaultLocale"})
  public static String[] f(Uri paramUri)
  {
    if ((paramUri == null) || (paramUri.getPath() == null))
      return null;
    String str1 = MimeTypeMap.getFileExtensionFromUrl(paramUri.toString()).toLowerCase(Locale.getDefault());
    boolean bool = MimeTypeMap.getSingleton().hasExtension(str1);
    String str2 = null;
    if (bool)
      str2 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str1);
    if (str2 == null)
      str2 = h(ViberApplication.getApplication(), paramUri);
    if (("image/webp".equals(str2)) && (da.a(str1)))
      str1 = "webp";
    return new String[] { str2, str1 };
  }

  public static File g(File paramFile)
  {
    if (paramFile == null)
      return null;
    String str = as.i.a(paramFile.getName());
    return a(paramFile.getParentFile(), str, false);
  }

  public static String g(Uri paramUri)
  {
    int i = 0;
    String[] arrayOfString1 = f(paramUri);
    if (arrayOfString1 != null)
    {
      String str1 = arrayOfString1[0];
      String str2 = arrayOfString1[1];
      if (str1 != null)
      {
        if ("image/webp".equals(str1))
          return "image";
        if ("image/gif".equals(str1))
          return "image/gif";
        if (str1.startsWith("image"))
        {
          if (da.a(str2))
            return "image";
          String[] arrayOfString2 = k.c;
          int j = arrayOfString2.length;
          while (i < j)
          {
            if (arrayOfString2[i].equals(str2.toLowerCase()))
              return "image";
            i++;
          }
        }
        if (str1.startsWith("video"))
          return "video";
        if (str1.startsWith("sound"))
          return "sound";
      }
    }
    return "file";
  }

  public static boolean g(Context paramContext, Uri paramUri)
  {
    boolean bool1 = true;
    if (paramUri == null)
      return false;
    File localFile = a(paramContext);
    boolean bool2;
    if (!paramUri.getPath().startsWith(localFile.getPath()))
      bool2 = bool1;
    try
    {
      boolean bool3 = k(a(paramContext, paramUri));
      if (!bool3);
      while (true)
      {
        bool2 &= bool1;
        label51: return bool2;
        bool2 = false;
        break;
        bool1 = false;
      }
    }
    catch (IOException localIOException)
    {
      break label51;
    }
  }

  public static String[] g(String paramString)
  {
    File localFile = new File(paramString);
    if (localFile.isDirectory())
    {
      String[] arrayOfString = localFile.list();
      if (arrayOfString != null)
        return arrayOfString;
    }
    return new String[0];
  }

  private static String h(Context paramContext, Uri paramUri)
  {
    ContentResolver localContentResolver = paramContext.getContentResolver();
    String str1;
    try
    {
      String str2 = localContentResolver.getType(paramUri);
      str1 = str2;
      if (str1 == null)
        return null;
    }
    catch (Exception localException)
    {
      while (true)
        str1 = null;
      if (str1.startsWith("video"))
        return "video";
      if (str1.startsWith("sound"))
        return "sound";
    }
    return str1;
  }

  public static boolean h(File paramFile)
  {
    return a(paramFile, true);
  }

  public static boolean h(String paramString)
  {
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramString);
      byte[] arrayOfByte = new byte[24];
      int i = localFileInputStream.read(arrayOfByte);
      localFileInputStream.close();
      if (i < arrayOfByte.length)
        return false;
      if ((arrayOfByte[0] == 0) && (arrayOfByte[1] == 0) && (arrayOfByte[2] == 0) && ("FTYP".equals(a(arrayOfByte, 4))))
      {
        String str1 = a(arrayOfByte, 8);
        if (d().contains(str1))
        {
          String str2 = a(arrayOfByte, 16);
          boolean bool = d().contains(str2);
          if (bool)
            return true;
        }
      }
    }
    catch (IOException localIOException)
    {
      a.a(localIOException, "isMpeg can't open " + paramString);
    }
    return false;
  }

  public static boolean i(File paramFile)
  {
    for (String str : c)
      if ((paramFile.getName().toLowerCase().endsWith("." + str)) || (paramFile.isDirectory()))
        return false;
    return true;
  }

  public static boolean i(String paramString)
  {
    return c(new File(paramString));
  }

  public static String j(File paramFile)
  {
    String str1 = paramFile.getName();
    int i = str1.lastIndexOf('.');
    if (i > 0)
    {
      String str2 = str1.substring(i + 1);
      if (c().matcher(str2).matches())
        return str2;
      return "/";
    }
    return "/";
  }

  public static boolean j(String paramString)
  {
    return e(new File(paramString));
  }

  private static boolean k(File paramFile)
    throws IOException
  {
    if (paramFile == null)
      return false;
    if (paramFile.getParent() == null)
      if (paramFile.getCanonicalFile().equals(paramFile.getAbsoluteFile()))
        break label53;
    label53: for (boolean bool = true; ; bool = false)
    {
      return bool;
      paramFile = new File(paramFile.getParentFile().getCanonicalFile(), paramFile.getName());
      break;
    }
  }

  public static boolean k(String paramString)
  {
    if ((paramString != null) && (new File(paramString).delete()))
    {
      com.viber.voip.util.upload.o.b(paramString);
      return true;
    }
    return false;
  }

  public static String l(String paramString)
  {
    return paramString.replaceAll("([;:\\\\\\/])", "_");
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[4];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
    }
  }

  public static abstract interface b
  {
    public abstract void a(Map<String, Boolean> paramMap);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.at
 * JD-Core Version:    0.6.2
 */