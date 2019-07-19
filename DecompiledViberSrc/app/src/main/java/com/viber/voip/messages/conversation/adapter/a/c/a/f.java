package com.viber.voip.messages.conversation.adapter.a.c.a;

import android.support.v4.graphics.ColorUtils;
import com.viber.voip.util.LongSparseSet;

public class f
  implements b
{
  private final double a;
  private final int b;
  private final int c;
  private LongSparseSet d;

  public f(int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramInt2;
    this.b = paramInt3;
    this.a = ColorUtils.calculateContrast(paramInt1, paramInt3);
  }

  private LongSparseSet a()
  {
    if (this.d == null)
      this.d = new LongSparseSet();
    return this.d;
  }

  public int a(int paramInt)
  {
    if (a().contains(paramInt))
      paramInt = this.c;
    while (ColorUtils.calculateContrast(paramInt, this.b) > this.a)
      return paramInt;
    a().add(paramInt);
    return this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.a.c.a.f
 * JD-Core Version:    0.6.2
 */