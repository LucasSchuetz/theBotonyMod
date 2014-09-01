package botanyPackets;
//package lavaInfusionPackets;
//
//import java.io.ByteArrayInputStream;
//import java.io.DataInputStream;
//
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.entity.EntityClientPlayerMP;
//import net.minecraft.tileentity.TileEntity;
//import net.minecraft.world.World;
//import cpw.mods.fml.common.network.simpleimpl.IMessage;
//import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
//import cpw.mods.fml.common.network.simpleimpl.MessageContext;
//
//public class PacketHandlerClient implements IMessageHandler<SToCMessage, IMessage>
//{
//	//Client to Server Variables
//	public static final int MAGMACHARGE = 0;
//
//	public PacketHandlerClient() {}
//
//    public IMessage onMessage(SToCMessage packet, MessageContext context)
//    {
//    	EntityClientPlayerMP p = Minecraft.getMinecraft().thePlayer;
//        World world = p.worldObj;
//        ByteArrayInputStream stream = new ByteArrayInputStream(packet.getData());
//        DataInputStream dis = new DataInputStream(stream);
//        //System.out.println("Packet get");
//        TileEntity te;
//    	
//    	return null;
//    }
//}