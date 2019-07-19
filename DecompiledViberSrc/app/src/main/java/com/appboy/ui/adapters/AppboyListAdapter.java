package com.appboy.ui.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.appboy.e.a.a;
import com.appboy.e.a.b;
import com.appboy.e.a.e;
import com.appboy.e.a.f;
import com.appboy.ui.feed.view.BaseFeedCardView;
import com.appboy.ui.widget.BannerImageCardView;
import com.appboy.ui.widget.CaptionedImageCardView;
import com.appboy.ui.widget.DefaultCardView;
import com.appboy.ui.widget.ShortNewsCardView;
import com.appboy.ui.widget.TextAnnouncementCardView;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AppboyListAdapter extends ArrayAdapter<com.appboy.e.a.c>
{
  private static final String TAG = com.appboy.f.c.a(AppboyListAdapter.class);
  private final Set<String> mCardIdImpressions;
  private final Context mContext;

  public AppboyListAdapter(Context paramContext, int paramInt, List<com.appboy.e.a.c> paramList)
  {
    super(paramContext, paramInt, paramList);
    this.mContext = paramContext;
    this.mCardIdImpressions = new HashSet();
  }

  private void logCardImpression(com.appboy.e.a.c paramc)
  {
    String str = paramc.m();
    if (!this.mCardIdImpressions.contains(str))
    {
      this.mCardIdImpressions.add(str);
      paramc.i();
      com.appboy.f.c.a(TAG, "Logged impression for card " + str);
    }
    while (true)
    {
      if (!paramc.l())
        paramc.c(true);
      return;
      com.appboy.f.c.a(TAG, "Already counted impression for card " + str);
    }
  }

  public void add(com.appboy.e.a.c paramc)
  {
    try
    {
      super.add(paramc);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void batchSetCardsToRead(int paramInt1, int paramInt2)
  {
    if (getCount() == 0)
      com.appboy.f.c.b(TAG, "mAdapter is empty in setting some cards to viewed.");
    while (true)
    {
      return;
      int i = Math.max(0, paramInt1);
      int j = Math.min(getCount(), paramInt2);
      for (int k = i; k < j; k++)
      {
        com.appboy.e.a.c localc = (com.appboy.e.a.c)getItem(k);
        if (localc == null)
        {
          com.appboy.f.c.b(TAG, "Card was null in setting some cards to viewed.");
          return;
        }
        if (!localc.k())
          localc.a(true);
      }
    }
  }

  public int getItemViewType(int paramInt)
  {
    com.appboy.e.a.c localc = (com.appboy.e.a.c)getItem(paramInt);
    if ((localc instanceof a))
      return 1;
    if ((localc instanceof b))
      return 2;
    if ((localc instanceof e))
      return 3;
    if ((localc instanceof f))
      return 4;
    return 0;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    com.appboy.e.a.c localc = (com.appboy.e.a.c)getItem(paramInt);
    Object localObject;
    if (paramView == null)
      if ((localc instanceof a))
        localObject = new BannerImageCardView(this.mContext);
    while (true)
    {
      com.appboy.f.c.a(TAG, "Using view of type: " + localObject.getClass().getName() + " for card at position " + paramInt + ": " + localc.toString());
      ((BaseFeedCardView)localObject).setCard(localc);
      logCardImpression(localc);
      return localObject;
      if ((localc instanceof b))
      {
        localObject = new CaptionedImageCardView(this.mContext);
      }
      else if ((localc instanceof e))
      {
        localObject = new ShortNewsCardView(this.mContext);
      }
      else if ((localc instanceof f))
      {
        localObject = new TextAnnouncementCardView(this.mContext);
      }
      else
      {
        localObject = new DefaultCardView(this.mContext);
        continue;
        com.appboy.f.c.a(TAG, "Reusing convertView for rendering of item " + paramInt);
        localObject = (BaseFeedCardView)paramView;
      }
    }
  }

  public int getViewTypeCount()
  {
    return 5;
  }

  public void replaceFeed(List<com.appboy.e.a.c> paramList)
  {
    while (true)
    {
      int i;
      int j;
      try
      {
        setNotifyOnChange(false);
        if (paramList == null)
        {
          clear();
          notifyDataSetChanged();
          return;
        }
        com.appboy.f.c.b(TAG, "Replacing existing feed of " + getCount() + " cards with new feed containing " + paramList.size() + " cards.");
        i = paramList.size();
        j = 0;
        int k = 0;
        if (k < getCount())
        {
          com.appboy.e.a.c localc1 = (com.appboy.e.a.c)getItem(k);
          com.appboy.e.a.c localc2 = null;
          if (j < i)
            localc2 = (com.appboy.e.a.c)paramList.get(j);
          if ((localc2 != null) && (localc2.a(localc1)))
          {
            int m = k + 1;
            j++;
            k = m;
            continue;
          }
          remove(localc1);
          continue;
        }
      }
      finally
      {
      }
      super.addAll(paramList.subList(j, i));
      notifyDataSetChanged();
    }
  }

  public void resetCardImpressionTracker()
  {
    this.mCardIdImpressions.clear();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.adapters.AppboyListAdapter
 * JD-Core Version:    0.6.2
 */