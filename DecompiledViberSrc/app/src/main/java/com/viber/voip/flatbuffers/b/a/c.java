package com.viber.voip.flatbuffers.b.a;

import android.content.Context;
import com.viber.voip.flatbuffers.R.raw;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;

public class c
  implements com.viber.voip.flatbuffers.b.d<ConferenceInfo>
{
  private final String a;

  public c(Context paramContext)
  {
    this.a = com.viber.voip.flatbuffers.model.util.a.a(paramContext, R.raw.conferenceinfo_scheme);
  }

  public com.viber.voip.flatbuffers.b.a<ConferenceInfo> a()
  {
    return new b(this.a);
  }

  public com.viber.voip.flatbuffers.b.b<ConferenceInfo> b()
  {
    return new d();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.b.a.c
 * JD-Core Version:    0.6.2
 */