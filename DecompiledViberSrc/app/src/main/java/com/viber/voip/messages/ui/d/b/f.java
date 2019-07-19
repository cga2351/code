package com.viber.voip.messages.ui.d.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;

public class f extends b<e>
{
  private TextView j;

  public f(Context paramContext)
  {
    super(paramContext);
  }

  protected void a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater.inflate(R.layout.sticker_package_promo_preview, this);
  }

  protected void b()
  {
    super.b();
    this.j = ((TextView)findViewById(R.id.weight));
  }

  public void setWeight(String paramString)
  {
    TextView localTextView = this.j;
    if (!da.a(paramString));
    for (boolean bool = true; ; bool = false)
    {
      dj.b(localTextView, bool);
      this.j.setText(paramString);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.d.b.f
 * JD-Core Version:    0.6.2
 */