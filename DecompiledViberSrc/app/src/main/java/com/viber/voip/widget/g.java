package com.viber.voip.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.support.v7.widget.AppCompatImageView;
import pl.droidsonroids.gif.b;

public class g extends AppCompatImageView
{
  h a = new h(new h.a()
  {
    public Drawable.Callback a()
    {
      return g.this;
    }

    public void a(b paramAnonymousb)
    {
      g.a(g.this, paramAnonymousb);
    }
  });

  public g(Context paramContext)
  {
    super(paramContext);
  }

  private void setNonGifDrawable(Drawable paramDrawable)
  {
    this.a.a(null);
    if (paramDrawable != null)
      super.setImageDrawable(paramDrawable);
  }

  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.a.a(null);
    super.setImageBitmap(paramBitmap);
  }

  public void setImageDrawable(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof b))
    {
      this.a.a((b)paramDrawable);
      return;
    }
    setNonGifDrawable(paramDrawable);
  }

  public void setImageIcon(Icon paramIcon)
  {
    this.a.a(null);
    super.setImageIcon(paramIcon);
  }

  public void setImageResource(int paramInt)
  {
    this.a.a(null);
    super.setImageResource(paramInt);
  }

  public void setImageURI(Uri paramUri)
  {
    this.a.a(null);
    super.setImageURI(paramUri);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.g
 * JD-Core Version:    0.6.2
 */