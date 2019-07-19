package android.support.v7.preference;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v7.app.c.a;

public class c extends f
{
  int a;
  private CharSequence[] b;
  private CharSequence[] c;

  public static c a(String paramString)
  {
    c localc = new c();
    Bundle localBundle = new Bundle(1);
    localBundle.putString("key", paramString);
    localc.setArguments(localBundle);
    return localc;
  }

  private ListPreference c()
  {
    return (ListPreference)b();
  }

  protected void a(c.a parama)
  {
    super.a(parama);
    parama.a(this.b, this.a, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        c.this.a = paramAnonymousInt;
        c.this.onClick(paramAnonymousDialogInterface, -1);
        paramAnonymousDialogInterface.dismiss();
      }
    });
    parama.a(null, null);
  }

  public void a(boolean paramBoolean)
  {
    ListPreference localListPreference = c();
    if ((paramBoolean) && (this.a >= 0))
    {
      String str = this.c[this.a].toString();
      if (localListPreference.b(str))
        localListPreference.b(str);
    }
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle == null)
    {
      ListPreference localListPreference = c();
      if ((localListPreference.m() == null) || (localListPreference.n() == null))
        throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
      this.a = localListPreference.c(localListPreference.p());
      this.b = localListPreference.m();
      this.c = localListPreference.n();
      return;
    }
    this.a = paramBundle.getInt("ListPreferenceDialogFragment.index", 0);
    this.b = paramBundle.getCharSequenceArray("ListPreferenceDialogFragment.entries");
    this.c = paramBundle.getCharSequenceArray("ListPreferenceDialogFragment.entryValues");
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("ListPreferenceDialogFragment.index", this.a);
    paramBundle.putCharSequenceArray("ListPreferenceDialogFragment.entries", this.b);
    paramBundle.putCharSequenceArray("ListPreferenceDialogFragment.entryValues", this.c);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.preference.c
 * JD-Core Version:    0.6.2
 */