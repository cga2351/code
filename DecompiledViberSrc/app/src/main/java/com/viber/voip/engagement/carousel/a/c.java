package com.viber.voip.engagement.carousel.a;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.layout;
import com.viber.voip.ViberEnv;
import com.viber.voip.engagement.data.GifsMediaViewData.GifItem;
import com.viber.voip.messages.controller.aa;
import com.viber.voip.messages.controller.y;
import com.viber.voip.messages.controller.y.a;
import com.viber.voip.messages.controller.z;
import java.util.List;

public class c extends a<GifsMediaViewData.GifItem, a>
{
  private static final Logger i = ViberEnv.getLogger();
  private final y j = y.a();

  public c(Context paramContext, List<GifsMediaViewData.GifItem> paramList, int paramInt1, int paramInt2, LayoutInflater paramLayoutInflater)
  {
    super(paramContext, paramList, paramInt1, paramInt2, paramLayoutInflater);
  }

  public a a(ViewGroup paramViewGroup, int paramInt)
  {
    return new a(this.b.inflate(R.layout.engagement_media_gif_item, paramViewGroup, false), this.d, this.e, this.j);
  }

  protected static class a extends b<GifsMediaViewData.GifItem>
  {
    private final y d;
    private String e;
    private final y.a f = new y.a()
    {
      public void a(ImageView paramAnonymousImageView, pl.droidsonroids.gif.b paramAnonymousb)
      {
        z.a(this, paramAnonymousImageView, paramAnonymousb);
      }

      public void a(pl.droidsonroids.gif.b paramAnonymousb, String paramAnonymousString, Uri paramAnonymousUri)
      {
        c.a locala = c.a.this;
        if (paramAnonymousb == null);
        for (boolean bool = true; ; bool = false)
        {
          locala.a(bool);
          c.a.a(c.a.this).a(paramAnonymousb, paramAnonymousString);
          c.a.a(c.a.this, c.a.this.a);
          return;
        }
      }

      public void b(pl.droidsonroids.gif.b paramAnonymousb, String paramAnonymousString, Uri paramAnonymousUri)
      {
        z.a(this, paramAnonymousb, paramAnonymousString, paramAnonymousUri);
      }
    };

    protected a(View paramView, int paramInt1, int paramInt2, y paramy)
    {
      super(paramInt1, paramInt2);
      this.d = paramy;
    }

    private void e(boolean paramBoolean)
    {
      if (this.d.a(this.e) == null)
      {
        aa localaa = new aa(true);
        localaa.b = true;
        this.d.a(this.e, localaa);
      }
      if (paramBoolean)
      {
        this.d.a(this.e, this.c.getDrawable());
        return;
      }
      this.d.b(this.e, this.c.getDrawable());
    }

    protected void a(GifsMediaViewData.GifItem paramGifItem, int paramInt, boolean paramBoolean)
    {
      super.a(paramGifItem, paramInt, paramBoolean);
      Uri localUri = paramGifItem.getUrl();
      this.e = (paramInt + localUri.toString());
      a(true);
      this.d.a(this.e, localUri, this.c, this.f, false);
    }

    protected void d(boolean paramBoolean)
    {
      e(paramBoolean);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.carousel.a.c
 * JD-Core Version:    0.6.2
 */