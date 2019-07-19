package com.viber.voip.notif.b.f.d.a;

import android.content.Context;
import android.support.v4.util.ArraySet;
import com.viber.voip.R.string;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.model.entity.h;
import com.viber.voip.notif.b.f.d;
import com.viber.voip.notif.c.n;
import com.viber.voip.notif.c.o;
import com.viber.voip.notif.f.b;
import com.viber.voip.notif.f.e;
import com.viber.voip.util.da;
import com.viber.voip.util.dg;
import dagger.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class c extends d
{
  private final String h;
  private final String[] i;
  private final a<ak> j;
  private a k;

  public c(com.viber.voip.notif.h.m paramm, a<ak> parama, String[] paramArrayOfString)
  {
    super(paramm);
    this.j = parama;
    this.h = dg.b(paramm.e().o());
    this.i = paramArrayOfString;
  }

  private a h()
  {
    if (this.k == null)
      this.k = i();
    return this.k;
  }

  private a i()
  {
    a locala = new a(null);
    locala.a = da.g(String.valueOf(this.i.length), this.h);
    if (this.i.length == 0)
    {
      locala.b = locala.a;
      return locala;
    }
    ArraySet localArraySet = new ArraySet(Arrays.asList(this.i));
    locala.c = ((ak)this.j.get()).b(localArraySet);
    ArrayList localArrayList = new ArrayList(locala.c.size());
    Iterator localIterator = locala.c.iterator();
    while (localIterator.hasNext())
      localArrayList.add(dg.a((com.viber.voip.model.entity.m)localIterator.next(), this.a.e().j(), this.a.e().p()));
    locala.b = da.a(localArrayList, this.h);
    return locala;
  }

  public String R_()
  {
    return "join";
  }

  protected n b(Context paramContext, o paramo, e parame)
  {
    if (h().c == null)
      return super.b(paramContext, paramo, parame);
    return paramo.a(((b)parame.a(3)).a(this.a.e(), h().c));
  }

  public CharSequence b(Context paramContext)
  {
    return h().a;
  }

  public CharSequence d(Context paramContext)
  {
    return paramContext.getText(R.string.app_name);
  }

  public CharSequence f(Context paramContext)
  {
    return h().b;
  }

  private static class a
  {
    CharSequence a;
    CharSequence b;
    List<com.viber.voip.model.entity.m> c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.d.a.c
 * JD-Core Version:    0.6.2
 */