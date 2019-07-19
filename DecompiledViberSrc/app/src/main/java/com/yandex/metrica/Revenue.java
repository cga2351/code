package com.yandex.metrica;

import com.yandex.metrica.impl.ob.ps;
import com.yandex.metrica.impl.ob.pt;
import com.yandex.metrica.impl.ob.px;
import java.util.Currency;

public class Revenue
{
  public final Currency currency;
  public final String payload;
  public final double price;
  public final String productID;
  public final Integer quantity;
  public final Receipt receipt;

  private Revenue(Builder paramBuilder)
  {
    this.price = paramBuilder.a;
    this.currency = paramBuilder.b;
    this.quantity = paramBuilder.c;
    this.productID = paramBuilder.d;
    this.payload = paramBuilder.e;
    this.receipt = paramBuilder.f;
  }

  public static Builder newBuilder(double paramDouble, Currency paramCurrency)
  {
    return new Builder(paramDouble, paramCurrency);
  }

  public static class Builder
  {
    private static final px<Currency> g = new pt(new ps("revenue currency"));
    double a;
    Currency b;
    Integer c;
    String d;
    String e;
    Revenue.Receipt f;

    Builder(double paramDouble, Currency paramCurrency)
    {
      g.a(paramCurrency);
      this.a = paramDouble;
      this.b = paramCurrency;
    }

    public Revenue build()
    {
      return new Revenue(this, (byte)0);
    }

    public Builder withPayload(String paramString)
    {
      this.e = paramString;
      return this;
    }

    public Builder withProductID(String paramString)
    {
      this.d = paramString;
      return this;
    }

    public Builder withQuantity(Integer paramInteger)
    {
      this.c = paramInteger;
      return this;
    }

    public Builder withReceipt(Revenue.Receipt paramReceipt)
    {
      this.f = paramReceipt;
      return this;
    }
  }

  public static class Receipt
  {
    public final String data;
    public final String signature;

    private Receipt(Builder paramBuilder)
    {
      this.data = Builder.a(paramBuilder);
      this.signature = Builder.b(paramBuilder);
    }

    public static Builder newBuilder()
    {
      return new Builder();
    }

    public static class Builder
    {
      private String a;
      private String b;

      public Revenue.Receipt build()
      {
        return new Revenue.Receipt(this, (byte)0);
      }

      public Builder withData(String paramString)
      {
        this.a = paramString;
        return this;
      }

      public Builder withSignature(String paramString)
      {
        this.b = paramString;
        return this;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.Revenue
 * JD-Core Version:    0.6.2
 */