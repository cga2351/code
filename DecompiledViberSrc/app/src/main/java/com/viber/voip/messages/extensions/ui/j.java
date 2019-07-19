package com.viber.voip.messages.extensions.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.viber.voip.R.attr;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.messages.extensions.model.d;
import com.viber.voip.util.dc;
import com.viber.voip.util.df;
import com.viber.voip.util.dj;
import com.viber.voip.widget.ProgressBar;

abstract class j extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  protected final ImageView c;
  protected final View d;
  protected final View e;
  protected final ProgressBar f;
  protected final l.a g;
  protected int h;
  protected int i;
  protected int j;
  protected int k;
  protected final Resources l;
  protected d m;

  public j(View paramView, l.a parama)
  {
    super(paramView);
    this.g = parama;
    this.l = paramView.getResources();
    this.c = ((ImageView)paramView.findViewById(R.id.suggestion_thumbnail));
    this.d = paramView.findViewById(R.id.suggestion_thumbnail_play_frame);
    this.e = paramView.findViewById(R.id.suggestion_thumbnail_progress_frame);
    this.f = ((ProgressBar)paramView.findViewById(R.id.suggestion_thumbnail_progress));
    a(paramView.getContext());
  }

  private Drawable a(Drawable paramDrawable)
  {
    if (paramDrawable == null)
      return null;
    int n = g();
    ColorStateList localColorStateList = null;
    if (n == 0);
    while (true)
    {
      return df.a(paramDrawable, localColorStateList, false);
      localColorStateList = ColorStateList.valueOf(n);
    }
  }

  private void b(boolean paramBoolean)
  {
    if (this.e != null)
    {
      dj.b(this.e, paramBoolean);
      return;
    }
    dj.b(this.f, paramBoolean);
  }

  private int g()
  {
    return dc.d(this.c.getContext(), R.attr.conversationListItemIconTintColor);
  }

  protected abstract ImageView.ScaleType a();

  protected void a(Context paramContext)
  {
    this.h = e();
    this.i = (this.l.getDimensionPixelSize(R.dimen.keyboard_extension_suggestions_thumbnail_progress_size) + 2 * this.l.getDimensionPixelSize(R.dimen.keyboard_extension_suggestions_thumbnail_progress_min_side_offset));
    this.j = dc.d(paramContext, R.attr.conversationKeyboardExtSuggestionThumbnailBackground);
    this.k = dc.d(paramContext, R.attr.conversationKeyboardExtSuggestionsItemThumbnailProgressColor);
  }

  public void a(d paramd)
  {
    this.m = paramd;
    this.itemView.setOnClickListener(this);
    dj.b(this.d, false);
    f(paramd);
  }

  protected final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.c.setScaleType(b());
      this.c.setImageDrawable(a(c()));
    }
    while (true)
    {
      b(false);
      return;
      this.c.setBackgroundResource(d());
      f();
    }
  }

  protected abstract ImageView.ScaleType b();

  protected void b(d paramd)
  {
  }

  protected abstract Drawable c();

  protected void c(d paramd)
  {
  }

  protected abstract int d();

  protected Pair<Integer, Integer> d(d paramd)
  {
    return Pair.create(Integer.valueOf(this.h), Integer.valueOf(this.h));
  }

  protected int e()
  {
    return this.l.getDimensionPixelOffset(R.dimen.keyboard_extension_suggestions_height);
  }

  protected void e(d paramd)
  {
    Pair localPair = d(paramd);
    int n = Math.min(((Integer)localPair.second).intValue(), this.h);
    int i1 = Math.max(((Integer)localPair.first).intValue(), this.i);
    if (i1 > 4 * this.h)
      i1 = this.h;
    ViewGroup.LayoutParams localLayoutParams = this.c.getLayoutParams();
    if ((localLayoutParams.width != i1) || (localLayoutParams.height != n))
    {
      localLayoutParams.width = i1;
      localLayoutParams.height = n;
      this.c.setLayoutParams(localLayoutParams);
    }
  }

  protected final void f()
  {
    dj.b(this.d, this.m.o());
  }

  protected void f(d paramd)
  {
    e(paramd);
    this.c.setScaleType(a());
    c(paramd);
    b(true);
    b(paramd);
  }

  public void onClick(View paramView)
  {
    if (this.g != null)
      this.g.a(paramView, this.m);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.ui.j
 * JD-Core Version:    0.6.2
 */