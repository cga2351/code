package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;

public final class zzcfm
{
  private final Clock zzbsb;

  public zzcfm(Clock paramClock)
  {
    this.zzbsb = paramClock;
  }

  public final void zza(List<Object> paramList, String paramString1, String paramString2, Object[] paramArrayOfObject)
  {
    zzaci localzzaci = zzact.zzcqh;
    if (!((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
      return;
    long l = this.zzbsb.currentTimeMillis();
    StringWriter localStringWriter = new StringWriter();
    JsonWriter localJsonWriter = new JsonWriter(localStringWriter);
    try
    {
      localJsonWriter.beginObject();
      localJsonWriter.name("timestamp").value(l);
      localJsonWriter.name("source").value(paramString1);
      localJsonWriter.name("event").value(paramString2);
      localJsonWriter.name("components").beginArray();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
        localJsonWriter.value(localIterator.next().toString());
    }
    catch (IOException localIOException)
    {
      zzaxa.zzc("unable to log", localIOException);
    }
    String str1 = String.valueOf(localStringWriter.toString());
    String str2;
    label181: int j;
    label212: Object localObject;
    if (str1.length() != 0)
    {
      str2 = "AD-DBG ".concat(str1);
      zzaxa.zzeo(str2);
      return;
      localJsonWriter.endArray();
      localJsonWriter.name("params").beginArray();
      int i = paramArrayOfObject.length;
      j = 0;
      if (j < i)
      {
        localObject = paramArrayOfObject[j];
        if (localObject == null)
          break label291;
      }
    }
    label291: for (String str3 = localObject.toString(); ; str3 = null)
    {
      localJsonWriter.value(str3);
      j++;
      break label212;
      localJsonWriter.endArray();
      localJsonWriter.endObject();
      localJsonWriter.flush();
      localJsonWriter.close();
      break;
      str2 = new String("AD-DBG ");
      break label181;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcfm
 * JD-Core Version:    0.6.2
 */