package com.viber.voip.messages.conversation.adapter.e;

import android.text.TextUtils;
import android.view.View;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.d.l;
import com.viber.voip.q.i;
import java.util.LinkedHashMap;
import java.util.Map;

public class r
  implements q
{
  final Map<String, Boolean> a = new LinkedHashMap();
  private final i b;

  public r(i parami)
  {
    this.b = parami;
  }

  public void a()
  {
    this.a.clear();
  }

  public boolean a(View paramView, l paraml, aa paramaa)
  {
    boolean bool = true;
    if (!paramaa.aJ())
      bool = false;
    String str;
    do
    {
      do
        return bool;
      while (!paramaa.ao());
      str = paramaa.p();
    }
    while (TextUtils.isEmpty(str));
    this.a.put(str, Boolean.valueOf(paramaa.be()));
    return bool;
  }

  public void b()
  {
    this.b.a(this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.e.r
 * JD-Core Version:    0.6.2
 */