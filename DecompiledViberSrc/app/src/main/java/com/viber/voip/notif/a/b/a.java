package com.viber.voip.notif.a.b;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.NotificationCompat.Action.Builder;
import android.support.v4.app.NotificationCompat.Action.Extender;
import android.support.v4.app.RemoteInput.Builder;
import com.viber.voip.R.array;

public class a
  implements NotificationCompat.Action.Extender
{
  private final Context a;
  private final int b;
  private final boolean c;

  private a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    this.a = paramContext;
    this.b = paramInt;
    this.c = paramBoolean;
  }

  public static a a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    return new a(paramContext, paramInt, paramBoolean);
  }

  public NotificationCompat.Action.Builder extend(NotificationCompat.Action.Builder paramBuilder)
  {
    RemoteInput.Builder localBuilder = new RemoteInput.Builder("remote_text_input");
    localBuilder.setLabel(this.a.getString(this.b));
    if (this.c)
      localBuilder.setChoices(this.a.getResources().getStringArray(R.array.wear_quick_reply));
    paramBuilder.addRemoteInput(localBuilder.build());
    return paramBuilder;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.a.b.a
 * JD-Core Version:    0.6.2
 */