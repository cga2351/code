package com.yandex.mobile.ads.nativeads;

import android.view.View.OnClickListener;
import com.yandex.mobile.ads.impl.ao;
import com.yandex.mobile.ads.impl.jv;
import com.yandex.mobile.ads.impl.jx;
import com.yandex.mobile.ads.impl.le;
import com.yandex.mobile.ads.impl.li;
import com.yandex.mobile.ads.impl.ln;

public abstract class f
{
  static final f a = new f()
  {
    public final View.OnClickListener a(le paramAnonymousle, li paramAnonymousli, a paramAnonymousa, af paramAnonymousaf, ao paramAnonymousao)
    {
      return new jv(paramAnonymousle, paramAnonymousa, paramAnonymousaf, paramAnonymousli, paramAnonymousao);
    }
  };
  static final f b = new f()
  {
    public final View.OnClickListener a(le paramAnonymousle, li paramAnonymousli, a paramAnonymousa, af paramAnonymousaf, ao paramAnonymousao)
    {
      if ("call_to_action".equals(paramAnonymousle.a()))
        return new jv(paramAnonymousle, paramAnonymousa, paramAnonymousaf, paramAnonymousli, paramAnonymousao);
      return new jx(paramAnonymousaf.c().d());
    }
  };

  static f a()
  {
    return a;
  }

  static f a(ln paramln)
  {
    if ((paramln != null) && ("button_click_only".equals(paramln.a())))
      return b;
    return a;
  }

  public abstract View.OnClickListener a(le paramle, li paramli, a parama, af paramaf, ao paramao);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.f
 * JD-Core Version:    0.6.2
 */