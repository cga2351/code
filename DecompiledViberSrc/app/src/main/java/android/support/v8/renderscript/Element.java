package android.support.v8.renderscript;

public class Element extends BaseObj
{
  int[] mArraySizes;
  String[] mElementNames;
  Element[] mElements;
  DataKind mKind;
  boolean mNormalized;
  int[] mOffsetInBytes;
  int mSize;
  DataType mType;
  int mVectorSize;
  int[] mVisibleElementMap;

  Element(long paramLong, RenderScript paramRenderScript)
  {
    super(paramLong, paramRenderScript);
  }

  Element(long paramLong, RenderScript paramRenderScript, DataType paramDataType, DataKind paramDataKind, boolean paramBoolean, int paramInt)
  {
    super(paramLong, paramRenderScript);
    if ((paramDataType != DataType.UNSIGNED_5_6_5) && (paramDataType != DataType.UNSIGNED_4_4_4_4) && (paramDataType != DataType.UNSIGNED_5_5_5_1))
      if (paramInt == 3)
        this.mSize = (4 * paramDataType.mSize);
    while (true)
    {
      this.mType = paramDataType;
      this.mKind = paramDataKind;
      this.mNormalized = paramBoolean;
      this.mVectorSize = paramInt;
      return;
      this.mSize = (paramInt * paramDataType.mSize);
      continue;
      this.mSize = paramDataType.mSize;
    }
  }

  Element(long paramLong, RenderScript paramRenderScript, Element[] paramArrayOfElement, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super(paramLong, paramRenderScript);
    this.mSize = 0;
    this.mVectorSize = 1;
    this.mElements = paramArrayOfElement;
    this.mElementNames = paramArrayOfString;
    this.mArraySizes = paramArrayOfInt;
    this.mType = DataType.NONE;
    this.mKind = DataKind.USER;
    this.mOffsetInBytes = new int[this.mElements.length];
    while (i < this.mElements.length)
    {
      this.mOffsetInBytes[i] = this.mSize;
      this.mSize += this.mElements[i].mSize * this.mArraySizes[i];
      i++;
    }
    updateVisibleSubElements();
  }

  public static Element ALLOCATION(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_ALLOCATION == null)
      paramRenderScript.mElement_ALLOCATION = createUser(paramRenderScript, DataType.RS_ALLOCATION);
    return paramRenderScript.mElement_ALLOCATION;
  }

  public static Element A_8(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_A_8 == null)
      paramRenderScript.mElement_A_8 = createPixel(paramRenderScript, DataType.UNSIGNED_8, DataKind.PIXEL_A);
    return paramRenderScript.mElement_A_8;
  }

  public static Element BOOLEAN(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_BOOLEAN == null)
      paramRenderScript.mElement_BOOLEAN = createUser(paramRenderScript, DataType.BOOLEAN);
    return paramRenderScript.mElement_BOOLEAN;
  }

  public static Element ELEMENT(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_ELEMENT == null)
      paramRenderScript.mElement_ELEMENT = createUser(paramRenderScript, DataType.RS_ELEMENT);
    return paramRenderScript.mElement_ELEMENT;
  }

  public static Element F32(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_F32 == null)
      paramRenderScript.mElement_F32 = createUser(paramRenderScript, DataType.FLOAT_32);
    return paramRenderScript.mElement_F32;
  }

  public static Element F32_2(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_FLOAT_2 == null)
      paramRenderScript.mElement_FLOAT_2 = createVector(paramRenderScript, DataType.FLOAT_32, 2);
    return paramRenderScript.mElement_FLOAT_2;
  }

  public static Element F32_3(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_FLOAT_3 == null)
      paramRenderScript.mElement_FLOAT_3 = createVector(paramRenderScript, DataType.FLOAT_32, 3);
    return paramRenderScript.mElement_FLOAT_3;
  }

  public static Element F32_4(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_FLOAT_4 == null)
      paramRenderScript.mElement_FLOAT_4 = createVector(paramRenderScript, DataType.FLOAT_32, 4);
    return paramRenderScript.mElement_FLOAT_4;
  }

  public static Element F64(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_F64 == null)
      paramRenderScript.mElement_F64 = createUser(paramRenderScript, DataType.FLOAT_64);
    return paramRenderScript.mElement_F64;
  }

  public static Element F64_2(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_DOUBLE_2 == null)
      paramRenderScript.mElement_DOUBLE_2 = createVector(paramRenderScript, DataType.FLOAT_64, 2);
    return paramRenderScript.mElement_DOUBLE_2;
  }

  public static Element F64_3(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_DOUBLE_3 == null)
      paramRenderScript.mElement_DOUBLE_3 = createVector(paramRenderScript, DataType.FLOAT_64, 3);
    return paramRenderScript.mElement_DOUBLE_3;
  }

  public static Element F64_4(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_DOUBLE_4 == null)
      paramRenderScript.mElement_DOUBLE_4 = createVector(paramRenderScript, DataType.FLOAT_64, 4);
    return paramRenderScript.mElement_DOUBLE_4;
  }

  public static Element I16(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_I16 == null)
      paramRenderScript.mElement_I16 = createUser(paramRenderScript, DataType.SIGNED_16);
    return paramRenderScript.mElement_I16;
  }

  public static Element I16_2(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_SHORT_2 == null)
      paramRenderScript.mElement_SHORT_2 = createVector(paramRenderScript, DataType.SIGNED_16, 2);
    return paramRenderScript.mElement_SHORT_2;
  }

  public static Element I16_3(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_SHORT_3 == null)
      paramRenderScript.mElement_SHORT_3 = createVector(paramRenderScript, DataType.SIGNED_16, 3);
    return paramRenderScript.mElement_SHORT_3;
  }

  public static Element I16_4(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_SHORT_4 == null)
      paramRenderScript.mElement_SHORT_4 = createVector(paramRenderScript, DataType.SIGNED_16, 4);
    return paramRenderScript.mElement_SHORT_4;
  }

  public static Element I32(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_I32 == null)
      paramRenderScript.mElement_I32 = createUser(paramRenderScript, DataType.SIGNED_32);
    return paramRenderScript.mElement_I32;
  }

  public static Element I32_2(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_INT_2 == null)
      paramRenderScript.mElement_INT_2 = createVector(paramRenderScript, DataType.SIGNED_32, 2);
    return paramRenderScript.mElement_INT_2;
  }

  public static Element I32_3(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_INT_3 == null)
      paramRenderScript.mElement_INT_3 = createVector(paramRenderScript, DataType.SIGNED_32, 3);
    return paramRenderScript.mElement_INT_3;
  }

  public static Element I32_4(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_INT_4 == null)
      paramRenderScript.mElement_INT_4 = createVector(paramRenderScript, DataType.SIGNED_32, 4);
    return paramRenderScript.mElement_INT_4;
  }

  public static Element I64(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_I64 == null)
      paramRenderScript.mElement_I64 = createUser(paramRenderScript, DataType.SIGNED_64);
    return paramRenderScript.mElement_I64;
  }

  public static Element I64_2(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_LONG_2 == null)
      paramRenderScript.mElement_LONG_2 = createVector(paramRenderScript, DataType.SIGNED_64, 2);
    return paramRenderScript.mElement_LONG_2;
  }

  public static Element I64_3(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_LONG_3 == null)
      paramRenderScript.mElement_LONG_3 = createVector(paramRenderScript, DataType.SIGNED_64, 3);
    return paramRenderScript.mElement_LONG_3;
  }

  public static Element I64_4(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_LONG_4 == null)
      paramRenderScript.mElement_LONG_4 = createVector(paramRenderScript, DataType.SIGNED_64, 4);
    return paramRenderScript.mElement_LONG_4;
  }

  public static Element I8(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_I8 == null)
      paramRenderScript.mElement_I8 = createUser(paramRenderScript, DataType.SIGNED_8);
    return paramRenderScript.mElement_I8;
  }

  public static Element I8_2(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_CHAR_2 == null)
      paramRenderScript.mElement_CHAR_2 = createVector(paramRenderScript, DataType.SIGNED_8, 2);
    return paramRenderScript.mElement_CHAR_2;
  }

  public static Element I8_3(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_CHAR_3 == null)
      paramRenderScript.mElement_CHAR_3 = createVector(paramRenderScript, DataType.SIGNED_8, 3);
    return paramRenderScript.mElement_CHAR_3;
  }

  public static Element I8_4(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_CHAR_4 == null)
      paramRenderScript.mElement_CHAR_4 = createVector(paramRenderScript, DataType.SIGNED_8, 4);
    return paramRenderScript.mElement_CHAR_4;
  }

  public static Element MATRIX_2X2(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_MATRIX_2X2 == null)
      paramRenderScript.mElement_MATRIX_2X2 = createUser(paramRenderScript, DataType.MATRIX_2X2);
    return paramRenderScript.mElement_MATRIX_2X2;
  }

  public static Element MATRIX_3X3(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_MATRIX_3X3 == null)
      paramRenderScript.mElement_MATRIX_3X3 = createUser(paramRenderScript, DataType.MATRIX_3X3);
    return paramRenderScript.mElement_MATRIX_3X3;
  }

  public static Element MATRIX_4X4(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_MATRIX_4X4 == null)
      paramRenderScript.mElement_MATRIX_4X4 = createUser(paramRenderScript, DataType.MATRIX_4X4);
    return paramRenderScript.mElement_MATRIX_4X4;
  }

  public static Element RGBA_4444(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_RGBA_4444 == null)
      paramRenderScript.mElement_RGBA_4444 = createPixel(paramRenderScript, DataType.UNSIGNED_4_4_4_4, DataKind.PIXEL_RGBA);
    return paramRenderScript.mElement_RGBA_4444;
  }

  public static Element RGBA_5551(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_RGBA_5551 == null)
      paramRenderScript.mElement_RGBA_5551 = createPixel(paramRenderScript, DataType.UNSIGNED_5_5_5_1, DataKind.PIXEL_RGBA);
    return paramRenderScript.mElement_RGBA_5551;
  }

  public static Element RGBA_8888(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_RGBA_8888 == null)
      paramRenderScript.mElement_RGBA_8888 = createPixel(paramRenderScript, DataType.UNSIGNED_8, DataKind.PIXEL_RGBA);
    return paramRenderScript.mElement_RGBA_8888;
  }

  public static Element RGB_565(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_RGB_565 == null)
      paramRenderScript.mElement_RGB_565 = createPixel(paramRenderScript, DataType.UNSIGNED_5_6_5, DataKind.PIXEL_RGB);
    return paramRenderScript.mElement_RGB_565;
  }

  public static Element RGB_888(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_RGB_888 == null)
      paramRenderScript.mElement_RGB_888 = createPixel(paramRenderScript, DataType.UNSIGNED_8, DataKind.PIXEL_RGB);
    return paramRenderScript.mElement_RGB_888;
  }

  public static Element SAMPLER(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_SAMPLER == null)
      paramRenderScript.mElement_SAMPLER = createUser(paramRenderScript, DataType.RS_SAMPLER);
    return paramRenderScript.mElement_SAMPLER;
  }

  public static Element SCRIPT(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_SCRIPT == null)
      paramRenderScript.mElement_SCRIPT = createUser(paramRenderScript, DataType.RS_SCRIPT);
    return paramRenderScript.mElement_SCRIPT;
  }

  public static Element TYPE(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_TYPE == null)
      paramRenderScript.mElement_TYPE = createUser(paramRenderScript, DataType.RS_TYPE);
    return paramRenderScript.mElement_TYPE;
  }

  public static Element U16(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_U16 == null)
      paramRenderScript.mElement_U16 = createUser(paramRenderScript, DataType.UNSIGNED_16);
    return paramRenderScript.mElement_U16;
  }

  public static Element U16_2(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_USHORT_2 == null)
      paramRenderScript.mElement_USHORT_2 = createVector(paramRenderScript, DataType.UNSIGNED_16, 2);
    return paramRenderScript.mElement_USHORT_2;
  }

  public static Element U16_3(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_USHORT_3 == null)
      paramRenderScript.mElement_USHORT_3 = createVector(paramRenderScript, DataType.UNSIGNED_16, 3);
    return paramRenderScript.mElement_USHORT_3;
  }

  public static Element U16_4(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_USHORT_4 == null)
      paramRenderScript.mElement_USHORT_4 = createVector(paramRenderScript, DataType.UNSIGNED_16, 4);
    return paramRenderScript.mElement_USHORT_4;
  }

  public static Element U32(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_U32 == null)
      paramRenderScript.mElement_U32 = createUser(paramRenderScript, DataType.UNSIGNED_32);
    return paramRenderScript.mElement_U32;
  }

  public static Element U32_2(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_UINT_2 == null)
      paramRenderScript.mElement_UINT_2 = createVector(paramRenderScript, DataType.UNSIGNED_32, 2);
    return paramRenderScript.mElement_UINT_2;
  }

  public static Element U32_3(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_UINT_3 == null)
      paramRenderScript.mElement_UINT_3 = createVector(paramRenderScript, DataType.UNSIGNED_32, 3);
    return paramRenderScript.mElement_UINT_3;
  }

  public static Element U32_4(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_UINT_4 == null)
      paramRenderScript.mElement_UINT_4 = createVector(paramRenderScript, DataType.UNSIGNED_32, 4);
    return paramRenderScript.mElement_UINT_4;
  }

  public static Element U64(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_U64 == null)
      paramRenderScript.mElement_U64 = createUser(paramRenderScript, DataType.UNSIGNED_64);
    return paramRenderScript.mElement_U64;
  }

  public static Element U64_2(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_ULONG_2 == null)
      paramRenderScript.mElement_ULONG_2 = createVector(paramRenderScript, DataType.UNSIGNED_64, 2);
    return paramRenderScript.mElement_ULONG_2;
  }

  public static Element U64_3(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_ULONG_3 == null)
      paramRenderScript.mElement_ULONG_3 = createVector(paramRenderScript, DataType.UNSIGNED_64, 3);
    return paramRenderScript.mElement_ULONG_3;
  }

  public static Element U64_4(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_ULONG_4 == null)
      paramRenderScript.mElement_ULONG_4 = createVector(paramRenderScript, DataType.UNSIGNED_64, 4);
    return paramRenderScript.mElement_ULONG_4;
  }

  public static Element U8(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_U8 == null)
      paramRenderScript.mElement_U8 = createUser(paramRenderScript, DataType.UNSIGNED_8);
    return paramRenderScript.mElement_U8;
  }

  public static Element U8_2(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_UCHAR_2 == null)
      paramRenderScript.mElement_UCHAR_2 = createVector(paramRenderScript, DataType.UNSIGNED_8, 2);
    return paramRenderScript.mElement_UCHAR_2;
  }

  public static Element U8_3(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_UCHAR_3 == null)
      paramRenderScript.mElement_UCHAR_3 = createVector(paramRenderScript, DataType.UNSIGNED_8, 3);
    return paramRenderScript.mElement_UCHAR_3;
  }

  public static Element U8_4(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_UCHAR_4 == null)
      paramRenderScript.mElement_UCHAR_4 = createVector(paramRenderScript, DataType.UNSIGNED_8, 4);
    return paramRenderScript.mElement_UCHAR_4;
  }

  public static Element createPixel(RenderScript paramRenderScript, DataType paramDataType, DataKind paramDataKind)
  {
    if ((paramDataKind != DataKind.PIXEL_L) && (paramDataKind != DataKind.PIXEL_A) && (paramDataKind != DataKind.PIXEL_LA) && (paramDataKind != DataKind.PIXEL_RGB) && (paramDataKind != DataKind.PIXEL_RGBA) && (paramDataKind != DataKind.PIXEL_DEPTH) && (paramDataKind != DataKind.PIXEL_YUV))
      throw new RSIllegalArgumentException("Unsupported DataKind");
    if ((paramDataType != DataType.UNSIGNED_8) && (paramDataType != DataType.UNSIGNED_16) && (paramDataType != DataType.UNSIGNED_5_6_5) && (paramDataType != DataType.UNSIGNED_4_4_4_4) && (paramDataType != DataType.UNSIGNED_5_5_5_1))
      throw new RSIllegalArgumentException("Unsupported DataType");
    if ((paramDataType == DataType.UNSIGNED_5_6_5) && (paramDataKind != DataKind.PIXEL_RGB))
      throw new RSIllegalArgumentException("Bad kind and type combo");
    if ((paramDataType == DataType.UNSIGNED_5_5_5_1) && (paramDataKind != DataKind.PIXEL_RGBA))
      throw new RSIllegalArgumentException("Bad kind and type combo");
    if ((paramDataType == DataType.UNSIGNED_4_4_4_4) && (paramDataKind != DataKind.PIXEL_RGBA))
      throw new RSIllegalArgumentException("Bad kind and type combo");
    if ((paramDataType == DataType.UNSIGNED_16) && (paramDataKind != DataKind.PIXEL_DEPTH))
      throw new RSIllegalArgumentException("Bad kind and type combo");
    int i = 1;
    switch (1.$SwitchMap$android$support$v8$renderscript$Element$DataKind[paramDataKind.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      return new Element(paramRenderScript.nElementCreate(paramDataType.mID, paramDataKind.mID, true, i), paramRenderScript, paramDataType, paramDataKind, true, i);
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
    }
  }

  static Element createUser(RenderScript paramRenderScript, DataType paramDataType)
  {
    DataKind localDataKind = DataKind.USER;
    return new Element(paramRenderScript.nElementCreate(paramDataType.mID, localDataKind.mID, false, 1), paramRenderScript, paramDataType, localDataKind, false, 1);
  }

  public static Element createVector(RenderScript paramRenderScript, DataType paramDataType, int paramInt)
  {
    if ((paramInt < 2) || (paramInt > 4))
      throw new RSIllegalArgumentException("Vector size out of range 2-4.");
    switch (1.$SwitchMap$android$support$v8$renderscript$Element$DataType[paramDataType.ordinal()])
    {
    default:
      throw new RSIllegalArgumentException("Cannot create vector of non-primitive type.");
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    case 10:
    case 11:
    }
    DataKind localDataKind = DataKind.USER;
    return new Element(paramRenderScript.nElementCreate(paramDataType.mID, localDataKind.mID, false, paramInt), paramRenderScript, paramDataType, localDataKind, false, paramInt);
  }

  private void updateVisibleSubElements()
  {
    if (this.mElements == null)
      return;
    int i = this.mElementNames.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      if (this.mElementNames[j].charAt(0) != '#')
        k++;
      j++;
    }
    this.mVisibleElementMap = new int[k];
    int m = 0;
    int n = 0;
    label60: int i1;
    if (n < i)
    {
      if (this.mElementNames[n].charAt(0) == '#')
        break label111;
      int[] arrayOfInt = this.mVisibleElementMap;
      i1 = m + 1;
      arrayOfInt[m] = n;
    }
    while (true)
    {
      n++;
      m = i1;
      break label60;
      break;
      label111: i1 = m;
    }
  }

  public int getBytesSize()
  {
    return this.mSize;
  }

  public DataKind getDataKind()
  {
    return this.mKind;
  }

  public DataType getDataType()
  {
    return this.mType;
  }

  public long getDummyElement(RenderScript paramRenderScript)
  {
    return paramRenderScript.nIncElementCreate(this.mType.mID, this.mKind.mID, this.mNormalized, this.mVectorSize);
  }

  public Element getSubElement(int paramInt)
  {
    if (this.mVisibleElementMap == null)
      throw new RSIllegalArgumentException("Element contains no sub-elements");
    if ((paramInt < 0) || (paramInt >= this.mVisibleElementMap.length))
      throw new RSIllegalArgumentException("Illegal sub-element index");
    return this.mElements[this.mVisibleElementMap[paramInt]];
  }

  public int getSubElementArraySize(int paramInt)
  {
    if (this.mVisibleElementMap == null)
      throw new RSIllegalArgumentException("Element contains no sub-elements");
    if ((paramInt < 0) || (paramInt >= this.mVisibleElementMap.length))
      throw new RSIllegalArgumentException("Illegal sub-element index");
    return this.mArraySizes[this.mVisibleElementMap[paramInt]];
  }

  public int getSubElementCount()
  {
    if (this.mVisibleElementMap == null)
      return 0;
    return this.mVisibleElementMap.length;
  }

  public String getSubElementName(int paramInt)
  {
    if (this.mVisibleElementMap == null)
      throw new RSIllegalArgumentException("Element contains no sub-elements");
    if ((paramInt < 0) || (paramInt >= this.mVisibleElementMap.length))
      throw new RSIllegalArgumentException("Illegal sub-element index");
    return this.mElementNames[this.mVisibleElementMap[paramInt]];
  }

  public int getSubElementOffsetBytes(int paramInt)
  {
    if (this.mVisibleElementMap == null)
      throw new RSIllegalArgumentException("Element contains no sub-elements");
    if ((paramInt < 0) || (paramInt >= this.mVisibleElementMap.length))
      throw new RSIllegalArgumentException("Illegal sub-element index");
    return this.mOffsetInBytes[this.mVisibleElementMap[paramInt]];
  }

  public int getVectorSize()
  {
    return this.mVectorSize;
  }

  public boolean isCompatible(Element paramElement)
  {
    if (equals(paramElement));
    while ((this.mSize == paramElement.mSize) && (this.mType != DataType.NONE) && (this.mType == paramElement.mType) && (this.mVectorSize == paramElement.mVectorSize))
      return true;
    return false;
  }

  public boolean isComplex()
  {
    if (this.mElements == null);
    while (true)
    {
      return false;
      for (int i = 0; i < this.mElements.length; i++)
        if (this.mElements[i].mElements != null)
          return true;
    }
  }

  public static class Builder
  {
    int[] mArraySizes;
    int mCount;
    String[] mElementNames;
    Element[] mElements;
    RenderScript mRS;
    int mSkipPadding;

    public Builder(RenderScript paramRenderScript)
    {
      this.mRS = paramRenderScript;
      this.mCount = 0;
      this.mElements = new Element[8];
      this.mElementNames = new String[8];
      this.mArraySizes = new int[8];
    }

    public Builder add(Element paramElement, String paramString)
    {
      return add(paramElement, paramString, 1);
    }

    public Builder add(Element paramElement, String paramString, int paramInt)
    {
      if (paramInt < 1)
        throw new RSIllegalArgumentException("Array size cannot be less than 1.");
      if ((this.mSkipPadding != 0) && (paramString.startsWith("#padding_")))
      {
        this.mSkipPadding = 0;
        return this;
      }
      if (paramElement.mVectorSize == 3);
      for (this.mSkipPadding = 1; ; this.mSkipPadding = 0)
      {
        if (this.mCount == this.mElements.length)
        {
          Element[] arrayOfElement = new Element[8 + this.mCount];
          String[] arrayOfString = new String[8 + this.mCount];
          int[] arrayOfInt = new int[8 + this.mCount];
          System.arraycopy(this.mElements, 0, arrayOfElement, 0, this.mCount);
          System.arraycopy(this.mElementNames, 0, arrayOfString, 0, this.mCount);
          System.arraycopy(this.mArraySizes, 0, arrayOfInt, 0, this.mCount);
          this.mElements = arrayOfElement;
          this.mElementNames = arrayOfString;
          this.mArraySizes = arrayOfInt;
        }
        this.mElements[this.mCount] = paramElement;
        this.mElementNames[this.mCount] = paramString;
        this.mArraySizes[this.mCount] = paramInt;
        this.mCount = (1 + this.mCount);
        return this;
      }
    }

    public Element create()
    {
      int i = 0;
      this.mRS.validate();
      Element[] arrayOfElement = new Element[this.mCount];
      String[] arrayOfString = new String[this.mCount];
      int[] arrayOfInt = new int[this.mCount];
      System.arraycopy(this.mElements, 0, arrayOfElement, 0, this.mCount);
      System.arraycopy(this.mElementNames, 0, arrayOfString, 0, this.mCount);
      System.arraycopy(this.mArraySizes, 0, arrayOfInt, 0, this.mCount);
      long[] arrayOfLong = new long[arrayOfElement.length];
      while (i < arrayOfElement.length)
      {
        arrayOfLong[i] = arrayOfElement[i].getID(this.mRS);
        i++;
      }
      return new Element(this.mRS.nElementCreate2(arrayOfLong, arrayOfString, arrayOfInt), this.mRS, arrayOfElement, arrayOfString, arrayOfInt);
    }
  }

  public static enum DataKind
  {
    int mID;

    static
    {
      PIXEL_L = new DataKind("PIXEL_L", 1, 7);
      PIXEL_A = new DataKind("PIXEL_A", 2, 8);
      PIXEL_LA = new DataKind("PIXEL_LA", 3, 9);
      PIXEL_RGB = new DataKind("PIXEL_RGB", 4, 10);
      PIXEL_RGBA = new DataKind("PIXEL_RGBA", 5, 11);
      PIXEL_DEPTH = new DataKind("PIXEL_DEPTH", 6, 12);
      PIXEL_YUV = new DataKind("PIXEL_YUV", 7, 13);
      DataKind[] arrayOfDataKind = new DataKind[8];
      arrayOfDataKind[0] = USER;
      arrayOfDataKind[1] = PIXEL_L;
      arrayOfDataKind[2] = PIXEL_A;
      arrayOfDataKind[3] = PIXEL_LA;
      arrayOfDataKind[4] = PIXEL_RGB;
      arrayOfDataKind[5] = PIXEL_RGBA;
      arrayOfDataKind[6] = PIXEL_DEPTH;
      arrayOfDataKind[7] = PIXEL_YUV;
    }

    private DataKind(int paramInt)
    {
      this.mID = paramInt;
    }
  }

  public static enum DataType
  {
    int mID;
    int mSize;

    static
    {
      FLOAT_32 = new DataType("FLOAT_32", 1, 2, 4);
      FLOAT_64 = new DataType("FLOAT_64", 2, 3, 8);
      SIGNED_8 = new DataType("SIGNED_8", 3, 4, 1);
      SIGNED_16 = new DataType("SIGNED_16", 4, 5, 2);
      SIGNED_32 = new DataType("SIGNED_32", 5, 6, 4);
      SIGNED_64 = new DataType("SIGNED_64", 6, 7, 8);
      UNSIGNED_8 = new DataType("UNSIGNED_8", 7, 8, 1);
      UNSIGNED_16 = new DataType("UNSIGNED_16", 8, 9, 2);
      UNSIGNED_32 = new DataType("UNSIGNED_32", 9, 10, 4);
      UNSIGNED_64 = new DataType("UNSIGNED_64", 10, 11, 8);
      BOOLEAN = new DataType("BOOLEAN", 11, 12, 1);
      UNSIGNED_5_6_5 = new DataType("UNSIGNED_5_6_5", 12, 13, 2);
      UNSIGNED_5_5_5_1 = new DataType("UNSIGNED_5_5_5_1", 13, 14, 2);
      UNSIGNED_4_4_4_4 = new DataType("UNSIGNED_4_4_4_4", 14, 15, 2);
      MATRIX_4X4 = new DataType("MATRIX_4X4", 15, 16, 64);
      MATRIX_3X3 = new DataType("MATRIX_3X3", 16, 17, 36);
      MATRIX_2X2 = new DataType("MATRIX_2X2", 17, 18, 16);
      RS_ELEMENT = new DataType("RS_ELEMENT", 18, 1000);
      RS_TYPE = new DataType("RS_TYPE", 19, 1001);
      RS_ALLOCATION = new DataType("RS_ALLOCATION", 20, 1002);
      RS_SAMPLER = new DataType("RS_SAMPLER", 21, 1003);
      RS_SCRIPT = new DataType("RS_SCRIPT", 22, 1004);
      DataType[] arrayOfDataType = new DataType[23];
      arrayOfDataType[0] = NONE;
      arrayOfDataType[1] = FLOAT_32;
      arrayOfDataType[2] = FLOAT_64;
      arrayOfDataType[3] = SIGNED_8;
      arrayOfDataType[4] = SIGNED_16;
      arrayOfDataType[5] = SIGNED_32;
      arrayOfDataType[6] = SIGNED_64;
      arrayOfDataType[7] = UNSIGNED_8;
      arrayOfDataType[8] = UNSIGNED_16;
      arrayOfDataType[9] = UNSIGNED_32;
      arrayOfDataType[10] = UNSIGNED_64;
      arrayOfDataType[11] = BOOLEAN;
      arrayOfDataType[12] = UNSIGNED_5_6_5;
      arrayOfDataType[13] = UNSIGNED_5_5_5_1;
      arrayOfDataType[14] = UNSIGNED_4_4_4_4;
      arrayOfDataType[15] = MATRIX_4X4;
      arrayOfDataType[16] = MATRIX_3X3;
      arrayOfDataType[17] = MATRIX_2X2;
      arrayOfDataType[18] = RS_ELEMENT;
      arrayOfDataType[19] = RS_TYPE;
      arrayOfDataType[20] = RS_ALLOCATION;
      arrayOfDataType[21] = RS_SAMPLER;
      arrayOfDataType[22] = RS_SCRIPT;
    }

    private DataType(int paramInt)
    {
      this.mID = paramInt;
      this.mSize = 4;
      if (RenderScript.sPointerSize == 8)
        this.mSize = 32;
    }

    private DataType(int paramInt1, int paramInt2)
    {
      this.mID = paramInt1;
      this.mSize = paramInt2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.Element
 * JD-Core Version:    0.6.2
 */