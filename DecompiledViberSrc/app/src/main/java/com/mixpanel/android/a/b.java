package com.mixpanel.android.a;

import com.mixpanel.android.a.d.d.a;
import com.mixpanel.android.a.e.h;
import com.mixpanel.android.a.e.i;
import java.net.InetSocketAddress;

public abstract class b
  implements d
{
  public i a(a parama, com.mixpanel.android.a.b.a parama1, com.mixpanel.android.a.e.a parama2)
    throws com.mixpanel.android.a.c.b
  {
    return new com.mixpanel.android.a.e.e();
  }

  public String a(a parama)
    throws com.mixpanel.android.a.c.b
  {
    InetSocketAddress localInetSocketAddress = parama.a();
    if (localInetSocketAddress == null)
      throw new com.mixpanel.android.a.c.d("socket not bound");
    StringBuffer localStringBuffer = new StringBuffer(90);
    localStringBuffer.append("<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"");
    localStringBuffer.append(localInetSocketAddress.getPort());
    localStringBuffer.append("");
    return localStringBuffer.toString();
  }

  public void a(a parama, com.mixpanel.android.a.d.d paramd)
  {
  }

  public void a(a parama, com.mixpanel.android.a.e.a parama1)
    throws com.mixpanel.android.a.c.b
  {
  }

  public void a(a parama, com.mixpanel.android.a.e.a parama1, h paramh)
    throws com.mixpanel.android.a.c.b
  {
  }

  public void b(a parama, com.mixpanel.android.a.d.d paramd)
  {
    com.mixpanel.android.a.d.e locale = new com.mixpanel.android.a.d.e(paramd);
    locale.a(d.a.e);
    parama.a(locale);
  }

  public void c(a parama, com.mixpanel.android.a.d.d paramd)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.a.b
 * JD-Core Version:    0.6.2
 */