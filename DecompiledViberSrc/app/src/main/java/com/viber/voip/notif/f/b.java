package com.viber.voip.notif.f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import com.viber.voip.R.drawable;
import com.viber.voip.model.entity.h;
import com.viber.voip.model.entity.m;
import com.viber.voip.util.dq;
import com.viber.voip.util.dx;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.j;
import java.util.List;

public class b
  implements d
{
  private final Context a;
  private final dagger.a<com.viber.voip.messages.d.b> b;
  private final com.viber.voip.b.d c;
  private final int d;
  private final int e;

  b(Context paramContext, dagger.a<com.viber.voip.messages.d.b> parama, com.viber.voip.b.d paramd)
  {
    this.a = paramContext;
    this.b = parama;
    this.c = paramd;
    this.d = this.a.getResources().getDimensionPixelSize(17104901);
    this.e = this.a.getResources().getDimensionPixelSize(17104902);
  }

  private Bitmap a(Uri paramUri)
  {
    if (paramUri == null)
      return null;
    if (dx.b(paramUri))
      paramUri = dx.b(paramUri.getLastPathSegment());
    return j.a(j.a(e.a(this.a, paramUri, true)), 400, 400, false);
  }

  private Bitmap a(h paramh, m paramm, int paramInt1, int paramInt2)
  {
    Uri localUri = paramh.r();
    if (localUri == null)
      return ((com.viber.voip.messages.d.b)this.b.get()).a(this.a, paramInt1, paramInt2, paramh, paramm);
    return j.c(this.a, localUri);
  }

  private Bitmap a(h paramh, m paramm, int paramInt1, int paramInt2, int paramInt3)
  {
    Bitmap localBitmap;
    if (paramh.e())
    {
      Uri localUri = paramh.r();
      localBitmap = j.b(this.a, localUri, paramInt3);
    }
    while (true)
    {
      return j.c(localBitmap, paramInt1, paramInt2);
      boolean bool = paramh.b();
      localBitmap = null;
      if (bool)
        localBitmap = a(paramh, paramm, paramInt1, paramInt2);
    }
  }

  private Bitmap a(h paramh, List<m> paramList, int paramInt1, int paramInt2)
  {
    if (!paramh.b())
      return null;
    return ((com.viber.voip.messages.d.b)this.b.get()).a(this.a, paramInt1, paramInt2, paramh, paramList);
  }

  private Bitmap b()
  {
    com.viber.voip.b.a.b localb = (com.viber.voip.b.a.b)this.c.a(com.viber.voip.b.a.a);
    Bitmap localBitmap = localb.a("conversation_icon_provider.bg_wear_default");
    if (localBitmap == null)
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      localBitmap = dq.a(this.a.getResources(), R.drawable.bg_wear_default, localOptions);
      localb.a("conversation_icon_provider.bg_wear_default", localBitmap);
    }
    return localBitmap;
  }

  private Bitmap d(h paramh, m paramm)
  {
    Bitmap localBitmap = j.c(this.a, paramm.p());
    if (localBitmap == null);
    for (boolean bool = true; ; bool = false)
    {
      if (bool)
        localBitmap = dq.a(this.a.getResources(), R.drawable.generic_image_thirty_x_thirty);
      return j.a(this.a, localBitmap, this.d, this.e, paramm.a(paramh), bool);
    }
  }

  public int a()
  {
    return 3;
  }

  public g a(h paramh, m paramm)
  {
    return new a(paramh, paramm);
  }

  public g a(h paramh, List<m> paramList)
  {
    return new b(paramh, paramList);
  }

  Bitmap b(h paramh, m paramm)
  {
    if (paramh.b())
      return j.e(a(paramh, paramm, this.d, this.e, R.drawable.status_unread_message));
    return d(paramh, paramm);
  }

  Bitmap b(h paramh, List<m> paramList)
  {
    return j.e(j.c(a(paramh, paramList, this.d, this.e), this.d, this.e));
  }

  Bitmap c(h paramh, m paramm)
  {
    if (paramh.b());
    for (Bitmap localBitmap = a(paramh, paramm, 400, 400, 0); ; localBitmap = a(paramm.p()))
    {
      if (localBitmap == null)
        localBitmap = b();
      return localBitmap;
    }
  }

  Bitmap c(h paramh, List<m> paramList)
  {
    Bitmap localBitmap = a(paramh, paramList, 400, 400);
    if (localBitmap == null)
      localBitmap = b();
    return localBitmap;
  }

  private class a
    implements g
  {
    private final h b;
    private final m c;

    a(h paramm, m arg3)
    {
      this.b = paramm;
      Object localObject;
      this.c = localObject;
    }

    public Bitmap a()
    {
      return b.this.b(this.b, this.c);
    }

    public Bitmap b()
    {
      return b.this.c(this.b, this.c);
    }
  }

  private class b
    implements g
  {
    private final h b;
    private final List<m> c;

    b(List<m> arg2)
    {
      Object localObject1;
      this.b = localObject1;
      Object localObject2;
      this.c = localObject2;
    }

    public Bitmap a()
    {
      return b.this.b(this.b, this.c);
    }

    public Bitmap b()
    {
      return b.this.c(this.b, this.c);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.f.b
 * JD-Core Version:    0.6.2
 */