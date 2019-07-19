package com.viber.voip.notif.b.f.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.notif.a;
import com.viber.voip.notif.a.g;
import com.viber.voip.notif.d.f.a;
import com.viber.voip.notif.i.d;
import com.viber.voip.util.da;

public class h extends com.viber.voip.notif.b.f.b
{
  private final d h;
  private final a i;
  private CharSequence j;

  public h(com.viber.voip.notif.h.m paramm, com.viber.voip.notif.b.f.b.e parame, d paramd, a parama)
  {
    super(paramm, parame);
    this.h = paramd;
    this.i = parama;
  }

  private Bitmap a(int paramInt1, int paramInt2, MessageEntity paramMessageEntity)
  {
    return com.viber.voip.util.e.e.a(Uri.parse(com.viber.voip.messages.extras.map.b.a(paramMessageEntity, paramInt1, paramInt2)), false, true, -2, paramInt2 / 2 - com.viber.voip.messages.extras.map.b.a());
  }

  private CharSequence a(String paramString)
  {
    if (this.j == null)
      if ((!this.a.e().b()) && (!this.a.c().hasQuote()))
        break label83;
    label83: for (this.j = da.a(this.a.d().a(this.a.e()), paramString, this.a.c().hasQuote()); ; this.j = paramString)
      return this.j;
  }

  public f.a a(Context paramContext)
  {
    MessageEntity localMessageEntity = this.a.c();
    int[] arrayOfInt1 = this.i.a();
    Bitmap localBitmap = a(arrayOfInt1[0], arrayOfInt1[1], localMessageEntity);
    int[] arrayOfInt2 = this.i.b();
    return new f.a(localBitmap, a(arrayOfInt2[0], arrayOfInt2[1], localMessageEntity), false);
  }

  protected void a(Context paramContext, g paramg)
  {
    super.a(paramContext, paramg);
    b(paramg.a(this.a.c()));
  }

  public CharSequence f(Context paramContext)
  {
    String str = this.a.c().getBucket();
    if (da.a(str))
    {
      this.h.a(this.a.c());
      return super.f(paramContext);
    }
    return a(str);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.c.h
 * JD-Core Version:    0.6.2
 */