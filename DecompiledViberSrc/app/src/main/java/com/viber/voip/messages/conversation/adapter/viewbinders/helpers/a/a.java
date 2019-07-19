package com.viber.voip.messages.conversation.adapter.viewbinders.helpers.a;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo;
import com.viber.voip.flatbuffers.model.msginfo.MediaInfo;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.messages.controller.y;
import com.viber.voip.messages.controller.y.a;
import com.viber.voip.messages.controller.y.d;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.d.l;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;

public class a
  implements com.viber.voip.messages.conversation.adapter.viewbinders.helpers.b.b
{
  private final y a;
  private final y.a b;
  private final y.d c = new y.d()
  {
    public void O_()
    {
      a.b(a.this);
    }

    public void g()
    {
      a.a(a.this);
    }
  };
  private ImageView d;
  private com.viber.voip.messages.conversation.adapter.a.a e;

  public a(y paramy)
  {
    this.a = paramy;
    this.b = new b(this);
  }

  private void a(com.viber.voip.messages.conversation.aa paramaa, i parami)
  {
    MediaInfo localMediaInfo = paramaa.bz().getMediaInfo();
    f localf = parami.a(localMediaInfo.getWidth(), localMediaInfo.getHeight());
    parami.T().a(paramaa.bo(), this.d, localf, null, paramaa.a(), paramaa.B(), paramaa.o(), paramaa.q(), paramaa.bx().getThumbnailEP(), paramaa.aT());
  }

  private l b()
  {
    if (this.e != null)
      return this.e.d();
    return null;
  }

  private void c()
  {
    l locall = b();
    if ((locall == null) || (this.d == null))
      return;
    this.a.a(y.a(locall), this.d.getDrawable());
  }

  private void d()
  {
    l locall = b();
    if ((locall == null) || (this.d == null))
      return;
    this.a.b(y.a(locall), this.d.getDrawable());
  }

  public void a()
  {
    this.d = null;
    this.e = null;
    this.a.b(this.c);
  }

  public void a(ImageView paramImageView, com.viber.voip.messages.conversation.adapter.a.a parama, i parami)
  {
    this.d = paramImageView;
    this.e = parama;
    l locall = parama.d();
    com.viber.voip.messages.conversation.aa localaa = parama.c();
    String str1 = localaa.o();
    if (!TextUtils.isEmpty(str1));
    for (int i = 1; ; i = 0)
    {
      Drawable localDrawable = this.d.getDrawable();
      if ((i != 0) && ((localDrawable instanceof pl.droidsonroids.gif.b)))
      {
        pl.droidsonroids.gif.b localb = (pl.droidsonroids.gif.b)localDrawable;
        String str2 = y.a(locall);
        com.viber.voip.messages.controller.aa localaa1 = this.a.a(str2);
        if (localaa1 != null)
        {
          localaa1.a = localb.isPlaying();
          this.a.b(str2, localaa1);
        }
      }
      a(localaa, parami);
      int j;
      if (localaa.f() != 1)
      {
        int k = localaa.f();
        j = 0;
        if (k != 2);
      }
      else
      {
        j = 1;
      }
      if ((i != 0) && (j != 0))
        this.a.a(locall, Uri.parse(str1), this.d, this.b);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.a.a
 * JD-Core Version:    0.6.2
 */