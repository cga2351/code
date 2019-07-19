package com.viber.voip.bot.item;

import com.viber.voip.ViberApplication;
import java.util.ArrayList;
import java.util.Iterator;

public class c<I extends KeyboardItem>
{
  private final b<I>[] a;
  private final b<I>[] b;

  public c(Iterable<I> paramIterable, int paramInt)
  {
    this(paramIterable, paramInt, false, false, false);
  }

  public c(Iterable<I> paramIterable, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramIterable, paramInt, true, paramBoolean1, paramBoolean2);
  }

  public c(Iterable<I> paramIterable, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList5;
    ArrayList localArrayList6;
    if (paramBoolean1)
    {
      ArrayList localArrayList3 = new ArrayList();
      ArrayList localArrayList4 = new ArrayList();
      localArrayList5 = localArrayList3;
      localArrayList6 = localArrayList4;
    }
    while (true)
    {
      boolean bool = ViberApplication.isTablet(ViberApplication.getApplication());
      Iterator localIterator = paramIterable.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        KeyboardItem localKeyboardItem = (KeyboardItem)localIterator.next();
        if ((localKeyboardItem.genericColPos == 0) && (localKeyboardItem.genericRowPos == 0) && (!localArrayList2.isEmpty()))
        {
          localArrayList1.add(new b(localArrayList2));
          localArrayList2.clear();
          if ((paramBoolean1) && ((!paramBoolean2) || (i != 0)))
          {
            localArrayList5.add(new b(localArrayList6));
            localArrayList6.clear();
          }
          if (i == 0)
            i = 1;
        }
        else
        {
          label179: localArrayList2.add(localKeyboardItem);
          if (paramBoolean1)
            localArrayList6.add(localKeyboardItem);
          localKeyboardItem.portRowPos = localKeyboardItem.genericRowPos;
          localKeyboardItem.landRowPos = localKeyboardItem.genericRowPos;
          if ((i == 0) || (!paramBoolean1))
            break label273;
        }
        label273: for (int j = paramInt + localKeyboardItem.genericColPos; ; j = localKeyboardItem.genericColPos)
        {
          localKeyboardItem.landColPos = j;
          if ((!bool) || (!paramBoolean3))
            break label283;
          localKeyboardItem.portColPos = localKeyboardItem.landColPos;
          break;
          i = 0;
          break label179;
        }
        label283: localKeyboardItem.portColPos = localKeyboardItem.genericColPos;
      }
      localArrayList1.add(new b(localArrayList2));
      if (paramBoolean1)
        localArrayList5.add(new b(localArrayList6));
      for (this.b = ((b[])localArrayList5.toArray(new b[localArrayList5.size()])); (paramBoolean1) && (bool) && (paramBoolean3); this.b = null)
      {
        this.a = this.b;
        return;
      }
      this.a = ((b[])localArrayList1.toArray(new b[localArrayList1.size()]));
      return;
      localArrayList6 = null;
      localArrayList5 = null;
    }
  }

  public b<I>[] a()
  {
    return this.a;
  }

  public b<I>[] b()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.bot.item.c
 * JD-Core Version:    0.6.2
 */