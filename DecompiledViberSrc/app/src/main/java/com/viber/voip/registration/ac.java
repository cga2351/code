package com.viber.voip.registration;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import c.b.a.a.j;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.f.d;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.util.ao;
import com.viber.voip.util.dj;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ac
  implements View.OnClickListener
{
  private final Logger a = ViberEnv.getLogger();
  private Context b;
  private l c;
  private b d;
  private final boolean e;
  private TextView f;
  private EditText g;
  private EditText h;
  private a i = a.b;
  private CountryCode j;
  private HashMap<String, CountryCode> k = new HashMap();
  private boolean l = false;
  private boolean m = false;
  private CountryCode n;
  private String o;
  private final Runnable p = new ad(this);
  private final Handler q;
  private final TextWatcher r = new TextWatcher()
  {
    private void a()
    {
      if (ac.f(ac.this))
        return;
      ac.a(ac.this, true);
      String str1 = ac.g(ac.this).getText().toString().replaceAll("\\D+", "");
      ac.g(ac.this).setText(str1);
      if (str1.length() == 0)
      {
        ac.h(ac.this).setText(R.string.activation_country_code);
        ac.a(ac.this, ac.a.b);
        ac.a(ac.this, null);
        ac.a(ac.this, false);
        return;
      }
      int j;
      label122: String str4;
      String str5;
      int k;
      label211: String str2;
      int i;
      String str3;
      if (str1.length() > 4)
      {
        ac.a(ac.this, true);
        j = 4;
        if (j >= 1)
        {
          str4 = str1.substring(0, j);
          if ((CountryCode)ac.i(ac.this).get(str4) != null)
          {
            str5 = str1.substring(j, str1.length()) + ac.a(ac.this).getText().toString();
            ac.g(ac.this).setText(str4);
            k = 1;
            if (k == 0)
            {
              ac.a(ac.this, true);
              str5 = str4.substring(1, str4.length()) + ac.a(ac.this).getText().toString();
              EditText localEditText = ac.g(ac.this);
              str4 = str4.substring(0, 1);
              localEditText.setText(str4);
            }
            String str6 = str5;
            str2 = str4;
            i = k;
            str3 = str6;
          }
        }
      }
      while (true)
      {
        CountryCode localCountryCode = (CountryCode)ac.i(ac.this).get(str2);
        if (localCountryCode != null)
        {
          ac.h(ac.this).setText(localCountryCode.getName());
          ac.a(ac.this, ac.a.a);
          ac.a(ac.this, localCountryCode);
          ac.j(ac.this).a(localCountryCode.getCode(), localCountryCode.getIddCode());
        }
        while (true)
        {
          if (i == 0)
            ac.g(ac.this).setSelection(ac.g(ac.this).getText().length());
          if (str3 == null)
            break;
          ac.a(ac.this).requestFocus();
          ac.a(ac.this).setText(str3);
          ac.a(ac.this).setSelection(ac.a(ac.this).length());
          break;
          j--;
          break label122;
          ac.h(ac.this).setText(R.string.activation_invalid_country_code);
          ac.a(ac.this, ac.a.c);
          ac.a(ac.this, null);
        }
        str4 = str1;
        str5 = null;
        k = 0;
        break label211;
        str2 = str1;
        str3 = null;
        i = 0;
      }
    }

    public void afterTextChanged(Editable paramAnonymousEditable)
    {
      a();
      ac.c(ac.this);
    }

    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
    }

    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
    }
  };
  private r s;
  private final l.b t = new l.b()
  {
    public void a(CountryCode paramAnonymousCountryCode)
    {
      ac.k(ac.this).b(this);
      ac.this.a(paramAnonymousCountryCode, null);
    }
  };

  public ac(Context paramContext, View paramView, l paraml, d paramd, b paramb)
  {
    this(paramContext, paramView, paraml, paramd, paramb, true);
  }

  private ac(Context paramContext, View paramView, l paraml, final d paramd, b paramb, boolean paramBoolean)
  {
    this.b = paramContext;
    this.c = paraml;
    this.d = paramb;
    this.e = paramBoolean;
    this.q = av.a(av.e.a);
    List localList = this.c.b();
    for (int i1 = 0; i1 < localList.size(); i1++)
    {
      CountryCode localCountryCode2 = (CountryCode)localList.get(i1);
      this.k.put(localCountryCode2.getIddCode(), localCountryCode2);
    }
    this.f = ((TextView)paramView.findViewById(R.id.registration_country_btn));
    this.f.setOnClickListener(this);
    this.f.setText(R.string.activation_country_code);
    this.g = ((EditText)paramView.findViewById(R.id.registration_code_field));
    InputFilter[] arrayOfInputFilter = new InputFilter[1];
    arrayOfInputFilter[0] = new InputFilter.LengthFilter(5);
    this.g.setFilters(arrayOfInputFilter);
    this.g.addTextChangedListener(this.r);
    this.g.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if (paramAnonymousInt == 5)
        {
          ac.a(ac.this).requestFocus();
          ac.a(ac.this).setSelection(ac.a(ac.this).length());
          return true;
        }
        return false;
      }
    });
    if (this.e)
    {
      dj.b(this.g);
      this.g.requestFocus();
    }
    this.h = ((EditText)paramView.findViewById(R.id.registration_phone_field));
    ArrayList localArrayList = new ArrayList(Arrays.asList(this.h.getFilters()));
    final ao local2 = new ao()
    {
      private boolean a(char paramAnonymousChar)
      {
        return (paramAnonymousChar >= '0') && (paramAnonymousChar <= '9');
      }

      public CharSequence a(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, Spanned paramAnonymousSpanned, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        if (paramAnonymousInt2 - paramAnonymousInt1 == 1)
        {
          if (a(paramAnonymousCharSequence.charAt(paramAnonymousInt1)))
            return paramAnonymousCharSequence;
          return "";
        }
        StringBuilder localStringBuilder = new StringBuilder(paramAnonymousInt2 - paramAnonymousInt1);
        while (paramAnonymousInt1 < paramAnonymousInt2)
        {
          if (a(paramAnonymousCharSequence.charAt(paramAnonymousInt1)))
            localStringBuilder.append(paramAnonymousCharSequence.charAt(paramAnonymousInt1));
          paramAnonymousInt1++;
        }
        return localStringBuilder.toString();
      }
    };
    localArrayList.add(local2);
    this.h.setFilters((InputFilter[])localArrayList.toArray(new InputFilter[localArrayList.size()]));
    CountryCode localCountryCode1 = this.c.c();
    this.s = new r(this.b, localCountryCode1.getCode(), localCountryCode1.getIddCode())
    {
      private boolean f;

      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        local2.a(false);
        super.afterTextChanged(paramAnonymousEditable);
        ac.c(ac.this);
        local2.a(true);
      }

      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        super.onTextChanged(paramAnonymousCharSequence, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        if ((this.f) && (!ac.b(ac.this)) && (paramd != null))
        {
          this.f = false;
          paramd.a("Manually by user");
        }
      }
    };
    this.h.addTextChangedListener(this.s);
    this.h.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if (paramAnonymousInt == 5)
        {
          if (ac.d(ac.this))
            ac.e(ac.this).aa_();
          return true;
        }
        return false;
      }
    });
  }

  public ac(Context paramContext, View paramView, l paraml, b paramb)
  {
    this(paramContext, paramView, paraml, null, paramb, false);
  }

  private void a(CountryCode paramCountryCode)
  {
    this.l = true;
    this.g.setText(paramCountryCode.getIddCode());
    this.f.setText(paramCountryCode.getName());
    this.i = a.a;
    this.j = paramCountryCode;
    this.l = false;
    this.s.a(paramCountryCode.getCode(), paramCountryCode.getIddCode());
  }

  private void a(String paramString)
  {
    this.m = true;
    this.h.setText(paramString);
    this.h.setSelection(this.h.length());
    this.m = false;
  }

  private void f()
  {
    this.d.a(g());
  }

  private boolean g()
  {
    return (!TextUtils.isEmpty(b())) && (this.i == a.a);
  }

  private void h()
  {
    av.a(av.e.a).postDelayed(new Runnable()
    {
      public void run()
      {
        dj.b(ac.a(ac.this));
      }
    }
    , 300L);
    this.h.requestFocus();
    this.h.setSelection(this.h.length());
  }

  public CountryCode a()
  {
    return this.j;
  }

  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 1) && (paramIntent != null) && (paramIntent.hasExtra("extra_selected_code")))
    {
      this.q.removeCallbacks(this.p);
      b((CountryCode)paramIntent.getParcelableExtra("extra_selected_code"), null);
    }
  }

  public void a(CountryCode paramCountryCode, String paramString)
  {
    this.n = paramCountryCode;
    this.o = paramString;
    this.q.post(this.p);
  }

  public void a(boolean paramBoolean)
  {
    this.d.a(paramBoolean);
    this.f.setEnabled(paramBoolean);
    this.g.setEnabled(paramBoolean);
    this.h.setEnabled(paramBoolean);
  }

  public String b()
  {
    return j.c(this.h.getText().toString());
  }

  public void b(CountryCode paramCountryCode, String paramString)
  {
    CountryCode localCountryCode;
    if (paramCountryCode != null)
    {
      if (!"39066".equals(paramCountryCode.getIddCode()))
        break label94;
      localCountryCode = (CountryCode)this.k.get("39");
      if ((TextUtils.isEmpty(paramString)) && (TextUtils.isEmpty(b())))
        paramString = "39066".substring("39".length());
    }
    while (true)
    {
      a(localCountryCode);
      if (!TextUtils.isEmpty(paramString))
        a(paramString);
      if (this.e)
        h();
      f();
      return;
      label94: localCountryCode = paramCountryCode;
    }
  }

  public void c()
  {
    this.c.a(this.t);
    this.c.d();
  }

  public void d()
  {
    this.c.b(this.t);
  }

  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.registration_country_btn)
    {
      Intent localIntent = new Intent(this.b, SelectCountryActivity.class);
      localIntent.putExtra("extra_selected_code", this.j);
      this.d.a(localIntent, 1);
    }
  }

  private static enum a
  {
    static
    {
      a[] arrayOfa = new a[3];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
    }
  }

  public static abstract interface b
  {
    public abstract void a(Intent paramIntent, int paramInt);

    public abstract void a(boolean paramBoolean);

    public abstract void aa_();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.ac
 * JD-Core Version:    0.6.2
 */