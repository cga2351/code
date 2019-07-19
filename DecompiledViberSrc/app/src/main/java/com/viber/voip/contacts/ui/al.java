package com.viber.voip.contacts.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.viber.voip.R.id;
import com.viber.voip.ui.ac;
import com.viber.voip.ui.ac.a;

public class al extends ac
{
  private final View a;
  private final EditText b;

  public al(ac.a parama, View paramView)
  {
    super(parama);
    this.a = paramView;
    this.b = ((EditText)this.a.findViewById(R.id.participant_search));
    if (this.b != null)
      this.b.addTextChangedListener(new TextWatcher()
      {
        public void afterTextChanged(Editable paramAnonymousEditable)
        {
        }

        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
        }

        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          if (al.a(al.this) != null)
            al.b(al.this).onQueryTextChange(paramAnonymousCharSequence.toString());
        }
      });
  }

  public String a()
  {
    if (this.b != null)
      return this.b.getText().toString();
    return "";
  }

  public void a(String paramString)
  {
    EditText localEditText;
    if (this.b != null)
    {
      localEditText = this.b;
      if (paramString != null)
        break label40;
    }
    label40: for (String str = ""; ; str = paramString)
    {
      localEditText.setText(str);
      if (paramString != null)
        this.b.setSelection(paramString.length());
      return;
    }
  }

  public void b()
  {
    if (this.b != null)
      this.b.setText("");
  }

  public View c()
  {
    return this.b;
  }

  public void d()
  {
    if ((this.a != null) && (this.a.getVisibility() == 8))
      this.a.setVisibility(0);
  }

  public boolean e()
  {
    View localView = this.a;
    boolean bool = false;
    if (localView != null)
    {
      int i = this.a.getVisibility();
      bool = false;
      if (i == 0)
        bool = true;
    }
    return bool;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.al
 * JD-Core Version:    0.6.2
 */