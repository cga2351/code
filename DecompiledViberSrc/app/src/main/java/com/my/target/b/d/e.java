package com.my.target.b.d;

import android.view.View;
import com.my.target.b.c.a.f;
import com.my.target.bi;
import com.my.target.dd;
import com.my.target.dl;
import com.my.target.dl.a;
import com.my.target.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
{
  private final dd a;
  private final ArrayList<f> b = new ArrayList();
  private k.b c;

  private e(List<f> paramList, dl paramdl)
  {
    this.a = paramdl;
    paramdl.setCarouselListener(new a((byte)0));
    for (int k : paramdl.getNumbersOfCurrentShowingCards())
      if ((k < paramList.size()) && (k >= 0))
      {
        f localf = (f)paramList.get(k);
        this.b.add(localf);
        bi.a(localf.y().a("playbackStarted"), paramdl.getView().getContext());
      }
  }

  public static e a(List<f> paramList, dl paramdl)
  {
    return new e(paramList, paramdl);
  }

  public final void a(k.b paramb)
  {
    this.c = paramb;
  }

  private final class a
    implements dl.a
  {
    private a()
    {
    }

    public final void a(f paramf)
    {
      if (e.a(e.this) != null)
        e.a(e.this).a(paramf, null, e.b(e.this).getView().getContext());
    }

    public final void a(List<f> paramList)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        if (!e.c(e.this).contains(localf))
        {
          e.c(e.this).add(localf);
          bi.a(localf.y().a("playbackStarted"), e.b(e.this).getView().getContext());
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.b.d.e
 * JD-Core Version:    0.6.2
 */