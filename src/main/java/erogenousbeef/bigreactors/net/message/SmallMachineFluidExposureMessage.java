package erogenousbeef.bigreactors.net.message;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import erogenousbeef.bigreactors.common.tileentity.base.TileEntityPoweredInventoryFluid;
import io.netty.buffer.ByteBuf;

public class SmallMachineFluidExposureMessage implements IMessage, IMessageHandler<SmallMachineFluidExposureMessage, IMessage> {
    private int x, y, z, side, tankIdx;

    public SmallMachineFluidExposureMessage(int x, int y, int z, int side, int tankIdx) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.side = side;
        this.tankIdx = tankIdx;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        x = buf.readInt();
        y = buf.readInt();
        z = buf.readInt();
        side = buf.readInt();
        tankIdx = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeInt(side);
        buf.writeInt(tankIdx);
    }

    @Override
    public IMessage onMessage(SmallMachineFluidExposureMessage message, MessageContext ctx) {
        TileEntity te = FMLClientHandler.instance().getWorldClient().getTileEntity(x, y, z);
        if(te != null && te instanceof TileEntityPoweredInventoryFluid) {
            ((TileEntityPoweredInventoryFluid)te).setExposedTank(ForgeDirection.getOrientation(side), tankIdx);
            FMLClientHandler.instance().getWorldClient().markBlockForUpdate(x, y, z);
        }
        return null;
    }
}