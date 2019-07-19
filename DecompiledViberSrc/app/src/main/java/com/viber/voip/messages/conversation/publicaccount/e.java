package com.viber.voip.messages.conversation.publicaccount;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m;
import com.viber.voip.ViberApplication;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.conversation.ui.ConversationBannerView;
import com.viber.voip.messages.k;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.r;
import com.viber.voip.user.UserData;
import com.viber.voip.user.UserManager;
import com.viber.voip.user.UserProfilePreviewActivity;
import com.viber.voip.util.ViberActionRunner.bt;
import java.util.Collections;

public class e
{
  private final k a = ViberApplication.getInstance().getMessagesManager();
  private final ConversationBannerView b;

  public e(ConversationBannerView paramConversationBannerView)
  {
    this.b = paramConversationBannerView;
  }

  public void a(Fragment paramFragment)
  {
    FragmentActivity localFragmentActivity = paramFragment.getActivity();
    UserData localUserData = UserManager.from(localFragmentActivity).getUserData();
    if ((!localUserData.getViberName().isEmpty()) && (!localUserData.getViberImage().isEmpty()))
    {
      paramFragment.startActivityForResult(new Intent(localFragmentActivity, UserProfilePreviewActivity.class), 900);
      return;
    }
    r.g().a(paramFragment).b(paramFragment);
  }

  public boolean a(int paramInt1, int paramInt2, long paramLong)
  {
    if (900 == paramInt1)
    {
      if (paramInt2 == -1)
      {
        this.a.d().a(paramLong);
        this.b.b();
      }
      return true;
    }
    return false;
  }

  public boolean a(Activity paramActivity, m paramm, int paramInt1, long paramLong, int paramInt2)
  {
    if ((paramm.a(DialogCode.D1012a)) && (-1 == paramInt1))
    {
      ViberActionRunner.bt.d(paramActivity);
      return true;
    }
    if ((paramm.a(DialogCode.D1002a)) && (-1 == paramInt1))
    {
      this.a.c().a(Collections.singleton(Long.valueOf(paramLong)), paramInt2);
      return true;
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.publicaccount.e
 * JD-Core Version:    0.6.2
 */