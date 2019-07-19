package com.viber.voip.messages.conversation.chatinfo.e;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import com.viber.voip.R.attr;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.util.dc;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f.a;
import com.viber.voip.util.e.g;
import com.viber.voip.widget.a.c;
import javax.annotation.Nonnull;

public final class a
{
  private final e a;
  private final g b;
  private final com.viber.voip.util.e.f c;
  private final com.viber.voip.util.e.f d;
  private final com.viber.voip.util.e.f e;
  private final com.viber.voip.util.e.f f;
  private final com.viber.voip.util.e.f g;
  private final RecyclerView.ItemDecoration h;
  private final com.viber.voip.util.links.f i;

  public a(@Nonnull Context paramContext, e parame, g paramg, @Nonnull com.viber.voip.util.links.f paramf)
  {
    this.a = parame;
    this.b = paramg;
    this.i = paramf;
    int j = dc.a(paramContext, R.attr.chatInfoHeadAvatarBackground);
    this.c = new f.a().b(false).a(Integer.valueOf(j)).b(Integer.valueOf(j)).c();
    this.d = com.viber.voip.util.e.f.a(paramContext);
    this.e = com.viber.voip.util.e.f.b(paramContext);
    this.h = new c(paramContext.getResources().getDimensionPixelSize(R.dimen.public_account_info_recent_media_divider_size), false);
    int k = paramContext.getResources().getDimensionPixelSize(R.dimen.public_account_info_recent_media_image_size);
    this.f = new f.a().a(Integer.valueOf(R.drawable.bg_loading_gallery_image)).a(k, k).e(true).c();
    this.g = this.f.f().c();
  }

  public e a()
  {
    return this.a;
  }

  public g b()
  {
    return this.b;
  }

  public com.viber.voip.util.e.f c()
  {
    return this.c;
  }

  public com.viber.voip.util.e.f d()
  {
    return this.d;
  }

  public com.viber.voip.util.e.f e()
  {
    return this.e;
  }

  public RecyclerView.ItemDecoration f()
  {
    return this.h;
  }

  public com.viber.voip.util.e.f g()
  {
    return this.f;
  }

  public com.viber.voip.util.e.f h()
  {
    return this.g;
  }

  public com.viber.voip.util.links.f i()
  {
    return this.i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.e.a
 * JD-Core Version:    0.6.2
 */