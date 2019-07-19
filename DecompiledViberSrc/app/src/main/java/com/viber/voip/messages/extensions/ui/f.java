package com.viber.voip.messages.extensions.ui;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView.ScaleType;
import com.viber.voip.R.id;
import com.viber.voip.messages.extensions.model.d;

final class f extends j
{
  private View a;

  public f(View paramView)
  {
    super(paramView, null);
    this.a = paramView.findViewById(R.id.loading_view);
  }

  protected ImageView.ScaleType a()
  {
    return null;
  }

  public void a(d paramd)
  {
    ((AnimationDrawable)this.a.getBackground()).start();
  }

  protected ImageView.ScaleType b()
  {
    return null;
  }

  protected Drawable c()
  {
    return null;
  }

  protected int d()
  {
    return 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.ui.f
 * JD-Core Version:    0.6.2
 */