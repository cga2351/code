package com.viber.voip.messages.conversation.adapter.a.c.a;

import android.content.Context;
import android.content.res.Resources;
import com.viber.voip.R.dimen;
import com.viber.voip.util.e.j;

public class g
{
  protected final int a;
  protected final int b;
  protected final int c;
  protected final int d;
  protected final int e;
  protected final int f;
  protected final int g;
  protected final int h;
  protected final int i;
  protected final int j;
  protected final int k;

  public g(Context paramContext)
  {
    this(paramContext, paramContext.getResources().getDimensionPixelSize(R.dimen.formatted_message_balloon_width));
  }

  public g(Context paramContext, int paramInt)
  {
    Resources localResources = paramContext.getResources();
    this.a = paramInt;
    int m = j.a(paramContext, 8.0F);
    this.d = m;
    this.f = m;
    this.g = m;
    this.i = m;
    this.h = m;
    this.b = (this.a - (this.f + this.i));
    this.j = j.a(paramContext, 4.0F);
    this.e = j.a(paramContext, 4.0F);
    this.k = (this.b / 2 - this.j / 2);
    this.c = localResources.getDimensionPixelSize(R.dimen.formatted_media_image_corner_radius);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.a.c.a.g
 * JD-Core Version:    0.6.2
 */