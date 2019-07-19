package com.viber.voip.notif.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.notif.a.a.a;
import com.viber.voip.util.ViberActionRunner.r;

public class b extends a
{
  private final long c;
  private final String d;
  private final boolean e;
  private final long f;

  private b(long paramLong1, String paramString, boolean paramBoolean, long paramLong2)
  {
    this.c = paramLong1;
    this.d = paramString;
    this.e = paramBoolean;
    this.f = paramLong2;
  }

  static b a(long paramLong, String paramString, boolean paramBoolean)
  {
    return new b(-1L, paramString, paramBoolean, paramLong);
  }

  static b b(long paramLong, String paramString, boolean paramBoolean)
  {
    return new b(paramLong, paramString, paramBoolean, -1L);
  }

  protected int a()
  {
    return R.drawable.ic_action_call;
  }

  protected Intent a(Context paramContext)
  {
    Intent localIntent = ViberActionRunner.r.a(paramContext, Uri.fromParts("tel", this.d, null));
    localIntent.putExtra("is_video_call", this.e);
    localIntent.putExtra("contact_id", this.c);
    localIntent.putExtra("conversation_id", this.f);
    return localIntent;
  }

  protected int b()
  {
    return R.string.menu_call;
  }

  protected int d()
  {
    return this.d.hashCode();
  }

  protected int e()
  {
    return 2;
  }

  protected int f()
  {
    return R.drawable.ic_action_wear_call;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.a.b
 * JD-Core Version:    0.6.2
 */