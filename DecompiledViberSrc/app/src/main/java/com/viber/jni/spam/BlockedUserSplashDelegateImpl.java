package com.viber.jni.spam;

import android.content.Context;
import android.text.TextUtils;
import com.viber.common.b.b;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.banner.view.BlockedUserSplashActivity;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.ad;
import com.viber.voip.util.ViberActionRunner.j;
import org.json.JSONException;
import org.json.JSONObject;

public class BlockedUserSplashDelegateImpl
  implements BlockedUserSplashDelegate
{
  private static final String KEY_CAPTCHA = "captchaUrl";
  private static final Logger L = ViberEnv.getLogger();
  private final Context mContext;

  public BlockedUserSplashDelegateImpl(Context paramContext)
  {
    this.mContext = paramContext;
  }

  public void onBlockedStatus(String paramString)
  {
    if (ao.f());
    while (true)
    {
      return;
      if (TextUtils.isEmpty(paramString))
        break label107;
      try
      {
        String str = new JSONObject(paramString).optString("captchaUrl", "");
        if (!TextUtils.isEmpty(str))
        {
          d.ad.K.a(true);
          d.ad.L.a(str);
          ViberApplication localViberApplication = ViberApplication.getInstance();
          String[] arrayOfString = new String[1];
          arrayOfString[0] = BlockedUserSplashActivity.class.getName();
          if (localViberApplication.isActivityOnForeground(arrayOfString))
            continue;
          ViberActionRunner.j.a(this.mContext, str);
        }
      }
      catch (JSONException localJSONException)
      {
        d.ad.K.a(false);
        return;
      }
    }
    d.ad.K.a(false);
    return;
    label107: d.ad.K.a(false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.spam.BlockedUserSplashDelegateImpl
 * JD-Core Version:    0.6.2
 */