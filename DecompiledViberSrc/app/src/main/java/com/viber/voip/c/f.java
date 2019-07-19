package com.viber.voip.c;

import com.google.d.a.c;
import com.viber.jni.ConferenceMembers;
import com.viber.voip.util.da;

class f
{

  @c(a="partyToken")
  private long a;

  @c(a="confId")
  private String b;

  @c(a="peerInfoList")
  private a[] c;

  public long a()
  {
    return this.a;
  }

  public String b()
  {
    return da.h(this.b);
  }

  public ConferenceMembers c()
  {
    ConferenceMembers localConferenceMembers = new ConferenceMembers();
    if (this.c != null)
      for (a locala : this.c)
        localConferenceMembers.add(locala.a(), locala.b());
    return localConferenceMembers;
  }

  private static class a
  {

    @c(a="mid")
    private String a;

    @c(a="name")
    private String b;

    public String a()
    {
      return da.h(this.a);
    }

    public String b()
    {
      return da.h(this.b);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.c.f
 * JD-Core Version:    0.6.2
 */