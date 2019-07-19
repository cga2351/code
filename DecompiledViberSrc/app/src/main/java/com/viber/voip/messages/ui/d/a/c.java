package com.viber.voip.messages.ui.d.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.widget.Checkable;
import android.widget.ImageView;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;

class c extends ImageView
  implements Checkable
{
  private static final int[] a = { 16842912 };
  private static final int[] b = new int[0];
  private boolean c;
  private a.a d;
  private boolean e;
  private int f;
  private int g;
  private int h;
  private int i;
  private Drawable j;
  private Drawable k;
  private Drawable l;
  private Drawable m;
  private boolean n;

  public c(Context paramContext)
  {
    super(paramContext);
    a();
  }

  private void a()
  {
    this.f = getResources().getDimensionPixelSize(R.dimen.sticker_menu_item_top_badge_horizontal_padding);
    this.g = getResources().getDimensionPixelSize(R.dimen.sticker_menu_item_top_badge_vertical_padding);
    this.h = getResources().getDimensionPixelSize(R.dimen.sticker_menu_item_bottom_badge_horizontal_padding);
    this.i = getResources().getDimensionPixelSize(R.dimen.sticker_menu_item_bottom_badge_vertical_padding);
    this.j = ContextCompat.getDrawable(getContext(), R.drawable.blue_dot_notification);
    this.k = ContextCompat.getDrawable(getContext(), R.drawable.ic_download_sticker_package);
    this.l = ContextCompat.getDrawable(getContext(), R.drawable.ic_sticker_pack_anim);
    this.m = ContextCompat.getDrawable(getContext(), R.drawable.ic_sticker_pack_sound);
  }

  public void a(a.a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.d = parama;
    this.c = paramBoolean1;
    this.e = paramBoolean2;
    invalidate();
  }

  public boolean isChecked()
  {
    return this.n;
  }

  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked())
      mergeDrawableStates(arrayOfInt, a);
    return arrayOfInt;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.d == a.a.b)
      this.j.draw(paramCanvas);
    do
      while ((this.c) && (!this.e))
      {
        this.l.draw(paramCanvas);
        return;
        if (this.d == a.a.c)
          this.k.draw(paramCanvas);
      }
    while (!this.e);
    this.m.draw(paramCanvas);
  }

  public void setChecked(boolean paramBoolean)
  {
    if (this.n == paramBoolean)
      return;
    this.n = paramBoolean;
    Drawable localDrawable;
    if (this.d == a.a.c)
    {
      localDrawable = this.k;
      if (!paramBoolean)
        break label48;
    }
    label48: for (int[] arrayOfInt = a; ; arrayOfInt = b)
    {
      localDrawable.setState(arrayOfInt);
      refreshDrawableState();
      return;
    }
  }

  protected boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
    this.j.setBounds(new Rect(getWidth() - this.j.getIntrinsicWidth() - this.f, this.g, getWidth() - this.f, this.j.getIntrinsicHeight() + this.g));
    this.k.setBounds(new Rect(getWidth() - this.k.getIntrinsicWidth() - this.f, this.g, getWidth() - this.f, this.k.getIntrinsicHeight() + this.g));
    this.l.setBounds(new Rect(getWidth() - this.l.getIntrinsicWidth() - this.h, getHeight() - this.l.getIntrinsicHeight() - this.i, getWidth() - this.h, getHeight() - this.i));
    this.m.setBounds(new Rect(getWidth() - this.m.getIntrinsicWidth() - this.h, getHeight() - this.m.getIntrinsicHeight() - this.i, getWidth() - this.h, getHeight() - this.i));
    return bool;
  }

  public void toggle()
  {
    if (!this.n);
    for (boolean bool = true; ; bool = false)
    {
      setChecked(bool);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.d.a.c
 * JD-Core Version:    0.6.2
 */