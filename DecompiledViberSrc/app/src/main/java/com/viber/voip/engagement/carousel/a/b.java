package com.viber.voip.engagement.carousel.a;

import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import com.viber.voip.R.id;
import com.viber.voip.util.dj;

public abstract class b<T> extends RecyclerView.ViewHolder
{
  protected boolean a;
  protected final View b;
  protected final ImageView c;

  protected b(View paramView, int paramInt1, int paramInt2)
  {
    super(paramView);
    paramView.setLayoutParams(new RecyclerView.LayoutParams(paramInt1, paramInt2));
    this.b = paramView.findViewById(R.id.engagement_media_item_progress);
    this.c = ((ImageView)paramView.findViewById(R.id.engagement_media_item_image));
  }

  protected void a(T paramT, int paramInt, boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  protected void a(boolean paramBoolean)
  {
    dj.b(this.b, paramBoolean);
  }

  public boolean a()
  {
    return this.b.getVisibility() == 0;
  }

  protected void b(boolean paramBoolean)
  {
    dj.b(this.c, paramBoolean);
  }

  public void c(boolean paramBoolean)
  {
    if (this.a != paramBoolean)
    {
      this.a = paramBoolean;
      d(this.a);
    }
  }

  protected abstract void d(boolean paramBoolean);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.carousel.a.b
 * JD-Core Version:    0.6.2
 */