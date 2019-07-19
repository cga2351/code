package android.support.v7.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class DropDownPreference extends ListPreference
{
  private final Context a;
  private final ArrayAdapter b;
  private Spinner c;
  private final AdapterView.OnItemSelectedListener d = new AdapterView.OnItemSelectedListener()
  {
    public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      if (paramAnonymousInt >= 0)
      {
        String str = DropDownPreference.this.n()[paramAnonymousInt].toString();
        if ((!str.equals(DropDownPreference.this.p())) && (DropDownPreference.this.b(str)))
          DropDownPreference.this.b(str);
      }
    }

    public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView)
    {
    }
  };

  public DropDownPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.dropdownPreferenceStyle);
  }

  public DropDownPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }

  public DropDownPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    this.a = paramContext;
    this.b = b();
    S();
  }

  private void S()
  {
    this.b.clear();
    if (m() != null)
      for (CharSequence localCharSequence : m())
        this.b.add(localCharSequence.toString());
  }

  public int a(String paramString)
  {
    CharSequence[] arrayOfCharSequence = n();
    if ((paramString != null) && (arrayOfCharSequence != null))
      for (int i = -1 + arrayOfCharSequence.length; i >= 0; i--)
        if (arrayOfCharSequence[i].equals(paramString))
          return i;
    return -1;
  }

  public void a(l paraml)
  {
    this.c = ((Spinner)paraml.itemView.findViewById(R.id.spinner));
    this.c.setAdapter(this.b);
    this.c.setOnItemSelectedListener(this.d);
    this.c.setSelection(a(p()));
    super.a(paraml);
  }

  public void a(CharSequence[] paramArrayOfCharSequence)
  {
    super.a(paramArrayOfCharSequence);
    S();
  }

  protected ArrayAdapter b()
  {
    return new ArrayAdapter(this.a, 17367049);
  }

  public void b(int paramInt)
  {
    b(n()[paramInt].toString());
  }

  protected void d_()
  {
    super.d_();
    this.b.notifyDataSetChanged();
  }

  protected void k()
  {
    this.c.performClick();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.preference.DropDownPreference
 * JD-Core Version:    0.6.2
 */