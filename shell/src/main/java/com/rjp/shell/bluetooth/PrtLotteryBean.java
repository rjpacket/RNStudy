package com.rjp.shell.bluetooth;

public class PrtLotteryBean
{
  private int flagLottery;
  private byte[] lotteryData;
  private byte[] lotteryDataWelfareHead;
  
  public int getFlagLottery()
  {
    return this.flagLottery;
  }
  
  public byte[] getLotteryData()
  {
    return this.lotteryData;
  }
  
  public byte[] getLotteryDataWelfareHead()
  {
    return this.lotteryDataWelfareHead;
  }
  
  public void setFlagLottery(int paramInt)
  {
    this.flagLottery = paramInt;
  }
  
  public void setLotteryData(byte[] paramArrayOfByte)
  {
    this.lotteryData = paramArrayOfByte;
  }
  
  public void setLotteryDataWelfareHead(byte[] paramArrayOfByte)
  {
    this.lotteryDataWelfareHead = paramArrayOfByte;
  }
}


/* Location:              D:\Android\NewTechnique\UCDemo\work\123res\classes-dex2jar.jar!\net\hlz\prt\bean\PrtLotteryBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */