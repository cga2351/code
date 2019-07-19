package android.support.v8.renderscript;

import android.os.Build.VERSION;

public class ScriptIntrinsicBlend extends ScriptIntrinsic
{
  private static final int INTRINSIC_API_LEVEL = 19;

  ScriptIntrinsicBlend(long paramLong, RenderScript paramRenderScript)
  {
    super(paramLong, paramRenderScript);
  }

  private void blend(int paramInt, Allocation paramAllocation1, Allocation paramAllocation2)
  {
    if (!paramAllocation1.getElement().isCompatible(Element.U8_4(this.mRS)))
      throw new RSIllegalArgumentException("Input is not of expected format.");
    if (!paramAllocation2.getElement().isCompatible(Element.U8_4(this.mRS)))
      throw new RSIllegalArgumentException("Output is not of expected format.");
    forEach(paramInt, paramAllocation1, paramAllocation2, null);
  }

  public static ScriptIntrinsicBlend create(RenderScript paramRenderScript, Element paramElement)
  {
    if ((paramRenderScript.isUseNative()) && (Build.VERSION.SDK_INT < 19));
    for (boolean bool = true; ; bool = false)
    {
      ScriptIntrinsicBlend localScriptIntrinsicBlend = new ScriptIntrinsicBlend(paramRenderScript.nScriptIntrinsicCreate(7, paramElement.getID(paramRenderScript), bool), paramRenderScript);
      localScriptIntrinsicBlend.setIncSupp(bool);
      return localScriptIntrinsicBlend;
    }
  }

  public void forEachAdd(Allocation paramAllocation1, Allocation paramAllocation2)
  {
    blend(34, paramAllocation1, paramAllocation2);
  }

  public void forEachClear(Allocation paramAllocation1, Allocation paramAllocation2)
  {
    blend(0, paramAllocation1, paramAllocation2);
  }

  public void forEachDst(Allocation paramAllocation1, Allocation paramAllocation2)
  {
  }

  public void forEachDstAtop(Allocation paramAllocation1, Allocation paramAllocation2)
  {
    blend(10, paramAllocation1, paramAllocation2);
  }

  public void forEachDstIn(Allocation paramAllocation1, Allocation paramAllocation2)
  {
    blend(6, paramAllocation1, paramAllocation2);
  }

  public void forEachDstOut(Allocation paramAllocation1, Allocation paramAllocation2)
  {
    blend(8, paramAllocation1, paramAllocation2);
  }

  public void forEachDstOver(Allocation paramAllocation1, Allocation paramAllocation2)
  {
    blend(4, paramAllocation1, paramAllocation2);
  }

  public void forEachMultiply(Allocation paramAllocation1, Allocation paramAllocation2)
  {
    blend(14, paramAllocation1, paramAllocation2);
  }

  public void forEachSrc(Allocation paramAllocation1, Allocation paramAllocation2)
  {
    blend(1, paramAllocation1, paramAllocation2);
  }

  public void forEachSrcAtop(Allocation paramAllocation1, Allocation paramAllocation2)
  {
    blend(9, paramAllocation1, paramAllocation2);
  }

  public void forEachSrcIn(Allocation paramAllocation1, Allocation paramAllocation2)
  {
    blend(5, paramAllocation1, paramAllocation2);
  }

  public void forEachSrcOut(Allocation paramAllocation1, Allocation paramAllocation2)
  {
    blend(7, paramAllocation1, paramAllocation2);
  }

  public void forEachSrcOver(Allocation paramAllocation1, Allocation paramAllocation2)
  {
    blend(3, paramAllocation1, paramAllocation2);
  }

  public void forEachSubtract(Allocation paramAllocation1, Allocation paramAllocation2)
  {
    blend(35, paramAllocation1, paramAllocation2);
  }

  public void forEachXor(Allocation paramAllocation1, Allocation paramAllocation2)
  {
    blend(11, paramAllocation1, paramAllocation2);
  }

  public Script.KernelID getKernelIDAdd()
  {
    return createKernelID(34, 3, null, null);
  }

  public Script.KernelID getKernelIDClear()
  {
    return createKernelID(0, 3, null, null);
  }

  public Script.KernelID getKernelIDDst()
  {
    return createKernelID(2, 3, null, null);
  }

  public Script.KernelID getKernelIDDstAtop()
  {
    return createKernelID(10, 3, null, null);
  }

  public Script.KernelID getKernelIDDstIn()
  {
    return createKernelID(6, 3, null, null);
  }

  public Script.KernelID getKernelIDDstOut()
  {
    return createKernelID(8, 3, null, null);
  }

  public Script.KernelID getKernelIDDstOver()
  {
    return createKernelID(4, 3, null, null);
  }

  public Script.KernelID getKernelIDMultiply()
  {
    return createKernelID(14, 3, null, null);
  }

  public Script.KernelID getKernelIDSrc()
  {
    return createKernelID(1, 3, null, null);
  }

  public Script.KernelID getKernelIDSrcAtop()
  {
    return createKernelID(9, 3, null, null);
  }

  public Script.KernelID getKernelIDSrcIn()
  {
    return createKernelID(5, 3, null, null);
  }

  public Script.KernelID getKernelIDSrcOut()
  {
    return createKernelID(7, 3, null, null);
  }

  public Script.KernelID getKernelIDSrcOver()
  {
    return createKernelID(3, 3, null, null);
  }

  public Script.KernelID getKernelIDSubtract()
  {
    return createKernelID(35, 3, null, null);
  }

  public Script.KernelID getKernelIDXor()
  {
    return createKernelID(11, 3, null, null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.ScriptIntrinsicBlend
 * JD-Core Version:    0.6.2
 */