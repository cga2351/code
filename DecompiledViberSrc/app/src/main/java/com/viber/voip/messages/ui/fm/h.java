package com.viber.voip.messages.ui.fm;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.viber.voip.R.dimen;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.e.b;
import com.viber.voip.messages.orm.entity.json.MediaMessage;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.f.a;

abstract class h<V extends View, M extends MediaMessage> extends a<V>
{
  final boolean g;
  final float h;
  final e i;
  final f j;
  final M k;
  final k<M> l;

  h(M paramM, Context paramContext, com.viber.voip.messages.conversation.adapter.a.a parama, i parami, b paramb)
  {
    super(paramM, paramContext, parama, parami, paramb);
    this.k = paramM;
    this.g = this.c.U();
    this.h = parami.j(false);
    this.i = e.a(paramContext);
    this.j = d().c();
    this.l = new k(paramContext, paramM, parama, parami, this.i, this.j, this.h);
  }

  public int b()
  {
    return 0;
  }

  public int c()
  {
    return 0;
  }

  protected f.a d()
  {
    return new f.a().b(false).a(this.k.getThumbnailWidth(), this.k.getThumbnailHeight());
  }

  public int e()
  {
    return this.a.getResources().getDimensionPixelOffset(R.dimen.formatted_message_media_margin_top);
  }

  public int f()
  {
    return this.a.getResources().getDimensionPixelOffset(R.dimen.formatted_message_media_margin_bottom);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.fm.h
 * JD-Core Version:    0.6.2
 */