package org.onepf.oms;

public class SkuMappingException extends IllegalArgumentException
{
  public static final int REASON_SKU = 1;
  public static final int REASON_STORE_NAME = 2;
  public static final int REASON_STORE_SKU = 3;

  public SkuMappingException()
  {
    super("Error while map sku.");
  }

  public SkuMappingException(String paramString)
  {
    super(paramString);
  }

  public static SkuMappingException newInstance(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return new SkuMappingException();
    case 1:
      return new SkuMappingException("Sku can't be null or empty value.");
    case 2:
      return new SkuMappingException("Store name can't be null or empty value.");
    case 3:
    }
    return new SkuMappingException("Store sku can't be null or empty value.");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.onepf.oms.SkuMappingException
 * JD-Core Version:    0.6.2
 */