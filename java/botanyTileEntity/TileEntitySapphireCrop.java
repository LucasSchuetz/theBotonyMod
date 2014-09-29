package botanyTileEntity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySapphireCrop extends TileEntity
{
	int bAmt;
	boolean staffFound = false;
	
	public int getBerryAmount()
	{
//		if(worldObj.isRemote)
//			System.out.print("client ");
//		else
//			System.out.print("server ");
//		System.out.print(bAmt + "\n");
		return bAmt;
	}
	
	public void setBerryAmount(int that)
	{
		this.bAmt = that;
	}
	
	public boolean getStaffFound()
	{
		return staffFound;
	}
	
	public void setStaffFound(boolean that)
	{
		this.staffFound = that;
	}
	
	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound nbtTag = new NBTTagCompound();
		this.writeToNBT(nbtTag);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
	{
		readFromNBT(packet.func_148857_g());
	}
	
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        this.bAmt = nbt.getInteger("bAmt");
        this.staffFound = nbt.getBoolean("staffFound");
    }

    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        nbt.setInteger("bAmt", bAmt);
        nbt.setBoolean("staffFound", staffFound);
    }
}
