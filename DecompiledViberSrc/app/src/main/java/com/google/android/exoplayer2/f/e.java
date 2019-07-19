package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.g.ag;
import java.util.ArrayList;
import java.util.Map;

public abstract class e
  implements h
{
  private final boolean a;
  private final ArrayList<ad> b;
  private int c;
  private l d;

  protected e(boolean paramBoolean)
  {
    this.a = paramBoolean;
    this.b = new ArrayList(1);
  }

  protected final void a(int paramInt)
  {
    l locall = (l)ag.a(this.d);
    for (int i = 0; i < this.c; i++)
      ((ad)this.b.get(i)).a(this, locall, this.a, paramInt);
  }

  public final void a(ad paramad)
  {
    if (!this.b.contains(paramad))
    {
      this.b.add(paramad);
      this.c = (1 + this.c);
    }
  }

  public Map b()
  {
    return i.a(this);
  }

  protected final void b(l paraml)
  {
    for (int i = 0; i < this.c; i++)
      ((ad)this.b.get(i)).a(this, paraml, this.a);
  }

  protected final void c(l paraml)
  {
    this.d = paraml;
    for (int i = 0; i < this.c; i++)
      ((ad)this.b.get(i)).b(this, paraml, this.a);
  }

  protected final void d()
  {
    l locall = (l)ag.a(this.d);
    for (int i = 0; i < this.c; i++)
      ((ad)this.b.get(i)).c(this, locall, this.a);
    this.d = null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.f.e
 * JD-Core Version:    0.6.2
 */