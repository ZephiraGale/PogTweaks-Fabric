package net.zephira.pogtweaks.item;

import java.util.UUID;

import com.google.common.collect.Multimap;

import dev.emi.trinkets.api.SlotAttributes;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;

public class SashItem extends TrinketItem {

    public SashItem(Settings settings) {
        super(settings);
    }
    
    public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers (ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
        var modifiers = super.getModifiers(stack, slot, entity, uuid);
    // +10% movement speed
    modifiers.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier(uuid, "guidemod:movement_speed", 0.1, EntityAttributeModifier.Operation.ADDITION ));
    // If the player has access to belt slots, this will give them an extra one
    SlotAttributes.addSlotModifier(modifiers, "legs/belt", uuid, 1, EntityAttributeModifier.Operation.ADDITION);
    return modifiers;
        
    }
}
