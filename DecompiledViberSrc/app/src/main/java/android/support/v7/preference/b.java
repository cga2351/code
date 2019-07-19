package android.support.v7.preference;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

public class b extends f
{
  private EditText a;
  private CharSequence b;

  public static b a(String paramString)
  {
    b localb = new b();
    Bundle localBundle = new Bundle(1);
    localBundle.putString("key", paramString);
    localb.setArguments(localBundle);
    return localb;
  }

  private EditTextPreference c()
  {
    return (EditTextPreference)b();
  }

  protected void a(View paramView)
  {
    super.a(paramView);
    this.a = ((EditText)paramView.findViewById(16908291));
    this.a.requestFocus();
    if (this.a == null)
      throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
    this.a.setText(this.b);
    this.a.setSelection(this.a.getText().length());
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      String str = this.a.getText().toString();
      if (c().b(str))
        c().a(str);
    }
  }

  protected boolean a()
  {
    return true;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle == null)
    {
      this.b = c().b();
      return;
    }
    this.b = paramBundle.getCharSequence("EditTextPreferenceDialogFragment.text");
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putCharSequence("EditTextPreferenceDialogFragment.text", this.b);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.preference.b
 * JD-Core Version:    0.6.2
 */