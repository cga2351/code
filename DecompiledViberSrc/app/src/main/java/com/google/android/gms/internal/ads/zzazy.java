package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.util.JsonWriter;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import java.io.IOException;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

@zzare
public final class zzazy
{
  private static boolean enabled = false;
  private static Object lock = new Object();
  private static Clock zzbsb = DefaultClock.getInstance();
  private static boolean zzdyx = false;
  private static final Set<String> zzdyy = new HashSet(Arrays.asList(new String[0]));
  private final List<String> zzdyz;

  public zzazy()
  {
    this(null);
  }

  public zzazy(String paramString)
  {
    Object localObject;
    if (!isEnabled())
    {
      localObject = new ArrayList();
      this.zzdyz = ((List)localObject);
      return;
    }
    String str1 = UUID.randomUUID().toString();
    String[] arrayOfString = new String[1];
    String str2 = String.valueOf(str1);
    if (str2.length() != 0);
    for (String str3 = "network_request_".concat(str2); ; str3 = new String("network_request_"))
    {
      arrayOfString[0] = str3;
      localObject = Arrays.asList(arrayOfString);
      break;
    }
  }

  public static boolean isEnabled()
  {
    while (true)
    {
      synchronized (lock)
      {
        if ((zzdyx) && (enabled))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }

  private static void zza(JsonWriter paramJsonWriter, Map<String, ?> paramMap)
    throws IOException
  {
    if (paramMap == null)
      return;
    paramJsonWriter.name("headers").beginArray();
    Iterator localIterator1 = paramMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      String str1 = (String)localEntry.getKey();
      if (!zzdyy.contains(str1))
        if ((localEntry.getValue() instanceof List))
        {
          Iterator localIterator2 = ((List)localEntry.getValue()).iterator();
          while (localIterator2.hasNext())
          {
            String str2 = (String)localIterator2.next();
            paramJsonWriter.beginObject();
            paramJsonWriter.name("name").value(str1);
            paramJsonWriter.name("value").value(str2);
            paramJsonWriter.endObject();
          }
        }
        else if ((localEntry.getValue() instanceof String))
        {
          paramJsonWriter.beginObject();
          paramJsonWriter.name("name").value(str1);
          paramJsonWriter.name("value").value((String)localEntry.getValue());
          paramJsonWriter.endObject();
        }
        else
        {
          zzbae.zzen("Connection headers should be either Map<String, String> or Map<String, List<String>>");
        }
    }
    paramJsonWriter.endArray();
  }

  private final void zza(String paramString, zzbad paramzzbad)
  {
    StringWriter localStringWriter = new StringWriter();
    JsonWriter localJsonWriter = new JsonWriter(localStringWriter);
    try
    {
      localJsonWriter.beginObject();
      localJsonWriter.name("timestamp").value(zzbsb.currentTimeMillis());
      localJsonWriter.name("event").value(paramString);
      localJsonWriter.name("components").beginArray();
      Iterator localIterator = this.zzdyz.iterator();
      while (localIterator.hasNext())
        localJsonWriter.value((String)localIterator.next());
    }
    catch (IOException localIOException)
    {
      zzbae.zzc("unable to log", localIOException);
    }
    while (true)
    {
      zzem(localStringWriter.toString());
      return;
      localJsonWriter.endArray();
      paramzzbad.zzb(localJsonWriter);
      localJsonWriter.endObject();
      localJsonWriter.flush();
      localJsonWriter.close();
    }
  }

  public static void zzal(boolean paramBoolean)
  {
    synchronized (lock)
    {
      zzdyx = true;
      enabled = paramBoolean;
      return;
    }
  }

  private final void zzb(String paramString1, String paramString2, Map<String, ?> paramMap, byte[] paramArrayOfByte)
  {
    zza("onNetworkRequest", new zzazz(paramString1, paramString2, paramMap, paramArrayOfByte));
  }

  private final void zzb(Map<String, ?> paramMap, int paramInt)
  {
    zza("onNetworkResponse", new zzbaa(paramInt, paramMap));
  }

  public static boolean zzbk(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 17)
      return false;
    zzaci localzzaci = zzact.zzcqc;
    if (!((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
      return false;
    try
    {
      int i = Settings.Global.getInt(paramContext.getContentResolver(), "development_settings_enabled", 0);
      return i != 0;
    }
    catch (Exception localException)
    {
      zzbae.zzd("Fail to determine debug setting.", localException);
    }
    return false;
  }

  private final void zzel(String paramString)
  {
    zza("onNetworkRequestError", new zzbac(paramString));
  }

  private static void zzem(String paramString)
  {
    try
    {
      zzbae.zzeo("GMA Debug BEGIN");
      int i = 0;
      if (i < paramString.length())
      {
        String str1 = String.valueOf(paramString.substring(i, Math.min(i + 4000, paramString.length())));
        if (str1.length() != 0);
        for (String str2 = "GMA Debug CONTENT ".concat(str1); ; str2 = new String("GMA Debug CONTENT "))
        {
          zzbae.zzeo(str2);
          i += 4000;
          break;
        }
      }
    }
    finally
    {
    }
    zzbae.zzeo("GMA Debug FINISH");
  }

  public static void zzxa()
  {
    synchronized (lock)
    {
      zzdyx = false;
      enabled = false;
      zzbae.zzep("Ad debug logging enablement is out of date.");
      return;
    }
  }

  public static boolean zzxb()
  {
    synchronized (lock)
    {
      boolean bool = zzdyx;
      return bool;
    }
  }

  public final void zza(String paramString1, String paramString2, Map<String, ?> paramMap, byte[] paramArrayOfByte)
  {
    if (!isEnabled())
      return;
    zzb(paramString1, paramString2, paramMap, paramArrayOfByte);
  }

  public final void zza(HttpURLConnection paramHttpURLConnection, int paramInt)
  {
    if (!isEnabled())
      return;
    Object localObject;
    if (paramHttpURLConnection.getHeaderFields() == null)
      localObject = null;
    String str3;
    String str1;
    while (true)
    {
      zzb((Map)localObject, paramInt);
      if ((paramInt >= 200) && (paramInt < 300))
        break;
      try
      {
        String str4 = paramHttpURLConnection.getResponseMessage();
        str3 = str4;
        zzel(str3);
        return;
        localObject = new HashMap(paramHttpURLConnection.getHeaderFields());
      }
      catch (IOException localIOException)
      {
        str1 = String.valueOf(localIOException.getMessage());
        if (str1.length() == 0);
      }
    }
    for (String str2 = "Can not get error message from error HttpURLConnection\n".concat(str1); ; str2 = new String("Can not get error message from error HttpURLConnection\n"))
    {
      zzbae.zzep(str2);
      str3 = null;
      break;
    }
  }

  public final void zza(HttpURLConnection paramHttpURLConnection, byte[] paramArrayOfByte)
  {
    if (!isEnabled())
      return;
    if (paramHttpURLConnection.getRequestProperties() == null);
    for (Object localObject = null; ; localObject = new HashMap(paramHttpURLConnection.getRequestProperties()))
    {
      zzb(new String(paramHttpURLConnection.getURL().toString()), new String(paramHttpURLConnection.getRequestMethod()), (Map)localObject, paramArrayOfByte);
      return;
    }
  }

  public final void zza(Map<String, ?> paramMap, int paramInt)
  {
    if (!isEnabled());
    do
    {
      return;
      zzb(paramMap, paramInt);
    }
    while ((paramInt >= 200) && (paramInt < 300));
    zzel(null);
  }

  public final void zzek(String paramString)
  {
    if (!isEnabled());
    while (paramString == null)
      return;
    zzj(paramString.getBytes());
  }

  public final void zzj(byte[] paramArrayOfByte)
  {
    zza("onNetworkResponseBody", new zzbab(paramArrayOfByte));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzazy
 * JD-Core Version:    0.6.2
 */