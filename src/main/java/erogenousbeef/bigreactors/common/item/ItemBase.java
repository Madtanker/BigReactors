package erogenousbeef.bigreactors.common.item;

import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import erogenousbeef.bigreactors.common.BigReactors;

public class ItemBase extends Item {
	// TODO textures
	//protected IIcon[] icons;

	public ItemBase(String name)
	{
		super();
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(BigReactors.TAB);
		// TODO textures
		//icons = new IIcon[getNumberOfSubItems()];
	}

	protected int getNumberOfSubItems() {
		return 0;
	}
	
	protected String[] getSubItemNames() {
		return null;
	}

	// TODO textures
	/*
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		String[] subItemNames = getSubItemNames();
		if(subItemNames != null) {
			for(int i = 0; i < subItemNames.length; i++) {
				icons[i] = iconRegister.registerIcon(BigReactors.TEXTURE_NAME_PREFIX + subItemNames[i]);
			}
		}
		else
		{
			this.itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().replace("item.", BigReactors.TEXTURE_NAME_PREFIX));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int damage)
	{
		if(icons.length > damage && !this.isDamageable()) {
			return icons[damage];
		}

		return super.getIconFromDamage(damage);
	}
	*/

	@Override
	public int getMetadata(int metadata) {
		return metadata;
	}
}
