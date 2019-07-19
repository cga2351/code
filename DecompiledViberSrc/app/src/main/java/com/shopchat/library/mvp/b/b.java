package com.shopchat.library.mvp.b;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.d.g;
import com.shopchat.library.R.id;
import com.shopchat.library.R.layout;
import com.shopchat.library.RootView;
import com.shopchat.library.RootView.a;
import com.shopchat.library.events.BrandsHttpFailure;
import com.shopchat.library.events.BrandsScroll;
import com.shopchat.library.events.LoadBrands;
import com.shopchat.library.events.RecommendedHttpFailure;
import com.shopchat.library.events.RecommendedProductScroll;
import com.shopchat.library.mvp.a.q;
import com.shopchat.library.mvp.models.BrandModel;
import com.shopchat.library.mvp.models.BrandModel.Category;
import com.shopchat.library.mvp.models.ProductModel;
import com.shopchat.library.mvp.models.RecommendedProductsModel;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.greenrobot.eventbus.EventBus;

public class b extends a
{
  private static com.shopchat.library.util.b c = RootView.a;
  private RecyclerView d;
  private com.shopchat.library.mvp.a.f e;
  private RecyclerView f;
  private q g;
  private ProgressBar h;
  private com.google.d.f i = new g().a();
  private final Locale j;
  private final RootView.a k;
  private List<BrandModel> l;
  private List<ProductModel> m;
  private boolean n;
  private boolean o;
  private RecyclerView.OnScrollListener p = new RecyclerView.OnScrollListener()
  {
    public void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
    {
      if ((!b.b(b.this)) && (paramAnonymousInt == 0))
      {
        com.shopchat.library.util.a.a().post(new RecommendedProductScroll());
        b.a(b.this, true);
      }
    }
  };
  private RecyclerView.OnScrollListener q = new RecyclerView.OnScrollListener()
  {
    public void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
    {
      if ((!b.c(b.this)) && (paramAnonymousInt == 0))
      {
        com.shopchat.library.util.a.a().post(new BrandsScroll());
        b.b(b.this, true);
      }
    }
  };

  public b(Context paramContext, Locale paramLocale, RootView.a parama)
  {
    super(paramContext);
    this.j = paramLocale;
    this.k = parama;
  }

  private void a(List<ProductModel> paramList)
  {
    this.f = ((RecyclerView)findViewById(R.id.recommendedList));
    if (this.g == null)
      this.g = new q(this.a, paramList, this.j);
    this.f.setAdapter(this.g);
    GridLayoutManager localGridLayoutManager = new GridLayoutManager(getContext(), 2, 1, false);
    localGridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup()
    {
      public int getSpanSize(int paramAnonymousInt)
      {
        return b.a(b.this).a(2, paramAnonymousInt);
      }
    });
    this.f.setLayoutManager(localGridLayoutManager);
    this.f.setVisibility(0);
    this.f.addOnScrollListener(this.p);
  }

  private void b()
  {
    if ((this.l == null) || (this.m == null))
      return;
    c();
    b(this.l);
    a(this.m);
  }

  private void b(List<BrandModel> paramList)
  {
    ((TextView)findViewById(R.id.brandsTitle)).setVisibility(0);
    this.d = ((RecyclerView)findViewById(R.id.brandsList));
    if (this.e == null)
      this.e = new com.shopchat.library.mvp.a.f(getContext(), paramList);
    this.d.setAdapter(this.e);
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
    this.d.setLayoutManager(localLinearLayoutManager);
    this.d.setVisibility(0);
    this.d.addOnScrollListener(this.q);
  }

  private void c()
  {
    this.h.setVisibility(8);
  }

  private void getBrands()
  {
    Callback local5 = new Callback()
    {
      public void onFailure(Call paramAnonymousCall, IOException paramAnonymousIOException)
      {
        b.a().a(paramAnonymousIOException, "brands fetch failed", new Object[0]);
        com.shopchat.library.util.a.a().post(new BrandsHttpFailure(paramAnonymousIOException));
      }

      public void onResponse(Call paramAnonymousCall, Response paramAnonymousResponse)
        throws IOException
      {
        if (paramAnonymousResponse.cacheResponse() != null)
          b.a().a("response cached: getBrands()", new Object[0]);
        int i = paramAnonymousResponse.code();
        if (i != 200)
        {
          final com.shopchat.library.b.b localb1 = new com.shopchat.library.b.b(i, paramAnonymousResponse.body().string());
          b.this.post(new Runnable()
          {
            public void run()
            {
              com.shopchat.library.util.a.a().post(new BrandsHttpFailure(localb1));
            }
          });
        }
        final List localList;
        while (true)
        {
          return;
          Type localType = new com.google.d.c.a()
          {
          }
          .getType();
          try
          {
            localList = (List)b.d(b.this).a(paramAnonymousResponse.body().charStream(), localType);
            if (localList != null)
            {
              Iterator localIterator1 = localList.iterator();
              while (localIterator1.hasNext())
              {
                BrandModel localBrandModel = (BrandModel)localIterator1.next();
                Iterator localIterator2 = localBrandModel.getCategories().iterator();
                while (localIterator2.hasNext())
                  ((BrandModel.Category)localIterator2.next()).setBrandName(localBrandModel.getName());
              }
            }
          }
          catch (Exception localException)
          {
            final com.shopchat.library.b.b localb2 = new com.shopchat.library.b.b(500, "potential socket timeout exception");
            b.this.post(new Runnable()
            {
              public void run()
              {
                com.shopchat.library.util.a.a().post(new RecommendedHttpFailure(localb2));
              }
            });
            return;
          }
        }
        b.this.post(new Runnable()
        {
          public void run()
          {
            b.a(b.this, localList);
            b.e(b.this);
          }
        });
      }
    };
    com.shopchat.library.b.a.a(this.a, this.j.getCountry(), this.k).a(local5);
  }

  private void getRecommends()
  {
    Callback local6 = new Callback()
    {
      public void onFailure(Call paramAnonymousCall, IOException paramAnonymousIOException)
      {
        b.a().a(paramAnonymousIOException, "recommended products fetch failed", new Object[0]);
        com.shopchat.library.util.a.a().post(new RecommendedHttpFailure(paramAnonymousIOException));
      }

      public void onResponse(Call paramAnonymousCall, Response paramAnonymousResponse)
        throws IOException
      {
        if (paramAnonymousResponse.cacheResponse() != null)
          b.a().a("response cached: recommendFeed", new Object[0]);
        int i = paramAnonymousResponse.code();
        if (i != 200)
        {
          final com.shopchat.library.b.b localb1 = new com.shopchat.library.b.b(i, paramAnonymousResponse.body().string());
          b.this.post(new Runnable()
          {
            public void run()
            {
              com.shopchat.library.util.a.a().post(new RecommendedHttpFailure(localb1));
            }
          });
          return;
        }
        try
        {
          final RecommendedProductsModel localRecommendedProductsModel = (RecommendedProductsModel)b.d(b.this).a(paramAnonymousResponse.body().charStream(), RecommendedProductsModel.class);
          b.this.post(new Runnable()
          {
            public void run()
            {
              Object localObject = localRecommendedProductsModel.getProducts();
              b localb = b.this;
              if (localObject != null);
              while (true)
              {
                b.b(localb, (List)localObject);
                b.e(b.this);
                return;
                localObject = new ArrayList();
              }
            }
          });
          return;
        }
        catch (Exception localException)
        {
          final com.shopchat.library.b.b localb2 = new com.shopchat.library.b.b(500, "potential socket timeout exception");
          b.this.post(new Runnable()
          {
            public void run()
            {
              com.shopchat.library.util.a.a().post(new RecommendedHttpFailure(localb2));
            }
          });
        }
      }
    };
    com.shopchat.library.b.a.a(this.a, this.j.getCountry(), this.k).b(local6);
  }

  public List<BrandModel> getLoadedBrands()
  {
    return this.l;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (com.shopchat.library.b.a.a(this.a))
    {
      this.b = inflate(this.a, R.layout.brands_list, null);
      addView(this.b);
      this.h = ((ProgressBar)findViewById(R.id.loadingProgress));
      getBrands();
      getRecommends();
      return;
    }
    setupNoNetworkView(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        com.shopchat.library.util.a.a().post(new LoadBrands());
      }
    });
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    com.shopchat.library.util.a.a().unregister(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.mvp.b.b
 * JD-Core Version:    0.6.2
 */