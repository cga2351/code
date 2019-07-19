package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.net.Uri;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.h;
import com.viber.voip.messages.conversation.adapter.a.c.a.h.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.dj;
import com.viber.voip.util.upload.l;
import com.viber.voip.util.upload.m;
import com.viber.voip.util.upload.s;
import com.viber.voip.util.upload.t;
import com.viber.voip.widget.PlayableImageView;

public class ae extends e<a, i>
  implements m
{
  private final PlayableImageView a;

  public ae(PlayableImageView paramPlayableImageView)
  {
    this.a = paramPlayableImageView;
    t.a(this);
  }

  private boolean a(aa paramaa, i parami)
  {
    if ((!paramaa.az()) || (paramaa.bE()));
    while ((parami.B() == paramaa.a()) || ((-1 == paramaa.f()) && (paramaa.ap())) || (2 == paramaa.z()) || (paramaa.z() == 0))
      return true;
    return false;
  }

  private boolean a(h paramh, long paramLong, h.a parama)
  {
    h.a locala = paramh.a(paramLong);
    if ((locala != null) && (parama != locala));
    for (boolean bool = true; ; bool = false)
    {
      paramh.a(paramLong, parama);
      return bool;
    }
  }

  public void a(Uri paramUri, int paramInt)
  {
    i locali = (i)e();
    if (locali == null);
    a locala;
    do
    {
      return;
      locala = (a)d();
    }
    while ((locala == null) || (!paramUri.equals(locali.ag().b(locala.c()))));
    this.a.post(new af(this, paramInt));
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    aa localaa = parama.c();
    if (a(localaa, parami))
    {
      dj.c(this.a, true);
      this.a.c();
      h localh = parami.ag();
      int i = localaa.z();
      if ((-1 != localaa.f()) && (3 == i))
        this.a.a(a(localh, localaa.a(), h.a.a));
      Integer localInteger;
      while (true)
      {
        return;
        if ((localaa.ap()) && (-1 == localaa.f()))
        {
          this.a.c(a(localh, localaa.a(), h.a.e));
          return;
        }
        Uri localUri = localh.b(localaa);
        localInteger = l.e(localUri);
        if (4 != i)
          break;
        if (s.a(localUri))
        {
          this.a.b(a(localh, localaa.a(), h.a.b));
          localh.a(localaa.a(), h.a.b);
        }
        while ((localInteger != null) && (localInteger.intValue() < 100))
        {
          this.a.a(localInteger.intValue() / 100.0D);
          return;
          this.a.d(a(localh, localaa.a(), h.a.c));
        }
      }
      this.a.e(a(localh, localaa.a(), h.a.d));
      if (localInteger == null)
      {
        this.a.b();
        return;
      }
      this.a.a(localInteger.intValue() / 100.0D);
      return;
    }
    dj.c(this.a, false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.ae
 * JD-Core Version:    0.6.2
 */