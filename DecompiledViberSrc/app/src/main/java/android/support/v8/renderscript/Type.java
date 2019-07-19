package android.support.v8.renderscript;

public class Type extends BaseObj
{
  boolean mDimFaces;
  boolean mDimMipmaps;
  int mDimX;
  int mDimY;
  int mDimYuv;
  int mDimZ;
  Element mElement;
  int mElementCount;

  Type(long paramLong, RenderScript paramRenderScript)
  {
    super(paramLong, paramRenderScript);
  }

  public static Type createX(RenderScript paramRenderScript, Element paramElement, int paramInt)
  {
    if (paramInt < 1)
      throw new RSInvalidStateException("Dimension must be >= 1.");
    Type localType = new Type(paramRenderScript.nTypeCreate(paramElement.getID(paramRenderScript), paramInt, 0, 0, false, false, 0), paramRenderScript);
    localType.mElement = paramElement;
    localType.mDimX = paramInt;
    localType.calcElementCount();
    return localType;
  }

  public static Type createXY(RenderScript paramRenderScript, Element paramElement, int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 1) || (paramInt2 < 1))
      throw new RSInvalidStateException("Dimension must be >= 1.");
    Type localType = new Type(paramRenderScript.nTypeCreate(paramElement.getID(paramRenderScript), paramInt1, paramInt2, 0, false, false, 0), paramRenderScript);
    localType.mElement = paramElement;
    localType.mDimX = paramInt1;
    localType.mDimY = paramInt2;
    localType.calcElementCount();
    return localType;
  }

  public static Type createXYZ(RenderScript paramRenderScript, Element paramElement, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 < 1) || (paramInt2 < 1) || (paramInt3 < 1))
      throw new RSInvalidStateException("Dimension must be >= 1.");
    Type localType = new Type(paramRenderScript.nTypeCreate(paramElement.getID(paramRenderScript), paramInt1, paramInt2, paramInt3, false, false, 0), paramRenderScript);
    localType.mElement = paramElement;
    localType.mDimX = paramInt1;
    localType.mDimY = paramInt2;
    localType.mDimZ = paramInt3;
    localType.calcElementCount();
    return localType;
  }

  void calcElementCount()
  {
    boolean bool = hasMipmaps();
    int i = getX();
    int j = getY();
    int k = getZ();
    if (hasFaces());
    for (int m = 6; ; m = 1)
    {
      if (i == 0)
        i = 1;
      if (j == 0)
        j = 1;
      if (k == 0)
        k = 1;
      int n = m * (k * (i * j));
      int i1 = j;
      int i2 = i;
      int i3 = n;
      while ((bool) && ((i2 > 1) || (i1 > 1) || (k > 1)))
      {
        if (i2 > 1)
          i2 >>= 1;
        if (i1 > 1)
          i1 >>= 1;
        if (k > 1)
          k >>= 1;
        i3 += m * (k * (i2 * i1));
      }
      this.mElementCount = i3;
      return;
    }
  }

  public int getCount()
  {
    return this.mElementCount;
  }

  public long getDummyType(RenderScript paramRenderScript, long paramLong)
  {
    return paramRenderScript.nIncTypeCreate(paramLong, this.mDimX, this.mDimY, this.mDimZ, this.mDimMipmaps, this.mDimFaces, this.mDimYuv);
  }

  public Element getElement()
  {
    return this.mElement;
  }

  public int getX()
  {
    return this.mDimX;
  }

  public int getY()
  {
    return this.mDimY;
  }

  public int getYuv()
  {
    return this.mDimYuv;
  }

  public int getZ()
  {
    return this.mDimZ;
  }

  public boolean hasFaces()
  {
    return this.mDimFaces;
  }

  public boolean hasMipmaps()
  {
    return this.mDimMipmaps;
  }

  public static class Builder
  {
    boolean mDimFaces;
    boolean mDimMipmaps;
    int mDimX = 1;
    int mDimY;
    int mDimZ;
    Element mElement;
    RenderScript mRS;
    int mYuv;

    public Builder(RenderScript paramRenderScript, Element paramElement)
    {
      paramElement.checkValid();
      this.mRS = paramRenderScript;
      this.mElement = paramElement;
    }

    public Type create()
    {
      if (this.mDimZ > 0)
      {
        if ((this.mDimX < 1) || (this.mDimY < 1))
          throw new RSInvalidStateException("Both X and Y dimension required when Z is present.");
        if (this.mDimFaces)
          throw new RSInvalidStateException("Cube maps not supported with 3D types.");
      }
      if ((this.mDimY > 0) && (this.mDimX < 1))
        throw new RSInvalidStateException("X dimension required when Y is present.");
      if ((this.mDimFaces) && (this.mDimY < 1))
        throw new RSInvalidStateException("Cube maps require 2D Types.");
      if ((this.mYuv != 0) && ((this.mDimZ != 0) || (this.mDimFaces) || (this.mDimMipmaps)))
        throw new RSInvalidStateException("YUV only supports basic 2D.");
      Type localType = new Type(this.mRS.nTypeCreate(this.mElement.getID(this.mRS), this.mDimX, this.mDimY, this.mDimZ, this.mDimMipmaps, this.mDimFaces, this.mYuv), this.mRS);
      localType.mElement = this.mElement;
      localType.mDimX = this.mDimX;
      localType.mDimY = this.mDimY;
      localType.mDimZ = this.mDimZ;
      localType.mDimMipmaps = this.mDimMipmaps;
      localType.mDimFaces = this.mDimFaces;
      localType.mDimYuv = this.mYuv;
      localType.calcElementCount();
      return localType;
    }

    public Builder setFaces(boolean paramBoolean)
    {
      this.mDimFaces = paramBoolean;
      return this;
    }

    public Builder setMipmaps(boolean paramBoolean)
    {
      this.mDimMipmaps = paramBoolean;
      return this;
    }

    public Builder setX(int paramInt)
    {
      if (paramInt < 1)
        throw new RSIllegalArgumentException("Values of less than 1 for Dimension X are not valid.");
      this.mDimX = paramInt;
      return this;
    }

    public Builder setY(int paramInt)
    {
      if (paramInt < 1)
        throw new RSIllegalArgumentException("Values of less than 1 for Dimension Y are not valid.");
      this.mDimY = paramInt;
      return this;
    }

    public Builder setYuvFormat(int paramInt)
    {
      switch (paramInt)
      {
      default:
        throw new RSIllegalArgumentException("Only NV21 and YV12 are supported..");
      case 17:
      case 842094169:
      }
      this.mYuv = paramInt;
      return this;
    }

    public Builder setZ(int paramInt)
    {
      if (paramInt < 1)
        throw new RSIllegalArgumentException("Values of less than 1 for Dimension Z are not valid.");
      this.mDimZ = paramInt;
      return this;
    }
  }

  public static enum CubemapFace
  {
    int mID;

    static
    {
      NEGATIVE_X = new CubemapFace("NEGATIVE_X", 1, 1);
      POSITIVE_Y = new CubemapFace("POSITIVE_Y", 2, 2);
      NEGATIVE_Y = new CubemapFace("NEGATIVE_Y", 3, 3);
      POSITIVE_Z = new CubemapFace("POSITIVE_Z", 4, 4);
      NEGATIVE_Z = new CubemapFace("NEGATIVE_Z", 5, 5);
      CubemapFace[] arrayOfCubemapFace = new CubemapFace[6];
      arrayOfCubemapFace[0] = POSITIVE_X;
      arrayOfCubemapFace[1] = NEGATIVE_X;
      arrayOfCubemapFace[2] = POSITIVE_Y;
      arrayOfCubemapFace[3] = NEGATIVE_Y;
      arrayOfCubemapFace[4] = POSITIVE_Z;
      arrayOfCubemapFace[5] = NEGATIVE_Z;
    }

    private CubemapFace(int paramInt)
    {
      this.mID = paramInt;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.Type
 * JD-Core Version:    0.6.2
 */