package com.viber.voip.publicaccount.wizard;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.ai.i;
import com.viber.voip.messages.k;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.wizard.a.d;
import com.viber.voip.util.da;

public class SetupInboxWizardActivity extends PublicAccountWizardActivity
  implements ai.i
{
  private static final Logger a = ViberEnv.getLogger();
  private boolean b;

  private void a(String paramString)
  {
    if (da.a(paramString))
    {
      finish();
      return;
    }
    ViberApplication.getInstance().getMessagesManager().c().a(paramString, this);
  }

  protected com.viber.voip.publicaccount.wizard.a.a a()
  {
    return new a(this);
  }

  public void a(final PublicAccount paramPublicAccount)
  {
    if (!this.b)
      return;
    av.e.a.a().post(new Runnable()
    {
      public void run()
      {
        if (paramPublicAccount == null)
        {
          SetupInboxWizardActivity.this.finish();
          return;
        }
        Bundle localBundle = new Bundle(1);
        localBundle.putParcelable("public_account", paramPublicAccount);
        SetupInboxWizardActivity.this.a(localBundle);
      }
    });
  }

  protected void onPause()
  {
    this.b = false;
    super.onPause();
  }

  protected void onResume()
  {
    super.onResume();
    this.b = true;
    if (!b())
    {
      setTitle(R.string.create_public_account_chat_solution_title);
      a(getIntent().getStringExtra("extra_public_account_id"));
    }
  }

  public static class a extends com.viber.voip.publicaccount.wizard.a.a
  {
    public a(d paramd)
    {
      super();
    }

    public int a()
    {
      return 2;
    }

    public com.viber.voip.publicaccount.wizard.a.b a(int paramInt, Bundle paramBundle)
    {
      switch (paramInt)
      {
      default:
        throw new IndexOutOfBoundsException("Invalid index " + paramInt + ", length is " + a());
      case 0:
        return com.viber.voip.publicaccount.ui.screen.a.b.a(paramBundle);
      case 1:
      }
      return com.viber.voip.publicaccount.ui.screen.a.a.a(paramBundle);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.wizard.SetupInboxWizardActivity
 * JD-Core Version:    0.6.2
 */