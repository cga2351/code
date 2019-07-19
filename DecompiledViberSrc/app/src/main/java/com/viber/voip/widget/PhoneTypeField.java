package com.viber.voip.widget;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.registration.CountryCode;
import com.viber.voip.ui.ViberEditText;
import com.viber.voip.util.af;
import com.viber.voip.util.bq;

public class PhoneTypeField extends ViberEditText
  implements TextWatcher
{
  private static final Logger a = ViberEnv.getLogger();
  private String b;
  private String c;
  private b d;
  private CountryCode e = null;
  private a f;
  private c g;

  public PhoneTypeField(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (!isInEditMode())
      this.d = new b(paramContext.getContentResolver());
    c();
  }

  private void c()
  {
    addTextChangedListener(this);
    setOnLongClickListener(new View.OnLongClickListener()
    {
      public boolean onLongClick(View paramAnonymousView)
      {
        PhoneTypeField.this.setInputType(3);
        PhoneTypeField.this.setCursorVisible(true);
        return false;
      }
    });
  }

  public void a()
  {
    if (!TextUtils.isEmpty(PhoneNumberUtils.stripSeparators(getText().toString())));
    while (true)
    {
      if (this.g != null)
        this.g.u_();
      return;
      this.b = "";
      this.c = "";
      this.e = null;
    }
  }

  public void afterTextChanged(Editable paramEditable)
  {
    a();
  }

  public void b()
  {
    setCursorVisible(false);
    setInputType(0);
  }

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public String getHiddenName()
  {
    return this.c;
  }

  public Editable getPhoneFieldEditable()
  {
    return getText();
  }

  public int getPhoneFieldLength()
  {
    return length();
  }

  public String getPhoneTypeText()
  {
    return getText().toString();
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    b();
  }

  public void setContactLookupListener(a parama)
  {
    this.f = parama;
  }

  public void setPhoneFieldText(String paramString)
  {
    setText(paramString);
  }

  public void setPhoneFieldTextChangeListener(c paramc)
  {
    this.g = paramc;
  }

  public static abstract interface a
  {
    public abstract void a(String paramString);

    public abstract void d();
  }

  class b extends bq
  {
    public final int c = 1591;
    public final String[] d = { "display_name" };
    public final String e = "_id IN (SELECT contact_id FROM phonebookdata WHERE data2=? OR data1=? )";
    public final String f = "display_name ASC";

    public b(ContentResolver arg2)
    {
      super();
    }

    protected void a(int paramInt, Object paramObject, Cursor paramCursor)
    {
      if ((paramInt == 1591) && (paramCursor != null) && (paramCursor.moveToFirst()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        do
        {
          if (localStringBuilder.length() > 0)
            localStringBuilder.append(',').append(' ');
          localStringBuilder.append(paramCursor.getString(paramCursor.getColumnIndex("display_name")));
        }
        while (paramCursor.moveToNext());
        PhoneTypeField.a(PhoneTypeField.this, localStringBuilder.toString());
        if (PhoneTypeField.a(PhoneTypeField.this) != null)
          PhoneTypeField.a(PhoneTypeField.this).a(localStringBuilder.toString());
      }
      while (true)
      {
        af.a(paramCursor);
        return;
        PhoneTypeField.a(PhoneTypeField.this, "");
        if (PhoneTypeField.a(PhoneTypeField.this) != null)
          PhoneTypeField.a(PhoneTypeField.this).d();
      }
    }
  }

  public static abstract interface c
  {
    public abstract void u_();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.PhoneTypeField
 * JD-Core Version:    0.6.2
 */