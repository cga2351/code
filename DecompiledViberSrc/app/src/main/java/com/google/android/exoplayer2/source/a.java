package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.ak;
import com.google.android.exoplayer2.f.ad;
import com.google.android.exoplayer2.j;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class a
  implements n
{
  private final ArrayList<n.b> a = new ArrayList(1);
  private final o.a b = new o.a();
  private j c;
  private ak d;
  private Object e;

  protected final o.a a(n.a parama)
  {
    return this.b.a(0, parama, 0L);
  }

  protected abstract void a();

  public final void a(Handler paramHandler, o paramo)
  {
    this.b.a(paramHandler, paramo);
  }

  protected final void a(ak paramak, Object paramObject)
  {
    this.d = paramak;
    this.e = paramObject;
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((n.b)localIterator.next()).a(this, paramak, paramObject);
  }

  protected abstract void a(j paramj, boolean paramBoolean, ad paramad);

  public final void a(j paramj, boolean paramBoolean, n.b paramb, ad paramad)
  {
    boolean bool;
    if ((this.c == null) || (this.c == paramj))
    {
      bool = true;
      com.google.android.exoplayer2.g.a.a(bool);
      this.a.add(paramb);
      if (this.c != null)
        break label59;
      this.c = paramj;
      a(paramj, paramBoolean, paramad);
    }
    label59: 
    while (this.d == null)
    {
      return;
      bool = false;
      break;
    }
    paramb.a(this, this.d, this.e);
  }

  public final void a(n.b paramb)
  {
    this.a.remove(paramb);
    if (this.a.isEmpty())
    {
      this.c = null;
      this.d = null;
      this.e = null;
      a();
    }
  }

  public final void a(o paramo)
  {
    this.b.a(paramo);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.source.a
 * JD-Core Version:    0.6.2
 */