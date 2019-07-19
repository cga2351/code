package com.viber.voip.publicaccount.wizard.a;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.viber.voip.R.id;
import com.viber.voip.R.menu;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.ui.aq;

public abstract class e extends aq
  implements b
{
  protected c a;
  protected MenuItem b;
  protected PublicAccount c;
  protected long d = -1L;
  protected a e = a.b;

  protected static Bundle b(Bundle paramBundle)
  {
    if (!paramBundle.containsKey("public_account"))
      throw new IllegalArgumentException("Data has to contain 'public_account'");
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("public_account", paramBundle.getParcelable("public_account"));
    localBundle.putLong("creation_start_timestamp", paramBundle.getLong("creation_start_timestamp", -1L));
    localBundle.putSerializable("screen_source", paramBundle.getSerializable("screen_source"));
    return localBundle;
  }

  protected abstract void a();

  protected void a(boolean paramBoolean)
  {
    if (this.b == null)
      return;
    this.b.setVisible(paramBoolean);
  }

  protected void c(Bundle paramBundle)
  {
    this.d = paramBundle.getLong("creation_start_timestamp");
    this.c = ((PublicAccount)paramBundle.getParcelable("public_account"));
    a locala = (a)paramBundle.getSerializable("screen_source");
    if (locala != null)
      this.e = locala;
  }

  protected void d(Bundle paramBundle)
  {
    if (this.a != null)
      this.a.b(paramBundle);
  }

  protected boolean d()
  {
    return true;
  }

  public boolean e()
  {
    return false;
  }

  public String f()
  {
    return getClass().getName();
  }

  public Bundle g()
  {
    if (this.c == null)
      c(getArguments());
    Bundle localBundle = new Bundle(3);
    localBundle.putParcelable("public_account", new PublicAccount(this.c));
    if (this.d != -1L)
      localBundle.putLong("creation_start_timestamp", this.d);
    localBundle.putSerializable("screen_source", this.e);
    return localBundle;
  }

  public e i()
  {
    return this;
  }

  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    if ((paramContext instanceof c))
    {
      this.a = ((c)paramContext);
      return;
    }
    throw new RuntimeException(paramContext.toString() + " must implement Wizard");
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = getArguments();
    if (localBundle != null)
      c(localBundle);
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
    if (d())
    {
      paramMenuInflater.inflate(R.menu.menu_create_pa_wizard, paramMenu);
      this.b = paramMenu.findItem(R.id.menu_done);
      a(false);
    }
  }

  public void onDetach()
  {
    super.onDetach();
    this.a = null;
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == R.id.menu_done)
    {
      a();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[2];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.wizard.a.e
 * JD-Core Version:    0.6.2
 */