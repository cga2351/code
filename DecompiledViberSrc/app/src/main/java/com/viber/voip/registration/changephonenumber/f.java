package com.viber.voip.registration.changephonenumber;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.c;
import com.viber.voip.R.color;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.settings.ui.BackupSettingsActivity;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.t;
import javax.inject.Inject;

public class f extends a
  implements View.OnClickListener, m.c
{

  @Inject
  dagger.a<com.viber.voip.analytics.story.g.a> c;

  private CharSequence a(int paramInt1, final int paramInt2)
  {
    int i = 0;
    Spanned localSpanned = Html.fromHtml(getString(paramInt1));
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(localSpanned);
    URLSpan[] arrayOfURLSpan = (URLSpan[])localSpannableStringBuilder.getSpans(0, localSpanned.length(), URLSpan.class);
    int j = arrayOfURLSpan.length;
    while (i < j)
    {
      final URLSpan localURLSpan = arrayOfURLSpan[i];
      int k = localSpannableStringBuilder.getSpanStart(localURLSpan);
      int m = localSpannableStringBuilder.getSpanEnd(localURLSpan);
      int n = localSpannableStringBuilder.getSpanFlags(localURLSpan);
      localSpannableStringBuilder.setSpan(new ClickableSpan()
      {
        public void onClick(View paramAnonymousView)
        {
          ((com.viber.voip.analytics.story.g.a)f.this.c.get()).b("Backup");
          Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(localURLSpan.getURL()));
          f.this.startActivity(localIntent);
        }

        public void updateDrawState(TextPaint paramAnonymousTextPaint)
        {
          paramAnonymousTextPaint.setColor(f.this.getResources().getColor(paramInt2));
          paramAnonymousTextPaint.setUnderlineText(true);
        }
      }
      , k, m, n);
      localSpannableStringBuilder.removeSpan(localURLSpan);
      i++;
    }
    return localSpannableStringBuilder;
  }

  private void a(a parama)
  {
    t.n().a(this).a(parama).a(getChildFragmentManager());
  }

  private void b(a parama)
  {
    if (parama == null)
      return;
    switch (2.a[parama.ordinal()])
    {
    default:
      return;
    case 1:
      this.b.a(a.b.b);
      return;
    case 2:
    }
    Intent localIntent = new Intent(getActivity(), BackupSettingsActivity.class);
    localIntent.putExtra("show_restore", false);
    startActivityForResult(localIntent, 201);
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (201 == paramInt1)
      this.b.a(a.b.b);
  }

  public void onAttach(Activity paramActivity)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramActivity);
  }

  public boolean onBackPressed()
  {
    ((com.viber.voip.analytics.story.g.a)this.c.get()).b("Back");
    return super.onBackPressed();
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.continue_btn)
    {
      a(a.b);
      ((com.viber.voip.analytics.story.g.a)this.c.get()).b("New phone number");
    }
    while (i != R.id.continue2_btn)
      return;
    a(a.a);
    ((com.viber.voip.analytics.story.g.a)this.c.get()).b("New phone number and device");
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.fragment_change_phone_number_explanation, paramViewGroup, false);
    TextView localTextView1 = (TextView)localView.findViewById(R.id.new_device_msg);
    localTextView1.setText(a(R.string.change_phone_number_new_device_msg, R.color.link_text));
    localTextView1.setMovementMethod(LinkMovementMethod.getInstance());
    TextView localTextView2 = (TextView)localView.findViewById(R.id.need_help_text);
    localTextView2.setText(a(R.string.change_phone_number_new_faq, R.color.weak_text));
    localTextView2.setMovementMethod(LinkMovementMethod.getInstance());
    localView.findViewById(R.id.continue_btn).setOnClickListener(this);
    localView.findViewById(R.id.continue2_btn).setOnClickListener(this);
    return localView;
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    Object localObject;
    if ((paramm.c() == DialogCode.D3009) && (-1 == paramInt))
    {
      localObject = paramm.d();
      if ((localObject == null) || (!(localObject instanceof a)))
        break label44;
    }
    label44: for (a locala = (a)localObject; ; locala = null)
    {
      b(locala);
      return;
    }
  }

  private static enum a
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
 * Qualified Name:     com.viber.voip.registration.changephonenumber.f
 * JD-Core Version:    0.6.2
 */