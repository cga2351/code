package com.viber.voip.stickers.ui;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Picture;
import android.widget.ImageView;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.f.e;
import com.viber.voip.stickers.i;
import com.viber.voip.stickers.w;
import com.viber.voip.stickers.x;

public class f
{
  public static final int a = Color.argb(76, 255, 0, 0);
  private com.viber.voip.stickers.f b;
  private b c;
  private b d;

  public f(com.viber.voip.stickers.f paramf, ImageView paramImageView)
  {
    this.b = paramf;
    this.c = new b(paramImageView, false);
  }

  public f(com.viber.voip.stickers.f paramf, ImageView paramImageView1, ImageView paramImageView2)
  {
    this.b = paramf;
    this.c = new b(paramImageView1, false);
    this.d = new b(paramImageView2, true);
  }

  private void a(b paramb, boolean paramBoolean)
  {
    ImageView localImageView = b.b(paramb);
    if (b.a(paramb).isSvg());
    while (true)
    {
      x.a(localImageView, paramBoolean);
      return;
      paramBoolean = true;
    }
  }

  public void a(Sticker paramSticker)
  {
    this.c.a(paramSticker);
    if (this.d != null)
      this.d.a(paramSticker);
  }

  public void a(boolean paramBoolean)
  {
    this.c.a(paramBoolean);
  }

  public boolean a()
  {
    return b.a(this.c) == null;
  }

  public boolean a(boolean paramBoolean1, boolean paramBoolean2, w paramw)
  {
    return a(false, paramBoolean1, paramBoolean2, paramw, null);
  }

  public boolean a(boolean paramBoolean1, boolean paramBoolean2, w paramw, a parama)
  {
    return a(false, paramBoolean1, false, paramBoolean2, paramw, parama);
  }

  public boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, w paramw, a parama)
  {
    return a(paramBoolean1, paramBoolean2, false, paramBoolean3, paramw, parama);
  }

  public boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, w paramw, a parama)
  {
    return a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramw, false, parama);
  }

  public boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, w paramw, boolean paramBoolean5, a parama)
  {
    if (paramBoolean2);
    for (b localb = this.d; localb == null; localb = this.c)
      return false;
    a(localb, paramBoolean3);
    return localb.a(paramBoolean1, paramBoolean4, paramw, true, paramBoolean3, paramBoolean5, parama);
  }

  public void b()
  {
    if ((b.c(this.c) != null) && ((b.c(this.c) instanceof com.viber.voip.stickers.f.b)))
    {
      com.viber.voip.stickers.f.b localb = (com.viber.voip.stickers.f.b)b.c(this.c);
      this.b.a(localb);
      localb.b();
    }
  }

  public void b(boolean paramBoolean)
  {
    if (paramBoolean);
    for (b localb = this.d; localb == null; localb = this.c)
      return;
    b.a(localb, null);
  }

  public static abstract interface a
  {
    public abstract boolean a(boolean paramBoolean);
  }

  private class b
  {
    boolean a = false;
    private ImageView c;
    private Object d;
    private com.viber.voip.b.a.a.a.b e;
    private Sticker f;
    private boolean g;

    public b(ImageView paramBoolean, boolean arg3)
    {
      this.c = paramBoolean;
      boolean bool;
      this.g = bool;
    }

    private void a()
    {
      if (this.e != null)
      {
        this.e.d();
        this.e = null;
      }
    }

    private void a(Bitmap paramBitmap)
    {
      this.c.setImageBitmap(paramBitmap);
      a();
    }

    private void a(Picture paramPicture, int paramInt1, int paramInt2)
    {
      this.c.setImageDrawable(new com.viber.voip.stickers.f.b(paramPicture, this.a, paramInt1, paramInt2));
      a();
    }

    private void a(com.viber.voip.b.a.a.a.b paramb)
    {
      this.c.setImageBitmap(paramb.a());
      b(paramb);
    }

    private boolean a(boolean paramBoolean1, w paramw, boolean paramBoolean2, f.a parama)
    {
      int i;
      int j;
      label32: x localx;
      Sticker localSticker;
      if (w.b == paramw)
      {
        i = this.f.getConversationWidth();
        if (w.b != paramw)
          break label131;
        j = this.f.getConversationHeight();
        localx = i.a().f();
        localSticker = this.f;
        if (!this.g)
          break label159;
      }
      label131: label159: for (String str = this.f.getOrigFramePath(); ; str = this.f.getOrigPath())
      {
        a(localx.a(localSticker, i, j, str, paramBoolean1, paramw, true, paramBoolean2), i, j);
        if (parama != null)
          parama.a(true);
        return true;
        if (paramBoolean1)
        {
          i = this.f.getMenuPortWidth();
          break;
        }
        i = this.f.getMenuLandWidth();
        break;
        if (paramBoolean1)
        {
          j = this.f.getMenuPortHeight();
          break label32;
        }
        j = this.f.getMenuLandHeight();
        break label32;
      }
    }

    private boolean a(boolean paramBoolean1, boolean paramBoolean2, w paramw, final boolean paramBoolean3, boolean paramBoolean4, final f.a parama)
    {
      com.viber.voip.b.a.a.a.b localb = f.a(f.this).b(this.f, this.g, paramBoolean2, paramw);
      if (localb != null)
      {
        a(localb);
        return true;
      }
      a(f.a(f.this).a(this.f));
      if (!paramBoolean4)
        this.d = f.a(f.this).a(this.f, paramBoolean1, this.g, paramBoolean2, paramw, new f.e()
        {
          public void a(Sticker paramAnonymousSticker, Object paramAnonymousObject)
          {
          }

          public void a(Sticker paramAnonymousSticker, Object paramAnonymousObject, com.viber.voip.b.a.a.a.b paramAnonymousb)
          {
            boolean bool1 = true;
            boolean bool2;
            if ((paramAnonymousObject == f.b.c(f.b.this)) && (paramAnonymousSticker == f.b.a(f.b.this)))
            {
              bool2 = bool1;
              if (parama != null)
                bool1 = parama.a(bool2);
              if (bool2)
                if (bool1)
                {
                  if (!paramBoolean3)
                    break label90;
                  f.b.a(f.b.this, paramAnonymousb);
                }
            }
            while (true)
            {
              f.b.a(f.b.this, null);
              return;
              bool2 = false;
              break;
              label90: f.b.b(f.b.this, paramAnonymousb);
            }
          }
        });
      return false;
    }

    private void b(com.viber.voip.b.a.a.a.b paramb)
    {
      com.viber.voip.b.a.a.a.b localb = this.e;
      this.e = paramb;
      paramb.b();
      if (localb != null)
        localb.d();
    }

    public void a(Sticker paramSticker)
    {
      if ((this.f != null) && (this.d != null))
        f.a(f.this).b(this.d);
      a();
      this.d = null;
      this.f = paramSticker;
    }

    public void a(boolean paramBoolean)
    {
      this.a = paramBoolean;
      if (paramBoolean)
        this.c.setColorFilter(f.a);
      while (true)
      {
        if ((this.c.getDrawable() instanceof com.viber.voip.stickers.f.b))
        {
          ((com.viber.voip.stickers.f.b)this.c.getDrawable()).a(this.a);
          this.c.postInvalidate();
        }
        return;
        this.c.clearColorFilter();
      }
    }

    public boolean a(boolean paramBoolean1, boolean paramBoolean2, w paramw, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, f.a parama)
    {
      if ((this.f.isSvg()) && ((!this.g) || (this.f.isOwned())) && (!paramBoolean4))
        return a(paramBoolean2, paramw, paramBoolean5, parama);
      return a(paramBoolean1, paramBoolean2, paramw, paramBoolean3, paramBoolean4, parama);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.ui.f
 * JD-Core Version:    0.6.2
 */