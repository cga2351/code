package com.viber.voip.g.a;

import android.content.ContentResolver;
import android.content.Context;
import androidx.work.p;
import com.google.d.f;
import com.viber.common.b.b;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.contacts.c.d.n;
import com.viber.voip.j.a.a.d;
import com.viber.voip.registration.ActivationController;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.aw;
import com.viber.voip.util.aa;
import d.d.b.g;
import d.d.b.h;
import d.d.b.m;
import javax.inject.Singleton;
import org.jetbrains.annotations.NotNull;

public final class ft
{
  @Singleton
  @NotNull
  public final com.viber.voip.j.a.a.c a(@NotNull Context paramContext, @NotNull dagger.a<p> parama, @NotNull dagger.a<ActivationController> parama1, @NotNull dagger.a<com.viber.common.permission.c> parama2, @NotNull dagger.a<ICdrController> parama3, @NotNull dagger.a<f> parama4, @NotNull dagger.a<n> parama5)
  {
    h.b(paramContext, "context");
    h.b(parama, "workManager");
    h.b(parama1, "activationController");
    h.b(parama2, "permissionManager");
    h.b(parama3, "cdrController");
    h.b(parama4, "gson");
    h.b(parama5, "contactsStateManager");
    d.d.a.a locala = (d.d.a.a)a.a;
    b localb = d.aw.a;
    h.a(localb, "Pref.Statistics.EMAILS_AB_REPORTED");
    ContentResolver localContentResolver = paramContext.getContentResolver();
    h.a(localContentResolver, "context.contentResolver");
    return new com.viber.voip.j.a.a.c(locala, localb, parama, parama2, parama5, parama1, new com.viber.voip.j.a.a.a(localContentResolver, aa.a()), new d(parama3, parama4));
  }

  static final class a extends g
    implements d.d.a.a<Boolean>
  {
    public static final a a = new a();

    a()
    {
      super();
    }

    public final boolean b()
    {
      return ao.f();
    }

    public final d.f.c c()
    {
      return m.a(ao.class);
    }

    public final String d()
    {
      return "isSecondary";
    }

    public final String e()
    {
      return "isSecondary()Z";
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.ft
 * JD-Core Version:    0.6.2
 */