package com.viber.voip.messages.ui.fm;

import android.content.Context;
import android.widget.ImageView;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.e.b;
import com.viber.voip.messages.orm.entity.json.ImageMessage;
import com.viber.voip.util.e.f.a;

public class g extends h<ImageView, ImageMessage>
{
  private final ImageMessage m;

  public g(ImageMessage paramImageMessage, Context paramContext, a parama, i parami, b paramb)
  {
    super(paramImageMessage, paramContext, parama, parami, paramb);
    this.m = paramImageMessage;
  }

  public void a(ImageView paramImageView)
  {
    super.a(paramImageView);
    this.l.a(paramImageView);
  }

  protected f.a d()
  {
    if (!this.g)
      return super.d();
    return super.d().a(3145728);
  }

  public ImageView g()
  {
    return this.l.a();
  }

  public ImageMessage j()
  {
    return this.m;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.fm.g
 * JD-Core Version:    0.6.2
 */