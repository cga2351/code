package com.getkeepsafe.taptargetview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

class e extends b
{
  final View o;

  e(View paramView, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    super(paramCharSequence1, paramCharSequence2);
    if (paramView == null)
      throw new IllegalArgumentException("Given null view to target");
    this.o = paramView;
  }

  public void a(final Runnable paramRunnable)
  {
    f.a(this.o, new Runnable()
    {
      public void run()
      {
        int[] arrayOfInt = new int[2];
        e.this.o.getLocationOnScreen(arrayOfInt);
        e.this.e = new Rect(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + e.this.o.getWidth(), arrayOfInt[1] + e.this.o.getHeight());
        if ((e.this.f == null) && (e.this.o.getWidth() > 0) && (e.this.o.getHeight() > 0))
        {
          Bitmap localBitmap = Bitmap.createBitmap(e.this.o.getWidth(), e.this.o.getHeight(), Bitmap.Config.ARGB_8888);
          Canvas localCanvas = new Canvas(localBitmap);
          e.this.o.draw(localCanvas);
          e.this.f = new BitmapDrawable(e.this.o.getContext().getResources(), localBitmap);
          e.this.f.setBounds(0, 0, e.this.f.getIntrinsicWidth(), e.this.f.getIntrinsicHeight());
        }
        paramRunnable.run();
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.getkeepsafe.taptargetview.e
 * JD-Core Version:    0.6.2
 */