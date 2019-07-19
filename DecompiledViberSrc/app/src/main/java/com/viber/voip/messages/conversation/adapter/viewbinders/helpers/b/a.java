package com.viber.voip.messages.conversation.adapter.viewbinders.helpers.b;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.c.a.h;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.m;
import com.viber.voip.settings.d.ab;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.h.a;

public class a
  implements b, h.a
{
  private ImageView a;
  private com.viber.voip.messages.conversation.adapter.a.a b;
  private i c;

  private void a(aa paramaa, i parami)
  {
    if (this.a == null)
      return;
    if ((paramaa.aq()) || (paramaa.ar()) || (paramaa.f() == -2));
    for (Drawable localDrawable = parami.ag().a(paramaa); ; localDrawable = null)
    {
      dj.a(this.a, localDrawable);
      return;
    }
  }

  private boolean a(aa paramaa)
  {
    return (d.ab.e.d()) && (!paramaa.ay()) && (paramaa.bE());
  }

  public void a()
  {
    this.a = null;
    this.b = null;
    this.c = null;
  }

  public void a(ImageView paramImageView, com.viber.voip.messages.conversation.adapter.a.a parama, i parami)
  {
    this.a = paramImageView;
    this.b = parama;
    this.c = parami;
    aa localaa = parama.c();
    parami.T().a(localaa.bo(), paramImageView, parami.a(localaa, a(localaa)), this, localaa.a(), localaa.C(), localaa.o(), localaa.q(), localaa.bx().getThumbnailEP(), m.a(localaa.A()));
  }

  public void onLoadComplete(Uri paramUri, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (this.a == null);
    while ((!paramBoolean) || (this.b == null) || (this.c == null))
      return;
    a(this.b.c(), this.c);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.b.a
 * JD-Core Version:    0.6.2
 */