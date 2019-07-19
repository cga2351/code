package com.viber.voip.messages.ui.d.b;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.stickers.i;
import com.viber.voip.stickers.p;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.cl;
import com.viber.voip.ui.dialogs.n;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;

public class g extends a<h>
{
  private static final Logger h = ViberEnv.getLogger();
  private Uri i;

  g(Context paramContext, i parami, com.viber.voip.analytics.g paramg)
  {
    super(paramContext, parami, paramg);
  }

  protected void a()
  {
    this.e.o(this.d);
  }

  public void a(int paramInt)
  {
    super.a(paramInt);
    if ((!this.e.i(paramInt)) && (!this.e.j(paramInt)));
    for (boolean bool = true; ; bool = false)
    {
      ((h)this.c).setActionsEnabled(bool);
      return;
    }
  }

  protected void a(com.viber.voip.stickers.entity.a parama)
  {
    this.i = Uri.parse(com.viber.voip.stickers.c.g.b(parama.e(), p.c));
    this.g.a(this.i, f.a(), this);
  }

  public void b()
  {
    n.b().a(new ViberDialogHandlers.cl()).d();
  }

  public void b(int paramInt)
  {
    if (paramInt == this.d)
      ((h)this.c).setActionsEnabled(false);
  }

  public void c()
  {
    this.e.r(this.d);
  }

  public void c(int paramInt)
  {
    if (paramInt == this.d)
      ((h)this.c).setActionsEnabled(true);
  }

  public void onLoadComplete(Uri paramUri, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramUri.equals(this.i))
      ((h)this.c).setThumbnail(new BitmapDrawable(ViberApplication.getApplication().getResources(), paramBitmap));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.d.b.g
 * JD-Core Version:    0.6.2
 */