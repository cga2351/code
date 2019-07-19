package org.onepf.oms.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.Iterator;
import java.util.Set;

public final class Utils
{
  private static final Logger L = ViberEnv.getLogger();

  // ERROR //
  public static String getStringFromInputStream(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 25	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   9: astore_2
    //   10: new 28	java/io/BufferedReader
    //   13: dup
    //   14: new 30	java/io/InputStreamReader
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 33	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   22: invokespecial 36	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   25: astore_3
    //   26: aload_3
    //   27: invokevirtual 40	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   30: astore 8
    //   32: aload 8
    //   34: ifnull +33 -> 67
    //   37: aload_2
    //   38: aload 8
    //   40: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: goto -18 -> 26
    //   47: astore 6
    //   49: aload 6
    //   51: invokevirtual 47	java/io/IOException:printStackTrace	()V
    //   54: aload_3
    //   55: ifnull +7 -> 62
    //   58: aload_3
    //   59: invokevirtual 50	java/io/BufferedReader:close	()V
    //   62: aload_2
    //   63: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: areturn
    //   67: aload_3
    //   68: ifnull -6 -> 62
    //   71: aload_3
    //   72: invokevirtual 50	java/io/BufferedReader:close	()V
    //   75: goto -13 -> 62
    //   78: astore 10
    //   80: aload 10
    //   82: invokevirtual 47	java/io/IOException:printStackTrace	()V
    //   85: goto -23 -> 62
    //   88: astore 7
    //   90: aload 7
    //   92: invokevirtual 47	java/io/IOException:printStackTrace	()V
    //   95: goto -33 -> 62
    //   98: astore 4
    //   100: aload_1
    //   101: ifnull +7 -> 108
    //   104: aload_1
    //   105: invokevirtual 50	java/io/BufferedReader:close	()V
    //   108: aload 4
    //   110: athrow
    //   111: astore 5
    //   113: aload 5
    //   115: invokevirtual 47	java/io/IOException:printStackTrace	()V
    //   118: goto -10 -> 108
    //   121: astore 4
    //   123: aload_3
    //   124: astore_1
    //   125: goto -25 -> 100
    //   128: astore 6
    //   130: aconst_null
    //   131: astore_3
    //   132: goto -83 -> 49
    //
    // Exception table:
    //   from	to	target	type
    //   26	32	47	java/io/IOException
    //   37	44	47	java/io/IOException
    //   71	75	78	java/io/IOException
    //   58	62	88	java/io/IOException
    //   10	26	98	finally
    //   104	108	111	java/io/IOException
    //   26	32	121	finally
    //   37	44	121	finally
    //   49	54	121	finally
    //   10	26	128	java/io/IOException
  }

  public static boolean hasRequestedPermission(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException("Permission can't be null or empty.");
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 4096);
      boolean bool1 = CollectionUtils.isEmpty(localPackageInfo.requestedPermissions);
      boolean bool2 = false;
      String[] arrayOfString;
      int i;
      if (!bool1)
      {
        arrayOfString = localPackageInfo.requestedPermissions;
        i = arrayOfString.length;
      }
      for (int j = 0; ; j++)
      {
        bool2 = false;
        if (j < i)
        {
          boolean bool3 = paramString.equals(arrayOfString[j]);
          if (bool3)
            bool2 = true;
        }
        else
        {
          return bool2;
        }
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return false;
  }

  public static String intentToString(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      Bundle localBundle = paramIntent.getExtras();
      if (localBundle != null)
      {
        Iterator localIterator = localBundle.keySet().iterator();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Intent:{");
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localStringBuilder.append("[" + str + "=" + localBundle.get(str) + "]");
        }
        localStringBuilder.append("}");
        return localStringBuilder.toString();
      }
    }
    return null;
  }

  public static boolean isPackageInstaller(Context paramContext, String paramString)
  {
    return TextUtils.equals(paramContext.getPackageManager().getInstallerPackageName(paramContext.getPackageName()), paramString);
  }

  public static boolean packageInstalled(Context paramContext, String paramString)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      localPackageManager.getPackageInfo(paramString, 1);
      return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return false;
  }

  public static boolean uiThread()
  {
    return Thread.currentThread() == Looper.getMainLooper().getThread();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.onepf.oms.util.Utils
 * JD-Core Version:    0.6.2
 */