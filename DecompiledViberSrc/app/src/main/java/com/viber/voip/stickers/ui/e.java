package com.viber.voip.stickers.ui;

import android.content.Context;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.p;

public class e extends a<Sticker>
{
  private p a;

  public e(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.a = p.a(paramInt);
  }

  protected a.a a()
  {
    a.a locala = new a.a();
    if (b());
    for (float f1 = this.a.a(); ; f1 = this.a.b())
    {
      float f2 = f1 * this.a.c() * c();
      locala.d(f1 * c());
      locala.a(f2);
      return locala;
    }
  }

  public void a(int paramInt)
  {
    p localp = p.a(paramInt);
    if (this.a != localp)
    {
      this.a = localp;
      e();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.ui.e
 * JD-Core Version:    0.6.2
 */