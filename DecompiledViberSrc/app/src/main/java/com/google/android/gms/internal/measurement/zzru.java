package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class zzru
{
  public static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
  private static final Uri zzbqp = Uri.parse("content://com.google.android.gsf.gservices/prefix");
  public static final Pattern zzbqq = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
  public static final Pattern zzbqr = Pattern.compile("^(0|false|f|off|no|n)$", 2);
  private static final AtomicBoolean zzbqs = new AtomicBoolean();
  private static HashMap<String, String> zzbqt;
  private static final HashMap<String, Boolean> zzbqu = new HashMap();
  private static final HashMap<String, Integer> zzbqv = new HashMap();
  private static final HashMap<String, Long> zzbqw = new HashMap();
  private static final HashMap<String, Float> zzbqx = new HashMap();
  private static Object zzbqy;
  private static boolean zzbqz;
  private static String[] zzbra = new String[0];

  public static String zza(ContentResolver paramContentResolver, String paramString1, String paramString2)
  {
    while (true)
    {
      Object localObject2;
      int j;
      try
      {
        zza(paramContentResolver);
        localObject2 = zzbqy;
        if (zzbqt.containsKey(paramString1))
        {
          String str4 = (String)zzbqt.get(paramString1);
          String str5 = null;
          if (str4 != null)
            str5 = str4;
          return str5;
        }
        String[] arrayOfString1 = zzbra;
        int i = arrayOfString1.length;
        j = 0;
        if (j >= i)
          break label171;
        if (!paramString1.startsWith(arrayOfString1[j]))
          break label332;
        if ((!zzbqz) || (zzbqt.isEmpty()))
        {
          String[] arrayOfString2 = zzbra;
          zzbqt.putAll(zza(paramContentResolver, arrayOfString2));
          zzbqz = true;
          if (zzbqt.containsKey(paramString1))
          {
            String str1 = (String)zzbqt.get(paramString1);
            String str2 = null;
            if (str1 != null)
              str2 = str1;
            return str2;
          }
        }
      }
      finally
      {
      }
      return null;
      label171: Cursor localCursor = paramContentResolver.query(CONTENT_URI, null, null, new String[] { paramString1 }, null);
      Object localObject3;
      if (localCursor == null)
      {
        localObject3 = null;
        if (localCursor != null)
        {
          localCursor.close();
          return null;
        }
      }
      else
      {
        try
        {
          if (!localCursor.moveToFirst())
          {
            zza(localObject2, paramString1, null);
            localObject3 = null;
            return null;
          }
          String str3 = localCursor.getString(1);
          if ((str3 != null) && (str3.equals(null)))
            str3 = null;
          zza(localObject2, paramString1, str3);
          localObject3 = null;
          if (str3 != null)
            localObject3 = str3;
          return localObject3;
        }
        finally
        {
          if (localCursor != null)
            localCursor.close();
        }
      }
      return localObject3;
      label332: j++;
    }
  }

  private static Map<String, String> zza(ContentResolver paramContentResolver, String[] paramArrayOfString)
  {
    Cursor localCursor = paramContentResolver.query(zzbqp, null, null, paramArrayOfString, null);
    TreeMap localTreeMap = new TreeMap();
    if (localCursor == null)
      return localTreeMap;
    try
    {
      if (localCursor.moveToNext())
        localTreeMap.put(localCursor.getString(0), localCursor.getString(1));
    }
    finally
    {
      localCursor.close();
    }
    return localTreeMap;
  }

  private static void zza(ContentResolver paramContentResolver)
  {
    if (zzbqt == null)
    {
      zzbqs.set(false);
      zzbqt = new HashMap();
      zzbqy = new Object();
      zzbqz = false;
      paramContentResolver.registerContentObserver(CONTENT_URI, true, new zzrv(null));
    }
    while (!zzbqs.getAndSet(false))
      return;
    zzbqt.clear();
    zzbqu.clear();
    zzbqv.clear();
    zzbqw.clear();
    zzbqx.clear();
    zzbqy = new Object();
    zzbqz = false;
  }

  private static void zza(Object paramObject, String paramString1, String paramString2)
  {
    try
    {
      if (paramObject == zzbqy)
        zzbqt.put(paramString1, paramString2);
      return;
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzru
 * JD-Core Version:    0.6.2
 */