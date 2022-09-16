package net.zephira.pogtweaks.item;

import java.util.UUID;

import com.google.common.collect.Multimap;

import dev.emi.stepheightentityattribute.StepHeightEntityAttributeMain;
import dev.emi.trinkets.api.SlotAttributes;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;

public class SashItem extends TrinketItem {

    private String _extraSlot;
    private double _speed;

    public SashItem(Settings settings) {
        this(settings, 0.035, null);
    }

    public SashItem(Settings settings, double speed) {
        this(settings, speed, null);
    }

    public SashItem(Settings settings, double speed, String extraSlot){
        super(settings);
        this._speed = speed;
        this._extraSlot = extraSlot;
    }

    
    public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers (ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
        var modifiers = super.getModifiers(stack, slot, entity, uuid);
        // +1 step height
        modifiers.put(StepHeightEntityAttributeMain.STEP_HEIGHT, new EntityAttributeModifier(uuid, "pogtweaks:step_height", 0.65, EntityAttributeModifier.Operation.ADDITION));
        // +  movement speed
        modifiers.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier(uuid, "guidemod:movement_speed", _speed, EntityAttributeModifier.Operation.ADDITION ));
    
        // If the player has access to belt slots, this will give them an extra one
        if (_extraSlot != null){
            //for (String newSlot : _extraSlot) { ---- NO LONGER STRING LIST
                SlotAttributes.addSlotModifier(modifiers, _extraSlot, uuid, 1,     EntityAttributeModifier.Operation.ADDITION);
            //}
        }
        return modifiers;
    }
}
