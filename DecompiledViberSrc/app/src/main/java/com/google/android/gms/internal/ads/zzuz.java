package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

@zzare
public final class zzuz
{
  private final int zzbvx;
  private final int zzbvy;
  private final int zzbvz;
  private final zzuy zzbwa = new zzvd();

  public zzuz(int paramInt)
  {
    this.zzbvy = paramInt;
    this.zzbvx = 6;
    this.zzbvz = 0;
  }

  @VisibleForTesting
  private final String zzbm(String paramString)
  {
    String[] arrayOfString1 = paramString.split("\n");
    if (arrayOfString1.length == 0)
      return "";
    zzvb localzzvb = new zzvb();
    PriorityQueue localPriorityQueue = new PriorityQueue(this.zzbvy, new zzva(this));
    for (int i = 0; i < arrayOfString1.length; i++)
    {
      String[] arrayOfString2 = zzvc.zzg(arrayOfString1[i], false);
      if (arrayOfString2.length != 0)
        zzvf.zza(arrayOfString2, this.zzbvy, this.zzbvx, localPriorityQueue);
    }
    Iterator localIterator = localPriorityQueue.iterator();
    while (true)
      if (localIterator.hasNext())
      {
        zzvg localzzvg = (zzvg)localIterator.next();
        try
        {
          localzzvb.write(this.zzbwa.zzbl(localzzvg.zzbwe));
        }
        catch (IOException localIOException)
        {
          zzaxa.zzc("Error while writing hash to byteStream", localIOException);
        }
      }
    return localzzvb.toString();
  }

  public final String zza(ArrayList<String> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    ArrayList localArrayList = (ArrayList)paramArrayList;
    int i = localArrayList.size();
    int j = 0;
    while (j < i)
    {
      Object localObject = localArrayList.get(j);
      j++;
      localStringBuilder.append(((String)localObject).toLowerCase(Locale.US));
      localStringBuilder.append('\n');
    }
    return zzbm(localStringBuilder.toString());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzuz
 * JD-Core Version:    0.6.2
 */