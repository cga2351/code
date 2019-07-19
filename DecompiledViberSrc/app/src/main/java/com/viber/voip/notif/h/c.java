package com.viber.voip.notif.h;

import android.net.Uri;
import com.viber.voip.model.entity.h;
import com.viber.voip.util.da;

public class c
{
  private final long a;
  private final long b;
  private final String c;
  private final Uri d;

  private c(long paramLong1, long paramLong2, String paramString, Uri paramUri)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramString;
    this.d = paramUri;
  }

  public static c a(h paramh)
  {
    return new c(paramh.getId(), paramh.k(), paramh.o(), paramh.q());
  }

  public static c a(d paramd)
  {
    long l1 = paramd.a();
    long l2 = paramd.b();
    String str = paramd.d();
    if (da.a(paramd.e()));
    for (Uri localUri = null; ; localUri = Uri.parse(paramd.e()))
      return new c(l1, l2, str, localUri);
  }

  public long a()
  {
    return this.a;
  }

  public long b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }

  public Uri d()
  {
    return this.d;
  }

  public String toString()
  {
    return "CommunityConversationInfo{mConversationId=" + this.a + ", mGroupId=" + this.b + ", mGroupName='" + this.c + '\'' + ", mIconUri=" + this.d + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.h.c
 * JD-Core Version:    0.6.2
 */