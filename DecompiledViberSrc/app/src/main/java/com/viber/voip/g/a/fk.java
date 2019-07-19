package com.viber.voip.g.a;

import com.viber.voip.flatbuffers.b.b;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import dagger.a.d;
import dagger.a.h;

public final class fk
  implements d<b<ConferenceInfo>>
{
  private static final fk a = new fk();

  public static fk b()
  {
    return a;
  }

  public b<ConferenceInfo> a()
  {
    return (b)h.a(fi.b(), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.fk
 * JD-Core Version:    0.6.2
 */