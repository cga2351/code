package com.viber.voip.messages.extensions.ui;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import com.viber.voip.messages.extensions.model.d;
import com.viber.voip.util.dx;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.f.a;
import com.viber.voip.util.e.h.a;

final class h extends k
{
  protected final e a;
  protected final f b;
  private h.a q = new h.a()
  {
    public void onLoadComplete(Uri paramAnonymousUri, Bitmap paramAnonymousBitmap, boolean paramAnonymousBoolean)
    {
      h localh = h.this;
      if (paramAnonymousBitmap == null);
      for (boolean bool = true; ; bool = false)
      {
        localh.a(bool);
        return;
      }
    }
  };

  public h(View paramView, l.a parama)
  {
    super(paramView, parama);
    this.a = e.a(paramView.getContext());
    this.b = f.a().f().a(2097152).c();
  }

  protected void b(d paramd)
  {
    super.b(paramd);
    Uri localUri = dx.c(paramd.g());
    this.a.a(localUri, this.c, this.b, this.q);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.ui.h
 * JD-Core Version:    0.6.2
 */