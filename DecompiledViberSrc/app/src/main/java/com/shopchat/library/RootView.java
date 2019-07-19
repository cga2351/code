package com.shopchat.library;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.shopchat.library.events.BrandClicked;
import com.shopchat.library.events.BrandsHttpFailure;
import com.shopchat.library.events.BrandsScroll;
import com.shopchat.library.events.CategoryClickedEvent;
import com.shopchat.library.events.CategoryScroll;
import com.shopchat.library.events.FirstCategory;
import com.shopchat.library.events.LoadBrands;
import com.shopchat.library.events.ProductBuyEvent;
import com.shopchat.library.events.ProductChanged;
import com.shopchat.library.events.ProductClicked;
import com.shopchat.library.events.ProductListScroll;
import com.shopchat.library.events.ProductOpenNative;
import com.shopchat.library.events.ProductToolbarClicked;
import com.shopchat.library.events.RecommendedHttpFailure;
import com.shopchat.library.events.RecommendedProductChanged;
import com.shopchat.library.events.RecommendedProductClicked;
import com.shopchat.library.events.RecommendedProductScroll;
import com.shopchat.library.events.RecommendedProductToolbarClicked;
import com.shopchat.library.events.ShareClickedEvent;
import com.shopchat.library.events.SwipeDirection;
import com.shopchat.library.mvp.b.d;
import com.shopchat.library.mvp.models.BrandModel;
import com.shopchat.library.mvp.models.BrandModel.Category;
import com.shopchat.library.mvp.models.ProductModel;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class RootView extends FrameLayout
{
  public static com.shopchat.library.util.b a = new com.shopchat.library.util.c();
  private LinkedList<View> b = new LinkedList();
  private com.shopchat.library.mvp.b.b c;
  private Context d;
  private com.shopchat.library.a.b e;
  private b f;
  private Locale g = new Locale("en", "US");
  private a h = new a();
  private a i;

  public RootView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public RootView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    this.d = paramContext;
  }

  private void a(View paramView)
  {
    b(paramView);
    View localView = paramView.findViewById(R.id.toolbarBack);
    if (localView != null)
      localView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          RootView.this.b();
        }
      });
  }

  private void a(BrandModel paramBrandModel)
  {
    a(new com.shopchat.library.mvp.b.c(this.d, paramBrandModel, this.g, this.i));
  }

  private void a(List<ProductModel> paramList, int paramInt, boolean paramBoolean)
  {
    a(new d(this.d, this.g, paramList, paramInt, paramBoolean));
  }

  private void b(View paramView)
  {
    View localView;
    if (!this.b.isEmpty())
    {
      localView = (View)this.b.peek();
      if (!localView.getClass().equals(paramView.getClass()))
        break label63;
      removeView((View)this.b.pop());
    }
    while (true)
    {
      this.b.push(paramView);
      addView(paramView);
      return;
      label63: localView.setVisibility(4);
    }
  }

  private void c()
  {
    com.shopchat.library.mvp.b.b localb = new com.shopchat.library.mvp.b.b(this.d, this.g, this.i);
    setBrandsView(localb);
    a(localb);
  }

  public void a()
  {
    if (this.i != null)
      a.a("server override: " + this.i.name(), new Object[0]);
    while (true)
    {
      c();
      return;
      a.a("server override: NULL", new Object[0]);
    }
  }

  public void a(String paramString1, String paramString2)
  {
    if (this.e != null)
      this.e.a(paramString1, paramString2);
  }

  public boolean b()
  {
    if (this.b.size() > 1)
    {
      View localView1 = (View)this.b.pop();
      removeView(localView1);
      View localView2 = (View)this.b.peek();
      localView2.setVisibility(0);
      if (((localView1 instanceof com.shopchat.library.mvp.b.c)) && ((localView2 instanceof com.shopchat.library.mvp.b.b)))
        this.h.g();
      while (true)
      {
        return true;
        if (((localView1 instanceof com.shopchat.library.mvp.b.c)) && ((localView2 instanceof d)))
        {
          if (((d)localView2).a())
            this.h.c();
          else
            this.h.d();
        }
        else if (((localView1 instanceof d)) && (((d)localView1).a()) && ((localView2 instanceof com.shopchat.library.mvp.b.b)))
          this.h.f();
        else if (((localView1 instanceof d)) && ((localView2 instanceof com.shopchat.library.mvp.b.c)))
          this.h.e();
      }
    }
    return false;
  }

  public com.shopchat.library.mvp.b.b getBrandsView()
  {
    return this.c;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    com.shopchat.library.util.a.a().register(this);
  }

  @Subscribe
  public void onBrandClicked(BrandClicked paramBrandClicked)
  {
    BrandModel localBrandModel = paramBrandClicked.getBrandsModel();
    int j = paramBrandClicked.getPosition();
    a(localBrandModel);
    this.h.a(localBrandModel, j);
  }

  @Subscribe
  public void onBrandsHttpFailure(BrandsHttpFailure paramBrandsHttpFailure)
  {
    a.a(paramBrandsHttpFailure.getCause(), paramBrandsHttpFailure.getCause().getMessage(), new Object[0]);
  }

  @Subscribe
  public void onBrandsScroll(BrandsScroll paramBrandsScroll)
  {
    this.h.b();
  }

  @Subscribe
  public void onCategoryClicked(CategoryClickedEvent paramCategoryClickedEvent)
  {
    BrandModel.Category localCategory = paramCategoryClickedEvent.category;
    int j = paramCategoryClickedEvent.position;
    this.h.a(localCategory, j);
  }

  @Subscribe
  public void onCategoryScroll(CategoryScroll paramCategoryScroll)
  {
    this.h.a(paramCategoryScroll);
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    com.shopchat.library.util.a.a().unregister(this);
  }

  @Subscribe
  public void onFirstCategory(FirstCategory paramFirstCategory)
  {
  }

  @Subscribe
  public void onLoadBrands(LoadBrands paramLoadBrands)
  {
    a();
  }

  @Subscribe
  public void onProductBuy(ProductBuyEvent paramProductBuyEvent)
  {
    ProductModel localProductModel = paramProductBuyEvent.product;
    boolean bool = paramProductBuyEvent.isRecommendedProduct;
    this.h.a(localProductModel, bool);
  }

  @Subscribe
  public void onProductChanged(ProductChanged paramProductChanged)
  {
    ProductModel localProductModel = paramProductChanged.getProduct();
    SwipeDirection localSwipeDirection = paramProductChanged.getSwipeDirection();
    int j = paramProductChanged.getPosition();
    this.h.a(localProductModel, j, localSwipeDirection);
  }

  @Subscribe
  public void onProductClicked(ProductClicked paramProductClicked)
  {
    ProductModel localProductModel = paramProductClicked.getProductModel();
    int j = paramProductClicked.position;
    a(paramProductClicked.items, j, false);
    this.h.b(localProductModel, j);
  }

  @Subscribe
  public void onProductListScroll(ProductListScroll paramProductListScroll)
  {
    this.h.a(paramProductListScroll);
  }

  @Subscribe
  public void onProductOpenNative(ProductOpenNative paramProductOpenNative)
  {
    ProductModel localProductModel = paramProductOpenNative.getProductModel();
    a(localProductModel.getUrl(), localProductModel.getTitle());
  }

  @Subscribe
  public void onProductToolbarClicked(ProductToolbarClicked paramProductToolbarClicked)
  {
    ProductModel localProductModel = paramProductToolbarClicked.product;
    int j = paramProductToolbarClicked.position;
    a(localProductModel.getBrand());
    this.h.a(localProductModel, j, false);
  }

  @Subscribe
  public void onRecommendedHttpFailure(RecommendedHttpFailure paramRecommendedHttpFailure)
  {
    a.a(paramRecommendedHttpFailure.getCause(), paramRecommendedHttpFailure.getCause().getMessage(), new Object[0]);
  }

  @Subscribe
  public void onRecommendedProductChanged(RecommendedProductChanged paramRecommendedProductChanged)
  {
    ProductModel localProductModel = paramRecommendedProductChanged.getProduct();
    int j = paramRecommendedProductChanged.getPosition();
    SwipeDirection localSwipeDirection = paramRecommendedProductChanged.getSwipeDirection();
    this.h.b(localProductModel, j, localSwipeDirection);
  }

  @Subscribe
  public void onRecommendedProductClicked(RecommendedProductClicked paramRecommendedProductClicked)
  {
    ProductModel localProductModel = paramRecommendedProductClicked.getProductModel();
    int j = paramRecommendedProductClicked.getPosition();
    a(paramRecommendedProductClicked.items, paramRecommendedProductClicked.position, true);
    this.h.a(localProductModel, j);
  }

  @Subscribe
  public void onRecommendedProductScrolled(RecommendedProductScroll paramRecommendedProductScroll)
  {
    this.h.a();
  }

  @Subscribe
  public void onRecommendedProductToolbarClicked(RecommendedProductToolbarClicked paramRecommendedProductToolbarClicked)
  {
    ProductModel localProductModel = paramRecommendedProductToolbarClicked.product;
    int j = paramRecommendedProductToolbarClicked.position;
    Iterator localIterator = getBrandsView().getLoadedBrands().iterator();
    BrandModel localBrandModel;
    do
    {
      if (!localIterator.hasNext())
        break;
      localBrandModel = (BrandModel)localIterator.next();
    }
    while (!localBrandModel.getId().equalsIgnoreCase(localProductModel.getBrand().getId()));
    for (List localList = localBrandModel.getCategories(); ; localList = null)
    {
      if ((localList == null) || (localList.isEmpty()))
      {
        com.shopchat.library.util.b localb = a;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = localProductModel.getBrand().getName();
        localb.b("onRecommendedProductToolbarClicked: categories not found for brand=\"?\"", arrayOfObject);
        return;
      }
      localProductModel.getBrand().setCategories(localList);
      a(localProductModel.getBrand());
      this.h.a(localProductModel, j, true);
      return;
    }
  }

  @Subscribe
  public void onShareClicked(ShareClickedEvent paramShareClickedEvent)
  {
    if (this.f != null)
    {
      ProductModel localProductModel = paramShareClickedEvent.product;
      boolean bool = paramShareClickedEvent.isRecommendedProduct;
      this.f.a(localProductModel.getProductId());
      this.h.b(localProductModel, bool);
      return;
    }
    a.c("Share Listener is NULL -- sharing broken!", new Object[0]);
  }

  public void setBrandsView(com.shopchat.library.mvp.b.b paramb)
  {
    this.c = paramb;
  }

  public void setGenericLogger(com.shopchat.library.util.b paramb)
  {
    a = paramb;
  }

  public void setLocale(Locale paramLocale)
  {
    this.g = paramLocale;
  }

  public void setMixpanelListener(com.shopchat.library.a.a parama)
  {
    this.h.a(parama);
  }

  public void setServerOverride(a parama)
  {
    this.i = parama;
  }

  public void setViberShareListener(b paramb)
  {
    this.f = paramb;
  }

  public void setWebViewListener(com.shopchat.library.a.b paramb)
  {
    this.e = paramb;
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[2];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.RootView
 * JD-Core Version:    0.6.2
 */