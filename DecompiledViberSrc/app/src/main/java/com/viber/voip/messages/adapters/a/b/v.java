package com.viber.voip.messages.adapters.a.b;

import android.widget.ImageView;
import com.viber.voip.R.drawable;
import com.viber.voip.messages.adapters.a.c;
import com.viber.voip.messages.adapters.a.c.a;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.f.a;
import com.viber.voip.util.e.f.b;

public class v extends com.viber.voip.ui.g.e<c, a>
{
  private final com.viber.voip.util.e.e a;
  private final f b;
  private final ImageView c;

  public v(ImageView paramImageView, com.viber.voip.util.e.e parame)
  {
    this.a = parame;
    this.c = paramImageView;
    this.b = new f.a().a(Integer.valueOf(R.drawable.ic_vibe_loading)).b(Integer.valueOf(R.drawable.ic_vibe_loading)).a(f.b.b).c();
  }

  public void a(c paramc, a parama)
  {
    super.a(paramc, parama);
    this.a.a(paramc.o(), this.c, this.b);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.a.b.v
 * JD-Core Version:    0.6.2
 */