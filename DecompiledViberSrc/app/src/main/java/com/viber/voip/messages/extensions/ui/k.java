package com.viber.voip.messages.extensions.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.viber.voip.R.attr;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.messages.extensions.model.d;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import com.viber.voip.widget.ProgressBar;

abstract class k extends j
{
  private int a;
  protected final View n;
  protected final TextView o;
  protected final TextView p;

  public k(View paramView, l.a parama)
  {
    super(paramView, parama);
    this.n = paramView.findViewById(R.id.keyboard_extension_suggestion_text_specification);
    this.o = ((TextView)paramView.findViewById(R.id.keyboard_extension_suggestion_text_specification_title));
    this.p = ((TextView)paramView.findViewById(R.id.keyboard_extension_suggestion_text_specification_description));
  }

  protected ImageView.ScaleType a()
  {
    return ImageView.ScaleType.CENTER_CROP;
  }

  protected void a(Context paramContext)
  {
    super.a(paramContext);
    this.a = dc.d(paramContext, R.attr.conversationKeyboardExtGifItemThumbnailProgressColor);
  }

  public void a(d paramd)
  {
    super.a(paramd);
    g(paramd);
  }

  protected ImageView.ScaleType b()
  {
    return ImageView.ScaleType.CENTER_INSIDE;
  }

  protected Drawable c()
  {
    return ContextCompat.getDrawable(this.c.getContext(), R.drawable.ic_keyboard_extension_generic_image_dark);
  }

  protected void c(d paramd)
  {
    super.c(paramd);
    this.c.setBackgroundColor(this.j);
    this.f.setProgressColor(this.a);
  }

  protected int d()
  {
    return 0;
  }

  protected Pair<Integer, Integer> d(d paramd)
  {
    int i = this.h;
    if (!paramd.e());
    for (int j = this.h * paramd.a(this.h) / paramd.b(this.h); ; j = this.h)
      return Pair.create(Integer.valueOf(j), Integer.valueOf(i));
  }

  protected int e()
  {
    return super.e() - 2 * this.l.getDimensionPixelOffset(R.dimen.keyboard_extension_suggestions_top_bottom_offset);
  }

  protected void g(d paramd)
  {
    if (paramd.e())
    {
      h(paramd);
      i(paramd);
      dj.b(this.n, true);
      return;
    }
    dj.b(this.n, false);
  }

  protected void h(d paramd)
  {
    if (paramd.c())
    {
      this.o.setText(paramd.b());
      dj.b(this.o, true);
      return;
    }
    dj.b(this.o, false);
  }

  protected void i(d paramd)
  {
    if (paramd.d())
    {
      this.p.setText(paramd.f());
      dj.b(this.p, true);
      return;
    }
    dj.b(this.p, false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.ui.k
 * JD-Core Version:    0.6.2
 */