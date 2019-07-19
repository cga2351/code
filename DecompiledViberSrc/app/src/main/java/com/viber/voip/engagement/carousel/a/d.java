package com.viber.voip.engagement.carousel.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.viber.dexshared.Logger;
import com.viber.svg.jni.SvgViewBackend;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberEnv;
import com.viber.voip.engagement.data.StickersMediaViewData.StickerItem;
import com.viber.voip.stickers.d.a.b;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.ui.StickerSvgContainer;
import com.viber.voip.stickers.ui.StickerSvgContainer.a;
import com.viber.voip.stickers.v.c;
import com.viber.voip.stickers.w;
import com.viber.voip.util.dj;
import java.util.List;

public class d extends a<StickersMediaViewData.StickerItem, a>
  implements a.b
{
  private static final Logger i = ViberEnv.getLogger();
  private final com.viber.voip.stickers.d.a j;
  private final com.viber.voip.stickers.f k;
  private final com.viber.voip.stickers.d.b l;

  public d(Context paramContext, List<StickersMediaViewData.StickerItem> paramList, int paramInt1, int paramInt2, com.viber.voip.stickers.d.a parama, com.viber.voip.stickers.f paramf, com.viber.voip.stickers.d.b paramb, LayoutInflater paramLayoutInflater)
  {
    super(paramContext, paramList, paramInt1, paramInt2, paramLayoutInflater);
    this.j = parama;
    this.k = paramf;
    this.j.a(this);
    this.l = paramb;
  }

  public a a(ViewGroup paramViewGroup, int paramInt)
  {
    return new a(this.b.inflate(R.layout.engagement_media_sticker_item, paramViewGroup, false), this.d, this.e, this.j, this.k, this.l);
  }

  public void a()
  {
    super.a();
    this.l.a();
  }

  public void a(Sticker paramSticker)
  {
    int m = getItemCount();
    for (int n = 0; n < m; n++)
      if (((StickersMediaViewData.StickerItem)this.c.get(n)).getId() == paramSticker.id)
        notifyItemChanged(n);
  }

  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.l.a();
  }

  public void b()
  {
    super.b();
    if (!this.h)
    {
      this.l.b();
      notifyItemChanged(this.f);
    }
  }

  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if ((paramBoolean) && (!this.g))
    {
      this.l.b();
      notifyItemChanged(this.f);
    }
  }

  public void c()
  {
    this.l.a();
  }

  public void d()
  {
    this.l.b();
  }

  protected static class a extends b<StickersMediaViewData.StickerItem>
    implements StickerSvgContainer.a, v.c<String>
  {
    private StickerSvgContainer d;
    private com.viber.voip.stickers.ui.f e;
    private final com.viber.voip.stickers.d.a f;
    private final com.viber.voip.stickers.d.b g;
    private Sticker h;
    private String i;

    protected a(View paramView, int paramInt1, int paramInt2, com.viber.voip.stickers.d.a parama, com.viber.voip.stickers.f paramf, com.viber.voip.stickers.d.b paramb)
    {
      super(paramInt1, paramInt2);
      this.f = parama;
      this.d = ((StickerSvgContainer)paramView.findViewById(R.id.sticker_svg_container));
      this.d.setAnimationCallback(this);
      this.e = new com.viber.voip.stickers.ui.f(paramf, this.c);
      this.g = paramb;
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if ((d.a.this.isAnimatedSticker()) && (d.a.this.a) && (d.a.a(d.a.this).c()))
            d.a.a(d.a.this).a(d.a.this);
        }
      });
    }

    private String a(int paramInt1, int paramInt2)
    {
      return paramInt1 + "|" + paramInt2;
    }

    private void e(boolean paramBoolean)
    {
      dj.b(this.d, paramBoolean);
      if (!paramBoolean);
      for (boolean bool = true; ; bool = false)
      {
        b(bool);
        return;
      }
    }

    private void f(boolean paramBoolean)
    {
      e(paramBoolean);
      if (paramBoolean)
      {
        this.g.a(this);
        return;
      }
      this.g.b(this);
    }

    protected void a(StickersMediaViewData.StickerItem paramStickerItem, int paramInt, boolean paramBoolean)
    {
      boolean bool1 = true;
      super.a(paramStickerItem, paramInt, paramBoolean);
      this.i = a(paramStickerItem.getId(), paramInt);
      a(bool1);
      this.c.setImageDrawable(null);
      this.e.b();
      this.d.c();
      this.d.d();
      this.d.b();
      this.d.setSticker(null);
      this.h = this.f.a(paramStickerItem.getId());
      boolean bool2;
      if (this.h != null)
      {
        a(false);
        this.e.a(this.h);
        this.e.a(false, bool1, w.b);
        if (!this.h.isAnimated())
          break label259;
        this.d.setSticker(this.h);
        bool2 = this.g.c();
        if ((!bool2) || (!this.i.equals(this.g.d())))
          break label265;
        SvgViewBackend localSvgViewBackend = this.g.e();
        if (localSvgViewBackend == null)
          break label265;
        this.d.setLoadedSticker(this.h);
        this.d.setBackend(localSvgViewBackend);
        this.d.a(false, false);
        e(bool1);
      }
      label259: label265: for (int j = 0; ; j = bool1)
      {
        if (j != 0)
          if ((!this.a) || (!bool2))
            break label253;
        while (true)
        {
          f(bool1);
          return;
          label253: bool1 = false;
        }
        e(false);
        return;
      }
    }

    public String b()
    {
      return this.i;
    }

    protected void d(boolean paramBoolean)
    {
      if (isAnimatedSticker())
        if ((!paramBoolean) || (!this.g.c()))
          break label29;
      label29: for (boolean bool = true; ; bool = false)
      {
        f(bool);
        return;
      }
    }

    public SvgViewBackend getBackend()
    {
      return this.d.getBackend();
    }

    public String getSoundPath()
    {
      if (this.h != null)
        return this.h.getOrigSoundPath();
      return "";
    }

    public boolean hasSound()
    {
      return (this.h != null) && (this.h.hasSound());
    }

    public boolean isAnimatedSticker()
    {
      return (this.h != null) && (this.h.isAnimated());
    }

    public void loadImage(boolean paramBoolean)
    {
      this.e.a(false, false, false, true, w.b, paramBoolean, null);
    }

    public void onPlayAnimation()
    {
      this.g.g(this.i);
    }

    public void onStartAnimation()
    {
      this.g.f(this.i);
    }

    public void onStopAnimation()
    {
      this.g.h(this.i);
    }

    public boolean pauseAnimation()
    {
      return this.d.f();
    }

    public boolean resumeAnimation()
    {
      return this.d.g();
    }

    public void startAnimation()
    {
      this.d.e();
    }

    public void stopAnimation()
    {
      this.d.h();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.carousel.a.d
 * JD-Core Version:    0.6.2
 */