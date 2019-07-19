package com.appboy.ui.feed;

import com.appboy.ui.feed.listeners.AppboyDefaultFeedClickActionListener;
import com.appboy.ui.feed.listeners.IFeedClickActionListener;

public class AppboyFeedManager
{
  private static volatile AppboyFeedManager sInstance = null;
  private IFeedClickActionListener mCustomFeedClickActionListener;
  private IFeedClickActionListener mDefaultFeedClickActionListener = new AppboyDefaultFeedClickActionListener();

  public static AppboyFeedManager getInstance()
  {
    if (sInstance == null);
    try
    {
      if (sInstance == null)
        sInstance = new AppboyFeedManager();
      return sInstance;
    }
    finally
    {
    }
  }

  public IFeedClickActionListener getFeedCardClickActionListener()
  {
    if (this.mCustomFeedClickActionListener != null)
      return this.mCustomFeedClickActionListener;
    return this.mDefaultFeedClickActionListener;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.feed.AppboyFeedManager
 * JD-Core Version:    0.6.2
 */