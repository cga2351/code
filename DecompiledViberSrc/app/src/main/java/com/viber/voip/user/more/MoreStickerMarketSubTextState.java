package com.viber.voip.user.more;

import com.viber.common.b.d;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.stickers.entity.a;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public class MoreStickerMarketSubTextState
{
  private static final Logger L = ViberEnv.getLogger();
  private static final int MARKET_OPENINGS_COUNT_MASK = 1;
  private static final int MORE_OPENINGS_COUNT_MASK = 14;
  private static final int MORE_OPENINGS_COUNT_RESET_MASK = 49;
  private static final int STATE_1_MASK = 16;
  private static final int STATE_2_MASK = 32;
  private static final int STATE_MASK = 48;
  private final d mMoreStickerMarketSubtextState;

  MoreStickerMarketSubTextState(d paramd)
  {
    this.mMoreStickerMarketSubtextState = paramd;
  }

  private int getCount(List<a> paramList)
  {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (j < i)
      if (!((a)paramList.get(j)).g())
        break label54;
    label54: for (int m = k + 1; ; m = k)
    {
      j++;
      k = m;
      break;
      return k;
    }
  }

  private int getNumberOfMarketOpenings()
  {
    return 0x1 & this.mMoreStickerMarketSubtextState.d();
  }

  private int getNumberOfMoreOpenings()
  {
    return (0xE & this.mMoreStickerMarketSubtextState.d()) >>> 1;
  }

  private int getSubTextPrefState()
  {
    return (0x30 & this.mMoreStickerMarketSubtextState.d()) >>> 4;
  }

  private void incrementNumberOfMoreScreenOpenings(int paramInt)
  {
    if (paramInt < 4)
    {
      int i = paramInt + 1;
      int j = 0x31 & this.mMoreStickerMarketSubtextState.d() | i << 1;
      this.mMoreStickerMarketSubtextState.a(j);
    }
  }

  private void updateState(List<a> paramList)
  {
    int i = getCount(paramList);
    int j = getSubTextPrefState();
    int k;
    if ((i >= 5) && (j != 3))
      k = 48;
    while (true)
    {
      if (k > 0)
        this.mMoreStickerMarketSubtextState.a(k);
      return;
      if ((i > 2) && (j != 2) && (j != 3))
      {
        k = 32;
      }
      else
      {
        k = 0;
        if (i >= 0)
        {
          k = 0;
          if (j == 0)
            k = 16;
        }
      }
    }
  }

  String getPrefKey()
  {
    return this.mMoreStickerMarketSubtextState.c();
  }

  public int getState()
  {
    int i = getSubTextPrefState();
    int j;
    if ((i == 3) || (i == 0))
      j = i;
    int m;
    do
    {
      int k;
      do
      {
        do
        {
          return j;
          k = getNumberOfMarketOpenings();
          if (i != 1)
            break;
          j = 0;
        }
        while (k == 1);
        if (i != 2)
          break;
        j = 0;
      }
      while (k == 1);
      m = getNumberOfMoreOpenings();
      j = 0;
    }
    while (m == 4);
    return i;
  }

  void onMarketOpened()
  {
    int i = getSubTextPrefState();
    if ((i != 3) && (i != 0) && (getNumberOfMarketOpenings() < 1))
      this.mMoreStickerMarketSubtextState.a(1 + this.mMoreStickerMarketSubtextState.d());
  }

  void onMoreTabOpened()
  {
    int i = getSubTextPrefState();
    if ((i != 3) && (i != 0))
      incrementNumberOfMoreScreenOpenings(getNumberOfMoreOpenings());
  }

  void onStickerPackagesChanged(List<a> paramList)
  {
    if (getSubTextPrefState() != 3)
      updateState(paramList);
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface State
  {
    public static final int HIDDEN = 0;
    public static final int STATE_1 = 1;
    public static final int STATE_2 = 2;
    public static final int STATE_3 = 3;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.MoreStickerMarketSubTextState
 * JD-Core Version:    0.6.2
 */