package com.viber.voip.stickers.c;

import android.os.Bundle;

class f extends c
{
  f(int paramInt, Bundle paramBundle)
  {
    super(paramInt, paramBundle);
  }

  static Bundle a(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("is_svg", paramBoolean);
    return localBundle;
  }

  String a()
  {
    if (this.c)
      return g.a(this.a, "ASVG");
    return g.h(this.a);
  }

  String b()
  {
    if (this.c)
      return g.l(this.a);
    return g.b(this.a, false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.c.f
 * JD-Core Version:    0.6.2
 */