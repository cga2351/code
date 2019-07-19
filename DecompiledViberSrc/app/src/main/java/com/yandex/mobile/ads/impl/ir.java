package com.yandex.mobile.ads.impl;

import android.view.View;
import android.widget.ImageView;
import com.yandex.mobile.ads.nativeads.MediaView;

public final class ir
  implements in<lk>, ip<lk>
{
  private final iz a;
  private final ja b;

  public ir(iz paramiz, ja paramja)
  {
    this.a = paramiz;
    this.b = paramja;
  }

  private static <V extends View, T> V a(je<V, T> paramje)
  {
    if (paramje != null)
      return paramje.a();
    return null;
  }

  private void a(lh paramlh)
  {
    ImageView localImageView = (ImageView)a(this.a);
    if ((localImageView != null) && (paramlh != null))
    {
      this.a.a(localImageView, paramlh);
      localImageView.setVisibility(0);
    }
  }

  private static <V extends View, T> boolean a(je<V, T> paramje, T paramT)
  {
    View localView = a(paramje);
    return (localView != null) && (paramT != null) && (paramje.a(localView, paramT));
  }

  public final void a()
  {
    ImageView localImageView = (ImageView)a(this.a);
    if (localImageView != null)
      this.a.a(localImageView);
    MediaView localMediaView = (MediaView)a(this.b);
    if (localMediaView != null)
      this.b.a(localMediaView);
  }

  public final void a(le paramle, ji paramji)
  {
    if (this.a != null)
      this.a.a(paramle, paramji);
    if (this.b != null)
      this.b.a(paramle, paramji);
  }

  public final boolean b()
  {
    int i;
    if ((this.b != null) && (this.b.b()))
    {
      i = 1;
      if ((this.a == null) || (!this.a.b()))
        break label57;
    }
    label57: for (int j = 1; ; j = 0)
    {
      boolean bool;
      if (i == 0)
      {
        bool = false;
        if (j == 0);
      }
      else
      {
        bool = true;
      }
      return bool;
      i = 0;
      break;
    }
  }

  public final boolean c()
  {
    int i;
    if ((this.b != null) && (this.b.c()))
    {
      i = 1;
      if ((this.a == null) || (!this.a.c()))
        break label57;
    }
    label57: for (int j = 1; ; j = 0)
    {
      boolean bool;
      if (i == 0)
      {
        bool = false;
        if (j == 0);
      }
      else
      {
        bool = true;
      }
      return bool;
      i = 0;
      break;
    }
  }

  public final boolean d()
  {
    int i;
    if ((this.b != null) && (this.b.d()))
    {
      i = 1;
      if ((this.a == null) || (!this.a.d()))
        break label57;
    }
    label57: for (int j = 1; ; j = 0)
    {
      boolean bool;
      if (i == 0)
      {
        bool = false;
        if (j == 0);
      }
      else
      {
        bool = true;
      }
      return bool;
      i = 0;
      break;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ir
 * JD-Core Version:    0.6.2
 */