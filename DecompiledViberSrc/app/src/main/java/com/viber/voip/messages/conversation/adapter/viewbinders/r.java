package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.net.Uri;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.d.g;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.dx;
import com.viber.voip.util.upload.l;
import com.viber.voip.util.upload.m;
import com.viber.voip.widget.FileIconView.a;
import com.viber.voip.widget.FileIconView.e;

public class r extends e<a, i>
{
  private static final Logger a = ViberEnv.getLogger();
  private final com.viber.voip.messages.conversation.adapter.viewbinders.helpers.file.b b;
  private final com.viber.voip.messages.conversation.adapter.viewbinders.helpers.media.b c;
  private Uri d;
  private volatile int e;
  private final m f;
  private final Runnable g;
  private final g h;

  public r(com.viber.voip.messages.conversation.adapter.viewbinders.helpers.file.b paramb)
  {
    this(paramb, null);
  }

  public r(com.viber.voip.messages.conversation.adapter.viewbinders.helpers.file.b paramb, com.viber.voip.messages.conversation.adapter.viewbinders.helpers.media.b paramb1)
  {
    this.b = paramb;
    this.c = paramb1;
    this.g = new s(this);
    this.f = new t(this);
    this.h = new u(this, paramb);
  }

  private void a(aa paramaa)
  {
    this.e = 0;
    this.b.a(paramaa);
    FileIconView.e locale;
    if (!TextUtils.isEmpty(paramaa.o()))
    {
      this.d = dx.b(paramaa);
      locale = this.b.b();
      switch (paramaa.f())
      {
      default:
      case 1:
      case 2:
      case 0:
      case 3:
      case 4:
      case 5:
      case -1:
      }
    }
    FileIconView.a locala;
    do
    {
      do
      {
        return;
        g();
        this.b.a();
        return;
        f();
        return;
        g();
        locale.b();
        return;
        this.d = dx.a(paramaa);
        locala = this.b.c();
        if (com.viber.voip.util.upload.s.a(this.d))
        {
          f();
          return;
        }
        if (paramaa.f() == -1)
        {
          g();
          locala.c();
          return;
        }
        g();
        switch (paramaa.z())
        {
        default:
          return;
        case 2:
        case 3:
        case 4:
        case 11:
        }
      }
      while (!paramaa.ad());
      locala.a();
      return;
      locala.b();
      return;
      if ((this.c == null) || (!this.c.a(paramaa)))
        break;
    }
    while (!this.c.b(paramaa));
    a(paramaa);
    return;
    locala.a();
    return;
    locala.a();
  }

  private void f()
  {
    l.a(this.f);
    Integer localInteger = l.e(this.d);
    if (localInteger != null);
    for (int i = localInteger.intValue(); ; i = 0)
    {
      this.e = i;
      this.g.run();
      return;
    }
  }

  private void g()
  {
    l.b(this.f);
    this.b.b(this.g);
  }

  public void a()
  {
    l.b(this.f);
    super.a();
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    a(parama.c());
  }

  public g b()
  {
    return this.h;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.r
 * JD-Core Version:    0.6.2
 */