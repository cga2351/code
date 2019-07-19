package com.viber.voip.contacts.ui.list;

import android.net.Uri;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import com.viber.voip.messages.conversation.adapter.a.c.a.e;
import com.viber.voip.messages.conversation.ae;

class z
{
  ae a;

  z(ae paramae)
  {
    this.a = paramae;
  }

  Uri a()
  {
    return this.a.j();
  }

  Pair<String, String> a(e parame)
  {
    String str1 = this.a.a(parame.c(), parame.e());
    String str2;
    if (this.a.isOwner())
      if (!TextUtils.isEmpty(str1))
        str2 = String.format(parame.f(), new Object[] { str1 });
    while (true)
    {
      return new Pair(str2, this.a.a(str1));
      str2 = parame.b();
      continue;
      str2 = str1;
    }
  }

  int b()
  {
    return this.a.a();
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
      return false;
    z localz = (z)paramObject;
    return this.a.p().equals(localz.a.p());
  }

  public int hashCode()
  {
    return this.a.p().hashCode();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.list.z
 * JD-Core Version:    0.6.2
 */