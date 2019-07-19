package com.viber.voip.messages.ui.d.b;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.CharacterStyle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.util.da;

public class h extends b<g>
{
  private View j;
  private TextView k;
  private CharacterStyle l;
  private CharSequence m;

  public h(Context paramContext)
  {
    super(paramContext);
  }

  private void c()
  {
    if (this.h != null)
      ((g)this.h).c();
  }

  private void d()
  {
    if (this.h != null)
      ((g)this.h).b();
  }

  protected void a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater.inflate(R.layout.sticker_package_redownload_preview, this);
  }

  protected void b()
  {
    super.b();
    this.j = findViewById(R.id.remove_button);
    this.j.setOnClickListener(new i(this));
    this.k = ((TextView)findViewById(R.id.download_all_button));
    this.k.setOnClickListener(new j(this));
    this.m = getResources().getString(R.string.sticker_packs_redownload);
    this.l = new AbsoluteSizeSpan(getResources().getDimensionPixelSize(R.dimen.sticker_package_redownload_size_text_size));
  }

  public void setActionsEnabled(boolean paramBoolean)
  {
    this.i.setEnabled(paramBoolean);
    this.j.setEnabled(paramBoolean);
    this.k.setEnabled(paramBoolean);
  }

  public void setWeight(String paramString)
  {
    if (!da.a(paramString))
    {
      String str = "(" + paramString + ")";
      SpannableString localSpannableString = new SpannableString(this.m + " " + str);
      localSpannableString.setSpan(this.l, localSpannableString.length() - str.length(), localSpannableString.length(), 17);
      this.i.setText(localSpannableString);
      return;
    }
    this.i.setText(this.m);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.d.b.h
 * JD-Core Version:    0.6.2
 */