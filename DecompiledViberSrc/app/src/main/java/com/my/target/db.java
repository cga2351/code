package com.my.target;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;

public final class db extends FrameLayout
{
  private final ImageView a;

  public db(Context paramContext)
  {
    super(paramContext);
    this.a = new ImageView(paramContext);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    addView(this.a, localLayoutParams);
  }

  public final void setImageBitmap(Bitmap paramBitmap)
  {
    this.a.setImageBitmap(paramBitmap);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.db
 * JD-Core Version:    0.6.2
 */