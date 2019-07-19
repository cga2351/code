package com.viber.voip.j.a.a;

import com.google.d.f;
import com.viber.jni.cdr.ICdrController;
import d.d.b.h;
import dagger.a;
import org.jetbrains.annotations.NotNull;

public final class d
{
  private final a<ICdrController> a;
  private final a<f> b;

  public d(@NotNull a<ICdrController> parama, @NotNull a<f> parama1)
  {
    this.a = parama;
    this.b = parama1;
  }

  public final boolean a(@NotNull b paramb)
  {
    h.b(paramb, "data");
    if ((paramb.b() > 0) || (paramb.c() > 0));
    for (String str1 = "1"; ; str1 = "0")
    {
      String str2 = ((f)this.b.get()).b(paramb);
      return ((ICdrController)this.a.get()).handleClientTrackingReport(5, str1, str2);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.j.a.a.d
 * JD-Core Version:    0.6.2
 */