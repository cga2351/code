package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class zzcxm
{
  public final int height;
  public final int width;
  public final boolean zzgkq;

  public zzcxm(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.zzgkq = paramBoolean;
  }

  static List<zzcxm> zze(JsonReader paramJsonReader)
    throws IllegalStateException, IOException, NumberFormatException
  {
    ArrayList localArrayList = new ArrayList();
    paramJsonReader.beginArray();
    while (paramJsonReader.hasNext())
    {
      paramJsonReader.beginObject();
      boolean bool = false;
      int i = 0;
      int j = 0;
      while (paramJsonReader.hasNext())
      {
        String str = paramJsonReader.nextName();
        if ("width".equals(str))
          j = paramJsonReader.nextInt();
        else if ("height".equals(str))
          i = paramJsonReader.nextInt();
        else if ("is_fluid_height".equals(str))
          bool = paramJsonReader.nextBoolean();
        else
          paramJsonReader.skipValue();
      }
      paramJsonReader.endObject();
      localArrayList.add(new zzcxm(j, i, bool));
    }
    paramJsonReader.endArray();
    return localArrayList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcxm
 * JD-Core Version:    0.6.2
 */