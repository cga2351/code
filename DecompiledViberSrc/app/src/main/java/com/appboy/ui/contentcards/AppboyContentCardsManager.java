package com.appboy.ui.contentcards;

import com.appboy.ui.contentcards.listeners.AppboyContentCardsActionListener;
import com.appboy.ui.contentcards.listeners.IContentCardsActionListener;

public class AppboyContentCardsManager
{
  private static volatile AppboyContentCardsManager sInstance = null;
  private IContentCardsActionListener mCustomContentCardsActionListener;
  private IContentCardsActionListener mDefaultContentCardsActionListener = new AppboyContentCardsActionListener();

  public static AppboyContentCardsManager getInstance()
  {
    if (sInstance == null);
    try
    {
      if (sInstance == null)
        sInstance = new AppboyContentCardsManager();
      return sInstance;
    }
    finally
    {
    }
  }

  public IContentCardsActionListener getContentCardsActionListener()
  {
    if (this.mCustomContentCardsActionListener != null)
      return this.mCustomContentCardsActionListener;
    return this.mDefaultContentCardsActionListener;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.contentcards.AppboyContentCardsManager
 * JD-Core Version:    0.6.2
 */