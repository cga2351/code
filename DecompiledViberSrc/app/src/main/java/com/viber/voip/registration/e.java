package com.viber.voip.registration;

import android.content.Context;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.registration.sms.a;
import com.viber.voip.registration.sms.b;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class e
{
  private static final Logger a = ViberEnv.getLogger();
  private final EventBus b;
  private final SmsRetrieverClient c;
  private final ActivationController.a d;
  private final Pattern e;
  private final Pattern f;

  public e(Context paramContext, EventBus paramEventBus, ActivationController.a parama)
  {
    this.b = paramEventBus;
    this.c = SmsRetriever.getClient(paramContext);
    this.d = parama;
    this.f = Pattern.compile("(\\d{6})(?=[^\\d]*|$)");
    this.e = Pattern.compile("((\\s)||(.))*(((:(\\w{1,2})|([\\r\\n]))\\d{6})|(viber))((\\s)||(.))*");
  }

  private void a(String paramString)
  {
    String str = b(paramString);
    if (str != null)
    {
      ActivationController.ActivationCode localActivationCode = new ActivationController.ActivationCode(str, ActivationController.b.a);
      this.d.a(localActivationCode);
    }
  }

  private String b(String paramString)
  {
    if (this.e.matcher(paramString.toLowerCase()).matches())
    {
      Matcher localMatcher = this.f.matcher(paramString);
      if (localMatcher.find())
        return localMatcher.group(1);
    }
    return null;
  }

  public void a()
  {
    if (!this.b.isRegistered(this))
      this.b.register(this);
    b.a(this.c);
  }

  public void b()
  {
    if (this.b.isRegistered(this))
      this.b.unregister(this);
  }

  @Subscribe(sticky=true, threadMode=ThreadMode.MAIN)
  public void onActivationSmsReceived(a parama)
  {
    this.b.removeStickyEvent(parama);
    a(parama.a());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.e
 * JD-Core Version:    0.6.2
 */