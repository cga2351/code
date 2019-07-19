package com.viber.voip.storage.manage;

import android.os.Handler;
import com.google.d.f;
import com.viber.voip.ViberApplication;
import com.viber.voip.messages.k;
import com.viber.voip.storage.repository.r;
import com.viber.voip.storage.repository.u;
import dagger.a;
import dagger.b;

public final class e
  implements b<d>
{
  public static void a(d paramd, Handler paramHandler)
  {
    paramd.f = paramHandler;
  }

  public static void a(d paramd, f paramf)
  {
    paramd.c = paramf;
  }

  public static void a(d paramd, ViberApplication paramViberApplication)
  {
    paramd.a = paramViberApplication;
  }

  public static void a(d paramd, r paramr)
  {
    paramd.d = paramr;
  }

  public static void a(d paramd, u paramu)
  {
    paramd.e = paramu;
  }

  public static void a(d paramd, a<k> parama)
  {
    paramd.b = parama;
  }

  public static void b(d paramd, Handler paramHandler)
  {
    paramd.g = paramHandler;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.manage.e
 * JD-Core Version:    0.6.2
 */