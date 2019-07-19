package com.viber.voip.messages.extensions.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.messages.extensions.model.d;
import com.viber.voip.util.dx;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.h.a;
import com.viber.voip.widget.ProgressBar;

final class i extends j
{
  protected final e a;
  protected final f b;
  private h.a n = new h.a()
  {
    public void onLoadComplete(Uri paramAnonymousUri, Bitmap paramAnonymousBitmap, boolean paramAnonymousBoolean)
    {
      i locali = i.this;
      if (paramAnonymousBitmap == null);
      for (boolean bool = true; ; bool = false)
      {
        locali.a(bool);
        return;
      }
    }
  };

  public i(View paramView, l.a parama)
  {
    super(paramView, parama);
    this.a = e.a(paramView.getContext());
    this.b = f.a();
  }

  protected ImageView.ScaleType a()
  {
    return ImageView.ScaleType.FIT_CENTER;
  }

  protected ImageView.ScaleType b()
  {
    return ImageView.ScaleType.FIT_CENTER;
  }

  protected void b(d paramd)
  {
    super.b(paramd);
    Uri localUri = dx.c(paramd.g());
    this.a.a(localUri, this.c, this.b, this.n);
  }

  protected Drawable c()
  {
    return ContextCompat.getDrawable(this.c.getContext(), R.drawable.ic_keyboard_extension_generic_image_stickers);
  }

  protected void c(d paramd)
  {
    super.c(paramd);
    this.c.setBackgroundResource(0);
    this.f.setProgressColor(this.k);
  }

  protected int d()
  {
    return 0;
  }

  protected Pair<Integer, Integer> d(d paramd)
  {
    int i = this.h;
    return Pair.create(Integer.valueOf(this.h * paramd.a(2) / 2), Integer.valueOf(i));
  }

  protected int e()
  {
    return super.e() - 2 * this.l.getDimensionPixelOffset(R.dimen.keyboard_extension_suggestions_top_bottom_offset) - 2 * this.l.getDimensionPixelOffset(R.dimen.keyboard_extension_suggestions_stickers_top_bottom_offset);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.ui.i
 * JD-Core Version:    0.6.2
 */