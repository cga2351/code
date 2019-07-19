package com.mopub.volley.toolbox;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.mopub.volley.VolleyError;

public class NetworkImageView extends ImageView
{
  Bitmap a;
  private String b;
  private int c;
  private int d;
  private Bitmap e;
  private ImageLoader f;
  private ImageLoader.ImageContainer g;

  public NetworkImageView(Context paramContext)
  {
    this(paramContext, null);
  }

  public NetworkImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public NetworkImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void a()
  {
    if (this.c != 0)
    {
      setImageResource(this.c);
      return;
    }
    if (this.a != null)
    {
      setImageBitmap(this.a);
      return;
    }
    setImageBitmap(null);
  }

  void a(final boolean paramBoolean)
  {
    int i = 1;
    int j = getWidth();
    int k = getHeight();
    ImageView.ScaleType localScaleType = getScaleType();
    int i2;
    int i3;
    label56: int n;
    int m;
    if (getLayoutParams() != null)
      if (getLayoutParams().width == -2)
      {
        i2 = i;
        if (getLayoutParams().height != -2)
          break label98;
        i3 = i;
        int i4 = i3;
        n = i2;
        m = i4;
      }
    while (true)
    {
      if ((n != 0) && (m != 0))
        label78: if ((j != 0) || (k != 0) || (i != 0))
          break label109;
      label98: label109: 
      do
      {
        return;
        i2 = 0;
        break;
        i3 = 0;
        break label56;
        i = 0;
        break label78;
        if (TextUtils.isEmpty(this.b))
        {
          if (this.g != null)
          {
            this.g.cancelRequest();
            this.g = null;
          }
          a();
          return;
        }
        if ((this.g == null) || (this.g.getRequestUrl() == null))
          break label188;
      }
      while (this.g.getRequestUrl().equals(this.b));
      this.g.cancelRequest();
      a();
      label188: if (n != 0);
      for (int i1 = 0; ; i1 = j)
      {
        if (m != 0)
          k = 0;
        this.g = this.f.get(this.b, new ImageLoader.ImageListener()
        {
          public void onErrorResponse(VolleyError paramAnonymousVolleyError)
          {
            if (NetworkImageView.a(NetworkImageView.this) != 0)
              NetworkImageView.this.setImageResource(NetworkImageView.a(NetworkImageView.this));
            while (NetworkImageView.b(NetworkImageView.this) == null)
              return;
            NetworkImageView.this.setImageBitmap(NetworkImageView.b(NetworkImageView.this));
          }

          public void onResponse(final ImageLoader.ImageContainer paramAnonymousImageContainer, boolean paramAnonymousBoolean)
          {
            if ((paramAnonymousBoolean) && (paramBoolean))
              NetworkImageView.this.post(new Runnable()
              {
                public void run()
                {
                  NetworkImageView.1.this.onResponse(paramAnonymousImageContainer, false);
                }
              });
            do
            {
              return;
              if (paramAnonymousImageContainer.getBitmap() != null)
              {
                NetworkImageView.this.setImageBitmap(paramAnonymousImageContainer.getBitmap());
                return;
              }
              if (NetworkImageView.c(NetworkImageView.this) != 0)
              {
                NetworkImageView.this.setImageResource(NetworkImageView.c(NetworkImageView.this));
                return;
              }
            }
            while (NetworkImageView.this.a == null);
            NetworkImageView.this.setImageBitmap(NetworkImageView.this.a);
          }
        }
        , i1, k, localScaleType);
        return;
      }
      m = 0;
      n = 0;
    }
  }

  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    invalidate();
  }

  protected void onDetachedFromWindow()
  {
    if (this.g != null)
    {
      this.g.cancelRequest();
      setImageBitmap(null);
      this.g = null;
    }
    super.onDetachedFromWindow();
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    a(true);
  }

  public void setDefaultImageBitmap(Bitmap paramBitmap)
  {
    this.c = 0;
    this.a = paramBitmap;
  }

  public void setDefaultImageResId(int paramInt)
  {
    this.a = null;
    this.c = paramInt;
  }

  public void setErrorImageBitmap(Bitmap paramBitmap)
  {
    this.d = 0;
    this.e = paramBitmap;
  }

  public void setErrorImageResId(int paramInt)
  {
    this.e = null;
    this.d = paramInt;
  }

  public void setImageUrl(String paramString, ImageLoader paramImageLoader)
  {
    a.a();
    this.b = paramString;
    this.f = paramImageLoader;
    a(false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.volley.toolbox.NetworkImageView
 * JD-Core Version:    0.6.2
 */