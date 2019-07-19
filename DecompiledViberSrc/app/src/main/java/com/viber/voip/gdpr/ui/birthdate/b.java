package com.viber.voip.gdpr.ui.birthdate;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.Html;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.viber.common.dialogs.e.a;
import com.viber.common.dialogs.i.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.a;
import com.viber.common.dialogs.m.c;
import com.viber.common.dialogs.m.d;
import com.viber.common.dialogs.m.e;
import com.viber.svg.jni.SvgImageView;
import com.viber.voip.R.color;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.gdpr.f;
import com.viber.voip.settings.d.at;
import com.viber.voip.ui.ViberButton;
import com.viber.voip.ui.aq;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.a.c.a;
import com.viber.voip.ui.dialogs.j;
import com.viber.voip.ui.style.NoUnderlineSpan;
import com.viber.voip.util.ParcelableInt;

public class b extends aq
  implements View.OnClickListener, DatePicker.OnDateChangedListener, m.c, m.d, m.e, a.c
{
  private a.a a;
  private ViberButton b;
  private TextView c;
  private DatePicker d;
  private SvgImageView e;
  private final m.a f = new c.a();

  private void a(View paramView)
  {
    this.d = ((DatePicker)paramView.findViewById(R.id.date_picker));
    this.c = ((TextView)paramView.findViewById(R.id.birthdate_input));
    this.b = ((ViberButton)paramView.findViewById(R.id.btn_done));
    this.e = ((SvgImageView)paramView.findViewById(R.id.icon_view));
    this.e.loadFromAsset(getContext(), "svg/birthday_update.svg", "", 0);
    TextView localTextView = (TextView)paramView.findViewById(R.id.summary);
    SpannableString localSpannableString = new SpannableString(Html.fromHtml(getString(R.string.date_of_birth_explanation).replace("?", "")));
    localSpannableString.setSpan(new NoUnderlineSpan(), 0, localSpannableString.length(), 33);
    localTextView.setText(localSpannableString, TextView.BufferType.SPANNABLE);
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
    this.b.setEnabled(false);
    this.b.setOnClickListener(this);
  }

  private void c()
  {
    SvgImageView localSvgImageView = this.e;
    c localc = new c(this);
    if (this.e.isSvgEnabled());
    for (long l = 0L; ; l = 500L)
    {
      localSvgImageView.postDelayed(localc, l);
      return;
    }
  }

  public void a()
  {
    j.g().a(this).b(this);
  }

  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2)
  {
    this.d.setMaxDate(paramLong2);
    this.d.setMinDate(paramLong1);
    this.d.init(paramInt1, paramInt2, paramInt3, this);
  }

  public void a(String paramString)
  {
    this.b.setEnabled(true);
    this.c.setText(paramString);
    this.c.setTextColor(ContextCompat.getColor(getActivity(), R.color.main_text));
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    a.a locala = this.a;
    if (paramBundle == null);
    for (boolean bool = true; ; bool = false)
    {
      locala.a(this, bool);
      return;
    }
  }

  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.btn_done)
      this.a.b();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(true);
    this.a = new d(new e(getActivity()), ViberApplication.getInstance().getLocaleDataCache().b(), f.a(getContext()), d.at.b);
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenuInflater.inflate(R.menu.menu_user_birthdate, paramMenu);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.fragment_user_birthdate, paramViewGroup, false);
  }

  public void onDateChanged(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.a(paramInt3, paramInt2, paramInt1);
  }

  public void onDestroyView()
  {
    this.a.a();
    super.onDestroyView();
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    if ((paramm.a(DialogCode.D460a)) && (-1000 == paramInt))
      this.a.d();
  }

  public void onDialogDataListAction(m paramm, int paramInt, Object paramObject)
  {
    int i;
    if (paramm.a(DialogCode.D460a))
    {
      i = ((ParcelableInt)paramObject).getValue();
      if (-2 != i)
        break label37;
      this.a.a(1);
    }
    label37: 
    while (-1 != i)
      return;
    this.a.a(2);
  }

  public void onDialogDataListBind(m paramm, i.a parama)
  {
    this.f.onDialogDataListBind(paramm, parama);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == R.id.menu_skip)
    {
      this.a.c();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  public void onResume()
  {
    super.onResume();
    c();
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a(paramView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gdpr.ui.birthdate.b
 * JD-Core Version:    0.6.2
 */