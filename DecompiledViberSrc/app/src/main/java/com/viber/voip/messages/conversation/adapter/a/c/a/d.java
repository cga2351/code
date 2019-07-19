package com.viber.voip.messages.conversation.adapter.a.c.a;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import com.viber.voip.R.attr;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.ViberApplication;
import com.viber.voip.util.dc;
import com.viber.voip.util.e.b.b;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.f.a;
import com.viber.voip.util.e.f.b;
import java.util.HashMap;
import java.util.Map;

public class d
{
  private final Context a;
  private Map<String, f> b;
  private Map<Integer, Integer> c = new HashMap();

  public d(Context paramContext)
  {
    this.a = paramContext;
    this.b = new HashMap();
    this.c.put(Integer.valueOf(3), Integer.valueOf(R.drawable.bg_media_loading_generic));
  }

  private f.a b(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    f.a locala = new f.a().b(false);
    Integer localInteger = (Integer)this.c.get(Integer.valueOf(paramInt));
    if (localInteger != null)
    {
      locala.b(localInteger);
      locala.a(localInteger);
    }
    if (paramBoolean2)
      locala.a(112640);
    if (paramBoolean1)
      locala.a(new b(ViberApplication.getApplication().getResources().getDimensionPixelSize(R.dimen.wink_image_blur_radius), true));
    return locala;
  }

  public f a()
  {
    f localf = (f)this.b.get("avatar_config");
    if (localf == null)
    {
      localf = f.c(dc.a(this.a, R.attr.contactDefaultPhotoMedium));
      this.b.put("avatar_config", localf);
    }
    return localf;
  }

  public f a(int paramInt)
  {
    f localf = (f)this.b.get("s_avatar_config");
    if (localf == null)
    {
      localf = new f.a().a(f.b.a).a(Integer.valueOf(paramInt)).b(Integer.valueOf(paramInt)).c();
      this.b.put("s_avatar_config", localf);
    }
    return localf;
  }

  public f a(int paramInt1, int paramInt2)
  {
    String str = "gif_" + paramInt1 + "x" + paramInt2;
    f localf = (f)this.b.get(str);
    if (localf == null)
    {
      localf = new f.a().b(false).a(new com.viber.voip.util.e.b.d(this.a.getResources().getDimensionPixelSize(R.dimen.gif_image_blur_radius), paramInt1, paramInt2, true)).c();
      this.b.put(str, localf);
    }
    return localf;
  }

  public f a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str1 = String.valueOf(paramInt);
    if (paramBoolean1)
      str1 = "pa_" + str1;
    if (paramBoolean2);
    for (String str2 = "blur_" + str1; ; str2 = str1)
    {
      f localf = (f)this.b.get(str2);
      if (localf == null)
      {
        localf = b(paramInt, paramBoolean2, paramBoolean1).c();
        this.b.put(str2, localf);
      }
      return localf;
    }
  }

  public f b()
  {
    f localf = (f)this.b.get("pa_avatar_config");
    if (localf == null)
    {
      localf = f.d(dc.a(this.a, R.attr.contactDefaultPhotoMedium));
      this.b.put("pa_avatar_config", localf);
    }
    return localf;
  }

  public f b(int paramInt)
  {
    String str = "big_emoticon_" + paramInt;
    f localf = (f)this.b.get(str);
    if (localf == null)
    {
      localf = f.g(paramInt);
      this.b.put(str, localf);
    }
    return localf;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.a.c.a.d
 * JD-Core Version:    0.6.2
 */