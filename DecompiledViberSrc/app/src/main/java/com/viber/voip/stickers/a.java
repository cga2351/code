package com.viber.voip.stickers;

import android.content.Context;
import android.graphics.Bitmap;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.notif.e.v;
import com.viber.voip.util.dq;

abstract class a extends n
{
  private static final Logger a = ViberEnv.getLogger();
  private final int b;
  private final String c;
  private v d;

  a(Context paramContext, int paramInt, String paramString)
  {
    this.b = paramInt;
    this.c = paramString;
    this.d = com.viber.voip.notif.g.a(paramContext).c();
  }

  private Bitmap b()
  {
    return dq.a(com.viber.voip.stickers.c.g.k(this.b));
  }

  public void a()
  {
    this.d.a(this.b, this.c);
  }

  protected abstract void a(int paramInt);

  protected abstract void b(int paramInt);

  public void onStickerPackageDeployed(com.viber.voip.stickers.entity.a parama)
  {
    if (parama.e() != this.b)
      return;
    this.d.a(parama.e(), this.c, b());
    a(this.b);
  }

  public void onStickerPackageDownloadError(boolean paramBoolean, com.viber.voip.stickers.entity.a parama)
  {
    if (parama.e() != this.b)
      return;
    this.d.b(this.b, this.c, b());
    b(this.b);
  }

  public void onStickerPackageDownloading(com.viber.voip.stickers.entity.a parama, int paramInt)
  {
    if (parama.e() != this.b)
      return;
    if (paramInt < 100)
    {
      this.d.a(this.b, paramInt, this.c, b());
      return;
    }
    this.d.c(this.b, this.c, b());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.a
 * JD-Core Version:    0.6.2
 */