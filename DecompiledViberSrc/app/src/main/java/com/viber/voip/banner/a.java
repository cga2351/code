package com.viber.voip.banner;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.viber.voip.banner.d.b;
import com.viber.voip.banner.view.c;
import java.lang.ref.WeakReference;

public class a extends e
{
  private final WeakReference<Activity> b;

  a(b paramb, dagger.a<com.viber.voip.analytics.story.g.a> parama, Activity paramActivity)
  {
    super(paramb, parama);
    this.b = new WeakReference(paramActivity);
  }

  protected ViewGroup a()
  {
    Activity localActivity = (Activity)this.b.get();
    if (localActivity != null)
      return c.a(localActivity.findViewById(16908290));
    return null;
  }

  protected Context b()
  {
    return (Context)this.b.get();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.a
 * JD-Core Version:    0.6.2
 */