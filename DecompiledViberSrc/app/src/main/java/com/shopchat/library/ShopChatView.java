package com.shopchat.library;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.shopchat.library.a.a;
import java.util.Locale;

public class ShopChatView extends FrameLayout
{
  private RootView a;
  private View b;

  public ShopChatView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public ShopChatView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  public ShopChatView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    inflate(paramContext, R.layout.shop_chat, this);
    this.a = ((RootView)findViewById(R.id.rootView));
    this.b = findViewById(R.id.collapsePanelButton);
  }

  public void a()
  {
    this.a.a();
  }

  public boolean b()
  {
    return this.a.b();
  }

  public View getCollapsePanelButton()
  {
    return this.b;
  }

  public void setCollapsePanelButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.b.setOnClickListener(paramOnClickListener);
  }

  public void setGenericLogger(com.shopchat.library.util.b paramb)
  {
    this.a.setGenericLogger(paramb);
  }

  public void setLocale(Locale paramLocale)
  {
    this.a.setLocale(paramLocale);
  }

  public void setMixpanelListener(a parama)
  {
    this.a.setMixpanelListener(parama);
  }

  public void setServerOverride(RootView.a parama)
  {
    this.a.setServerOverride(parama);
  }

  public void setViberShareListener(b paramb)
  {
    this.a.setViberShareListener(paramb);
  }

  public void setWebViewListener(com.shopchat.library.a.b paramb)
  {
    this.a.setWebViewListener(paramb);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.ShopChatView
 * JD-Core Version:    0.6.2
 */