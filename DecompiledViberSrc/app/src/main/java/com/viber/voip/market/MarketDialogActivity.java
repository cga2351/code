package com.viber.voip.market;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import com.viber.voip.R.color;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ui.n;
import com.viber.voip.ui.style.NoUnderlineSpan;
import com.viber.voip.widget.ViberWebView;

public abstract class MarketDialogActivity extends ViberWebApiActivity
  implements View.OnClickListener
{
  protected View a;
  protected View b;
  protected TextView c;

  protected WebViewClient a(Runnable paramRunnable)
  {
    // Byte code:
    //   0: new 18	com/viber/voip/market/MarketDialogActivity$3
    //   3: dup
    //   4: aload_0
    //   5: aload_1
    //   6: invokespecial 21	com/viber/voip/market/MarketDialogActivity$3:<init>	(Lcom/viber/voip/market/MarketDialogActivity;Ljava/lang/Runnable;)V
    //   9: areturn
  }

  protected void a()
  {
    this.a = findViewById(R.id.back_button);
    this.b = findViewById(R.id.close_button);
    this.c = ((TextView)findViewById(R.id.title));
    this.h.f.setVisibility(8);
    this.h.c.setVisibility(0);
    String str1 = getString(R.string.market_error_check_internet_try);
    String str2 = getString(R.string.market_error_check_internet_placeholder, new Object[] { str1 });
    int i = str2.indexOf(str1);
    int j = str2.length();
    SpannableString localSpannableString = new SpannableString(str2);
    localSpannableString.setSpan(new ClickableSpan()
    {
      public void onClick(View paramAnonymousView)
      {
        MarketDialogActivity.this.p();
        MarketDialogActivity.this.b();
      }
    }
    , i, j, 33);
    localSpannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.main_pressed)), i, j, 33);
    localSpannableString.setSpan(new NoUnderlineSpan(), i, j, 33);
    this.h.c.setText(localSpannableString);
    this.h.c.setMovementMethod(LinkMovementMethod.getInstance());
    if (this.a != null)
      this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
  }

  protected void a(boolean paramBoolean)
  {
    int i = 4;
    View localView;
    if (this.a != null)
    {
      localView = this.a;
      if ((paramBoolean) && (this.h.a.getVisibility() != 0))
        break label37;
    }
    while (true)
    {
      localView.setVisibility(i);
      return;
      label37: i = 0;
    }
  }

  protected int e()
  {
    return R.layout.market_dialog_layout;
  }

  public void e_(final String paramString)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        MarketDialogActivity.this.c.setText(paramString);
      }
    });
  }

  public void g()
  {
    finish();
  }

  protected void h()
  {
    if (!com.viber.common.d.a.m())
      com.viber.voip.n.a.c(this);
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.back_button)
    {
      this.f.goBack();
      if (!this.f.canGoBack())
        a(false);
    }
    while (i != R.id.close_button)
      return;
    s_();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.i = false;
    a();
    e_(d());
  }

  protected void s_()
  {
    finish();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.MarketDialogActivity
 * JD-Core Version:    0.6.2
 */