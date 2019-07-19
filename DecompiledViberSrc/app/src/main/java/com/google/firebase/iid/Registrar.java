package com.google.firebase.iid;

import android.support.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.FirebaseApp;
import com.google.firebase.a.d;
import com.google.firebase.components.b;
import com.google.firebase.components.b.a;
import com.google.firebase.components.h;
import com.google.firebase.components.n;
import com.google.firebase.d.g;
import com.google.firebase.iid.a.a;
import java.util.Arrays;
import java.util.List;

@Keep
@KeepForSdk
public final class Registrar
  implements h
{
  @Keep
  public final List<b<?>> getComponents()
  {
    return Arrays.asList(new b[] { b.a(FirebaseInstanceId.class).a(n.a(FirebaseApp.class)).a(n.a(d.class)).a(n.a(g.class)).a(r.a).a().b(), b.a(a.class).a(n.a(FirebaseInstanceId.class)).a(s.a).b() });
  }

  private static final class a
    implements a
  {
    private final FirebaseInstanceId a;

    public a(FirebaseInstanceId paramFirebaseInstanceId)
    {
      this.a = paramFirebaseInstanceId;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.iid.Registrar
 * JD-Core Version:    0.6.2
 */