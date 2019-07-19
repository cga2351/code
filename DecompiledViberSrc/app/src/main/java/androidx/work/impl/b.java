package androidx.work.impl;

import android.arch.lifecycle.m;
import androidx.work.impl.utils.a.c;
import androidx.work.l;
import androidx.work.l.a;
import androidx.work.l.a.a;
import androidx.work.l.a.c;

public class b
  implements l
{
  private final m<l.a> c = new m();
  private final c<l.a.c> d = c.d();

  public b()
  {
    a(l.b);
  }

  public void a(l.a parama)
  {
    this.c.postValue(parama);
    if ((parama instanceof l.a.c))
      this.d.a((l.a.c)parama);
    while (!(parama instanceof l.a.a))
      return;
    l.a.a locala = (l.a.a)parama;
    this.d.a(locala.a());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.b
 * JD-Core Version:    0.6.2
 */