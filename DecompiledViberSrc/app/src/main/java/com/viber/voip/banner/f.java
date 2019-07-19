package com.viber.voip.banner;

import android.app.Activity;
import android.support.v4.app.Fragment;
import com.viber.voip.ViberApplication;
import com.viber.voip.banner.d.b;

public class f
{
  public static e a(Object paramObject, dagger.a<com.viber.voip.analytics.story.g.a> parama)
  {
    return a(paramObject, parama, ViberApplication.isTablet(ViberApplication.getApplication()));
  }

  public static e a(Object paramObject, dagger.a<com.viber.voip.analytics.story.g.a> parama, boolean paramBoolean)
  {
    b localb = b.a(paramObject, paramBoolean);
    if (localb == null)
      return new j();
    if ((paramObject instanceof Activity))
      return new a(localb, parama, (Activity)paramObject);
    if ((paramObject instanceof Fragment))
      return new c(localb, parama, (Fragment)paramObject);
    return new j();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.f
 * JD-Core Version:    0.6.2
 */