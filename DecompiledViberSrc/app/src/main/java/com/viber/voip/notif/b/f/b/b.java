package com.viber.voip.notif.b.f.b;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import com.viber.voip.messages.ui.aj;
import com.viber.voip.notif.h.m;

abstract class b extends a
{
  final q.a k;
  private final int l;

  b(Context paramContext, m paramm, q.a parama, dagger.a<aj> parama1, h paramh)
  {
    super(paramContext, paramm, parama1, paramh);
    this.k = parama;
    if (this.c);
    for (int i = this.k.c(); ; i = this.k.a())
    {
      this.l = i;
      return;
    }
  }

  String a(int paramInt)
  {
    try
    {
      String str = this.a.getString(paramInt);
      return str;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
    }
    return "";
  }

  String a(int paramInt, Object[] paramArrayOfObject)
  {
    try
    {
      String str = this.a.getString(paramInt, paramArrayOfObject);
      return str;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
    }
    return "";
  }

  String a(Object[] paramArrayOfObject)
  {
    return a(this.l, paramArrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.b.b
 * JD-Core Version:    0.6.2
 */