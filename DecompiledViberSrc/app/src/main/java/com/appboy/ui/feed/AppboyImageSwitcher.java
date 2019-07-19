package com.appboy.ui.feed;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageSwitcher;
import com.appboy.f.c;
import com.appboy.ui.R.styleable;

public class AppboyImageSwitcher extends ImageSwitcher
{
  private static final String TAG = c.a(AppboyImageSwitcher.class);
  private Drawable mReadIcon;
  private Drawable mUnReadIcon;

  public AppboyImageSwitcher(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    while (true)
    {
      TypedArray localTypedArray;
      int i;
      try
      {
        localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.com_appboy_ui_feed_AppboyImageSwitcher);
        i = 0;
        if (i < localTypedArray.getIndexCount())
        {
          int j = localTypedArray.getIndex(i);
          if (j == R.styleable.com_appboy_ui_feed_AppboyImageSwitcher_appboyFeedCustomReadIcon)
          {
            Drawable localDrawable2 = localTypedArray.getDrawable(j);
            if (localDrawable2 != null)
              this.mReadIcon = localDrawable2;
          }
          else if (localTypedArray.getIndex(i) == R.styleable.com_appboy_ui_feed_AppboyImageSwitcher_appboyFeedCustomUnReadIcon)
          {
            Drawable localDrawable1 = localTypedArray.getDrawable(j);
            if (localDrawable1 != null)
              this.mUnReadIcon = localDrawable1;
          }
        }
      }
      catch (Exception localException)
      {
        c.c(TAG, "Error while checking for custom drawable.", localException);
        return;
      }
      localTypedArray.recycle();
      return;
      i++;
    }
  }

  public Drawable getReadIcon()
  {
    return this.mReadIcon;
  }

  public Drawable getUnReadIcon()
  {
    return this.mUnReadIcon;
  }

  public void setReadIcon(Drawable paramDrawable)
  {
    this.mReadIcon = paramDrawable;
  }

  public void setUnReadIcon(Drawable paramDrawable)
  {
    this.mUnReadIcon = paramDrawable;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.feed.AppboyImageSwitcher
 * JD-Core Version:    0.6.2
 */