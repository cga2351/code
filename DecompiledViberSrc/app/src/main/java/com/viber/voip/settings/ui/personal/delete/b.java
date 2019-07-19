package com.viber.voip.settings.ui.personal.delete;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.c;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.gdpr.a.e;
import com.viber.voip.messages.k;
import com.viber.voip.ui.aq;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.j;
import com.viber.voip.util.cj;

public class b extends aq
  implements View.OnClickListener, m.c, a.c
{
  private a.a a;

  public void a()
  {
    ad.a().b(this);
  }

  public void a(int paramInt)
  {
    j.b(paramInt).a(this).b(this);
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.a = new c(ViberApplication.getInstance().getMessagesManager().x().b(), cj.a(getContext().getApplicationContext()), new d(getActivity()));
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
    if (paramView.getId() == R.id.btn_delete_data)
      this.a.b();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.delete_your_data_preference_screen, paramViewGroup, false);
  }

  public void onDestroyView()
  {
    this.a.a();
    super.onDestroyView();
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    if ((paramm.a(DialogCode.D445)) && (-1 == paramInt))
      this.a.c();
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    TextView localTextView = (TextView)paramView.findViewById(R.id.description);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(getString(R.string.gdpr_data_erasure_desciption1));
    localSpannableStringBuilder.append("\n\n");
    localSpannableStringBuilder.append(Html.fromHtml(getResources().getString(R.string.gdpr_data_erasure_desciption2)));
    localTextView.setText(localSpannableStringBuilder);
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramView.findViewById(R.id.btn_delete_data).setOnClickListener(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.personal.delete.b
 * JD-Core Version:    0.6.2
 */