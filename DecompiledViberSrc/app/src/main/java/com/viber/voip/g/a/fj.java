package com.viber.voip.g.a;

import com.viber.voip.flatbuffers.b.a;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import dagger.a.d;
import dagger.a.h;

public final class fj
  implements d<a<ConferenceInfo>>
{
  private static final fj a = new fj();

  public static fj b()
  {
    return a;
  }

  public a<ConferenceInfo> a()
  {
    return (a)h.a(fi.c(), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.fj
 * JD-Core Version:    0.6.2
 */