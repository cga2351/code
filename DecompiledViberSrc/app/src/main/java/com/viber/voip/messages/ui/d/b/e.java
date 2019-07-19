package com.viber.voip.messages.ui.d.b;

import android.content.Context;
import com.viber.voip.analytics.g;
import com.viber.voip.market.StickerMarketActivity;
import com.viber.voip.stickers.i;
import com.viber.voip.util.cj;

public class e extends a<f>
{
  public e(Context paramContext, i parami, g paramg)
  {
    super(paramContext, parami, paramg);
  }

  protected void a()
  {
    if (cj.c(((f)this.c).getContext()))
      StickerMarketActivity.a(StickerMarketActivity.a(this.d, true, 5, "Promoted Sticker Pack", "Product Page"));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.d.b.e
 * JD-Core Version:    0.6.2
 */