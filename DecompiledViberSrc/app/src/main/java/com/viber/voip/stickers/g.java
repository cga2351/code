package com.viber.voip.stickers;

import android.util.SparseArray;
import com.viber.voip.bot.item.c;
import com.viber.voip.stickers.entity.Sticker;
import java.util.ArrayList;
import java.util.Iterator;

public class g extends c<Sticker>
{
  private static int[] a = { 200, 201, 204, 202, 203, 205, 207, 206, 210, 209, 208 };

  public g(Iterable<Sticker> paramIterable, int paramInt1, int paramInt2)
  {
    super(a(paramIterable, paramInt1), paramInt2, true, true);
  }

  private static Iterable<Sticker> a(Iterable<Sticker> paramIterable, int paramInt)
  {
    switch (paramInt)
    {
    default:
      return paramIterable;
    case 200:
    }
    return a(paramIterable, a);
  }

  private static Iterable<Sticker> a(Iterable<Sticker> paramIterable, int[] paramArrayOfInt)
  {
    SparseArray localSparseArray = new SparseArray(paramArrayOfInt.length);
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
    {
      Sticker localSticker = (Sticker)localIterator.next();
      localSparseArray.put(localSticker.id, localSticker);
    }
    ArrayList localArrayList = new ArrayList(paramArrayOfInt.length);
    for (int i = 0; i < paramArrayOfInt.length; i++)
      localArrayList.add(i, localSparseArray.get(paramArrayOfInt[i]));
    return localArrayList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.g
 * JD-Core Version:    0.6.2
 */