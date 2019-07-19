package com.viber.voip.publicaccount.wizard;

import android.os.Bundle;
import com.viber.common.b.h;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.entity.PublicAccount.Background;
import com.viber.voip.publicaccount.ui.screen.b.c;
import com.viber.voip.publicaccount.wizard.a.d;
import com.viber.voip.publicaccount.wizard.a.e.a;
import com.viber.voip.settings.d.i;
import com.viber.voip.util.dj;

public class CreatePublicAccountWizardActivity extends PublicAccountWizardActivity
{
  private long a = System.currentTimeMillis();

  private Bundle f()
  {
    Bundle localBundle = new Bundle();
    PublicAccount localPublicAccount = new PublicAccount();
    localPublicAccount.setBackground(new PublicAccount.Background(d.i.g.d(), null));
    localBundle.putParcelable("public_account", localPublicAccount);
    localBundle.putLong("creation_start_timestamp", this.a);
    localBundle.putSerializable("screen_source", e.a.a);
    return localBundle;
  }

  protected com.viber.voip.publicaccount.wizard.a.a a()
  {
    return new a(this);
  }

  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    if (paramBundle != null)
    {
      long l = paramBundle.getLong("extra_creation_started_timestamp", -1L);
      if (l != -1L)
        this.a = l;
    }
    if (!b())
      a(f());
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putLong("extra_creation_started_timestamp", this.a);
  }

  public boolean onSupportNavigateUp()
  {
    dj.d(this);
    return super.onSupportNavigateUp();
  }

  public static class a extends com.viber.voip.publicaccount.wizard.a.a
  {
    public a(d paramd)
    {
      super();
    }

    public int a()
    {
      return 5;
    }

    public com.viber.voip.publicaccount.wizard.a.b a(int paramInt, Bundle paramBundle)
    {
      if (paramBundle == null)
        throw new IllegalArgumentException("Data parameter can't be NULL for this wizard");
      switch (paramInt)
      {
      default:
        throw new IndexOutOfBoundsException("Invalid index " + paramInt + ", length is " + a());
      case 0:
        return com.viber.voip.publicaccount.ui.screen.b.b.a(paramBundle);
      case 1:
        return com.viber.voip.publicaccount.ui.screen.b.a.a(paramBundle);
      case 2:
        return c.a(paramBundle);
      case 3:
        return com.viber.voip.publicaccount.ui.screen.a.b.a(paramBundle);
      case 4:
      }
      return com.viber.voip.publicaccount.ui.screen.a.a.a(paramBundle);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.wizard.CreatePublicAccountWizardActivity
 * JD-Core Version:    0.6.2
 */