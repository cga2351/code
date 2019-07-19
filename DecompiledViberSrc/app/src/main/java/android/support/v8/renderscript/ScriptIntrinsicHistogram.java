package android.support.v8.renderscript;

import android.os.Build.VERSION;

public class ScriptIntrinsicHistogram extends ScriptIntrinsic
{
  private static final int INTRINSIC_API_LEVEL = 19;
  private Allocation mOut;

  protected ScriptIntrinsicHistogram(long paramLong, RenderScript paramRenderScript)
  {
    super(paramLong, paramRenderScript);
  }

  public static ScriptIntrinsicHistogram create(RenderScript paramRenderScript, Element paramElement)
  {
    if ((!paramElement.isCompatible(Element.U8_4(paramRenderScript))) && (!paramElement.isCompatible(Element.U8_3(paramRenderScript))) && (!paramElement.isCompatible(Element.U8_2(paramRenderScript))) && (!paramElement.isCompatible(Element.U8(paramRenderScript))))
      throw new RSIllegalArgumentException("Unsupported element type.");
    if ((paramRenderScript.isUseNative()) && (Build.VERSION.SDK_INT < 19));
    for (boolean bool = true; ; bool = false)
    {
      ScriptIntrinsicHistogram localScriptIntrinsicHistogram = new ScriptIntrinsicHistogram(paramRenderScript.nScriptIntrinsicCreate(9, paramElement.getID(paramRenderScript), bool), paramRenderScript);
      localScriptIntrinsicHistogram.setIncSupp(bool);
      return localScriptIntrinsicHistogram;
    }
  }

  public void forEach(Allocation paramAllocation)
  {
    forEach(paramAllocation, null);
  }

  public void forEach(Allocation paramAllocation, Script.LaunchOptions paramLaunchOptions)
  {
    if (paramAllocation.getType().getElement().getVectorSize() < this.mOut.getType().getElement().getVectorSize())
      throw new RSIllegalArgumentException("Input vector size must be >= output vector size.");
    if ((!paramAllocation.getType().getElement().isCompatible(Element.U8(this.mRS))) && (!paramAllocation.getType().getElement().isCompatible(Element.U8_2(this.mRS))) && (!paramAllocation.getType().getElement().isCompatible(Element.U8_3(this.mRS))) && (!paramAllocation.getType().getElement().isCompatible(Element.U8_4(this.mRS))))
      throw new RSIllegalArgumentException("Input type must be U8, U8_1, U8_2 or U8_4.");
    forEach(0, paramAllocation, null, null, paramLaunchOptions);
  }

  public void forEach_Dot(Allocation paramAllocation)
  {
    forEach_Dot(paramAllocation, null);
  }

  public void forEach_Dot(Allocation paramAllocation, Script.LaunchOptions paramLaunchOptions)
  {
    if (this.mOut.getType().getElement().getVectorSize() != 1)
      throw new RSIllegalArgumentException("Output vector size must be one.");
    if ((!paramAllocation.getType().getElement().isCompatible(Element.U8(this.mRS))) && (!paramAllocation.getType().getElement().isCompatible(Element.U8_2(this.mRS))) && (!paramAllocation.getType().getElement().isCompatible(Element.U8_3(this.mRS))) && (!paramAllocation.getType().getElement().isCompatible(Element.U8_4(this.mRS))))
      throw new RSIllegalArgumentException("Input type must be U8, U8_1, U8_2 or U8_4.");
    forEach(1, paramAllocation, null, null, paramLaunchOptions);
  }

  public Script.FieldID getFieldID_Input()
  {
    return createFieldID(1, null);
  }

  public Script.KernelID getKernelID_Separate()
  {
    return createKernelID(0, 3, null, null);
  }

  public void setDotCoefficients(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((paramFloat1 < 0.0F) || (paramFloat2 < 0.0F) || (paramFloat3 < 0.0F) || (paramFloat4 < 0.0F))
      throw new RSIllegalArgumentException("Coefficient may not be negative.");
    if (paramFloat4 + (paramFloat3 + (paramFloat1 + paramFloat2)) > 1.0F)
      throw new RSIllegalArgumentException("Sum of coefficients must be 1.0 or less.");
    FieldPacker localFieldPacker = new FieldPacker(16);
    localFieldPacker.addF32(paramFloat1);
    localFieldPacker.addF32(paramFloat2);
    localFieldPacker.addF32(paramFloat3);
    localFieldPacker.addF32(paramFloat4);
    setVar(0, localFieldPacker);
  }

  public void setOutput(Allocation paramAllocation)
  {
    this.mOut = paramAllocation;
    if ((this.mOut.getType().getElement() != Element.U32(this.mRS)) && (this.mOut.getType().getElement() != Element.U32_2(this.mRS)) && (this.mOut.getType().getElement() != Element.U32_3(this.mRS)) && (this.mOut.getType().getElement() != Element.U32_4(this.mRS)) && (this.mOut.getType().getElement() != Element.I32(this.mRS)) && (this.mOut.getType().getElement() != Element.I32_2(this.mRS)) && (this.mOut.getType().getElement() != Element.I32_3(this.mRS)) && (this.mOut.getType().getElement() != Element.I32_4(this.mRS)))
      throw new RSIllegalArgumentException("Output type must be U32 or I32.");
    if ((this.mOut.getType().getX() != 256) || (this.mOut.getType().getY() != 0) || (this.mOut.getType().hasMipmaps()) || (this.mOut.getType().getYuv() != 0))
      throw new RSIllegalArgumentException("Output must be 1D, 256 elements.");
    setVar(1, paramAllocation);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.ScriptIntrinsicHistogram
 * JD-Core Version:    0.6.2
 */