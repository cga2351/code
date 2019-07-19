package com.viber.voip.notif.e;

import android.content.Context;
import android.graphics.Bitmap;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.notif.c.o;
import com.viber.voip.notif.d.e.b;
import com.viber.voip.notif.d.j;
import com.viber.voip.notif.f;

public class v
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final o c;
  private final dagger.a<f> d;
  private final j e;
  private final com.viber.voip.notif.f.a f;

  v(Context paramContext, j paramj, dagger.a<f> parama)
  {
    this.b = paramContext;
    this.e = paramj;
    this.c = paramj.b();
    this.d = parama;
    this.f = ((com.viber.voip.notif.f.a)paramj.d().a(0));
  }

  private void a(com.viber.voip.notif.d.e parame)
  {
    try
    {
      parame.a(this.b, this.e).a((f)this.d.get());
      return;
    }
    catch (Exception localException)
    {
      a.a(localException, "Can't show notification!");
    }
  }

  public void a(int paramInt)
  {
    ((f)this.d.get()).a("sticker_package", paramInt);
  }

  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    a(com.viber.voip.notif.b.i.a.a(paramInt1, paramInt2, paramString, this.c, this.f.a(paramBitmap)));
  }

  public void a(int paramInt, String paramString)
  {
    a(com.viber.voip.notif.b.i.a.a(paramInt, paramString, this.c));
  }

  public void a(int paramInt, String paramString, Bitmap paramBitmap)
  {
    a(com.viber.voip.notif.b.i.a.a(paramInt, paramString, this.c, this.f.a(paramBitmap)));
  }

  public void b(int paramInt, String paramString, Bitmap paramBitmap)
  {
    a(com.viber.voip.notif.b.i.a.b(paramInt, paramString, this.c, this.f.a(paramBitmap)));
  }

  public void c(int paramInt, String paramString, Bitmap paramBitmap)
  {
    a(com.viber.voip.notif.b.i.a.c(paramInt, paramString, this.c, this.f.a(paramBitmap)));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.e.v
 * JD-Core Version:    0.6.2
 */