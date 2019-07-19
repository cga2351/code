package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

public final class zzcxr
{
  public final List<zzcxl> zzgkt;
  public final zzcxn zzgku;
  public final List<zzcxs> zzgkv;

  private zzcxr(JsonReader paramJsonReader)
    throws IllegalStateException, IOException, JSONException, NumberFormatException
  {
    Object localObject = Collections.emptyList();
    ArrayList localArrayList = new ArrayList();
    paramJsonReader.beginObject();
    zzcxn localzzcxn = null;
    while (paramJsonReader.hasNext())
    {
      String str1 = paramJsonReader.nextName();
      if ("responses".equals(str1))
      {
        paramJsonReader.beginArray();
        paramJsonReader.beginObject();
        while (paramJsonReader.hasNext())
        {
          String str4 = paramJsonReader.nextName();
          if ("ad_configs".equals(str4))
          {
            localObject = new ArrayList();
            paramJsonReader.beginArray();
            while (paramJsonReader.hasNext())
              ((List)localObject).add(new zzcxl(paramJsonReader));
            paramJsonReader.endArray();
          }
          else if (str4.equals("common"))
          {
            localzzcxn = new zzcxn(paramJsonReader);
          }
          else
          {
            paramJsonReader.skipValue();
          }
        }
        paramJsonReader.endObject();
        paramJsonReader.endArray();
      }
      else if (str1.equals("actions"))
      {
        paramJsonReader.beginArray();
        while (paramJsonReader.hasNext())
        {
          paramJsonReader.beginObject();
          Map localMap = null;
          String str2 = null;
          while (paramJsonReader.hasNext())
          {
            String str3 = paramJsonReader.nextName();
            if ("name".equals(str3))
              str2 = paramJsonReader.nextString();
            else if ("info".equals(str3))
              localMap = zzazd.zzb(paramJsonReader);
            else
              paramJsonReader.skipValue();
          }
          if (str2 != null)
            localArrayList.add(new zzcxs(str2, localMap));
          paramJsonReader.endObject();
        }
        paramJsonReader.endArray();
      }
    }
    this.zzgkv = localArrayList;
    this.zzgkt = ((List)localObject);
    if (localzzcxn != null);
    while (true)
    {
      this.zzgku = localzzcxn;
      return;
      localzzcxn = new zzcxn(new JsonReader(new StringReader("{}")));
    }
  }

  // ERROR //
  public static zzcxr zza(java.io.Reader paramReader)
    throws zzcxo
  {
    // Byte code:
    //   0: new 2	com/google/android/gms/internal/ads/zzcxr
    //   3: dup
    //   4: new 35	android/util/JsonReader
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 118	android/util/JsonReader:<init>	(Ljava/io/Reader;)V
    //   12: invokespecial 123	com/google/android/gms/internal/ads/zzcxr:<init>	(Landroid/util/JsonReader;)V
    //   15: astore_1
    //   16: aload_0
    //   17: invokestatic 129	com/google/android/gms/common/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   20: aload_1
    //   21: areturn
    //   22: astore_2
    //   23: new 122	com/google/android/gms/internal/ads/zzcxo
    //   26: dup
    //   27: ldc 131
    //   29: aload_2
    //   30: invokespecial 134	com/google/android/gms/internal/ads/zzcxo:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   33: athrow
    //   34: astore_3
    //   35: aload_0
    //   36: invokestatic 129	com/google/android/gms/common/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   39: aload_3
    //   40: athrow
    //   41: astore_2
    //   42: goto -19 -> 23
    //   45: astore_2
    //   46: goto -23 -> 23
    //   49: astore_2
    //   50: goto -27 -> 23
    //
    // Exception table:
    //   from	to	target	type
    //   0	16	22	java/lang/IllegalStateException
    //   0	16	34	finally
    //   23	34	34	finally
    //   0	16	41	org/json/JSONException
    //   0	16	45	java/lang/NumberFormatException
    //   0	16	49	java/io/IOException
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcxr
 * JD-Core Version:    0.6.2
 */