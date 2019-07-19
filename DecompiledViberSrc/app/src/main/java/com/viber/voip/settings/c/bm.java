package com.viber.voip.settings.c;

import android.content.Context;
import android.os.Handler;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.b.h;
import com.viber.voip.ViberApplication;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.schedule.p.a;
import com.viber.voip.settings.d.bg;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;
import com.viber.voip.user.viberid.ViberIdMessageUtil;
import com.viber.voip.user.viberid.ViberIdPromoStickerPackHelper;
import java.util.concurrent.TimeUnit;

public class bm extends m
{
  public bm(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  protected void a()
  {
    f(new x(this.a, x.a.d, d.bg.f.c(), "Set ViberId promo stickers JSON url").a(d.bg.f.f()).a());
    x localx = new x(this.a, x.a.b, d.bg.h.c(), "ViberId promo stickers JSON sync period").a(d.bg.h.f()).a(new CharSequence[] { "24h", "1h", "5m", "1m" });
    CharSequence[] arrayOfCharSequence = new CharSequence[4];
    arrayOfCharSequence[0] = String.valueOf(TimeUnit.HOURS.toSeconds(24L));
    arrayOfCharSequence[1] = String.valueOf(TimeUnit.HOURS.toSeconds(1L));
    arrayOfCharSequence[2] = String.valueOf(TimeUnit.MINUTES.toSeconds(5L));
    arrayOfCharSequence[3] = String.valueOf(TimeUnit.MINUTES.toSeconds(1L));
    f(localx.b(arrayOfCharSequence).a(this).a());
    f(new x(this.a, x.a.a, "generate_freepack_msg_key", "Generate free stickerpack message").a(this).a());
    f(new x(this.a, x.a.a, "generate_connected_on_another_device_msg_key", "Generate same email connected message").a(this).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("viber_id_debug_key");
    paramPreferenceGroup.c("ViberId");
  }

  public boolean a(Preference paramPreference)
  {
    if (paramPreference.C().equals("generate_freepack_msg_key"))
    {
      localMessageEntity = new ViberIdPromoStickerPackHelper().createFreeStickerPackMessage(this.a);
      if (localMessageEntity != null)
        av.a(av.e.d).post(new Runnable()
        {
          public void run()
          {
            new bs(bm.this.a).b(localMessageEntity);
          }
        });
    }
    while (!paramPreference.C().equals("generate_connected_on_another_device_msg_key"))
    {
      final MessageEntity localMessageEntity;
      return false;
      ViberApplication.getInstance().showToast("Couldn't create free sticker pack message");
      return false;
    }
    av.a(av.e.d).post(new Runnable()
    {
      public void run()
      {
        new bs(bm.this.a).b(ViberIdMessageUtil.createEmailConnectedSystemMessage(bm.this.a, "test@viber.com"));
      }
    });
    return true;
  }

  public boolean a(Preference paramPreference, Object paramObject)
  {
    String str = paramPreference.C();
    if (d.bg.h.c().equals(str))
    {
      d.bg.h.a((String)paramObject);
      ((ListPreference)paramPreference).b(((ListPreference)paramPreference).c(d.bg.h.d()));
      p.a.g.c(ViberApplication.getApplication());
      ViberApplication.exit(null, true);
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.bm
 * JD-Core Version:    0.6.2
 */