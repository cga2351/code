package com.viber.voip.publicaccount.ui.holders.background;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import com.viber.voip.R.id;
import com.viber.voip.widget.ImageViewWithDescription;

class d
  implements c
{
  private final ImageViewWithDescription a;

  public d(View paramView, View.OnClickListener paramOnClickListener)
  {
    this.a = ((ImageViewWithDescription)paramView.findViewById(R.id.txt_background));
    this.a.setOnClickListener(paramOnClickListener);
  }

  public void a()
  {
    this.a.setOnClickListener(null);
  }

  public void a(Bitmap paramBitmap)
  {
    this.a.setImageBitmap(paramBitmap);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.background.d
 * JD-Core Version:    0.6.2
 */