package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class zzdmh<MessageType extends zzdmh<MessageType, BuilderType>, BuilderType extends zzdmi<MessageType, BuilderType>>
  implements zzdpj
{
  private static boolean zzhcg = false;
  protected int zzhcf = 0;

  protected static <T> void zza(Iterable<T> paramIterable, List<? super T> paramList)
  {
    zzdoc.checkNotNull(paramIterable);
    if ((paramIterable instanceof zzdos))
    {
      List localList = ((zzdos)paramIterable).zzayo();
      zzdos localzzdos = (zzdos)paramList;
      int m = paramList.size();
      Iterator localIterator2 = localList.iterator();
      while (localIterator2.hasNext())
      {
        Object localObject2 = localIterator2.next();
        if (localObject2 == null)
        {
          int n = localzzdos.size() - m;
          String str2 = 37 + "Element at index " + n + " is null.";
          for (int i1 = -1 + localzzdos.size(); i1 >= m; i1--)
            localzzdos.remove(i1);
          throw new NullPointerException(str2);
        }
        if ((localObject2 instanceof zzdmq))
          localzzdos.zzdb((zzdmq)localObject2);
        else
          localzzdos.add((String)localObject2);
      }
    }
    if ((paramIterable instanceof zzdpv))
      paramList.addAll((Collection)paramIterable);
    while (true)
    {
      return;
      if (((paramList instanceof ArrayList)) && ((paramIterable instanceof Collection)))
        ((ArrayList)paramList).ensureCapacity(paramList.size() + ((Collection)paramIterable).size());
      int i = paramList.size();
      Iterator localIterator1 = paramIterable.iterator();
      while (localIterator1.hasNext())
      {
        Object localObject1 = localIterator1.next();
        if (localObject1 == null)
        {
          int j = paramList.size() - i;
          String str1 = 37 + "Element at index " + j + " is null.";
          for (int k = -1 + paramList.size(); k >= i; k--)
            paramList.remove(k);
          throw new NullPointerException(str1);
        }
        paramList.add(localObject1);
      }
    }
  }

  public final byte[] toByteArray()
  {
    try
    {
      byte[] arrayOfByte = new byte[zzaxj()];
      zzdnh localzzdnh = zzdnh.zzab(arrayOfByte);
      zzb(localzzdnh);
      localzzdnh.zzawv();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      String str = getClass().getName();
      throw new RuntimeException(62 + String.valueOf(str).length() + String.valueOf("byte array").length() + "Serializing " + str + " to a " + "byte array" + " threw an IOException (should never happen).", localIOException);
    }
  }

  public final zzdmq zzavf()
  {
    try
    {
      zzdmy localzzdmy = zzdmq.zzfo(zzaxj());
      zzb(localzzdmy.zzavt());
      zzdmq localzzdmq = localzzdmy.zzavs();
      return localzzdmq;
    }
    catch (IOException localIOException)
    {
      String str = getClass().getName();
      throw new RuntimeException(62 + String.valueOf(str).length() + String.valueOf("ByteString").length() + "Serializing " + str + " to a " + "ByteString" + " threw an IOException (should never happen).", localIOException);
    }
  }

  int zzavg()
  {
    throw new UnsupportedOperationException();
  }

  void zzfi(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdmh
 * JD-Core Version:    0.6.2
 */