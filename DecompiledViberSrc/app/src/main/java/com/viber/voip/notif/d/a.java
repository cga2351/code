package com.viber.voip.notif.d;

import android.app.PendingIntent;
import android.content.Context;
import android.support.v4.app.NotificationCompat.Action.Builder;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;

public class a
{
  private Context a;

  public a(Context paramContext)
  {
    this.a = paramContext;
  }

  public NotificationCompat.Action.Builder a(int paramInt1, int paramInt2, int paramInt3, PendingIntent paramPendingIntent)
  {
    Object localObject;
    if (paramInt3 != -1)
    {
      localObject = new SpannableString(this.a.getText(paramInt2));
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.a, paramInt3)), 0, ((SpannableString)localObject).length(), 17);
    }
    while (true)
    {
      return new NotificationCompat.Action.Builder(paramInt1, (CharSequence)localObject, paramPendingIntent);
      localObject = this.a.getText(paramInt2);
    }
  }

  public NotificationCompat.Action.Builder a(int paramInt1, int paramInt2, PendingIntent paramPendingIntent)
  {
    return a(paramInt1, paramInt2, -1, paramPendingIntent);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.d.a
 * JD-Core Version:    0.6.2
 */