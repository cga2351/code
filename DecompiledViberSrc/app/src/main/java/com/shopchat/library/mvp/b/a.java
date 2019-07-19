package com.shopchat.library.mvp.b;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopchat.library.R.id;
import com.shopchat.library.R.layout;
import com.shopchat.library.mvp.models.BrandModel;
import com.shopchat.library.mvp.models.BrandModel.BrandType;
import com.shopchat.library.mvp.models.ColorModel;
import com.shopchat.library.util.d;
import com.viber.common.ui.a.b;

public abstract class a extends FrameLayout
{
  protected final Context a;
  protected View b;

  public a(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
  }

  public void a(View paramView, BrandModel paramBrandModel, View.OnClickListener paramOnClickListener)
  {
    ImageView localImageView1 = (ImageView)paramView.findViewById(R.id.toolbarBrandImage);
    ImageView localImageView2 = (ImageView)paramView.findViewById(R.id.toolbarBrandImageBackground);
    TextView localTextView = (TextView)paramView.findViewById(R.id.toolbarBrandName);
    if (paramBrandModel.getBrandType() == BrandModel.BrandType.NORMAL)
      d.a(getContext()).a(paramBrandModel.getLogo(), localImageView1, null);
    b localb = new b();
    localb.b(paramBrandModel.getBackgroundColor().getColor());
    localImageView2.setBackground(new ShapeDrawable(localb));
    localTextView.setText(paramBrandModel.getName());
    if (paramOnClickListener != null)
    {
      paramView.findViewById(R.id.toolbarBrandImageBackground).setOnClickListener(paramOnClickListener);
      paramView.findViewById(R.id.toolbarBrandName).setOnClickListener(paramOnClickListener);
    }
  }

  protected void setupNoNetworkView(final View.OnClickListener paramOnClickListener)
  {
    final View localView = inflate(this.a, R.layout.no_network, null);
    TextView localTextView = (TextView)localView.findViewById(R.id.noNetworkSubtitle);
    if (TextUtils.isEmpty(localTextView.getText()))
      localTextView.setVisibility(8);
    ((TextView)localView.findViewById(R.id.no_network_refresh_button)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        a.this.removeView(localView);
        paramOnClickListener.onClick(paramAnonymousView);
      }
    });
    addView(localView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.mvp.b.a
 * JD-Core Version:    0.6.2
 */