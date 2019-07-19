package com.viber.voip.util;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.viber.common.b.h;
import com.viber.common.d.a;
import com.viber.voip.R.string;
import com.viber.voip.ShareChooserReceiver;
import com.viber.voip.settings.d.az;

public class dw
{
  public static Intent a(Context paramContext, Intent paramIntent, CharSequence paramCharSequence, String paramString)
  {
    return a(paramContext, paramIntent, paramCharSequence, paramString, null);
  }

  public static Intent a(Context paramContext, Intent paramIntent, CharSequence paramCharSequence, String paramString, Bundle paramBundle)
  {
    if (a.h())
    {
      Intent localIntent = new Intent(paramContext, ShareChooserReceiver.class);
      localIntent.putExtra("share_type", paramString);
      if (paramBundle != null)
        localIntent.putExtras(paramBundle);
      return Intent.createChooser(paramIntent, paramCharSequence, PendingIntent.getBroadcast(paramContext, 0, localIntent, 134217728).getIntentSender());
    }
    return Intent.createChooser(paramIntent, paramCharSequence);
  }

  private static void a(Context paramContext, int paramInt, String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.putExtra("android.intent.extra.TEXT", paramString);
    localIntent.setType("text/plain");
    paramContext.startActivity(Intent.createChooser(localIntent, paramContext.getString(paramInt)));
  }

  public static void a(Context paramContext, String paramString)
  {
    da.a(paramContext, paramContext.getString(R.string.pg_sharing_text, new Object[] { paramString }), paramContext.getString(R.string.pg_copy_to_clipboard_message));
  }

  public static void a(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    a(paramContext, R.string.vibe_invite_sending, paramContext.getString(R.string.pg_sharing_text, new Object[] { paramString1 }));
  }

  public static String b(Context paramContext, String paramString)
  {
    if ("prod".equals(d.az.a.d()));
    for (int i = R.string.public_account_id_prefix; ; i = R.string.public_account_id_int_prefix)
      return paramContext.getString(i) + paramString;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.dw
 * JD-Core Version:    0.6.2
 */