package com.viber.voip.util.e.a;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.h.a;

public class a
  implements h.a
{
  private View a;

  public a(View paramView)
  {
    this.a = paramView;
  }

  public void onLoadComplete(Uri paramUri, Bitmap paramBitmap, boolean paramBoolean)
  {
    BitmapDrawable localBitmapDrawable = null;
    if (paramBitmap != null)
    {
      localBitmapDrawable = new BitmapDrawable(this.a.getResources(), paramBitmap);
      localBitmapDrawable.setDither(true);
    }
    dj.a(this.a, localBitmapDrawable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.e.a.a
 * JD-Core Version:    0.6.2
 */