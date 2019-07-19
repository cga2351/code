package com.shopchat.library.mvp.b;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.SnapHelper;
import android.view.View;
import android.view.View.OnClickListener;
import com.shopchat.library.R.id;
import com.shopchat.library.R.layout;
import com.shopchat.library.events.ProductBuyEvent;
import com.shopchat.library.events.ProductChanged;
import com.shopchat.library.events.ProductClicked;
import com.shopchat.library.events.ProductOpenNative;
import com.shopchat.library.events.ProductToolbarClicked;
import com.shopchat.library.events.RecommendedProductChanged;
import com.shopchat.library.events.RecommendedProductClicked;
import com.shopchat.library.events.RecommendedProductToolbarClicked;
import com.shopchat.library.events.ShareClickedEvent;
import com.shopchat.library.events.SwipeDirection;
import com.shopchat.library.mvp.a.j;
import com.shopchat.library.mvp.a.m;
import com.shopchat.library.mvp.models.ProductModel;
import java.util.List;
import java.util.Locale;
import org.greenrobot.eventbus.EventBus;

public class d extends a
{
  private RecyclerView c;
  private m d;
  private List<ProductModel> e;
  private int f;
  private final boolean g;
  private Locale h;
  private SwipeDirection i;

  public d(Context paramContext, Locale paramLocale, List<ProductModel> paramList, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    this.h = paramLocale;
    this.e = paramList;
    this.f = paramInt;
    this.g = paramBoolean;
  }

  private void a(final ProductModel paramProductModel, final int paramInt)
  {
    a(findViewById(R.id.toolbar), paramProductModel.getBrand(), new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (d.a(d.this))
        {
          d.a(d.this, new RecommendedProductToolbarClicked(paramProductModel, paramInt));
          return;
        }
        d.a(d.this, new ProductToolbarClicked(paramProductModel, paramInt));
      }
    });
  }

  private void a(Object paramObject)
  {
    com.shopchat.library.util.a.a().post(paramObject);
  }

  private void b()
  {
    if (this.d == null)
    {
      this.d = new m(getContext(), this.h, this.e, new j()
      {
        public void a(int paramAnonymousInt, ProductModel paramAnonymousProductModel)
        {
        }

        public void a(ProductModel paramAnonymousProductModel)
        {
          d.a(d.this, new ShareClickedEvent(paramAnonymousProductModel, d.a(d.this)));
        }

        public void b(ProductModel paramAnonymousProductModel)
        {
          ProductBuyEvent localProductBuyEvent = new ProductBuyEvent(paramAnonymousProductModel, d.a(d.this));
          d.a(d.this, localProductBuyEvent);
          ProductOpenNative localProductOpenNative = new ProductOpenNative(paramAnonymousProductModel);
          d.a(d.this, localProductOpenNative);
        }
      });
      final LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
      this.c.setLayoutManager(localLinearLayoutManager);
      new PagerSnapHelper().attachToRecyclerView(this.c);
      this.c.setAdapter(this.d);
      this.c.addOnScrollListener(new RecyclerView.OnScrollListener()
      {
        public void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          int i;
          if (paramAnonymousInt == 0)
          {
            i = localLinearLayoutManager.findFirstCompletelyVisibleItemPosition();
            if (i != -1);
          }
          else
          {
            return;
          }
          if (i == 0)
            d.e(d.this).scrollToPosition(d.d(d.this).b(-1 + d.b(d.this).size()));
          ProductModel localProductModel;
          while (true)
          {
            int j = d.d(d.this).a(i);
            if (d.c(d.this) == j)
              break;
            d.a(d.this, j);
            localProductModel = d.f(d.this);
            if (!d.a(d.this))
              break label201;
            d.a(d.this, localProductModel, d.c(d.this));
            d.a(d.this, new RecommendedProductChanged(localProductModel, d.c(d.this), d.g(d.this)));
            return;
            if ((i > 0) && (i == -1 + d.d(d.this).getItemCount()))
              d.e(d.this).scrollToPosition(d.d(d.this).b(0));
          }
          label201: d.a(d.this, new ProductChanged(localProductModel, d.g(d.this), d.c(d.this)));
        }

        public void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          if (paramAnonymousInt1 > 0)
          {
            d.a(d.this, SwipeDirection.NEXT);
            return;
          }
          d.a(d.this, SwipeDirection.PREVIOUS);
        }
      });
    }
    int j = this.d.b(this.f);
    this.c.scrollToPosition(j);
  }

  private ProductModel getProduct()
  {
    return (ProductModel)this.e.get(this.f);
  }

  public boolean a()
  {
    return this.g;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (com.shopchat.library.b.a.a(this.a))
    {
      this.b = inflate(getContext(), R.layout.products_list, null);
      addView(this.b);
      this.c = ((RecyclerView)findViewById(R.id.productDetailsList));
      b();
      a(getProduct(), this.f);
      return;
    }
    setupNoNetworkView(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (d.a(d.this))
        {
          d.a(d.this, new RecommendedProductClicked(d.b(d.this), d.c(d.this)));
          return;
        }
        d.a(d.this, new ProductClicked(d.b(d.this), d.c(d.this)));
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.mvp.b.d
 * JD-Core Version:    0.6.2
 */