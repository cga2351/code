package com.viber.voip.viberout.ui.products.coupon;

import android.content.Context;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.util.dj;
import com.viber.voip.viberout.ui.RedeemCouponWebActivity;

public class b extends com.viber.voip.mvp.core.d<ViberOutCouponPresenter>
  implements View.OnClickListener, a
{
  private final EditText a;
  private final TextWatcher b = new TextWatcher()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
    }

    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
    }

    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      if (paramAnonymousCharSequence != null)
        ((ViberOutCouponPresenter)b.a(b.this)).a(paramAnonymousCharSequence.toString());
    }
  };

  public b(ViberOutCouponPresenter paramViberOutCouponPresenter, View paramView)
  {
    super(paramViberOutCouponPresenter, paramView);
    this.a = ((EditText)paramView.findViewById(R.id.coupon));
    this.a.addTextChangedListener(this.b);
    this.a.setOnFocusChangeListener(new c(this));
    this.a.setOnClickListener(new d(this));
    paramView.findViewById(R.id.button).setOnClickListener(this);
    TextView localTextView = (TextView)paramView.findViewById(R.id.scan_qr);
    localTextView.setText(Html.fromHtml(paramView.getContext().getString(R.string.vo_scan_qr)));
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
  }

  public void a()
  {
    dj.c(this.a);
  }

  public void a(String paramString)
  {
    RedeemCouponWebActivity.d(paramString);
  }

  public void b(String paramString)
  {
    this.a.setText(paramString);
  }

  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.button)
      ((ViberOutCouponPresenter)this.mPresenter).b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.coupon.b
 * JD-Core Version:    0.6.2
 */