package me.superhb.mobdrops.content;

import me.superhb.mobdrops.Refrence;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class MDArmor extends ItemArmor {
	public MDArmor (ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
	}

	@Override
	public String getArmorTexture (ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
		if (stack.getItem() == MDItems.creeperViewHelmet)
			return Refrence.MODID + ":textures/models/armor/creeper_view.png";
		else if (stack.getItem() == MDItems.creeperHelmet || stack.getItem() == MDItems.creeperChestplate || stack.getItem() == MDItems.creeperBoots)
			return Refrence.MODID + ":textures/models/armor/creeper_1.png";
		else if (stack.getItem() == MDItems.creeperLeggings)
			return Refrence.MODID + ":textures/models/armor/creeper_2.png";
		else if (stack.getItem() == MDItems.wolfHelmet || stack.getItem() == MDItems.wolfChestplate || stack.getItem() == MDItems.wolfBoots)
			return Refrence.MODID + ":textures/models/armor/wolf_1.png";
		else if (stack.getItem() == MDItems.wolfLeggings)
			return Refrence.MODID + ":textures/models/armor/wolf_2.png";
		else if (stack.getItem() == MDItems.ocelotHelmet || stack.getItem() == MDItems.ocelotChestplate || stack.getItem() == MDItems.ocelotBoots)
			return Refrence.MODID + ":textures/models/armor/ender_1.png";
		else if (stack.getItem() == MDItems.ocelotLeggings)
			return Refrence.MODID + ":textures/models/armor/ender_2.png";
		else if (stack.getItem() == MDItems.mooHelmet || stack.getItem() == MDItems.mooChestplate || stack.getItem() == MDItems.mooBoots)
			return Refrence.MODID + ":textures/models/armor/moo_1.png";
		else if (stack.getItem() == MDItems.mooLeggings)
			return Refrence.MODID + ":textures/models/armor/moo_2.png";
		else if (stack.getItem() == MDItems.enderHelmet || stack.getItem() == MDItems.enderChestplate || stack.getItem() == MDItems.enderBoots)
			return Refrence.MODID + ":textures/models/armor/ender_1.png";
		else if (stack.getItem() == MDItems.enderLeggings)
			return Refrence.MODID + ":textures/models/armor/ender_2.png";
		else if (stack.getItem() == MDItems.blazeHelmet || stack.getItem() == MDItems.blazeChestplate || stack.getItem() == MDItems.blazeBoots)
			return Refrence.MODID + ":textures/models/armor/blaze_1.png";
		else if (stack.getItem() == MDItems.blazeLeggings)
			return Refrence.MODID + ":textures/models/armor/blaze_2.png";
		else
			return null;
	}
	
	@Override
	public void onArmorTick (World world, EntityPlayer player, ItemStack stack) {
		if (player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(0) != null) {
			ItemStack helmet = player.inventory.armorItemInSlot(3);
			ItemStack chestplate = player.inventory.armorItemInSlot(2);
			ItemStack leggings = player.inventory.armorItemInSlot(1);
			ItemStack boots = player.inventory.armorItemInSlot(0);
			
			//if (helmet.getItem() == MDItems.blazeHelmet && chestplate.getItem() == MDItems.blazeChestplate && leggings.getItem() == MDItems.blazeLeggings && boots.getItem() == MDItems.blazeBoots)
				//world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, player.posX, player.posY + 1D, player.posZ, 0.01D, 0.01D, 0.01D, 1);
		}
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (((EntityPlayer) entityIn).inventory.armorItemInSlot(3) != null && ((EntityPlayer) entityIn).inventory.armorItemInSlot(2) != null && ((EntityPlayer) entityIn).inventory.armorItemInSlot(1) != null && ((EntityPlayer) entityIn).inventory.armorItemInSlot(0) != null) {
			ItemStack helmet = ((EntityPlayer) entityIn).inventory.armorItemInSlot(3);
			ItemStack chestplate = ((EntityPlayer) entityIn).inventory.armorItemInSlot(2);
			ItemStack leggings = ((EntityPlayer) entityIn).inventory.armorItemInSlot(1);
			ItemStack boots = ((EntityPlayer) entityIn).inventory.armorItemInSlot(0);
			
			if (helmet.getItem() == MDItems.blazeHelmet && chestplate.getItem() == MDItems.blazeChestplate && leggings.getItem() == MDItems.blazeLeggings && boots.getItem() == MDItems.blazeBoots) {
				if (!helmet.isItemEnchanted() && !chestplate.isItemEnchanted() && !leggings.isItemEnchanted() && !boots.isItemEnchanted()) {
					helmet.addEnchantment(Enchantments.FIRE_PROTECTION, 1);
					chestplate.addEnchantment(Enchantments.FIRE_PROTECTION, 1);
					leggings.addEnchantment(Enchantments.FIRE_PROTECTION, 1);
					boots.addEnchantment(Enchantments.FIRE_PROTECTION, 1);
				}
			}
		} else {
			if (stack.getItem() == MDItems.blazeHelmet || stack.getItem() == MDItems.blazeChestplate || stack.getItem() == MDItems.blazeLeggings || stack.getItem() == MDItems.blazeBoots) {
				if (stack.isItemEnchanted())
					stack.getTagCompound().removeTag("ench");
			}
		}
		
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
	}
}