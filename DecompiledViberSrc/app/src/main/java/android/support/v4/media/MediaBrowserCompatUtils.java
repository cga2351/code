package android.support.v4.media;

import android.os.Bundle;

public class MediaBrowserCompatUtils
{
  public static boolean areSameOptions(Bundle paramBundle1, Bundle paramBundle2)
  {
    if (paramBundle1 == paramBundle2);
    do
    {
      do
      {
        do
        {
          return true;
          if (paramBundle1 != null)
            break;
        }
        while ((paramBundle2.getInt("android.media.browse.extra.PAGE", -1) == -1) && (paramBundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1) == -1));
        return false;
        if (paramBundle2 != null)
          break;
      }
      while ((paramBundle1.getInt("android.media.browse.extra.PAGE", -1) == -1) && (paramBundle1.getInt("android.media.browse.extra.PAGE_SIZE", -1) == -1));
      return false;
    }
    while ((paramBundle1.getInt("android.media.browse.extra.PAGE", -1) == paramBundle2.getInt("android.media.browse.extra.PAGE", -1)) && (paramBundle1.getInt("android.media.browse.extra.PAGE_SIZE", -1) == paramBundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1)));
    return false;
  }

  public static boolean hasDuplicatedItems(Bundle paramBundle1, Bundle paramBundle2)
  {
    int i = 2147483647;
    int j;
    int k;
    label16: int m;
    label23: int n;
    label30: int i1;
    int i2;
    label47: int i3;
    if (paramBundle1 == null)
    {
      j = -1;
      if (paramBundle2 != null)
        break label98;
      k = -1;
      if (paramBundle1 != null)
        break label110;
      m = -1;
      if (paramBundle2 != null)
        break label122;
      n = -1;
      if ((j != -1) && (m != -1))
        break label134;
      i1 = i;
      i2 = 0;
      if ((k != -1) && (n != -1))
        break label160;
      i3 = 0;
    }
    while (true)
    {
      boolean bool = false;
      if (i1 >= i3)
      {
        bool = false;
        if (i >= i2)
          bool = true;
      }
      return bool;
      j = paramBundle1.getInt("android.media.browse.extra.PAGE", -1);
      break;
      label98: k = paramBundle2.getInt("android.media.browse.extra.PAGE", -1);
      break label16;
      label110: m = paramBundle1.getInt("android.media.browse.extra.PAGE_SIZE", -1);
      break label23;
      label122: n = paramBundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1);
      break label30;
      label134: int i4 = j * m;
      int i5 = -1 + (i4 + m);
      i2 = i4;
      i1 = i5;
      break label47;
      label160: i3 = n * k;
      i = -1 + (i3 + n);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompatUtils
 * JD-Core Version:    0.6.2
 */