package com.viber.voip;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.cdr.entity.PublicAccountInteraction;
import com.viber.voip.analytics.a.i;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.e.c;
import com.viber.voip.analytics.story.l.b;
import com.viber.voip.analytics.story.o;

public class ShareChooserReceiver extends BroadcastReceiver
{
  private static final Logger a = ViberEnv.getLogger();

  private String a(String paramString)
  {
    if ("share_type_invite_contact".equals(paramString))
      return "share_type_invite_contact";
    if ("share_type_public_account".equals(paramString))
      return "share_type_public_account";
    if ("share_type_invite_group".equals(paramString))
      return "share_type_invite_group";
    if ("share_type_invite_community".equals(paramString))
      return "share_type_invite_community";
    return "share_type_unknown";
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ComponentName localComponentName = (ComponentName)paramIntent.getParcelableExtra("android.intent.extra.CHOSEN_COMPONENT");
    String str1;
    String str2;
    if (localComponentName != null)
    {
      str1 = localComponentName.getPackageName();
      str2 = a(paramIntent.getStringExtra("share_type"));
      if (!str2.equals("share_type_public_account"))
        break label184;
      int i = paramIntent.getIntExtra("media_type", -1);
      int j = paramIntent.getIntExtra("file_size", 0);
      ICdrController localICdrController = ViberApplication.getInstance().getEngine(false).getCdrController();
      localICdrController.handleReportShareNativeMenu(i, str1, j, 1);
      PublicAccountInteraction localPublicAccountInteraction = (PublicAccountInteraction)paramIntent.getParcelableExtra("public_account_cdr_interaction");
      if (localPublicAccountInteraction != null)
        localICdrController.handleReportPAInteractions(localPublicAccountInteraction.publicAccountId, localPublicAccountInteraction.publicAccountCategory, localPublicAccountInteraction.publicAccountSubcategory, localPublicAccountInteraction.publicAccountCountryCode, localPublicAccountInteraction.publicAccountLocationInfo, localPublicAccountInteraction.publicChatSessionToken, localPublicAccountInteraction.messageMediaType, localPublicAccountInteraction.messageUrl, null, localPublicAccountInteraction.isGifMessage, localPublicAccountInteraction.messageStickerNumber, localPublicAccountInteraction.messageToken, localPublicAccountInteraction.messageSequence, localPublicAccountInteraction.publicAccountUserRole);
    }
    label184: 
    do
    {
      return;
      str1 = null;
      break;
      if (str2.equals("share_type_invite_contact"))
      {
        if (paramIntent.getBooleanExtra("invitation_track_by_external_trackers", false))
        {
          g.a().a(i.h(str1));
          g.a().a(i.i(str1));
          g.a().a(b.a(str1));
        }
        ViberApplication.getInstance().getEngine(false).getCdrController().handleReportShareInvitationNativeMenu(str1, 1);
        return;
      }
    }
    while (!str2.equals("share_type_invite_community"));
    g.a().c().g().a(1, null, true);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ShareChooserReceiver
 * JD-Core Version:    0.6.2
 */