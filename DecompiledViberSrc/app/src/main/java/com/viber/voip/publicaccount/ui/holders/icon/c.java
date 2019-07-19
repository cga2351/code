package com.viber.voip.publicaccount.ui.holders.icon;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.viber.voip.R.id;
import com.viber.voip.util.dj;

class c
  implements b
{
  private final ImageView a;
  private final View b;

  private c()
  {
    this.a = null;
    this.b = null;
  }

  public c(View paramView, View.OnClickListener paramOnClickListener)
  {
    this.a = ((ImageView)paramView.findViewById(R.id.public_account_icon));
    this.a.setOnClickListener(paramOnClickListener);
    this.b = paramView.findViewById(R.id.public_account_icon_text);
    this.b.setOnClickListener(paramOnClickListener);
  }

  public void a()
  {
    this.a.setOnClickListener(null);
    this.b.setOnClickListener(null);
  }

  public void a(Bitmap paramBitmap)
  {
    this.a.setImageBitmap(paramBitmap);
  }

  public void a(boolean paramBoolean)
  {
    dj.b(this.a, paramBoolean);
    dj.b(this.b, paramBoolean);
  }

  public void b()
  {
    this.b.setVisibility(8);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.icon.c
 * JD-Core Version:    0.6.2
 */