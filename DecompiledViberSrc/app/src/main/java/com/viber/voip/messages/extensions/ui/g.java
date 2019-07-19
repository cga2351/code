package com.viber.voip.messages.extensions.ui;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.viber.voip.messages.controller.y;
import com.viber.voip.messages.controller.y.a;
import com.viber.voip.messages.controller.z;
import com.viber.voip.messages.extensions.model.d;
import com.viber.voip.util.dv;
import pl.droidsonroids.gif.b;

final class g extends k
{
  private final y a = y.a();
  private y.a b = new y.a()
  {
    public void a(ImageView paramAnonymousImageView, b paramAnonymousb)
    {
      z.a(this, paramAnonymousImageView, paramAnonymousb);
    }

    public void a(b paramAnonymousb, String paramAnonymousString, Uri paramAnonymousUri)
    {
      g localg = g.this;
      if (paramAnonymousb == null);
      for (boolean bool = true; ; bool = false)
      {
        localg.a(bool);
        return;
      }
    }

    public void b(b paramAnonymousb, String paramAnonymousString, Uri paramAnonymousUri)
    {
      z.a(this, paramAnonymousb, paramAnonymousString, paramAnonymousUri);
    }
  };

  public g(View paramView, l.a parama)
  {
    super(paramView, parama);
  }

  protected void b(d paramd)
  {
    super.b(paramd);
    this.a.a(paramd.g(), paramd.h(), this.c, this.b, 2097152, dv.D);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.ui.g
 * JD-Core Version:    0.6.2
 */