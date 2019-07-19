package com.yandex.metrica.impl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class bw
{
  public static String a(Context paramContext, String paramString)
  {
    return String.valueOf(c(paramContext, paramString));
  }

  public static String a(String paramString, Throwable paramThrowable)
  {
    String str = a(paramThrowable);
    if (!TextUtils.isEmpty(paramString))
      str = paramString + ":\n" + str;
    return str;
  }

  static String a(Throwable paramThrowable)
  {
    String str = "";
    if (paramThrowable != null)
    {
      StringWriter localStringWriter = new StringWriter();
      PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
      paramThrowable.printStackTrace(localPrintWriter);
      str = localStringWriter.toString();
      localPrintWriter.close();
    }
    return str;
  }

  public static List<ResolveInfo> a(Context paramContext, String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Intent localIntent = new Intent(paramString1, null);
      localIntent.addCategory(paramString2);
      List localList = paramContext.getPackageManager().queryIntentActivities(localIntent, 0);
      return localList;
    }
    catch (Exception localException)
    {
    }
    return localArrayList;
  }

  public static <T> List<T> a(List<T> paramList, int paramInt)
  {
    if (paramList.size() > paramInt)
    {
      ArrayList localArrayList = new ArrayList(paramInt);
      for (int i = 0; i < paramInt; i++)
        localArrayList.add(paramList.get(i));
      paramList = localArrayList;
    }
    return paramList;
  }

  public static Set<Integer> a(int[] paramArrayOfInt)
  {
    HashSet localHashSet = new HashSet();
    int i = paramArrayOfInt.length;
    for (int j = 0; j < i; j++)
      localHashSet.add(Integer.valueOf(paramArrayOfInt[j]));
    return localHashSet;
  }

  public static void a(Cursor paramCursor)
  {
    if ((paramCursor != null) && (!paramCursor.isClosed()))
      paramCursor.close();
  }

  public static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramSQLiteDatabase != null);
    try
    {
      paramSQLiteDatabase.endTransaction();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null);
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public static void a(HttpURLConnection paramHttpURLConnection)
  {
    if (paramHttpURLConnection != null);
    try
    {
      paramHttpURLConnection.disconnect();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public static boolean a(int paramInt)
  {
    return Build.VERSION.SDK_INT >= paramInt;
  }

  public static boolean a(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) && (paramObject2 == null))
      return true;
    if ((paramObject1 == null) || (paramObject2 == null))
      return false;
    return paramObject1.equals(paramObject2);
  }

  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!"-1".equals(paramString));
  }

  public static boolean a(Collection paramCollection)
  {
    return (paramCollection == null) || (paramCollection.size() == 0);
  }

  public static boolean a(Map paramMap)
  {
    return (paramMap == null) || (paramMap.size() == 0);
  }

  public static boolean a(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte == null) || (paramArrayOfByte.length == 0);
  }

  public static <T> boolean a(T[] paramArrayOfT)
  {
    return (paramArrayOfT == null) || (paramArrayOfT.length == 0);
  }

  public static String[] a(long[] paramArrayOfLong)
  {
    String[] arrayOfString = new String[paramArrayOfLong.length];
    for (int i = 0; i < paramArrayOfLong.length; i++)
      arrayOfString[i] = String.valueOf(paramArrayOfLong[i]);
    return arrayOfString;
  }

  public static String b(Context paramContext, String paramString)
  {
    try
    {
      String str = paramContext.getPackageManager().getPackageInfo(paramString, 0).versionName;
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return "0.0";
  }

  public static int c(Context paramContext, String paramString)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramString, 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return 0;
  }

  public static PackageInfo d(Context paramContext, String paramString)
  {
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      return localPackageInfo;
    }
    catch (Exception localException)
    {
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.bw
 * JD-Core Version:    0.6.2
 */