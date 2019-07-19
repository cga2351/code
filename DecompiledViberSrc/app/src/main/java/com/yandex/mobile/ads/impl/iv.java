package com.yandex.mobile.ads.impl;

import android.view.View;
import android.widget.TextView;
import com.yandex.mobile.ads.nativeads.aj;
import com.yandex.mobile.ads.nativeads.i;
import java.util.HashMap;
import java.util.Map;

public final class iv
{
  private final iu a;
  private final aj b;

  public iv(aj paramaj, i parami)
  {
    this.b = paramaj;
    this.a = new iu(parami);
  }

  public final Map<String, in> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("age", iu.a(this.b.b()));
    localHashMap.put("body", iu.a(this.b.c()));
    localHashMap.put("call_to_action", iu.a(this.b.d()));
    TextView localTextView = this.b.e();
    ix localix;
    io localio1;
    label106: View localView;
    if (localTextView != null)
    {
      localix = new ix(localTextView);
      if (localix == null)
        break label393;
      localio1 = new io(localix);
      localHashMap.put("close_button", localio1);
      localHashMap.put("domain", iu.a(this.b.f()));
      localHashMap.put("favicon", this.a.a(this.b.g()));
      localHashMap.put("feedback", this.a.b(this.b.h()));
      localHashMap.put("icon", this.a.a(this.b.i()));
      localHashMap.put("media", this.a.a(this.b.j(), this.b.k()));
      localView = this.b.m();
      if (localView == null)
        break label399;
    }
    label393: label399: for (jc localjc = new jc(localView); ; localjc = null)
    {
      io localio2 = null;
      if (localjc != null)
        localio2 = new io(localjc);
      localHashMap.put("rating", localio2);
      localHashMap.put("review_count", iu.a(this.b.n()));
      localHashMap.put("price", iu.a(this.b.l()));
      localHashMap.put("sponsored", iu.a(this.b.o()));
      localHashMap.put("title", iu.a(this.b.p()));
      localHashMap.put("warning", iu.a(this.b.q()));
      return localHashMap;
      localix = null;
      break;
      localio1 = null;
      break label106;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.iv
 * JD-Core Version:    0.6.2
 */