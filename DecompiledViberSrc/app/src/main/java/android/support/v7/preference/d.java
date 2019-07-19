package android.support.v7.preference;

import android.content.DialogInterface;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.os.Bundle;
import android.support.v7.app.c.a;
import android.support.v7.preference.internal.AbstractMultiSelectListPreference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class d extends f
{
  Set<String> a = new HashSet();
  boolean b;
  CharSequence[] c;
  CharSequence[] d;

  public static d a(String paramString)
  {
    d locald = new d();
    Bundle localBundle = new Bundle(1);
    localBundle.putString("key", paramString);
    locald.setArguments(localBundle);
    return locald;
  }

  private AbstractMultiSelectListPreference c()
  {
    return (AbstractMultiSelectListPreference)b();
  }

  protected void a(c.a parama)
  {
    super.a(parama);
    int i = this.d.length;
    boolean[] arrayOfBoolean = new boolean[i];
    for (int j = 0; j < i; j++)
      arrayOfBoolean[j] = this.a.contains(this.d[j].toString());
    parama.a(this.c, arrayOfBoolean, new DialogInterface.OnMultiChoiceClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          d locald2 = d.this;
          locald2.b |= d.this.a.add(d.this.d[paramAnonymousInt].toString());
          return;
        }
        d locald1 = d.this;
        locald1.b |= d.this.a.remove(d.this.d[paramAnonymousInt].toString());
      }
    });
  }

  public void a(boolean paramBoolean)
  {
    AbstractMultiSelectListPreference localAbstractMultiSelectListPreference = c();
    if ((paramBoolean) && (this.b))
    {
      Set localSet = this.a;
      if (localAbstractMultiSelectListPreference.b(localSet))
        localAbstractMultiSelectListPreference.a(localSet);
    }
    this.b = false;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle == null)
    {
      AbstractMultiSelectListPreference localAbstractMultiSelectListPreference = c();
      if ((localAbstractMultiSelectListPreference.a() == null) || (localAbstractMultiSelectListPreference.b() == null))
        throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
      this.a.clear();
      this.a.addAll(localAbstractMultiSelectListPreference.c());
      this.b = false;
      this.c = localAbstractMultiSelectListPreference.a();
      this.d = localAbstractMultiSelectListPreference.b();
      return;
    }
    this.a.clear();
    this.a.addAll(paramBundle.getStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values"));
    this.b = paramBundle.getBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", false);
    this.c = paramBundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries");
    this.d = paramBundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues");
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values", new ArrayList(this.a));
    paramBundle.putBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", this.b);
    paramBundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries", this.c);
    paramBundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues", this.d);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.preference.d
 * JD-Core Version:    0.6.2
 */