package com.shopchat.library.mvp.b;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import com.google.d.f;
import com.google.d.g;
import com.shopchat.library.R.id;
import com.shopchat.library.R.layout;
import com.shopchat.library.RootView;
import com.shopchat.library.RootView.a;
import com.shopchat.library.events.BrandClicked;
import com.shopchat.library.events.CategoryClickedEvent;
import com.shopchat.library.events.CategoryScroll;
import com.shopchat.library.events.FirstCategory;
import com.shopchat.library.events.ProductListScroll;
import com.shopchat.library.mvp.a.i;
import com.shopchat.library.mvp.a.p;
import com.shopchat.library.mvp.models.BrandModel;
import com.shopchat.library.mvp.models.BrandModel.Category;
import com.shopchat.library.mvp.models.BrandModel.Link;
import com.shopchat.library.mvp.models.CategoryProductsModel;
import com.shopchat.library.mvp.models.ProductModel;
import com.shopchat.library.util.b;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.greenrobot.eventbus.EventBus;

public class c extends a
{
  private static b f = RootView.a;
  p c;
  i d;
  BrandModel e;
  private RecyclerView g;
  private RecyclerView h;
  private f i = new g().a();
  private Locale j;
  private RootView.a k = null;
  private ProgressBar l;
  private boolean m;
  private boolean n;
  private RecyclerView.OnScrollListener o = new RecyclerView.OnScrollListener()
  {
    public void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
    {
      BrandModel.Category localCategory;
      if ((!c.a(c.this)) && (paramAnonymousInt == 0) && (!c.this.e.getCategories().isEmpty()))
      {
        Iterator localIterator = c.this.e.getCategories().iterator();
        do
        {
          if (!localIterator.hasNext())
            break;
          localCategory = (BrandModel.Category)localIterator.next();
        }
        while (!localCategory.isSelected());
      }
      for (String str = localCategory.getName(); ; str = "")
      {
        com.shopchat.library.util.a.a().post(new ProductListScroll(c.this.e.getName(), str));
        c.a(c.this, true);
        return;
      }
    }
  };
  private RecyclerView.OnScrollListener p = new RecyclerView.OnScrollListener()
  {
    public void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
    {
      if ((!c.b(c.this)) && (paramAnonymousInt == 0))
      {
        com.shopchat.library.util.a.a().post(new CategoryScroll(c.this.e.getName()));
        c.b(c.this, true);
      }
    }
  };

  public c(Context paramContext, BrandModel paramBrandModel, Locale paramLocale, RootView.a parama)
  {
    super(paramContext);
    this.e = paramBrandModel;
    this.j = paramLocale;
    this.k = parama;
  }

  private void a(BrandModel.Category paramCategory)
  {
    for (int i1 = 0; i1 < this.e.getCategories().size(); i1++)
    {
      BrandModel.Category localCategory = (BrandModel.Category)this.e.getCategories().get(i1);
      if (localCategory.getId() != paramCategory.getId())
        localCategory.setSelected(false);
    }
    for (int i2 = 0; i2 < this.g.getChildCount(); i2++)
      if (this.g.getChildAt(i2).getTag() != paramCategory.getId())
        this.g.getChildAt(i2).setSelected(false);
    if (this.h != null)
      this.h.scrollToPosition(0);
    a(paramCategory.getFirstLinkHref(), this.e);
  }

  private void a(final String paramString, final BrandModel paramBrandModel)
  {
    Callback local5 = new Callback()
    {
      public void onFailure(Call paramAnonymousCall, IOException paramAnonymousIOException)
      {
        c.b().a(paramAnonymousIOException, "category products fetch failed", new Object[0]);
      }

      public void onResponse(Call paramAnonymousCall, Response paramAnonymousResponse)
        throws IOException
      {
        if (paramAnonymousResponse.cacheResponse() != null)
        {
          b localb2 = c.b();
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = paramString;
          localb2.a("response cached: getProducts(): ?", arrayOfObject2);
        }
        CategoryProductsModel localCategoryProductsModel = (CategoryProductsModel)c.c(c.this).a(paramAnonymousResponse.body().charStream(), CategoryProductsModel.class);
        if (localCategoryProductsModel != null)
        {
          final List localList = localCategoryProductsModel.getProducts();
          b localb1 = c.b();
          Object[] arrayOfObject1 = new Object[1];
          arrayOfObject1[0] = Integer.valueOf(localList.size());
          localb1.a("category product list count: ?", arrayOfObject1);
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
            ((ProductModel)localIterator.next()).setBrand(paramBrandModel);
          c.this.post(new Runnable()
          {
            public void run()
            {
              c.this.a(localList);
            }
          });
        }
      }
    };
    com.shopchat.library.b.a.a(this.a, this.j.getCountry(), this.k).a(paramString, local5);
  }

  private void c()
  {
    int i1 = 1;
    a();
    if (!this.e.getCategories().isEmpty())
    {
      BrandModel.Category localCategory = (BrandModel.Category)this.e.getCategories().get(0);
      localCategory.setSelected(i1);
      for (int i2 = i1; i2 < this.e.getCategories().size(); i2++)
        ((BrandModel.Category)this.e.getCategories().get(i2)).setSelected(false);
      if ((this.g != null) && (this.g.getChildCount() > 0))
      {
        this.g.getChildAt(0).setSelected(i1);
        while (i1 < this.g.getChildCount())
        {
          this.g.getChildAt(i1).setSelected(false);
          i1++;
        }
      }
      this.g.scrollToPosition(0);
      this.l.setVisibility(0);
      a(((BrandModel.Link)localCategory.getLinks().get(0)).getHref(), this.e);
      String str = ((BrandModel.Link)localCategory.getLinks().get(0)).getHref();
      com.shopchat.library.util.a.a().post(new FirstCategory(str, localCategory.getName(), localCategory.getId(), localCategory.getBrandName()));
    }
  }

  public void a()
  {
    for (int i1 = 0; i1 < this.e.getCategories().size(); i1++)
      ((BrandModel.Category)this.e.getCategories().get(i1)).setSelected(false);
    for (int i2 = 0; i2 < this.g.getChildCount(); i2++)
      this.g.getChildAt(i2).setSelected(false);
  }

  public void a(List<ProductModel> paramList)
  {
    this.l.setVisibility(8);
    if (this.c == null)
    {
      this.c = new p(getContext(), paramList, this.j);
      GridLayoutManager localGridLayoutManager = new GridLayoutManager(getContext(), 2, 1, false);
      this.h = ((RecyclerView)findViewById(R.id.productsList));
      this.h.setLayoutManager(localGridLayoutManager);
      this.h.setAdapter(this.c);
    }
    while (true)
    {
      this.h.addOnScrollListener(this.o);
      return;
      this.c.a(paramList);
      this.c.notifyDataSetChanged();
    }
  }

  public void b(List<BrandModel.Category> paramList)
  {
    if (this.d == null)
      this.d = new i(getContext(), paramList, new com.shopchat.library.mvp.a.a()
      {
        public void a(int paramAnonymousInt, BrandModel.Category paramAnonymousCategory)
        {
          if (!TextUtils.isEmpty(paramAnonymousCategory.getFirstLinkHref()))
          {
            c.this.d.a(paramAnonymousInt);
            c.a(c.this, paramAnonymousCategory);
            com.shopchat.library.util.a.a().post(new CategoryClickedEvent(paramAnonymousCategory, paramAnonymousInt));
          }
        }
      });
    this.g = ((RecyclerView)findViewById(R.id.categoriesList));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
    this.g.setLayoutManager(localLinearLayoutManager);
    this.g.setAdapter(this.d);
    this.g.addOnScrollListener(this.p);
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (com.shopchat.library.b.a.a(this.a))
    {
      this.b = inflate(getContext(), R.layout.categories_list, null);
      addView(this.b);
      List localList = this.e.getCategories();
      b(localList);
      this.l = ((ProgressBar)findViewById(R.id.loadingProgress));
      if (localList.size() > 0)
        c();
      a(findViewById(R.id.toolbar), this.e, null);
      return;
    }
    setupNoNetworkView(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        com.shopchat.library.util.a.a().post(new BrandClicked(c.this.e, c.this.e.getDisplayOrder()));
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
 * Qualified Name:     com.shopchat.library.mvp.b.c
 * JD-Core Version:    0.6.2
 */